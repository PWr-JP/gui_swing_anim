package figury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AnimPanel extends JPanel implements ActionListener {

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
	private int R = 191;
	private int G = 168;
	private int B = 229;


	public AnimPanel() {
		super();
		color = new Color(R,G,B);
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
		color = new Color(R,G,B);
		numer++;
		Figura fig = (numer % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight(), color)
				: new Elipsa(buffer, delay, getWidth(), getHeight(), color);
		timer.addActionListener(fig);
		new Thread(fig, 'i'+String.valueOf(numer)).start();
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

	protected void setDelay(int delay)
	{
		this.delay = delay;
	}

	protected void setColor(String color, int value) {
		switch (color) {
			case "red": {this.R = value;break;}
			case "green": {this.G = value;break;}
			case "blue": {this.B = value;break;}
		}
	}
}
