package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Jajko extends Figura{
    public Jajko(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape=new Ellipse2D.Float(0,0, 5,10);
        aft=new AffineTransform();
        area=new Area(shape);
    }
}
