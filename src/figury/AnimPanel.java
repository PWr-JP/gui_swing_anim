package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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

	private Color color;
	private int alpha;

	private boolean isColRandom = true;

	protected static final Random rand = new Random();

	public AnimPanel() {
		super();
		setBackground(Color.WHITE);
		this.color = Color.BLACK;
		this.alpha = 255;
		this.timer = new Timer(delay, this);
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

	void addFig(String shapeType){
		Figura fig;
		switch(shapeType){
			case "ELLIPSE":
				if(isColRandom)
					fig = new Elipsa(buffer, delay, getWidth(), getHeight(),new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
				else
					fig = new Elipsa(buffer, delay, getWidth(), getHeight(), new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
				break;
			case "SQUARE":
				if(isColRandom)
					fig = new Kwadrat(buffer, delay, getWidth(), getHeight(),new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
				else
					fig = new Kwadrat(buffer, delay, getWidth(), getHeight(), new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
			break;
			default:
				if(isColRandom)
					fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight(),new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)))
							: new Elipsa(buffer, delay, getWidth(), getHeight(),new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
				else
					fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight(), new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha))
							: new Elipsa(buffer, delay, getWidth(), getHeight(), new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
				break;
		}
		timer.addActionListener(fig);
		new Thread(fig).start();
		threads.add(fig);
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

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void setColor(Color col){
		this.color = col;
	}

	public void setColRandom(boolean isOn){
		this.isColRandom = isOn;
	}

	public Color getColor() {
		return color;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha){
		this.alpha = alpha;
	}

	public int getDelay(){
		return delay;
	}

	public void killLast(){
		if(!threads.isEmpty()){
			threads.get(threads.size()-1).stop();
			threads.remove(threads.size()-1);
		}
	}

	private ArrayList<Figura> threads = new ArrayList<>();
}
