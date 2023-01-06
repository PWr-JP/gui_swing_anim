package app.figures;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipse extends Figure {
    @Override
    public Shape initializeShape() {
        return new Ellipse2D.Float(rand.nextInt(100), rand.nextInt(100),
                rand.nextInt(100), rand.nextInt(100));
    }
}
