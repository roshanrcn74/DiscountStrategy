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
public final class PointOfSaleTerminal {
    private ReceiptTypeStrategy receipt;
    private OutputStrategy consoleOutput;
    private OutputStrategy guiOutput;
    
    
    
    PointOfSaleTerminal(OutputStrategy guiOutput, OutputStrategy consoleOutput, ReceiptTypeStrategy receiptType){
        setConsoleOutput(consoleOutput);
        setGuiOutput(guiOutput);
        setReceipt(receiptType);
    }
    
    public void startSale(){
        guiOutput.outPut(receipt.getReceiptToDisplay());
    }

    public final void addItemToSale(String productID, double qty) {
        receipt.addLineItem(productID, qty);
        displayOnScreen();
    }

    private void displayOnScreen() {
        guiOutput.outPut(receipt.getReceiptToDisplay());
        
    }

    public void processPayment(String customerID) {
        receipt.doTransaction(customerID);
    }
    
    
    public final void closeSale() {
        consoleOutput.outPut(receipt.getReceipt());
        
    } 

    public void setConsoleOutput(OutputStrategy consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    public void setGuiOutput(OutputStrategy guiOutput) {
        this.guiOutput = guiOutput;
    }
    
    public void setReceipt(ReceiptTypeStrategy receipt ){
        if (receipt == null){
            
        }
        this.receipt = receipt;
    }
    
}
