package other;

import java.awt.*;

public class GetSetHelper {
    private static Color color = Color.WHITE;
    private static boolean bounceColorChange = false;

    public static Color getColor() { return color; }
    public static void setColor(Color color) { GetSetHelper.color = color; }
    public static boolean getBounceColorChange() {return bounceColorChange;}
    public static void setBounceColorChange(boolean x) {
        GetSetHelper.bounceColorChange = x;}
}

