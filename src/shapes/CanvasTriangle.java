/*
 * Original author : tb
 * Fork: koxx4
 */

package shapes;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;

public class CanvasTriangle extends CanvasFigure{
    public CanvasTriangle(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        Path2D triangle = new Path2D.Double();
        triangle.moveTo(0,0);
        triangle.lineTo(15, 30);
        triangle.lineTo(30, 0);
        triangle.lineTo(0,0);
        triangle.closePath();
        this.setShape(triangle);
        setArea(new Area(getShape()));
    }
}
