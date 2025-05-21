public class Employee extends User {
    public Employee(String id, String name) {
        super(id, name);
    }

    @Override
    public void showMenu() {
        System.out.println("Employee Menu:");
        System.out.println("1. View Customer Details");
        System.out.println("2. Logout");
    }
}
