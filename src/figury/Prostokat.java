package figury;

import java.awt.*;
import java.awt.geom.*;

public class Prostokat extends Figura{
    public Prostokat(Graphics2D buf, int del, int w, int h){
        super(buf,del,w,h);
        shape = new Rectangle2D.Float(0,0,50,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
