package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura{


    public Kwadrat(Graphics2D buffor, int delay, int width, int height){
        super(buffor,delay,width,height,0);
        shape = new Rectangle2D.Double(0,100,20,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
