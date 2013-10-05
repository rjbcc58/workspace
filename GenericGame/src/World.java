import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class World extends JPanel {
	private int heightPx, widthPx, height, width;
	private final int DEFAULT_SQUARE_HEIGHT = 25,
			          DEFAULT_SQUARE_WIDTH = 25;
	Player player;
	Point startPoint;
	
	World(int heightPx, int widthPx) {
		this.heightPx = heightPx;
		this.widthPx = widthPx;
		this.height = this.heightPx / DEFAULT_SQUARE_HEIGHT;
		this.width = this.widthPx / DEFAULT_SQUARE_WIDTH;
		this.player = new Player(new Point(20,0));
	}
	
	World(int heightPx, int widthPx, int height, int width) {
		this.heightPx = heightPx; 
		this.widthPx =  widthPx;
		this.height = height;
		this.width = width;
		this.player = new Player(new Point(20,0));
	}
	
	// Key Events delegated to the World class	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	movePlayerDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	movePlayerLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	movePlayerRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	movePlayerUp();
        }
	}
	
	// Player methods
	public void movePlayerDown() {
		player.moveDown();
	}
	
	private void movePlayerUp() {
		player.moveUp();	
	}

	private void movePlayerRight() {
		player.moveRight();
	}

	private void movePlayerLeft() {
		player.moveLeft();
	}

	public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	movePlayerDown();
        }
	}
	
	public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	movePlayerDown();
        }
	}
	
	// Paint methods
	
	public void paintComponent(Graphics g) {
		int x = player.getX() * DEFAULT_SQUARE_WIDTH;
		int y = player.getY() * DEFAULT_SQUARE_HEIGHT;
		
		g.fillRect(x, y, this.DEFAULT_SQUARE_WIDTH, DEFAULT_SQUARE_HEIGHT);		
	}
	
	
	// Getter Methods
	public int getWidthPx() {
		return widthPx;
	}

	public int getHeightPx() {
		return heightPx;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	// Main method for Testing
	public static void main(String[] args) {
		final World w = new World(450, 800);
		JFrame f = new JFrame("test");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponents(g);
				w.paintComponent(g);
			}
			public Dimension getPreferredSize() {
				return new Dimension(w.widthPx, w.heightPx);
			}
		});
		
		f.pack();
		f.setVisible(true);
	}
}