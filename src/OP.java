import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OP extends JFrame implements ActionListener , ChangeListener {

    private int MAX_AMMO, MAX_TARGETS;
    private JFrame optionFrame;
    private JPanel optionPanel, dataPanel, labelsPanel, buttonsPanel;
    private Dimension labelsDimension = new Dimension(100, 25);
    private Dimension slidersDimension = new Dimension(100, 25);
    private Dimension textFields = new Dimension(100, 25);
    private Dimension buttonsDimension = new Dimension(95, 25);
    private Dimension dataPanelDimension = new Dimension(550, 200);
    private Dimension labelsPanelDimension = new Dimension(550, 200);
    private JSpinner maxLives;
    private JSlider ammoSlider;
    private JSlider targetSlider;
    private JLabel lives, ammo, targets, difficulty;
    private JTextField difficultyText, ammoText, targetText;
    private Font font = new Font("ariel", Font.BOLD, 20);
    private JButton go, quit, reset;
    private ImageIcon turtuleIcoon;
    private PlayerRadioButtonPanel playerRadioButtonPanel;
    private DifficultyLevelPanel difficultyLevelPanel;
    private FocusListener focusListener;
    public String playerFigure,difficultyLevel;
    public MatchConfig matchConfig;

    public OP() {

        BuildOptionFrame();
        BuildLabelsPanel();
        BuildDataPanel();
        BuildOptionPanel();
        BuildButtonsPanel();
        playerRadioButtonPanel = new PlayerRadioButtonPanel();
        optionFrame.add(labelsPanel,0);
        optionFrame.add(dataPanel,1);
        optionFrame.add(optionPanel,2);
        optionFrame.add(playerRadioButtonPanel,3);
        optionFrame.add(buttonsPanel,4);
        optionFrame.setVisible(true);
        optionFrame.pack();
    }

    private void BuildOptionFrame() {
        turtuleIcoon = new ImageIcon(this.getClass().getResource("images/icons/turtliconss.png"));
        optionFrame = new JFrame();
        optionFrame.setLayout(new BoxLayout(optionFrame.getContentPane(),BoxLayout.Y_AXIS));
        optionFrame.setBounds(20,20,650,700);
        optionFrame.setLocationByPlatform(true);
        optionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        optionFrame.setBackground(Color.BLUE);
        optionFrame.setIconImage(turtuleIcoon.getImage());
        optionFrame.setVisible(true);

    }


    public static void main(String[] args) {
        new OP();
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println(e.paramString());
        if (e.getSource() == go) {
            System.out.println("GOGOGOGOG");
            matchConfig = new MatchConfig(1,1,1, 5, MAX_AMMO,MAX_TARGETS);
            Level game = new Level(matchConfig);
        } else if (e.getSource() == reset) {
            System.out.println("RESET");
            MAX_AMMO = 5;
            ammoText.setText(Integer.toString(MAX_AMMO));
            ammoSlider.setValue(MAX_AMMO);
            MAX_TARGETS = 5;
            targetSlider.setValue(MAX_TARGETS);
            targetText.setText(Integer.toString(MAX_TARGETS));
            maxLives.setValue(1);
            difficultyText.setText(difficultyLevelPanel.getDifficultyLevel());
        } else if (e.getSource() == quit) {
            dispatchEvent(new WindowEvent(this, DISPOSE_ON_CLOSE));
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
    private void BuildLabelsPanel(){
        FlowLayout flowLabelsLayout= new FlowLayout(FlowLayout.LEADING,15,15);
        labelsPanel = new JPanel(flowLabelsLayout);
        labelsPanel.setSize(labelsPanelDimension);
        labelsPanel.setVisible(true);
        labelsPanel.setLocation(0, 0);
        labelsPanel.setFont(font);
        lives = new JLabel("LIVES", SwingConstants.CENTER);
        lives.setPreferredSize(labelsDimension);
        lives.setFont(font);

        ammo = new JLabel("AMMO", SwingConstants.CENTER);
        ammo.setPreferredSize(labelsDimension);
        ammo.setForeground(Color.RED);
        ammo.setFont(font);
        ammo.setVisible(true);

        targets = new JLabel("TARGETS", SwingConstants.CENTER);
        targets.setPreferredSize(labelsDimension);
        targets.setForeground(Color.BLUE);
        targets.setFont(font);
        targets.setVisible(true);

        difficulty = new JLabel("DIFFICULTY", SwingConstants.CENTER);
        difficulty.setForeground(Color.BLUE);
        difficulty.setFont(font);
        difficulty.setVisible(true);
        lives.setForeground(Color.BLUE);
        lives.setVisible(true);
        labelsPanel.add(lives,0);
        labelsPanel.add(ammo, 1);
        labelsPanel.add(targets, 2);
        labelsPanel.add(difficulty, 3);
    }
    private void BuildDataPanel(){
        FlowLayout flowDataLayout= new FlowLayout(FlowLayout.LEADING,25,25);
        dataPanel = new JPanel(flowDataLayout);
        dataPanel.setSize(dataPanelDimension);
        dataPanel.setFont(font);
        SpinnerModel model1 = new SpinnerNumberModel();
        maxLives = new JSpinner(model1);
        maxLives.setValue(1);
        maxLives.setPreferredSize(buttonsDimension);
        maxLives.setFont(font);
        difficultyText = new JTextField("normal");
        ammoText = new JTextField("" + MAX_AMMO);
        targetText = new JTextField("" + MAX_TARGETS);
        difficultyText.setFont(font);
        ammoText.setFont(font);
        targetText.setFont(font);
        difficultyText.setPreferredSize(textFields);
        ammoText.setPreferredSize(textFields);
        targetText.setPreferredSize(textFields);
        difficultyText.setVisible(true);
        ammoText.setVisible(true);
        targetText.setVisible(true);
        dataPanel.add(maxLives,0);
        dataPanel.add(ammoText, 1);
        dataPanel.add(targetText, 2);
        dataPanel.add(difficultyText, 3);
        dataPanel.setVisible(true);

    }
    private void BuildOptionPanel(){
        FlowLayout flowOptionLayout= new FlowLayout(FlowLayout.LEADING,15,15);
        optionPanel = new JPanel(flowOptionLayout);
        optionPanel.setPreferredSize(dataPanelDimension);
        optionPanel.setLocation(0, 200);
        optionPanel.setVisible(true);

        ammoSlider = new JSlider(1, 50, 25);
        ammoSlider.setPreferredSize(slidersDimension);
        ammoSlider.addChangeListener(this::slidersListeners);

        targetSlider = new JSlider(1, 250, 25);
        targetSlider.setPreferredSize(slidersDimension);
        targetSlider.addChangeListener(this::slidersListeners);
        difficultyLevelPanel = new DifficultyLevelPanel();

        optionPanel.setVisible(true);
        optionPanel.add(ammoSlider,0);
        optionPanel.add(targetSlider,1);
        optionPanel.add(difficultyLevelPanel,2);
        optionPanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                difficultyText.setText(difficultyLevelPanel.getDifficultyLevel());
            }
        });

    }
    private void BuildButtonsPanel(){
        FlowLayout flowButtonsLayout= new FlowLayout(FlowLayout.LEADING,35,25);
        buttonsPanel = new JPanel(flowButtonsLayout);
        buttonsPanel.setSize(dataPanelDimension);

        go = new JButton("GO");
        reset = new JButton("RESET");
        quit = new JButton("QUIT");
        go.setPreferredSize(buttonsDimension);
        reset.setPreferredSize(buttonsDimension);
        quit.setPreferredSize(buttonsDimension);
        go.addActionListener(this);
        quit.addActionListener(this);
        reset.addActionListener(this);
        buttonsPanel.add(go, 0);
        buttonsPanel.add(reset, 1);
        buttonsPanel.add(quit, 2);
        buttonsPanel.setVisible(true);

    }

    /**
     * Invoked when the target of the listener has changed its state.
     *
     * @param e a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        difficultyText.setText(difficultyLevelPanel.getDifficultyLevel());
    }
}
