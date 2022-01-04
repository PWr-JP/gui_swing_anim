package figury;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setTitle("Animacja");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 460, wh = 310;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
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

		JButton btnElipse = new JButton("Elipse");
		btnElipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addElipse();
			}
		});
		contentPane.add(btnElipse);

		JButton btnSquare = new JButton("Square");
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addSquare();
			}
		});
		contentPane.add(btnSquare);

		JButton btnRsquare = new JButton("R. square");
		btnRsquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addRsquare();
			}
		});
		contentPane.add(btnRsquare);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		contentPane.add(btnAnimate);

		addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent ce) {

				int height = contentPane.getHeight();
				btnElipse.setBounds(10, height-30, 90, 20);
				btnSquare.setBounds(120, height-30, 90, 20);
				btnRsquare.setBounds(230, height-30, 90, 20);
				btnAnimate.setBounds(340, height-30, 90, 20);
			}
		});
	}

}
