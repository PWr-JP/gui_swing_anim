package figury;

import java.awt.*;
import java.awt.geom.*;

public class Trojkat extends Figura {
    public Trojkat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        Polygon trojkat = new Polygon();
        trojkat.addPoint(0, 0);
        trojkat.addPoint(15, 30);
        trojkat.addPoint(30, 0);
        aft = new AffineTransform();
        shape = trojkat;
        area = new Area(shape);
    }

}
