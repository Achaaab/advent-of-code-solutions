package com.github.achaaab.aoc.year2021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * <a href="https://adventofcode.com/2021/day/1">Day 1</a>
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Day202101 extends Day2021 {

	private int increments1;
	private int increments3;
	private Deque<Integer> previousDepths;

	/**
	 * Creates a new day 01 of year 2021.
	 *
	 * @since 0.0.0
	 */
	public Day202101() {
		super(1);
	}

	@Override
	protected void compute(Stream<String> input) {

		var depths = input.mapToInt(Integer::parseInt);

		increments1 = 0;
		increments3 = 0;
		previousDepths = new LinkedList<>();

		depths.forEach(this::compare);

		System.out.println(increments1);
		System.out.println(increments3);
	}

	/**
	 * Compares the given depth to the previous depths and update the increments if it increases.
	 *
	 * @param depth depth to compare
	 * @since 0.0.0
	 */
	private void compare(int depth) {

		var previousDepthCount = previousDepths.size();

		if (previousDepthCount > 0) {

			var depth1 = previousDepths.getLast();

			if (depth > depth1) {
				increments1++;
			}
		}

		if (previousDepthCount == 3) {

			var depth3 = previousDepths.getFirst();

			if (depth > depth3) {
				increments3++;
			}

			previousDepths.removeFirst();
		}

		previousDepths.addLast(depth);
	}
}