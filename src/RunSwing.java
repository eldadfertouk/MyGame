import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunSwing extends JPanel {
    static int x1 = 500;
    static int y1 = 200;
    static int x2 = x1;
    static int y2 = y1;
    static int bx1 = 400;
    static int by1 = 400;
    static int cx1 = 0;
    static int cy1 = 0;
    static int H=5,W=15,J=5;
    final static int vectorLength = 50;
    final static int sinx2 = x2;
    final static int siny2 = y2;
    static double count = 0;
    private static RunSwing run = new RunSwing();

    final Timer print = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            increaseSinusGraph();
            increaseClockVector();
            count+=6; //for clock for 1 second
            count++;//for sinus*/
            if (count % 360 == 0)
                System.out.println((count / 360) + " minute passed");
        }
    });


    RunSwing() {
        print.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(run);
        frame.setSize(1000, 800);
        frame.setVisible(true);
    }

    static void increaseClockVector() {
        double cos = Math.cos(Math.toRadians(count));
        double sin = Math.sin(Math.toRadians(count));
        y2 = siny2 + (int) (vectorLength * sin);
        x2 = sinx2 + (int) (vectorLength * cos);
        cx1 = bx1 + (int) (vectorLength-J * cos);
        cy1 = bx1 + (int) (vectorLength+J * sin);
    }

    static void increaseSinusGraph() {
        double sin = Math.sin(Math.toRadians(count));
        y2 = siny2 + (int) (vectorLength * sin);
        cy1 = siny2 + (int) (vectorLength * sin);
        x2++;
        cx1++;
    }

    private void createPoint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x2, y2, x2 + 1, y2 + 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(200,0,45));
        //paint grid
        g.drawLine(x1, y1, x2, y2);//for clock
        g.drawLine(x2, y2, x2+10, y2+10);//for sinus*/
        g.drawArc(x2,y2,H,W,90,360);
        g.setColor(new Color(50,150,040));
        g.create(bx1,by1,15,15);
        g.drawLine(bx1,by1,cx1,cy1);
        g.drawString("OVAL",cx1,cy1);
        repaint();
    }
}