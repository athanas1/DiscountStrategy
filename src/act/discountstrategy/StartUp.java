/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.discountstrategy;

/**
 *
 * @author athanas1
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // KLUDGE: do configuration here 
        DatabaseStrategy db = new FakeDatabase();

        // Start talking to objects
        Register register = new Register();
        register.startNewSale("100", db);

        Customer customer = register.getReceipt().getCustomer();
        System.out.println("Customer " + customer.getCustName() + " found and added to receipt");
        
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
        
        LineItem[] items = register.getReceipt().getLineItems();
        for(LineItem item : items) {
            System.out.println(item.getProduct().getProdName());
        }
    }

}
