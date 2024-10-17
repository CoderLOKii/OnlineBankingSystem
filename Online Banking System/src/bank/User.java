package bank;

public class User {
    private String username;
    private String password;

    // Constructor to initialize a new user
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters to access the username and password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
