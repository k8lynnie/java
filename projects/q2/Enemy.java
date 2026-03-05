    //graphics
import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
        //private instance variables
    private int x, y, width, height;
    private Color pink, white, black;
    private int yDirection;
    private int count;
    private boolean visible;

        //constructor
    public Enemy() {
            //position
        x = 800;
        y = (int) (Math.random() * 550 + 1);
            //colors
        pink = new Color(255, 163, 244);
        white = new Color(255, 255, 255);
        black = new Color(0, 0, 0);
            //for moving
        count = 0;
        yDirection = 1;
            //width and height
        width = 50;
        height = 50;
            //drawing enemies is true or not
        visible = true;
    }
    //methods
        //draw enemy
    public void drawEnemy(Graphics g) {
        if (visible) {
            //body
            g.setColor(pink);
            g.fillOval(x, y, width, height);
            //eye
            g.setColor(white);
            g.fillOval(x + 12, y + 7, 26, 26);
            g.setColor(pink);
            g.fillOval(x + 18, y + 13, 14, 14);
            g.setColor(black);
            g.fillOval(x + 22, y + 17, 6, 6);
        }
    }
    //getters
    public boolean getVisible() {
        return visible;
    }
    //change visibility
    public void revive() {
        visible = true;
    }
    public void die() {
        visible = false;
    }
    //reset
    public void reset() {
        if (visible) {
            x = 800;
        }
    }
    //move method
    public void move(int level, int speed) {
            //if not visible don't draw
        if (!visible) {
            return;
        }
            //move horizontally
        x -= speed;
            //reset position
        if (x + width < 0) {
            x = 800;
            y = (int)(Math.random() * 550);
            visible = true;
        }
            //vertical movement
        if (y > 550) {
            yDirection = 2;
        }
        else if (y < 0) {
            yDirection = 1;
        }
            //change vertical direction periodically based on level
        if (level == 1 && count > 50) {
            yDirection = (int) (Math.random() * 2 + 1);
            count = 0;
        } 
        else if (level == 2 && count > 20) {
            yDirection = (int) (Math.random() * 2 + 1);
            count = 0;
        }
            // move vertically
        if (yDirection == 1) {
            moveDown();
        }
        else {
            moveUp();
        }
    }
    //move methods
    public void moveUp() {
        y--;
    }
    public void moveDown() {
        y++;
    }
    //getter
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}