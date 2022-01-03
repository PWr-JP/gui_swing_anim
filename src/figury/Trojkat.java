package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura{
    private int[] x = new int[]{10,20,30};
    private int[] y = new int[]{30,5,10};

    public Trojkat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Polygon(x, y, 3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
