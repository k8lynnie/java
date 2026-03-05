import javax.swing.JFrame;
import java.util.Scanner;
public class Runner {
    public static void main( String args[] ) {
            // Create the frame object. Give it a title appropriate to the application
        JFrame frame = new JFrame("Scenery Project");

            //instantiate scanner object
        Scanner input = new Scanner(System.in);
            //ask user to choose background (day/night + season)
        System.out.print("Select day or night for the background: ");
        String time = input.next();
        System.out.print("Select a season (winter, fall, spring) for the background: ");
        String season = input.next();
            //close scanner
        input.close();

            //Create the JPanel object and add it to the frame
        Scenery canvas = new Scenery(time, season);
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
