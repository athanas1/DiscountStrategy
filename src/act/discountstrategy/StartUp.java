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
// To do on Mid Term  Validation, Java doc writeup's, NO MAGIC NUMBERS, Open Close principal
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
        register.startNewSale("100", db, "JC Penny");

        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);

        register.endSale(gui);
        register.endSale(COutput);
    }

}
