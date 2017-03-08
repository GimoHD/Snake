package game;

import parts.Tile;

import java.awt.Color;

import gamemode.EasyMode;
import gamemode.FreeMode;
import gamemode.GameMode;
import parts.Candy;
import parts.Snake;
import util.Debugger;
import util.Node;
import util.Random;

/**
 * Created by Kristof on 16/02/2017.
 */
public class Game {
	private GameMode mode;
	private int SIZE;
	private String[][] board;
	private Snake[] snakes = new Snake[2];
	private Candy candy;
	private GameMode[] gameModes = {new FreeMode(this), new EasyMode(this)};
	
	public Game() {
		setMode(gameModes[0]);
		SIZE = mode.getSize();
		int x = Random.nextInt(0, 5);
		System.out.println(x);
		board = new String[SIZE * 2][SIZE];
		newCandy();
	}

	public void addNewSnake(int i) {
		if (snakes[i] == null) {
			int other = (i == 0) ? 1 : 0;
			Color c = (i == 0) ? Color.GREEN : Color.BLUE;
			
			if (snakes[other] == null) {
				snakes[i] = new Snake(5, 5, i, c);
			} else {
				int x;
				int y;
				Tile loc;
				while (snakes[i] == null) {
					x = (Random.nextInt(1, SIZE * 2) - 1);
					y = (Random.nextInt(1, SIZE - 1));
					loc = new Tile(x, y);
					if (!snakes[other].find(loc)) {
						snakes[i] = new Snake(loc,i,c);
					}
				}

			}
		}
	}

	public void newCandy() {
		Debugger.print("Making new candy");
		int x = (Random.nextInt(1, SIZE * 2) - 1);
		int y = (Random.nextInt(1, SIZE - 1));

		Tile t = new Tile(x, y);
		boolean foundFreeTile = false;
		while (!foundFreeTile) {
			for (Snake snake : snakes) {
				if (snake != null) {

					if (snake.find(t)) {
						x = (Random.nextInt(1, SIZE * 2) - 1);
						y = (Random.nextInt(1, SIZE - 1));
						t.setX(x);
						t.setY(y);

						break;
					}
				}
			}
			foundFreeTile = true;
		}
		Debugger.print("NEW CANDY MADE");
		setCandy(new Candy(x, y));
	}


	public void move() {
		mode.move();
	}

	public void reset(GameMode mode) {
		snakes = new Snake[2];
		newCandy();
		this.setMode(mode);
	}
	
	public void start() {

	}

	public void update() {
		move();
		// snake
		/*
		 * for (int i = 0; i < SIZE; i++) { for (int j = 0; j < SIZE; j++) { if
		 * ((i == 0 || i == SIZE - 1) && (j == 0 || j == SIZE - 1)) {
		 * board[i][j] = "+"; } else if (i == 0 || i == SIZE - 1) { board[i][j]
		 * = " - "; } else if (j == 0 || j == SIZE - 1) { board[i][j] = "|"; }
		 * else { board[i][j] = "   "; } } }
		 */
	}

	public void reDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	public Snake getSnake(int i) {
		if (i < snakes.length && i >= 0) {
			return snakes[i];
		} else {
			return null;
		}

	}

	public Snake[] getSnakes() {
		return snakes;
	}

	public int getSize() {
		return SIZE;
	}

	public void checkHead() {
	}

	public void gameOver(int i) {
		snakes[i] = null;
	}

	public Candy getCandy() {
		return candy;
	}

	public void setCandy(Candy candy) {
		this.candy = candy;
	}

	public GameMode getMode() {
		return mode;
	}

	public void setMode(GameMode mode) {
		this.mode = mode;
	}

	public GameMode[] getGameModes() {
		return gameModes;
	}

	public void setGameModes(GameMode[] gameModes) {
		this.gameModes = gameModes;
	}

}
