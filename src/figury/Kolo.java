package figury;

import java.awt.*;
import java.awt.geom.*;

public class Kolo extends Figura{
    public Kolo(Graphics2D buf,int del,int w,int h){
        super(buf,del,w,h);
        shape = new Ellipse2D.Float(0,0,20,20);
        aft = new AffineTransform();
        area = new Area(shape);
    }
    @Override
    public void run() {
        super.run();
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
