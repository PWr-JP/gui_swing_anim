package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura {

    public Kwadrat(Graphics2D buffer, int delay, int width, int height, Color color){
        super(buffer,delay,width,height,color);
        shape = new Rectangle2D.Float(0,0,10,10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
