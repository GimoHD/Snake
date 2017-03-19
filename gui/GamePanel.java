/**
 *
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.Game;
import parts.Snake;
import parts.Tile;
import util.Debugger;
import util.Node;

/**
 * @author Kristof
 *
 */
public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int x;
	int y;
	Game game;

	public GamePanel(Game game) {
		this.setPreferredSize(new Dimension(1600, 800));
		this.x = 2 * (game.getSize());
		this.y = game.getSize();
		this.game = game;
		Thread t = new Thread(() -> {
			while (true) {
				GamePanel.this.repaint();
				try {
					Thread.sleep(game.getMode().getSpeed());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		// Important to call super class method
		super.paintComponent(g);

		this.game.move();
		this.game.getMode().collision();
		// Clear the board
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		for (Snake snake : this.game.getSnakes()) {
			if (snake != null) {
				Node<Tile> node = snake.getHead();
				while (node != null) {
					Debugger.print("drawing node");
					node.get().draw(g, snake.getColor());
					node = node.next();
				}
			}
		}

		this.game.getCandy().draw(g, Color.RED);

		this.game.getMode().draw(g);
		int scoreA = 0;
		int scoreB = 0;

		if (this.game.getSnake(0) != null) {
			scoreA = this.game.getSnake(0).size();
		}
		if (this.game.getSnake(1) != null) {
			scoreB = this.game.getSnake(1).size();
		}

		this.game.getGui().setScore(scoreA, scoreB);
	}
}
