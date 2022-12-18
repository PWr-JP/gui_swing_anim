package app.figury;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Elipsa extends Figura{
    public Elipsa(Graphics2D buffer, int delay, int width, int height) {
        super(buffer, delay, width, height);
    }

    @Override
    public void run() {
        // przesuniecie na srodek
        aft.translate(100, 100);
        if(area == null) {
            Ellipse2D.Float a = new Ellipse2D.Float(rand.nextInt(100),rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
            area = new Area(a);
        }
        area.transform(aft);
        shape = area;

        while (true) {
            // przygotowanie nastepnego kadru
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }
}
