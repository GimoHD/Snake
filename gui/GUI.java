package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;
import parts.Tile;
import util.Direction;

public class GUI extends JFrame implements KeyListener {

	
	private static final long serialVersionUID = 1L;
	JLabel label;
	private Game game;
	private GamePanel gamePanel;
	private ControlPanel controlPanel;

	/**
	 * @param s
	 * @param game
	 */
	public GUI(String s, Game game) {
		super(s);
		this.game = game;
		this.addKeyListener(this);

		BorderLayout experimentLayout = new BorderLayout();
		this.setLayout(experimentLayout);
		this.controlPanel = new ControlPanel(game);
		this.gamePanel = new GamePanel(game);
		this.add(this.controlPanel, BorderLayout.NORTH);
		this.add(this.gamePanel, BorderLayout.SOUTH);
		this.gamePanel.requestFocus();
	}

	/**
	 * @param s the message that has to be printed in the JLabel
	 */
	public void print(String s) {
		this.controlPanel.print(s);
	}

	/**
	 * @param a score of the first snake
	 * @param b score of the second snake
	 */
	public void setScore(int a, int b) {
		this.controlPanel.setScore(a, b);
	}

	/**
	 * Initiates the tiles by setting the size according to the size of the GUI
	 */
	public void init() {
		Tile.setSize((int) Math.ceil(this.gamePanel.getHeight() / this.game.getSize()));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT: {
			this.game.addNewSnake(1);
			if (this.game.getSnake(1).getDirection() != Direction.RIGHT) {
				this.game.getSnake(1).setDirection(Direction.LEFT);
			}
			break;
		}
		case KeyEvent.VK_RIGHT: {
			this.game.addNewSnake(1);
			if (this.game.getSnake(1).getDirection() != Direction.LEFT) {
				this.game.getSnake(1).setDirection(Direction.RIGHT);
			}
			break;
		}
		case KeyEvent.VK_UP: {
			this.game.addNewSnake(1);
			if (this.game.getSnake(1).getDirection() != Direction.DOWN) {
				this.game.getSnake(1).setDirection(Direction.UP);
			}
			break;
		}
		case KeyEvent.VK_DOWN: {
			this.game.addNewSnake(1);
			if (this.game.getSnake(1).getDirection() != Direction.UP) {
				this.game.getSnake(1).setDirection(Direction.DOWN);
			}
			break;
		}
		case KeyEvent.VK_Q: {
			this.game.addNewSnake(0);
			if (this.game.getSnake(0).getDirection() != Direction.RIGHT) {
				this.game.getSnake(0).setDirection(Direction.LEFT);
			}
			break;
		}
		case KeyEvent.VK_D: {
			this.game.addNewSnake(0);
			if (this.game.getSnake(0).getDirection() != Direction.LEFT) {
				this.game.getSnake(0).setDirection(Direction.RIGHT);
			}
			break;
		}
		case KeyEvent.VK_Z: {
			this.game.addNewSnake(0);
			if (this.game.getSnake(0).getDirection() != Direction.DOWN) {
				this.game.getSnake(0).setDirection(Direction.UP);
			}
			break;
		}
		case KeyEvent.VK_S: {
			this.game.addNewSnake(0);
			if (this.game.getSnake(0).getDirection() != Direction.UP) {
				this.game.getSnake(0).setDirection(Direction.DOWN);
			}
			break;
		}
		default: {
			break;
		}

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}