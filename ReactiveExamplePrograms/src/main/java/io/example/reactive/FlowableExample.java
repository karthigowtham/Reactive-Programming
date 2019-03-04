package io.example.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class FlowableExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Running Flowable Example");

		Flowable<Integer> feed = Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		feed.map(i -> i * 2).subscribe(System.out::println);

		//Flowable.interval(1, 1, TimeUnit.SECONDS).map(i -> i *2).forEach(System.out::println);

		//Thread.sleep(10000);

		System.out.println("Program Completes");

	}

}
