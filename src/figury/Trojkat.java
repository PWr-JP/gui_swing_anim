package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura{
    private int[] x = new int[]{11, 18, 29};
    private int[] y = new int[]{25, 4, 8};

    public Trojkat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        shape = new Polygon(x, y, 3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
