import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Target extends JPanel implements MouseListener {
    private static int targetNumber=0;
    private ImageIcon targetIcon;
    private Point targetLocation;
    public boolean isMovingTarget,radarLockOn,isHit;
    private int targetHeight,targetWide,targetId;
    private int targetX,targetY;
    private Rectangle targetImpactArea;
    private Container targetsContainer;

    public Target(){
        targetNumber++;
        this.targetId=targetNumber;
        this.targetsContainer = new Container();
        this.targetsContainer.setLayout(new GridLayout(1,1,800,500));
        this.targetIcon = new ImageIcon(this.getClass().getResource("/images/targets/defaulttarget.png"));
        this.targetX = new Random().nextInt((860)+100);
        this.targetY = new Random().nextInt((500)+100);
        Point p1=new Point(targetX,targetY);
        this.setTargetLocation(p1);
        this.targetsContainer.add(this, -1);
        this.targetLocation.PointPrint("Target");
        this.radarLockOn = false;
        this.isMovingTarget = false;
        this.isHit=false;
        this.setVisible(true);
    }


    public void TargetMoveRandom (){
        Random direction = new Random();
        int moveDirection = direction.nextInt(4);
        Random stepXrand = new Random();
        Random stepYrand = new Random();
        int stepX = stepXrand.nextInt((30)+1);
        int stepY = stepYrand.nextInt((5)+1);
        this.isMovingTarget=true;
        switch (moveDirection){
            case 0:
                this.targetLocation.setxCordinta(this.targetX+=stepX);
                this.targetLocation.setyCordinta(this.targetY-=stepY);
                break;
            case 1:
                this.targetLocation.setxCordinta(this.targetX+=stepX);
                this.targetLocation.setyCordinta(this.targetY-=stepY);
                break;
            case 2:
                this.targetLocation.setxCordinta(this.targetX-=stepX);
                this.targetLocation.setyCordinta(this.targetY-=stepY);
                break;
            case 3:
                this.targetLocation.setxCordinta(this.targetX-stepX);
                this.targetLocation.setyCordinta(this.targetY-stepY);
                break;
        }

    }

    public Target(String targetType,int targetsQountity,boolean move){

        for (int i=targetsQountity;i >=0;i--){
            if(move){
                this.isMovingTarget=true;
            }
        switch (targetType){
            case "defaulttarget":
                this.targetIcon =  new ImageIcon(this.getClass().getResource("/images/targets/targeticon.png"));
                break;
            case "balloon":
               this.targetIcon =  new ImageIcon(this.getClass().getResource("/images/targets/blueballoonsmal.png"));
                break;
            case "flyingballon":
                this.targetIcon =  new ImageIcon(this.getClass().getResource("/images/targets/flyingballoon.png"));
                break;
            case "airplain":
              this.targetIcon = new ImageIcon(this.getClass().getResource("/images/targets/airplain.gif"));
                break;
        }
        }
    }

    public Target(ImageIcon targetIcon, Point targetLocation, boolean isMovingTarget, boolean radarLock, int targetHeight, int targetWide) {
        this.targetIcon = targetIcon;
        this.targetLocation = targetLocation;
        this.isMovingTarget = isMovingTarget;
        this.radarLockOn = radarLock;
        this.targetHeight = targetHeight;
        this.targetWide = targetWide;
    }

    public boolean isRadarLockOn() {
        return radarLockOn;
    }

    public void setRadarLockOn(boolean radarLockOn) {
        this.radarLockOn = radarLockOn;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        Target.targetNumber = targetNumber;
    }

    public ImageIcon getTargetIcon() {
        return targetIcon;
    }

    public void setTargetIcon(ImageIcon targetIcon) {
        this.targetIcon = targetIcon;
    }

    public Point getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Point targetLocation) {
        this.targetLocation = targetLocation;
    }

    public int getTargetHeight() {
        return targetHeight;
    }

    public void setTargetHeight(int targetHeight) {
        this.targetHeight = targetHeight;
    }

    public int getTargetWide() {
        return targetWide;
    }

    public void setTargetWide(int targetWide) {
        this.targetWide = targetWide;
    }

    public Container getTargetsContainer() {
        return targetsContainer;
    }

    public void setTargetsContainer(Container targetsContainer) {
        this.targetsContainer = targetsContainer;
    }

    public Rectangle getTargetImpactArea() {
        return targetImpactArea;
    }

    public void setTargetImpactArea(Rectangle targetImpactArea) {
        this.targetImpactArea = targetImpactArea;
    }


    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x=(int)e.getLocationOnScreen().getX();
        int y=(int)e.getLocationOnScreen().getY();
        int x1=this.targetLocation.getxCordinta();
        int y1=this.targetLocation.getyCordinta();
        Rectangle s = new Rectangle(e.getLocationOnScreen());
        if (s.contains(targetLocation)){
            System.out.println("ffdgdfgdfgdffdgdfg");
            this.setRadarLockOn(true);
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}

