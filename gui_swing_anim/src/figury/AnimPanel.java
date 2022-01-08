package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import static figury.AnimatorApp.toStart;

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
	private static int numer3=0;

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
		if(numer3++ % 3==0){
			//Figura fig = new Triangle(buffer, delay, getWidth(), getHeight()); jeszcze nie ma klasy Triangle
		}else{
			Figura fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight())
					: new Elipsa(buffer, delay, getWidth(), getHeight());
			timer.addActionListener(fig);
			new Thread(fig).start();
		}
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	void LowFPS(){
		if(toStart) {
			timer.setDelay(500);
		}else{
			timer.setDelay(delay);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buffer.setBackground(Color.WHITE);
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}
}
