

public class Participant {
    private String name;
    private String regNo;
    private String email;
    private String mobile;
    private String userId;
    private String password;

    public Participant(String name, String regNo, String email, String mobile, String userId, String password) {
        this.name = name;
        this.regNo = regNo;
        this.email = email;
        this.mobile = mobile;
        this.userId = userId;
        this.password = password;
    }

    public Participant(String name, String regNo, String userId, String password) {
        this.name = name;
        this.regNo = regNo;
        this.email = email; 
        this.mobile =mobile ; 
        this.userId = userId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
