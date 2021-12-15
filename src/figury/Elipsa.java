package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Elipsa extends Figura{


    public Elipsa (Graphics2D buf, int delay, int w, int h){
        super(buf,delay,w,h);
        shape = new Ellipse2D.Float(0,0,10,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}