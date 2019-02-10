/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.events;

/**
 *
 * @author Tanvir
 */
public class PizzaDeliveryApp {

    public PizzaDeliveryApp() {
        Bakery b = new Bakery();
        Customer c1 = new Customer(1, b);
        b.addOrderListener(c1);
        Customer c2 = new Customer(2, b);
        b.addOrderListener(c2);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PizzaDeliveryApp app = new PizzaDeliveryApp();
    }
}
