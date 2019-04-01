import javax.swing.*;

public class Camel extends Player{
    private ImageIcon camelRightGif=new ImageIcon(getClass().getResource("images/camelright.gif"));
    private ImageIcon camelLeftGif=new ImageIcon(getClass().getResource("images/camelleft.gif"));
    private int camelX;
    private int camelY;

    public ImageIcon getCamelLeftGif() {
        return camelLeftGif;
    }

    public void setCamelLeftGif(ImageIcon camelLeftGif) {
        this.camelLeftGif = camelLeftGif;
    }

    public Camel(String direction, int camelX, int camelY) {
        super();
        super.setPlayerIconLeft(camelLeftGif);
        super.setPlayerIconRight(camelRightGif);
        this.camelX = camelX;
        this.camelY = camelY;
    }

    public ImageIcon getCamelRightGif() {
        return camelRightGif;
    }

    public void setCamelRightGif(ImageIcon camelRightGif) {
        this.camelRightGif =new ImageIcon(getClass().getResource("images/players/smallcamel.gif"));
    }

    public int getCamelX() {
        return camelX;
    }

    public void setCamelX(int camelX) {
        this.camelX = camelX;
    }

    public int getCamelY() {
        return camelY;
    }

    public void setCamelY(int camelY) {
        this.camelY = camelY;
    }

    public Camel(){
        super.setPlayerIconLeft(camelLeftGif);
        super.setPlayerIconRight(camelRightGif);
        super.setPlayerLocation(new Point(600,600));

    }
    public void CamelRun(){
        this.camelX+=10;

    }
    public void MoveCamel(String direction){
        this.PlayerMoves(direction);
        }

}
