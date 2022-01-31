package figury;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Arc extends Kwadrat{

    public Arc(Graphics2D buf, int del, int w, int h){
        super(buf,del,w,h);
        Random rng = new Random();
        shape = new Arc2D.Float(20,20,20,20,20,rng.nextInt(360),Arc2D.PIE);
        aft = new AffineTransform();
        area = new Area(shape);
    }

    @Override
    protected Shape nextFrame() {
        // zapamietanie na zmiennej tymczasowej
        // aby nie przeszkadzalo w wykreslaniu
        area = new Area(area);
        aft = new AffineTransform();
        Rectangle bounds = area.getBounds();
        int cx = bounds.x + bounds.width / 2;
        int cy = bounds.y + bounds.height / 2;
        // odbicie
        if (cx < 0 || cx > width)
            dx = -dx;
        if (cy < 0 || cy > height)
            dy = -dy;
        // zwiekszenie lub zmniejszenie
        if (bounds.height > height / 3 || bounds.height < 10)
            sf = 1 / sf;
        // konstrukcja przeksztalcenia
        aft.translate(cx, cy);
        aft.scale(sf, sf);
        aft.rotate(an);
        aft.translate(-cx, -cy);
        aft.translate(dx, dy);
        // przeksztalcenie obiektu
        area.transform(aft);
        //((Arc2D) shape).setAngleExtent(angle++);
        //angle = angle > 360 ? 0 : angle;
        return area;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}
