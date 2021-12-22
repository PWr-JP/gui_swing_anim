package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura{

    public Kwadrat(Graphics2D buffer, int delay, int width, int height){
        super(buffer, delay, width, height);
        shape = new Rectangle2D.Float(80, 25, 30, 22);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
