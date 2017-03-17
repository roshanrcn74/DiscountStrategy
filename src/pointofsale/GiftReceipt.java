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
public class GiftReceipt implements ReceiptTypeStrategy{
    
    private Customer customer;
    private ReceiptDataAccessStrategy dataBase;
    private LineItem[] lineItems;
    private String [] messages;
    private String reciptNum;

    public GiftReceipt(ReceiptDataAccessStrategy db, String [] messages, String receiptNumber) {
       setDataBase(db);    
       lineItems = new LineItem[0];
       setMessage(messages);
       setReciptNum(receiptNumber);
    }

    @Override
    public final String getReceipt() {
        String receipt = this.messages[1] + "\n\n";
        receipt += "Sold to : " + (this.customer == null ? "New Customer" : this.customer.getName()) + "\n\n";
        receipt += "Receipt No : " + this.reciptNum + "\n\n";
        
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getProduct().getProductId() + "  " + 
                    lineItem.getProduct().getProductName() + "\n";
        }
        return receipt;
    }
    
    @Override
    public final String getReceiptToDisplay() {
        String receipt = this.messages[0] + "\n\n";
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getLineItem() + "\n";
        }
        return receipt;
        
    }

    /**
     * @param customerID
     */
    @Override
    public final void doTransaction(String customerID) {
        setCustomer(this.dataBase.findCustomer(customerID));
    }

    @Override
    public final void addLineItem(String productID, double qty) {
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

    public final void setDataBase(ReceiptDataAccessStrategy dataBase) {
        this.dataBase = dataBase;
    }

    public final void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }

    public final void setCustomer(Customer customer) {
        this.customer = customer;
    }   
    
    @Override
    public final String[] getMessage() {
        return messages;
    }

    @Override
    public final void setMessage(String[] messages) {
        if (messages != null && messages.length != 0){
            this.messages = messages;
        }   
    }

    public final String getReciptNum() {
        return reciptNum;
    }

    public final void setReciptNum(String reciptNum) {
        if (reciptNum == null || reciptNum.isEmpty()){
            
        }
        this.reciptNum = reciptNum;
    }
    
}
