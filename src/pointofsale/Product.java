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
public final class Product {
    private String productName;
    private String productId;
    private double price;
    private DiscountStrategy productDiscount;

    public Product(String priductId, String productName, double price, DiscountStrategy prodDiscount) {
        setProductName(productName);
        setProductId(priductId);
        setPrice(price);
        setProductDiscount(prodDiscount);
        
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String priductId) {
        this.productId = priductId;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    public final DiscountStrategy getProductDiscount() {
        return productDiscount;
    }

    public final void setProductDiscount(DiscountStrategy productDiscount) {
        this.productDiscount = productDiscount;
    }
    
}