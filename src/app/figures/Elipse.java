package app.figures;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipse extends Figure {
    public Elipse() {}

    @Override
    public void run() {
        aft.translate(100, 100);
        if(area == null) {
            Ellipse2D.Float a = new Ellipse2D.Float(rand.nextInt(100),rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
            area = new Area(a);
        }
        area.transform(aft);
        shape = area;

        while (true) {
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }
}
