
import java.io.*;
import java.util.ArrayList;
import java.util.List;

        public class BankAccount {
            private String accountNumber;
            private String accountHolderName;
            private double balance;
            private List<String> transactions;

            // Constructor
            public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
                this.accountNumber = accountNumber;
                this.accountHolderName = accountHolderName;
                this.balance = initialBalance;
                this.transactions = new ArrayList<>();
                transactions.add("Account created with initial balance: " + initialBalance);
            }

            // Getters and Setters
            public String getAccountNumber() {
                return accountNumber;
            }

            public String getAccountHolderName() {
                return accountHolderName;
            }

            public double getBalance() {
                return balance;
            }

            // Deposit Method
            public void deposit(double amount) {
                if (amount > 0) {
                    balance += amount;
                    transactions.add("Deposited: " + amount);
                    System.out.println("Deposit successful!");
                } else {
                    System.out.println("Invalid deposit amount!");
                }
            }

            // Withdraw Method
            public void withdraw(double amount) throws Exception {
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    transactions.add("Withdrew: " + amount);
                    System.out.println("Withdrawal successful!");
                } else {
                    throw new Exception("Insufficient funds or invalid withdrawal amount!");
                }
            }

            // Transaction History
            public void printTransactionHistory() {
                System.out.println("\nTransaction History for Account: " + accountNumber);
                for (String transaction : transactions) {
                    System.out.println(transaction);
                }
            }

            // Save Transactions to File
            public void saveTransactionsToFile() throws IOException {
                FileWriter writer = new FileWriter(accountNumber + "_transactions.txt");
                for (String transaction : transactions) {
                    writer.write(transaction + "\n");
                }
                writer.close();
                System.out.println("Transaction history saved to file.");
            }



        // Load Transactions from File
        public void loadTransactionsFromFile() throws IOException {
            File file = new File(accountNumber + "_transactions.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    transactions.add(line);
                }
                reader.close();
                System.out.println("Transaction history loaded from file.");
            } else {
                System.out.println("No transaction history found for this account.");
            }
        }
}


