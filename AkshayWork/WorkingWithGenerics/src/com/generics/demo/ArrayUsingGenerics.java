package com.generics.demo;

public class ArrayUsingGenerics {

	public static void main(String[] args) {
		W[] myArray = new W[2];
		for (int i = 0; i < 2; i++) {

			W w = new W();
			w.setT("Hello world");
			if (i % 2 == 0) {
				w.setT(12);

			}
			myArray[i] = w;
		}

		arrayMethod(myArray);

	}

	private static <T1> void arrayMethod(T1[] data) {

		for (T1 iterable_element : data) {

			System.out.println(iterable_element);

		}
	}

}

class W<T> {

	@Override
	public String toString() {
		return "W [t=" + t + "]";
	}

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}