//import graphics
import java.awt.Graphics;
import java.awt.Color;
    //import fonts
import java.awt.Font;
    //import imported images
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ArcadeGame {
    //private instance variables
    public static int startScreen = 0;
    public static int level1 = 1;
    public static int level2 = 2;
    public static int endScreen = 3;
    private int state, level, lives;
    //colors
    private Color screenBackground, boxPurple, black, level1Background, level2Background;
    //images
    private BufferedImage gameTitle, smallPinkStar, smallBlueStar;  
    //stars
    private BackgroundStar[] backgroundStars1;
    private BackgroundStar[] backgroundStars2;
    private CollectibleStar[] starLvl1;
    private CollectibleStar[] starLvl2;
    private int starsCollected;
    private int starsRequired1, starsRequired2;
    private int starSpawnTimer;
    //objects
    private Spaceship spaceship;
    private Laser[] lasers;
    private Enemy[] enemies1;
    private Enemy[] enemies2;
    private Boss[] boss;
    
    //constructor
    public ArcadeGame() {
        state = startScreen;
        level = 1;
        lives = 5;
            //colors
        screenBackground = new Color(195, 229, 255);
        boxPurple = new Color(197, 196, 250);
        black = new Color(0, 0, 0);
        level1Background = new Color(15, 43, 80);
        level2Background = new Color(50, 81, 124);
            //instantiate class objects
        spaceship = new Spaceship();
        lasers = new Laser[10];
        for (int i = 0; i < lasers.length; i++) {
            lasers[i] = new Laser();
        }

        // initialize level 1 collectible stars
        starLvl1 = new CollectibleStar[3];
        for (int i = 0; i < 3; i++) {
            starLvl1[i] = new CollectibleStar();
        }

        // initialize level 2 collectible stars
        starLvl2 = new CollectibleStar[5];
        for (int i = 0; i < 5; i++) {
            starLvl2[i] = new CollectibleStar();
        }
        starsCollected = 0;
        starsRequired1 = 3;
        starsRequired2 = 5;
        starSpawnTimer = 0;
            //instantiate image objects
        try {
            gameTitle = ImageIO.read(new File("images/starBlaster.png"));
            smallPinkStar = ImageIO.read(new File("images/smallPinkStar.png"));
            smallBlueStar = ImageIO.read(new File("images/smallBlueStar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
            //initialize level 1 background stars
        backgroundStars1 = new BackgroundStar[150];
        for (int i = 0; i < backgroundStars1.length; i++) {
            int x = (int)(Math.random() * 800);
            int y = (int)(Math.random() * 800);
            int size = (int)(Math.random() * 4) + 2;
            backgroundStars1[i] = new BackgroundStar(x, y, size, size);
        }
            //level 1 enemies
        enemies1 = new Enemy[5];
        for (int i = 0; i < enemies1.length; i++) {
            enemies1[i] = new Enemy();
        }
            //initialize level 2 background stars
        backgroundStars2 = new BackgroundStar[200];
        for (int i = 0; i < backgroundStars2.length; i++) {
            int x = (int)(Math.random() * 800);
            int y = (int)(Math.random() * 800);
            int size = (int)(Math.random() * 4) + 2;
            backgroundStars2[i] = new BackgroundStar(x, y, size, size);
        }
            //level 2 enemeis
        enemies2 = new Enemy[10];
        for (int i = 0; i < enemies2.length; i++) {
            enemies2[i] = new Enemy();
        }
            //level 2 boss
        boss = new Boss[3];
        for (int i = 0; i < boss.length; i++) {
            boss[i] = new Boss();
        }
    }

    //setter/getter
    public void setState(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }
    public Spaceship getSpaceship() { 
        return spaceship; 
    }
    public int getLives() {
        return lives;
    }
    public Enemy[] getEnemies2() {
        return enemies2;
    }
    public Boss[] getBoss() {
        return boss;
    }
    //methods
    //------------ start screen ------------
    public void drawStartScreen(Graphics g) {
			//draw background
		g.setColor(screenBackground);
		g.fillRect(0, 0, 800, 600);
			//game instructions
		g.setColor(boxPurple);
		g.fillRect(125, 205, 530, 200);
		g.setColor(black);
		g.setFont(new Font("Verdana", Font.PLAIN, 14));
		g.drawString("Welcome to Star Blaster!", 135, 222);
		g.drawString("The mission: help the spaceship travel safely through outer space", 135, 245);
		g.drawString("and defend itself against space enemies and collect stars along the way", 135, 262);
		g.drawString("Level 1: collect 3 stars and defeat space enemies to land safely at planet", 135, 281);
		g.drawString("Level 2: collect 5 stars and defeat space enemies and their boss to land", 135, 298);
		g.drawString("safely at planet", 135, 315);
		g.drawString("Instructions:", 135, 337); 
		g.drawString("Use the up and down arrows to move the spaceship", 135, 356);
		g.drawString("Use the space bar to shoot lasers to blast the space enemies", 135, 375);
		g.drawString("Choose your level, then press start!", 135, 394);
            //game title
        g.drawImage(gameTitle, -400, -220, null);
        g.drawImage(smallPinkStar, 40, 70, null);
        g.drawImage(smallPinkStar, -550, -275, null);
        g.drawImage(smallBlueStar, -100, 0, null);
	}
    // ------------ Level 1 ------------
    public void drawLevel1(Graphics g) {
            //draw background
        g.setColor(level1Background);
        g.fillRect(0, 0, 800, 600);
            //draw lives
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 14));
        g.drawString("Lives: " + lives, 20, 30);
        g.drawString("Stars: " + starsCollected + "/" + starsRequired1, 20, 50);
            //draw background stars
        for (BackgroundStar s : backgroundStars1) {
            s.drawBackgroundStar(g);
        }
            //draw spaceship
        spaceship.drawSpaceship(g); 
            //draw lasers
        for (Laser l : lasers) {
            l.drawLaser(g);
        }
            //draw enemies
        for (Enemy e : enemies1) {
            e.drawEnemy(g);
        }
            //draw collectible stars
        for (CollectibleStar s : starLvl1) {
            s.drawCollectibleStar(g);
        }
    }
    //------------ Level 2 ------------
    public void drawLevel2(Graphics g) {
            //draw background
        g.setColor(level2Background);
		g.fillRect(0, 0, 800, 600);
            //draw lives
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", Font.BOLD, 14));
        g.drawString("Lives: " + lives, 20, 30);
        g.drawString("Stars: " + starsCollected + "/" + starsRequired2, 20, 50);
            //background stars
        for (BackgroundStar s : backgroundStars2) {
            s.drawBackgroundStar(g);
        }
            //draw spaceship
        spaceship.drawSpaceship(g);
            //draw lasers
        for (Laser l : lasers) {
            l.drawLaser(g);
        }
            //draw enemies
        for (Enemy e : enemies2) {
            e.drawEnemy(g);
        }
            // draw boss
        for (Boss b : boss) {
            b.drawBoss(g);
        }
            //draw stars
        for (CollectibleStar s : starLvl2) {
            if (!s.isCollected()) {
                s.drawCollectibleStar(g);
            }
        }
    }
    //------------ end screen ------------
	public void drawEndScreen(Graphics g) {
            //draw background
		g.setColor(screenBackground);
		g.fillRect(0, 0, 800, 600);
            //show game stats
        g.setColor(boxPurple);
		g.fillRect(125, 205, 530, 200);
            //diferent end screens
		g.setColor(black);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        if (lives == 0) {
            g.drawString("GAME OVER", 255, 265);
            g.drawString("Lives : 0", 255, 295);
        }
        else if (starsCollected == starsRequired1) {
            g.drawString("LEVEL 1: completed", 255, 265);
            g.drawString("Stars Collected: 3", 255, 295);
        }
        else if (starsCollected == starsRequired2) {
            g.drawString("LEVEL 2: completed", 255, 265);
            g.drawString("Stars Collected: 5", 255, 295);
        }
            //call animations
            //decorations
        g.drawImage(gameTitle, -400, -220, null);
        g.drawImage(smallPinkStar, 40, 70, null);
        g.drawImage(smallPinkStar, -550, -275, null);
        g.drawImage(smallBlueStar, -100, 0, null);
	}
    //animate laser
    public void fireLaser() {
        for (Laser l : lasers) {
            if (!l.isVisible()) {
                l.fire(spaceship.getY());
                break;
            }
        }
    }
    public void animateLaser() {
        for (Laser l : lasers) {
            l.moveRight();

            // check collision for level 1 enemies
            if (state == level1) {
                for (Enemy e : enemies1) {
                    l.checkCollision(e);
                }
            } 
            // check collision for level 2 enemies
            else if (state == level2) {
                for (Enemy e : enemies2) {
                    l.checkCollision(e);
                }
                for (Boss b : boss) {
                    l.checkCollisionB(b);
                }
            }
        }
    }
    //animate enemies
    public void animateEnemies() {
            //move level 1 enemies
        if (state == level1) {
            for (Enemy e : enemies1) {
                e.move(level, 1);
            }
        } 
            //move level 2 enemies
        else if (state == level2) {
                //boss is visible
            for (Enemy e : enemies2) {
                e.move(level, 5);
            }

            for (Boss b : boss) {
                b.move();
            }
        }
    }
    //collisions between spaceship and enemies/bosses
    public void checkSpaceshipCollisions() {
        //level 1
        if (state == level1) {
            for (Enemy e : enemies1) {
                if (e.getVisible() && spaceship.checkCollision(e)) {
                    e.die();       // enemy disappears
                    lives--;       // spaceship loses a life
                    break;         // avoid multiple collisions in one frame
                }
            }
        }
        //level 2
        else if (state == level2) {
            for (Enemy e : enemies2) {
                if (e.getVisible() && spaceship.checkCollision(e)) {
                    e.die();
                    lives--;
                    break;
                }
            }
            for (Boss b : boss) {
                if (b.getVisible() && spaceship.checkCollisionB(b)) {
                    b.die();
                    lives--;
                    break;
                }
            }
        }
        //end screen when boss is gone
        if (!boss[0].getVisible() && starsCollected >= starsRequired2) {
            state = endScreen;
        }
        //game over if all the lives are gone
        if (lives <= 0) {
            state = endScreen;
        }
    }
    //animate stars
    public void animateStar() {
            //level 1 stars
        if (state == level1) {
            starSpawnTimer++;

            if (starSpawnTimer > 250) {
                for (CollectibleStar star : starLvl1) {
                    if (!star.isVisible()) {
                        star.spawn();
                        break; // spawn ONE star at a time
                    }
                }
                starSpawnTimer = 0;
            }

            for (CollectibleStar star : starLvl1) {
                star.move();

                if (star.checkCollision(spaceship)) {
                    star.collect();
                    starsCollected++;
                }
            }
            //end screen if stars collected is 3
            if (starsCollected >= starsRequired1) {
                state = endScreen;
            }
        }
        //level 2 stars
        else if (state == level2) {
                //draw stars
            starSpawnTimer++;
            if (starSpawnTimer > 250) {
                for (CollectibleStar star : starLvl2) {
                    if (!star.isVisible()) {
                        star.spawn();
                        break;
                    }
                }
                starSpawnTimer = 0;
            }

            for (CollectibleStar star : starLvl2) {
                star.move();
                if (star.checkCollision(spaceship)) {
                    star.collect();
                    starsCollected++;
                }
            }
            //end level
            if (starsCollected >= starsRequired2) {
                state = endScreen;
            }
        }
    }

    //get draw spaceship method
    public void getDrawSpaceship(Graphics g) {
        spaceship.drawSpaceship(g);
    }
}