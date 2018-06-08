package com.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 07-Jun-2018
 */

public class MainClass {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	List<String> blackList = new ArrayList<String>();
	blackList.add(new String("Apple"));
	blackList.add(new String("Jam"));
	blackList.add(new String("Fig"));
	blackList.add(new String("Grapes"));
	blackList.add(new String("Tomato"));
	blackList.add(new String("Papaya"));
	blackList.add(new String("Bread"));
	blackList.add(new String("Red Meat"));

	Set<String> set = new HashSet<>();

	set.add(new String("Apple"));

	Stream<String> x = blackList.stream().filter(p -> {

	    if (set.contains(p.toString())) {

		return false;
	    }
	    return true;
	});
	x.forEach(p1 -> {
	    System.out.println(p1);
	});
	;

    }

}
