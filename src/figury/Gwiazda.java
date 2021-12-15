package figury;

import java.awt.*;
import java.awt.geom.*;

public class Gwiazda extends Figura {
    public Gwiazda(Graphics2D buf, int del, int width, int height){
        super(buf, del, width, height);
        double radius = 20;
        shape = new Gwiazda_Shape();
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
class Gwiazda_Shape extends Path2D.Double {
    public Gwiazda_Shape() {
        double numRays = 5; // liczba ramion gwiazdy
        double innerRadius = 15;
        double outerRadius = 30;
        double deltaAngleRad = Math.PI / numRays;

        for (int i = 0; i < numRays * 2; i++)
            {
                double angleRad = i * deltaAngleRad;
                double ca = Math.cos(angleRad);
                double sa = Math.sin(angleRad);
                double relX = ca;
                double relY = sa;
                if ((i & 1) == 0)
                {
                    relX *= outerRadius;
                    relY *= outerRadius;
                }
                else
                {
                    relX *= innerRadius;
                    relY *= innerRadius;
                }
                if (i == 0)
                {
                    moveTo(  relX,  relY);
                }
                else
                {
                    lineTo( relX, relY);
                }
            }
           closePath();
        }
    }
