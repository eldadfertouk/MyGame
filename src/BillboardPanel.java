import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageProducer;

public class BillboardPanel extends JPanel {
    private JPanel billBoard = new JPanel();
    private JLabel scoreLabel,ammoLabel,levelLabel,livesLabel, targetsLabel;
    private JTextField scoreText,ammoText,levelText, livesText, targetsText;
    private Dimension boxDimention;
    private ImageIcon icon;
    private LayoutManager layOut;
    private Graphics baner;
    private Container container=new Container();

    public BillboardPanel(){
        super.paint(baner);
        layOut = new GridLayout(2,8,1,1);
        billBoard.setLayout(layOut);
        container.setLayout(layOut);
        container.add(billBoard);
        icon = new ImageIcon(getClass().getResource("images/turtle40x40.gif"));
        boxDimention = new Dimension(80,40);
     //   billBoard.setBackground(Color.BLUE);
        billBoard.setFont(new Font("Guttman Yad-Light",Font.BOLD,26));
        billBoard.setBounds(0,0,900,50);
        container.setLayout(layOut);
        scoreLabel=new JLabel("SCORE:", (int) CENTER_ALIGNMENT);
        scoreLabel.setPreferredSize(boxDimention);
        billBoard.add(scoreLabel,0 );
        ammoLabel=new JLabel("AMMO:",(int)CENTER_ALIGNMENT);
        ammoLabel.setPreferredSize(boxDimention);
        billBoard.add(ammoLabel, 1);
        levelLabel=new JLabel("LEVEL:",(int)CENTER_ALIGNMENT);
        levelLabel.setPreferredSize(boxDimention);
        billBoard.add(levelLabel, 2);
        livesLabel=new JLabel("TURTLES LEFT:",(int)CENTER_ALIGNMENT);
        livesLabel.setPreferredSize(boxDimention);
        billBoard.add(livesLabel, 3);
        targetsLabel=new JLabel("TARGETS",(int)CENTER_ALIGNMENT);
        targetsLabel.setPreferredSize(boxDimention);
        billBoard.add(targetsLabel,4);
        levelText=new JTextField("Level 1",5);
        levelText.setPreferredSize(boxDimention);
        billBoard.add(levelText, 5);
        livesText=new JTextField("turtle lives",6);
        livesText.setPreferredSize(boxDimention);
        billBoard.add(livesText, 6);
        this.ammoText = new JTextField("",8);
        this.ammoText.setPreferredSize(boxDimention);
        billBoard.setBackground(Color.white);
    }

public void PaintBillboardPanel(Graphics datapage){
        super.paintComponent(datapage);
        billBoard.setBounds(1,1,900,80);
        billBoard.add(ammoLabel);
        billBoard.add(ammoText);
        billBoard.add(scoreLabel);
        billBoard.add(scoreText);
        billBoard.add(livesLabel);
        billBoard.add(livesText);
        billBoard.add(levelLabel);
        billBoard.add(levelText);
        billBoard.add(targetsText);
        billBoard.add(targetsText);
        billBoard.setVisible(true);
        this.add(billBoard);
}

    public JLabel getBalloonLabel() {
        return targetsLabel;
    }

    public void setTargetsLabel(JLabel targetsLabel) {
        this.targetsLabel = targetsLabel;
    }

    public JTextField getTargetsText() {
        return targetsText;
    }

    public void setTargetsText(JTextField targetsText) {
        this.targetsText=targetsText;

    }

    public Dimension getBoxDimention() {
        return boxDimention;
    }

    public void setBoxDimention(Dimension boxDimention) {
        this.boxDimention = boxDimention;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public JPanel getBillBoard() {
        return billBoard;
    }

    public void setBillBoard(JPanel billBoard) {
        this.billBoard = billBoard;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public JLabel getAmmoLabel() {
        return ammoLabel;
    }

    public void setAmmoLabel(JLabel ammoLabel) {

        this.ammoLabel = ammoLabel;

    }

    public JLabel getLevelLabel() {
        return levelLabel;
    }

    public void setLevelLabel(JLabel levelLabel) {
        this.levelLabel = levelLabel;
    }

    public JLabel getLivesLabel() {
        return livesLabel;
    }

    public void setLivesLabel(JLabel livesLabel) {
        this.livesLabel = livesLabel;
    }

    public JTextField getScoreText() {
        return scoreText;
    }

    public void setScoreText(JTextField scoreText) {
        this.scoreText = scoreText;
    }

    public JTextField getAmmoText() {
        return ammoText;
    }

    public void setAmmoText(JTextField ammoText)
    {
      this.ammoText = ammoText;

    }

    public JTextField getLevelText() {
        return levelText;
    }

    public void setLevelText(JTextField levelText) {
        this.levelText = levelText;
    }

    public JTextField getLivesText() {
        return livesText;
    }

    public void setLivesText(JTextField livesText) {
        this.livesText = livesText;
    }
}
