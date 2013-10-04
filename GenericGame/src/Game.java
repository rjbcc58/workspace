import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JPanel implements KeyListener {
    private final int DEFAULT_HEIGHT= 450,
    				  DEFAULT_WIDTH = 800;
	World world;
	/*
	Game(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	Game() {
		this.gamePanel = new GamePanel();
	}*/
	
	Game(World world) {
		this.world = world;
	}
	
	Game() {
		this.world = new World(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public void createAndShowGUI() {
		JFrame f = new JFrame("The G A M E");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gamePanel.addKeyListener(this);
		//gamePanel.setFocusable(true);
		
		//f.add(gamePanel);
		
		f.add(this);
		f.setFocusable(true);
		
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		final Game theGame = new Game();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				theGame.createAndShowGUI();
			}
		});
	}

	   public void keyTyped(KeyEvent e) {
		   System.out.println("here");
	        displayInfo(e, "KEY TYPED: ");
	    }

	    /** Handle the key-pressed event from the text field. */
	    public void keyPressed(KeyEvent e) {
	    	world.keyPressed(e);
	    	

	    }

	    /** Handle the key-released event from the text field. */
	    public void keyReleased(KeyEvent e) {
	        displayInfo(e, "KEY RELEASED: ");
	        System.out.println("here");
	    }
	    			    
	    //JPanel Methods
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			world.paintComponent(g);
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}
		
		// Testing key events
		
	    private void displayInfo(KeyEvent e, String keyStatus){
	        
	        //You should only rely on the key char if the event
	        //is a key typed event.
	        int id = e.getID();
	        String keyString;
	        if (id == KeyEvent.KEY_TYPED) {
	            char c = e.getKeyChar();
	            keyString = "key character = '" + c + "'";
	        } else {
	            int keyCode = e.getKeyCode();
	            keyString = "key code = " + keyCode
	                    + " ("
	                    + KeyEvent.getKeyText(keyCode)
	                    + ")";
	        }
	        
	        int modifiersEx = e.getModifiersEx();
	        String modString = "extended modifiers = " + modifiersEx;
	        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
	        if (tmpString.length() > 0) {
	            modString += " (" + tmpString + ")";
	        } else {
	            modString += " (no extended modifiers)";
	        }
	        
	        String actionString = "action key? ";
	        if (e.isActionKey()) {
	            actionString += "YES";
	        } else {
	            actionString += "NO";
	        }
	        
	        String locationString = "key location: ";
	        int location = e.getKeyLocation();
	        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	            locationString += "standard";
	        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	            locationString += "left";
	        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	            locationString += "right";
	        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	            locationString += "numpad";
	        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	            locationString += "unknown";
	        }
	        System.out.println("----------");
	        System.out.println(keyString);
	        System.out.println(modString);
	        System.out.println(actionString);
	        System.out.println(locationString);
	    }
}
