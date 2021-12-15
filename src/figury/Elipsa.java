package figury;


import java.awt.*;
import java.awt.geom.*;

public class Elipsa extends Figura{

    public Elipsa(Graphics2D buffor,int delay, int width, int height){
    super(buffor,delay,width,height);
    shape = new Ellipse2D.Float(0,0,20,10);
    aft = new AffineTransform();
    area = new Area(shape);
    }

}