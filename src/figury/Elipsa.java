package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura{

    public Elipsa( Graphics2D buffer, int delay, int width, int height){
        super(buffer, delay, width, height);
        shape = new Ellipse2D.Float(40, 25, 30, 22);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
