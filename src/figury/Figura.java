package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

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
	private final Color color;

	protected static final Random rand = new Random();

	public Figura(Graphics2D buf, int del, int w, int h, Color c) {
		delay = del;
		buffer = buf;
		width = w;
		height = h;
		color = c;

		dx = 1 + rand.nextInt(5);
		dy = 1 + rand.nextInt(5);
		sf = 1 + 0.05 * rand.nextDouble();
		an = 0.1 * rand.nextDouble();;

		// reszta musi być zawarta w realizacji klasy Figure
		// (tworzenie figury i przygotowanie transformacji)
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
			sf = 1 / sf;
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
		buffer.setColor(color.brighter());
		buffer.fill(shape);
		// wykreslenie ramki
		buffer.setColor(color.darker());
		buffer.draw(shape);
	}
}
