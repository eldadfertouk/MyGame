import javax.swing.*;
import java.awt.*;

public class Armadil extends Player {
    private ImageIcon armadilIcon = new ImageIcon(this.getClass().getResource("/images/players/armadiloicon.gif"));
    public Armadil(){
        super();
        super.setPlayerIcon(armadilIcon);
        super.setPlayerLocation(new Point(500,500));
        super.setPlayerLifes(5);
        super.setPlayerName("Mister armadil");
        super.setPlayerType("Armadilo");
        super.setPlayerX(500);
        super.setPlayerY(500);
        super.setPreferredSize(new Dimension(100,100));
        super.setPlayerIconRight(armadilIcon);
        super.setVisible(true);
    }
    public void ArmadilWalk(Player player){
        player.setPlayerX(+1);
        System.out.println("armadil walk");
    }
    public void ArmadilMove(String direction){
        super.PlayerMoves(direction);
    }

    public ImageIcon getArmadilIcon() {
        return armadilIcon;
    }

    public void setArmadilIcon(ImageIcon armadilIcon) {
        this.armadilIcon = armadilIcon;
    }
}
