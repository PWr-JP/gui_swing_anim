package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
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
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(120, 239, 100, 23);
		contentPane.add(btnAnimate);

		JComboBox choice = new JComboBox();
		choice.addItem("Wybor figur");
		choice.addItem("Elipsa");
		choice.addItem("Kwadrat");
		choice.addItem("Kolo");
		choice.addItem("Prostokat");
		choice.addItem("Luk");

		choice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String wybor = choice.getSelectedItem().toString();
				if(wybor.equals("Elipsa"))
					kanwa.addElipsa();
				if(wybor.equals("Kwadrat"))
					kanwa.addKwadrat();
				if(wybor.equals("Kolo"))
					kanwa.addKolo();
				if(wybor.equals("Prostokat"))
					kanwa.addProstokat();
				if(wybor.equals("Luk"))
					kanwa.addLuk();
			}
		});
		choice.setBounds(10, 239, 100, 23);
		contentPane.add(choice);
	}

}
