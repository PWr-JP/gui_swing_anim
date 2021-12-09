package figury;

import java.awt.*;
import java.awt.geom.*;

public class RoundedRect extends Figura{

    public RoundedRect(Graphics2D buffor, int delay, int width, int height){
        super(buffor,delay,width,height,2);
        shape = new RoundRectangle2D.Float(0,100,20,20,15,15);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
