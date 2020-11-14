package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arluna
 */
public class OpAdminAlumno extends Conexion{
    private int rs;
        
    public boolean guardar (Alumno alu){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `alumno`(`id`, `nivel_id`, `nombre`, `apellidos`) VALUES ('"+ alu.getIdAlumno()+"','"+ alu.getIdnivelAlumno() +"','"+ alu.getNombreAlumno()+"','"+ alu.getApellidosAlumno() +"')";      
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeUpdate(sql);
            System.out.println(alu.idAlumno);
            System.out.println("Data from online Database :");
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }          
        }
    }
}
    
    /*
    public boolean modificar(Equipos eq) {

    }
    
    public boolean eliminar(Equipos eq) {

    }
    
    public boolean buscar(Equipos eq) {

    }*/
