package parts;

import java.awt.Color;

import util.*;

public class Snake extends LinkedList<Tile> {
	private Direction dir;
	private int ID;
	private Color color;
	
    public Snake(int x, int y, int ID, Color c){
        this.prepend(new Tile(x, y));
        dir = Direction.RIGHT;
        this.ID = ID;
        setColor(c);
    }

    public Snake(Tile loc,int ID, Color c) {
    	 this.prepend(loc);
    	 dir = Direction.RIGHT;
         this.ID = ID;
         setColor(c);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
