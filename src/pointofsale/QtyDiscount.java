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
public final class QtyDiscount implements DiscountStrategy {
    private double discount;
    private double minQuantity;

    public QtyDiscount(double discount, int qty) {
        setDiscount(discount);
    }

    @Override
    public final double getDiscount(double qty) {
        double discountValue = 0.0;
        if (qty >= this.minQuantity){
            discountValue = this.discount;
        }
        return discountValue;
    }

    public final double getDiscount() {
        return discount;
    }

    public final void setDiscount(double discount) {
        if (discount < 0){
            throw new IllegalArgumentException("Discount cann't be negative");
        }
        this.discount = discount;
    }

    public final void setQty(double qty) {
        if (qty > 0){
            throw new IllegalArgumentException("Quantity shoud be grater than 0");
        }
        this.minQuantity = qty;
    }
    
    
}
