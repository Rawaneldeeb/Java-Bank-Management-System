public class SavingAccount {
    public SavingAccount(String accountNumber, String accountHolderName, double initialBalance) {
    }

    public static class SavingsAccount extends BankAccount {
   //enforcement minimum amount
        private static final double MINIMUM_BALANCE = 1000;

        public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
            super(accountNumber, accountHolderName, initialBalance);
        }
//override withdraw
        @Override
        public void withdraw(double amount) throws Exception {
            if (getBalance() - amount < MINIMUM_BALANCE) {
                throw new Exception("Withdrawal denied! Minimum balance of " + MINIMUM_BALANCE + " must be maintained.");
            }
            super.withdraw(amount);
        }
    }

}


