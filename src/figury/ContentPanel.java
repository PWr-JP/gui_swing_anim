package figury;

import javax.swing.*;

public class ContentPanel extends JPanel {
    private JButton btnAdd;
    private JButton btnAnimate;
    private JButton btnAccelerate;
    private JButton btnSlow;
    private JButton btnBlinking;
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

    public JButton getBtnAccelerate() {
        return btnAccelerate;
    }

    public void setBtnAccelerate(JButton btnAccelerate) {
        this.add(btnAccelerate);
        this.btnAccelerate = btnAccelerate;
    }

    public JButton getBtnSlow() {
        return btnSlow;
    }

    public void setBtnSlow(JButton btnSlow) {
        this.add(btnSlow);
        this.btnSlow = btnSlow;
    }

    public JButton getBtnBlinking() {
        return btnBlinking;
    }

    public void setBtnBlinking(JButton btnBlinking) {
        this.add(btnBlinking);
        this.btnBlinking = btnBlinking;
    }
}
