
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Files {
    public static void saveTransactionsToFile(String accountNumber, List<String> transactions) {
        try (FileWriter writer = new FileWriter(accountNumber + "_transactions.txt")) {
            for (String transaction : transactions) {
                writer.write(transaction + "\n");
            }
            System.out.println("Transaction history saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving transaction history: " + e.getMessage());
        }
    }
}

