import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public LoginForm() {
        setTitle("Login Form");
        setLayout(new GridLayout(3, 2, 10, 10));
        getContentPane().setBackground(Color.GREEN);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        add(userIdLabel);
        add(userIdField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(cancelButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                if (authenticate(userIdField.getText(), String.valueOf(passwordField.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose();
                    new EventDashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login details!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private boolean authenticate(String userId, String password) {
        return true;
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
