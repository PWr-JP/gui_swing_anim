package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.QuadCurve2D;

public class EnquaddedCurve extends Figura{

    public EnquaddedCurve(Graphics2D buffor, int delay, int width, int height){
        super(buffor,delay,width,height,3);
        shape = new QuadCurve2D.Float(0,100,50,50,0,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
