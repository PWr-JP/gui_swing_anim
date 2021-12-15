package figury;

import java.awt.*;
import java.awt.geom.*;

public class Elipsa extends Figura{
    public Elipsa(Graphics2D buf, int del, int w, int h){
        super(buf, del, w, h);
        shape = new Ellipse2D.Float(0, 0, 10, 20);
        aft = new AffineTransform();
        area = new Area(shape);
    }

}
