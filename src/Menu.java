
import Reportable.Reportable;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Save Transactions to File");
            System.out.println("7. Load Transactions from File");
            System.out.println("8. Generate Account Summary");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Create Savings Account
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    account = new BankAccount (accountNumber, accountHolderName, initialBalance);
                    System.out.println("Savings account created successfully.");
                    break;

                case 2: // Deposit
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;

                case 3: // Withdraw
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            account.withdraw(withdrawAmount);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;

                case 4: // Check Balance
                    if (account != null) {
                        System.out.println("Current Balance: " + account.getBalance());
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;

                case 5: // View Transaction History
                    if (account != null) {
                        account.printTransactionHistory();
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;

                case 6: // Save Transactions to File
                    if (account != null) {
                        try {
                            account.saveTransactionsToFile();
                        } catch (IOException e) {
                            System.out.println("Error saving transactions: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;

                case 7: // Load Transactions from File
                    if (account != null) {
                        try {
                            account.loadTransactionsFromFile();
                        } catch (IOException e) {
                            System.out.println("Error loading transactions: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No account found! Please create an account first.");
                    }
                    break;

                case 8: // Generate Account Summary
                    if (account instanceof Reportable) {
                        ((Reportable) account).generateAccountSummary();
                    } else {
                        System.out.println("Summary generation is unavailable for this account type.");
                    }
                    break;

                case 9: // Exit
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
