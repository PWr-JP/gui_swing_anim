package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura {
    public Trojkat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        shape = new Polygon(new int[] {20,50,0}, new int[] {0, 50, 50}, 3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}