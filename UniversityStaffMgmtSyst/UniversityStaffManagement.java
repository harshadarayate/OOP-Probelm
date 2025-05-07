import java.util.*;

// Base class
abstract class Staff {
    protected String name;
    protected int id;
    protected double salary;

    public Staff(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void displayDetails();
    public abstract double calculateBonus();
    public abstract void promote();
}

// Derived class: Professor
class Professor extends Staff {
    private String department;

    public Professor(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Professor:");
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: ₹" + salary + ", Department: " + department);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // 20% bonus
    }

    @Override
    public void promote() {
        salary += 10000;
        System.out.println(name + " has been promoted to Senior Professor. New Salary: ₹" + salary);
    }
}

// Derived class: AdministrativeStaff
class AdministrativeStaff extends Staff {
    private String role;

    public AdministrativeStaff(String name, int id, double salary, String role) {
        super(name, id, salary);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Administrative Staff:");
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: ₹" + salary + ", Role: " + role);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10; // 10% bonus
    }

    @Override
    public void promote() {
        salary += 5000;
        System.out.println(name + " has been promoted to Senior " + role + ". New Salary: ₹" + salary);
    }
}

// Derived class: MaintenanceStaff
class MaintenanceStaff extends Staff {
    private String shift;

    public MaintenanceStaff(String name, int id, double salary, String shift) {
        super(name, id, salary);
        this.shift = shift;
    }

    @Override
    public void displayDetails() {
        System.out.println("Maintenance Staff:");
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: ₹" + salary + ", Shift: " + shift);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05; // 5% bonus
    }

    @Override
    public void promote() {
        salary += 3000;
        System.out.println(name + " has been promoted to Senior Maintenance Staff. New Salary: ₹" + salary);
    }
}

// Main class
public class UniversityStaffManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== University Staff Management ===");
            System.out.println("1. Add Professor");
            System.out.println("2. Add Administrative Staff");
            System.out.println("3. Add Maintenance Staff");
            System.out.println("4. Display All Staff");
            System.out.println("5. Calculate Bonus");
            System.out.println("6. Promote Staff");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 7) {
                System.out.println("Exiting program...");
                break;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter Name: ");
                    String pname = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int pid = scanner.nextInt();
                    System.out.print("Enter Salary: ");
                    double psalary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    staffList.add(new Professor(pname, pid, psalary, dept));
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String aname = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int aid = scanner.nextInt();
                    System.out.print("Enter Salary: ");
                    double asalary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    staffList.add(new AdministrativeStaff(aname, aid, asalary, role));
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String mname = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int mid = scanner.nextInt();
                    System.out.print("Enter Salary: ");
                    double msalary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Shift: ");
                    String shift = scanner.nextLine();
                    staffList.add(new MaintenanceStaff(mname, mid, msalary, shift));
                    break;

                case 4:
                    for (Staff staff : staffList) {
                        staff.displayDetails();
                        System.out.println("--------------------");
                    }
                    break;

                case 5:
                    for (Staff staff : staffList) {
                        System.out.println(staff.name + "'s Bonus: ₹" + staff.calculateBonus());
                    }
                    break;

                case 6:
                    for (Staff staff : staffList) {
                        staff.promote();
                    }
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

