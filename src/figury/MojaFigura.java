package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class MojaFigura extends Figura{
    private final double points[][] = {
            {20, 10}, {30, 15}, {20, 20}, {15, 30}, {10, 20}, {0, 15}, {10, 10}
    };

    public MojaFigura(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        GeneralPath ksztalt = new GeneralPath();
        ksztalt.moveTo(15,0);
        for(int i = 0; i < points.length; i++) {
            ksztalt.lineTo(points[i][0], points[i][1]);
        }
        ksztalt.closePath();
        setShape(ksztalt);

        setArea(new Area(getShape()));
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
