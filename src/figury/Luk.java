package figury;

import java.awt.*;
import java.awt.geom.*;

public class Luk extends Figura{
    public Luk(Graphics2D buf, int del, int w, int h){
        super(buf,del,w,h);
        shape = new Arc2D.Float(0, 0, 110, 90, 90,135, Arc2D.PIE);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
