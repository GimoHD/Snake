package gamemode;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.Game;
import parts.Snake;
import parts.Tile;
import util.Debugger;

public class EasyMode extends GameMode {

	ArrayList<Tile> walls;
	public EasyMode(Game game) {
		super(game);
		this.setSize(20);
		this.setSpeed(100);
		walls = new ArrayList<Tile>();
		addWalls();
	}
	
	public void addWalls(){
		for (int i = 0; i < this.getSize() * 2; i++) {
			for (int j = 0; j < this.getSize(); j++) {
				if (i == 0 || i == this.getSize() * 2 - 1 || j == 0 || j == this.getSize() - 1) {
					Tile t = new Tile(i, j);
					walls.add(t);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "EasyMode(Walls around)";
	}

	@Override
	public void move() {
		for (Snake snake : game.getSnakes()) {
			if (snake != null) {
				Debugger.print("PREPENDING");
				int x = snake.getHeadLocation().getX() + snake.getDirection().getX();
				int y = snake.getHeadLocation().getY() + snake.getDirection().getY();
				snake.prepend(new Tile(x, y));
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
		for(Tile t : walls){
			for (Snake s : game.getSnakes()){
				if(s !=null && s.getHead() !=null){
					if(s.getHead().get().equals(t)){
						game.gameOver(s.getID());
					}
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {

		for(Tile t : walls){
				g.setColor(Color.BLACK);
				g.fillRect((int) Math.floor(t.getX() * Tile.getSize()), (int) Math.floor(t.getY() * Tile.getSize()),
						Tile.getSize(), Tile.getSize());
				g.setColor(Color.WHITE);
				g.drawRect((int) Math.floor(t.getX() * Tile.getSize()), (int) Math.floor(t.getY() * Tile.getSize()),
						Tile.getSize(), Tile.getSize());	
		}
	}

}