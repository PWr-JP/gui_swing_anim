package figury;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Soul  implements KeyListener, ActionListener, Runnable {

    private int width, height;

    public Soul (Graphics2D buffer, int delay, int width, int heigth){
        this.width = width;
        this.height= heigth;

        addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char znak = e.getKeyChar();

        switch (znak){
            case 'd':
             // dx+=5;
                break;

            case 'a':
          //  dx-=5;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
