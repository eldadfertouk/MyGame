import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DifficultyLevelPanel extends JPanel
        implements ActionListener {

    static String hradString = "hard";
    static String normalString = "normal";
    static String easyString = "easy";
    static Font font = new Font("ariel", Font.BOLD, 20);
    public String difficultyLevel;
    JLabel picture;

    public DifficultyLevelPanel() {
        super(new BorderLayout());

        //Create the radio buttons.
        JRadioButton hardButton = new JRadioButton(hradString);
        hardButton.setFont(font);
        hardButton.setMnemonic(KeyEvent.VK_B);
        hardButton.setActionCommand(hradString);
        hardButton.setSelected(true);

        JRadioButton normalButton = new JRadioButton(normalString);
        normalButton.setFont(font);
        normalButton.setMnemonic(KeyEvent.VK_C);
        normalButton.setActionCommand(normalString);

        JRadioButton easyButton = new JRadioButton(easyString);
        easyButton.setFont(font);
        easyButton.setMnemonic(KeyEvent.VK_D);
        easyButton.setActionCommand(easyString);


        //Group the radio buttons.
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(hardButton);
        difficultyGroup.add(normalButton);
        difficultyGroup.add(easyButton);
        normalButton.setSelected(true);

        //Register a listener for the radio buttons.
        hardButton.addActionListener(this);
        normalButton.addActionListener(this);
        easyButton.addActionListener(this);

        //Set up the picture label.
        picture = new JLabel(createImageIcon("\\images\\difficulty\\"
                + normalString
                + ".gif"));

        picture.setPreferredSize(new Dimension(100, 100));


        //Put the radio buttons in a column in a panel.
        JPanel difficultyPanel = new JPanel(new GridLayout(0, 1));
        difficultyPanel.setFont(font);
        difficultyPanel.add(hardButton);
        difficultyPanel.add(normalButton);
        difficultyPanel.add(easyButton);
        add(difficultyPanel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }


    public void actionPerformed(ActionEvent e) {
        difficultyLevel=e.getActionCommand();
        picture.setIcon(createImageIcon("\\images\\difficulty\\"
                + e.getActionCommand()
                + ".gif"));
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PlayerRadioButtonPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("difficulty Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        JComponent newContentPane = new PlayerRadioButtonPanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}

