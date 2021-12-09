package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Trojkat extends Figura {

    public Trojkat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        Point2D [] points = new Point2D[3];
        points[0] = new Point2D.Float(10,0);
        points[1] = new Point2D.Float(20,20);
        points[2] = new Point2D.Float(0,20);

        shape = new MyTriangle(points);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
