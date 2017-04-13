/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roshann
 */
public class PercentOffDiscountTest {
    private PercentOffDiscount percentOffDiscount;
    
    public PercentOffDiscountTest() {
    }
    
    @Before
    public void setUp() {
       percentOffDiscount = new PercentOffDiscount(0.50);
       
    }
    
    @After
    public void tearDown() {
       
    }

    /**
     * Test of getDiscount method, of class PercentOffDiscount.
     */
    @Test
    public void testGetDiscount() {

    }

    /**
     * Test of getPercentDuscount method, of class PercentOffDiscount.
     */
    @Test
    public void testGetPercentDuscount() {

    }

    /**
     * Test of setPercentDuscount method, of class PercentOffDiscount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetPercentDuscountShouldNotAllowNegativeValue() {
       percentOffDiscount.setPercentDuscount(-1);

    }
    
}
