package app.figures;

import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundRectangle extends Figure{
    @Override
    public void run() {
        aft.translate(100, 100);
        if(area == null) {
            RoundRectangle2D.Double a = new RoundRectangle2D.Double(rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100),
                    rand.nextInt(100), rand.nextInt(100));
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
