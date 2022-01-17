package figury;

import swingUtil.SwingFactory;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AnimPanel kanwa;

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
		int ww = 600, wh = 500;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);

		kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, ww - 35, wh*3/5);




		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		animFrameInit();
		
	}

	private void animFrameInit(){



		JButton btnAdd = SwingFactory.createButton("Add", 100, 23);
		btnAdd.setLocation(10, kanwa.getY() + kanwa.getHeight() + 5);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});

		JButton btnAnimate = SwingFactory.createButton("Animate", 100, 23);
		btnAnimate.setLocation(btnAdd.getX() + btnAdd.getWidth() + 10, kanwa.getY() + kanwa.getHeight() + 5);
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});

		JButton btnColor = SwingFactory.createButton("Pick color", 100, 23);
		JPanel colorSquare = new JPanel();
		JSlider alphaSlider = SwingFactory.createSlider(1, 255, 255);
		JLabel alphaVal = new JLabel("Alpha: " + kanwa.getAlpha());
		JSlider delaySlider = SwingFactory.createSlider(10,200,70);
		JLabel delayVal = new JLabel("Delay: " + kanwa.getDelay());

		JButton deleteLast = SwingFactory.createButton("Delete last",100,23);
		deleteLast.setLocation(kanwa.getX()+kanwa.getWidth()-deleteLast.getWidth(),btnAdd.getY());
		deleteLast.addActionListener(e ->{
			kanwa.killLast();
		});

		btnColor.setLocation(btnAdd.getX(), btnAdd.getY()+btnAdd.getHeight()+5);
		colorSquare.setBounds((int)(btnColor.getX() + btnColor.getWidth() * 1.25 + 5), btnColor.getY(), btnColor.getWidth()*3/5, btnColor.getHeight());
		colorSquare.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		colorSquare.setOpaque(false);
		colorSquare.setBackground(kanwa.getColor());
		btnColor.addActionListener(
				e -> {
					Color color = JColorChooser.showDialog(null,"Choose color", Color.BLACK);
					if (color != null) {
						kanwa.setColor(color);
						colorSquare.setBackground(color);
					}
				});

		btnColor.setEnabled(false);
		colorSquare.setOpaque(false);
		colorSquare.setBackground(null);

		JCheckBox randomColor = SwingFactory.createCheckbox(colorSquare.getX()+colorSquare.getWidth() + 20,colorSquare.getY()+colorSquare.getHeight()/2 - 8, 120,15, true, "Random color");
		randomColor.addItemListener(e -> {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				kanwa.setColRandom(true);
				btnColor.setEnabled(false);
				colorSquare.setOpaque(false);
				colorSquare.setBackground(null);
			}
			else {
				kanwa.setColRandom(false);
				btnColor.setEnabled(true);
				colorSquare.setOpaque(true);
				colorSquare.setBackground(kanwa.getColor());
			}
		});


		alphaSlider.setLocation(btnColor.getX(), btnColor.getY() + btnColor.getHeight() + 5);
		alphaSlider.addChangeListener(
				e ->{
					kanwa.setAlpha(alphaSlider.getValue());
					alphaVal.setText("Alpha : " + kanwa.getAlpha());
					alphaVal.setBounds(alphaSlider.getX() + alphaSlider.getWidth() + 5,alphaSlider.getY()+(alphaSlider.getHeight()/2) - (alphaVal.getHeight()/2), (int)alphaVal.getPreferredSize().getWidth(), (int)alphaVal.getPreferredSize().getHeight());
				});

		delaySlider.setLocation(alphaSlider.getX(), alphaSlider.getY()+alphaSlider.getHeight()-10);
		delaySlider.addChangeListener(
				e->{
					kanwa.setDelay(delaySlider.getValue());
					delayVal.setText("Delay: " + kanwa.getDelay());
					delayVal.setBounds(delaySlider.getX() + delaySlider.getWidth() + 5,delaySlider.getY()+(delaySlider.getHeight()/2) - (delayVal.getHeight()/2),(int)delayVal.getPreferredSize().getWidth(), (int)delayVal.getPreferredSize().getHeight());
				});

		alphaVal.setBounds(0,0, (int)alphaVal.getPreferredSize().getWidth(), (int)alphaVal.getPreferredSize().getHeight());
		alphaVal.setBounds(alphaSlider.getX() + alphaSlider.getWidth() + 5,alphaSlider.getY()+(alphaSlider.getHeight()/2) - (alphaVal.getHeight()/2), alphaVal.getWidth(), alphaVal.getHeight());

		delayVal.setBounds(0,0,(int)delayVal.getPreferredSize().getWidth(), (int)delayVal.getPreferredSize().getHeight());
		delayVal.setLocation(delaySlider.getX() + delaySlider.getWidth() + 5,delaySlider.getY()+(delaySlider.getHeight()/2) - (delayVal.getHeight()/2));


		contentPane.add(delaySlider);
		contentPane.add(delayVal);
		contentPane.add(alphaVal);
		contentPane.add(btnAdd);
		contentPane.add(btnAnimate);
		contentPane.add(btnColor);
		contentPane.add(alphaSlider);
		contentPane.add(randomColor);
		contentPane.add(colorSquare);
		contentPane.add(deleteLast);
	}


}
