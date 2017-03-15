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
    private Receipt receipt;
    private OutputStrategy consoleOutput;
    private OutputStrategy guiOutput;
    
    
    
    PointOfSaleTerminal(OutputStrategy guiOutput, OutputStrategy consoleOutput){
        setConsoleOutput(consoleOutput);
        setGuiOutput(guiOutput);
    }
    
    public void startSale(ReceiptDataAccessStrategy dataBase){
        receipt = new Receipt(dataBase);
    }

    public final void addItemToSale(String productID, double qty) {
        receipt.addLineItem(productID, qty);
        displayOnScreen();
    }

    private final void displayOnScreen() {
        guiOutput.outPut(receipt.getReceipt());
        
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
    
    
}
