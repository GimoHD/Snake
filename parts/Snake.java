package parts;

import util.*;

/**
 * Created by Kristof on 16/02/2017.
 */
public class Snake extends LinkedList<Tile> {
	private Direction dir;
	private int ID;
	
    public Snake(int x, int y, int ID){
        this.prepend(new Tile(x, y));
        dir = Direction.RIGHT;
        this.ID = ID;
    }

    public Snake(Tile loc) {
    	 this.prepend(loc);
	}

	public void update(){

    }
	public Tile getHeadLocation(){
    	return this.getHead().get();
    }
	
	public void setDirection(Direction dir){
    	this.dir = dir;
    }
	
	public Direction getDirection(){
    	return dir;
    }
	
	public void removelast() {
		Node<Tile> last = getHead();
		Node<Tile> next = last;
		while(next.next() != null){
			last = next;
			next = next.next();
		}
		last.setNext(null);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
