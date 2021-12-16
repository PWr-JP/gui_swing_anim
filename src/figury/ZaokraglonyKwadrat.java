package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import java.awt.geom.RoundRectangle2D;

public class ZaokraglonyKwadrat extends Figura{
    public ZaokraglonyKwadrat(Graphics2D buffer, int delay, int w, int h) {
        super(buffer, delay, w, h);
        shape = new RoundRectangle2D.Float(0, 0, 20, 10, 10, 10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
