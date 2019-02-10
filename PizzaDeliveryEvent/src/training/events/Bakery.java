/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.events;

import java.util.Vector;

/**
 *
 * @author Tanvir
 */
public class Bakery implements Runnable {

    private Vector myCustomers = new Vector();
    private Thread myThread;
    
    public Bakery() {
        myThread = new Thread(this);
        myThread.start();
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                myThread.sleep(4000);
                PizzaEvent event = new PizzaEvent(this);
                sendMessage(event);
            }
        } catch (InterruptedException ex) {
            // noop
        }
    }
    
    public synchronized void addOrderListener(OrderListener aListener) {
        myCustomers.addElement(aListener);
    }
    
    public synchronized void removeOrderListener(OrderListener aListener) {
        myCustomers.removeElement(aListener);
    }
    
    private void sendMessage(PizzaEvent anEvent) {
        Vector v;
        // copy list of customers
        synchronized(this) {
            v = (Vector) myCustomers.clone();
        }
        // notify
        for (int i=0; i<v.size(); i++) {
            OrderListener ol = (OrderListener)v.elementAt(i);
            ol.pizzaReady(anEvent);
        }
        System.out.println("Pizza ready...");
        Thread.yield();
    }
}
