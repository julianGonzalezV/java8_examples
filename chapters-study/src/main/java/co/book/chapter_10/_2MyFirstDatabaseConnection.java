package co.book.chapter_10;

import java.sql.*;

public class _2MyFirstDatabaseConnection {
    /**
     * oJO en producción use dataSource DriverManager es solo para ejemplo
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select name from animal")) {
            while (rs.next())
                System.out.println(rs.getString(1));
        }
    }
}
