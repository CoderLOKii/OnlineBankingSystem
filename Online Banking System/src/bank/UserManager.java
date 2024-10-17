package bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String FILE_PATH = "users.txt";  // Path to the file where user data is stored

    // Method to register a new user
    public void registerUser(User user) throws IOException {
        List<User> users = loadUsers();  // Load existing users from file

        // Check if the username already exists
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                System.out.println("Username already taken.");
                return;
            }
        }

        users.add(user);  // Add the new user to the list
        saveUsers(users);  // Save the updated list of users back to the file
        System.out.println("User registered successfully.");
    }

    // Method to log in an existing user
    public boolean loginUser(String username, String password) throws IOException {
        List<User> users = loadUsers();  // Load users from the file

        // Check if the username and password match
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }

        System.out.println("Invalid username or password.");
        return false;
    }

    // Load users from the text file
    private List<User> loadUsers() throws IOException {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (file.exists()) {  // Check if the file exists
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  // Split the line into username and password
                String username = parts[0];
                String password = parts[1];
                users.add(new User(username, password));  // Add user to the list
            }

            reader.close();  // Close the file reader
        }

        return users;  // Return the list of users
    }

    // Save users to the text file
    private void saveUsers(List<User> users) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

        for (User user : users) {
            writer.write(user.getUsername() + "," + user.getPassword());  // Write username and password to the file
            writer.newLine();  // Move to the next line
        }

        writer.close();  // Close the file writer
    }
}
