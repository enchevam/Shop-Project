/*import employee.Employee;
import employee.EmployeeActions;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static utility.Queries.QUERY_SORT_EMPLOYEES_BY_NAME;


public class EmployeeActionsTest {
    private static List<Employee> EMPLOYEE_LIST;

    @Before
    public void setup() {
        createEmployeeList();

    }

    @Test
    public void sortEmployeesTest() throws SQLException {
        Connection connection = DbConnection.connect();

        ResultSet rs = connection.createStatement().executeQuery;
        String query = QUERY_SORT_EMPLOYEES_BY_NAME;

        ArrayList<Employee> list = EmployeeActions.sortEmployees(rs, query);
        assertEquals(list,EMPLOYEE_LIST);


    }

    private void createEmployeeList() {
        EMPLOYEE_LIST = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Employee employee = new Employee(i, "Name " + i, "Last name " + i, 30, 1300);

            EMPLOYEE_LIST.add((employee));
        }
    }
}*/
