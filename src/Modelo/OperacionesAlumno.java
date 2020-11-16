package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OperacionesAlumno extends Conexion {
    private int rs;
    
    public void ListarAlumnos(Alumno eq ) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try{
           // String sql = "select `nombre`, `apellido` from `alumno` where id = "+ eq.nivelAlumno +"";
           // rs = ps.executeQuery(sql);
            System.out.println("Data from online Database :");
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("marca");


                System.out.println("nombre :"+ nombre +" "+"apellido :"+ apellido +"");
            }
            
        }catch(Exception ex){
            System.out.println("Error is found :"+ex);
        }
    }
}
