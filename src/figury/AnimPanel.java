package figury;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;



public class AnimPanel extends JPanel implements ActionListener, MouseInputListener {
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

	public int xPos = 0;
	public int yPos = 0;

	public int shapeNum = 0;
	public Color shapeCol = Color.BLUE;
	boolean isCreated = false;

	public AnimPanel() {
		super();

		timer = new Timer(delay, this);
		addMouseListener(this);
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

	void setParameters(int shapeNumber, Color shapeColor) {
		shapeNum = shapeNumber;
		shapeCol = shapeColor;
	}

	void addFig() {
		Figura fig = (shapeNum == 0) ? new Kwadrat(xPos, yPos,shapeCol,buffer, delay, getWidth(), getHeight()) :
		(shapeNum == 1) ? new Elipsa(xPos, yPos,shapeCol,buffer, delay, getWidth(), getHeight()) : new RoundRect(xPos, yPos,shapeCol,buffer, delay, getWidth(), getHeight());
		timer.addActionListener(fig);
		new Thread(fig).start();
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}
	}

	void changeSpeed(int speedVal) {
		if(isCreated == false)
		delay = (speedVal == 0) ? 140 : (speedVal == 1) ? 70 : 35;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		xPos = e.getX() - 120;
		yPos = e.getY() - 110;
		addFig();
		isCreated = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
