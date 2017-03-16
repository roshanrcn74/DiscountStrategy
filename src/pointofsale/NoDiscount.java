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
public class NoDiscount implements DiscountStrategy {

    public NoDiscount() {
    }

    @Override
    public double getDiscount(double qty) {
        return 0.0;
    }
    
}
