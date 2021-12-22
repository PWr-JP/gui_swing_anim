package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Wielokat extends Figura{

    public Wielokat(Graphics2D buffer, int delay, int width, int height){
        super(buffer, delay, width, height);
        shape = new Polygon( new int[] {2, 12, 0, 14, 7}, new int[] {0, 0, 10, 10, 15}, 5 );
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
