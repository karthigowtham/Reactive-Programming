package io.example;

import java.util.concurrent.SubmissionPublisher;

public class Sample {

	public static void main(String[] args) throws InterruptedException {

		SubmissionPublisher<Integer> feed = new SubmissionPublisher<Integer>();

		// MyTransformer transformer = new MyTransformer(data -> data * 2);
		// feed.subscribe(transformer);
		// transformer.subscribe(new MySubscriber());

		feed.subscribe(new MySubscriber());

		for (int i = 0; i <= 10; i++) {

			feed.submit(i);
			System.out.println("Emitting:" + i);
			Thread.sleep(500);
		}

		// feed.close();

		Thread.sleep(5000);

	}

}
