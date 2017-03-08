package parts;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
    private int x;
	private int y;
	private Color color;
	private static int size;
	
	public Tile(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setColor(Color.BLACK);
	}

	 @Override
	 public boolean equals(Object obj) {
	       if (!(obj instanceof Tile)){
	    	   return false;
	       }else{  
	    	   Tile p = (Tile) obj;
			return (p.getX() == this.getX() && p.getY() == this.getY());
	       }
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	public void draw(Graphics g){
		g.setColor(this.getColor());
		g.fillRect((int) Math.floor(x * size), (int) Math.floor(y * size), size, size);
		g.setColor(Color.WHITE);
		g.drawRect((int) Math.floor(x * size), (int) Math.floor(y * size), size, size);
	}

	public static int getSize() {
		return size;
	}


	public static void setSize(int size) {
		Tile.size = size;
	}

	@Override
	public String toString() {
		return "Tile [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
	
}
