package figury;

import java.awt.*;
import java.awt.geom.*;

public class Kwadrat extends Figura {
    public Kwadrat(Graphics2D buf, int del, int width, int height) {
        super(buf, del, width, height);
        shape = new Rectangle2D.Float(0, 0, 20, 20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
