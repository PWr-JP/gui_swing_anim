package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;



public class Polkolo extends Figura {
    public Polkolo(Graphics2D buf, int del, int w, int h) {
        super(buf,del,w,h);
        shape = new Arc2D.Float(0,0,40,40,0,180,Arc2D.OPEN);
        aft = new AffineTransform();
        area= new Area(shape);
    }
}


