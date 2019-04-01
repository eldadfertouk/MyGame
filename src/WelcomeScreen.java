import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WelcomeScreen extends JFrame implements ActionListener
{
    JLabel answer = new JLabel("");
    JPanel pane = new JPanel(); // create pane object
    JButton start = new JButton("START");
    JButton quit = new JButton("QUIT");
    JButton options = new JButton("OPTIONS");
    ImageIcon reka = new ImageIcon(this.getClass().getResource("/images/intro.gif"));
    ImageIcon turtuleIcoon = new ImageIcon(this.getClass().getResource("images/icons/turtliconss.png"));
    JOptionPane optionPane;
    public WelcomeScreen()   // the constructor
    {
        super("INTRO");

        setBounds(50,0,700,680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = this.getContentPane(); // inherit main frame
        con.setLayout(new BorderLayout(5,5));
        //   con.add(new JLabel(reka),BorderLayout.CENTER);
        con.add(pane,BorderLayout.SOUTH);
        this.setIconImage(turtuleIcoon.getImage());
        con.setVisible(true);
        start.addActionListener(this);// register button listener
        quit.addActionListener(this);
        options.addActionListener(this);
        pane.add(new JLabel(reka),BorderLayout.CENTER);
        pane.add(quit,0);pane.add(options,1);
        pane.add(answer,2); pane.add(start,3);
        start.requestFocus();
        setVisible(true); // make frame visible
    }
    // here is the basic event handler
    public void paintComponent(Graphics message){
        super.paint(message);

    }
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        String mo = event.getActionCommand();
        System.out.println(mo);
        switch (event.getActionCommand()){
            case "START":
                new GameFrame();
              //  new Level();
             break;
            case "OPTIONS":
                new OP();
               // optionPane = new JOptionPane();
                //JOptionPane.showMessageDialog(null,"CHOOSE GAME OPTIONS:");
               // setVisible(true);
                break;
            case "QUIT":
                new GameMainFrame();
               // System.exit(1);
                break;
        }
    }
    public static void main(String[] args) {
        new WelcomeScreen();
    }
}