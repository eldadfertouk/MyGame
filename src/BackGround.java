import javax.swing.*;

public class BackGround extends JPanel {
    private ImageIcon backgroundIcon;

    public ImageIcon getBackgroundIcon() {
        return backgroundIcon;
    }

    public void setBackgroundIcon(ImageIcon backgroundIcon) {
        this.backgroundIcon = backgroundIcon;
    }

    public BackGround(){
        backgroundIcon = new ImageIcon(getClass().getResource("images/backgrounds/flyingthroughclouds.gif"));
    }
    public BackGround(int level){
        switch (level){
            case 1:
                backgroundIcon = new ImageIcon(getClass().getResource("images/backgrounds/senddune.gif"));
                break;
            case 2:
                backgroundIcon = new ImageIcon(getClass().getResource("images/backgrounds/backgrounddesrtsky.gif"));
                break;
            case 3:
                backgroundIcon = new ImageIcon(getClass().getResource("images/backgrounds/backgrounddesert.gif"));
                break;
            case 4:
                backgroundIcon = new ImageIcon(getClass().getResource("images/backgrounds/backgroundsky.gif"));
                break;
            case 5:
                backgroundIcon = new ImageIcon(getClass().getResource("images/backgrounds/background.gif"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }

    }
}
