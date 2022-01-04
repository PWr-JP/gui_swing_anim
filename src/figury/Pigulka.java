package figury;

import java.awt.*;
import java.awt.geom.*;

public class Pigulka extends Figura{
    public Pigulka(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        shape = new RoundRectangle2D.Float(0,0,25,15, 10,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
