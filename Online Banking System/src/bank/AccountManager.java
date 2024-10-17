package bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static final String ACCOUNT_FILE_PATH = "accounts.txt";  // File to store accounts

    // Create a new account
    public void createAccount(Account account) throws IOException {
        List<Account> accounts = loadAccounts();  // Load existing accounts from file
        accounts.add(account);  // Add the new account to the list
        saveAccounts(accounts);  // Save the updated list of accounts
        System.out.println("Account created successfully.");
    }

    // Load accounts from the text file
    public List<Account> loadAccounts() throws IOException {
        List<Account> accounts = new ArrayList<>();
        File file = new File(ACCOUNT_FILE_PATH);

        if (file.exists()) {  // Check if the file exists
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  // Split the line into account number and balance
                String accountNumber = parts[0];
                double balance = Double.parseDouble(parts[1]);
                accounts.add(new Account(accountNumber, balance));  // Add account to the list
            }

            reader.close();  // Close the file reader
        }

        return accounts;  // Return the list of accounts
    }

    // Save accounts to the text file
    public void saveAccounts(List<Account> accounts) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNT_FILE_PATH));

        for (Account account : accounts) {
            writer.write(account.getAccountNumber() + "," + account.getBalance());  // Write account data to the file
            writer.newLine();  // Move to the next line
        }

        writer.close();  // Close the file writer
    }
}
