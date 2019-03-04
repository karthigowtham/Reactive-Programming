package io.highway.source;

import io.highway.util.HighwayTrafficSimulator;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.schedulers.Schedulers;

public class VehicleDetector {

	public static Flowable<Vehicle> getVehicleFeed() {

		return Flowable.<Vehicle>create(source -> detect(source), BackpressureStrategy.BUFFER)
				.observeOn(Schedulers.computation(), true, 5);

	}

	private static void detect(FlowableEmitter<Vehicle> source) throws InterruptedException {

		System.out.println("TRAFFIC STARTED");
		int count = 0;

		while (count < 15) {

			if (count % 5 == 0) {
				Thread.sleep(3000);
			}
			/*
			 * if (count == 14) { source.onError(new RuntimeException()); }
			 */

			Vehicle car = HighwayTrafficSimulator.getVehicle();
			System.out.println("EMIT-CAR:" + car.getCarPlateNumber());
			source.onNext(car);

			count++;
		}

		source.onComplete();
	}

}
