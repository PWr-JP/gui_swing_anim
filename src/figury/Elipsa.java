package figury;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Elipsa extends Figura{
    Random random = new Random();
    public Elipsa(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Ellipse2D.Float(0,0,random.nextInt(30),random.nextInt(30));
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
