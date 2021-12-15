package figury;

import java.awt.*;
import java.awt.geom.*;

public class Kolo extends Figura{
    public Kolo(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Ellipse2D.Float(0, 0, 35, 35);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
