import employee.Employee;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static employee.EmployeeActions.sortEmployees;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EmployeeActionsTest {

    private Statement statement = null;

    @Before
    public void setUp() {
        try {
            DbConnection.connect();
            statement = DbConnection.con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void whenSortEmployeesReturnSortedEmployeeArrayList() {
        Employee employee = new Employee(3, "Mariya", "Peneva", 48, 1260);
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(sortEmployees(any(), anyString())).thenReturn(employeeList);
            ArrayList<Employee> finalList = sortEmployees(any(), anyString());
            assertEquals(employeeList, finalList);

        } catch (SQLException e) {
            // throw e;
        }

    }
}
