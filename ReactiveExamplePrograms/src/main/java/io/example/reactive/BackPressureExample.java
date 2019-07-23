package io.example.reactive;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.schedulers.Schedulers;

public class BackPressureExample {

	public static void main(String[] args) {

		Flowable<Integer> feed = getFeed();

		feed.subscribe(data -> process(data), err -> System.out.println("ERROR"), () -> System.out.println("DONE"));

		sleep(10000);

	}

	private static Flowable<Integer> getFeed() {

		return Flowable.<Integer>create(emitter -> emit(emitter), BackpressureStrategy.BUFFER)
				.observeOn(Schedulers.computation(), true, 2);

	}

	private static void emit(FlowableEmitter<Integer> emitter) {
		int count = 0;

		while (count < 10) {

			// if (count == 5) { emitter.onError(new RuntimeException()); }

			System.out.println("Emitting:" + count);
			emitter.onNext(count);
			count++;

			sleep(500);
		}
		emitter.onComplete();

	}

	private static void process(int data) {
		System.out.println("Processing:" + data);

		sleep(1000);
	}

	private static boolean sleep(int ms) {
		try {
			Thread.sleep(ms);
			return true;
		} catch (InterruptedException e) {
			return false;
		}
	}

}
