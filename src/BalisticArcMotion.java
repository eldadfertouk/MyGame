import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class BalisticArcMotion extends JPanel {
    static int playerX = 200,playerY = 400;
    static int vectorToTarget;
    static int x1 = playerX = 600;// X from player current place
    static int y1 = playerY = 650;// Y from player current place
    static int x2 = x1;
    static int y2 = y1;
    static int cx1 = 5;//offset X
    static int cy1 = 5;// offset Y
    static int Xtarget = 750, Ytarget = 75;
    static int sightX = Xtarget; // X from Sight
    static int sightY = Ytarget; //Y from Sight
    static int sinTargetX2 = x2;
    static int sinTargetY2 = y2;
    static int H=0,W=0,J=0;
    static int px=400,py=400,tx=250,ty=50;
    static int deltaX = px - (tx * -1);
    static int deltaY = py - (py * -1);
    static int slope = deltaY / deltaX;
    final static int vectorLength = 100;
    final static int sinx2 = px;
    final static int siny2 = py;
    static double countClock,countSinus = 0;
    private static BalisticArcMotion run = new BalisticArcMotion();

    final Timer print = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            increaseSinusGraph();
            increaseClockVector();
            countClock+=6; //for clock for 1 second
            countSinus++;//for sinus*/
            if (countClock % 360 == 0)
                System.out.println((countClock / 360) + " minute passed");
        }
    });


    BalisticArcMotion() {
        print.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(run);
        frame.setSize(900, 700);
        frame.setVisible(true);
    }

    static void increaseClockVector() {
        double cos = Math.cos(Math.toRadians(countClock));
        double sin = Math.sin(Math.toRadians(countClock));
        y1 = siny2 + (int) (vectorLength * sin);
        x1 = sinx2 + (int) (vectorLength * cos);
        x2 = x1 + (int) (vectorLength+J * cos);
        y2 = y1 + (int) (vectorLength+J * sin);
    }

    static void increaseSinusGraph() {
        double sin = Math.sin(Math.toRadians(countSinus));
        y2 = siny2 + (int) (vectorLength * sin);
        y1 = siny2 + (int) (vectorLength * sin);
        x2++;
        x1++;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0,0,0));
        g.drawRect(1,1,995,695);
        g.setColor(new Color(50,150,40));
        g.create(x1,y1,15,15);
        g.drawOval(px,py,50,50);//player
        g.setColor(new Color(20,0,250));
        g.drawArc(px,py,tx+px,py+ty,slope,180);//balisticArc
        g.setColor(new Color(200,0,45));
        g.drawOval(tx,ty,25,25);//enemy
        g.drawLine(px,py,tx,ty);
        g.drawString("OVAL",x1,y1);
        repaint();
    }
}
