import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ScopeSight extends JPanel implements MouseMotionListener {
    public ImageIcon scopeSightIcon= new ImageIcon(this.getClass().getResource("/images/wepon/scopesight5.png"));
    public ImageIcon radarLockon=new ImageIcon(this.getClass().getResource("/images/wepon/radarlockon.gif"));
    public Point scopeLocation;

    public ScopeSight(){

    }
    public ScopeSight(Point p){
        this.scopeLocation.setLocation(p);
    }
    public void ScopeTracking(AimListener track){

        scopeLocation = new Point(track.getxAimCordinta(),track.getyAimCordinta());
    }

    public void ScopeTracking (MouseEvent e){
        scopeLocation =new Point(e.getXOnScreen(),e.getYOnScreen());
    }

    public ImageIcon getScopeSightIcon() {
        return scopeSightIcon;
    }

    public void setScopeSightIcon(ImageIcon scopSightIcon) {
        this.scopeSightIcon = scopSightIcon;
    }

    public Point getScopeLocation() {
        return scopeLocation;
    }

    public void setScopeLocation(Point scopLocation) {
        this.scopeLocation = scopLocation;
    }

    public ImageIcon getRadarLockon() {
        return radarLockon;
    }

    public void setRadarLockon(ImageIcon radarLockon) {
        this.radarLockon = radarLockon;
    }




    @Override
    public void mouseDragged(MouseEvent e) {
        scopeLocation.setxCordinta(e.getXOnScreen());
        scopeLocation.setyCordinta(e.getYOnScreen());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        scopeLocation.setxCordinta(e.getXOnScreen());
        scopeLocation.setyCordinta(e.getYOnScreen());
    }
}
