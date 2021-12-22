package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class RoundedSquare extends Figura{
    public RoundedSquare(Graphics2D buff, int del, int w, int h){
        super(buff,del,w,h);
        shape = new RoundRectangle2D.Float(0,0,10,10,7,7);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
