/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.events;

import java.util.EventListener;

/**
 *
 * @author Tanvir
 */
public interface OrderListener extends EventListener {
    public void pizzaReady(PizzaEvent anEvent);
}
