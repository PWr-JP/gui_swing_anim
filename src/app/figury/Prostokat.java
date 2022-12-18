package app.figury;

import java.awt.*;
import java.awt.geom.Area;

public class Prostokat extends Figura{
    public Prostokat(Graphics2D buffer, int delay, int width, int heigth) {
        super(buffer, delay, width, heigth);
    }

    @Override
    public void run() {
        // przesuniecie na srodek
        aft.translate(100, 100);
        if(area == null) {
            Rectangle a = new Rectangle(rand.nextInt(100),rand.nextInt(100));
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