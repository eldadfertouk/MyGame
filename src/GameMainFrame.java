import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JFrame{

    public static int SCREENWIDTH=900, SCREENHEIGHT =800;

    public GameMainFrame(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        //this.getContentPane().add(new MenuPanel());
        this.setSize(SCREENWIDTH, SCREENHEIGHT);
        this.getContentPane().add(new Level(1));
        this.setFocusable(true);
        this.setVisible(true);
        this.pack();
    }
    public static void main(String[] args) {
//
        new WelcomeScreen();

    }
}
