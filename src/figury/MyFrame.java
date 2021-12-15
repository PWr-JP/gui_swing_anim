package figury;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 420;
    private JPanel componentsPanel;
    private JButton buttonAdd;
    private JButton buttonAnim;
    private JSlider slider;
    private JLabel label;
    AnimPanel animPanel;

    MyFrame() {
        componentsPanel = new JPanel();
        componentsPanel.setLayout(new FlowLayout());
        componentsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        componentsPanel.setBackground(Color.lightGray);

        animPanel = new AnimPanel(FRAME_HEIGHT, FRAME_HEIGHT);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                animPanel.initialize();
            }
        });

        buttonAdd = new JButton("Add shape");
        buttonAdd.setFocusable(false);
        buttonAdd.addActionListener(e -> animPanel.addFig());

        buttonAnim = new JButton("Animate");
        buttonAnim.setFocusable(false);
        buttonAnim.addActionListener(e -> animPanel.animate());

        slider = new JSlider(0,50,25);
        slider.setPaintTicks(true);
        slider.setBackground(Color.lightGray);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> animPanel.changeDelay(slider.getValue()));

        label = new JLabel("           Delay:");

        componentsPanel.add(buttonAdd);
        componentsPanel.add(buttonAnim);
        componentsPanel.add(label);
        componentsPanel.add(slider);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setTitle("Animation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(componentsPanel, BorderLayout.SOUTH);
        this.add(animPanel, BorderLayout.CENTER);
    }
}
