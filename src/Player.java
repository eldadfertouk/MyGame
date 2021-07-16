import javax.swing.*;
import java.util.List;

public class Player extends JPanel {
    private int playerXStartPoint = 500, playerYStartPoint = 820, PLAYERSPEED = 5, playerStep = 1, playerJump = 25;
    private String playerName, playerType;
    private ImageIcon playerIcon, playerIconUp, playerIconRight, playerIconLeft, playerIconDown, playerIconJump;
    private int playerScore, playerLifes, playerX = 300, playerY = 580;
    public Point playerStartPoint = new Point(playerXStartPoint, playerYStartPoint), playerLocation;
    private Munitions playerAmmo;
    private List <Munitions> playerAmmoList;

    //create default player
    public Player() {
        this.playerName = "new player";
        this.playerType = "default";
        this.playerLifes = 5;
        this.playerLocation = new Point(playerX, playerY);
        this.playerIcon = new ImageIcon(this.getClass().getResource("/images/players/armadilright.gif"));
        this.playerIconRight = new ImageIcon(this.getClass().getResource("/images/players/armadilright.gif"));
        this.playerIconLeft = new ImageIcon(this.getClass().getResource("/images/players/armadilleft.gif"));
        this.playerIconDown = new ImageIcon(this.getClass().getResource("/images/players/armadiloicon.gif"));
        this.playerIconUp = new ImageIcon(this.getClass().getResource("/images/players/armadiloicon.gif"));
        this.playerIconJump = new ImageIcon(this.getClass().getResource("/images/players/armadiloicon.gif"));
    }

    public Player(String playername, String playertype) {
        this.playerStartPoint.setLocation(playerXStartPoint, playerYStartPoint);
        this.playerName = playername;
        switch (playertype) {
            case "default":
                this.playerIcon = new ImageIcon(this.getClass().getResource("/images/players/armadilo.gif"));
                this.playerIconRight = new ImageIcon(this.getClass().getResource("/images/players/armadilo.gif"));
                this.playerIconLeft = new ImageIcon(this.getClass().getResource("/images/players/armadilo.gif"));
                this.playerIconUp = new ImageIcon(this.getClass().getResource("/images/players/armadilo.gif"));
                this.playerIconDown = new ImageIcon(this.getClass().getResource("/images/players/armadilo.gif"));
                this.playerIconJump = new ImageIcon(this.getClass().getResource("/images/players/armadilo.gif"));
                break;
            case "turtle":
                this.playerIcon = new ImageIcon(this.getClass().getResource("/images/players/turtle.png"));
                this.playerIconRight = new ImageIcon(this.getClass().getResource("/images/players/turtleyamin.png"));
                this.playerIconLeft = new ImageIcon(this.getClass().getResource("/images/players/turtlesmall.png"));
                this.playerIconUp = new ImageIcon(this.getClass().getResource("/images/players/turtlesmall.png"));
                this.playerIconDown = new ImageIcon(this.getClass().getResource("/images/players/turtlesmall.png"));
                this.playerIconJump = new ImageIcon(this.getClass().getResource("/images/players/turtlesmall.png"));
                break;
            case "camel":
                this.playerIcon = new ImageIcon(this.getClass().getResource("/images/players/camel.gif"));
                this.playerIconRight = new ImageIcon(this.getClass().getResource("/images/players/camelright.gif"));
                this.playerIconLeft = new ImageIcon(this.getClass().getResource("/images/players/camelleft.gif"));
                this.playerIconUp = new ImageIcon(this.getClass().getResource("/images/players/camel.gif"));
                this.playerIconDown = new ImageIcon(this.getClass().getResource("/images/players/camel.gif"));
                this.playerIconJump = new ImageIcon(this.getClass().getResource("/images/players/camel.gif"));
                break;
        }
    }

