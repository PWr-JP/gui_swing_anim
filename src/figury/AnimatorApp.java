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

//	/**
//	 * Create the frame.
//	 * @param delay
//	 */
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

		JButton btnAddSquare = new JButton("Square");
		btnAddSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(1);
			}
		});
		btnAddSquare.setBounds(10, 239, 80, 23);
		contentPane.add(btnAddSquare);

		JButton btnAddRectengle = new JButton("Rectengle" );
		btnAddRectengle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(2);
			}
		});
		btnAddRectengle.setBounds(100, 239, 100, 23);
		contentPane.add(btnAddRectengle);

		JButton btnAddElipse = new JButton("Elipse");
		btnAddElipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(3);
			}
		});
		btnAddElipse.setBounds(220, 239, 80, 23);
		contentPane.add(btnAddElipse);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(300, 239, 80, 23);
		contentPane.add(btnAnimate);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int w = contentPane.getWidth();
				int h = contentPane.getHeight();

				btnAddSquare.setLocation(10, h-30);
				btnAddRectengle.setLocation(btnAddSquare.getLocation().x+100, h-30);
				btnAddElipse.setLocation(btnAddSquare.getLocation().x+220,h-30);
				btnAnimate.setLocation(w-100, h-30);
			}
		});
	}

}
