package com.github.achaaab.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * abstract class for all days of the Advent of Code 2021
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class Day {

	private static final String INPUT_RESOURCE_FORMAT = "%d/%02d_input.txt";

	private final int year;
	private final int number;

	/**
	 * Creates a new Day having the given number.
	 *
	 * @param number number of the day
	 * @since 0.0.0
	 */
	public Day(int year, int number) {

		this.year = year;
		this.number = number;
	}

	/**
	 * Computes this day and prints the solution to the standard output.
	 *
	 * @since 0.0.0
	 */
	public void compute() {

		try (var reader = readInput()) {
			compute(reader.lines());
		} catch (IOException cause) {
			throw new UncheckedIOException(cause);
		}
	}

	/**
	 * Computes a solution to this day and prints it in the standard output.
	 *
	 * @param input ordered input lines
	 * @since 0.0.0
	 */
	protected abstract void compute(Stream<String> input);

	/**
	 * Opens a new buffered reader from the input resource.
	 *
	 * @return open buffered reader
	 * @throws IOException if an I/O error occurs while opening the input resource
	 * @since 0.0.0
	 */
	private BufferedReader readInput() throws IOException {

		var classLoader = getClass().getClassLoader();
		var resourceName = INPUT_RESOURCE_FORMAT.formatted(year, number);
		var stream = classLoader.getResourceAsStream(resourceName);

		requireNonNull(stream);

		var reader = new InputStreamReader(stream);
		return new BufferedReader(reader);
	}
}