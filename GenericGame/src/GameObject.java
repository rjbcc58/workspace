import java.awt.Graphics;
import java.awt.Point;
import javax.swing.text.Position;


public abstract class GameObject {
	Point position;
	
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
	
	void moveDown() {
		moveTo(position.x, position.y+1);
	}
	
	// abstract void paintComponent(Graphics g);
	
}
