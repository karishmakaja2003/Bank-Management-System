import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, Employee> employees = new HashMap<>();
    private Admin admin;

    public Bank() {
        admin = new Admin("admin", "Administrator");
     
        customers.put("cust1", new Customer("cust1", "John Doe", 1000));
        employees.put("emp1", new Employee("emp1", "Jane Smith"));
    }

    public void registerCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.next();
        if (customers.containsKey(id)) {
            System.out.println("Customer ID already exists. Please try again.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        Customer newCustomer = new Customer(id, name, balance);
        customers.put(id, newCustomer);
        System.out.println("Customer registered successfully.");
    }

    public void customerLogin(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String id = scanner.next();
        Customer customer = customers.get(id);

        if (customer != null) {
            boolean loggedIn = true;
            while (loggedIn) {
                customer.showMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        customer.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        customer.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Balance: " + customer.getBalance());
                        break;
                    case 4:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid Customer ID.");
        }
    }

    public void employeeLogin(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String id = scanner.next();
        Employee employee = employees.get(id);

        if (employee != null) {
            boolean loggedIn = true;
            while (loggedIn) {
                employee.showMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Customer details:");
                        customers.values().forEach(c -> {
                            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Balance: " + c.getBalance());
                        });
                        break;
                    case 2:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid Employee ID.");
        }
    }

    public void adminLogin(Scanner scanner) {
        System.out.print("Enter Admin ID: ");
        String id = scanner.next();

        if (admin.getId().equals(id)) {
            boolean loggedIn = true;
            while (loggedIn) {
                admin.showMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("All Customers:");
                        customers.values().forEach(c -> {
                            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Balance: " + c.getBalance());
                        });
                        break;
                    case 2:
                        System.out.println("All Employees:");
                        employees.values().forEach(e -> {
                            System.out.println("ID: " + e.getId() + ", Name: " + e.getName());
                        });
                        break;
                    case 3:
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid Admin ID.");
        }
    }
}
