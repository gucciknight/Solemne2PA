package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Vista.Listado;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class OperacionesAlumno extends Conexion {
     public ResultSet rs;
     private Statement st;
     private Connection con;
    
    public void ListarAlumnos(Alumno al ) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "select `nombre`, `apellidos` from `alumno` where nivel_id =" + al.getIdNivelAlumno() +"";

        try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery(sql);
           Listado listado = new Listado();
           listado.setVisible(true);
           listado.fetch(rs);
            
        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }
    }
}
