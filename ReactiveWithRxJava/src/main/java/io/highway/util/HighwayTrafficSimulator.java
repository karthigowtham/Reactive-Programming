package io.highway.util;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import io.highway.source.Vehicle;

public class HighwayTrafficSimulator {

	private static DecimalFormat plateFormatNumber = new DecimalFormat("0000");
	private static String[] RANDOM_STRING = { "TN", "AP", "KL", "KA", "AB", "NM", "AR" };

	private static String[] COLORS = { "Blue", "White", "Silver", "Black", "Metalic Green", "Orange", "Yellow" };

	public static Vehicle getVehicle() {

		String str = RANDOM_STRING[ThreadLocalRandom.current().nextInt(0, 6)];
		StringBuffer sb = new StringBuffer(str);
		sb.append(" ");
		sb.append(plateFormatNumber.format(ThreadLocalRandom.current().nextInt(0, 9999)));
		String carPlateNumber = sb.toString();

		Integer speed = ThreadLocalRandom.current().nextInt(60, 200);

		String color = COLORS[ThreadLocalRandom.current().nextInt(0, 6)];

		return new Vehicle(carPlateNumber, speed, color);

	}

}
