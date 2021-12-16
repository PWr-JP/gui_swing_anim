package figury;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

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
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 650, wh =550;
		setBounds((screen.width - ww) / 2, (screen.height - wh) / 2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10,10,615,400);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(() -> kanwa.initialize());

		JButton btnAddSquere = new JButton("Add squere");
		btnAddSquere.addActionListener(e -> kanwa.addFigSquere());

		btnAddSquere.setBounds(40, 430, 140, 30);
		contentPane.add(btnAddSquere);

		JButton btnAddEllipsa = new JButton("Add Ellipse");
		btnAddEllipsa.addActionListener(e -> kanwa.addFigEllipse());

		btnAddEllipsa.setBounds(240, 430, 140, 30);
		contentPane.add(btnAddEllipsa);

		JButton btnAddRandom = new JButton("Add Random Fig");
		btnAddRandom.addActionListener(e -> kanwa.addRandom());

		btnAddRandom.setBounds(440, 430, 140, 30);
		contentPane.add(btnAddRandom);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(e -> kanwa.animate());
		btnAnimate.setBounds(240, 470, 140, 30);
		contentPane.add(btnAnimate);

	}
}
