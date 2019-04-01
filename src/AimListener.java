import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class AimListener extends Point implements MouseMotionListener {
    public int xAimCordinta, yAimCordinta;
    public Point mousePoint;

    public AimListener() {
        int x = getxAimCordinta();
        int y= getyAimCordinta();
        super.setLocation(x,y);
        mousePoint = new Point(x,y);
        setxAimCordinta(getxAimCordinta());
        setyAimCordinta(getyAimCordinta());

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        xAimCordinta = e.getX()-58;
        yAimCordinta = e.getY()-57;
     //   int a =e.getX();
     //   int b=e.getY();
     //   System.out.println("e.get key-DRAGED "+a+" : "+b);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xAimCordinta = e.getX()-58;
        yAimCordinta = e.getY()-57;

    }

    public Point getMousePoint() {
        double x= getxAimCordinta();
        double y= getyAimCordinta();
        mousePoint.setLocation(x,y);
        return mousePoint;
    }

    public void setMousePoint(Point mousePoint) {
        this.mousePoint = mousePoint;
    }

    public int getxAimCordinta() {
        return xAimCordinta;
    }

    public void setxAimCordinta(int xAimCordinta) {
        this.xAimCordinta = xAimCordinta;
    }

    public int getyAimCordinta() {
        return yAimCordinta;
    }

    public void setyAimCordinta(int yAimCordinta) {
        this.yAimCordinta = yAimCordinta;
    }
}
