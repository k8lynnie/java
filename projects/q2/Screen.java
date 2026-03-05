	//import graphics
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.Timer;
    //import keylistener
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
    //import actionlistener
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener, KeyListener{
        //instance variables
	private ArcadeGame game;
	private JButton start, level1, level2, restart;
	private int chooseLevel;
	private int testKey = 0;
	private Timer timer;

    //constructor
	public Screen() {
		setFocusable(true); 
		setLayout(null);

			//instantiate game
		game = new ArcadeGame();
		chooseLevel = 0;

			//set up start screen buttons
	    start = new JButton("start");
		restart = new JButton("restart");
		level1 = new JButton("level 1");
		level2 = new JButton("level 2");
	    	//set the position and size of the button, then add it to the JPanel
	    start.setBounds(280,465, 200, 50);
		restart.setBounds(280,465, 200, 50);
		level1.setBounds(150, 465, 100, 50);
		level2.setBounds(510, 465, 100, 50);
		restart.setVisible(false);
	    add(start);
		add(restart);
		add(level1);
		add(level2);
	    	//add action listening to the current object
	    start.addActionListener(this);
		restart.addActionListener(this);
		level1.addActionListener(this);
		level2.addActionListener(this);
		    //add key listener
		addKeyListener(this);
			//add timer
		timer = new Timer(16, this);
		timer.start();
	}

    @Override
	public Dimension getPreferredSize() {
		    //sets the size of the panel
        return new Dimension(800,600);
	}

    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
            //draw the different screens
		int state = game.getState();
		if (state == ArcadeGame.startScreen) {
			game.drawStartScreen(g);
		}
		else if (state == ArcadeGame.level1) {
			game.drawLevel1(g);
		}
		else if (state == ArcadeGame.level2) {
			game.drawLevel2(g);
		}
		else {
			game.drawEndScreen(g);
        	restart.setVisible(true);
        	start.setVisible(false);
        	level1.setVisible(false);
        	level2.setVisible(false);
		}
	}

    //methods
	    //interpret key clicks
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32) { //space bar
			game.fireLaser();
		}
		if (e.getKeyCode() == 38) {  //up arrow
			game.getSpaceship().moveUp();
		}
		if (e.getKeyCode() == 40) {  //down arrow
			game.getSpaceship().moveDown();
		}
		if (e.getKeyCode() == 57) { //testing key
			game.setState(testKey);
				//removing buttons
			if (testKey != 0) {
				start.setVisible(false);
				level1.setVisible(false);
				level2.setVisible(false);
			}
			else if (testKey == 0) {
				start.setVisible(true);
				level1.setVisible(true);
				level2.setVisible(true);
			}
				//changing the screen 
			if (testKey < 3) {
				testKey++;
			}
			else {
				testKey = 0;
			}
		}

		animate();
	}

    //button clicks
	public void actionPerformed(ActionEvent e) {
			//level 1
		if (e.getSource() == level1) {
			level1.setVisible(false);
			level2.setVisible(false);
			chooseLevel = 1;
		}
			//level 2
		if (e.getSource() == level2) {
			level1.setVisible(false);
			level2.setVisible(false);
			chooseLevel = 2;
		}
			//switch screens
		if (e.getSource() == start) {
			start.setVisible(false); 
			if (chooseLevel == 1) {
				game.setState(ArcadeGame.level1);
			}
			else {
				game.setState(ArcadeGame.level2);
				game.getBoss()[0].revive();
        		for (Enemy en : game.getEnemies2()) {
            		en.revive();
        		}
			}
		}
			//restart button
    	if (e.getSource() == restart) {
        	game = new ArcadeGame();
        	restart.setVisible(false);
        	start.setVisible(true);
        	level1.setVisible(true);
        	level2.setVisible(true);
        	requestFocusInWindow();
		}

		animate();
	}

    //animate method
    public void animate() {
		game.animateLaser();
		game.animateEnemies();
		game.checkSpaceshipCollisions();
		game.animateStar();
        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}