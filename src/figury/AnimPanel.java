package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean paused=true;

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
		/*Figura fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight())
				: new Elipsa(buffer, delay, getWidth(), getHeight());
*/
		numer++;
		Figura fig=getNextFig();

		timer.addActionListener(fig);
		new Thread(fig).start();
	}

	Figura getNextFig() {
		if(numer%4==0){
			return new Elipsa(buffer, delay, getWidth(),getHeight());
		}else if(numer%4==1){
			return new Kwadrat(buffer,delay, getWidth(),getHeight());
		}else if(numer%4==2){
			return new Kolo(buffer, delay, getWidth(),getHeight());
		}else{
			return new Prostokat(buffer, delay,getWidth(),getHeight());
		}
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
			paused=true;
		} else {
			timer.start();
			paused=false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}

	public static boolean isPaused(){
		return paused;
	}
}
