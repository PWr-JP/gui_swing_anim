package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static List<Figura> objectList = new ArrayList<>();

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

	void addFig(int s) {
//		Figura fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight())
//				: new Elipsa(buffer, delay, getWidth(), getHeight());
		Figura fig;
		switch (s){
			case 1:{
				fig = new Kwadrat(buffer,delay,getWidth(),getHeight());
				break;
			}
			case 2:{
				fig = new Prostokat(buffer,delay,getWidth(),getHeight());
				break;
			}
			default:{
				fig = new Elipsa(buffer,delay,getWidth(),getHeight());
				break;
			}
		}

		timer.addActionListener(fig);
		new Thread(fig).start();
		objectList.add(fig);
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
			for(Figura f : objectList ){
				f.isRunning=false;
			}
		} else {
			timer.start();
			for(Figura f : objectList ){
				f.isRunning=true;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}
}
