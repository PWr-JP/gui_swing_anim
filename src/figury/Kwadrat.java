package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;


public class Kwadrat extends Figura{
    public Kwadrat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Rectangle.Float(0,0,20,10);
        aft = new AffineTransform();
        area = new Area(shape);

    }
}