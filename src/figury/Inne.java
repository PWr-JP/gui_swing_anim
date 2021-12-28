package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class Inne extends Figura {
    public Inne(Graphics2D buffer, int delay, int width, int height) {
        super(buffer,delay,width,height);
        shape=new RoundRectangle2D.Double(0,0,20,40,20,15);
        aft=new AffineTransform();
        area=new Area(shape);
    }
}
