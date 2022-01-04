package figury;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int shapeNumber = 0;
	public Color shapeColor = Color.BLUE;

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
	 * @param delay
	 */
	public AnimatorApp() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 650, wh = 300;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GREEN);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 0, 615, 219);

		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		String[] shapeStrings = { "Kwadrat", "Elipsa", "Okrągły prostokąt"};

		JComboBox choseShape = new JComboBox(shapeStrings);
		choseShape.setSelectedIndex(0);
		choseShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(choseShape.getSelectedIndex());

				shapeNumber = choseShape.getSelectedIndex();
			}
		});
		choseShape.setBounds(280, 239, 160, 23);
		contentPane.add(choseShape);

		String[] speedStrings = { "prędkość: wolno", "prędkość: normalnie", "prędkość: szybko"};

		JComboBox choseSpeed = new JComboBox(speedStrings);
		choseSpeed.setSelectedIndex(1);
		choseSpeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.changeSpeed(choseSpeed.getSelectedIndex());
			}
		});
		choseSpeed.setBounds(450, 239, 160, 23);
		contentPane.add(choseSpeed);

		Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.PINK};
		String[] colorStrings = {"Niebieski", "Czerwony", "Zielony", "Żółty", "Różowy"};

		JComboBox choseColor = new JComboBox(colorStrings);
		choseColor.setSelectedIndex(0);
		choseColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shapeColor = colors[choseColor.getSelectedIndex()];
			}
		});
		choseColor.setBounds(190, 239, 80, 23);
		contentPane.add(choseColor);

//		JButton btnReset = new JButton("Reset");
//		btnReset.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				kanwa.initialize();
//				choseSpeed.setVisible(true);
//			}
//		});
//		btnReset.setBounds(190, 239, 80, 23);
//		btnReset.setVisible(true);
//		contentPane.add(btnReset);

		JButton btnAdd = new JButton("Set");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.setParameters(shapeNumber, shapeColor);

			}
		});
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
				choseSpeed.setVisible(false);
			}
		});
		btnAnimate.setBounds(100, wh - 57, 80, 23);
		contentPane.add(btnAnimate);



		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int newWidth = contentPane.getWidth();
				int newHeight = contentPane.getHeight();
				btnAdd.setBounds(newWidth - 625, newHeight - 30, 80, 23);
				btnAnimate.setBounds(newWidth - 535, newHeight - 30, 80, 23);
				choseColor.setBounds(newWidth - 445, newHeight - 30, 80, 23);
				choseShape.setBounds(newWidth - 355, newHeight - 30, 160, 23);
				choseSpeed.setBounds(newWidth - 185, newHeight - 30, 160, 23);
			}
		});


	}

}
