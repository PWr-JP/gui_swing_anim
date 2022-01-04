package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Dimension;
import java.awt.event.*;

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

		// Dodane: poprzez klikniecie myszki na kanwie, mozna wybrac gdzie ma byc narysowana figura
		kanwa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kanwa.addFig(e.getX(),e.getY());
			}
		});
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
				kanwa.addFig(100,100);
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
		btnAnimate.setBounds(100, 239, 80, 23);
		contentPane.add(btnAnimate);

		// Dodane: suwak zmieniający wartość prędkości animacji dla nowo dodanego kształtu
		// (skala suwaka jest lepiej widoczna przy powiększeniu okienka)
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setOrientation(SwingConstants.HORIZONTAL);
		slider.setMinimum(1);
		slider.setMaximum(151);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				kanwa.changeDelay(slider.getValue());
			}
		});
		contentPane.add(slider);


		// Dodane: resizowanie okienka
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {

				super.componentResized(arg0);

				int width = contentPane.getWidth();
				int height = contentPane.getHeight();

				kanwa.setBounds( 10, 11, contentPane.getWidth() - 30, contentPane.getHeight() - 60);
				kanwa.initialize();

				slider.setBounds(100, height-45, width-210, 43);
				btnAdd.setBounds(10, height-30, 90, 20);
				btnAnimate.setBounds(width-100, height-30, 90, 20);
			}
		});

	}

}
