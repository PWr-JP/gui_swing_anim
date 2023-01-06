package app;

import app.figures.*;
import app.figures.MyRectangle;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final JPanel contentPane = new JPanel();
	private static final JTextField red = new JTextField("255");
	private static final JTextField green = new JTextField("255");
	private static final JTextField blue = new JTextField("255");
	private static final JLabel rgbLabel = new JLabel("Color in RGB");

	private static final JLabel shapeLabel = new JLabel("Shape");
	private static final JRadioButton roundRectRadioBtn = new JRadioButton("Round rectangle");
	private static final JRadioButton rectangleRadioBtn = new JRadioButton("Rectangle");
	private static final JRadioButton elipseRadioBtn = new JRadioButton("Elipse");
	private static final ButtonGroup shapeGroup = new ButtonGroup();

	private static final Color BACKGROUND_COLOR = new Color(251, 251, 240);
	private static final Color PANEL_COLOR = Color.WHITE;

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
		PanelHolder.setPanel(canva);

		canva.setBounds(10, 11, 422, 219);
		contentPane.add(canva);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				canva.initialize();
			}
		});

		Border blackLine = BorderFactory.createLineBorder(Color.black);
		canva.setBorder(blackLine);
		canva.setBackground(PANEL_COLOR);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FigureParametersHolder.color = new Color(
						Integer.parseInt( red.getText() ),
						Integer.parseInt( green.getText() ),
						Integer.parseInt( blue.getText() ));

				Figure figure;

				if (rectangleRadioBtn.isSelected())
					figure = new MyRectangle();
				else if (elipseRadioBtn.isSelected())
					figure = new Elipse();
				else
					figure = new RoundRectangle();

				canva.addFig(figure);
			}
		});
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canva.animate();
			}
		});
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

		elipseRadioBtn.setSelected(true);

		roundRectRadioBtn.setSelected(false);

		shapeGroup.add(rectangleRadioBtn);
		shapeGroup.add(elipseRadioBtn);
		shapeGroup.add(roundRectRadioBtn);
		this.add(rectangleRadioBtn);
		this.add(elipseRadioBtn);
		this.add(roundRectRadioBtn);

		elipseRadioBtn.setBounds(70, 365, 90, 25);
		rectangleRadioBtn.setBounds(165, 365, 90, 25);
		roundRectRadioBtn.setBounds(265, 365, 119, 25);

		rectangleRadioBtn.setBackground(BACKGROUND_COLOR);
		elipseRadioBtn.setBackground(BACKGROUND_COLOR);
		roundRectRadioBtn.setBackground(BACKGROUND_COLOR);

		this.repaint();
	}

}
