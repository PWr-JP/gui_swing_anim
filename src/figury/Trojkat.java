package figury;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.Polygon;
import java.util.Random;

public class Trojkat extends Figura {

    public Trojkat(Graphics2D buf, int del, int w, int h){
        super(buf, del, w, h);
        Random random = new Random();
        shape = new Polygon(new int[] {0, random.nextInt(30)+10, random.nextInt(5)+5}, new int[] {0, 0, random.nextInt(15)+5}, 3);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}