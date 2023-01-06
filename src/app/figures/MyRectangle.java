package app.figures;

import java.awt.*;

public class MyRectangle extends Figure {
    @Override
    public Shape initializeShape() {
        return new Rectangle(rand.nextInt(100), rand.nextInt(100));
    }
}