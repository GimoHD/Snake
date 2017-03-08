import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.Game;
import gui.GUI;

public class Main {

    public static void main(String[] args) {
	// write your code here
    	final Game game = new Game();
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI frame = new GUI("Game",game);
               
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
                frame.init();
            }
        });
  /*  	
        final Game game = new Game();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                game.reDraw();
            }
        }, 1000, 1000);
        Scanner scanner = new Scanner(System.in);
        System.out.print(game.toString());

        while(true) {
            String input = scanner.next();
            if (input.equals("q")) {
                game.setDirection(Direction.LEFT);
            } else if (input.equals("d")) {
                game.setDirection(Direction.RIGHT);
            } else if (input.equals("z")) {
                game.setDirection(Direction.UP);
            } else if (input.equals("s")) {
                game.setDirection(Direction.DOWN);
            }
        }
*/
    }
}
