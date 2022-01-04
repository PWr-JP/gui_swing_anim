// Dodane: kształt trójkąt

package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura {
    public Trojkat(Graphics2D buf, int del, int w, int h, int x, int y) {
        super(buf,del,w,h);
        shape = new Polygon(new int[]{x-50,x-96,x-99}, new int[]{y-50,y-50,y-95}, 3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
