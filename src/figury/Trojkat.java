package figury;

import java.awt.*;
import java.awt.geom.*;

public class Trojkat extends Figura{
    public Trojkat(Graphics2D buf, int del, int width, int height){
        super(buf, del, width, height);
        int xcords[] = {50, 100, 0};
        int ycords[] = {0, 100, 100};
        shape = new Polygon(xcords, ycords, 3);
        aft = new AffineTransform();
        area = new Area(shape);
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
