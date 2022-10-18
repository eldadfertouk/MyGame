import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpiralMissileMotion extends JPanel {
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
    static double count = 360;

    private static final SpiralMissileMotion run = new SpiralMissileMotion();
    final Timer print = new Timer(50, new ActionListener(){
        @Override
        public void actionPerformed(final ActionEvent e) {
         //   increaseSinusLine();
          //  increaseSpiralVector();

            decreaseSpiralVector();
            increaseVectorToTarget();
            count+=6; //for clock for 1 second
            count++;//for sinus*/
            if (count % 360 == 0)
                System.out.println((count / 360) + " minute passed");
        }
    });
   SpiralMissileMotion() {
        print.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spiral Motion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(run);
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
    static void increaseSpiralVector(){
        double cos = Math.cos(Math.toRadians(count));
        double sin = Math.sin(Math.toRadians(count));
        y2 = sinTargetY2 + (int) (vectorToTarget * sin);
        x2 = sinTargetX2 + (int) (vectorToTarget * cos);
    }
    static void decreaseSpiralVector(){
        double cos = Math.cos(Math.toRadians(count));
        double sin = Math.sin(Math.toRadians(count));
        y2 = sinTargetY2 - (int) (vectorToTarget * sin);
        x2 = sinTargetX2 - (int) (vectorToTarget * cos);
        y2--;
        x2--;
    }
    static void increaseSinusLine(){
        double sin = Math.sin(Math.toRadians(count));
        y2 = sinTargetY2 + (int) (vectorToTarget * sin);
        cy1 = sinTargetY2 + (int) (vectorToTarget * sin);
        x2++;
        y2++;
    }
    static void increaseVectorToTarget(){
        if (vectorToTarget <= 360){
            vectorToTarget += 1;}
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0,0,0));
        //paint grid
        g.drawLine(x1, y1, x2, y2);//for clock
        g.drawLine(x2, y2, x2+10, y2+10);//for sinus*/
        g.setColor(new Color(0,250,0));
        g.drawArc(x2,y2,50,50,45,360);
        g.setColor(new Color(250,0,0));//set mark for designated target
        g.create(playerX,playerY,250,250);
        g.drawLine(playerX,playerY,Xtarget,Ytarget);//draw line from player to sight current location
        g.drawOval(sightX,sightY,25,25);//draw circle on designated target
        g.setColor(new Color(0,25,250));
        g.drawLine(cx1, cy1, x2 + 15, y2 + 15);
        g.drawArc(cx1,cy1,25,25,0,360);//rolling circle on the tip of the vector
        repaint();
    }
}
