package io.example.streams;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		System.out.println("Running Stream Example");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.stream().map(i -> i * 2).forEach(System.out::println);
	}
}
