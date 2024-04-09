package DB;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest {

    @Test
    public void testDatabaseQuery() {
        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "12345678";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")) {

            assertTrue(resultSet.next(), "At least one row should be present by the query");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
