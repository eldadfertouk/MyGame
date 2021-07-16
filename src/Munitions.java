import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Munitions extends JPanel{
    public static int TOTAL_MUNITION=50;
    public String ammoType;
    public int ammoFired,damage,ammoSpeed,radiusDamage,Xammo,Yammo;
    public ImageIcon ammoIcon;
    public Point ammoStartLocation,ammoDestination,ammoCurrentLocation,warHeadTipPoint;
    public HashSet<Point> projectilePath;

    public Munitions(){
        this.ammoIcon = new ImageIcon(this.getClass().getResource("/images/munition/rocketrolldefualt.gif"));
        Xammo=500;Yammo=650;
        ammoStartLocation = new Point(Xammo,Yammo);
        ammoCurrentLocation = new Point(Xammo,Yammo);
    }
    public Point getWarHeadTipPoint (int x,int y){
        this.warHeadTipPoint = new Point(x-this.getWidth()/2,y-3);
     return warHeadTipPoint;
    }
    public Munitions(String ammoType){

            switch (ammoType){
                case "arrow":
                    this.ammoIcon=new ImageIcon(this.getClass().getResource("/images/munition/uparrowfinal.gif"));
                    break;
                case "missile":
                    this.ammoIcon=new ImageIcon(this.getClass().getResource("/images/munition/missilesmall.png"));
                    break;
                case "atombomb":
                    this.ammoIcon=new ImageIcon(this.getClass().getResource("/images/munition/atombomb.gif"));
                    break;
                case "rocket":
                    this.ammoIcon=new ImageIcon(this.getClass().getResource("/images/munition/rocketroll.gif"));
                    break;
            }
            this.ammoIcon = new ImageIcon(this.getClass().getResource("/images/munition/missilesmall.png"));
            ammoCurrentLocation = new Point(Xammo,Yammo);
            ammoDestination = new Point(400,5);

    }
    public void MunitionsUse(Munitions ammo,Point start,Point destination){
        ammoStartLocation=start;
        ammoDestination=destination;
        this.setProjectilePath(ammoStartLocation,ammoDestination);

    }
    public void MunitionsUse(){

        Yammo--;
    }

    public Munitions(Point ammoStartLocation, Point ammoDestination, Point ammoLoaction, Point warHeadTipPoint) {

    }
    public HashSet<Point> getProjectilePath(Munitions ammo, Point StartLocation, Point destination){
        this.ammoStartLocation=ammoStartLocation;
        this.ammoDestination=destination;
        this.setProjectilePath(ammoStartLocation,ammoDestination);
        return projectilePath;
    }

    public void MunitionUse(Munitions ammo,Point start,Point target){
        //set ammo balistick projactail
        String ammoType = ammo.getAmmoType();
        switch (ammoType){
            case "atom":
                //move up and down
                Yammo--;
                break;
            case "missile":
                Yammo--;
                break;
            case "arrow":
                Yammo--;
                break;
            case "rocket":
                Yammo--;

                break;

        }
        this.setAmmoFired(+1);

    }
    public List<Point> Rockets_ProjectilePath (Point player,Point target){
        List<Point> rocketProjectile = new ArrayList<>();
        int x1=(int)player.getX();
        int y1=(int)player.getY();
        int x2=(int)target.getX();
        int y2=(int)target.getY();
        int m=(x1-x2)/(y1-y2);
        int Sx = Math.abs(x1-x2),Sy = Math.abs(y1-y2);
            for (int i = x1 ; i <= x2; i++){
                for (int j = y1;j<=y2; j++){
                Point p = new Point(i,j);
                rocketProjectile.add(p);
                }
        }

        return rocketProjectile;
    }
    public HashSet<Point> setProjectilePath (Point player, Point target){
        int x1=(int)player.getX();
        int y1=(int)player.getY();
        int x2=(int)target.getX();
        int y2=(int)target.getY();
        int m;
        m=(x1-x2)/(y1-y2);
        projectilePath = new HashSet<>();
        //set balistik up
        if (m==0) {
                int yy = y1-y2;
                for (;yy<=y2;yy--){
                    Point nextPoint=new Point(x1,yy);
                    projectilePath.add(nextPoint);
                }
            //set blistic right up shoot
        if(m>0){
            int xx=x1-x2;
            int yx=y1-y2;
            for(;xx<=x2 && yx==yx;xx++,yx--){
                Point nextPoint=new Point(x1,yy);
                projectilePath.add(nextPoint);
            }
        }
                //set blistic left up shot
        }

        return projectilePath;
    }

    public Munitions(String ammoType, int ammoFired, int damage, int ammoSpeed, ImageIcon ammoIcon, Point ammoLocation) {
        this.ammoType = ammoType;
        this.ammoFired = ammoFired;
        this.damage = damage;
        this.ammoSpeed = ammoSpeed;
        this.ammoIcon = ammoIcon;
        this.ammoStartLocation = ammoLocation;
    }

    public int getRadiusDamage() {
        return radiusDamage;
    }

    public void setRadiusDamage(int radiusDamage) {
        this.radiusDamage = radiusDamage;
    }

    public String getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(String ammoType) {
        this.ammoType = ammoType;
    }

    public int getAmmoFired() {
        return ammoFired;
    }

    public void setAmmoFired(int ammoFired) {
        this.ammoFired = ammoFired;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Point getWarHeadTipPoint() {
        return warHeadTipPoint;
    }

    public void setWarHeadTipPoint(Point warHeadTipPoint) {
        this.warHeadTipPoint = warHeadTipPoint;
    }

    public int getAmmoSpeed() {
        return ammoSpeed;
    }

    public void setAmmoSpeed(int ammoSpeed) {
        this.ammoSpeed = ammoSpeed;
    }

    public ImageIcon getAmmoIcon() {
        return ammoIcon;
    }

    public void setAmmoIcon(ImageIcon ammoIcon) {
        this.ammoIcon = ammoIcon;
    }

    public Point getStartLocation() {
        return ammoStartLocation;
    }

    public void setStartLocation(Point ammoLocation) {
        this.ammoStartLocation = ammoLocation;
    }

    public Point getAmmoCurrentLocation() {
        return ammoCurrentLocation;
    }

    public void setAmmoCurrentLocation(Point ammoCurrentLocation) {
        this.ammoCurrentLocation = ammoCurrentLocation;
    }

    public Point getAmmoDestination() {
        return ammoDestination;
    }

    public void setAmmoDestination(Point ammoDestination) {
        this.ammoDestination = ammoDestination;
    }
}
