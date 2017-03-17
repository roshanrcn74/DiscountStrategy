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
    
    //Output goes to printer ot email 
    @Override
    public String getReceipt() {
        String separator = "----------------------------------------------------------------------- \n";
        
        String receipt = this.messages[1] + "\n\n";
        receipt += "Sold to " + (this.customer == null ? "New Customer" : this.customer.getName()) + "\n\n";
        receipt += "Receipt No : " + this.reciptNum + "\n\n";
        receipt += getItemsHeaders();
        receipt += separator;
        receipt += getReceiptBody() + "\n";

        receipt += separator;
        receipt += getReceiptFooter();
        
        return receipt;
    }
    //Output goes to display units like monitor or gui display
    @Override
    public String getReceiptToDisplay() {
        String separator = "----------------------------------------------------------------------- \n";

        String receipt = this.messages[0] + "\n\n";
        receipt += getItemsHeaders();
        receipt += separator;
        receipt += getReceiptBody() + "\n";

        receipt += separator;
        receipt += getReceiptFooter();
        
        return receipt;       
    }
    private String getItemsHeaders(){    
        return String.format("%1$-7s %2$-22s %3$-13s %4$-5s %5$-10s %6$-8s", "ID", "Item", "Price", "Qty", "SubTotal", "Discount \n");
    }
    
    private String getReceiptBody(){
        String receiptBody = "";
                for (LineItem lineItem : this.lineItems){
            receiptBody += String.format("%1$s %2$8s %3$8s", lineItem.getLineItem(), 
                    String.format("%1$.2f",(lineItem.getQuantity() * lineItem.getProduct().getPrice())), 
                    String.format("%1$.2f", lineItem.getProduct().getProductDiscount().getDiscount(lineItem.getQuantity()))) + "\n";
        }
        return receiptBody;
    }
    
    private String getReceiptFooter(){
        String receiptFooter = "";
        String subTotal =String.format("%1$.2f",getSubTotalSale()) + "\n";
        String totalSave = String.format("%1$.2f",getTotalDiscountSale()) + "\n";
        String totalDue = String.format("%1$.2f",getTotalDueSale()) + "\n";
        receiptFooter += String.format("Net Total : %1$10sTotal Save : %2$10sTotal Due : %3$10s",
                subTotal, totalSave, totalDue);
        
        return receiptFooter;
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
