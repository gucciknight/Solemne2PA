package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {

    private final String base = "orcl";
    private final String user = "sql10373447";
    private final String password = "2NW81VYfzW";
    private final String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10373447";
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
