package figury;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static int selection;
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
     *
     * @param delay
     */
    public AnimatorApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int ww = 450, wh = 300;
        setBounds((screen.width - ww) / 2, (screen.height - wh) / 2, ww, wh);
        setBackground(Color.WHITE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 11));

        AnimPanel kanwa = new AnimPanel();
        kanwa.setPreferredSize(new Dimension(422, 219));
        contentPane.add(kanwa, BorderLayout.NORTH);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                kanwa.initialize();
            }
        });

        JPanel buttons = new JPanel();

        JComboBox choice = null;
        String[] fg = {"Figury", "Kwadrat", "Elipsa"};
        choice = new JComboBox(fg);
        choice.setBounds(1, 239, 80, 23);
        choice.setSelectedIndex(0);
        JComboBox finalChoice = choice;
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selection = finalChoice.getSelectedIndex();
            }
        });
        buttons.add(choice);


        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.addFig();
            }
        });
        btnAdd.setBounds(100, 239, 80, 23);
        buttons.add(btnAdd);

        JButton btnAnimate = new JButton("Animate");
        btnAnimate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.animate();
            }
        });
        btnAnimate.setBounds(100, 239, 80, 23);
        buttons.add(btnAnimate);

        contentPane.add(buttons, BorderLayout.SOUTH);
        this.pack();
    }

}
