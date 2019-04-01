import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Shoot implements MouseListener {
    private int click = 0;
    private int totalShotsfierd=0;
    public Shoot(){
        //System.out.println("shoot called");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        click = e.getButton();
        this.totalShotsfierd++;
        SoundTrack shootingarrosound = new SoundTrack();
        shootingarrosound.SoundTrack("shoot");

    }

    public int getTotalShotsfierd() {
        return totalShotsfierd;
    }

    public void setTotalShotsfierd(int totalShotsfierd) {
        this.totalShotsfierd = totalShotsfierd;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        e.getComponent();
        click=e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click=0;

       // System.out.println("com... "+e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        click=0;
    }


    @Override
    public void mouseExited(MouseEvent e) {
        click=0;
    }
}
