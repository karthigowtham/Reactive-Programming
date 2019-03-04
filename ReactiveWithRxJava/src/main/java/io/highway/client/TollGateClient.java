package io.highway.client;

import io.highway.source.Vehicle;
import io.highway.source.VehicleDetector;
import io.reactivex.Flowable;

public class TollGateClient {

	public static Flowable<Vehicle> feed = VehicleDetector.getVehicleFeed();
	
	public static void main(String[] args) throws InterruptedException {
		
		getAllVehicles();
		getOverSpeedVehicles(120);
		
		Thread.sleep(20000);

	}

	private static void getAllVehicles() {
		feed.subscribe(
				data -> processVehicle("VEHICLE -> "+data.toString()),
				err -> System.out.println("DEVICE DOWN....!!!!"),
				() -> System.out.println("TRAFFIC CLOSED"));

	}

	private static void getOverSpeedVehicles(int speedLimit) {
		
		System.out.println("Over speed Vehicles");
		feed.filter(vehicle -> vehicle.getSpeed() > speedLimit).subscribe(
				data -> processSpeedVehicle("OVER SPEED VEHICLE -> "+data.toString()),
				err -> System.out.println("DEVICE DOWN....!!!!"),
				() -> System.out.println("TRAFFIC CLOSED"));

	}
	
	private static void processVehicle(String msg) throws InterruptedException {
		System.out.println(msg);
		Thread.sleep(3000);
	}
	
	private static void processSpeedVehicle(String msg) {
		System.out.println(msg);		
	}

}
