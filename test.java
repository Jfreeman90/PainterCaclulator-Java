import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class test {
    public static void main(String[] args){
        //create the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);

        //text field
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        frame.add(tf);

        //create button object
        JButton button = new JButton("Click here");
        button.setBounds(200,100,100,50);
        frame.add(button);

    }

}
