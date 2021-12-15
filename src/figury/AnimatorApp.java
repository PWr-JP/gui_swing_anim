package figury;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
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
		kanwa.setBounds(0, 0, 422, 219);
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
		btnAdd.setBounds(10, kanwa.getHeight() , 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, kanwa.getHeight(), 80, 23);
		contentPane.add(btnAnimate);

		contentPane.addComponentListener(new ResizeListener(kanwa, btnAdd, btnAnimate));
	}
}

class ResizeListener extends ComponentAdapter {
	AnimPanel kanwa;
	JButton btn1, btn2;
	public ResizeListener(AnimPanel kanwa, JButton btn1, JButton btn2){
		this.kanwa = kanwa;
		this.btn1 = btn1;
		this.btn2 = btn2;
	}
	public void componentResized(ComponentEvent e) {
		Component component = e.getComponent();
		kanwa.setBounds(0, 0, component.getWidth(), component.getHeight() - 23);
		btn1.setBounds(0, kanwa.getHeight(), 80, 23);
		btn2.setBounds(100, kanwa.getHeight(), 80, 23);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

	}
}