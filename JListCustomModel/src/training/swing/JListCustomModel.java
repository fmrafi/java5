package training.swing;

import java.awt.*;
import javax.swing.*;

/** Simple JList example illustrating the use of a custom
 *  ListModel (JavaLocationListModel).
 *  1998-99 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */
public class JListCustomModel extends JFrame {

    public static void main(String[] args) {
        new JListCustomModel();
    }

    public JListCustomModel() {
        super("JList with a Custom Data Model");
//    WindowUtilities.setNativeLookAndFeel();
//    addWindowListener(new ExitListener());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();

        JavaLocationCollection collection = new JavaLocationCollection();
        JavaLocationListModel listModel = new JavaLocationListModel(collection);
        JList sampleJList = new JList(listModel);
        Font displayFont = new Font("Serif", Font.BOLD, 18);
        sampleJList.setFont(displayFont);
        content.add(sampleJList);

        pack();
        setVisible(true);
    }
}
