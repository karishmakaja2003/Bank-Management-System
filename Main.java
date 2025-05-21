import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("Welcome to the Bank Management System");
            System.out.println("1. Customer Login");
            System.out.println("2. Register New Customer");
            System.out.println("3. Employee Login");
            System.out.println("4. Admin Login");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bank.customerLogin(scanner);
                    break;
                case 2:
                    bank.registerCustomer(scanner);
                    break;
                case 3:
                    bank.employeeLogin(scanner);
                    break;
                case 4:
                    bank.adminLogin(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

