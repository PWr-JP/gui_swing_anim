package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Kwadrat extends Figura{
    protected static final Random rand = new Random();

    public Kwadrat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Rectangle2D.Float(rand.nextInt(250), rand.nextInt(100), 10, 10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
