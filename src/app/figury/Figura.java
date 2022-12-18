/**
 * 
 */
package app.figury;

import app.FigureParameters;

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
	protected int dx, dy;
	// rozciaganie
	protected double streching;
	// kat obrotu
	protected double rotateAngle;
	protected int delay;
	protected int width;
	protected int height;
	protected Color color;

	protected static final Random rand = new Random();

	public Figura(Graphics2D buffer, int delay, int width, int height) {
		this.delay = delay;
		this.buffer = buffer;
		this.width = width;
		this.height = height;

		dx = 1 + rand.nextInt(5);
		dy = 1 + rand.nextInt(5);
		streching = 1 + 0.05 * rand.nextDouble();
		rotateAngle = 0.1 * rand.nextDouble();

		aft = new AffineTransform(1,0,0,1,0,0);

		color = FigureParameters.color;
		// reszta musi być zawarta w realizacji klasy Figure
		// (tworzenie app.figury i przygotowanie transformacji)

	}

	@Override
	public void run() {
		// przesuniecie na srodek
		aft.translate(100, 100);
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
		if (cx < 0 || cx > width)
			dx = -dx;
		if (cy < 0 || cy > height)
			dy = -dy;
		// zwiekszenie lub zmniejszenie
		if (bounds.height > height / 3 || bounds.height < 10)
			streching = 1 / streching;
		// konstrukcja przeksztalcenia
		aft.translate(cx, cy);
		aft.scale(streching, streching);
		aft.rotate(rotateAngle);
		aft.translate(-cx, -cy);
		aft.translate(dx, dy);
		// przeksztalcenie obiektu
		area.transform(aft);
		return area;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// wypelnienie obiektu
		buffer.setColor(color.brighter());
		buffer.fill(shape);
		// wykreslenie ramki
		buffer.setColor(color.darker());
		buffer.draw(shape);
	}

}
