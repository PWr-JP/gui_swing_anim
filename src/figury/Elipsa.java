package figury;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;

public class Elipsa extends Figura {
  public Elipsa(Graphics2D buf, int del, int w, int h) {
    super(buf, del, w, h);
    aft = new AffineTransform();
    shape = new Ellipse2D.Float(0, 0, 16, 24);
    area = new Area(shape);
  }
}
