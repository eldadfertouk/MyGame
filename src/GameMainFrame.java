import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JFrame{

    public static int SCREENWIDTH=900, SCREENHEIGHT =800;
    public int currentLevel = 1;

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
    public GameMainFrame(int currentLevel){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        //this.getContentPane().add(new MenuPanel());
        this.setSize(SCREENWIDTH, SCREENHEIGHT);
        this.getContentPane().add(new Level(currentLevel));
        this.setFocusable(true);
        this.setVisible(true);
        this.pack();
    }
}
