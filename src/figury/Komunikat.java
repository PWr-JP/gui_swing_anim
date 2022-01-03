package figury;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Komunikat extends JPanel {

    public Komunikat(String tresc){
        setBorder(new LineBorder(new Color(9, 92, 225), 4, true));
        setLayout(null);

        JTextArea komunikat = new JTextArea();
        komunikat.setText(tresc);
        komunikat.setBounds(7,10,500,40);
        komunikat.setBackground(null);
        this.add(komunikat);

    }

}
