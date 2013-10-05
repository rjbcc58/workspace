import java.awt.Graphics;
import java.awt.Point;

public class Player extends GameObject {
	private int health;
	private String name;
	
	Player(int x, int y) {
		super(x, y);
		this.name = "ThePlayer";
	}
	
	Player(Point position) {
		super(position);
		this.name = "ThePlayer";
	}

	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
}