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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String priductId) {
        this.productId = priductId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DiscountStrategy getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(DiscountStrategy productDiscount) {
        this.productDiscount = productDiscount;
    }
    
}