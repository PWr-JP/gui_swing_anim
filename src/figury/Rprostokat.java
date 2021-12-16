package figury;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Rprostokat extends Figura{
    Random random = new Random();
    public Rprostokat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new RoundRectangle2D.Double(0, 0, random.nextInt(25), random.nextInt(25), 10, 10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}