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
import Modelo.Alumno;

public class OperacionesAlumno extends Conexion {
     public ResultSet rs;
     private Statement st;
     private Connection con;
     
    public Alumno LoginAlumno(String login, String contrasena){
       PreparedStatement ps = null;
       Connection con = getConexion(); 
       
       String sql = "SELECT * FROM `alumno` WHERE `login` = '"+ login +"' and `clave` = '"+ contrasena +"'";
       Alumno alumno = new Alumno();
       
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery(sql);
           
           while(rs.next()){
           int id = rs.getInt("id");
           String nombre = rs.getString("nombre");
           String apellidos = rs.getString("apellidos");        
           int nivel_id = rs.getInt("nivel_id");
           
           alumno.setNombreAlumno(nombre);           
           alumno.setApellidoAlumno(apellidos);
           alumno.setClaveAlumno(contrasena);
           alumno.setIdAlumno(id);
           alumno.setIdNivelAlumno(nivel_id);
           alumno.setLoginAlumno(login);
           alumno.setNombreAlumno(nombre);
           }
           System.out.println(alumno.getNombreAlumno());
       
       }catch(SQLException ex){
           System.out.println("Error is found :"+ex);
        }
    
      return alumno;
    }
    
    public void ListarAlumnos(Alumno al ) {
        try{
           PreparedStatement ps = null;
           Connection con = getConexion();
           String sql = "SELECT nombre, apellidos FROM `alumno`";
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
