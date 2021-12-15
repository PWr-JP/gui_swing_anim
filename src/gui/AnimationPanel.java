/*
 * Original author : tb
 * Fork: koxx4
 */

package gui;

import shapes.CanvasFigure;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener {

	private Image backBuffer;
	private Graphics2D screenGraphics;
	private Graphics2D bufferGraphics;
	private final Timer timer;
	private static int numer = 0;
	private final int delay = 60;

	public AnimationPanel(int initialWidth, int initialHeight) {
		super();
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(initialWidth, initialHeight));
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				createGraphicsContext(e.getComponent().getWidth(), e.getComponent().getHeight());
			}
		});

		timer = new Timer(delay, this);
	}

	public void addFigure(Class<? extends CanvasFigure> figureClass) {

		CanvasFigure figureToDraw = null;
		try {
			figureToDraw = figureClass.getDeclaredConstructor(Graphics2D.class, int.class, int.class, int.class)
					.newInstance(bufferGraphics, delay, getWidth(), getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}

		timer.addActionListener(figureToDraw);
		new Thread(figureToDraw).start();
	}

	public void toggleAnimation() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	@Override
	public void setSize(int newWidth, int newHeight){
		super.setSize(newWidth, newHeight);
		this.createGraphicsContext(newWidth, newHeight);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		screenGraphics.drawImage(backBuffer, 0, 0, null);
		bufferGraphics.clearRect(0, 0,
				backBuffer.getWidth(null),
				backBuffer.getHeight(null));
	}

	private void applyRenderingHints() {
		bufferGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		screenGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void createGraphicsContext(int width, int height){
		backBuffer = createImage(width, height);
		bufferGraphics = (Graphics2D) backBuffer.getGraphics();
		screenGraphics = (Graphics2D) getGraphics();
		applyRenderingHints();
	}

}
