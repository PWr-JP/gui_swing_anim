package figury;

import java.awt.*;
import java.awt.geom.*;

public class Barrel extends Figura{
    public Barrel(Graphics2D buffer, int delay, int width, int height) {
        super(buffer,delay,width,height);
        shape=new RoundRectangle2D.Float(0,0,13,20,4,20);
        area=new Area(shape);
        aft=new AffineTransform();

    }
}