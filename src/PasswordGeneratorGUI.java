import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

// render the GUI Components (frontend)
// this class will inherit from the JFrame class
public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

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

        // setting custom background panel
        setContentPane(new BackgroundPanel());
        passwordGenerator = new PasswordGenerator();

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

        passwordOutPane.setBounds(25,97,479,70);

        //create a pink border around the text area
        passwordOutPane.setBorder(BorderFactory.createLineBorder(Color.pink));

        add(passwordOutPane);

        //create password length label
        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dialog", Font.ITALIC,32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        // create password length
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.ITALIC,32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.pink));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);

        //create toggle buttons

        //upper case toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setBounds(25,302,225,56);
        uppercaseToggle.setFont(new Font("Dialog",Font.TRUETYPE_FONT,26));
        add(uppercaseToggle);

        //lower case toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setBounds(282,302,225,56);
        lowercaseToggle.setFont(new Font("Dialog",Font.TRUETYPE_FONT,26));
        add(lowercaseToggle);

        // numbers toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setBounds(25,373,225,56);
        numbersToggle.setFont(new Font("Dialog",Font.TRUETYPE_FONT,26));
        add(numbersToggle);

        // symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setBounds(282,373,225,56);
        symbolsToggle.setFont(new Font("Dialog",Font.TRUETYPE_FONT,26));
        add(symbolsToggle);

        // create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.ITALIC,32));
        generateButton.setBounds(155,477,222,41);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 // validation: genrate a password only when length > 0 and one of the toggled buttons is pressed
                if(passwordLengthInputArea.getText().length() <=0) return;
                boolean antToggleSelected = lowercaseToggle.isSelected()||uppercaseToggle.isSelected()||numbersToggle.isSelected()|| symbolsToggle.isSelected();

                //generate password
                //converts the text to an integer value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(antToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,uppercaseToggle.isSelected(),lowercaseToggle.isSelected(),numbersToggle.isSelected(),symbolsToggle.isSelected());

                    // display password back to the user
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}

class BackgroundPanel extends JPanel{
    private BufferedImage backgroundimage;
    public BackgroundPanel(){
        try {
            URL imageURL = new URL("https://wallpapercave.com/wp/wp6691926.jpg");
            backgroundimage = ImageIO.read(imageURL);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundimage != null) {
            g.drawImage(backgroundimage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

