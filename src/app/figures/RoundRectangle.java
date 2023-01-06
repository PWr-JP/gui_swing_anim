package app.figures;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundRectangle extends Figure{
    @Override
    public Shape initializeShape() {
        return new RoundRectangle2D.Float(rand.nextInt(100), rand.nextInt(100),
                rand.nextInt(100), rand.nextInt(100),
                rand.nextInt(100), rand.nextInt(100));
    }
}
