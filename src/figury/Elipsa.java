package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Elipsa extends Figura {
    public Elipsa (Graphics2D buffer, int delay, int width, int heigth){
        super(buffer, delay, width, heigth);
        shape = new Ellipse2D.Double(10,10,10,15);
        aft = new AffineTransform();
        area = new Area(shape);

    }
}
