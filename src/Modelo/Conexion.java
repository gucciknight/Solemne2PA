package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {

    private final String user = "sql10376396";
    private final String password = "bMXXWE3ySg";
    private final String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10376396";
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión a la BBDD");
        }

        return con;
    }

}
