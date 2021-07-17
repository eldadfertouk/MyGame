import javax.swing.*;

public class Missile extends  Munitions{
    private ImageIcon missileIcon;
    private Point missileLocation;
    private int missileX;
    private int missileY;
    private Point missileTarget;

    public Missile(){
        super();
        super.setAmmoIcon(ammoIcon);
        this.missileIcon = new ImageIcon(this.getClass().getResource("/images/munition/missilesmall.png"));
        super.setWarHeadTipPoint(missileLocation);
    }
    public Missile(int x,int y, Point missileLocation, Point missileTarget){
        super();
    }



    public void MissileLunch(Point lunchlocation,Point destination){
        System.out.println("MISSILE LUNCH");
    }
}

