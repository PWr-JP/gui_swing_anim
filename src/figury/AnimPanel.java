package figury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Image image; // bufor
	private Graphics2D device; // wykreslacz ekranowy
	private Graphics2D buffer; // wykreslacz bufora
	private int delay = 25;
	private Timer timer;
	private static int numer = 0;

	public AnimPanel(int width, int height) {
		super();
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(width, height));
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

	public void addFig() {
		Figura fig;
		if(numer % 3 == 0) {
			fig = new Kwadrat(buffer, delay, getWidth(), getHeight());
			timer.addActionListener(fig);
			new Thread(fig).start();
			numer++;
		}
		else if(numer % 3 == 1) {
			fig = new Elipsa(buffer, delay, getWidth(), getHeight());
			timer.addActionListener(fig);
			new Thread(fig).start();
			numer++;
		}
		else if(numer % 3 == 2) {
			fig = new MojaFigura(buffer, delay, getWidth(), getHeight());
			timer.addActionListener(fig);
			new Thread(fig).start();
			numer++;
		}
	}

	public void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	public void changeDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}
}
