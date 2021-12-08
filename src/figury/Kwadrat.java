package figury;

import java.awt.*;
import java.awt.geom.*;

public class Kwadrat extends Figura {


    public Kwadrat(Graphics2D buf, int del, int width, int height) {
        super(buf, del, width, height);
        area = new Area(new Rectangle(20, 20));

    }
}
