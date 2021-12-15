package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Kolo extends Figura{
    public Kolo(Graphics2D buffer, int delay, int width, int height) {
        super(buffer,delay,width,height);
        shape = new Ellipse2D.Float(0,0,20,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
