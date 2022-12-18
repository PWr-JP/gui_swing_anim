package app;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final JPanel contentPane = new JPanel();
	private static final JTextField red = new JTextField("255");
	private static final JTextField green = new JTextField("255");
	private static final JTextField blue = new JTextField("255");
	private static final JLabel rgb = new JLabel("Kolor w formacie RGB");

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
		int ww = 450, wh = 500;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
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
				FigureParameters.color = new Color(
						Integer.parseInt( red.getText() ),
						Integer.parseInt( green.getText() ),
						Integer.parseInt( blue.getText() ));
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, 239, 80, 23);
		contentPane.add(btnAnimate);

		rgb.setBounds(147, 290, 200, 25);
		rgb.setVisible(true);
		this.add(rgb);

		red.setBounds(65, 315, 80, 25);
		red.setVisible(true);
		this.add(red);

		green.setBounds(170, 315, 80, 25);
		green.setVisible(true);
		this.add(green);

		blue.setBounds(275, 315, 80, 25);
		blue.setVisible(true);
		this.add(blue);
	}

}
