import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.Game;
import gui.GUI;

public class Main {

	public static void main(String[] args) {
		final Game game = new Game();
		SwingUtilities.invokeLater(() -> {
			GUI frame = new GUI("Game", game);
			game.setGui(frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.pack();
			frame.setVisible(true);
			frame.init();
		});
	}
}
