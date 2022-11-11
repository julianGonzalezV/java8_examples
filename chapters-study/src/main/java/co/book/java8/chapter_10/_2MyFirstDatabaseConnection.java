package co.book.java8.chapter_10;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

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

            Map<Integer, String> idToNameMap = new HashMap<>();
            ResultSet rs2 = stmt.executeQuery("select id, name from species");
            while(rs2.next()) {
                int id = rs2.getInt("id");
                String name = rs2.getString("name");
                idToNameMap.put(id, name);
            }
            System.out.println(idToNameMap); // {1=African Elephant, 2=Zebra}
        }
    }
}
