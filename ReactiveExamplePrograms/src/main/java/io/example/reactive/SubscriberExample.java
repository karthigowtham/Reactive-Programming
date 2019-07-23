package io.example.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class SubscriberExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Running Subscriber Example");

		Flowable<Long> feed = Flowable.interval(1, 1, TimeUnit.SECONDS);

		feed.map(i -> transform(i)).subscribe(System.out::println);

		// feed.map(i -> transform(i)).subscribe(System.out::println, err ->
		// System.out.println("Its an ERROR:" + err),
		// () -> System.out.println("DONE"));

		Thread.sleep(10000);
	}

	private static long transform(long value) {

		/*
		 * if (value == 5) { throw new RuntimeException("something went wrong"); }
		 */

		return value * 2;
	}

}
