package swingUtil;

import javax.swing.*;
import java.awt.*;

public class SwingFactory {
    /*=================================================*/
    /*                                                 */
    /* Static class created for ease of use of Swing   */
    /* elements.                                       */
    /*                                                 */
    /*=================================================*/
    public static JFrame createFrame(String title){
        JFrame frame = new JFrame(title);


        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setResizable(false);


        frame.setVisible(true);
        return frame;
    }

    public static JFrame createFrame(String title, Boolean isResizable){
        JFrame frame = createFrame(title);
        frame.setResizable(isResizable);

        return frame;
    }

    public static JButton createButton(String text){
        return createButton(text,200, 70);
    }

    public static JButton createButton(String text,int nWidth, int nHeight){
        JButton button = new JButton();

        button.setText(text);
        button.setFocusable(false);
        button.setBounds(0, 0, nWidth, nHeight);

        return button;
    }

    public static JSlider createSlider(int minVal, int maxVal, int defVal){
        JSlider slider = new JSlider(minVal, maxVal, defVal);

        slider.setFocusable(false);
        slider.setSize(200, 50);

        return slider;
    }

    public static JSlider createSlider(int minVal, int maxVal, int defVal, int nWidth, int nHeight){
        JSlider slider = createSlider(minVal, maxVal, defVal);

        slider.setSize(nWidth, nHeight);

        return slider;
    }

    public static JCheckBox createCheckbox(int nPosX, int nPosY, int nWidth, int nHeight, boolean isOn, String text){
        JCheckBox temp = new JCheckBox(text, isOn);
        temp.setBounds(nPosX,nPosY,nWidth,nHeight);
        temp.setFocusable(false);

        return temp;
    }
}
