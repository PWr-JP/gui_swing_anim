package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
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
	private ContentPanel contentPane;

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
		int ww = 600, wh = 500;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new ContentPanel();
		contentPane.addComponentListener(new ResizeListener());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
		contentPane.setAnimPanel(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		contentPane.setBtnAdd(btnAdd);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		contentPane.setBtnAnimate(btnAnimate);

		JButton btnSlow = new JButton("Slow");
		btnSlow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.slowAnimation();
			}
		});
		contentPane.setBtnSlow(btnSlow);

		JButton btnAccelerate = new JButton("Accelerate");
		btnAccelerate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kanwa.accelerateAnimation();
			}
		});
		contentPane.setBtnAccelerate(btnAccelerate);

		JButton btnBlinking = new JButton("Blinking");
		btnBlinking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kanwa.blinking();
			}
		});
		contentPane.setBtnBlinking(btnBlinking);

		
	}

}
