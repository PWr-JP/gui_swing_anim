package figury;

import java.awt.*;
import java.awt.geom.*;

public class zaokrProstokad extends Figura{

    public zaokrProstokad(Graphics2D b, int d, int w, int h){
        super(b,d,w,h);
        shape=new RoundRectangle2D.Float(0,0,20,10,5,8);
        aft=new AffineTransform();
        area=new Area(shape);
    }
}
