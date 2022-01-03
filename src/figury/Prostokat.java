package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Prostokat extends Figura {
    public Prostokat(Graphics2D buff, int del, int w, int h) {
        super(buff, del, w, h);
        shape = new Rectangle2D.Float(0,0,40,10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
