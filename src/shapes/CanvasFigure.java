
/*
 * Original author : tb
 * Fork: koxx4
 */

package shapes;

import java.awt.Color;
import java.awt.Graphics2D;


import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

public abstract class CanvasFigure implements ActionListener {

	private final Graphics2D sharedBuffer;
	private Area area;
	private Shape shape;
	private AffineTransform affineTransform;

	// przesuniecie
	private int dx, dy;
	// rozciaganie
	private double sf;
	// kat obrotu
	private double an;
	private int delay;
	private int width;
	private int height;
	private Color color;

	protected static final Random rand = new Random();

	public CanvasFigure(Graphics2D buf, int del, int w, int h) {
		delay = del;
		sharedBuffer = buf;
		width = w;
		height = h;

		dx = 1 + rand.nextInt(5);
		dy = 1 + rand.nextInt(5);
		sf = 1 + 0.05 * rand.nextDouble();
		an = 0.5 * rand.nextDouble();

		color = new Color(rand.nextInt(255), rand.nextInt(255),
				rand.nextInt(255), rand.nextInt(255));
		affineTransform = sharedBuffer.getTransform();
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void setAffineTransform(AffineTransform affineTransform) {
		this.affineTransform = affineTransform;
	}

	public Shape getShape() {
		return shape;
	}

	public Graphics2D getSharedBuffer() {
		return sharedBuffer;
	}

	public Area getArea() {
		return area;
	}

	public AffineTransform getAffineTransform() {
		return affineTransform;
	}

	public void run() {
		// przesuniecie na srodek
		affineTransform.translate(20, 20);
		area.transform(affineTransform);
	}

	protected void nextFrame() {
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

		//affineTransform.translate(cx, cy);
		//affineTransform.scale(sf, sf);
		area.transform(AffineTransform.getRotateInstance(an, cx, cy));
		//affineTransform.translate(-cx, -cy);
		area.transform(AffineTransform.getTranslateInstance(dx, dy));
		// przeksztalcenie obiektu
		//area.transform(affineT);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		nextFrame();
		sharedBuffer.setColor(color.brighter());
		sharedBuffer.fill(area);
		sharedBuffer.setColor(color.darker());
		sharedBuffer.draw(area);
	}

}
