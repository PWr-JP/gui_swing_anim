package figury;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Kwadrat extends Figura{
    Random random = new Random();
    public Kwadrat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        int bok = random.nextInt(30);
        shape = new Rectangle2D.Float(0,0, bok, bok);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}