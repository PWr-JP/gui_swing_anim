package gui;

import shapes.CanvasEllipse;
import shapes.CanvasFigure;
import shapes.CanvasSquare;
import shapes.CanvasTriangle;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private AnimationPanel animationPanel;
    private final JPanel buttonsPanel;
    private final JButton addShapeButton;
    private final JButton toggleAnimationButton;
    private final JRadioButton squareRadioButton;
    private final JRadioButton ellipseRadioButton;
    private final JRadioButton triangleRadioButton;
    private Class<? extends CanvasFigure> selectedFigure;

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
        squareRadioButton = new JRadioButton("Square");
        ellipseRadioButton = new JRadioButton("Circle");
        triangleRadioButton = new JRadioButton("Triangle");

        this.initializeComponents();
    }

    private void initializeComponents(){
        squareRadioButton.addActionListener((e) -> {
            selectedFigure = CanvasSquare.class;
            ellipseRadioButton.setSelected(false);
            triangleRadioButton.setSelected(false);
        });
        ellipseRadioButton.addActionListener((e) -> {
            selectedFigure = CanvasEllipse.class;
            squareRadioButton.setSelected(false);
            triangleRadioButton.setSelected(false);
        });
        triangleRadioButton.addActionListener((e) -> {
            selectedFigure = CanvasTriangle.class;
            ellipseRadioButton.setSelected(false);
            squareRadioButton.setSelected(false);
        });

        //Make square default option
        squareRadioButton.doClick();

        addShapeButton.addActionListener((event) -> animationPanel.addFigure(selectedFigure));
        toggleAnimationButton.addActionListener((event) -> animationPanel.toggleAnimation());

        buttonsPanel.add(addShapeButton);
        buttonsPanel.add(toggleAnimationButton);
        buttonsPanel.add(squareRadioButton);
        buttonsPanel.add(ellipseRadioButton);
        buttonsPanel.add(triangleRadioButton);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(animationPanel, BorderLayout.CENTER);
        this.pack();
    }


}
