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

	/**
	 * Create the frame.
	 * @param delay 
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 605, wh = 311;
		final int[] choise = new int[1];
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 600, 219);
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
		btnAnimate.setBounds(100, 239, 90, 23);
		contentPane.add(btnAnimate);

		JButton btnAddE = new JButton("Add Elipse");
		btnAddE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choise[0] = 0;
				kanwa.addAll(choise[0]);
			}
		});
		btnAddE.setBounds(200, 239, 120, 23);
		contentPane.add(btnAddE);

		JButton btnAddS = new JButton("Add Square");
		btnAddS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choise[0] = 1;
				kanwa.addAll(choise[0]);
			}
		});
		btnAddS.setBounds(330, 239, 120, 23);
		contentPane.add(btnAddS);

		JButton btnAddP = new JButton("Add Triangle");
		btnAddP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choise[0] = 2;
				kanwa.addAll(choise[0]);
			}
		});
		btnAddP.setBounds(460, 239, 120, 23);
		contentPane.add(btnAddP);


		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				kanwa.setBounds( 10, 11, contentPane.getWidth() - 20, contentPane.getHeight() - 52);
				kanwa.initialize();
				btnAdd.setBounds( 10, contentPane.getHeight() - 28, 80, 23);
				btnAnimate.setBounds( 100, contentPane.getHeight() - 28, 90, 23);
				btnAddE.setBounds( 200, contentPane.getHeight() - 28, 120, 23);
				btnAddS.setBounds( 330, contentPane.getHeight() - 28, 120, 23);
				btnAddP.setBounds( 460, contentPane.getHeight() - 28, 120, 23);
			}
		});
	}

}