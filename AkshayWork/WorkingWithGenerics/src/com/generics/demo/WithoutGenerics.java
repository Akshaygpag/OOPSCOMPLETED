package com.generics.demo;

import java.util.ArrayList;

public class WithoutGenerics {

	public static void main(String[] args) {

		System.out.println(max(1, 2, 3));
		System.out.println(max(11.21, 212.12, 312.21));
	}

	private static int max(int first, int second, int third) {

		return (first > second) ? ((first > third) ? first : third) : ((second > third) ? second : third);
	}

	private static <T2 extends Object, T> T2 createObject(T data) {

		try {

			Class<?> obj = Class.forName(data.getClass().getName());

			obj.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (first > second) ? ((first > third) ? first : third) : ((second > third) ? second : third);
	}

}
