package JDBC;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/foo_db";
    private final String USER = "root";
    private final String PASS = "fee";

    private String insertRecordSql = "INSERT INTO student VALUES (100, 'foo', 'fee', 18)";
    private String deleteRecordSql = "DELETE FROM student WHERE id = 101";
    private String modifyRecordSql = "UPDATE student SET age = 22 WHERE id in (100, 101)";
    private String queryRecordSql = "SELECT id, first, last, age FROM student";
    private String preparedStatementSql = "INSERT INTO Employees(id,first,last,age) VALUES(?, ?, ?, ?)";

    @Before
    public void setUp() {
        this.registerJdbcDriver();
    }

    @Test
    public void testInsertRecord() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(insertRecordSql);
        } catch (Exception e) {
            throw new RuntimeException("Insert Record failed");
        }
    }

    @Test
    public void testDeleteRecord() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(deleteRecordSql);
        } catch (Exception e) {
            throw new RuntimeException("Delete Record failed");
        }
    }

    @Test
    public void testModifyRecord() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(modifyRecordSql);
        } catch (Exception e) {
            throw new RuntimeException("Modify Record failed");
        }
    }

    @Test
    public void testQueryRecord() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            this.printRows(stmt);
        } catch (Exception e) {
            throw new RuntimeException("Query Record failed");
        }
    }

    @Test
    public void testBatchingWithPrepareStatement() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(preparedStatementSql)) {
            conn.setAutoCommit(false);
            this.printRows(stmt);

            stmt.setInt(1, 400);
            stmt.setString(2, "Python");
            stmt.setString(3, "Zhang");
            stmt.setInt(4, 33);
            stmt.addBatch();

            stmt.setInt(1, 401);
            stmt.setString(2, "C++");
            stmt.setString(3, "Huang");
            stmt.setInt(4, 31);
            stmt.addBatch();

            stmt.executeBatch();
            conn.commit();
            this.printRows(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void registerJdbcDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Register Driver failed");
        }
    }

    private void printRows(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery(queryRecordSql);
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
        }
        System.out.println();
        rs.close();
    }

}
