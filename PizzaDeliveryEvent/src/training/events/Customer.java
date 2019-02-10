/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.events;

import java.util.Random;

/**
 *
 * @author Tanvir
 */
public class Customer implements OrderListener, Runnable {

    private int myNumber;
    private Random myRandom;
    private Thread myThread;
    
    private Bakery bakery;
    private boolean haveSlice;
    private int sliceNumber;
    
    public Customer(int aNumber, Bakery bakery) {
        myNumber = aNumber;
        myRandom = new Random(myNumber);
        this.bakery = bakery;
        haveSlice = false;
        myThread = new Thread(this);
        myThread.start();
    }
    
    @Override
    public void pizzaReady(PizzaEvent anEvent) {
        if (!haveSlice) {
            haveSlice = true;
            sliceNumber++;
            System.out.println("Customer [" + myNumber + "] has slice " + sliceNumber);
            myThread.resume();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (haveSlice) {
                for (int bites=0; bites<4; bites++) {
                    System.out.println("Customer [" + myNumber + "] bite " + bites + " slice " + sliceNumber);
                    try {
                        long timeout = myRandom.nextLong() % 1000;
                        if (timeout < 0) timeout *= -1;
                        Thread.sleep(timeout);
                    } catch (InterruptedException ex) {
                        // noop
                    }
                }
                synchronized(this) {
                    haveSlice = false;
                }
                myThread.suspend();
            }
        }
    }
    
}
