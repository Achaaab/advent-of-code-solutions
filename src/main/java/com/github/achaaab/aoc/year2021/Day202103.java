package com.github.achaaab.aoc.year2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <a href="https://adventofcode.com/2021/day/3">Day 3</a>
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Day202103 extends Day2021 {

	private int total;
	private int[] ones;

	/**
	 * Creates a new day 03 of year 2021.
	 *
	 * @since 0.0.0
	 */
	public Day202103() {
		super(3);
	}

	@Override
	protected void compute(Stream<String> numbers) {

		total = 0;

		numbers.forEach(this::countOnes);

		var length = ones.length;
		var half = total / 2;

		var gammaRate = 0L;
		var epsilonRate = 0L;
		var weight = 1;

		for (var index = 0; index < length; index++) {

			var count = ones[length - index - 1];

			if (count > half) {
				gammaRate += weight;
			} else {
				epsilonRate += weight;
			}

			weight <<= 1;
		}

		System.out.println(gammaRate * epsilonRate);
	}

	/**
	 * Counts the bits set to 1 in the given number.
	 *
	 * @param number number in which to count the bits set to 1
	 * @since 0.0.0
	 */
	private void countOnes(String number) {

		var length = number.length();

		if (total++ == 0) {
			ones = new int[length];
		}

		for (var index = 0; index < length; index++) {

			var bit = number.charAt(index);

			if (bit == '1') {
				ones[index]++;
			}
		}
	}
}