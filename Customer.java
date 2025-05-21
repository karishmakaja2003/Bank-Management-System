import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Customer extends User {
    private double balance;

    public Customer(String id, String name, double balance) {
        super(id, name);
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        String timestamp = getCurrentTimestamp();
        System.out.println("Deposited: " + amount + " at " + timestamp);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            String timestamp = getCurrentTimestamp();
            System.out.println("Withdrew: " + amount + " at " + timestamp);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void showMenu() {
        System.out.println("Customer Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Logout");
    }

    // Helper method to get the current timestamp in IST
    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
