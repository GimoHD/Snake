package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import gamemode.GameMode;

/**
 * @author Kristof
 *
 */

public class ControlPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Game game;
	JComboBox<GameMode> choose;
	JButton startButton;
	JLabel  status;
	JLabel  score;
	
	public ControlPanel(Game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(1600, 50));
		status = new JLabel("Started game");
		status.setFocusable(false);
		score = new JLabel("Score: Snake 1: 0 - Snake 2: 0");
		score.setFocusable(false);
		startButton = new JButton("Start");
		startButton.setFocusable(false);
		startButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.reset((GameMode) choose.getSelectedItem());				
			}
			
		});
		choose = new JComboBox<GameMode>();
		for (GameMode mode: game.getGameModes()){
			choose.addItem(mode);
		}
				
		choose.setFocusable(false);
		this.add(status);
		this.add(startButton);
		this.add(choose);
		this.add(score);
		
	}
	 public void print(String s){
	    	status.setText(s);
	    }
	 public void setScore(int a, int b){
	    	score.setText("Score: Snake 1: " + a + " - Snake 2: " + b);
	    }
	

	
}
