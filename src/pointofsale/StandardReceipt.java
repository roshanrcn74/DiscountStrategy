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
    private String [] messages;
    private String reciptNum;
    

    public StandardReceipt(ReceiptDataAccessStrategy dataBase, String [] messages, String receiptNumber) {
       setDataBase(dataBase);    
       lineItems = new LineItem[0];
       setMessage(messages);
       setReciptNum(receiptNumber);
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
        
        String receipt = this.messages[1] + "\n\n";
        receipt += "Sold to " + (this.customer.getName() == null ? "New Customer" : this.customer.getName()) + "\n\n";
        receipt += "Receipt No : " + this.reciptNum + "\n\n";
        receipt += "ID  Item            Price   Qty Subtotal    Discount \n";
        receipt += "---------------------------------------------------- \n";
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getLineItem() + "\n";
        }
        receipt += "\n" + "Net Total : " + getSubTotalSale() + "\n";
        receipt += "Total Save : " + getTotalDiscountSale() + "\n";
        receipt += "Total Due : " + getTotalDueSale() + "\n";
        return receipt;
    }

    @Override
    public String getReceiptToDisplay() {
        String receipt = this.messages[0] + "\n\n";
        receipt += "ID  Item            Price   Qty Subtotal    Discount \n";
        receipt += "---------------------------------------------------- \n";
        for (LineItem lineItem : this.lineItems){
            receipt += lineItem.getLineItem() + "\n";
        }
        receipt += "---------------------------------------------------- \n";
        receipt += "\n" + "Net Total : " + getSubTotalSale() + "\n";
        receipt += "Total Save " + getTotalDiscountSale() + "\n";
        receipt += "Total Due " + getTotalDueSale() + "\n";
        return receipt;       
    }
    private double getSubTotalSale(){
        double subTotal = 0.0;
        for (LineItem lineItem : this.lineItems){
            subTotal += lineItem.getProduct().getPrice() * lineItem.getQuantity();
        }
        return subTotal;
    }
    
    private double getTotalDiscountSale(){
        double totalDiscount = 0.0;
        for (LineItem lineItem : this.lineItems){
            totalDiscount += lineItem.getProduct().getPrice() * 
                    lineItem.getQuantity() * 
                    lineItem.getProduct().getProductDiscount().getDiscount(lineItem.getQuantity());
        }
        return totalDiscount;
    }
    
    private double getTotalDueSale(){
        return (getSubTotalSale() - getTotalDiscountSale());
    }

    @Override
    public String[] getMessage() {
        return messages;
    }

    @Override
    public final void setMessage(String[] messages) {
        if (messages != null && messages.length != 0){
            this.messages = messages;
        }
    }

    public final void setReciptNum(String reciptNum) {
        if (reciptNum == null || reciptNum.isEmpty()){
            
        }
        this.reciptNum = reciptNum;
    }
}
