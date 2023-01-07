package app;

import app.figures.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static final HashMap<Figure, Thread> figureThreadHashMap= new HashMap<>();
	// bufor
	private Image image;
	// wykreslacz ekranowy
	private Graphics2D device;
	// wykreslacz bufora
	private Graphics2D buffer;

	private final int delay = 70;

	private Timer timer;

	public AnimPanel() {
		super();
		setBackground(Color.WHITE);
		timer = new Timer(delay, this);
	}

	public void initialize() {
		int width = getWidth();
		int height = getHeight();

		image = createImage(width, height);
		buffer = (Graphics2D) image.getGraphics();
		buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		device = (Graphics2D) getGraphics();
		device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void addFig(Figure figure) {
		figure.initializeParameters(this.buffer, this.delay, this.getWidth(), this.getHeight(), this);

		timer.addActionListener(figure);
		Thread thread = new Thread(figure);
		thread.start();

		figureThreadHashMap.put(figure, thread);
	}

	public void deleteFig(Figure figure) {
		timer.removeActionListener(figure);
		Thread thread = figureThreadHashMap.get(figure);
		thread.stop();
		figureThreadHashMap.remove(figure, thread);

		this.repaint();
	}

	 public void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}
}
