package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	
	public ControlPanel(Game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(1600, 50));
		
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
		
		this.add(startButton);
		this.add(choose);
	}
	

	
}
