package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import java.awt.geom.RoundRectangle2D;

public class OkraglyProstokat extends Figura{

    public OkraglyProstokat(Graphics2D buffer, int delay, int width, int height){
        super(buffer, delay, width, height);
        shape = new RoundRectangle2D.Double(0,0 ,40, 20, 5, 5);
        aft = new AffineTransform();
        area = new Area(shape);
    }

}
