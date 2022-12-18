package app.figures;
import java.awt.geom.Area;

public class Rectangle extends Figure {
    public Rectangle() {}

    @Override
    public void run() {
        aft.translate(100, 100);
        java.awt.Rectangle a = new java.awt.Rectangle(rand.nextInt(100), rand.nextInt(100));

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