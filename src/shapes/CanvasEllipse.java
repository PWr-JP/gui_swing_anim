package shapes;

import java.awt.*;
import java.awt.geom.*;

public class CanvasEllipse extends CanvasFigure {

    public CanvasEllipse(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
        setShape(new Ellipse2D.Double(10,10, 30, 30));
        setArea(new Area(getShape()));
    }

}
