

import javax.swing.*;

public class Arrow extends Munitions  {
    private ImageIcon arrowIcon=new ImageIcon(this.getClass().getResource("/images/munition/uparrowfinal.gif"));
    private int XArrow =426;
    private int yArrowCordinta =630;
    private Point arrowPoint,arrowLocation;
    private static int arrowsFierd = 0;
    public Arrow(){
        super();
        super.setAmmoIcon(ammoIcon);
        //TODO:chech this part
        this.arrowIcon = new ImageIcon(this.getClass().getResource("/images/munition/uparrowfinal.gif"));
        arrowPoint = new Point((this.getX()-this.getWidth()/2),(this.getY()+5));
        super.setWarHeadTipPoint(arrowPoint);
    }

    public Arrow(int x,int y,Point ammoStartLocation,Point ammoDestination,Point ammoLoaction,Point warHeadTipPoint) {
        super(ammoStartLocation,ammoDestination,ammoLoaction,warHeadTipPoint);
        super.setAmmoIcon(ammoIcon);
        super.setStartLocation(new Point(x,y));
        this.XArrow = x;
        this.yArrowCordinta = y;
        arrowPoint = new Point((this.getX()-this.getWidth()/2),(this.getY()+5));
        super.setWarHeadTipPoint(arrowPoint);
    }
    public void moveArrowUp(int x){
        if (this.yArrowCordinta > -90) {
            this.arrowPoint = new Point(this.getXArrow(),(this.getY()+5));
            this.yArrowCordinta--;
        }
    }

    public Point getArrowPoint(int x) {
        this.arrowPoint = new Point((x-this.getWidth()/2),(this.getY()+5));
        return arrowPoint;
    }

    public void setArrowPoint(Point arrowPoint) {
        this.arrowPoint = arrowPoint;
    }

    public void ShootAnArrow(int x) {
      //  arrowsFierd+=1;
        moveArrowUp(x);
    }
    public static int getArrowsFierd() {
        return arrowsFierd;
    }

    public static void setArrowsFierd(int arrowsFierd) {
        Arrow.arrowsFierd = arrowsFierd;
    }

    public ImageIcon getArrow() {
        return arrowIcon;
    }

    public void setArrow(ImageIcon arrow) {
        this.arrowIcon = arrow;
    }

    public int getXArrow() {
        return XArrow;
    }

    public void setXArrow(int XArrow) {
        this.XArrow = XArrow;
    }

    public int getyArrowCordinta() {
        return yArrowCordinta;
    }

    public void setyArrowCordinta(int yArrowCordinta) {
        this.yArrowCordinta = yArrowCordinta;
    }
    public ImageIcon getArrowIcon() {
        return arrowIcon;
    }

    public void setArrowIcon(ImageIcon arrowIcon) {
        this.arrowIcon = arrowIcon;
    }

    public Point getArrowPoint() {
        return arrowPoint;
    }

}
