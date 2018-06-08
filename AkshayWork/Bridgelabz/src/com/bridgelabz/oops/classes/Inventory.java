/**

 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.oops.classes;

/**
 * @author bridgeit
 *
 */
public class Inventory {
    @Override
    public String toString() {
	return "Inventory [product=" + product + ", inventoryPrice=" + inventoryPrice + "]";
    }
    String product;
    double inventoryPrice;
    public double getInventoryPrice() {
        return inventoryPrice;
    }
    public void setInventoryPrice(double inventoryPrice) {
        this.inventoryPrice = inventoryPrice;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    
}
