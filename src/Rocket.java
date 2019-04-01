import javax.swing.*;

public class Rocket extends Munitions{
    private ImageIcon rocketIcon=new ImageIcon(this.getClass().getResource("/images/munition/rocketrolldefualt.gif"));
    private int rocketX=500,rocketY=800,ammoFired=0,damage=50,ammoSpeed=1,radiusDamage=250;
    private Point rocketLocation=new Point(rocketX,rocketY);

    public Rocket(){
        super.setAmmoType("Rocket");
        super.setAmmoIcon(rocketIcon=new ImageIcon(this.getClass().getResource("/images/munition/rocketrolldefualt.gif")));
        super.setDamage(damage);
        super.setStartLocation(rocketLocation);
        super.setRadiusDamage(radiusDamage);
        super.setAmmoSpeed(ammoSpeed);
        super.setAmmoFired(ammoFired);
        super.setWarHeadTipPoint(new Point(this.getAmmoIcon().getIconWidth() +9, this.getAmmoIcon().getIconHeight() +4));
    }
    public void RocketLunch(Point pl,Point dl){
        int px= (int)pl.getX();
        int py=(int)pl.getY();
        int dx=(int)dl.getX();
        int dy=(int)dl.getY();
        int d = py-dy;
        for(;d>0;d--){
        this.rocketY-=1;
        if (d%5==0){
            super.setSize(this.getAmmoIcon().getIconWidth()-2,this.getAmmoIcon().getIconHeight()-2);
        }
        }

    }
}
