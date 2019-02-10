/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.swing;

import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Tanvir
 */
public class HelloSwingFrame extends JFrame {
    
    public HelloSwingFrame() {
        initComponents();
    }

    private void initComponents() {
        add(new JLabel("Hello Swing World!"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HelloSwingFrame frame = new HelloSwingFrame();
        frame.setBounds(new Rectangle(640, 480));
        frame.setTitle("Hello Swing!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
