package io.example;

import java.util.concurrent.SubmissionPublisher;

public class Sample {

	public static void main(String[] args) throws InterruptedException {

		SubmissionPublisher<Integer> feed = new SubmissionPublisher<Integer>();

		feed.subscribe(new MySubscriber());

		for (int i = 0; i <= 10; i++) {
			feed.submit(i);
		}

		// feed.closeExceptionally(new RuntimeException("TEST ERROR"));

		Thread.sleep(5000);
		// feed.close();
	}

}
