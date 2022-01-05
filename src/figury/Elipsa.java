package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura {
    public Elipsa (Graphics2D buffer, int delay, int width, int heigth){
        super(buffer, delay, width, heigth);
        shape = new Ellipse2D.Double(rand.nextInt(400)-100,rand.nextInt(200)-100,rand.nextInt(100),rand.nextInt(100));
        aft = new AffineTransform();
        area = new Area(shape);

    }
}