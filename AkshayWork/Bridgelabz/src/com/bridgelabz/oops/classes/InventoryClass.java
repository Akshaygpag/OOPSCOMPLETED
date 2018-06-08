
package com.bridgelabz.oops.classes;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */
public class InventoryClass {
    String name;;
    double weight;
    double price;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getWeight() {
	return weight;
    }

    public void setWeight(double weight) {
	this.weight = weight;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    @Override
    public String toString() {
	return "InventoryClass [name=" + name + ", weight=" + weight + ", price=" + price + "]";
    }

}
