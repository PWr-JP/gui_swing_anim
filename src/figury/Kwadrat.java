package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Figura {
    public Kwadrat(int xPos, int yPos, Color shapeColor, Graphics2D buffer, int delay, int width, int height) {
        super(shapeColor,buffer, delay, width, height);
        shape = new Rectangle2D.Float(xPos,yPos,20,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
