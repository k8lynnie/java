    //import graphics
import java.awt.Graphics;
import java.awt.Color;

public class BackgroundStar {
        //private instance variables
    private int x, y, width, height;
    private Color white;

        //constructor
    public BackgroundStar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
            //colors
        white = new Color(235, 240, 255);
    }
    
    //methods
        //draw the stars
    public void drawBackgroundStar(Graphics g) {
            //draw the background star
        g.setColor(white);
        g.fillOval(x, y, width, height);
    }
}
