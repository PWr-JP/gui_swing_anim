package figury;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class AnimatorApp extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				final AnimatorApp frame = new AnimatorApp();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 460, wh = 300;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 422, 219);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(kanwa::initialize);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(e -> kanwa.addFig());
		btnAdd.setBounds(10, 239, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(e -> kanwa.animate());
		btnAnimate.setBounds(100, 239, 80, 23);
		contentPane.add(btnAnimate);

		JButton btnColor = new JButton("AddColor (0-255)");
		btnColor.setBounds(190, 239, 130, 23);

		contentPane.add(btnColor);

		NumberFormat format = NumberFormat.getInstance();

		NumberFormatter color = new NumberFormatter(format);
		color.setValueClass(Integer.class);
		color.setMaximum(255);
		color.setAllowsInvalid(false);

		JFormattedTextField txtRed = new JFormattedTextField(color);
		JFormattedTextField txtGreen  = new JFormattedTextField(color);
		JFormattedTextField txtBlue = new JFormattedTextField(color);

		txtRed.setBackground(Color.red);
		txtBlue.setBackground(Color.blue);
		txtGreen.setBackground(Color.green);

		txtRed.setBounds(330, 239, 30, 23);
		txtGreen.setBounds(370, 239, 30, 23);
		txtBlue.setBounds(410, 239, 30, 23);

		btnColor.addActionListener(e -> kanwa.colorSet(getColor(txtRed), getColor(txtGreen), getColor(txtBlue)));

		txtBlue.setForeground(Color.white);

		contentPane.add(txtRed);
		contentPane.add(txtGreen);
		contentPane.add(txtBlue);


	}
//getter zwróci 0, jeśli zawartość pola będzie mniejsza od 0 lub pusta, 255 jeśli większa
	public int getColor(JFormattedTextField x) {
		if (x.getText().isEmpty()) return 0;
		if (Integer.parseInt(x.getText()) > 255) return 255;
		if (Integer.parseInt(x.getText()) < 0) return 0;
		return Integer.parseInt(x.getText());
	}

}
