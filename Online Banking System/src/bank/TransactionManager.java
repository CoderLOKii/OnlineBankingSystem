package bank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static final String TRANSACTION_FILE_PATH = "transactions.txt";  // File to store transactions

    // Save a new transaction to the file
    public void saveTransaction(Transaction transaction) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_FILE_PATH, true));  // Append mode
        writer.write(transaction.toString());
        writer.newLine();
        writer.close();
    }

    // Load all transactions from the file
    public List<String> loadTransactions() throws IOException {
        List<String> transactions = new ArrayList<>();
        File file = new File(TRANSACTION_FILE_PATH);

        if (file.exists()) {  // Check if the file exists
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                transactions.add(line);  // Add each line (transaction) to the list
            }

            reader.close();  // Close the file reader
        }

        return transactions;  // Return the list of transactions
    }
}
