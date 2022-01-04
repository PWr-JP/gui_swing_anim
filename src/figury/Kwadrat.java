package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura {
    public Kwadrat(Graphics2D buf, int del, int w, int h) {
        super(buf, del , w, h);
        aft = new AffineTransform();
        shape = new Rectangle2D.Float(0,0,20,20);
        area = new Area(shape);
    }
}
