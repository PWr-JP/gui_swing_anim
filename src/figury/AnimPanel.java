package figury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;

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
	ArrayList<Figura> figuresList = new ArrayList<Figura>();
	int figuresListSize=-1;
	private int delay = 20;

	private Timer timer;

	public AnimPanel() {
		super();
		timer = new Timer(delay, this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public void initialize() {
		int width = getWidth()+700;
		int height = getHeight()-100;

		image = createImage(width, height);

		buffer = (Graphics2D) image.getGraphics();
		buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		device = (Graphics2D) getGraphics();
		device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	void addSquare(int w, int h) {
		Figura square = new Kwadrat(buffer, delay, w, h);
		timer.addActionListener(square);
		figuresListSize++;
		figuresList.add(square);
		new Thread(square).start();
	}

    void addCircle(int w, int h) {
        Figura circle = new Elipsa(buffer, delay, w, h);
        timer.addActionListener(circle);
		figuresListSize++;
		figuresList.add(circle);
        new Thread(circle).start();
    }

	void addTriangle(int w, int h){
		Figura triangle = new Trojkat(buffer, delay, w,h);
		timer.addActionListener(triangle);
		figuresListSize++;
		figuresList.add(triangle);
		new Thread(triangle).start();
	}

	void addPolygon(int w, int h){
		Figura polygon = new Rownoleglobok(buffer, delay, w,h);
		timer.addActionListener(polygon);
		figuresListSize++;
		figuresList.add(polygon);
		new Thread(polygon).start();
	}

	void stopFigure(){

		figuresList.get(figuresListSize).stopProcess();
		figuresListSize--;

	}

	void startFigure(){
		figuresListSize++;
		figuresList.get(figuresListSize).startProcess();

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
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				device.drawImage(image, 0, 0, null);

				buffer.clearRect(0, 0, getWidth(), getHeight()+40);
			}
		});
		//repant();
	}
}
