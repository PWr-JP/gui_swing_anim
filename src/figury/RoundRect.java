package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundRect extends Figura {
    public RoundRect(int xPos, int yPos, Color shapeColor, Graphics2D buffer, int delay, int width, int height) {
        super(shapeColor, buffer, delay, width, height);
        shape = new RoundRectangle2D.Float(xPos,yPos,20,30, 10,30);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
