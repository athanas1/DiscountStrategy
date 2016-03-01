/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.discountstrategy;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author athanas1
 */
public class Receipt {
    private LineItem lineItem;
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private String storeName;
    private double total;
    private final Date date = Calendar.getInstance().getTime();

    public Receipt(String custId, DatabaseStrategy db, String storeName) {
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        setStoreName(storeName);
        lineItems = new LineItem[0];
    }

    // adding item to the receipt
    public final void addItemToReceipt(String prodId, int qty) {
        LineItem item = new LineItem(prodId, qty, db);

        addItemToArray(lineItems, item);
//        LineItem[] tempArray = new LineItem[lineItems.length + 1];
//
//        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
//        tempArray[tempArray.length - 1] = item;
//        lineItems = tempArray;
    }

    // adding item to the array
    private void addItemToArray(LineItem[] origArray, LineItem item) {
        LineItem[] tempArray = new LineItem[origArray.length + 1];

        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length - 1] = item;
        origArray = tempArray;
        lineItems = origArray;
    }
// using StringBuilder to create what the Receipt will output as

    public final String getReceiptData() {
        
        double receiptTotal = getSubTotal();
        double discountTotal = getAmountSaved();
        double grandTotal = getTotal();
        StringBuilder sBuilder;
        sBuilder = new StringBuilder(storeName + "\n" + customer.getCustName() + "\n" + date + "\n");
        LineItem[] items = getLineItems();
        for (LineItem i : items) {
            sBuilder.append(i.getLineItem());
        }
        sBuilder.append("\n");
        sBuilder.append("Total before: ").append(nf.format(getSubTotal()));
        sBuilder.append("\n");
        sBuilder.append("You saved: ").append(nf.format(discountTotal));
        sBuilder.append("\n");
        sBuilder.append("Your grand total is: ").append(nf.format(grandTotal));

        String BuildertoString = sBuilder.toString();
        return BuildertoString;
    }

    public final DatabaseStrategy getDb() {
        return db;
    }
// needs to be validated

    public final void setDb(DatabaseStrategy db) {
        // Needs validation
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }
// needs to be validated

    public final void setCustomer(Customer customer) {
        // Needs validation
        this.customer = customer;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }
// needs to be validated

    public void setLineItems(LineItem[] lineItems) {
        // needs validation
        this.lineItems = lineItems;
    }

    public String getStoreName() {
        return storeName;
    }
// needs to be validated

    public void setStoreName(String storeName) {
        //needs validation
        this.storeName = storeName;
    }

    public final double getAmountSaved() {
        total = 0.0;
        for (LineItem item : lineItems) {
            total += item.getDiscountAmount();
        }
        return total;
    }

    public Date getDate() {
        return date;
    }

    public final double getSubTotal() {
        total = 0.0;
        for (LineItem i : lineItems) {
            total += i.getSubTotal();
        }
        return total;
    }

    public final double getTotal() {
        return getSubTotal() - getAmountSaved();
    }
}
