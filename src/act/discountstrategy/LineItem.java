/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act.discountstrategy;

/**
 *
 * @author Alex
 */
public class LineItem {
    private Product product;
    private int qty;

    public LineItem(Product product, int qty) {
        setProduct(product);
        setQty(qty);
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
