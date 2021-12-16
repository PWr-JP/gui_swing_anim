package figury;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.Polygon;

public class Trojkat extends Figura {

    public Trojkat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Polygon(new int[] {0, 20, 10}, new int[] {0, 0, 20}, 3);
        area = new Area(shape);
        aft = new AffineTransform();
    }
    
}
