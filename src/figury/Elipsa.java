package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura{

    public Elipsa(Graphics2D buff, int del, int w, int h) {
        super(buff, del, w, h);
        shape = new Ellipse2D.Float(0,0, 10,5);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
