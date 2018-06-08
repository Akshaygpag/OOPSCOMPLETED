package com.bridgelabz.functionalprogramming.codes;

import java.util.HashSet;
import java.util.Set;
import com.bridgelabz.functionalprogramming.exceptions.GenericExceptions;
import com.bridgelabz.functionalprogramming.util.Utility;
/**
 * 
 * @author Akshay
 * @since 17-05-2018
 *@version 1.0.0
 */
public class CouponGenerator 
{
	private static int couponsCounter;
	private static int couponTimes;

	public static void main(String[] args) throws GenericExceptions {
		// MAIN METHOD CALLS GENERATECOUPONS METHOD AND WORK WITH GETTING USER DATA
		int noOfCoupons = 0;
		Set<Integer> couponCollector = null;
		try 
		{
			System.out.println("Enter the number of coupons to be generated");
			noOfCoupons = Utility.getIntergerValue();
			couponTimes = noOfCoupons;
			if (noOfCoupons < 1) {
				throw new GenericExceptions("Enter number greater than 0");
			} 
			couponCollector = new HashSet<Integer>();
			generateCoupons(couponCollector);
			System.out.println("The number of times the coupon is generated is "+couponsCounter);
System.out.println(couponCollector);
		} 
		catch (Exception e) 
		{
			throw new GenericExceptions(e.getMessage());
		}

	}

	private static void generateCoupons(Set<Integer> couponCollector) 
	{
		if (!(couponCollector.size() == couponTimes)) {

			int couponNumber = Utility.getRandomInt();
			System.out.println("The random value generated is   "+couponNumber);
			couponsCounter++;
			if (!couponCollector.contains(couponNumber)) {
				couponCollector.add(couponNumber);

			} 
			generateCoupons(couponCollector);
			

		} else {
			return;
		}

	}

}
