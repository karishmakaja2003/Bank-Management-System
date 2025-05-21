public class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. View All Customers");
        System.out.println("2. View All Employees");
        System.out.println("3. Logout");
    }
}
