package figury;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Kwadrat extends Figura {
    public Kwadrat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        shape = new Rectangle2D.Float(0, 0, new Random().nextInt(50)+10, new Random().nextInt(50)+10);
        area = new Area(shape);
        aft = new AffineTransform();
    }

}
