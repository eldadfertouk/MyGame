import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.desktop.QuitEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class OptionPanel extends JFrame implements ActionListener {
    public static int OPTIONSSCREENHIGHT=400,OPTIONSSCREENWIDTH=400;
    public int MAX_PLAYER_LIVES,MAX_AMMO,MAX_TARGETS;
    private JFrame OptionFrame=new JFrame();
    private JPanel optionPanel,dataPanel,labelsPanel,buttonsPanel;
    private Dimension dimension = new Dimension(OPTIONSSCREENWIDTH,OPTIONSSCREENHIGHT);
    private Dimension labelsDimension=new Dimension(75,25);
    private Dimension slidersDimension = new Dimension(75,25);
    private Dimension dataPanelDimension=new Dimension(400,75);
    private Dimension labelsPanelDimension=new Dimension(400,75);
    private Dimension textFields = new Dimension(75,25);
    private Dimension buttonsDimension = new Dimension(75,25);
    private JSpinner maxLives;
    private JSlider ammoSlider;
    private JSlider targetSlider;
    private JLabel lives,ammo,targets,players;
    private JTextField livesText,ammoText,targetText;
    private Font font=new Font("ariel",Font.BOLD,20);
    private JButton go,quit,reset;

    public OptionPanel(){
        super("option panel");
        setPreferredSize(dimension);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GridLayout g1 = new GridLayout(3,1,5,5);
        setLayout(g1);
        setFont(font);
        //labls
        createlabelsContainer();
        //pakadim
        createPakadim();
        //data fields
        createDataFields();
        createButtonsContainer();

        this.add(buttonsPanel);
        this.add(dataPanel);
        this.add(optionPanel);
        this.add(labelsPanel);
        this.setVisible(true);
        this.pack();
    }

    private void createlabelsContainer() {
        labelsPanel = new JPanel();
        Container labelsPanel = this.getContentPane();
        labelsPanel.setSize(labelsPanelDimension);
        labelsPanel.setVisible(true);
        labelsPanel.setLocation(0,0);
        labelsPanel.setFont(font);
        lives = new JLabel("LIVES",SwingConstants.CENTER);
        lives.setPreferredSize(labelsDimension);
        lives.setFont(font);
        lives.setForeground(Color.BLUE);
        lives.setVisible(true);
        labelsPanel.add(lives,0);
        ammo = new JLabel("AMMO",SwingConstants.CENTER);
        ammo.setPreferredSize(labelsDimension);
        ammo.setForeground(Color.RED);
        ammo.setFont(font);
        ammo.setVisible(true);
        labelsPanel.add(ammo,1);
        targets = new JLabel("TARGETS",SwingConstants.CENTER);
        targets.setPreferredSize(labelsDimension);
        targets.setForeground(Color.BLUE);
        targets.setFont(font);
        targets.setVisible(true);
        labelsPanel.add(targets,2);
        players =new JLabel("PLAYERS",SwingConstants.CENTER);
        players.setForeground(Color.BLUE);
        players.setFont(font);
        players.setVisible(true);
        labelsPanel.add(players,3);
    }
    private void createPakadim() {
        optionPanel = new JPanel();
        Container optionsPanel = this.getContentPane(); // inherit main frame
        optionsPanel.setPreferredSize(dataPanelDimension);
        optionsPanel.setLocation(0,100);
        optionsPanel.setVisible(true);
        SpinnerModel model1 = new SpinnerNumberModel();
        maxLives = new JSpinner(model1);
        maxLives.setValue(MAX_PLAYER_LIVES);
        maxLives.setPreferredSize(buttonsDimension);
        maxLives.setFont(font);
        optionsPanel.add(maxLives);
        ammoSlider = new JSlider(1,50,25);
        ammoSlider.setPreferredSize(slidersDimension);
        ammoSlider.addChangeListener(this::slidersListeners);
        optionsPanel.add(ammoSlider);
        targetSlider = new JSlider(1,250,25);
        targetSlider.setPreferredSize(slidersDimension);
        targetSlider.addChangeListener(this::slidersListeners);
        optionsPanel.add(targetSlider);
        optionsPanel.setVisible(true);

    }
    private void createDataFields() {
        dataPanel = new JPanel();
        Container dataPanel = this.getContentPane();
        dataPanel.setSize(dataPanelDimension);
        dataPanel.setFont(font);
        dataPanel.setLocation(0,200);
        livesText = new JTextField(""+MAX_PLAYER_LIVES);
        ammoText = new JTextField(""+MAX_AMMO);
        targetText = new JTextField(""+MAX_TARGETS);
        livesText.setPreferredSize(textFields);
        ammoText.setPreferredSize(textFields);
        targetText.setPreferredSize(textFields);
        livesText.setVisible(true);
        ammoText.setVisible(true);
        targetText.setVisible(true);
        dataPanel.add(livesText,0);
        dataPanel.add(ammoText,1);
        dataPanel.add(targetText,2);
        dataPanel.setVisible(true);
    }

    private void createButtonsContainer() {
        buttonsPanel = new JPanel();
        Container buttonsPanel = this.getContentPane();
        buttonsPanel.setSize(dataPanelDimension);
        buttonsPanel.setLocation(0,300);
        go = new JButton("GO");
        reset = new JButton("RESET");
        quit = new JButton("QUIT");
        go.setPreferredSize(buttonsDimension);
        reset.setPreferredSize(buttonsDimension);
        quit.setPreferredSize(buttonsDimension);
        go.addActionListener(this);
        quit.addActionListener(this);
        reset.addActionListener(this);
        buttonsPanel.add(go,0);
        buttonsPanel.add(reset,1);
        buttonsPanel.add(quit,2);
        buttonsPanel.setVisible(true);
    }


    public static void main(String[] args) {
        new OptionPanel();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==go){
            System.out.println("GOGOGOGOG");
            Level game = new Level(1);
        }
        else if (e.getSource()==reset){
            System.out.println("RESET");
            MAX_AMMO=5;
            ammoText.setText(Integer.toString(MAX_AMMO));
            ammoSlider.setValue(MAX_AMMO);
            MAX_TARGETS=5;
            targetSlider.setValue(MAX_TARGETS);
            targetText.setText(Integer.toString(MAX_TARGETS));
            MAX_PLAYER_LIVES=1;
            maxLives.setValue(MAX_PLAYER_LIVES);
            livesText.setText(Integer.toString(MAX_PLAYER_LIVES));
        }
        else if (e.getSource()==quit){
            dispatchEvent(new WindowEvent(this,DISPOSE_ON_CLOSE));
        }
    }

    public void slidersListeners(ChangeEvent e) {
        if (ammoSlider.getValueIsAdjusting()) {
            MAX_AMMO = ammoSlider.getValue();
            ammoText.setText(Integer.toString(MAX_AMMO));
        }
        if (targetSlider.getValueIsAdjusting()) {
            MAX_TARGETS = targetSlider.getValue();
            targetText.setText(Integer.toString(MAX_TARGETS));
        }
    }
}



