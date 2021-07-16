import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class GamePanel extends JPanel {
    public int SCREEN_WIDTH = 960;
    public int SCREEN_HIGHT = 720;
    public int BALOON_COUNT = 50;
    public int AMMO_COUNT = 50;
    private boolean impact = false;
    private int turtleWidth,playerWidh,playerHight,turtlehight;
    private int balloonSpeed = 350,turtulespeed = 5,arrowSpeed=1,score=0,shotsFierd=0;
    private int keyPressed;
    private String direction = "right";
    private List<Target> targetList;
    private List <Balloon> balloons;
    private List <Arrow> ammo;
    private Turtle player;
    private Explosion explosion;
    private MovementListener mahazin;
    private Mouse mouse;
    private Shoot shoot;
    private KeyMazin keyMazin;
    private BackGround gameborad;
    private Point impactpoint;
    private Point arrowtip;
    private JTextField ammoField,scoresField,targetsField;
    private BillboardPanel billboardPanel;

    public GamePanel() {
        impactpoint = new Point(-1,-1);
        billboardPanel = new BillboardPanel();
        gameborad = new BackGround();
        player = new Turtle();
        explosion = new Explosion(0, 0);
        balloons = new ArrayList <>();
        targetList = new ArrayList <>();
        ammo = new ArrayList <>();
        mouse = new Mouse();
        this.addMouseMotionListener(mouse);
        shoot = new Shoot();
        this.addMouseListener(shoot);
        keyMazin = new KeyMazin();
        this.addKeyListener(keyMazin);
        keyPressed = keyMazin.getKeyCode();
        for (int i = 0; i < BALOON_COUNT; i++) {
            Target target = new Target();
            targetList.add(target);
            Balloon balloon = new Balloon(i);
            balloons.add(balloon);
            this.setVisible(true);
        }
        // create ammo
        for (int a = 0; a < AMMO_COUNT; a++) {
            Arrow arrow = new Arrow();
            ammo.add(arrow);
        }
        this.setVisible(true);
        //sound track
        new Thread(() -> {
            try {
                SoundTrack wind = new SoundTrack();
                wind.SoundTrack("wind");
                sleep(1);
            } catch (Exception e) {
                SoundTrack inflateBaloonSound = new SoundTrack();
                inflateBaloonSound.SoundTrack("inflate");
            }
        }).start();
      //arrow
    //  int mikum = player.getXTurtle();
        new Thread(() -> {
            try {
                while (ammo.size()>-1) {
                    switch (shoot.getClick()) {
                        case 1:
                            ammo.get(0).ShootAnArrow(ammo.get(0).getXArrow());
                            shotsFierd += 1;
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    if (ammo.get(0).getyArrowCordinta() < -10) {
                        shoot.setClick(0);
                        ammo.remove(0);
                    }
                    repaint();
                    sleep(0,arrowSpeed*2);
                }
            } catch (Exception e) {
                Thread.dumpStack();
            }
        }).start();

        new Thread(() -> {
            try {
                while (!balloons.isEmpty()) {
                    for (Target target:this.targetList) {
                        target.TargetMoveRandom();
                    }
                    repaint();
                    for (Balloon balloon : this.balloons) {
                        balloon.moveBalloon();
                    }
                    repaint();
                    sleep(balloonSpeed);
                    //remove balloons from screen
                    if (balloonSpeed < 50) {
                        if (balloons.size()>=1){
                            balloons.remove(0);
                        }
                    }
                    // speed up balloon movement
                    if (balloonSpeed > 10) {
                        balloonSpeed -= 1;
                    }
                }
            } catch (InterruptedException e) {
            }
        }).start();
//keyboard listener
        new Thread(() -> {
            try {
                while (true) {
                    switch (keyMazin.getKeyCode()) {
                        case 37:
                            direction = "left";
                            player.PlayerMoves(direction);
                          //  player.moveTurtle(direction);
                            repaint();
                            break;
                        case 38:
                            direction = "up";
                            player.PlayerMoves(direction);
                         //   player.moveTurtle(direction);
                            repaint();
                            break;

                        case 39:
                            direction = "right";
                            player.PlayerMoves(direction);
                         //   player.moveTurtle(direction);
                            repaint();
                            break;
                        case 40:
                            direction = "down";
                            player.PlayerMoves(direction);
                       //     player.moveTurtle(direction);
                            repaint();
                            break;

                    }
                    repaint();
                    sleep(turtulespeed);
                }
            } catch (Exception e) {
            }
        }).start();
        new Thread(()->{
            try {
            while (impactpoint.getxCordinta()*impactpoint.getyCordinta()!=1){
                    explosion.createExplosion(impactpoint);
                    sleep(2500);
                    repaint();
            }
            }catch (Exception e){}
        }).start();
        this.setFocusable(true);
        this.requestFocus();
        String a=""+ammo.size();
        ammoField = new JTextField(a);
        billboardPanel.setAmmoText(ammoField);
        String scoreText = ""+score;
        scoresField = new JTextField(scoreText+"");
        billboardPanel.setScoreText(scoresField);
        String balloonsLeft=""+balloons.size();
        targetsField = new JTextField(balloonsLeft);
        billboardPanel.setTargetsText(targetsField);
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        //main game board
        int ammoLeft = ammo.size();
        String ammoText = "" + ammoLeft;
        billboardPanel.PaintBillboardPanel(page);
        ammoField.setText(ammoText + "   ");
        billboardPanel.setAmmoText(ammoField);
        String scoreText = "" + score;
        scoresField.setText(scoreText + "         ");
        String balloonsLeft = "" + balloons.size();
        targetsField.setText(balloonsLeft + "      ");
        this.add(billboardPanel, -1);
        gameborad.getBackgroundIcon().paintIcon(this, page, 0, 0);
        int ammoNumber = 0;
        int i = 1;
        int w = (player.getPlayerIcon().getIconWidth()) / 2;
        int x1 = player.getPlayerX();
        //  int x = ammo.get(1).getXArrow();
        while (ammoNumber < ammo.size()) {
            ammo.get(ammoNumber).setXArrow(x1);
            int i1 = 1;
            while (i < balloons.size() && i1 < targetList.size()) {
                impact = false;
                targetList.get(i1).getTargetIcon().paintIcon(this, page, targetList.get(i1).getTargetLocation().getxCordinta(), targetList.get(i1).getTargetLocation().getyCordinta());
                balloons.get(i).getBalloon().paintIcon(this, page, balloons.get(i).getTargetLocation().getxCordinta(), balloons.get(i).getTargetLocation().getyCordinta());
                ammo.get(ammoNumber).getArrow().paintIcon(this, page, ammo.get(ammoNumber).getXArrow(), ammo.get(ammoNumber).getyArrowCordinta());
                int targetIconW = targetList.get(i1).getTargetIcon().getIconWidth();
                int targetIconH = targetList.get(i1).getTargetIcon().getIconHeight();
                Point targetPoint = new Point(targetList.get(i1).getTargetLocation().getxCordinta(), targetList.get(i1).getTargetLocation().getyCordinta());
                Point warHeadPoint = new Point(ammo.get(ammoNumber).getXArrow() + 45, ammo.get(ammoNumber).getyArrowCordinta() + 3);
                if (warHeadPoint.PointImpact(targetPoint, targetIconW, targetIconH, warHeadPoint)) {
                    impact = true;
                    score += 100;
                    impactpoint = new Point(targetPoint.getxCordinta(), targetPoint.getyCordinta());
                    explosion.getExplosionIcon().paintIcon(this, page, impactpoint.getxCordinta(), impactpoint.getyCordinta());
                    SoundTrack boom = new SoundTrack();
                    boom.SoundTrack("boom");
                    this.repaint();
                    targetList.remove(i1);
                }
                impact = false;
                Point balloonPoint = new Point(balloons.get(i).getTargetLocation().getxCordinta(), balloons.get(i).getTargetLocation().getyCordinta());
                Point arrowtip = new Point(ammo.get(ammoNumber).getXArrow() + 45, ammo.get(ammoNumber).getyArrowCordinta() + 3);
                int ballooniconwidth = balloons.get(i).getTargetIcon().getIconWidth();
                int ballooniconhight = balloons.get(i).getTargetIcon().getIconHeight();
                int bx = balloons.get(i).getTargetLocation().getxCordinta();
                int by = balloons.get(i).getTargetLocation().getyCordinta();
                if (arrowtip.PointImpact(balloonPoint, ballooniconwidth, ballooniconhight, arrowtip)) {
                    score += 49;
                    System.out.println("SCORE:" + score);
                    impact = true;
                    impactpoint = new Point(balloonPoint.getxCordinta(),balloonPoint.getyCordinta());
                    explosion.getExplosionIcon().paintIcon(this, page, impactpoint.getxCordinta(), impactpoint.getyCordinta());
                    SoundTrack boom = new SoundTrack();
                    boom.SoundTrack("boom");
                    this.repaint();
                    balloons.remove(i1);
                }
                impact = false;
                i++;
                i1++;
            }
            ammoNumber++;

    }
    //turtle
        turtlehight = player.getTurtle().getIconHeight();
        turtleWidth = player.getTurtle().getIconWidth();
        playerWidh = player.getPlayerIcon().getIconWidth();
        playerHight = player.getPlayerIcon().getIconHeight();

        switch (direction){
            case "left":
                player.getPlayerIconLeft().paintIcon(this,page,player.getPlayerX(), player.getPlayerY());
         //       player.getTurtleIconL().paintIcon(this,page,player.getXTurtle(),player.getYTurtle());
                break;
            case "right":
                player.getPlayerIconRight().paintIcon(this,page,player.getPlayerX(), player.getPlayerY());
            //    player.getTurtleIconR().paintIcon(this,page,player.getXTurtle(),player.getYTurtle());
                break;
        }

        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();
        }
public static void main(String[] args){
        GamePanel gamePanel = new GamePanel();
}
    }
