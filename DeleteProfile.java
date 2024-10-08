import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteProfile extends JFrame {
    private JFrame frame;

    public DeleteProfile(CustomerProfDB database) {

        frame = new JFrame();

        JLabel title = new JLabel("Delete Profile");
        title.setBounds(40, 0, 200, 60);

        JLabel adminID = new JLabel("Admin ID:");
        adminID.setBounds(10, 50, 100, 30);

        JTextField aID = new JTextField();
        aID.setBounds(90, 50, 200, 30);
        
        JLabel lastName = new JLabel("Last Name:");
        lastName.setBounds(10, 75, 100, 30);
        
        JTextField lName = new JTextField();
        lName.setBounds(90, 75, 200, 30);

        JButton delete = new JButton("Delete");
        delete.setBounds(50, 100, 100, 50);

        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                boolean deleted = database.deleteProfile(aID.getText(), lName.getText());
                if(deleted) JOptionPane.showMessageDialog(null, "Profile Deleted!");
                else JOptionPane.showMessageDialog(null, "The customer profile could not be deleted. This is because it was either not found or the adminID was invalid.");
                frame.setVisible(false);
            }
        });

        frame.add(title);
        frame.add(adminID);
        frame.add(aID);
        frame.add(lastName);
        frame.add(lName);
        frame.add(delete);

        frame.setSize(300, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
