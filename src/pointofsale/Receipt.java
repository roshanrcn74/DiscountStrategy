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
public class Receipt {
    
    private Customer customer;
    private ReceiptDataAccessStrategy dataBase;
    private LineItem[] lineItems;

    public Receipt(ReceiptDataAccessStrategy dataBase) {
       setDataBase(dataBase);    
       lineItems = new LineItem[0];
    }
    
    public void addLineItem(String productID, double qty) {
        LineItem lineItem = new LineItem(productID, qty, dataBase);
        addLineItemsToArray(lineItem);   
    }
    
    private void addLineItemsToArray(LineItem lineItem){
        LineItem[] temp = new LineItem[this.lineItems.length + 1];
        int i = 0;
        for (LineItem lineItem1 : this.lineItems) {
            temp[i] = lineItem1;
            i++;
        }
        temp[i] = lineItem;
        
        setLineItems(temp);
        temp = null;
    }

    public final void setLineItems(LineItem[] lineItems) {
        if (lineItems == null){
            
        }
        this.lineItems = lineItems;    
    }

    public Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        if (customer == null){
            
        }
        this.customer = customer;
    }

    public final ReceiptDataAccessStrategy getDataBase() {
        return dataBase;
    }

    public final void setDataBase(ReceiptDataAccessStrategy dataBase) {
        this.dataBase = dataBase;
    }

    public final void doTransaction(String customerID) {
        setCustomer(this.dataBase.findCustomer(customerID));
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }
    
    

    public String getReceipt() {
        String receipt = "";
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getLineItem() + "\n";
        }
        return receipt;
    }
}
