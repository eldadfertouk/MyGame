import java.awt.event.*;

class Mouse implements MouseMotionListener {
    private int xMouseCordinta;
    private int yMouseCordinta;

    public Mouse()
    {
    setxMouseCordinta(getxMouseCordinta());
    setyMouseCordinta(getyMouseCordinta());
    }

    public void mouseDragged(MouseEvent e)
    {
        xMouseCordinta = e.getX();
        yMouseCordinta = e.getY();
    }


    public void mouseMoved(MouseEvent e)
    {
        xMouseCordinta = e.getX();
        yMouseCordinta = e.getY();
    }

    public int getxMouseCordinta() {
        return xMouseCordinta;
    }

    public void setxMouseCordinta(int xMouseCordinta) {
        this.xMouseCordinta = xMouseCordinta;
    }

    public int getyMouseCordinta() {
        return yMouseCordinta;
    }

    public void setyMouseCordinta(int yMouseCordinta) {
        this.yMouseCordinta = yMouseCordinta;
    }
}
