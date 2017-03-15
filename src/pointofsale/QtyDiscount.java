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
public class QtyDiscount implements DiscountStrategy {
    private double discount;
    private double qty;

    public QtyDiscount(double discount, int qty) {
        setDiscount(discount);
    }

    @Override
    public double applyDiscount(double qty) {
        double discount = 0.0;
        if (qty >= this.qty){
            discount += qty * this.discount;
        }
        return discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 0){
            throw new IllegalArgumentException("Discount cann't be negative");
        }
        this.discount = discount;
    }

    public void setQty(double qty) {
        if (qty > 0){
            throw new IllegalArgumentException("Quantity shoud be grater than 0");
        }
        this.qty = qty;
    }
    
    
}
