package gui;

import java.awt.Dimension;

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
	JLabel status;
	JLabel score;

	public ControlPanel(Game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(1600, 50));
		this.status = new JLabel("Started game");
		this.status.setFocusable(false);
		this.score = new JLabel("Score: Snake 1: 0 - Snake 2: 0");
		this.score.setFocusable(false);
		this.startButton = new JButton("Start");
		this.startButton.setFocusable(false);
		this.startButton.addActionListener(arg0 -> game.reset((GameMode) ControlPanel.this.choose.getSelectedItem()));
		this.choose = new JComboBox<>();
		for (GameMode mode : game.getGameModes()) {
			this.choose.addItem(mode);
		}

		this.choose.setFocusable(false);
		this.add(this.status);
		this.add(this.startButton);
		this.add(this.choose);
		this.add(this.score);

	}

	public void print(String s) {
		this.status.setText(s);
	}

	public void setScore(int a, int b) {
		this.score.setText("Score: Snake 1: " + a + " - Snake 2: " + b);
	}

}
