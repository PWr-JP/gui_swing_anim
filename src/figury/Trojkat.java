package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura{

    private int[] xCoordinate = new int[]{20, 40,60};
    private int[] yCoordinate = new int[]{60, 20,40};

    public Trojkat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Polygon(xCoordinate,yCoordinate,3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
