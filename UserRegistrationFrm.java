import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UserRegistrationFrm extends JFrame implements ActionListener {
    JLabel lname, lpwd, lcpwd;
    JTextField tf;
    JPasswordField pwd, cpwd;
    JButton b1, b2;

    public UserRegistrationFrm() {
        lname = new JLabel("User name");
        lpwd = new JLabel("Password");
        lcpwd = new JLabel("Re-Password");

        tf = new JTextField(20);
        pwd = new JPasswordField(20);
        cpwd = new JPasswordField(20);
        b1 = new JButton("Register");
        b2 = new JButton("Cancel");

        setLayout(null);
        lname.setBounds(10, 10, 120, 20);
        tf.setBounds(130, 10, 120, 20);
        lpwd.setBounds(10, 40, 120, 20);
        pwd.setBounds(130, 40, 120, 20);
        lcpwd.setBounds(10, 70, 120, 20);
        cpwd.setBounds(130, 70, 120, 20);
        b1.setBounds(10, 100, 120, 20);
        b2.setBounds(130, 100, 120, 20);

        add(lname);
        add(tf);
        add(lpwd);
        add(pwd);
        add(lcpwd);
        add(cpwd);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                if (String.valueOf(pwd.getPassword()).equals(String.valueOf(cpwd.getPassword()))) {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "mange");
                    Statement st = con.createStatement();

                    String qry = "INSERT INTO login VALUES('" + tf.getText() + "','" + String.valueOf(pwd.getPassword()) + "')";
                    int x = st.executeUpdate(qry);
                    if (x != 0) {
                        JOptionPane.showMessageDialog(this, "Register Successfully", "Result", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error", "Result", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords do not match", "Result", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // For debugging
            }
        }
    }

    public static void main(String args[]) {
        UserRegistrationFrm ob = new UserRegistrationFrm();
        ob.setSize(300, 180);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setVisible(true);
    }
}
