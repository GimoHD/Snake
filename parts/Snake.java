package parts;

import java.awt.Color;

import util.Direction;
import util.LinkedList;
import util.Node;

public class Snake extends LinkedList<Tile> {
	private Direction dir;
	private int ID;
	private Color color;

	public Snake(int x, int y, int ID, Color c) {
		this.prepend(new Tile(x, y));
		this.dir = Direction.RIGHT;
		this.ID = ID;
		this.setColor(c);
	}

	public Snake(Tile loc, int ID, Color c) {
		this.prepend(loc);
		this.dir = Direction.RIGHT;
		this.ID = ID;
		this.setColor(c);
	}

	public void update() {

	}

	public Tile getHeadLocation() {
		return this.getHead().get();
	}

	public void setDirection(Direction dir) {
		this.dir = dir;
	}

	public Direction getDirection() {
		return this.dir;
	}

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

	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
