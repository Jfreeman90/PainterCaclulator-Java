import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame {
    //create the frame
    JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit the program when 'x' is clicked default is HIDE_ON_CLOSE
    ImageIcon image= new ImageIcon("images.jpg");   //change the icon on window bar to an uploaded image
        frame.setIconImage(image.getImage());
        frame.setTitle("Painting walls!");
        frame.setSize(750,900);     //define the size of the window
        frame.setVisible(true);     //makes frame visible
        frame.getContentPane().setBackground(new Color(0xFFFFE0));      //set background
        frame.setResizable(true);       //prevent frame from being resized by the user by setting to false
        frame.setLayout(null);       //this prevent automatic layout of items within the frame.


    //create a border around the label to see boundries
    //Border border = BorderFactory.createLineBorder(Color.blue, 2);

    //create a label
    JLabel label = new JLabel("Sit back while we work out how many tins of paint youll need!");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);     //set text left, center, right of image.
        label.setVerticalTextPosition(JLabel.TOP);      //set text top,center, bottom of image icon
        label.setVerticalAlignment(JLabel.CENTER);       //set vertical position of the text within the label
        label.setHorizontalAlignment(JLabel.CENTER);     //set horizontal position of the text within the label
        label.setForeground(Color.black);      //set font colour
    //label.setBackground(new Color(0xFFFFE0));        //set label colour
        label.setFont(new Font("MV Boli", Font.PLAIN, 15));        //set label font, style, size
    // label.setBorder(border);      //add border to label
        label.setBounds(0,0,300,300);      //x,y, height, width

    //create a panel - same as a tkinter frame which can hold things inside it.
    JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setBounds(400,400,100,100);      //x,y, height, width
    JLabel label2 = new JLabel();
        label2.setText("Add to panel");
        panel.add(label2);

        frame.add(panel);
        frame.add(label);       //add the label to the frame
    //frame.pack();       //automatically fits frame run last

}
