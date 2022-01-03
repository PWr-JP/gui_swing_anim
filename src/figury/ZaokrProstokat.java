package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class ZaokrProstokat extends Figura {
    public ZaokrProstokat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new RoundRectangle2D.Float(0, 0, 10, 10, 5, 5);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}