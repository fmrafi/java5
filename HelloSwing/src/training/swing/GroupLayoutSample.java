/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.swing;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Tanvir
 */
public class GroupLayoutSample extends JFrame {
    
    public GroupLayoutSample() {     
        initComponents();
        //setUndecorated(true);
    }
    
    private void initComponents() {
        JLabel label1 = new JLabel("Label 1");
        JTextField tf1 = new JTextField("Text Field 1");
        JLabel label2 = new JLabel("Label 2");
        JTextField tf2 = new JTextField("Text Field 2");
        
        GroupLayout layout = new GroupLayout(this.getContentPane());
        setLayout(layout);

        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Turn on automatically creating gaps between components that touch
        // the edge of the container and the container.
        layout.setAutoCreateContainerGaps(true);

        // Create a sequential group for the horizontal axis.

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The sequential group in turn contains two parallel groups.
        // One parallel group contains the labels, the other the text fields.
        // Putting the labels in a parallel group along the horizontal axis
        // positions them at the same x location.
        //
        // Variable indentation is used to reinforce the level of grouping.
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(label1).addComponent(label2));
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(tf1).addComponent(tf2));
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // The sequential group contains two parallel groups that align
        // the contents along the baseline. The first parallel group contains
        // the first label and text field, and the second parallel group contains
        // the second label and text field. By using a sequential group
        // the labels and text fields are positioned vertically after one another.
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                addComponent(label1).addComponent(tf1));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                addComponent(label2).addComponent(tf2));
        layout.setVerticalGroup(vGroup);
    }
    
    public static void main(String[] args) {
        GroupLayoutSample window = new GroupLayoutSample();
        window.setTitle("GroupLayout Sample");
        window.pack();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
