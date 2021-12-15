package figury;

import java.awt.*;
import java.awt.geom.*;

public class Kwadrat extends Figura{
    public Kwadrat(Graphics2D buf, int del, int w, int h){
        super(buf, del, w, h);
        shape = new Rectangle2D.Float(0,0,20,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
