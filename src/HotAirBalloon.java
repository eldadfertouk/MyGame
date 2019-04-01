import javax.swing.*;
import java.util.Random;

public class HotAirBalloon extends Target {
    private ImageIcon hotAirBalloon;
    private int hotAirBalloonX;
    private int hotAirBalloonY;

    public HotAirBalloon(){
        super.setTargetIcon(hotAirBalloon = new ImageIcon(this.getClass().getResource("/images/targets/flyingballoon.png")));
        Random hotairballoonX = new Random();
        this.hotAirBalloonX = hotairballoonX.nextInt((960) + 50);
        Random hotairballoonY = new Random();
        this.hotAirBalloonY = hotairballoonY.nextInt((500) + 100);
    }
    //move balloon on the screen
    public void moveHotAirBalloon(){
        Random direction = new Random();
        int movedirection = direction.nextInt(4);
        Random stepXrand = new Random();
        Random stepYrand = new Random();
        int stepX = stepXrand.nextInt(30+1);
        int stepY = stepYrand.nextInt(2+1);
        switch (movedirection){
            case 0:
                this.hotAirBalloonX+=stepX;
                this.hotAirBalloonY-=stepY;
                break;
            case 1:
                this.hotAirBalloonX+=stepX;
                this.hotAirBalloonY-=stepY;
                break;
            case 2:
                this.hotAirBalloonX-=stepX;
                this.hotAirBalloonY-=stepY;
                break;
            case 3:
                this.hotAirBalloonX-=stepX;
                this.hotAirBalloonY-=stepY;
                break;
        }

    }

    public ImageIcon getHotAirBalloon() {
        return hotAirBalloon;
    }

    public void setHotAirBalloon(ImageIcon hotAirBalloon) {
        this.hotAirBalloon = hotAirBalloon;
    }

    public int getHotAirBalloonX() {
        return hotAirBalloonX;
    }

    public void setHotAirBalloonX(int hotAirBalloonX) {
        this.hotAirBalloonX = hotAirBalloonX;
    }

    public int getHotAirBalloonY() {
        return hotAirBalloonY;
    }

    public void setHotAirBalloonY(int hotAirBalloonY) {
        this.hotAirBalloonY = hotAirBalloonY;
    }
}
