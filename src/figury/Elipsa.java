package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura{

    public Elipsa(Graphics2D buffor, int delay, int width, int height){
        super(buffor,delay,width,height,1);
        shape = new Ellipse2D.Double(60,60,20,30);
        aft = new AffineTransform();
        area = new Area(shape);
    }

}
