package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Elipsa extends Figura{

    public Elipsa(Graphics2D buff, int del, int w, int h){
        super(buff, del, w, h);
        Random random = new Random();
        shape = new Ellipse2D.Float(0,0,random.nextInt(20)+5,random.nextInt(10)+5);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}