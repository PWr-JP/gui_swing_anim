package app.figures;

import app.AnimPanel;

public class PanelHolder {
    private PanelHolder() {}

    private static AnimPanel panel;
    public static AnimPanel getPanel() {
        return panel;
    }
    public static void setPanel(AnimPanel panel) {
        PanelHolder.panel = panel;
    }
}
