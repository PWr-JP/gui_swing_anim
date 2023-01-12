package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;


public class Elipsa extends Figura{
    public Elipsa(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        aft = new AffineTransform();
        area = new Area(new Ellipse2D.Float(rand.nextInt(100),rand.nextInt(100),
                rand.nextInt(w/3)+10,rand.nextInt(h/2)+10));
    }
}
