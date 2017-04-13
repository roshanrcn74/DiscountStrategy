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
public class LineItemTest {
    
    public LineItemTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLineItem method, of class LineItem.
     */
    @Test
    public void testGetLineItem() {
        System.out.println("getLineItem");
        LineItem instance = null;
        String expResult = "";
        String result = instance.getLineItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class LineItem.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        LineItem instance = null;
        Product expResult = null;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProduct method, of class LineItem.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        Product product = null;
        LineItem instance = null;
        instance.setProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class LineItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        LineItem instance = null;
        double expResult = 0.0;
        double result = instance.getQuantity();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class LineItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        double quantity = 0.0;
        LineItem instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
