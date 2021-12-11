package com.github.achaaab.aoc.year2021;

import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

/**
 * <a href="https://adventofcode.com/2021/day/2">Day 2</a>
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Day202102 extends Day2021 {

	private long horizontalPosition1;
	private long depth1;

	private long aim;
	private long horizontalPosition2;
	private long depth2;

	/**
	 * Creates a new day 02 of year 2021.
	 *
	 * @since 0.0.0
	 */
	public Day202102() {
		super(2);
	}

	@Override
	protected void compute(Stream<String> commands) {

		horizontalPosition1 = 0;
		depth1 = 0;

		aim = 0;
		horizontalPosition2 = 0;
		depth2 = 0;

		commands.forEach(this::updatePosition);

		System.out.println(horizontalPosition1 * depth1);
		System.out.println(horizontalPosition2 * depth2);
	}

	/**
	 * Updates the horizontal position and depth according to the given command.
	 *
	 * @param command command to execute
	 * @since 0.0.0
	 */
	private void updatePosition(String command) {

		var commandTokens = command.split(" ");
		var direction = commandTokens[0];
		var units = parseInt(commandTokens[1]);

		updatePositionPart1(direction, units);
		updatePositionPart2(direction, units);
	}

	/**
	 * Update the horizontal position and depth according to the given command
	 * using the logic in the first part of the day.
	 *
	 * @param direction direction
	 * @param units number of units
	 * @since 0.0.0
	 */
	private void updatePositionPart1(String direction, int units) {

		switch (direction) {

			case "forward" -> horizontalPosition1 += units;
			case "down" -> depth1 += units;
			case "up" -> depth1 -= units;
		}
	}

	/**
	 * Update the horizontal position and depth according to the given command
	 * using the logic in the second part of the day.
	 *
	 * @param direction direction
	 * @param units number of units
	 * @since 0.0.0
	 */
	private void updatePositionPart2(String direction, int units) {

		switch (direction) {

			case "forward" -> {
				horizontalPosition2 += units;
				depth2 += units * aim;
			}
			case "down" -> aim += units;
			case "up" -> aim -= units;
		}
	}
}