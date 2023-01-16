package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Prostokat extends Figura{
    public Prostokat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        aft = new AffineTransform();
        area = new Area(new Rectangle(rand.nextInt(100),rand.nextInt(100),
                rand.nextInt(w/3)+10,rand.nextInt(h/2)+10));
    }

    public Prostokat(Graphics2D buf, int del, int w, int h, Color c) {
        super(buf, del, w, h, c);
        aft = new AffineTransform();
        area = new Area(new Rectangle(rand.nextInt(100),rand.nextInt(100),
                rand.nextInt(w/3)+10,rand.nextInt(h/2)+10));
    }
}
