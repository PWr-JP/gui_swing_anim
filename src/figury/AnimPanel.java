package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	static boolean isRunning;
	// bufor
	Image image;
	// wykreslacz ekranowy
	Graphics2D device;
	// wykreslacz bufora
	Graphics2D buffer;

	private int delay = 70;

	public void setDelay(int delay) {
		this.delay = delay;
	}

	private final Timer timer;

	private static int numer = 0;

	public AnimPanel() {
		super();
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

	void addFig() {
		Figura fig;
		switch (numer++ % 3) {
			case 0:
				fig = new Elipsa(buffer, delay, getWidth(), getHeight());
				break;
			case 1:
				fig = new Kwadrat(buffer, delay, getWidth(), getHeight());
				break;
			case 2:
				fig = new ZaokraglonyProstokat(buffer, delay, getWidth(), getHeight());
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + numer++ % 3);
		}
		timer.addActionListener(fig);
		new Thread(fig).start();
	}

	public void resizeWindow(int width, int height) {
		image = createImage(width, height);
		buffer = (Graphics2D) image.getGraphics();
		device = (Graphics2D) getGraphics();
	}

	void animate() {
		if (timer.isRunning()) {
			isRunning = false;
			timer.stop();
		} else {
			isRunning = true;
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}

}