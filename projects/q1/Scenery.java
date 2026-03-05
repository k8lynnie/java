import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.Timer;

public class Scenery extends JPanel{
        //creating instance variables
    String time, season;
    Color dayblue, nightblue, yellow, white, gray, brown, black, fallBrown, treeSpring, springGreen, bush;
    Color stoneGray, treeFall, house, roof, door, doorKnob, window, flowerPetalPink, flowerCenter, flowerLeaves;
    Color bird, tummy, cloud, flowerPetalPurple;
    Color bunny, ears;
    Color snowman, carrot;
        //cloud animation variables
    int cloudX;
    int cloudY;
    Timer cloudTimer;

    public Scenery(String time, String season) {
        setFocusable(true); // this is the default so you do not necessarily need this line.
        setLayout(null);    // setting to null allows you to control the layout of the Jpanel.
        
            //initialization code
        this.time = time;
        this.season = season;
        dayblue = new Color(173, 216, 230);
        nightblue = new Color(25, 46, 102);
        yellow = new Color(239,220,123);
        white = new Color(255,255,255);
        gray = new Color(183, 187, 196);
        brown = new Color(98,50,9);
        black = new Color (0, 0, 0);
        fallBrown = new Color(158, 124, 97);
        treeSpring = new Color(41, 138, 63);
        treeFall = new Color (221, 123, 64);
        springGreen = new Color(167, 218, 138);
        roof = new Color (223, 28, 82);
        stoneGray = new Color (126, 126, 126);
        house = new Color(243, 220, 182);
        window = new Color(226, 239, 252);
        door = new Color(160, 17, 57);
        doorKnob = new Color(78, 16, 33);
        bush = new Color(100, 150, 107);
        cloud = new Color(237, 238, 240);
        carrot = new Color(255, 165, 74);
        flowerCenter = new Color(252, 234, 108);
        flowerPetalPink = new Color(255, 157, 206);
        flowerPetalPurple = new Color(196, 162, 255);
        bird = new Color(94, 128, 247);
        tummy = new Color(191, 201, 233);
        bunny = new Color(160, 160, 160);
        ears = new Color(255, 182, 193);
            //cloud animation
        cloudX = -150;
        cloudY = 50;
            //animation timer
        cloudTimer = new Timer(50, new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                    //slow drift
                cloudX += 1;
                    //looping it
                if (cloudX > 800) {
                    cloudX = -150; // loop back
                }
                repaint();
            }
        });
        cloudTimer.start();
	}

	@Override
	public Dimension getPreferredSize() {
		    //sets the size of the panel
		return new Dimension(800,600);  //max size is 1920 (width) by 1080 (height)
	}

    /* Call all of your drawing methods from paintComponent(Graphics). You must pass the Graphics reference variable, g, to your
        draw methods. */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);   // DO NOT REMOVE THIS LINE
            //deciding which scene to draw
        if (time.equalsIgnoreCase("day")) {
            drawDay(g);
            if (season.equalsIgnoreCase("winter")) {
                drawWinter(g);
            }
            else if (season.equalsIgnoreCase("fall")) {
                drawFall(g);
            }
            else if (season.equalsIgnoreCase("spring")) {
                drawSpring(g);
            }
        }
        else {
            drawNight(g);
            if (season.equalsIgnoreCase("winter")) {
                drawWinter(g);
            }
            else if (season.equalsIgnoreCase("fall")) {
                drawFall(g);
            }
            else if (season.equalsIgnoreCase("spring")) {
                drawSpring(g);
            }
        }
	}

    //time
        //creating day background
	private void drawDay(Graphics g) {
            //drawing the sky
        g.setColor(dayblue);
        g.fillRect(0, 0, 800, 400);
            //draw the sun
        g.setColor(yellow);
        g.fillOval(670, 50, 100, 100);
            //draw cloud
        drawCloud(g, cloudX, cloudY);
	}
        //creating night background
    private void drawNight(Graphics g) {
            //drawing the sky
        g.setColor(nightblue);
        g.fillRect(0, 0, 800, 400);
            //draw moon
        g.setColor(gray);
        g.fillOval(670, 50, 100, 100);
        g.setColor(nightblue);
        g.fillOval(700, 25, 100, 100);
            //draw cloud
        drawCloud(g, cloudX, cloudY);
    }

    //season
        //creating winter
    private void drawWinter(Graphics g) {
            //draw ground
        g.setColor(white);
        g.fillRect(0, 400, 800, 200);
            //draw road
        g.setColor(stoneGray);
        g.fillOval(170, 430, 30, 10);
        g.fillOval(200, 470, 40, 20);
        g.fillOval(270, 500, 49, 25);
        g.fillOval(375, 510, 70, 25);
        g.fillOval(450, 550, 100, 45);
            //draw house
        drawHouse(g);
            //draw tree
        drawTree(g, 500, 250, brown);
        drawTree(g, 600, 300, brown);
        drawTree(g, 670, 250, brown);
            //draw snowman
        drawSnowman(g);
            //draw bush
        drawBush(g);
            //draw flower
        drawFlower(g);
            //draw bird
        drawBird(g);
            //draw bunny
        drawBunny(g, 80, 480);
    }
        //creating fall
    private void drawFall(Graphics g) {
            //draw ground
        g.setColor(fallBrown);
        g.fillRect(0, 400, 800, 200);
            //draw road
        g.setColor(stoneGray);
        g.fillOval(170, 430, 30, 10);
        g.fillOval(200, 470, 40, 20);
        g.fillOval(270, 500, 49, 25);
        g.fillOval(375, 510, 70, 25);
        g.fillOval(450, 550, 100, 45);
            //draw house
        drawHouse(g);
            //draw tree
        drawTree(g, 500, 250, treeFall);
        drawTree(g, 600, 300, treeFall);
        drawTree(g, 670, 250, treeFall);
            //draw bush
        drawBush(g);
            //draw flower
        drawFlower(g);
            //draw bird
        drawBird(g);
            //draw bunny
        drawBunny(g, 80, 480);
    }
        //creating spring
    private void drawSpring(Graphics g) {
            //draw ground
        g.setColor(springGreen);
        g.fillRect(0, 400, 800, 200);
            //draw road
        g.setColor(stoneGray);
        g.fillOval(170, 430, 30, 10);
        g.fillOval(200, 470, 40, 20);
        g.fillOval(270, 500, 49, 25);
        g.fillOval(375, 510, 70, 25);
        g.fillOval(450, 550, 100, 45);
            //draw house
        drawHouse(g);
            //draw tree
        drawTree(g, 500, 250, treeSpring);
        drawTree(g, 600, 300, treeSpring);
        drawTree(g, 670, 250, treeSpring);
            //draw bush
        drawBush(g);
            //draw flowers
        drawFlower(g);
            //draw bird
        drawBird(g);
            //draw bunny
        drawBunny(g, 80, 480);
    }
    //foreground objects
        //draw tree
    private void drawTree(Graphics g, int x, int y, Color leaves) {
        if (season.equalsIgnoreCase("winter")) {
                //draw tree trunk
            g.setColor(brown);
            g.fillRect(x, y, 20, 150);
        }
        else {
                //draw tree trunk
            g.setColor(brown);
            g.fillRect(x, y, 20, 150);
                //draw leaves
            g.setColor(leaves);
            g.fillOval((x - 25), (y - 70), 70, 100);
        }

    }
        //draw bush
    private void drawBush(Graphics g) {
        g.setColor(bush);
        g.fillOval(255, 380, 60, 50);
        g.fillOval(35, 380, 60, 50);
    }
        //draw house
    private void drawHouse(Graphics g) {
            //draw roof
        int[] xr = {50, 175, 300};
        int[] yr = {250, 150, 250};
        g.setColor(roof);
        g.fillPolygon(xr, yr, 3);
            //draw house
        g.setColor(house);
        g.fillRect(100, 250, 150, 170);
            //draw chimmeny
        g.setColor(roof);
        g.fillRect(200, 150, 30, 50);
            //draw windows
        g.setColor(window);
        g.fillRect(125, 270, 100, 50);
            //draw door + door knob
        g.setColor(door);
        g.fillRect(150, 330, 50, 90);
        g.setColor(doorKnob);
        g.fillOval(180, 370, 20, 20);
    }
        //draw flower
    private void drawFlower(Graphics g) {
            //draw stem
        g.setColor(flowerLeaves);
        g.fillRect(550, 410, 5, 30);
        g.fillRect(650, 410, 5, 30);
            //draw petals
        g.setColor(flowerPetalPink);
        g.fillOval(534, 402, 20, 20);
        g.fillOval(552, 402, 20, 20);
        g.fillOval(542, 375, 20, 20);
        g.fillOval(529, 387, 20, 20);
        g.fillOval(555, 387, 20, 20);
        g.setColor(flowerPetalPurple);
        g.fillOval(634, 402, 20, 20);
        g.fillOval(652, 402, 20, 20);
        g.fillOval(642, 375, 20, 20);
        g.fillOval(629, 387, 20, 20);
        g.fillOval(655, 387, 20, 20);
            //draw center
        g.setColor(flowerCenter);
        g.fillOval(545, 393, 15, 15);
        g.fillOval(645, 393, 15, 15);
        
    }
        //draw bird
    private void drawBird(Graphics g) {
        if (season.equalsIgnoreCase("winter")) {
                //draw body + head
            g.setColor(bird);
            g.fillOval(490, 199, 27, 27);
            g.fillOval(490, 210, 27, 37);
                //draw wings
            g.fillOval(486, 214, 20, 24);
            g.fillOval(501, 214, 20, 24);
                //draw tummy
            g.setColor(tummy);
            g.fillOval(493, 215, 20, 30);
                //draw eye
            g.setColor(black);
            g.fillOval(500, 204, 6, 6);
                //draw beak
            g.setColor(carrot);
            g.fillPolygon(new int[] {486, 497, 497}, new int[] {214, 207, 217}, 3);
        }
        else {
                //draw body + head
            g.setColor(bird);
            g.fillOval(483, 144, 27, 27);
            g.fillOval(483, 155, 27, 37);
                //draw wings
            g.fillOval(479, 159, 20, 24);
            g.fillOval(494, 159, 20, 24);
                //draw tummy
            g.setColor(tummy);
            g.fillOval(486, 160, 20, 30);
                //draw eye
            g.setColor(black);
            g.fillOval(493, 149, 6, 6);
                //draw beak
            g.setColor(carrot);
            g.fillPolygon(new int[] {479, 490, 490}, new int[] {159, 152, 163}, 3);
        }
    }
        //draw bunny
    private void drawBunny(Graphics g, int x, int y) {
            //draw body
        g.setColor(bunny);
        g.fillOval(x, y, 55, 45);
        g.fillOval(x + 35, y - 20, 30, 30);
            //draw tummy
        g.setColor(white);
        g.fillOval(x + 12, y + 12, 28, 18);
            //draw tail
        g.setColor(bunny);
        g.fillOval(x - 8, y + 15, 15, 15);
            //draw ears
        g.fillOval(x + 41, y - 50, 12, 32);
        g.fillOval(x + 51, y - 50, 12, 32);
            //draw inner ears
        g.setColor(ears);
        g.fillOval(x + 44, y - 45, 6, 22);
        g.fillOval(x + 54, y - 45, 6, 22);
            //draw eyes
        g.setColor(black);
        g.fillOval(x + 50, y - 12, 6, 6);
            //draw nose
        g.setColor(ears);
        g.fillOval(x + 60, y - 6, 10, 6);
    }
        //draw cloud
    private void drawCloud(Graphics g, int x, int y) {
            //draw big cloud
        g.setColor(cloud);
        g.fillOval(x, y + 10, 60, 40);
        g.fillOval(x + 30, y, 70, 50);
        g.fillOval(x + 60, y + 10, 50, 40);
        g.fillOval(x + 20, y + 20, 70, 40);
        g.fillOval(x + 50, y + 20, 60, 30);
            //draw small cloud
        g.fillOval(x + 150, y + 30, 40, 25);
        g.fillOval(x + 170, y + 20, 50, 30);
        g.fillOval(x + 190, y + 30, 35, 25);
        g.fillOval(x + 165, y + 40, 50, 25);
            //draw small cloud #2
        g.fillOval(x - 120, y + 10, 50, 30);
        g.fillOval(x - 100, y, 60, 35);
        g.fillOval(x - 80, y + 10, 40, 25);
        g.fillOval(x - 110, y + 15, 55, 30);
    }
        //draw snowman
    private void drawSnowman(Graphics g) {
            //draw body
        g.setColor(white);
        g.fillOval(360, 350, 65, 65);
        g.fillOval(365, 320, 53, 53);
        g.fillOval(369, 290, 44, 44);
            //draw buttons
        g.setColor(black);
        g.fillOval(388, 375, 10, 10);
        g.fillOval(387, 340, 10, 10);
            //draw eyes
        g.fillOval(383, 302,6, 6);
        g.fillOval(393, 302, 6, 6);
            //draw carrot 
        g.setColor(carrot);
        g.fillPolygon(new int[] {377, 393, 393}, new int[] {317, 310, 325}, 3);
    }
}
