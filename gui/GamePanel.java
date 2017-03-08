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
	/**
	 * 
	 */
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
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        
        for (Snake snake : game.getSnakes()){
        	if (snake !=null){
        	//System.out.println(snake.getHead().get().getX());
        	Node<Tile> node = snake.getHead();
        	while(node !=null){
        		Debugger.print("drawing node");
        		node.get().draw(g, snake.getColor());
        		node = node.next();
        	}
        	}   	
        }
        game.getCandy().draw(g, Color.RED);
        game.getMode().collision();
        game.getMode().draw(g);
        game.update();
        //repaint();
        // Draw the grid
       /* int rectWidth = (int) Math.ceil(getWidth() / x);
        int rectHeight = (int) Math.ceil(getHeight() / y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // Upper left corner of this terrain rect
                int x_rect = (int) Math.floor(i * rectWidth);
                int y_rect = (int) Math.floor(j * rectHeight);
                if( i == 0 || j==0 || i == x-1 || j == y-1){
                	g.fillRect(x_rect, y_rect, rectWidth, rectHeight);
                	//System.out.println("x_rect=" + x_rect + "y_rect=" + y_rect +"w=" + rectWidth +"h=" + rectHeight);
                }
            }
        }
        */
    }
}
