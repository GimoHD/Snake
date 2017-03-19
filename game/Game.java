package game;

import java.awt.Color;

import gamemode.EasyMode;
import gamemode.FreeMode;
import gamemode.GameMode;
import gui.GUI;
import parts.Candy;
import parts.Snake;
import parts.Tile;
import util.Debugger;
import util.Random;

/**
 * Created by Kristof on 16/02/2017.
 */
public class Game {
	private GameMode mode;
	private int SIZE;
	private Snake[] snakes = new Snake[2];
	private Candy candy;
	private GameMode[] gameModes = { new FreeMode(this), new EasyMode(this) };
	private GUI gui;

	/**
	 *
	 */
	public Game() {
		this.setMode(this.gameModes[0]);
		this.SIZE = this.mode.getSize();
		int x = Random.nextInt(0, 5);
		System.out.println(x);
		this.newCandy();
	}

	/**
	 * @param i
	 *            adds a new snake with index i (if it does not exist)
	 */
	public void addNewSnake(int i) {
		if (this.snakes[i] == null) {
			int other = (i == 0) ? 1 : 0;
			Color c = (i == 0) ? Color.GREEN : Color.BLUE;

			if (this.snakes[other] == null) {
				this.snakes[i] = new Snake(5, 5, i, c);
			} else {
				int x;
				int y;
				Tile loc;
				while (this.snakes[i] == null) {
					x = (Random.nextInt(1, this.SIZE * 2) - 1);
					y = (Random.nextInt(1, this.SIZE - 1));
					loc = new Tile(x, y);
					if (!this.snakes[other].find(loc)) {
						this.snakes[i] = new Snake(loc, i, c);
					}
				}

			}
		}
	}

	/**
	 * generates a new candy
	 */
	public void newCandy() {
		Debugger.print("Making new candy");
		int x = (Random.nextInt(1, this.SIZE * 2) - 2);
		int y = (Random.nextInt(1, this.SIZE - 2));

		Tile t = new Tile(x, y);
		boolean foundFreeTile = false;
		while (!foundFreeTile) {
			for (Snake snake : this.snakes) {
				if (snake != null) {

					if (snake.find(t)) {
						x = (Random.nextInt(1, this.SIZE * 2) - 1);
						y = (Random.nextInt(1, this.SIZE - 1));
						t.setX(x);
						t.setY(y);

						break;
					}
				}
			}
			foundFreeTile = true;
		}
		if (this.getGui() != null) {
			this.getGui().print("New candy made");
		}
		this.setCandy(new Candy(x, y));
	}

	/**
	 * moves the snake
	 */
	public void move() {
		this.mode.move();
	}

	/**
	 * @param mode
	 *            resets the game to a GameMode
	 */
	public void reset(GameMode mode) {
		this.snakes = new Snake[2];
		this.newCandy();
		this.setMode(mode);
	}

	/**
	 * @param i
	 *            the index of the snake
	 * @return a snake with the index i
	 */
	public Snake getSnake(int i) {
		if ((i < this.snakes.length) && (i >= 0)) {
			return this.snakes[i];
		} else {
			return null;
		}

	}

	/**
	 * @return the snakes which are active in the game
	 */
	public Snake[] getSnakes() {
		return this.snakes;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return this.SIZE;
	}

	/**
	 * @param i
	 *            the index of the snake that lost
	 */
	public void gameOver(int i) {
		this.getGui().print("Game over: snake " + i + " lost");
		this.snakes[i] = null;
	}

	/**
	 * @return the candy which has been set that the snakes can eat
	 */
	public Candy getCandy() {
		return this.candy;
	}

	/**
	 * @param candy
	 *            sets a candy the snakes can eat
	 */
	public void setCandy(Candy candy) {
		this.candy = candy;
	}

	/**
	 * @return the mode which is active at the time
	 */
	public GameMode getMode() {
		return this.mode;
	}

	/**
	 * @param mode
	 *            the mode that has to be set active (will reset the current
	 *            game)
	 */
	public void setMode(GameMode mode) {
		this.mode = mode;
	}

	/**
	 * @return an array of the game modes
	 */
	public GameMode[] getGameModes() {
		return this.gameModes;
	}

	/**
	 * @param gameModes
	 *            an array of the game modes
	 */
	public void setGameModes(GameMode[] gameModes) {
		this.gameModes = gameModes;
	}

	public GUI getGui() {
		return this.gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}

}
