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

public class OperacionesProfesor extends Conexion {
     public ResultSet rs;
     private Statement st;
     private Connection con;
     
    public Profesor LoginProfesor(String login, String contrasena){
       PreparedStatement ps = null;
       Connection con = getConexion(); 
       
       String sql = "SELECT * FROM `profesor` WHERE `login` = '"+ login +"' and `clave` = '"+ contrasena +"'";
       Profesor profesor = new Profesor();
       
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery(sql);
           
           while(rs.next()){
           int id = rs.getInt("id");
           String nombre = rs.getString("nombre");
           String apellidos = rs.getString("apellidos");
           String email = rs.getString("email");
           int especialista = rs.getInt("especialista");
           
           profesor.setNombreProfesor(nombre);
           profesor.setApellidoProfesor(apellidos);
           profesor.setEmailProfesor(email);
           profesor.setLoginProfesor(login);
           profesor.setClaveProfesor(contrasena);
           profesor.setIdProfesor(id);
           profesor.setEspecialistaProfesor(especialista);
           }
           System.out.println(profesor.getNombreProfesor()+" "+ profesor.getApellidoProfesor());
           System.out.println(profesor.getEmailProfesor());
       
       }catch(SQLException ex){
           System.out.println("Error is found :"+ex);
        }
    
      return profesor;
    }
    
    public void ListarAlumnos(Alumno al ) {/*
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "select `nombre`, `apellidos` from `alumno` where nivel_id =" + al.getIdNivelAlumno() +"";

        try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery(sql);
           Listado listado = new Listado();
           listado.setVisible(true);
           listado.fetch(rs);
            /*while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");
                System.out.println("nombre:" + nombre +" "+"apellido: "+ apellido +"");
                Listado listado = new Listado();
                listado.jFrame1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }*/
    }
}
