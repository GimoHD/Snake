package gamemode;

import java.awt.Graphics;

import game.Game;
import parts.Snake;
import parts.Tile;
import util.Debugger;

public class FreeMode extends GameMode {

	public FreeMode(Game game) {
		super(game);
		this.setSize(20);
		this.setSpeed(100);
	}
	
	@Override
	public String toString() {
		return "FreeMode(No walls)";
	}

	@Override
	public void move() {
		for (Snake snake : game.getSnakes()) {
			if (snake != null) {
				Debugger.print("PREPENDING");
				int x=snake.getHeadLocation().getX() + snake.getDirection().getX();
				int y=snake.getHeadLocation().getY() + snake.getDirection().getY();
				if(x>=this.getSize()*2){
					x=0;
					y=snake.getHeadLocation().getY() + snake.getDirection().getY();
				}else if (x<0){
					x= this.getSize()*2-1;
					y=snake.getHeadLocation().getY() + snake.getDirection().getY();

				}else if(y>=this.getSize()){
					y= 0;
					x=snake.getHeadLocation().getX() + snake.getDirection().getX();
				}else if (y<0){
					x=snake.getHeadLocation().getX() + snake.getDirection().getX();
					y=this.getSize()-1;
				}				
				snake.prepend(new Tile(x,y));
				Debugger.print("CANDY");
				if (!game.getCandy().equals(snake.getHead().get())) {
					snake.removelast();
				} else {
					game.newCandy();
				}

			}
		}
		
	}
	
	@Override
	public void collision() {
		this.snakeCollision();
	}

	@Override
	public void draw(Graphics g) {
		
		}
	
	

}
