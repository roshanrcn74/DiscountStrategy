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
public class InMemoryDataAccess implements ReceiptDataAccessStrategy {
    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };
    
    
//    private Product[] products = {
//        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
//        new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(.10,5)),
//        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
//    };

    
    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new PercentOffDiscount(0.15)),
        new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(0.15,5)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };
    
    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    @Override
    public final Customer findCustomer(String custId) {
        // validation is needed for method parameter
        if(custId == null || custId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findCustomer method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }
        
        Customer customer = null;
        for(Customer c : customers) {
            if(custId.equals(c.getCustomerID())) {
                customer = c;
                break;
            }
        }
        
        return customer;
    }
    
    /**
     * Tries to find a Proudct by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    @Override
    public final Product findProduct(String prodId) {
        // validation is needed for method parameter
        if(prodId == null || prodId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findProduct method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }
        
        Product product = null;
        for(Product p : products) {
            if(prodId.equals(p.getProductId())) {
                product = p;
                break;
            }
        }
        
        return product;
    }
}
