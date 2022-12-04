package employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeActions {

    public static ArrayList<Employee> sortEmployees(Statement statement, String query){
        ArrayList<Employee> employeeList = new ArrayList<>();
        getEmployeesFromDb(statement, employeeList, query);
        return employeeList;
    }

    private static void getEmployeesFromDb(Statement statement, ArrayList<Employee> employeeList, String query) {
        ResultSet rs;
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
    }
}
