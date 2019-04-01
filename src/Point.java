import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.Rectangle;

public class Point extends Point2D {
    private int xCordinta, yCordinta;
    private double XP,YP;
    private Rectangle rectangle;

    public Point(int x, int y) {
        this.xCordinta = x;
        this.yCordinta = y;
        this.XP=x;
        this.YP=y;
    }
    public Point(int x){
        this.xCordinta = x;
        this.yCordinta = x;
        this.XP=x;
        this.YP=x;
    }
    public Point(){
        this.xCordinta =0;
        this.yCordinta =0;
        this.XP=0;
        this.YP=0;
    }
    public Point(double a,double b){
        this.setLocation(a,b);
        this.YP=b;
        this.XP=a;
    }


    @Override
    public double getX() {
        return this.getxCordinta();
    }

    @Override
    public double getY() {
        return this.getyCordinta();
    }

    public boolean PointImpact (Point a,int ha,int wa,Point b){
        return (b.getxCordinta() >= a.getxCordinta() && b.getxCordinta() <= (a.getxCordinta() + wa)) && ((b.getyCordinta() >= a.getyCordinta()) && (b.getyCordinta() <= (a.getyCordinta() + ha)));
    }
    public boolean isImpact (Munitions ammo,Target target){
        if(ammo.getLocation().equals(target.getLocation())){
            System.out.println("BOOMBOOM");
            return true;
        }
        return false;
        }
    public boolean isSightOnTarget(Point sight,int sw,int sh,int tw,int th,Point target){
        if (sight.getxCordinta() < target.getxCordinta() && sight.getxCordinta()+sw > target.getxCordinta()+sw && sight.getyCordinta()<target.getyCordinta() && sight.getyCordinta()+sh < target.getyCordinta()+sh){
            System.out.println("TARGET LOCK ON ");
            return true;}
        return false;}

    public boolean isPointInside (Point sight,int x,int y){
        rectangle = new Rectangle();
        rectangle.setLocation(x,y);
        return rectangle.contains(sight);
    }
    public void PointPrint(String pointName){
        System.out.println(pointName+" point X: "+this.xCordinta +" point Y:"+this.yCordinta);

    }
    public boolean PointSquareImpact(Point a, int ha, int wa, Point b, int hb, int wb){return false;}

    @Override
    public void setLocation(double x, double y) {
    this.xCordinta = (int) x;
    this.yCordinta = (int) y;
    }
    public void getMagnitud(Point2D a,Point2D b){

    }

    public int getxCordinta() {
        return xCordinta;
    }

    public void setxCordinta(int xCordinta) {
        this.xCordinta = xCordinta;
    }

    public int getyCordinta() {
        return yCordinta;
    }

    public void setyCordinta(int yCordinta) {
        this.yCordinta = yCordinta;
    }
}
