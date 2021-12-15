package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class ZaokraglonyProstokat extends Figura{
    public ZaokraglonyProstokat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new RoundRectangle2D.Float();
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
