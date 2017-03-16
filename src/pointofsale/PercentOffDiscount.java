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
public class PercentOffDiscount implements DiscountStrategy {
    private double percentDiscount;

    public PercentOffDiscount(double discount) {
        setPercentDuscount(discount);
    }

    @Override
    public double getDiscount(double qty) {
        
         return percentDiscount;
    }

    public final double getPercentDuscount() {
        return percentDiscount;
    }

    public final void setPercentDuscount(double percentDuscount) {
        if (percentDuscount < 0){
            throw new IllegalArgumentException("Discount cann't be negative");
        }
        this.percentDiscount = percentDuscount;
    }
    
    
    
}
