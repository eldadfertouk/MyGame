import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Balloon extends Target{
    private ImageIcon balloonIcon= new ImageIcon(this.getClass().getResource("/images/targets/redtransperntredballoon.gif"));
    private String balloonColor;
    private int xBalloon;
    private int yBalloon;
    private int balloonNumber;
    private Point balloonCenter;
    //balloon random creater
    public Balloon(int balloonNumber){
        super.setTargetIcon(balloonIcon);
        super.setTargetHeight(balloonIcon.getIconHeight());
        super.setTargetWide(balloonIcon.getIconWidth());
        super.setTargetNumber(balloonNumber);
        Rectangle r=new Rectangle(balloonIcon.getIconWidth(),balloonIcon.getIconHeight());
        super.setTargetImpactArea(r);
        Random balloonX = new Random();
        this.xBalloon = balloonX.nextInt((960) + 50);
        Random balloonY = new Random();
        this.yBalloon = balloonY.nextInt((500) + 100);
        super.setTargetLocation(new Point(xBalloon,yBalloon));
    }

    //move balloon on the screen
    public void moveBalloon(){
        super.TargetMoveRandom();

    }

    public Balloon(ImageIcon icon){
        this.balloonIcon = icon;
    }

    public ImageIcon getBalloon() {
        return balloonIcon;
    }

    public void setBalloon(ImageIcon balloon) {
        this.balloonIcon = balloon;
    }

    public ImageIcon getBalloonIcon() {
        return balloonIcon;
    }

    public void setBalloonIcon(ImageIcon balloonIcon, String balloonColor)
    {
        while (!balloonColor.equals("null")) ;
        switch (balloonColor){
            case "red":
                this.balloonIcon = new ImageIcon(this.getClass().getResource("/images/targets/redballoon.png"));
                break;
            case "blue":
                this.balloonIcon= new ImageIcon(this.getClass().getResource("/images/targets/blueballoon.png"));
                break;
            case "green":
                this.balloonIcon= new ImageIcon(this.getClass().getResource("/images/targets/greenballoon.png"));
                break;
            case "yellow":
                this.balloonIcon= new ImageIcon(this.getClass().getResource("/images/targets/yellowballoon.png"));
                break;
            case "purple":
                this.balloonIcon= new ImageIcon(this.getClass().getResource("/images/targets/purpleballoon.png"));
                break;
        }
        switch (balloonColor) {
            case "null":
                this.balloonIcon = new ImageIcon(this.getClass().getResource("/images/targets/redtransperntredballoon.gif"));
                break;
        }
    }

    public int getxBalloon() {
        return xBalloon;
    }

    public void setxBalloon(int xBalloon) {
        this.xBalloon = xBalloon;
    }

    public int getyBalloon() {
        return yBalloon;
    }

    public void setyBalloon(int yBalloon) {
        this.yBalloon = yBalloon;
    }
}

