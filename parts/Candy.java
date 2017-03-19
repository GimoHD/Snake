package parts;

/**
 * Created by Kristof on 17/02/2017.
 */
public class Candy extends Tile {
	/**
	 * @param x the X coordinate for the candy
	 * @param y the Y coordinate for the candy
	 */
	public Candy(int x, int y) {
		super(x, y);
	}

	/**
	 * @param x Sets the X coordinate
	 * @param y Sets the Y coordinate
	 */
	public void setLocation(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
}
