package figury;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.Random;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnElipsa,btnKwadrat,btnProstokat;

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
		int ww = 450, wh = 350;
		setBounds((screen.width - ww) / 2, (screen.height - wh) / 2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
		contentPane.add(kanwa);
		setBackground(Color.WHITE);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				kanwa.initialize();
			}
		});


		Random random = new Random();

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(random.nextInt(3));
			}
		});
		contentPane.add(btnAdd);

		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		contentPane.add(btnAnimate);
		createButtons();

		btnKwadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(0);
			}
		});
		btnElipsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(1);
			}
		});
		btnProstokat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig(2);
			}
		});


		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				int w = contentPane.getWidth(), h = contentPane.getHeight();
				btnAnimate.setBounds(w - 160, h - 60, 90, 20);
				btnAdd.setBounds(70, h - 60, 90, 20);
				btnKwadrat.setBounds(10, h-30, 90,20);
				btnElipsa.setBounds(w-120,h-30,90,20);
				btnProstokat.setBounds((int) (0.5*w-45),h-30,90,20);
			}
		});

	}

	private void createButtons(){
		btnElipsa = createButton("Elipsa");
		btnKwadrat = createButton("Kwadrat");
		btnProstokat = createButton("Prosotkat");
	}

	private JButton createButton(String name) {
		JButton jButton = new JButton(name);
		contentPane.add(jButton);
		return jButton;
	}
}
