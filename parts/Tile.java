package parts;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	/**
	 * x coordinate of the tile
	 */
	private int x;
	/**
	 * y coordinate of the tile
	 */
	private int y;
	/**
	 * size of the Graphical tile (Square tile)
	 */
	private static int size;

	/**
	 * @param x coordinate of the tile
	 * @param y coordinate of the tile
	 */
	public Tile(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tile)) {
			return false;
		} else {
			Tile p = (Tile) obj;
			return ((p.getX() == this.getX()) && (p.getY() == this.getY()));
		}
	}

	/**
	 * @return x coordinate
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * sets the X coordinate
	 * @param x 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the Y coordinate
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Sets the Y coordinate
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Draws the graphics on a panel with the specific color
	 * @param g Graphics from the GUI
	 * @param c Color
	 */
	public void draw(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect((int) Math.floor(this.x * size), (int) Math.floor(this.y * size), size, size);
		g.setColor(Color.WHITE);
		g.drawRect((int) Math.floor(this.x * size), (int) Math.floor(this.y * size), size, size);
	}

	/**
	 * @return the size of the tile's graphics
	 */
	public static int getSize() {
		return size;
	}

	/**
	 * Sets the size of the tile's graphics
	 * @param size
	 */
	public static void setSize(int size) {
		Tile.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tile [x=" + this.x + ", y=" + this.y + "]";
	}

}
