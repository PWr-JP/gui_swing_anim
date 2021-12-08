package figury;

import java.awt.*;
import java.awt.geom.*;

public class Zaokroglony_prostokat extends Figura{
    public Zaokroglony_prostokat(Graphics2D buf, int del, int w, int h ){
        super(buf, del, w ,h);
        shape = new RoundRectangle2D.Float(0,0,30,15,10,10);
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
