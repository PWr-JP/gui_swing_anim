package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.Rectangle;
import java.util.Random;

public class Kwadrat extends Figura{

    public Kwadrat(Graphics2D buff, int del, int w, int h){
        super(buff, del, w, h);
        Random random = new Random();
        int number = random.nextInt(15)+5;
        shape = new Rectangle.Float(0,0,number,number);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}