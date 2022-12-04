import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static auth.Authentication.authenticate;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AuthenticationTest {
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
    public void givenValidCredentialsWhenAuthenticateThenShowMenu() {
        Scanner sc = new Scanner("2");
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            boolean result = authenticate(statement, sc, 1, "Pesho");
            assertTrue(result);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void givenInvalidCredentialsWhenAuthenticateThenReturnErrorMessage() {
        Scanner sc = new Scanner("2");
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(authenticate(statement, sc, 1, "Pesho")).thenReturn(false);
            boolean result = authenticate(statement, sc, 1, "Pesho");
            assertFalse(result);

        } catch (SQLException e) {
            // throw e;
        }
    }

}
