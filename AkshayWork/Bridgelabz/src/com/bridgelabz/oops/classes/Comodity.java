
package com.bridgelabz.oops.classes;

import java.io.Serializable;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 30-May-2018
 */

public class Comodity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String type;
    private Double price;
    private Long quantity;

    @Override
    public String toString() {
	return "Comodity [type=" + type + ", price=" + price + ", quantity=" + quantity + "]";
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public Long getQuantity() {
	return quantity;
    }

    public void setQuantity(Long quantity) {
	this.quantity = quantity;
    }

   
}
