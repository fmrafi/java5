/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.util.ListResourceBundle;

/**
 *
 * @author Tanvir
 */
public class messages extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
        { "welcome", "How are you?" },
        { "goodbye", "Goodbye." },
    };
}
