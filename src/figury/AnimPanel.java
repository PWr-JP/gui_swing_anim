package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		setFocusable(true);
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

	void addFig(int numer) {
		switch (numer){
			case 0:
				Figura fig = new Kwadrat(buffer,delay,getWidth(),getHeight());
				numer++;
				timer.addActionListener(fig);
				new Thread(fig).start();
				break;
			case 1:
				Figura fig1 = new Elipsa(buffer, delay, getWidth(), getHeight());
				numer++;
				timer.addActionListener(fig1);
				new Thread(fig1).start();
				break;
			case 2:
				Figura fig2 = new Prostokat(buffer,delay,getWidth(),getHeight());
				numer=0;
				timer.addActionListener(fig2);
				new Thread(fig2).start();
				break;
		}
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
