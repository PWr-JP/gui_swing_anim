package figury;

import java.awt.*;
import java.awt.geom.*;

public class Elipsa extends Figura {


    public Elipsa(Graphics2D buf, int del, int width, int height) {
        super(buf, del, width, height);
        area = new Area(new Ellipse2D.Double(0, 0, 40, 20) {
        });

    }
}
