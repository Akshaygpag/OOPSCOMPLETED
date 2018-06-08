package com.generics.demo;

public class UsingGenerics {

	public static void main(String[] args) {
		System.out.println(max(1243, 123123, 12));
	}

	private static MyGenericT max(MyGenericT first, MyGenericT second, MyGenericT third) {

		return (first.compareTo(second) > 0) ? ((first.compareTo(third) > 0) ? first : third)
				: ((second.compareTo(third) > 0) ? second : third);
	}

	private static <E extends Comparable<E>> E max(E first, E second, E third) {

		return (first.compareTo(second) > 0) ? ((first.compareTo(third) > 0) ? first : third)
				: ((second.compareTo(third) > 0) ? second : third);
	}
}

class MyGenericT<T> implements Comparable<MyGenericT> {
	T x;

	@Override
	public int compareTo(MyGenericT o) {
		if (this.compareTo(o) > 0) {
			return 1;
		} else if (this.compareTo(o) < 0) {

			return -1;
		}

		return 0;

	}

}


class Element<E>{
	

	E e;
	
}