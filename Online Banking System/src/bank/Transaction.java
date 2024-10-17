package bank;

import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private String type;  // "deposit" or "withdraw"
    private double amount;
    private LocalDateTime dateTime;

    // Constructor to initialize a new transaction
    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();  // Capture the current date and time
    }

    // Getters for the transaction details
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return dateTime + ": " + type + " of " + amount + " for account " + accountNumber;
    }
}
