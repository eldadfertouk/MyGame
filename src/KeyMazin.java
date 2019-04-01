import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMazin implements KeyListener {
    private int keyCode;
    private int x;
    private int y;
    public KeyMazin(){
    }
    @Override
    public void keyTyped(KeyEvent e) {
        keyCode = e.getKeyCode();
        keyStrokes(keyCode);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();
        keyStrokes(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyCode = 0;

    }
    public void keyStrokes(int keyCode){
        System.out.println("key"+keyCode);
        switch (keyCode) {

            case 37:
                x--;
                break;
            case 38:
                y++;
                break;
            case 39:
                x++;
                break;
            case 40:
                y--;
                break;
        }
    }

    public int getKeyCode() {

        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }
}
