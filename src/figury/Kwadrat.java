package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura{

    public Kwadrat(Graphics2D buf, int del, int w, int h){
        super(buf, del, w, h);
        int r = 20/((rand.nextInt(10)+10)/5);
        shape = new Rectangle2D.Float(0,0,10,r);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
