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
public class Customer {

    private String custId;
    private String custName;

    public Customer(String custId, String custName) {
        setCustId(custId);
        setCustName(custName);
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String CustId) {
        //Needs validation
        this.custId = CustId;
    }

    public final String getCustName() {
        return custName;
    }

    public final void setCustName(String CustName) {
        // Needs Validation
        this.custName = CustName;
    }

}
