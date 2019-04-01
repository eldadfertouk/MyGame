import javax.swing.*;

public class Turtle extends Player{
    private ImageIcon turtleIconL = new ImageIcon(getClass().getResource("images/players/turtlesmall.png"));
    private ImageIcon turtleIconR = new ImageIcon(getClass().getResource("images/players/turtleyamin.png"));
    private int XTurtle=350;
    private int YTurtle=580;
    private int speed=50;
    private boolean direction;

    public Turtle() {
        super.setPlayerIconRight(turtleIconR);
        super.setPlayerIconLeft(turtleIconL);
        super.setPlayerLocation(new Point(XTurtle,YTurtle));
    }

    public void moveTurtle(String direction) {
        super.PlayerMoves(direction);
        switch (direction) {
            case "start":
                this.XTurtle = 350;
                this.YTurtle = 580;
                break;
            case "right":
                if (XTurtle<850 && XTurtle>-1){
                    this.XTurtle+=1;
                    this.setTurtleIconR(turtleIconR);}
                break;
            case "left":
                if (XTurtle > 0 && XTurtle < 900){
                this.XTurtle-=1;
                this.setTurtleIconL(turtleIconL);}
                break;
        }
    }

    public ImageIcon getTurtleIconR() {
        return turtleIconR;
    }

    public void setTurtleIconR(ImageIcon turtleIconR) {
        this.turtleIconR = turtleIconR;
    }

    public ImageIcon getTurtleIconL() {
        return turtleIconL;
    }

    public void setTurtleIconL(ImageIcon turtleIconL) {
        this.turtleIconL = turtleIconL;
    }

    public ImageIcon getTurtle() {
        return turtleIconR;
    }

    public void setTurtle(ImageIcon turtle) {
        this.turtleIconR = turtle;
    }

    public int getXTurtle() {
        return XTurtle;
    }

    public void setXTurtle(int XTurtle) {
        this.XTurtle = XTurtle;
    }

    public int getYTurtle() {
        return YTurtle;
    }

    public void setYTurtle(int YTurtle) {
        this.YTurtle = YTurtle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}