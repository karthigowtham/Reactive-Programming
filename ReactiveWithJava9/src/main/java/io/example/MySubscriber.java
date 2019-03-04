package io.example;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber implements Subscriber<Integer> {

	private Subscription subscription;

	public void onComplete() {
		System.out.println("COMPLETED");
	}

	public void onError(Throwable throwable) {
		System.out.println("ERROR:" + throwable);
	}

	public void onNext(Integer value) {
		System.out.println("Data:" + value);

		/*
		 * if (value == 8) { subscription.cancel(); }
		 */
		//subscription.request(1);
	}

	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(5);

	}

}
