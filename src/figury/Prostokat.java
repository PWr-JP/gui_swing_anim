package figury;


import java.awt.*;
import java.awt.geom.*;

public class Prostokat extends Figura {

    public Prostokat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer,delay,width,height);
        shape = new Rectangle2D.Float(0,0,50,10);
        aft = new AffineTransform();
        area = new Area(shape);
    }


}

