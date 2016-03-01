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
public class Register {

    private Receipt receipt;
    private String storeName = "JC Penny";

    public final void startNewSale(String custId, DatabaseStrategy db, String storeName) {
        receipt = new Receipt(custId, db, this.storeName);
    }

    public final void endSale() {

    }

    public final void addItemToSale(String prodId, int qty) {
        receipt.addItemToReceipt(prodId, qty);
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        // Needs validation
        this.receipt = receipt;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        // Needs validation
        this.storeName = storeName;
    }

}
