import java.awt.Graphics;
import java.awt.Point;
import javax.swing.text.Position;


public abstract class GameObject {
	private Point position;
	
	GameObject(int x, int y) {
		position.x = x;
		position.y = y;
	}
	
	GameObject(Point position) {
		this.position = position;
	}
	
	void moveTo(int x, int y) {
		position.x = x;
		position.y = y;
	}
	
	void moveTo(Point position) {
		this.position = position;
	}
	public void moveDown() {
		moveTo(position.x, position.y + 1);
	}
	
	public void moveUp() {
		moveTo(position.x, position.y - 1);
	}

	public void moveRight() {
		moveTo(position.x + 1, position.y);
	}

	public void moveLeft() {
		moveTo(position.x - 1, position.y);
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}
	
	public Point getPosition() {
		return position;
	}
}
