import javax.swing.*;

public class Missile {
    private ImageIcon missileIcon;
    private Point missileLocation;
    private int missileX;
    private int missileY;
    private Point missileTarget;

    public Missile(){
        this.missileIcon = new ImageIcon(this.getClass().getResource("/images/munition/missilesmall.png"));

    }
    public void MissileLunch(Point lunchlocation,Point destination){
        System.out.println("MISSILE LUNCH");
    }
}
