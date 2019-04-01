import javax.swing.*;

public class AtomBomb extends Munitions{
    private ImageIcon atomBombIcon;

    public AtomBomb(ImageIcon icon){
        super();
        this.atomBombIcon = new ImageIcon(this.getClass().getResource("/images/munition/atombombU.gif"));
        super.setDamage(50);
        super.setRadiusDamage(150);
    }
    public void AtomBombDrop(Point droplocation){
        System.out.println("ATOMBOMB DROPET");
    }

}
