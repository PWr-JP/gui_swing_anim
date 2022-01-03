// Dodane: kształt trójkąt

package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura {
    public Trojkat(Graphics2D buf, int del, int w, int h) {
        super(buf,del,w,h);
        shape = new Polygon(new int[]{20,30,20}, new int[]{20,10,5}, 3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
