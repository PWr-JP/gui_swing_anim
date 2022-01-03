package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

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
		setBackground(Color.WHITE); // zrobic cos z tłem
		timer = new Timer(delay, this); //wystartowanie timera swingowego
	}

	public void initialize() {
		int width = getWidth();   //
		int height = getHeight();// aby obraz mial takie same rozmiary co kanwa na ktorej rysujeemy

		image = createImage(width, height); // na tym rysujemy
		buffer = (Graphics2D) image.getGraphics(); //graphics to narzedzia za pomoca których rysujemy, buffer okreslia narzedzia
		buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //antyaliasing zeby krawedzie lepiej wygladały
		buffer.setColor(Color.WHITE);
		device = (Graphics2D) getGraphics(); // narzedzia do rysowania po ekranie, ale my nie rysujemyy po ekranie, tylko rzutujemyna ekran
		device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	void addFig() {
		Figura fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight())
				: new Elipsa(buffer, delay, getWidth(), getHeight());
		timer.addActionListener(fig);
		new Thread(fig).start(); // start nowego watku
		//System.out.println("dodano figure");
	}

	void addSoul() {
		Soul fig = new Soul(buffer, delay, getWidth(), getHeight());
		timer.addActionListener(fig);
		new Thread(fig).start(); // start nowego watku
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // wydarzy sie gdy przyjdzie takt zegara
		//System.out.println("takt zegara");
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());//czyscimy buffor - znika kolor tła
		buffer.setBackground(Color.white);
		//rysowanie powinno odbywać sie asynchronicznie - gdy nie resetujemy bufora, w odstepach miedzy taktami zegara
	}
}
