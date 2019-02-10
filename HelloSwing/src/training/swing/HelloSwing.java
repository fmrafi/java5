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
public class HelloSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //frame.setBounds(new Rectangle(640, 480));
        frame.setTitle("Hello Swing!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initComponents(frame);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void initComponents(JFrame frame) {
        frame.add(new JLabel("Hello Swing World!"));
    }
}
