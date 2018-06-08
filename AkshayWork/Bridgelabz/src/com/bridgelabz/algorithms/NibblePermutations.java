/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */

package com.bridgelabz.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author bridgeit
 *
 */
public class NibblePermutations {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	String name = "01234567";
	Utility.setString(name);
	Utility.callRecurssive(0, name.length() - 1);

	List<String> combinations = Utility.getCombinations();

	String binaryData = AlgorithmUtil.toBinary(100);

	int i = 0;
	int index = 0;
	String[] nibbles = new String[8];
	for (int j = 1; j <= binaryData.length(); j++) {

	    if (j % 4 == 0) {

		String created = binaryData.substring(i, j);
		i = j;
		nibbles[index++] = created;

	    }

	}
Set<String> mySet=new HashSet<String>();
	StringBuffer sb = new StringBuffer();

	for (String string : combinations) {
	    sb = null;
	    sb = new StringBuffer();

	    for (int j = 0; j < string.length(); j++) {

		sb.append(nibbles[Integer.parseInt(String.valueOf(string.charAt(j)))]);


	    }
	    mySet.add(toDecimal(sb.toString()));
//	     System.out.println(toDecimal(sb.toString()));
//	    System.out.println(sb);

	}
System.out.println(mySet);
    }

    private static String toDecimal(String concat) {
	// CONVERT FROM BINARY TO DECIMAL

	int len = concat.length() - 1;
	int result = 0;
	int i = 0;
	while (len >= 0) {

	    result = result + Integer.parseInt(String.valueOf(concat.charAt(len))) * (int) Math.pow(2, i);
	    len--;
	    i++;
	}

	return String.valueOf(result);
    }
}
