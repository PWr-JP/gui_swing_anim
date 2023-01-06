package app;

import app.figures.*;
import app.figures.MyRectangle;

import java.awt.*;

import javax.swing.*;

public class AnimatorApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final JPanel contentPane = new JPanel();
	private static final Color BACKGROUND_COLOR = new Color(251, 251, 240);


	private static final JTextField red = new JTextField("255");
	private static final JTextField green = new JTextField("255");
	private static final JTextField blue = new JTextField("255");
	private static final JLabel rgbLabel = new JLabel("Color in RGB");


	private static final JLabel shapeLabel = new JLabel("Shape");
	private static final ButtonGroup shapeGroup = new ButtonGroup();
	private static final JRadioButton roundRectRadioBtn;
	private static final JRadioButton rectangleRadioBtn;
	private static final JRadioButton ellipseRadioBtn;
	static {
		roundRectRadioBtn = new JRadioButton("Round rectangle");
		rectangleRadioBtn = new JRadioButton("Rectangle");
		ellipseRadioBtn = new JRadioButton("Ellipse");
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int windowWidth = 450, windowHeigth = 500;
		setBounds((screen.width-windowWidth)/2, (screen.height-windowHeigth)/2, windowWidth, windowHeigth);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		getContentPane().setBackground(BACKGROUND_COLOR);

		AnimPanel canva = new AnimPanel();

		canva.setBounds(10, 11, 422, 219);
		contentPane.add(canva);
		SwingUtilities.invokeLater(canva::initialize);



		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(e -> {
			ColorHolder.color = new Color(
					Integer.parseInt( red.getText() ),
					Integer.parseInt( green.getText() ),
					Integer.parseInt( blue.getText() ));

			Figure figure;

			if (rectangleRadioBtn.isSelected())
				figure = new MyRectangle();
			else if (ellipseRadioBtn.isSelected())
				figure = new Ellipse();
			else
				figure = new RoundRectangle();

			canva.addFig(figure);
		});
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);

		JButton btnAnimate = new JButton("Animate");

		btnAnimate.addActionListener(e -> canva.animate());
		btnAnimate.setBounds(100, 239, 80, 23);
		contentPane.add(btnAnimate);




		rgbLabel.setBounds(170, 280, 200, 25);
		rgbLabel.setVisible(true);
		this.add(rgbLabel);

		red.setBounds(65, 305, 80, 25);
		red.setVisible(true);
		this.add(red);

		green.setBounds(170, 305, 80, 25);
		green.setVisible(true);
		this.add(green);

		blue.setBounds(275, 305, 80, 25);
		blue.setVisible(true);
		this.add(blue);

		shapeLabel.setBounds(190, 340, 200, 25);
		shapeLabel.setVisible(true);
		this.add(shapeLabel);

		rectangleRadioBtn.setSelected(false);
		ellipseRadioBtn.setSelected(true);
		roundRectRadioBtn.setSelected(false);

		shapeGroup.add(rectangleRadioBtn);
		shapeGroup.add(ellipseRadioBtn);
		shapeGroup.add(roundRectRadioBtn);
		this.add(rectangleRadioBtn);
		this.add(ellipseRadioBtn);
		this.add(roundRectRadioBtn);

		ellipseRadioBtn.setBounds(70, 365, 90, 25);
		rectangleRadioBtn.setBounds(165, 365, 90, 25);
		roundRectRadioBtn.setBounds(265, 365, 119, 25);

		ellipseRadioBtn.setBackground(BACKGROUND_COLOR);
		rectangleRadioBtn.setBackground(BACKGROUND_COLOR);
		roundRectRadioBtn.setBackground(BACKGROUND_COLOR);

		this.repaint();
	}

}
