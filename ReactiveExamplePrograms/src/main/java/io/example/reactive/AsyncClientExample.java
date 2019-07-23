package io.example.reactive;

import io.reactivex.Flowable;

public class AsyncClientExample {

	public static void main(String[] args) throws InterruptedException {

		Flowable<Integer> feed = Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		feed.subscribe(data -> printIt("SUB:" + data));

		// ExecutorService executors = Executors.newFixedThreadPool(50);
		// feed.subscribeOn(Schedulers.from(executors)).forEach(data -> printIt("Client
		// 1:" + data));

		Thread.sleep(5000);
	}

	private static void printIt(String value) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		System.out.println(value);
	}
}
