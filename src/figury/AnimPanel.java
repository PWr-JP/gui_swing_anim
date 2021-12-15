package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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

	private int delay = 60;

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

	void addFig() {
		Figura fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight())
				: new Kolo(buffer, delay, getWidth(), getHeight());
		fig = (numer % 3 == 0) ? new Elipsa(buffer, delay, getWidth(), getHeight()) :
				fig;
		timer.addActionListener(fig);
		new Thread(fig).start();
	}
	void addKolo(){
			Figura figureKo =  new Kolo(buffer, delay, getWidth(), getHeight());
			timer.addActionListener(figureKo);
			new Thread(figureKo).start();
		}

	void addElipsa(){
		Figura figureE =  new Elipsa(buffer, delay, getWidth(), getHeight());
		timer.addActionListener(figureE);
		new Thread(figureE).start();
	}
	void addKwadrat(){
		Figura figureKw =  new Kwadrat(buffer, delay, getWidth(), getHeight());
		timer.addActionListener(figureKw);
		new Thread(figureKw).start();
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
