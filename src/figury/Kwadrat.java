package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura{

    public Kwadrat(Graphics2D b, int d, int w, int h){
        super(b,d,w,h);
        shape=new Rectangle2D.Float(0,0,10,10);
        aft=new AffineTransform();
        area=new Area(shape);

    }
}
