package io.highway.source;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.schedulers.Schedulers;

public class VehicleDetector {	
	
	public static Flowable<Vehicle> getVehicleFeed() {
		
		return Flowable.<Vehicle> create(source -> detect(source), BackpressureStrategy.BUFFER)
				.observeOn(Schedulers.computation(), true, 2); 
		
	}
	
	private static void detect(FlowableEmitter<Vehicle> source) {
		
		System.out.println("TRAFFIC STARTED");
		int count 
		while()
	}

}
