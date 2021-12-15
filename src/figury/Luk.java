package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.util.Random;

public class Luk extends Figura {

    public Luk(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Arc2D.Float(0, 0, 20 , 20, 0, new Random().nextInt(180)+45,Arc2D.PIE);
        area = new Area(shape);
        aft = new AffineTransform();
    }
}
