/**
 *
 */
package figury;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

/**
 * @author tb
 *
 */
public abstract class Figura implements Runnable, ActionListener/*, Shape*/ {

	// wspolny bufor
	protected Graphics2D buffer;
	protected Area area;
	// do wykreslania
	protected Shape shape;
	// przeksztalcenie obiektu
	protected AffineTransform aft;

	// przesuniecie
	private int dx, dy;
	// rozciaganie
	private double sf;
	// kat obrotu
	private final double an;
	private final int delay;
	private final int width;
	private final int height;
	private final Color clr;
	Timer vTimer;
	int vCounter = 0;
	Timer hTimer;
	int hCounter = 0;
	Timer sTimer;
	int sCounter;


	protected static final Random rand = new Random();

	public Figura(Graphics2D buf, int del, int w, int h) {
		delay = del;
		buffer = buf;
		width = w;
		height = h;

		dx = 1 + rand.nextInt(5);
		dy = 1 + rand.nextInt(5);
		sf = 1 + 0.05 * rand.nextDouble();
		an = 0.1 * rand.nextDouble();

		clr = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		createTimers();
	}

	private void createTimers(){
		// timer do odbijania
		vTimer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (vTimer.isRunning()) {
					vCounter = 0;
				}
			}
		});

		hTimer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (hTimer.isRunning()) {
					hCounter = 0;
				}
			}
		});

		//Timer do zmiany wielkości
		sTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sTimer.isRunning()) {
					sCounter = 0;
					sTimer.stop();
				}
			}
		});

		vTimer.start();
		hTimer.start();
	}

	@Override
	public void run() {
		area.transform(aft);
		shape = area;

		while (true) {
			// przygotowanie nastepnego kadru
			shape = nextFrame();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
			}
		}
	}

	protected Shape nextFrame() {

		// zapamietanie na zmiennej tymczasowej
		// aby nie przeszkadzalo w wykreslaniu
		area = new Area(area);
		aft = new AffineTransform();
		Rectangle bounds = area.getBounds();
		int cx = bounds.x + bounds.width / 2;
		int cy = bounds.y + bounds.height / 2;
		// odbicie
		if (cx < bounds.width/2 || cx > width-bounds.width/2){
			vCounter++;
			if (vCounter < 2)
				dx = -dx;
			else if (vCounter == 2){
				if (cx < 200){
					if (dx < 0)
						dx = -dx;
				} else {
					if (dx > 0)
						dx = -dx;
				}
			}

		}

		if (cy < bounds.height/2 || cy > height-bounds.height/2) {
			hCounter++;
			if (hCounter < 3)
				dy = -dy;
			else if (hCounter == 3) {
				if (cy < 100) {
					if (dy < 0)
						dy = -dy;
				} else {
					if (dy > 0)
						dy = -dy;
				}
			}
		}

		// zwiekszenie lub zmniejszenie
		if ((bounds.height + bounds.width > width/2+height/2 || bounds.width + bounds.height < 20) && sCounter == 0) {
			sCounter++;
			sTimer.start();
			sf = 1 / sf;
		}
		// konstrukcja przeksztalcenia
		aft.translate(cx, cy);
		aft.scale(sf, sf);
		aft.rotate(an);
		aft.translate(-cx, -cy);
		aft.translate(dx, dy);
		// przeksztalcenie obiektu
		area.transform(aft);
		return area;

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// wypelnienie obiektu
		buffer.setColor(clr.brighter());
		buffer.fill(shape);
		// wykreslenie ramki
		buffer.setColor(clr.darker());
		buffer.draw(shape);
	}

}
