import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI {
    public static void Display() {
        //Create Frame, and set FlowLayout.
        JFrame jf = new JFrame("Cards");
        jf.setSize(600, 400);
        jf.setLayout(new FlowLayout());

        //Create label, textField, button.
        JLabel label = new JLabel("Cards Name");
        JTextField textField = new JTextField(16);
        JButton button = new JButton("Display");

        //Add label, textField, button to Frame.
        jf.add(label);
        jf.add(textField);
        jf.add(button);


        //Create image label.
        JLabel image = new JLabel();
        //Set button listener for click event
        button.addActionListener(e -> {
            //Get textField string.
            String str = textField.getText();
            //Lowercase change.
            str = str.toUpperCase();
            //Get the rank and suit.
            Card card = new Card(str);
            //Initial image path.
            ImageIcon img = null;
            try {
                //Get the image path by Card class.
                String path = Card.imagePath(card.getRank(), card.getSuit());
                //Check if there have such file.
                File f = new File(path);
                if (!f.exists()) {
                    //Error window message and option.
                    Object[] close = {"Close"};
                    JOptionPane.showOptionDialog(jf, "No such file, check the input",
                            "Error", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, close, close);
                }
                //Set path.
                img = new ImageIcon(path);
            } catch (RuntimeException e1) {
                Object[] ok = {"OK"};
                JOptionPane.showOptionDialog(jf, "Empty Input", "Error", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, ok, ok);
            }
            //Get image.
            image.setIcon(img);
        });
        //Add image to Frame.
        jf.add(image);

        //Frame close and visible.
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        GUI.Display();
    }
}