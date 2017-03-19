/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import game.Game;
import parts.*;
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
		setPreferredSize(new Dimension(1600, 800));
		this.x = 2*(game.getSize());
		this.y = game.getSize();
		this.game = game;
		Thread t = new Thread(new Runnable() {
		    public void run() {
		    	while(true){
		    	repaint();
		    	try {
					Thread.sleep(game.getMode().getSpeed());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    }
		    }
		});
		t.start();
		
	}

	@Override
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        

        game.move();
        game.getMode().collision();
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        
        for (Snake snake : game.getSnakes()){
        	if (snake !=null){
        	Node<Tile> node = snake.getHead();
        	while(node !=null){
        		Debugger.print("drawing node");
        		node.get().draw(g, snake.getColor());
        		node = node.next();
        	}
        	}   	
        }
        
        game.getCandy().draw(g, Color.RED);
        
        game.getMode().draw(g);
        int scoreA = 0;
        int scoreB = 0;
        
        	if (game.getSnake(0) !=null){
        		scoreA = game.getSnake(0).size();
        	}
        	if (game.getSnake(1) !=null){
        		scoreB = game.getSnake(1).size();
        	}
        
        game.getGui().setScore(scoreA, scoreB);
    }
}
