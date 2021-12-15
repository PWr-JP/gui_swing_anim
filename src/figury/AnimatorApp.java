package figury;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;


public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int speedLvl=0;
	private JPanel contentPane;

	private boolean animationState=true;
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
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, wh-57, 90, 20);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.setBackground(Color.RED);
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
				if(animationState){
					btnAnimate.setBackground(Color.GREEN);
				}else{
					btnAnimate.setBackground(Color.RED);
				}
				animationState=(!animationState);
			}
		});
		btnAnimate.setBounds(110, wh-57, 90, 20);
		contentPane.add(btnAnimate);

		JButton btnSpeed= new JButton("Prędkość: "+(speedLvl+1));
		btnSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				speedLvl=(speedLvl+1)%3;

				kanwa.delay= (int)(kanwa.startDelay/(speedLvl+1));
				btnSpeed.setText("Prędkość: "+(speedLvl+1));


			}
		});
		btnSpeed.setBounds(60, wh-57, 90, 20);
		contentPane.add(btnSpeed);


		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				int w=contentPane.getWidth(),h=contentPane.getHeight();
				kanwa.setBounds(10,10,w-20,h-50);
				kanwa.clear();
				btnAdd.setBounds(10, h-30,90,20);
				btnSpeed.setBounds((w/2)-63, h-30,125,20);
				btnAnimate.setBounds(w-100,h-30,90,20);
			}
		});




	}

}
