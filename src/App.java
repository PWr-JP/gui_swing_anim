/*
 * Original author : tb
 * Fork: koxx4
 */

import gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
				try {
					final MainFrame mainFrame = new MainFrame(400,300);
					mainFrame.setVisible(true);
				} catch (HeadlessException e) {
					e.printStackTrace();
				}
		});
	}
}
