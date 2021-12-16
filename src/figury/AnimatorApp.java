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
		int ww = 750, wh = 500;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 700, 400);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAdd = new JButton("Random");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, 420, 80, 23);
		contentPane.add(btnAdd);

		JButton btnKw = new JButton("Kwadrat");
		btnKw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addKwadrat();
			}
		});
		btnKw.setBounds(110, 420, 80, 23);
		contentPane.add(btnKw);

		JButton btnEl = new JButton("Elipsa");
		btnEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addElipsa();
			}
		});
		btnEl.setBounds(210, 420, 80, 23);
		contentPane.add(btnEl);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();

			}
		});
		btnAnimate.setBounds(410, 420, 80, 23);
		contentPane.add(btnAnimate);


		JButton btnCzysc = new JButton("Czyść");
		btnCzysc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.repaint();
			}
		});
		btnCzysc.setBounds(310, 420, 80, 23);
		contentPane.add(btnCzysc);
		
	}

}
