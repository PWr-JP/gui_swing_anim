package figury;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
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

	/**
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 700, wh = 600;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 600, 400);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAddRect = new JButton("Rectangle");
		btnAddRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(1);
			}
		});
		btnAddRect.setBounds(10, 420, 120, 23);
		contentPane.add(btnAddRect);

		JButton btnAddOval = new JButton("Oval");
		btnAddOval .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(2);
			}
		});
		btnAddOval .setBounds(150, 420, 120, 23);
		contentPane .add(btnAddOval);

		JButton btnAddRandom = new JButton("Random");
		btnAddRandom .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(3);
			}
		});
		btnAddRandom .setBounds(280, 420, 120, 23);
		btnAddRandom.setBackground(Color.yellow);
		contentPane .add(btnAddRandom);


		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(430, 420, 120, 23);
		btnAnimate.setBackground(Color.CYAN);
		contentPane.add(btnAnimate);
		
	}

}
