package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame extends JFrame {
    private AnimationPanel animationPanel;
    private final JPanel buttonsPanel;
    private final JButton addShapeButton;
    private final JButton toggleAnimationButton;

    public MainFrame(int minWidth, int minHeight) {
        super("Animations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(minWidth, minHeight));
        this.setSize(minWidth, minHeight);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        addShapeButton = new JButton("Add next shape");
        toggleAnimationButton = new JButton("Toggle animation");
        animationPanel = new AnimationPanel(minWidth, minHeight);

        this.initializeComponents();
    }

    private void initializeComponents(){
        addShapeButton.addActionListener((event) -> animationPanel.addFig());
        toggleAnimationButton.addActionListener((event) -> animationPanel.toggleAnimation());

        buttonsPanel.add(addShapeButton);
        buttonsPanel.add(toggleAnimationButton);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(animationPanel, BorderLayout.CENTER);
    }

}
