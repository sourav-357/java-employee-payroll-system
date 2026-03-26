import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {

    private int id;
    private String name;

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();
    @Override
    public String toString() {
        return " [ID: " + id + ", Name: " + name + ", Salary: " + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayRollSystem {

    private ArrayList<Employee> employeeList;

    public PayRollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int id) {
        Employee toRemove = null;

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                toRemove = emp;
                break;
            }
        }

        if (toRemove != null) {
            employeeList.remove(toRemove);
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        int i = 0;
        for (Employee emp : employeeList) {
            System.out.println("Employee " + (++i) + emp.toString()); 
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PayRollSystem company = new PayRollSystem();

        while (true) {
            System.out.println("\n");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();

                    System.out.print("Enter Monthly Salary: ");
                    double salary = sc.nextDouble();

                    company.addEmployee(new FullTimeEmployee(id1, name1, salary));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name2 = sc.nextLine();

                    System.out.print("Enter Hours Worked: ");
                    int hours = sc.nextInt();

                    System.out.print("Enter Hourly Rate: ");
                    double rate = sc.nextDouble();

                    company.addEmployee(new PartTimeEmployee(id2, name2, hours, rate));
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    company.removeEmployee(removeId);
                    break;

                case 4:
                    company.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}