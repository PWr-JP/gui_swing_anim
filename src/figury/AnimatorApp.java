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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		int ww = 800, wh = 650;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(0, 0, ww, wh);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAddSquare = new JButton("Dodaj kwadrat");
		btnAddSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addSquare(getWidth(), getHeight());
			}
		});

		btnAddSquare.setBounds(10, contentPane.getHeight()-30, 150, 20);
		contentPane.add(btnAddSquare);
		JButton btnAddCircle = new JButton("Dodaj koło");
		btnAddCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addCircle(getWidth(), getHeight());
			}
		});
		btnAddCircle.setBounds(170, contentPane.getHeight()-30, 150, 20);
		contentPane.add(btnAddCircle);

		JButton btnAddTriangle = new JButton("Dodaj trójkąt");
		btnAddTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addTriangle(getWidth(), getHeight());
			}
		});
		btnAddTriangle.setBounds(330, contentPane.getHeight()-30, 150, 20);
		contentPane.add(btnAddTriangle);

		JButton btnAddPolygon = new JButton("Dodaj czworokąt");
		btnAddPolygon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addPolygon(getWidth(), getHeight());
			}
		});
		btnAddPolygon.setBounds(330, contentPane.getHeight()-30, 150, 20);
		contentPane.add(btnAddPolygon);
		
		JButton btnAnimate = new JButton("Animuj");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(490, contentPane.getHeight()-30, 80, 20);
		contentPane.add(btnAnimate);

		JButton btnCloseThread = new JButton("Zatrzymaj ostatnią figurę");
		btnCloseThread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kanwa.figuresListSize>-1){
					System.out.println(kanwa.figuresListSize);
					kanwa.stopFigure();
				}

			}
		});
		btnCloseThread.setBounds(650, contentPane.getHeight()-60, 80, 20);
		contentPane.add(btnCloseThread);
		JButton btnOpenThread = new JButton("Wznów ostatnią figurę");
		btnOpenThread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(kanwa.figuresListSize<kanwa.figuresList.size()-1 && kanwa.figuresListSize>-2){
					kanwa.startFigure();
				}
				System.out.println(kanwa.figuresListSize);
				System.out.println("e");
				System.out.println(kanwa.figuresList.size());

			}
		});
		btnOpenThread.setBounds(650, contentPane.getHeight()-30, 80, 20);
		contentPane.add(btnOpenThread);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				int w = contentPane.getWidth(), h = contentPane.getHeight() ;


				kanwa.setSize(w,h-90);
				btnAddSquare.setBounds(10, h-60, 150, 20);
				btnAddCircle.setBounds(170, h-60, 150, 20);
				btnAddTriangle.setBounds(330, h-60, 150, 20);
				btnAddPolygon.setBounds(10, h-30, 150, 20);
				btnAnimate.setBounds(490, h-60, 90, 20);
				btnCloseThread.setBounds(650, h-60, 90, 20);
				btnOpenThread.setBounds(650, h-30, 90, 20);
				contentPane.repaint();
			}
		});
	}

}
