package figury;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Trojkat extends Figura {

	public Trojkat(Graphics2D buf, int del, int w, int h) {
		super(buf, del, w, h);
		Path2D triangle = new Path2D.Double();
        triangle.moveTo(0,0);
        triangle.lineTo(10, 20);
        triangle.lineTo(20, 0);
        triangle.lineTo(0,0);
        triangle.closePath();
		shape = triangle;
		aft = new AffineTransform();
		area = new Area(shape);
	}

}
