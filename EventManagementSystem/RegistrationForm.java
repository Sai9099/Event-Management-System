import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    private JTextField nameField, regNoField, userIdField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setLayout(new GridLayout(6, 2, 10, 10));
        getContentPane().setBackground(Color.GREEN);

        
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel regNoLabel = new JLabel("Registration No.:");
        regNoField = new JTextField();

        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();

        registerButton = new JButton("Register");

        add(nameLabel);
        add(nameField);
        add(regNoLabel);
        add(regNoField);
        add(userIdLabel);
        add(userIdField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(new JLabel());
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPasswordField.getPassword()))) {
                 
                    Participant participant = new Participant(nameField.getText(), regNoField.getText(), userIdField.getText(), String.valueOf(passwordField.getPassword()));

                    System.out.println("Participant Registered: " + participant);

                    dispose();
                    new LoginForm().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new RegistrationForm().setVisible(true);
    }
}
