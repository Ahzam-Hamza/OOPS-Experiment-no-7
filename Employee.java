import java.util.*;

class InvalidEmpidException extends Exception {
    public InvalidEmpidException(String message) {
        super(message);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class EmployeeDetails {
    int empid;
    String name;
    int age;

    EmployeeDetails(int empid, String name, int age) {
        this.empid = empid;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("\nEmployee Details:");
        System.out.println("Emp ID : " + empid);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
    }
}

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Employee ID: ");
            int empid = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(sc.nextLine().trim());

            if (empid < 1000) {
                throw new InvalidEmpidException("Employee ID must be at least 4 digits!");
            }

            if (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                throw new InvalidNameException("Name must contain only alphabets!");
            }

            if (age < 18 || age > 50) {
                throw new InvalidAgeException("Age must be between 18 and 50!");
            }

            EmployeeDetails e = new EmployeeDetails(empid, name, age);
            e.display();

        } catch (InvalidEmpidException | InvalidNameException | InvalidAgeException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Error: Invalid numeric input. Please enter valid numbers.");
        } catch (Exception ex) {
            System.out.println("Something went wrong! Please check your input.");
        } finally {
            sc.close();
        }
    }
}
