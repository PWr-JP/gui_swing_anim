package app;

import app.figures.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	ArrayList<Figure> figures = new ArrayList<>();
	ArrayList<Thread> threads = new ArrayList<>();
	// bufor
	Image image;
	// wykreslacz ekranowy
	Graphics2D device;
	// wykreslacz bufora
	Graphics2D buffer;

	private int delay = 70;

	private Timer timer;

	private static int numer = 0;

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
		figures.add(figure);
		threads.add(thread);
	}

	 void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	public void deleteFig(Figure figure) {
		int index = figures.indexOf(figure);

		timer.removeActionListener(figure);
		threads.get(index).stop();
		threads.remove(index);
		figures.remove(index);

		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}
}
