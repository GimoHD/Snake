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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
    Game game;
    GamePanel gamePanel;
    ControlPanel controlPanel;

    public GUI(String s, Game game) {
        super(s);
        this.game =game;
        addKeyListener(this);

        BorderLayout experimentLayout = new BorderLayout();
        this.setLayout(experimentLayout);
        this.controlPanel = new ControlPanel(game);
        this.gamePanel = new GamePanel(game);
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(gamePanel, BorderLayout.SOUTH);
        gamePanel.requestFocus();
    }
    
    public void print(String s){
    	controlPanel.print(s);
    }
    public void setScore(int a, int b){
    	controlPanel.setScore(a,b);
    }
    
    public void init(){
		Tile.setSize((int) Math.ceil(gamePanel.getHeight() / game.getSize()));
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	switch (e.getKeyCode()){
    	case KeyEvent.VK_LEFT:
    	{
    		game.addNewSnake(1);
    		if(game.getSnake(1).getDirection() !=Direction.RIGHT){
    			game.getSnake(1).setDirection(Direction.LEFT);
    		}
    		break;
    	}
    	case KeyEvent.VK_RIGHT:
    	{
    		game.addNewSnake(1);
    		if(game.getSnake(1).getDirection() !=Direction.LEFT){
    			game.getSnake(1).setDirection(Direction.RIGHT);
    		}
    		break;
    	}
    	case KeyEvent.VK_UP:
    	{
    		game.addNewSnake(1);
    		if(game.getSnake(1).getDirection() !=Direction.DOWN){
    			game.getSnake(1).setDirection(Direction.UP);
    		}
    		break;
    	}
    	case KeyEvent.VK_DOWN:
    	{
    		game.addNewSnake(1);
    		if(game.getSnake(1).getDirection() !=Direction.UP){
    			game.getSnake(1).setDirection(Direction.DOWN);
    		}
    		break;
    	}
    	case KeyEvent.VK_Q:
    	{
    		game.addNewSnake(0);
    		if(game.getSnake(0).getDirection() !=Direction.RIGHT){
    			game.getSnake(0).setDirection(Direction.LEFT);
    		}
    		break;
    	}
    	case KeyEvent.VK_D:
    	{
    		game.addNewSnake(0);
    		if(game.getSnake(0).getDirection() !=Direction.LEFT){
    			game.getSnake(0).setDirection(Direction.RIGHT);
    		}
    		break;
    	}
    	case KeyEvent.VK_Z:
    	{
    		game.addNewSnake(0);
    		if(game.getSnake(0).getDirection() !=Direction.DOWN){
    			game.getSnake(0).setDirection(Direction.UP);
    		}
    		break;
    	}
    	case KeyEvent.VK_S:
    	{
    		game.addNewSnake(0);
    		if(game.getSnake(0).getDirection() !=Direction.UP){
    			game.getSnake(0).setDirection(Direction.DOWN);
    		}
    		break;
    	}
    	default:
    	{
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