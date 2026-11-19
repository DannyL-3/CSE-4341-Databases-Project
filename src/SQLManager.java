import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SQLManager {

    private static final String DATABASE_NAME = "database project.db";
    public static Connection conn = null;
    private static PreparedStatement ps;

    public static Connection initializeDB() {
        String url = "jdbc:sqlite:" + DATABASE_NAME;
        try {
            conn = DriverManager.getConnection(url);
            if (conn == null) {
                System.out.println("No connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to connect to the database.");
        }
        return conn;
    }

    public static void sqlQuery(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value);
                if (i < columnCount)
                    System.out.print(",  ");
            }
            System.out.print("\n");

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                    if (i < columnCount)
                        System.out.print(",  ");
                }
                System.out.print("\n");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sqlQuery(PreparedStatement sql) {
        try {
            ResultSet rs = sql.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String value = rsmd.getColumnName(i);
                System.out.print(value);
                if (i < columnCount)
                    System.out.print(",  ");
            }
            System.out.print("\n");

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                    if (i < columnCount)
                        System.out.print(",  ");
                }
                System.out.print("\n");
            }

            rs.close();
            sql.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ps_Search(String sql, Object... values) {
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }

            sqlQuery(ps);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ps_Update(String sql, Object... values) {
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Operation successful!");
            } else {
                System.out.println("No rows were changed.");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeDB() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
