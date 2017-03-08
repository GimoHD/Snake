package util;

import parts.Tile;

public class Debugger {

	private static boolean on = true;
	public static void print(String s){
		if (Debugger.on){
			System.out.println("DEBUG: " + s);
		}
	}
	
	public static void print(Tile t){
		if (Debugger.on){
			Debugger.print("->TILE: x=" + t.getX() + "y=" + t.getY());
		}
	}
	
	public static void turnOff() {
		Debugger.on = false;
	}

	public static void turnOn() {
		Debugger.on = true;
	}
	
}
