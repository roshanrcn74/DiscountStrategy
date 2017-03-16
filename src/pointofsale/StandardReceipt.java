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
public class StandardReceipt implements ReceiptTypeStrategy {
    
    private Customer customer;
    private ReceiptDataAccessStrategy dataBase;
    private LineItem[] lineItems;
    private String [] message;
    

    public StandardReceipt(ReceiptDataAccessStrategy dataBase, String [] messages) {
       setDataBase(dataBase);    
       lineItems = new LineItem[0];
       setMessage(message);
    }
    
    @Override
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

    @Override
    public final void doTransaction(String customerID) {
        setCustomer(this.dataBase.findCustomer(customerID));
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }
    
    @Override
    public String getReceipt() {
        
        String receipt = this.message[1] + "\n\n";
        receipt += "Sold to " + (this.customer.getName() == null ? "New Customer" : this.customer.getName()) + "\n\n";
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getLineItem() + "\n";
        }
        return receipt;
    }

    @Override
    public String getReceiptToDisplay() {
        String receipt = this.message[0] + "\n\n";
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getLineItem() + "\n";
        }
        return receipt;       
    }

    @Override
    public String[] getMessage() {
        return message;
    }

    @Override
    public void setMessage(String[] message) {
        if (message != null && message.length != 0){
            this.message = message;
        }
    }
    
    
}