    public void PlayerMoves(String direction) {
        switch (direction) {
            case "start":
                this.playerLocation = new Point(playerXStartPoint, playerYStartPoint);
                this.setPlayerIconUp(playerIcon);
                break;
            case "right":
                if (playerLocation.getxCordinta() < 950 && playerLocation.getxCordinta() > 0) {
                    this.playerX+=1;
                    this.setPlayerIconRight(playerIconRight);
                    System.out.println("XX  " + playerX + " YY   " + playerY);
                }
                break;
            case "left":
                if (this.playerLocation.getxCordinta() > -1 && this.playerLocation.getxCordinta() < 960) {
                    this.playerX-=1;
                    this.setPlayerIconLeft(playerIconLeft);
                    System.out.println("XX  " + playerX + " YY   " + playerY);
                }
                break;
            case "up":
                if (this.playerLocation.getyCordinta() < -1 && this.playerLocation.getyCordinta() < 800) {
                    setPlayerY(playerY - playerStep);
                    this.playerLocation.setyCordinta(playerX - playerStep);
                    this.setPlayerIconLeft(playerIconUp);
                    System.out.println("XX  " + playerX + " YY   " + playerY);
                }
                break;
            case "down":
                if (this.playerLocation.getyCordinta() < -1 && this.playerLocation.getyCordinta() < 980) {
                    setPlayerY(playerY + playerStep);
                    this.playerLocation.setyCordinta(playerY + playerStep);
                    this.setPlayerIconLeft(playerIconDown);
                    System.out.println("XX  " + playerX + " YY   " + playerY);
                }
                break;
            case "jump":
                if (this.playerLocation.getyCordinta() < -1 && this.playerLocation.getyCordinta() < 980) {
                    playerLocation.setyCordinta(playerY - playerJump);
                    playerLocation.setxCordinta(playerX + playerJump);
                    this.setPlayerIcon(playerIconJump);
                    System.out.println("XX  " + playerX + " YY   " + playerY);
                }
                break;

        }
    }

    public int getPlayerXStartPoint() {
        return playerXStartPoint;
    }

    public void setPlayerXStartPoint(int playerXStartPoint) {
        this.playerXStartPoint = playerXStartPoint;
    }

    public int getPlayerYStartPoint() {
        return playerYStartPoint;
    }

    public void setPlayerYStartPoint(int playerYStartPoint) {
        this.playerYStartPoint = playerYStartPoint;
    }

    public int getPLAYERSPEED() {
        return PLAYERSPEED;
    }

    public void setPLAYERSPEED(int PLAYERSPEED) {
        this.PLAYERSPEED = PLAYERSPEED;
    }

    public int getPlayerStep() {
        return playerStep;
    }

    public void setPlayerStep(int playerStep) {
        this.playerStep = playerStep;
    }

    public int getPlayerJump() {
        return playerJump;
    }

    public void setPlayerJump(int playerJump) {
        this.playerJump = playerJump;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public ImageIcon getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(ImageIcon playerIcon) {
        this.playerIcon = playerIcon;
    }

    public ImageIcon getPlayerIconUp() {
        return playerIconUp;
    }

    public void setPlayerIconUp(ImageIcon playerIconUp) {
        this.playerIconUp = playerIconUp;
    }

    public ImageIcon getPlayerIconRight() {
        return playerIconRight;
    }

    public void setPlayerIconRight(ImageIcon playerIconRight) {
        this.playerIconRight = playerIconRight;
    }

    public ImageIcon getPlayerIconLeft() {
        return playerIconLeft;
    }

    public void setPlayerIconLeft(ImageIcon playerIconLeft) {
        this.playerIconLeft = playerIconLeft;
    }

    public ImageIcon getPlayerIconDown() {
        return playerIconDown;
    }

    public void setPlayerIconDown(ImageIcon playerIconDown) {
        this.playerIconDown = playerIconDown;
    }

    public ImageIcon getPlayerIconJump() {
        return playerIconJump;
    }

    public void setPlayerIconJump(ImageIcon playerIconJump) {
        this.playerIconJump = playerIconJump;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerLifes() {
        return playerLifes;
    }

    public void setPlayerLifes(int playerLifes) {
        this.playerLifes = playerLifes;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public Point getPlayerStartPoint() {
        return playerStartPoint;
    }

    public void setPlayerStartPoint(Point playerStartPoint) {
        this.playerStartPoint = playerStartPoint;
    }

    public Point getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Point playerLocation) {
        this.playerLocation = playerLocation;
    }

    public Munitions getPlayerAmmo() {
        return playerAmmo;
    }

    public void setPlayerAmmo(Munitions playerAmmo) {
        this.playerAmmo = playerAmmo;
    }

    public List <Munitions> getPlayerAmmoList() {
        return playerAmmoList;
    }

    public void setPlayerAmmoList(List <Munitions> playerAmmoList) {
        this.playerAmmoList = playerAmmoList;
    }
}