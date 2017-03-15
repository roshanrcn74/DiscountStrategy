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
public final class LineItem {
    
    private Product product;
    private double quantity;
   

    public LineItem(String productID, double quantity, ReceiptDataAccessStrategy dataBase) {
        setProduct(findProduct(productID, dataBase));
        setQuantity(quantity);
    }
    
    private Product findProduct(String prodID, ReceiptDataAccessStrategy dataBase){
        
        return dataBase.findProduct(prodID);
    }
    
    public String getLineItem(){
        String lineItem = "";
        lineItem += product.getProductId() + "   " + product.getProductName() 
                + "   " + product.getPrice() + "  " + product.getProductDiscount() 
                + "  " + (product.getPrice() * product.getProductDiscount().applyDiscount(quantity)) ;
                
        return lineItem;
    }

    public Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if (product == null){
           throw new IllegalArgumentException("Please initialize the object"); 
        }
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public final void setQuantity(double quantity) {
        if (quantity <= 0){
            
        }
        this.quantity = quantity;
    }  

}
