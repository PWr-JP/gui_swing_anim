package figury;

import java.awt.*;
import java.awt.geom.*;

public class Trojkat extends Figura {
    public Trojkat(Graphics2D buf, int del, int width, int height){
        super(buf, del, width, height);

        shape = new Triangle_Shape(new Point2D.Double(50, 0), new Point2D.Double(100, 100), new Point2D.Double(0, 100));
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
class Triangle_Shape extends Path2D.Double {
    public Triangle_Shape(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}
