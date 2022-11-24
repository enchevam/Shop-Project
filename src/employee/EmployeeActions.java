package employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeActions {

    public  static ArrayList<Employee> sortEmployeesByName(Statement statement) {
        ResultSet rs;
        ArrayList<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM employee ORDER BY first_name";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int employeeId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                int age = rs.getInt(4);
                int salary = rs.getInt(5);
                Employee item = new Employee(employeeId, firstName, lastName,age,salary);
                employeeList.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeList;
    }

    public  static ArrayList<Employee> sortEmployeesBySalary(Statement statement) {
        ResultSet rs;
        ArrayList<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM employee ORDER BY salary";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int employeeId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                int age = rs.getInt(4);
                int salary = rs.getInt(5);
                Employee item = new Employee(employeeId, firstName, lastName,age,salary);
                employeeList.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeList;
    }
}
