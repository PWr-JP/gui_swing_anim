package figury;


import java.awt.*;
import java.awt.geom.*;

public class Trojkat extends Figura {

    public Trojkat(Graphics2D buffer, int delay, int width, int height) {
        super(buffer,delay,width,height);
        shape = new Polygon
        aft = new AffineTransform();
        area = new Area(shape);
    }


}

