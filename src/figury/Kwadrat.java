package figury;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;

public class Kwadrat extends Figura {
    public Kwadrat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        aft = new AffineTransform();
        shape = new Rectangle2D.Float(0, 0, 20, 20);
        area = new Area(shape);
    }
}
