package figury;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura {

    public Elipsa(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Ellipse2D.Float(20,20,25,15);
        area = new Area(shape);
        aft = new AffineTransform();
    }
}
