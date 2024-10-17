package bank;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        AccountManager accountManager = new AccountManager();
        TransactionManager transactionManager = new TransactionManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Create Account");
                System.out.println("4. Deposit");
                System.out.println("5. Withdraw");
                System.out.println("6. Check Balance");  // New option to check balance
                System.out.println("7. View Transaction History");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                switch (choice) {
                    case 1:
                        // Registration logic (same as before)
                        break;

                    case 2:
                        // Login logic (same as before)
                        break;

                    case 3:
                        // Account creation logic (same as before)
                        break;

                    case 4:
                        // Deposit logic (same as before)
                        break;

                    case 5:
                        // Withdraw logic (same as before)
                        break;

                    case 6:  // Check balance
                        System.out.print("Enter account number: ");
                        String checkBalanceAccountNumber = scanner.nextLine();
                        checkBalance(accountManager, checkBalanceAccountNumber);
                        break;

                    case 7:
                        // Transaction history logic (same as before)
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();  // Clear the invalid input
            } catch (IOException e) {
                System.out.println("Error processing your request: " + e.getMessage());
            }
        }
    }

    // Helper method to check balance
    private static void checkBalance(AccountManager accountManager, String accountNumber) throws IOException {
        List<Account> accounts = accountManager.loadAccounts();  // Load all accounts from file
        boolean accountFound = false;  // Flag to check if the account exists

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("The balance for account " + accountNumber + " is: " + account.getBalance());
                accountFound = true;
                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }

    // Helper method to handle deposit and withdrawal (as in previous steps)
    private static void processTransaction(AccountManager accountManager, TransactionManager transactionManager, String accountNumber, double amount, String type) throws IOException {
        List<Account> accounts = accountManager.loadAccounts();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (type.equals("deposit")) {
                    account.deposit(amount);
                    transactionManager.saveTransaction(new Transaction(accountNumber, "deposit", amount));
                    System.out.println("Deposit of " + amount + " completed successfully.");
                } else if (type.equals("withdraw")) {
                    account.withdraw(amount);
                    transactionManager.saveTransaction(new Transaction(accountNumber, "withdraw", amount));
                    System.out.println("Withdrawal of " + amount + " completed successfully.");
                }
                accountManager.saveAccounts(accounts);
                break;
            }
        }
    }
}
