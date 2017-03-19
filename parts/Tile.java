package parts;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	private int x;
	private int y;
	private static int size;

	public Tile(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tile)) {
			return false;
		} else {
			Tile p = (Tile) obj;
			return ((p.getX() == this.getX()) && (p.getY() == this.getY()));
		}
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect((int) Math.floor(this.x * size), (int) Math.floor(this.y * size), size, size);
		g.setColor(Color.WHITE);
		g.drawRect((int) Math.floor(this.x * size), (int) Math.floor(this.y * size), size, size);
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Tile.size = size;
	}

	@Override
	public String toString() {
		return "Tile [x=" + this.x + ", y=" + this.y + "]";
	}

}
