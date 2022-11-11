package co.book.java8.chapter_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * debe instalar postgresql y crear la BD sino no le va a funcionar
 */
public class _4TestExternalToPostgresql {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ocp-book",
                "username",
                "password");
        System.out.println(conn);
    }
}
