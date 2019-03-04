package io.example;

import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class Sample {

	public static void main(String[] args) throws InterruptedException {

		SubmissionPublisher<Integer> feed = new SubmissionPublisher<Integer>();

		MyTransformer transformer = new  MyTransformer(
		
		
		//feed.subscribe(new MySubscriber());

		for (int i = 0; i <= 10; i++) {		
				
			feed.submit(i);
			System.out.println("Emitting:"+i);
		}
		
		//feed.close();

		Thread.sleep(5000);
	
	}

}
