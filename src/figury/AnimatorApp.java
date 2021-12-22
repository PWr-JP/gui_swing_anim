package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private final JPanel contentPane;

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
		setTitle("Animacja");
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
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, 239, 100, 23);
		contentPane.add(btnAnimate);


		JLabel delayLabel = new JLabel("Delay: ");
		JSlider delaySlider = new JSlider(JSlider.HORIZONTAL,20,200,70);
		JLabel delayValueLabel = new JLabel(String.format("%d",delaySlider.getValue()));
		delaySlider.setSize(150,23);
		delaySlider.setMajorTickSpacing(5);
		delaySlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				delayValueLabel.setText(String.format("%d", delaySlider.getValue()));
				kanwa.setDelay(delaySlider.getValue());
			}
		});

		Box delayBox = Box.createHorizontalBox();
		delayBox.add(delayLabel);
		delayBox.add(delaySlider);
		delayBox.add(delayValueLabel);
		delayBox.setBounds(10,250,200,23);
		contentPane.add(delayBox);


		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				kanwa.setBounds(e.getComponent().getX() + 10,e.getComponent().getY()+10 ,e.getComponent().getWidth()-20,e.getComponent().getHeight()-80);
				kanwa.resizeWindow(e.getComponent().getWidth(), e.getComponent().getHeight());
				btnAdd.setLocation(10,kanwa.getHeight()+20);
				btnAnimate.setLocation(getWidth()-124,kanwa.getHeight()+20);
				delayBox.setLocation(10,kanwa.getHeight()+btnAdd.getHeight()+20);
			}
		});

	}

}
