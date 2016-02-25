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
public class Receipt {

    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;

    public Receipt(String custId, DatabaseStrategy db) {
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }

    public final void addItemToReceipt(String prodId, int qty) {
        LineItem item = new LineItem(prodId, qty, db);
        
        addItemToArray(lineItems, item);
//        LineItem[] tempArray = new LineItem[lineItems.length + 1];
//
//        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
//        tempArray[tempArray.length - 1] = item;
//        lineItems = tempArray;
    }

    private void addItemToArray(LineItem[] origArray, LineItem item) {
        LineItem[] tempArray = new LineItem[origArray.length + 1];

        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length - 1] = item;
        origArray = tempArray;
        lineItems = origArray;
    }

    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db) {
        // Needs validation
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        // Needs validation
        this.customer = customer;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
    

}
