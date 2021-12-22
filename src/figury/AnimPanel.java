package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class AnimPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// bufor
	private Image image;
	// wykreslacz ekranowy
	private Graphics2D device;
	// wykreslacz bufora
	private Graphics2D buffer;

	private int delay = 70;

	private Timer timer;

	private static int numer = 0;

	private List<Figura> figures = new ArrayList<>();

	public AnimPanel() {
		super();
		setBackground(UIManager.getColor("Panel.background"));
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
		numer++;
		if(numer%2 == 0){fig = new Kwadrat(buffer,delay,getWidth(),getHeight());}
		else if(numer%3 == 0){fig = new RoundedSquare(buffer,delay,getWidth(),getHeight());}
		else{fig = new Elipsa(buffer,delay,getWidth(),getHeight());}
		timer.addActionListener(fig);
		figures.add(fig);
		new Thread(fig).start();
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
			stopAnimation();
		} else {
			timer.start();
			startAnimation();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}

	private void stopAnimation(){
		for(Figura fig: figures){
			fig.setRunning(false);
		}
	}

	private void startAnimation(){
		for(Figura fig: figures){
			fig.setRunning(true);
		}
	}

	public void accelerateAnimation(){
		for(Figura fig: figures){
			if(fig.getDelay()-5 >= 0)
			fig.setDelay(fig.getDelay()-5);
		}
	}

	public void slowAnimation(){
		for(Figura fig: figures){

			fig.setDelay(fig.getDelay()+5);
		}
	}

	public void blinking(){
		for(Figura fig: figures){

			if(fig.isBlinking()){
				fig.setBlinking(false);
			}else{
				fig.setBlinking(true);
			}
		}
	}
}
