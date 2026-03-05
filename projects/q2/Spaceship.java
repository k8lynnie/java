    //import graphics
import java.awt.Color;
import java.awt.Graphics;

public class Spaceship {
        //private instance variables
	private int x, y, width, height;
	private Color grey;
    private Color darkgrey;
    private Color lightgrey;
        //constructors
    public Spaceship() {
            //assign variables
        x = 40;
        y = 285;
        width = 50;
        height = 30;
            //assign colors
        grey = new Color(120, 120, 120);
        darkgrey = new Color(89, 88, 88);
        lightgrey = new Color(186, 186, 186);
    }
    //methods
        //draw spaceship
	public void drawSpaceship(Graphics g) {
		g.setColor(grey);
        g.fillOval(x, y, width, height);
        g.fillRect(x, y, 25, 30);

        g.setColor(darkgrey);
        int[] ashipx = {x - 10, x + 10, x + 20, x};
        int[] ashipy = {y - 7, y - 7, y, y};
        g.fillPolygon(ashipx, ashipy, 4);
        int[] bshipx = {x - 10, x + 10, x + 20, x};
        int[] bshipy = {y + 37, y + 37, y + 30, y + 30};
        g.fillPolygon(bshipx, bshipy, 4);
        g.fillRect(x - 7, y + 12, 20, 6);

        g.setColor(lightgrey);
        g.fillOval(x + 23, y + 8, 14, 14);
	}
        //move methods
    public void moveUp() {
        y -= 10;
    }
    public void moveDown() {
        y += 10;
    }
        //getter
    public int getY () {
        return y;
    }
    public int getX() {
        return x;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
        //setter
    public void setY(int y) {
        this.y = y;
    }
        //collision detection with enemy
    public boolean checkCollision(Enemy e) {
        if (e.getVisible()) {
                //spaceship variables
            int sX = x;
            int sY = y;
            int sWidth = width;
            int sHeight = height;
                //enemy variables
            int eX = e.getX();
            int eY = e.getY();
            int eWidth = e.getWidth();
            int eHeight = e.getHeight();
                //check collisions
            if (sX + sWidth >= eX && sX <= eX + eWidth  &&  sY + sHeight >= eY && sY <= eY + eHeight) {
                return true;
            }
            return false;
        }
        return false;
    }
        //collision detection with boss
    public boolean checkCollisionB(Boss b) {
        if (b.getVisible()) {
                //spaceship variables
            int sX = x;
            int sY = y;
            int sWidth = width;
            int sHeight = height;
                //boss variables
            int bX = b.getX();
            int bY = b.getY();
            int bWidth = b.getWidth();
            int bHeight = b.getHeight();
                //check collision
            if (sX + sWidth >= bX && sX <= bX + bWidth  &&  sY + sHeight >= bY && sY <= bY + bHeight) {
                    return true;
            }
            return false;
        }
        return false;
    }
}