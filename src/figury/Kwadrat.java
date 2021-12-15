package figury;

import java.awt.*;
import java.awt.geom.*;

public class Kwadrat extends Figura {
    public Kwadrat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        shape = new Rectangle2D.Float(0, 0, 20, 20);
        area = new Area(shape);
        aft = new AffineTransform();
    }

}
