/**
 * @author Akshay
 * @version 1.0.0
 * @since 30-May-2018
 */

package com.bridgelabz.oops.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author bridgeit
 *
 */
public class GodownInventory implements Serializable {

    @Override
    public String toString() {
	return "GodownInventory [name=" + name + ", types=" + types + ", nextSupply=" + nextSupply + "]";
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Comodity> types;
    private Date nextSupply;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Comodity> getTypes() {
	return types;
    }

    public void setTypes(List<Comodity> types) {
	this.types = types;
    }

    public Date getNextSupply() {
	return nextSupply;
    }

    public void setNextSupply(Date nextSupply) {
	this.nextSupply = nextSupply;
    }

}
