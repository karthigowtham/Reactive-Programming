package io.example.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;

public class ForkingExample {
	// Cold vs Hot (share) publisher
	public static void main(String[] args) throws InterruptedException {

		Flowable<Long> feed = Flowable.interval(1, 1, TimeUnit.SECONDS);

		feed.subscribe(data -> printIt("S1: " + data));

		Thread.sleep(5000);

		feed.subscribe(data -> printIt("S2: " + data));

		Thread.sleep(10000);
	}

	private static void printIt(String msg) {
		System.out.println(msg);
	}
}
