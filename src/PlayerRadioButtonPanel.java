import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerRadioButtonPanel extends JPanel
        implements ActionListener {

    static String turtleString = "turtle";
    static String camelString = "camel";
    static String armadilString = "armadil";
    static Font font = new Font("ariel", Font.BOLD, 20);
    public String chosenPlayer;
    JLabel picture;

    public PlayerRadioButtonPanel() {
        super(new BorderLayout());
        this.setFont(font);
        //Create the radio buttons.
        JRadioButton turtleButton = new JRadioButton(turtleString);
        turtleButton.setFont(font);
        turtleButton.setMnemonic(KeyEvent.VK_B);
        turtleButton.setActionCommand(turtleString);
        turtleButton.setSelected(true);

        JRadioButton camelButton = new JRadioButton(camelString);
        camelButton.setFont(font);
        camelButton.setMnemonic(KeyEvent.VK_C);
        camelButton.setActionCommand(camelString);

        JRadioButton armadilButton = new JRadioButton(armadilString);
        armadilButton.setFont(font);
        armadilButton.setMnemonic(KeyEvent.VK_D);
        armadilButton.setActionCommand(armadilString);


        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(turtleButton);
        group.add(camelButton);
        group.add(armadilButton);

        //Register a listener for the radio buttons.
        turtleButton.addActionListener(this);
        camelButton.addActionListener(this);
        armadilButton.addActionListener(this);

        //Set up the picture label.
        picture = new JLabel(createImageIcon("\\images\\players\\"
                + turtleString
                + ".gif"));

        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image.
        //A real program would compute this.
        picture.setPreferredSize(new Dimension(200, 150));


        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.setFont(font);
        radioPanel.add(turtleButton);
        radioPanel.add(camelButton);
        radioPanel.add(armadilButton);
        add(radioPanel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
        chosenPlayer = e.getActionCommand();
        picture.setIcon(createImageIcon("\\images\\players\\"
                + e.getActionCommand()
                + ".gif"));
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PlayerRadioButtonPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("RadioButton");
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

    public String getChosenPlayer() {
        return chosenPlayer;
    }

    public void setChosenPlayer(String chosenPlayer) {
        this.chosenPlayer = chosenPlayer;
    }
}
