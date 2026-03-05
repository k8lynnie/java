//import graphics
import java.awt.Graphics;
    //import images
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CollectibleStar {
        //instance variables
    private int x, y, width, height;
    private boolean collected, visible;
    private BufferedImage star;
    
        //constructor
    public CollectibleStar() {
            //variable instantiation
        collected = false;
        visible = false;
        x = 800;
        y = (int)(Math.random() * 500 + 50);
            //image instantiation
        try {
            star = ImageIO.read(new File("images/collectibleStar.png"));
            width = star.getWidth();
            height = star.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
            star = null;
            width = 40;
            height = 40;
        }
    }
    //methods
        //draw the stars
    public void drawCollectibleStar(Graphics g) {
            //draw the collectible star
        if (visible && !collected) {
            g.drawImage(star, x, y, null);
        }
    }
        //move the star
    public void move() {
        if (visible && !collected) {
            x -= 2;
            if (x < -width) {
                visible = false;
                collected = false; 
            }
        }
    }
    //spawn the star on screen
    public void spawn() {
        if (!visible) {
            collected = false;
            visible = true;
            x = 800;
            y = (int)(Math.random() * 500 + 50);
        }
    }

    //mark as collected
    public void collect() {
        collected = true;
        visible = false;
    }

    //collision detection with spaceship
    public boolean checkCollision(Spaceship s) {
        int sX = s.getX();
        int sY = s.getY();
        int sWidth = s.getWidth();
        int sHeight = s.getHeight();

        return visible && !collected &&
               sX + sWidth >= x && sX <= x + width &&
               sY + sHeight >= y && sY <= y + height;
    }

    //getters
    public boolean isVisible() { 
        return visible; 
    }
    public boolean isCollected() { 
        return collected; 
    }
}