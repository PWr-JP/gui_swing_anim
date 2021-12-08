package figury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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

	void addFig() {
		Random rand = new Random();
		int r = rand.nextInt(3); //losowanie liczby od 0,1,2
		if (r == 0) {Figura fig = new Kwadrat(buffer, delay, getWidth(), getHeight());//jesli r=0 zostanie dodany kwadrat
			timer.addActionListener(fig);
			new Thread(fig).start();}

		if (r == 1) {Figura fig = new Elipsa(buffer, delay, getWidth(), getHeight());//jesli r=1 zostanie dodana elipsa
			timer.addActionListener(fig);
			new Thread(fig).start();}

		if (r == 2) {Figura fig = new Trojkat(buffer, delay, getWidth(), getHeight());//jesli r=2 zostanie dodany trojkat
			timer.addActionListener(fig);
			new Thread(fig).start();}

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
