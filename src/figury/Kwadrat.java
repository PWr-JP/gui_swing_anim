package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura {
    public Kwadrat(Graphics2D buffer, int delay, int width, int heigth){
        super(buffer, delay, width, heigth);
        shape = new Rectangle2D.Double(3,3,30,30);
        aft = new AffineTransform();
        area = new Area(shape);
        //System.out.println("Pojawil sie kwadrat");

    }
}
