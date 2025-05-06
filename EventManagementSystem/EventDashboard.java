import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EventDashboard extends JFrame {
    private JComboBox<String> eventList;
    private JButton registerButton;
    private JTextArea eventInfoArea;

    private static Map<String, java.util.List<Participant>> eventParticipants = new HashMap<>();

    public EventDashboard() {
        setTitle("Event Dashboard");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.GREEN);

        String[] events = {"Coding Contest", "Robotics", "Gaming", "Debate", "Hackathon"};
        eventList = new JComboBox<>(events);

        eventInfoArea = new JTextArea(10, 30);
        eventInfoArea.setEditable(false);

        registerButton = new JButton("Register for Event");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Event:"));
        topPanel.add(eventList);
        topPanel.setBackground(Color.GREEN);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(eventInfoArea), BorderLayout.CENTER);
        add(registerButton, BorderLayout.SOUTH);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedEvent = (String) eventList.getSelectedItem();

                JTextField nameField = new JTextField(20);
                JTextField regNoField = new JTextField(20);
                JTextField emailField = new JTextField(20);
                JTextField mobileField = new JTextField(20);

                JPanel registrationPanel = new JPanel(new GridLayout(4, 2));
                registrationPanel.add(new JLabel("Name:"));
                registrationPanel.add(nameField);
                registrationPanel.add(new JLabel("Registration No:"));
                registrationPanel.add(regNoField);
                registrationPanel.add(new JLabel("Email:"));
                registrationPanel.add(emailField);
                registrationPanel.add(new JLabel("Mobile No:"));
                registrationPanel.add(mobileField);

                int option = JOptionPane.showConfirmDialog(null, registrationPanel, "Enter your details", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String name = nameField.getText().trim();
                    String regNo = regNoField.getText().trim();
                    String email = emailField.getText().trim();
                    String mobile = mobileField.getText().trim();

                    if (!name.isEmpty() && !regNo.isEmpty() && !email.isEmpty() && !mobile.isEmpty()) {
                       
                        Participant participant = new Participant(name, regNo, email, mobile);

                        eventParticipants.computeIfAbsent(selectedEvent, k -> new java.util.ArrayList<>()).add(participant);
                        updateEventInfo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill in all the details.");
                    }
                }
            }
        });

        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        updateEventInfo();
    }

    private void updateEventInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, java.util.List<Participant>> entry : eventParticipants.entrySet()) {
            sb.append("Event: ").append(entry.getKey()).append("\nParticipants:\n");
            for (Participant participant : entry.getValue()) {
                sb.append("- ").append(participant.getName()).append(", Reg No: ").append(participant.getRegNo())
                  .append(", Email: ").append(participant.getEmail()).append(", Mobile: ").append(participant.getMobile()).append("\n");
            }
            sb.append("\n");
        }
        eventInfoArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new EventDashboard().setVisible(true);
    }
}
