package app;

import java.awt.Color;

public class ColorHolder {
    private static Color color = new Color(255, 255, 255);

    public static Color getColor() { return color; }
    public static void setColor(Color color) { ColorHolder.color = color; }
    private ColorHolder() {}
}
