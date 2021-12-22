package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ZaokraglonyProstokat extends Figura{
    public ZaokraglonyProstokat(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        area = new Area(new RoundRectangle2D.Double(0, 0, 100,50,10,10));
        aft = new AffineTransform();
    }
}
