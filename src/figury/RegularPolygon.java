package figury;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class RegularPolygon extends Figura {

    public RegularPolygon(Graphics2D buf, int del, int w, int h, int numberOfSides) {
        super(buf, del, w, h);
        shape = generateRegularPolygon(numberOfSides, 30);
        area = new Area(shape);
        aft = new AffineTransform();
    }

    private Shape generateRegularPolygon(int numberOfSides, int radius) {
        int[] verticesX = new int[numberOfSides];
        int[] verticesY = new int[numberOfSides];
        float angle = 0f;
        for (int i = 0; i < numberOfSides; i++, angle += 2 * Math.PI / numberOfSides) {
            verticesX[i] = (int) (Math.sin(angle) * radius);
            verticesY[i] = (int) (Math.cos(angle) * radius);
        }
        return polygonToShape(verticesX, verticesY, numberOfSides);
    }

    private Shape polygonToShape(int[] verticesX, int[] verticesY, int numberOfSides) {
        Path2D shape = new Path2D.Float();
        shape.moveTo(verticesX[0], verticesY[0]);
        for (int i=1; i<numberOfSides; i++) {
            shape.lineTo(verticesX[i], verticesY[i]);
        }
        shape.closePath();
        return shape;
    }
}