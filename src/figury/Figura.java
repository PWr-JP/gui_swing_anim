/**
 * 
 */
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
import java.util.Timer;

/**
 * @author tb
 *
 */
public abstract class Figura implements Runnable, ActionListener {

	// wspolny bufor
	protected Graphics2D buffer;
	protected Area area;
	// do wykreslania
	protected Shape shape;
	// przeksztalcenie obiektu
	protected AffineTransform aft;
	protected int przypadek;

	// przesuniecie
	private int dx, dy;
	// rozciaganie
	private double sf;
	// kat obrotu
	private double an;
	private int delay;
	private int width;
	private int height;
	private Color clr;

	private AnimPanel panel;

	protected static final Random rand = new Random();

	public Figura(Graphics2D buf, int del, int w, int h, int przypadek) { //0 - rect, 1 - elipse, 2 - RoundedRect, 3 - Curve
		delay = del;
		buffer = buf;
		width = w;
		height = h;
		this.przypadek = przypadek;

		dx = 1 + rand.nextInt(5);
		dy = 1 + rand.nextInt(5);
		sf = 1 + 0.05 * rand.nextDouble();
		an = 0.1 * rand.nextDouble();

		clr = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		// reszta musi być zawarta w realizacji klasy Figure
		// (tworzenie figury i przygotowanie transformacji)
	}

	public void setPanel(AnimPanel panel) {
		this.panel = panel;
	}

	@Override
	public void run() {
		// przesuniecie na srodek
		aft.translate(0, 100);
		area.transform(aft);
		shape = area;

		//startujemy animacje tylko kiedy timer okna Kanwy jest aktywny
		while (true) {
			if(Figura.this.panel.getTimer().isRunning()) {
				// przygotowanie nastepnego kadru
				shape = nextFrame(przypadek);
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	protected Shape nextFrame(int przypadek) {
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

		//Rotacje w zaleznosci od ksztaltu
		if(przypadek ==0||przypadek==1)
			aft.rotate(an);
		if(przypadek==3)
			aft.rotate(-an);


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
