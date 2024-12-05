import Reportable.Reportable;

import java.util.ArrayList;

public class ReportableSavingsAccount extends BankAccount implements Reportable {


    public ReportableSavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }
    @Override
    public void generateAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());}


}