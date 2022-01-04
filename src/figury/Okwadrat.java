package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;


public class Okwadrat extends Figura {
    public Okwadrat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new RoundRectangle2D.Float(0, 0, 30, 30, 10, 10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}