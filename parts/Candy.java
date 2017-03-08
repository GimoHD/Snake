package parts;

import java.awt.Color;

/**
 * Created by Kristof on 17/02/2017.
 */
public class Candy extends Tile {
    public Candy(int x, int y) {
		super(x, y);
		this.setColor(Color.RED);
	}
    
    public void setLocation(int x, int y){
        this.setX(x);
        this.setY(y);
    }
}
