package app.figures;

import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundRectangle extends Figure{
    public RoundRectangle() {}

    @Override
    public void run() {
        aft.translate(100, 100);
        RoundRectangle2D.Float a = new RoundRectangle2D.Float(rand.nextInt(100), rand.nextInt(100),
                rand.nextInt(100), rand.nextInt(100),
                rand.nextInt(100), rand.nextInt(100));

        area = new Area(a);
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
