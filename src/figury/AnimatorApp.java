package figury;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

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
		int ww = 1000, wh = 700;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		setResizable(false);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 960, 500);
		contentPanel.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() { kanwa.initialize(); }
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, 530, 150, 55);
		contentPanel.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { kanwa.animate();}
		});
		btnAnimate.setBounds(10, 600, 150, 55);
		contentPanel.add(btnAnimate);

		JSlider delaySlider = new JSlider(10, 200, 70);
		delaySlider.setFocusable(false);
		delaySlider.setBounds(630,570,300,50);
		contentPanel.add(delaySlider);
		delaySlider.addChangeListener(e -> kanwa.setDelay(delaySlider.getValue()));

		JLabel delayLabel = new JLabel("Delay: " + delaySlider.getValue());
		contentPanel.add(delayLabel);
		delayLabel.setBounds(550,570,70,50);
		delaySlider.addChangeListener(e -> delayLabel.setText("Delay: " + delaySlider.getValue()));

		JSlider redSlider = new JSlider(0,255,191);
		JSlider greenSlider = new JSlider(0,255,168);
		JSlider blueSlider = new JSlider(0, 255,229);
		redSlider.setBounds(300,530,200,50);
		greenSlider.setBounds(300,570,200,50);
		blueSlider.setBounds(300,610,200,50);
		contentPanel.add(redSlider);
		contentPanel.add(greenSlider);
		contentPanel.add(blueSlider);

		JLabel redLabel = new JLabel("Red: " + redSlider.getValue());
		JLabel greenLabel = new JLabel("Green: " + greenSlider.getValue());
		JLabel blueLabel = new JLabel("Blue: " + blueSlider.getValue());
		redLabel.setBounds(200,530,70,50);
		greenLabel.setBounds(200,570,70,50);
		blueLabel.setBounds(200,610,70,50);
		contentPanel.add(redLabel);
		contentPanel.add(greenLabel);
		contentPanel.add(blueLabel);

		redSlider.addChangeListener(e -> redLabel.setText("Red: " + redSlider.getValue()));
		redSlider.addChangeListener(e -> kanwa.setColor("red", redSlider.getValue()));

		greenSlider.addChangeListener(e -> greenLabel.setText("Green: " + greenSlider.getValue()));
		greenSlider.addChangeListener(e -> kanwa.setColor("green", greenSlider.getValue()));

		blueSlider.addChangeListener(e -> blueLabel.setText("Blue: " + blueSlider.getValue()));
		blueSlider.addChangeListener(e -> kanwa.setColor("blue", blueSlider.getValue()));
	}
}
