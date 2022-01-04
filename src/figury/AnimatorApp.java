package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 450, wh = 300;
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

		JButton btnAddSquare = new JButton("Add Square");
		btnAddSquare.setFocusable(false);
		btnAddSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addSquare();
			}
		});
		btnAddSquare.setBounds(10, 239, 100, 23);
		contentPane.add(btnAddSquare);

		JButton btnAddOval = new JButton("Add Oval");
		btnAddOval.setFocusable(false);
		btnAddOval.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kanwa.addOval();
			}
		});

		btnAddOval.setBounds(120,239,100,23);
		contentPane.add(btnAddOval);

		JButton btnAddRectangle = new JButton("Add Rectangle");
		btnAddRectangle.setFocusable(false);
		btnAddRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kanwa.addRectangle();
			}
		});

		btnAddRectangle.setBounds(230, 239, 120, 23);
		contentPane.add(btnAddRectangle);


		JButton btnAnimate = new JButton("Animate");
		btnAnimate.setFocusable(false);
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(360, 239, 80, 23);
		contentPane.add(btnAnimate);
		
	}

}
