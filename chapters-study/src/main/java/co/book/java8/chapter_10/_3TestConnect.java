package co.book.java8.chapter_10;

import java.sql.*;

/**
 * Cuando no se ha configurado bien el driver entonces sale:
 * java.sql.SQLException: No suitable driver found for jdbc:derby:zoo
 *
 * Para evitar lo anterior entonces:
 * Coloque la dependencia en el buidl.gradle
 * compile group: 'org.apache.derby', name: 'derby', version: '10.14.2.0'
 * O instalelo en el classpath de la instalación java que usa este proyecto
 *
 * Cree la base de datos
 *
 */

public class _3TestConnect {

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        System.out.println(conn);
    }
}
