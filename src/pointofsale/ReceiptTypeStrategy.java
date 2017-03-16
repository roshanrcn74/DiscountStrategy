/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

/**
 *
 * @author roshann
 */
public interface ReceiptTypeStrategy {
    
    public abstract String getReceipt(); 
    public abstract String getReceiptToDisplay(); 
    public abstract void doTransaction(String customerID); 
    public abstract void addLineItem(String productID, double qty);
    public abstract String [] getMessage();
    public abstract void setMessage(String [] message);
    
}
