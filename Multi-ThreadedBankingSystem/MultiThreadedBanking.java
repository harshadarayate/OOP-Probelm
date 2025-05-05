import java.util.*;

// BankAccount class with synchronized methods
class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + 
            " deposited " + amount + " | New balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                " withdrew " + amount + " | New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                " failed to withdraw " + amount + " | Insufficient funds.");
        }
    }

    public synchronized void transfer(BankAccount toAccount, double amount) {
        if (balance >= amount) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println(Thread.currentThread().getName() + 
                " transferred " + amount + " to Account " + toAccount.getAccountNumber());
        } else {
            System.out.println(Thread.currentThread().getName() + 
                " failed to transfer " + amount + " | Insufficient funds.");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }
}

// UserTask representing a user performing random operations
class UserTask implements Runnable {
    private BankAccount[] accounts;
    private Random rand = new Random();

    public UserTask(BankAccount[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // 5 operations per user
            int operation = rand.nextInt(3);
            int accIndex = rand.nextInt(accounts.length);
            BankAccount account = accounts[accIndex];
            double amount = rand.nextInt(1000) + 1;

            switch (operation) {
                case 0: // Deposit
                    account.deposit(amount);
                    break;
                case 1: // Withdraw
                    account.withdraw(amount);
                    break;
                case 2: // Transfer
                    int toIndex = rand.nextInt(accounts.length);
                    while (toIndex == accIndex) {
                        toIndex = rand.nextInt(accounts.length);
                    }
                    account.transfer(accounts[toIndex], amount);
                    break;
            }

            try {
                Thread.sleep(100); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class
public class MultiThreadedBanking {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new BankAccount(1001, 5000),
            new BankAccount(1002, 7000),
            new BankAccount(1003, 10000)
        };

        Thread t1 = new Thread(new UserTask(accounts), "User-1");
        Thread t2 = new Thread(new UserTask(accounts), "User-2");
        Thread t3 = new Thread(new UserTask(accounts), "User-3");
 
        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final balances
        System.out.println("\nFinal account balances:");
        for (BankAccount account : accounts) {
            System.out.println("Account " + account.getAccountNumber() + ": " + account.getBalance());
        }
    }
}
