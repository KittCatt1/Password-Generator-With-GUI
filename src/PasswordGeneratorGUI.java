import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// render the GUI Components (frontend)
// this class will inherit from the JFrame class
public class PasswordGeneratorGUI extends JFrame {

    public PasswordGeneratorGUI(){
        // render frame and add a title
        super("Password Generator");

        // set the size of the GUI
        setSize(540, 570);

        // prevent GUI from being able to resized
        setResizable(false);

        // we will set the layout to be null to have control over the position and size of our components in our app
        setLayout(null);

        // terminate the program when the GUI is closed (ends the process)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // center the GUI to the screen
        setLocationRelativeTo(null);

       addGuiComponents();
    }
    private void addGuiComponents(){
        // creating the title text
        JLabel titleLabel = new JLabel("Caitlin's Password Generator <3");
        // Increasing font size
        titleLabel.setFont(new Font("Dialog", Font.ITALIC,32));

        //centre text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        //set x.y coordinates and width/height values
        titleLabel.setBounds(0,10,540,39);

        //add to GUI
        add(titleLabel);

        // Create result text area
        JTextArea passwordOutput = new JTextArea();

        // prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.ITALIC,32));

        // add scrolling in case output is too big
        JScrollPane passwordOutPane = new JScrollPane(passwordOutput);

        passwordOutput.setBounds(25,97,479,70);

        //create a pink border around the text area
        passwordOutPane.setBorder(BorderFactory.createLineBorder(Color.pink));

        add(passwordOutPane);

    }
}

