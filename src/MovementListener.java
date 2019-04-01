import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener{
    private ImageIcon icon;
    private String direction;
    private int Mx,My;
    private int keycode;
    public MovementListener(ImageIcon t) {
        System.out.println("mazin");
    }

        @Override
        public void keyTyped (KeyEvent e){
            int key = e.getKeyCode();
            System.out.println(key);
        }

        @Override
        public void keyPressed (KeyEvent e){
            int key = e.getKeyCode();
            System.out.println(key);
            switch (key) {
                case KeyEvent.VK_LEFT:
                    direction = "left";
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = "right";
                    System.out.println(direction);
                    break;
                case KeyEvent.VK_UP:
                    direction = "up";
                    System.out.println(direction);
                    break;
                case KeyEvent.VK_DOWN:
                    direction = "down";
                    System.out.println(direction);
                    break;
            }
        }

        @Override
        public void keyReleased (KeyEvent e){
           // if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
                System.out.println("key releesed");
        }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getMx() {
        return Mx;
    }

    public void setMx(int mx) {
        Mx = mx;
    }

    public int getMy() {
        return My;
    }

    public void setMy(int my) {
        My = my;
    }

    public int getKeycode() {
        return keycode;
    }

    public void setKeycode(int keycode) {
        this.keycode = keycode;
    }
}





