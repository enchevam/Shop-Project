package employee;

public class Employee {

    private final int employeeId;
    private String firstName;
    private String lastName;
    private int age;
    private int salary;

    public Employee(int employeeId, String firstName, String lastName, int age, int salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
