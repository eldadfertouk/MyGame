import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Level extends JPanel {
    //set static variables
    private int TARGETS_COUNTS = 50;
    private int TARGET_SPEED = 250;
    private int AMMO_COUNT = 50;
    private int MUNITION_TOTAL = 50;
    private int TOTAL_ROCKETS = 50;
    //set static threads
    private String TARGET_TYPE = "defaulttarget";
    private static Thread trgetsMotion, fighterMotion, ammoUse, soundTrack;
    //set int variables
    private int playerSpeed = 1, score = 0, shotsFierd = 0, arrowSpeed = 1, ammoSpeed = 5, targetSpeed = 250;
    private JPanel mainPanel = new JPanel();
    //set classes obj.
    private BillboardPanel billboardPanel;
    private Player player;
    private AimListener scopeSightListener;
    private BackGround gameBorad;
    private Point impactPoint, warHeadPoint, explosionPoint, scopePoint, mousePoint, playerLocation, rocketDestination;
    private Explosion explosion;
    private Mouse mouse;
    private AimListener mySights;
    private KeyEvent move;
    private Shoot shoot;
    private KeyMazin keyMazin;
    //create scope
    private ScopeSight scope = new ScopeSight();
    private Rocket rocket;
    //set booleans
    private boolean impact = false;
    //set strings
    private String direction = "right";
    //create lists
    private List <HotAirBalloon> hotAirBalloons;
    private List <Munitions> weapons;
    private List <Target> targetsList;
    private List<Munitions> rockets;
    //create text fields
    private JTextField ammoField, targetsField, scoresField, ammoRemain;
    private MatchConfig matchConfig;
    public Level(MatchConfig matchConfig){
        TARGETS_COUNTS = matchConfig.getTargets();
        TARGET_TYPE = "defaulttarget";
        AMMO_COUNT = matchConfig.getAmmo();
        int DIFFICULTY = matchConfig.getLevel();
        int FIGTHER_SPEED = 1; TARGET_SPEED = 250;  MUNITION_TOTAL = 50;TOTAL_ROCKETS = 50;

    }
    public Level(int stage) {
        mainPanel.setLayout(null);
        impactPoint = new Point(-1, -1);
        billboardPanel = new BillboardPanel();
        gameBorad = new BackGround(1);
        player = new Player();
        explosion = new Explosion(0, 0);
        weapons = new ArrayList <>();
        hotAirBalloons = new ArrayList <>();
        targetsList = new ArrayList <Target>();
        rockets = new ArrayList<Munitions>();
        mouse = new Mouse();
        this.addMouseMotionListener(mouse);
        shoot = new Shoot();
        this.addMouseListener(shoot);
        keyMazin = new KeyMazin();
        this.addKeyListener(keyMazin);
        scopeSightListener = new AimListener();
        this.addMouseMotionListener(scopeSightListener);
        mousePoint = new Point(mouse.getxMouseCordinta(), mouse.getyMouseCordinta());
        JOptionPane.showMessageDialog(this,"Level: "+stage);
        this.TARGET_TYPE = "hotairballoon";
//create targets
        for (int i = 0; i <= TARGETS_COUNTS; i++) {
            //Target target = new Target(this.TARGET_TYPE,this.targetsList.size(),true);
            Target target = new Target();
            this.targetsList.add(target);
            this.setVisible(true);
        }
//create munition
        for (int m = 1; m <= MUNITION_TOTAL; m++) {
            Munitions weapon = new Munitions();
            weapons.add(weapon);
          //  System.out.println(weapon.toString());
        }
        for (int r = 1; r <= TOTAL_ROCKETS;r++){
            Munitions rocket = new Munitions("rocket");
            rockets.add(rocket);
        }
//move target
        new Thread(() -> {
            try {
                while (!targetsList.isEmpty()) {
                    for (Target target : targetsList) {
                        target.TargetMoveRandom(); }
                    Thread.sleep(targetSpeed);
                }
            } catch (InterruptedException e) {
            }
        }).start();
//sound track
        new Thread(() -> {
            try {
                SoundTrack wind = new SoundTrack();
                wind.SoundTrack("wee");
                Thread.sleep(1);
            } catch (Exception e) {
            }
        }).start();
//scopesight
        new Thread(() -> {
            try {
                double x = scopeSightListener.getxAimCordinta();
                double y = scopeSightListener.getyAimCordinta();
                scopePoint.setLocation(x,y);
                while (true) {
                    scope.ScopeTracking(scopeSightListener);
                    Point scopeP = scope.getScopeLocation();
                    int x1 = scope.getX();
                    int y1= scope.getY();
                    Rectangle s= new Rectangle(scopeP.getxCordinta(),scopeP.getyCordinta(),scope.getWidth(),scope.getHeight());
                    for (Target target:targetsList) {
                        if (s.contains(target.getLocation())) {
                        target.setRadarLockOn(true);
                            System.out.println("got radar lock on");
                            System.out.println(target.getTargetNumber());
                        }
                    }
                    Thread.sleep(0, 1);
                }
            } catch (Exception e) {
            }
        }).start();
//arrow
 new Thread(() -> {
            try {
                while (true) {
                   switch (shoot.getClick()) {
                        case 1:
                            for (Target target : targetsList) {
                                scopePoint.setLocation(scopeSightListener.getMousePoint());
                                if(!scopePoint.isPointInside(mousePoint,target.getX(), target.getY())){
                                    System.out.println("GOOD VERY GOOD"); }
                                System.out.println(":" + scopePoint + ":" + ":" + scope.getWidth() + ":" + ": " + ":" + ":" + scope.getHeight() + ":" + ":" + target.getTargetWide() + ":" + ":" + target.getTargetHeight() + ":" + ":" + target.getTargetLocation());
                                if (!scopePoint.isSightOnTarget(scopePoint, scope.getWidth(), scope.getHeight(), target.getTargetWide(), target.getTargetHeight(), target.getTargetLocation()))
                                    target.setRadarLockOn(true);
                                System.out.println("LOCKON" + target);
                                weapons.get(0).MunitionUse(weapons.get(0), playerLocation, scopePoint);
                                shotsFierd += 1;
                                weapons.get(0).setProjectilePath(playerLocation,scopePoint);
                                shotsFierd += 1;}
                            break;
                         case 2:
                            break;
                        case 3:
                            break;
                 }
                   if (weapons.get(0).Xammo<= -10 ) {
                       shoot.setClick(0);
                        weapons.remove(0);
                   }
                   repaint();
                    Thread.sleep(0,arrowSpeed*2);
                }
           } catch (Exception e) {
            }
       }).start();
//mouse listner
//keyboard listner for fighter movement
// players
        new Thread(() -> {
            try {
                while (true) {
                    switch (keyMazin.getKeyCode()) {
                        case 37:
                            direction = "left";
                            player.PlayerMoves(direction);
                            repaint();
                            break;
                        case 38:
                            direction = "up";
                            player.PlayerMoves(direction);
                            repaint();
                            break;
                        case 39:
                            direction = "right";
                            player.PlayerMoves(direction);
                            repaint();
                            break;
                        case 40:
                            direction = "down";
                            player.PlayerMoves(direction);
                            repaint();
                            break;
                        case 76:
                            for (Target target:targetsList) {
                                if (scopePoint.getxCordinta() <= target.getX()) {
                                    target.getY();
                                }
                                {
                                    System.out.println("LockOn");
                            }
                        }
                    }
                    repaint();
                    Thread.sleep(playerSpeed);
                }
            } catch (Exception e) {
            }
        }).start();
//impact detection
        new Thread(() -> {
            try {
                while (impactPoint.getX() * impactPoint.getY() != 1) {
                    explosion.createExplosion(impactPoint);
                    Thread.sleep(250);
                    repaint();
                }
            } catch (Exception e) {
            }
        }).start();
        this.setFocusable(true);
        this.requestFocus();
        String a = "" + weapons.size();
        ammoField = new JTextField(a);
        billboardPanel.setAmmoText(ammoField);
        String scoreText = "" + score;
        scoresField = new JTextField(scoreText + "");
        billboardPanel.setScoreText(scoresField);
        String targetsLeft = "" + targetsList.size();
        targetsField = new JTextField(targetsLeft);
        billboardPanel.setTargetsText(targetsField);
    }


    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        //mouse curser to cros air
        super.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        // back ground
          //main game board
        // billboard panel
        mainPanel.paint(page);
        billboardPanel.PaintBillboardPanel(page);
        int ammoLeft = weapons.size();
        String ammoText = "" + ammoLeft;
        ammoField.setText(ammoText + " ");
        billboardPanel.setAmmoText(ammoField);
        scoresField.setText(score + " ");
        String balloonsLeft = "" + targetsList.size();
        targetsField.setText(balloonsLeft + "      ");
        mainPanel.add(billboardPanel,-1);
        gameBorad.getBackgroundIcon().paintIcon(this, page, 0, 0);
        billboardPanel.setBackground(Color.YELLOW);
        scope.getScopeSightIcon().paintIcon(this, page, scopeSightListener.getxAimCordinta(), scopeSightListener.getyAimCordinta());
        player.getPlayerIcon().paintIcon(this,page,player.getPlayerX(),player.getPlayerY());
        this.setFocusable(true);
        this.setVisible(true);
        mainPanel.setVisible(true);
        int i1 = 0;int w=0;
        while (w <= weapons.size()) {
            weapons.get(w).getAmmoIcon().paintIcon(this, page, player.getPlayerX(), player.getPlayerY());
            while (i1 <= targetsList.size()) {
                for (Target target : targetsList){
                    if (target.isRadarLockOn()) {
                        scope.getRadarLockon().paintIcon(this,page,target.getTargetLocation().getxCordinta(), target.getTargetLocation().getyCordinta());
                        w++;}
                    else target.getTargetIcon().paintIcon(this, page, target.getTargetLocation().getxCordinta(), target.getTargetLocation().getyCordinta());
                    w++;}
            i1++;}
            }
        switch (direction) {
            case "left":
                player.getPlayerIconLeft().paintIcon(this,page,player.getPlayerX(),player.getPlayerY());
                break;
            case "right":
                player.getPlayerIconRight().paintIcon(this,page,player.getPlayerX(),player.getPlayerY());
                break;
            case "up":
                player.getPlayerIconUp().paintIcon(this,page,player.getPlayerX(),player.getPlayerY());
                break;
            case "down":
                player.getPlayerIconDown().paintIcon(this,page,player.getPlayerX(),player.getPlayerY());
                break;
        }
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();
    }

    public static void main(String[] args) {
        for (String s:args) {
            int l=(Integer.parseInt(s));
                    Level game = new Level(l);
        }
        Level game = new Level(1);

    }

}

