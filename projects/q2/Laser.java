    //import graphics
import java.awt.Color;
import java.awt.Graphics;

public class Laser {
        //private instance variables
	private int x;
	private int y;	
	private int width;
	private int height;
	private Color red;
    private boolean visible;

        //constructor
	public Laser() {
            //variable instantiation
		x = 85;
		y = 295;
		width = 10;
		height = 10;
		red = new Color(255, 76, 76);
        visible = false;
	}
    //methods
        //fire laser
    public void fire(int shipY) {
        visible = true;
        x = 85;
        y = shipY + 10;
    }  
        //draw laser
	public void drawLaser(Graphics g) {
		if (visible) {
            g.setColor(red);
	    	g.fillOval(x, y, width, height);
        }
	}
        //move methods
    public void moveRight() {
        if (visible) {
            x += 5;
        }

        if (x > 800) {
            visible = false;
            x = 85;
        }
    }
        //update y position
    public void updateY(int y) {
        if (!visible) {
            this.y = y + 10;
        }
    }
        //check collisions with enemy
    public void checkCollision(Enemy e) {
		if (e.getVisible()) {
                //laser variables
            int pX = x;
            int pY = y;
            int pWidth = width;
            int pHeight = height;
                //enemy variables
            int eX = e.getX();
            int eY = e.getY();
            int eWidth = e.getWidth();
            int eHeight = e.getHeight();
                //check collision
            if (visible) {
                if (pX + pWidth >= eX && pX <= eX + eWidth  &&  pY + pHeight >= eY && pY <= eY + eHeight) {
                    e.die();
                    visible = false;
                    x = 85;
                }
            }
        }
	}
        //check collisions with boss
    public void checkCollisionB(Boss b) {
		if (b.getVisible()) {
                //laser variables
            int pX = x;
            int pY = y;
            int pWidth = width;
            int pHeight = height;
                //boss variables
            int bX = b.getX();
            int bY = b.getY();
            int bWidth = b.getWidth();
            int bHeight = b.getHeight();
                //check collision
            if (visible) {
                if (pX + pWidth >= bX && pX <= bX + bWidth  &&  pY + pHeight >= bY && pY <= bY + bHeight) {
                    b.die();
                    visible = false;
                    x = 85;
                }
            }
        }
	}
    //getter
    public boolean isVisible() {
        return visible;
    }
}