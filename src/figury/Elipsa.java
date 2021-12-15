package figury;

import java.awt.*;
import java.awt.geom.*;

public class Elipsa extends Figura {
    public Elipsa(Graphics2D buf, int del, int width, int height){
        super(buf, del, width, height);
        shape = new Ellipse2D.Float(0,0,20,17);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
