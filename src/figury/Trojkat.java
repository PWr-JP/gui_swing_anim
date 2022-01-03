package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Trojkat extends Figura {
    /**
     * @param buf
     * @param del
     * @param w
     * @param h
     */
    public Trojkat (Graphics2D buf,int del,int w, int h){
        super(buf,del,w,h);
        shape=new Polygon(new int []{5,10,0},new int []{0,10,10},3);
        aft=new AffineTransform();
        area=new Area(shape);
    }
}
