package other;


import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {

	/**
	 *
	 */
	private final JFrame window;
	private static final long serialVersionUID = 1L;
	private int figure;
	private Color color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnimatorApp() {
		window = this;
		setTitle("Animacja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 460, wh = 410;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);


		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 111, 422, 219);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(figure);
			}
		});
		btnAdd.setBounds(10, 339, 200, 23);
		contentPane.add(btnAdd);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(232, 339, 200, 23);
		contentPane.add(btnAnimate);

		JLabel shapeLabel = new JLabel("Kształt");
		shapeLabel.setBounds(10,10,50,23);
		shapeLabel.setFont(new Font("", Font.BOLD, 14));
		contentPane.add(shapeLabel);

		JRadioButton rbtnRectangle = new JRadioButton("Prostokąt");
		rbtnRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				figure = 1;
			}
		});
		rbtnRectangle.setBounds(10,40,100,23);
		rbtnRectangle.doClick();
		contentPane.add(rbtnRectangle);

		JRadioButton rbtnEllipse = new JRadioButton("Elipsa");
		rbtnEllipse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				figure = 2;
				color = null;
			}
		});
		rbtnEllipse.setBounds(10,70,100,23);
		contentPane.add(rbtnEllipse);

		ButtonGroup shapeGroup = new ButtonGroup();
		shapeGroup.add(rbtnRectangle);
		shapeGroup.add(rbtnEllipse);



		JButton btnChooseColor = new JButton("Wybierz kolor");
		btnChooseColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(window,"Wybierz kolor", color);
				GetSetHelper.setColor(color);
			}
		});
		btnChooseColor.setBounds(300, 40, 132, 23);
		btnChooseColor.setEnabled(false);
		btnChooseColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnChooseColor);

		JCheckBox checkBox = new JCheckBox("zmiana przy odbiciu");
		checkBox.setBounds(296,70,150,23);
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GetSetHelper.setBounceColorChange(!GetSetHelper.getBounceColorChange());
				System.out.println("xd");
			}
		});
		contentPane.add(checkBox);

		JLabel colorLabel = new JLabel("Kolor");
		colorLabel.setFont(new Font("", Font.BOLD, 14));
		colorLabel.setBounds(200,10,50,23);
		contentPane.add(colorLabel);

		JRadioButton rbtnOneColor = new JRadioButton("Stały");
		rbtnOneColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnChooseColor.setEnabled(true);
				checkBox.setSelected(false);
				GetSetHelper.setBounceColorChange(false);
				checkBox.setEnabled(false);

			}
		});
		rbtnOneColor.setBounds(200,40,80,23);
		rbtnOneColor.doClick();
		contentPane.add(rbtnOneColor);

		JRadioButton rbtnRandColor = new JRadioButton("Losowy");
		rbtnRandColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkBox.setEnabled(true);
				btnChooseColor.setEnabled(false);
				GetSetHelper.setColor(null);
			}
		});
		rbtnRandColor.setBounds(200,70,80,23);
		contentPane.add(rbtnRandColor);

		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(rbtnOneColor);
		colorGroup.add(rbtnRandColor);
	}

}
