package figury;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class MyTriangle extends Path2D.Float {

    public MyTriangle(Point2D[] points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}
