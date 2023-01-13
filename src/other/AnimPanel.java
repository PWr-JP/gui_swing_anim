package other;

import figury.Elipsa;
import figury.Figura;
import figury.Prostokat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class AnimPanel extends JPanel implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// bufor
	Image image;
	// wykreslacz ekranowy
	Graphics2D device;
	// wykreslacz bufora
	Graphics2D buffer;

	private final int delay = 70;

	private final Timer timer;


	public AnimPanel() {
		super();
		timer = new Timer(delay, this);
		setBackground(Color.WHITE);
	}

	public void initialize() {
		int width = getWidth();
		int height = getHeight();
		System.out.println(width + " " + height);

		image = createImage(width, height);
		buffer = (Graphics2D) image.getGraphics();
		buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		buffer.setBackground(Color.WHITE);
		device = (Graphics2D) getGraphics();
		device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	void addFig(int x) {
		Figura fig = null;
		if (x == 1) {
			if (GetSetHelper.getColor() == null){
				fig = new Prostokat(buffer, delay, getWidth(), getHeight());
			} else fig = new Prostokat(buffer, delay, getWidth(), getHeight(), GetSetHelper.getColor());
		} else if (x == 2){
			if (GetSetHelper.getColor() == null){
				fig = new Elipsa(buffer, delay, getWidth(), getHeight());
			} else fig = new Elipsa(buffer, delay, getWidth(), getHeight(), GetSetHelper.getColor());
		}

		timer.addActionListener(fig);
		new Thread(fig).start();
	}

	void animate() {
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
