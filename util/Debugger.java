package util;

import parts.Tile;

/**
 * @author Kristof
 *
 */
public class Debugger {

	private static boolean on = false;

	/**
	 * @param s prints a debug string s in the command line
	 */
	public static void print(String s) {
		if (Debugger.on) {
			System.out.println("DEBUG: " + s);
		}
	}

	/**
	 * Prints out a Tile on the console
	 * @param t A tile
	 */
	public static void print(Tile t) {
		if (Debugger.on) {
			Debugger.print("->TILE: x=" + t.getX() + "y=" + t.getY());
		}
	}

	/**
	 * Turns the debugger OFF
	 */
	public static void turnOff() {
		Debugger.on = false;
	}

	/**
	 * Turns the debugger ON
	 */
	public static void turnOn() {
		Debugger.on = true;
	}

}
