package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura {
    public Elipsa(int xPos, int yPos, Color shapeColor, Graphics2D buffer, int delay, int width, int height) {
        super(shapeColor, buffer, delay, width,height);
        shape = new Ellipse2D.Float(xPos,yPos,20,10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
