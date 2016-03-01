/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.discountstrategy;

import java.text.NumberFormat;
/**
 *
 * @author Alex
 */
public class LineItem {

    private Product product;
    private int qty;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    private double[] subtotals;
    
    
    public LineItem(String prodId, int qty, DatabaseStrategy db) {
        this.qty = qty;
        setProduct(db.findProductById(prodId));
        getSubTotal();
    }
    
    public String getLineItem(){
        String item = this.getProduct().getProdId() + " " + this.getProduct().getProdName() + " " + this.getQty();
        return item;
    }
    public final double getSubTotal(){
        return qty * product.getUnitCost();
    }
    
    public final double getDiscountAmount(){
        return product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
    }
    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //needs validation
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        // needs validation
        this.qty = qty;
    }


}
