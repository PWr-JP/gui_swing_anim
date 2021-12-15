package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

		JButton btnAddElip = new JButton("Add Elipse");
		btnAddElip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addElip();
			}
		});
		btnAddElip.setBounds(10, 239, 80, 23);
		contentPane.add(btnAddElip);

		JButton btnAddRect = new JButton("Add Rectangle");
		btnAddRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addRect();
			}
		});
		btnAddRect.setBounds(100, 239, 80, 23);
		contentPane.add(btnAddRect);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(190, 239, 80, 23);
		contentPane.add(btnAnimate);

		JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 50, 20);
		slider.setBounds(280, 239, 150, 23);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				kanwa.setDelay(slider.getValue());
			}
		});
		contentPane.add(slider);
	}

}
