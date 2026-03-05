    //import graphics
import java.awt.Color;
import java.awt.Graphics;

public class Boss {
        //private instance variables
    private int x, y, width, height;
    private Color blue, white, black;
    private boolean visible;

        //constructor
    public Boss() {
        x = 800;
        y = (int) (Math.random() * 550 + 1);
        blue = new Color(94, 128, 247);
        white = new Color(255, 255, 255);
        black = new Color(0, 0, 0);
        width = 100;
        height = 100;
        visible = true;
    }
    //methods
        //draw boss
    public void drawBoss(Graphics g) {
        if (visible) {
            // body
            g.setColor(blue);
            g.fillOval(x, y, width, height);
            // eye
            g.setColor(white);
            g.fillOval(x + 24, y + 14, 52, 52);
            g.setColor(blue);
            g.fillOval(x + 36, y + 26, 28, 28);
            g.setColor(black);
            g.fillOval(x + 44, y + 34, 12, 12);
        }
    }
    //getter
    public boolean getVisible() {
        return visible;
    }
    //change visibility of boss
    public void revive() {
        visible = true;
    }

    public void die() {
        visible = false;
    }
    //reset position
    public void reset() {
        if (visible) {
            x = 800;
        }
    }
    //move boss
    public void move() {
            //don't draw if not visible
        if (!visible) {
            return;
        }
            //set boss speed
        x -= 2;
            //respawn
        if (x + width < 0) {
            x = 800;
            y = (int)(Math.random() * 300 + 100);
            visible = true;
        }
    }
    //move methods
    public void moveUp() {
        y -= 2;
    }
    public void moveDown() {
        y += 2;
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