package com.github.achaaab.aoc.year2021;

import com.github.achaaab.aoc.Day;

/**
 * day of year 2021
 *
 * @author Jonathan Guéhenneux
 */
public abstract class Day2021 extends Day {

	/**
	 * @param arguments none
	 * @since 0.0.0
	 */
	public static void main(String... arguments) {
		new Day202103().compute();
	}

	/**
	 * Creates a new day of year 2021.
	 *
	 * @param number number of the day
	 * @since 0.0.0
	 */
	public Day2021(int number) {
		super(2021, number);
	}
}