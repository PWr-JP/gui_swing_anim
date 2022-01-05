package figury;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.Random;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter = 2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				final AnimatorApp frame = new AnimatorApp();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Animacja");
		setResizable(false);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 450, wh = 300;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(176, 196, 222));

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(kanwa::initialize);

		JButton btnAdd = new JButton("Add shape");
		btnAdd.addActionListener(e -> kanwa.addFig());
		btnAdd.setBounds(100, 239, 120, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Start");
		btnAnimate.addActionListener(e -> kanwa.animate());
		btnAnimate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(counter++ % 2 == 0){
					btnAnimate.setText("Stop");
				}else{
					btnAnimate.setText("Start");
				}

			}
		});
		btnAnimate.setBounds(10, 239, 80, 23);
		contentPane.add(btnAnimate);

		JButton btnColor = new JButton("Change background color");
		btnColor.addActionListener(e -> kanwa.buffer.setBackground(randomColor()));
		btnColor.setBounds(230, 239, 200, 23);
		contentPane.add(btnColor);
	}

	private static Color randomColor() {
		Random random = new Random();
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
