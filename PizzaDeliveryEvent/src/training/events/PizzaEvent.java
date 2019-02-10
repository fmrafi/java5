/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.events;

import java.util.EventObject;

/**
 *
 * @author Tanvir
 */
public class PizzaEvent extends EventObject {
    
    public PizzaEvent(Object aSource) {
        super(aSource);
    }
}
