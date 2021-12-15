package figury;

import java.awt.*;
import java.awt.geom.*;

public class Wycinek extends Figura{

    public Wycinek(Graphics2D b, int d, int w, int h){
        super(b,d,w,h);
        shape=new Arc2D.Float(0,0,10,10,0,180,Arc2D.PIE);
        aft=new AffineTransform();
        area=new Area(shape);
    }
}
