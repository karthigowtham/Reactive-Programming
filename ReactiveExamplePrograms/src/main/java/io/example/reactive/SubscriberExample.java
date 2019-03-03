package io.example.reactive;

import io.reactivex.Flowable;

public class SubscriberExample {

	public static void main(String[] args) {
		System.out.println("Running Subscriber Example");

		Flowable<Integer> feed = Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		feed.map(i -> transform(i)).subscribe(System.out::println);

		// feed.map(i -> transform(i)).subscribe(System.out::println, err ->
		// System.out.println("Its an ERROR:" + err),
		// () -> System.out.println("DONE"));
	}

	private static int transform(int value) {

		/*
		 * if (value == 8) { throw new RuntimeException("something went wrong"); }
		 */

		return value * 2;
	}

}
