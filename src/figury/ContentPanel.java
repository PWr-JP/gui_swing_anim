package figury;

import javax.swing.*;

public class ContentPanel extends JPanel {
    private JButton btnAdd;
    private JButton btnAnimate;
    private AnimPanel animPanel;

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.add(btnAdd);
        this.btnAdd = btnAdd;
    }

    public JButton getBtnAnimate() {
        return btnAnimate;
    }

    public void setBtnAnimate(JButton btnAnimate) {
        this.add(btnAnimate);
        this.btnAnimate = btnAnimate;
    }

    public AnimPanel getAnimPanel() {
        return animPanel;
    }

    public void setAnimPanel(AnimPanel animPanel) {
        this.add(animPanel);
        this.animPanel = animPanel;
    }
}
