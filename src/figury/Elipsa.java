package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura{

    public Elipsa(Graphics2D buffer, int delay, int width, int height, Color color){
        super(buffer,delay,width,height,color);
        shape = new Ellipse2D.Float(0,0,10,8);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
