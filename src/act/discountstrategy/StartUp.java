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
        ConsoleOutput COutput = new ConsoleOutput();
        GuiOutput gui = new GuiOutput();

        // Start talking to objects
        Register register = new Register();
        register.startNewSale("100", db,"JC Penny");

        Customer customer = register.getReceipt().getCustomer();
        System.out.println("Customer " + customer.getCustName() + " found and added to receipt");
        
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
        
     register.endSale(gui);
     register.endSale(COutput);
    }

}
