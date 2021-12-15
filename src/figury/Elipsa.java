package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Elipsa extends Figura{


    public Elipsa(Graphics2D buf, int del, int w, int h){
        super(buf, del, w, h);
        int r = 20/((rand.nextInt(10)+10)/5);
        shape = new Ellipse2D.Float(0,0,10, r);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
