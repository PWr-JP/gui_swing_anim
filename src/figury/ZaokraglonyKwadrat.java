package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class ZaokraglonyKwadrat extends Figura{

    public ZaokraglonyKwadrat(Graphics2D buff, int del, int w, int h){
        super(buff, del, w, h);
        Random random = new Random();
        int number = random.nextInt(15)+5;
        shape = new RoundRectangle2D.Float(0,0,random.nextInt(5)+15,random.nextInt(5)+15,random.nextInt(5)+10,random.nextInt(5)+10);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}