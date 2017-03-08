package gamemode;

import game.Game;

public abstract class GameMode {
	
	Game game;
	private int size = 10;
	private int speed= 500;
	
	public GameMode(Game game){
		this.game = game;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public abstract void move();
	@Override
	public String toString() {
		return "GameMode [game=" + game + ", size=" + size + ", speed=" + speed + "]";
	}

}
