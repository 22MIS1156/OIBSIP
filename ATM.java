import java.util.Scanner;

class User {
    private String userId;
    private String userPin;
    private double balance;
    private String transactionHistory;

    public User(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactionHistory = "";
    }

    public boolean authenticate(String userId, String userPin) {
        return this.userId.equals(userId) && this.userPin.equals(userPin);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory += "Deposited $" + amount + "\n";
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory += "Withdrew $" + amount + "\n";
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void transfer(double amount, User recipient) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory += "Transferred $" + amount + " to " + recipient.userId + "\n";
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);
    }

    public double getBalance() {
        return balance;
    }
}

public class ATM {
    private User user;

    public ATM(User user) {
        this.user = user;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();

        if (user.authenticate(userId, userPin)) {
            System.out.println("Login successful!");
            menu();
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient user ID: ");
                    String recipientUserId = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    User recipient = new User(recipientUserId, "1234", 0.0);
                    user.transfer(transferAmount, recipient);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        User user = new User("1234", "1234", 1000.0);
        ATM atm = new ATM(user);
        atm.start();
    }
}