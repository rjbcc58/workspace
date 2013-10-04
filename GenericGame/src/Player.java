import java.awt.Graphics;
import java.awt.Point;

public class Player extends GameObject {
	int health;
	String name;
	
	Player(int x, int y) {
		super(x, y);
		this.name = "ThePlayer";
	}
	
	Player(Point position) {
		super(position);
		this.name = "ThePlayer";
	}
	
}