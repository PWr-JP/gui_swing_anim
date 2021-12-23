package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import java.awt.Dimension;

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

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(e -> kanwa.addOvalOrSquare());

		JSpinner spinner = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));

		JButton btnAddPolygon = new JButton("Add Polygon");
		btnAddPolygon.addActionListener(e -> kanwa.addPolygon((Integer) spinner.getValue()));

		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);

		btnAddPolygon.setBounds(100, 239, 120, 23);
		contentPane.add(btnAddPolygon);
		spinner.setBounds(230, 239, 30, 23);
		contentPane.add(spinner);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(e -> kanwa.animate());
		btnAnimate.setBounds(300, 239, 80, 23);
		contentPane.add(btnAnimate);


		
	}

}
