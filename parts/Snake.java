package parts;

import java.awt.Color;

import util.Direction;
import util.LinkedList;
import util.Node;

/**
 * @author Kristof
 *
 */
public class Snake extends LinkedList<Tile> {
	private Direction dir;
	private int ID;
	private Color color;

	/**
	 * @param x The starting X coordinate of the snake
	 * @param y The starting Y coordinate of the snake
	 * @param ID gives the snake an ID
	 * @param c Gives a color of the snake
	 */
	public Snake(int x, int y, int ID, Color c) {
		this.prepend(new Tile(x, y));
		this.dir = Direction.RIGHT;
		this.ID = ID;
		this.setColor(c);
	}

	/**
	 * @param loc gives the X and Y with a location
	 * @param ID gives the snake an ID
	 * @param c Gives a color of the snake
	 */
	public Snake(Tile loc, int ID, Color c) {
		this.prepend(loc);
		this.dir = Direction.RIGHT;
		this.ID = ID;
		this.setColor(c);
	}

	
	/**
	 * @return the location of the head of the snake
	 */
	public Tile getHeadLocation() {
		return this.getHead().get();
	}

	/**
	 * @param dir sets the direction of the snake
	 */
	public void setDirection(Direction dir) {
		this.dir = dir;
	}

	/**
	 * @return the direction of the snake
	 */
	public Direction getDirection() {
		return this.dir;
	}

	/**
	 * Removes the last element from the snake
	 */
	public void removelast() {
		Node<Tile> last = this.getHead();
		Node<Tile> next = last;
		while (next.next() != null) {
			last = next;
			next = next.next();
		}
		last.setNext(null);
		this.size--;
	}

	/**
	 * @return the ID of the snake
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * @param iD sets the ID of the snake
	 */
	public void setID(int iD) {
		this.ID = iD;
	}

	/**
	 * @return the color of the snake
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * sets the color of the snake
	 * @param color the color of the snake
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}
