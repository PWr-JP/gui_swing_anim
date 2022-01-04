package figury;

import java.awt.*;
import java.awt.geom.*;

public class Oval extends Figura {
    public Oval(Graphics2D buf, int del, int w, int h) {
        super(buf, del , w, h);
        aft = new AffineTransform();
        shape = new RoundRectangle2D.Float(0,0,20,10,15,10);
        area = new Area(shape);
    }}