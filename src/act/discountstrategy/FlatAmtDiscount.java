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
public class FlatAmtDiscount implements DiscountStrategy {
    private double discountRate;
    
    public FlatAmtDiscount(double discountRate){
        setDiscountRate(discountRate);
    }
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        //Needs validation
        return discountRate;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        // Needs validation
        this.discountRate = discountRate;
    }
    
}
