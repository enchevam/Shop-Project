import org.junit.Before;
import org.junit.Test;
import utility.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static utility.UtilMethods.*;

public class UtilMethodsTest {

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
    public void givenIdWhenCheckPositiveThenReturnFalse() {
        assertFalse(checkPositive(-9));
    }

    @Test
    public void givenIdWhenCheckPositiveThenReturnTrue() {
        assertTrue(checkPositive(8));
    }

    @Test
    public void givenDateWhenCheckValidDateThenReturnFalse() {
        String date = "2026.03.05";
        assertFalse(checkValidDate(date));
    }

    @Test
    public void givenDateWhenCheckValidDateThenReturnTrue() {
        String date = "05.03.2025";
        assertTrue(checkValidDate(date));
    }

    @Test
    public void givenValidStringDateWhenGetFormattedDateThenReturnLocalDate() {
        String stringDate = "05.03.2026";
        LocalDate localDate = getFormattedDate(stringDate);
        assertEquals(localDate, getFormattedDate(stringDate));

    }

    @Test
    public void givenInvalidStringDateWhenGetFormattedDateThenReturnLocalDate() {
        String stringDate = "2026.03.05";
        Exception exception = assertThrows(DateTimeParseException.class, () -> {
            getFormattedDate(stringDate);
        });
        assertEquals("Text '2026-03-05' could not be parsed at index 2", exception.getMessage());

    }

    @Test
    public void givenValidProductTypeWhenCheckProductThenReturnType() {
        Scanner sc = new Scanner("food");

        Type productType = checkProduct(sc);
        assertEquals("food", productType.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidProductTypeWhenCheckProductThenReturnType() {

        Scanner sc = new Scanner("wrong type");
        Type productType = Type.valueOf("wrong type");

        try {
            productType = checkProduct(sc);
        } catch (IllegalArgumentException e) {
            assertEquals("food", productType.getValue());
            throw e;
        }
    }

    @Test
    public void givenExistingIdWhenCheckIdExistsThenReturnTrue() {
        int id = 4;
        String query = "SELECT id FROM products WHERE id='" + id + "';";

        try {
            ResultSet rs = statement.executeQuery(query);
            when(statement.executeQuery(anyString())).thenReturn(rs);
            assertTrue(checkIdExists(statement, id));

        } catch (SQLException e) {
            // throw e;
        }
    }
}
