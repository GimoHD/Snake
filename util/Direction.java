package util;

/**
 * Created by Kristof on 16/02/2017.
 */
public enum Direction {
	LEFT(-1, 0), RIGHT(1, 0), UP(0, -1), DOWN(0, 1);

	private final int x;
	private final int y;

	/**
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the Y coordinate a tile has to move the next step
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return the X coordinate he has to move the next step
	 */
	public int getY() {
		return this.y;
	}
}
