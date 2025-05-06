import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static Connection con;
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE"; 
    private static final String DB_USER = "system";  
    private static final String DB_PASSWORD = "mange"; 

    public static Connection connect() {
        try {
            if (con == null || con.isClosed()) {
               
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("Driver Registered....");

                con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connection Created......");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void insertParticipant(Participant participant) {
        try {
            String sql = "INSERT INTO participants (name, regNo, userId, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, participant.getName());
            ps.setString(2, participant.getRegNo());
            ps.setString(3, participant.getUserId());
            ps.setString(4, participant.getPassword());
            ps.executeUpdate();
            System.out.println("Participant registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        try {
            String sql = "SELECT * FROM participants";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String regNo = rs.getString("regNo");
                String userId = rs.getString("userId");
                String password = rs.getString("password");
                participants.add(new Participant(name, regNo, userId, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }

    public static boolean authenticate(String userId, String password) {
        try {
            String sql = "SELECT * FROM participants WHERE userId = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    }

    public static void main(String[] args) {
        
        connect();

        Participant participant = new Participant("John Doe", "12345", "john_doe", "password123");

        insertParticipant(participant);

        List<Participant> participants = getAllParticipants();
        for (Participant p : participants) {
            System.out.println(p);
        }

        boolean isAuthenticated = authenticate("john_doe", "password123");
        System.out.println("Authentication result: " + isAuthenticated);

        closeConnection();
    }
}
