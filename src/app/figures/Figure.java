/**
 * 
 */
package app.figures;

import app.ColorHolder;
import app.PanelHolder;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

public abstract class Figure implements Runnable, ActionListener/*, Shape*/ {

	// wspolny bufor
	protected Graphics2D buffer;
	protected Area area;
	// do wykreslania
	protected Shape shape;
	// przeksztalcenie obiektu
	protected AffineTransform aft;

	private final int bounceLimit = 3;
	private int timesBounced = 0;
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

	public Figure() {}

	public void setColor(Color color) {
		this.color = color;
	}

	public Graphics2D getBuffer() {
		return buffer;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public void initializeParameters() {
		dx = 1 + rand.nextInt(5);
		dy = 1 + rand.nextInt(5);
		streching = 1 + 0.05 * rand.nextDouble();
		rotateAngle = 0.1 * rand.nextDouble();

		aft = new AffineTransform(1,0,0,1,0,0);

		color = ColorHolder.color;
	}

	public void setBuffer(Graphics2D buffer) { this.buffer = buffer; }
	public void setDelay(int delay) { this.delay = delay; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }

	public Shape initializeShape() {
		return null;
	}

	@Override
	public void run() {
		aft.translate(100, 100);
		Shape a = initializeShape();

		area = new Area(a);
		area.transform(aft);
		shape = area;

		while (true) {
			shape = nextFrame();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
			}
		}
	}

	private Shape nextFrame() {
		area = new Area(area);
		aft = new AffineTransform();
		Rectangle bounds = area.getBounds();
		int cx = bounds.x + bounds.width / 2;
		int cy = bounds.y + bounds.height / 2;

		boolean isBouncedHorizontally = (cx < 0 || cx > width);
		boolean isBouncedVertically = (cy < 0 || cy > height);

		if (isBouncedHorizontally) {
			dx = -dx;
			timesBounced++;
		}
		if (isBouncedVertically) {
			dy = -dy;
			timesBounced++;
		}
		if (timesBounced >= bounceLimit)
			PanelHolder.getPanel().deleteFig(this, shape);

		if (isBouncedHorizontally || isBouncedVertically) {
			int red = this.color.getRed();
			int green = this.color.getGreen();
			int blue = this.color.getBlue();
			this.color = new Color(255 - red, 255 - green, 255 - blue);
		}

		if (bounds.height > height / 3 || bounds.height < 10)
			streching = 1 / streching;

		aft.translate(cx, cy);
		aft.scale(streching, streching);
		aft.rotate(rotateAngle);
		aft.translate(-cx, -cy);
		aft.translate(dx, dy);

		area.transform(aft);

		return area;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		buffer.setColor(color.brighter());
		buffer.fill(shape);

		buffer.setColor(color.darker());
		buffer.draw(shape);
	}
}