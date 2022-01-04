package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;


public class Trojkat extends Figura{
    public Trojkat(Graphics2D buf, int del, int w, int h){
        super(buf,del,w,h);
        Polygon triangle = new Polygon();
        triangle.addPoint(0,0);
        triangle.addPoint(10,0);
        triangle.addPoint(5,10);
        shape = triangle;
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
