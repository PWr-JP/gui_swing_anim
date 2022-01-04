// Dodane: kształt elipsa

package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura {
    public Elipsa(Graphics2D buf, int del, int w, int h, int x, int y) {
        super(buf,del,w,h);
        shape = new Ellipse2D.Float(x-105,y-105,30,15);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
