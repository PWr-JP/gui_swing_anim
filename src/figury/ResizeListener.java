package figury;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ResizeListener extends ComponentAdapter {


    public void componentResized(ComponentEvent e){
        Component mainComponent = e.getComponent();
        ContentPanel contentPanel = (ContentPanel) e.getComponent();
        int width = mainComponent.getWidth();
        int height = mainComponent.getHeight();

        contentPanel.getAnimPanel().setBounds(10,11,width,height-40);

        contentPanel.getBtnAdd().setBounds(10, contentPanel.getAnimPanel().getHeight()+13, 80, 25);
        contentPanel.getBtnAnimate().setBounds(contentPanel.getBtnAdd().getWidth()+20,contentPanel.getAnimPanel().getHeight()+13,80,25);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                contentPanel.getAnimPanel().initialize();
            }
        });

    }
}
