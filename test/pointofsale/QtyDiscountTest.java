/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roshann
 */
public class QtyDiscountTest {
    private DiscountStrategy instance;
    
    public QtyDiscountTest() {
    }
    
    @Before
    public void setUp() {
        DiscountStrategy instance = new QtyDiscount(10.0, 5);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getDiscount method, of class QtyDiscount.
     */
    @Test
    public void testGetDiscountValueIfQtyGreaterThanZero() {
        System.out.println("getDiscount");
        double qty = 10.0;
        double expResult = 10.0;
        double result = instance.getDiscount(qty);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDiscount method, of class QtyDiscount.
     */
    @Test
    public void testGetDiscount_0args() {
//        System.out.println("getDiscount");
//        QtyDiscount instance = null;
//        double expResult = 0.0;
//        double result = instance.getDiscount();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscount method, of class QtyDiscount.
     */
    @Test
    public void testSetDiscount() {
//        System.out.println("setDiscount");
//        double discount = 0.0;
//        QtyDiscount instance = null;
//        instance.setDiscount(discount);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setQty method, of class QtyDiscount.
     */
    @Test
    public void testSetQty() {
//        System.out.println("setQty");
//        double qty = 0.0;
//        QtyDiscount instance = null;
//        instance.setQty(qty);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
