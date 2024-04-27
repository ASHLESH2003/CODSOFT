import java.util.Scanner;

// BankAccount class to represent user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        }
    }
}

// ATM class representing the ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance set to 1000
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}
