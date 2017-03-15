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
public class PointOfSaleStartup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReceiptDataAccessStrategy dataBase = new InMemoryDataAccess();
        OutputStrategy guiOutput = new GuiOutput();
        OutputStrategy consoleOutput = new ConsoleOutput();
        PointOfSaleTerminal posTerminal = new PointOfSaleTerminal(guiOutput, consoleOutput);
        
        posTerminal.startSale(dataBase);
        posTerminal.addItemToSale("A101", 5);
        posTerminal.addItemToSale("B205", 2);
        posTerminal.processPayment("100");
        posTerminal.closeSale();
    }
    
}
