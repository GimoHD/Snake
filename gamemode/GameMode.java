package gamemode;

import java.awt.Graphics;

import game.Game;
import parts.Snake;
import parts.Tile;
import util.Debugger;
import util.Node;

public abstract class GameMode {
	
	Game game;
	private int size;
	private int speed;
	
	/**
	 * @param game
	 */
	public GameMode(Game game){
		this.game = game;
	}
	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public abstract void move();
	public abstract void collision();
	public abstract void draw(Graphics g);
	
	/**
	 * Checks the snake for collision with other snakes
	 * first it iterates over the snakes, and per snake it iterates over the snakes
	 * again to check for collisions
	 */
	public void snakeCollision(){
		for (Snake snake : game.getSnakes()) {
			if (snake != null) {
				for (Snake other : game.getSnakes()) {
					if (other != null) {
						Node<Tile> next = other.getHead();
						if (snake.getID() == other.getID()) {
							if (next.next() != null) {
								next = next.next();
							} else {
								continue;
							}
						}
						do {
							
							if (snake.getHead().get().equals(next.get())) {
								game.gameOver(snake.getID());	
								System.out.println("game over");
							}
							if (next.next() !=null){
								next = next.next();
							}else{
								break;
							}
							
						} while (next != null);

					}
				}
			}

		}
}
	
	
	@Override
	public String toString() {
		return "GameMode [game=" + game + ", size=" + size + ", speed=" + speed + "]";
	}

}
