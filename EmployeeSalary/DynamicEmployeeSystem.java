import java.util.*;

// Base class
class Employee {
    protected String name;
    protected int id;
    protected double basicSalary;

    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    public void displayDetails() {
        System.out.println("\nName: " + name);
        System.out.println("ID: " + id);
        System.out.println("Basic Salary: " + basicSalary);
    }

    public double calculateSalary() {
        return basicSalary;
    }
}

// Manager subclass
class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: " + bonus);
    }
}

// Developer subclass
class Developer extends Employee {
    private double projectAllowance;

    public Developer(String name, int id, double basicSalary, double projectAllowance) {
        super(name, id, basicSalary);
        this.projectAllowance = projectAllowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + projectAllowance;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Project Allowance: " + projectAllowance);
    }
}

// Main class
public class DynamicEmployeeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n----- Employee Management System -----");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Display All Employee Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Manager Name: ");
                    String mName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int mId = scanner.nextInt();
                    System.out.print("Enter Basic Salary: ");
                    double mSalary = scanner.nextDouble();
                    System.out.print("Enter Bonus: ");
                    double bonus = scanner.nextDouble();
                    employees.add(new Manager(mName, mId, mSalary, bonus));
                    break;

                case 2:
                    System.out.print("Enter Developer Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int dId = scanner.nextInt();
                    System.out.print("Enter Basic Salary: ");
                    double dSalary = scanner.nextDouble();
                    System.out.print("Enter Project Allowance: ");
                    double allowance = scanner.nextDouble();
                    employees.add(new Developer(dName, dId, dSalary, allowance));
                    break;

                case 3:
                    System.out.println("\n=== All Employee Details ===");
                    for (Employee emp : employees) {
                        emp.displayDetails();
                        System.out.println("Total Salary: " + emp.calculateSalary());
                        System.out.println("------------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);
    }
}
