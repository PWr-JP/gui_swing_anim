package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class KwadratKolor extends Figura {
    public KwadratKolor(Graphics2D buffer, int delay, int width, int height, int red, int green, int blue) {
        super(buffer, delay, width, height, red, green, blue);
        aft = new AffineTransform();
        shape = new Rectangle2D.Float(0, 0, 20, 20);
        area = new Area(shape);
    }
}
