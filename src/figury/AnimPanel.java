package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

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
	Figura figure;

	private int delay = 70;

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

	void addFig(){
		//Figura figure;
		Random random = new Random();
		int determinedFifure = random.nextInt(4);
		if(determinedFifure==0)
			figure = new Kwadrat(buffer,delay,getWidth(),getHeight());
		else if(determinedFifure==1)
			figure = new Elipsa(buffer,delay,getWidth(),getHeight());
		else if(determinedFifure==2)
			figure = new EnquaddedCurve(buffer,delay,getWidth(),getHeight());
		else
			figure = new RoundedRect(buffer,delay,getWidth(),getHeight());
		figure.setPanel(this);
		timer.addActionListener(figure);
		new Thread(figure).start();

	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	public Timer getTimer() {
		return timer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}
}
