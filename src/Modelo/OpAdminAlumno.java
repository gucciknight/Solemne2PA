package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpAdminAlumno extends Conexion{
    private int rs;
        
    public boolean guardar (Alumno alu){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `alumno`(`id`, `nivel_id`, `nombre`, `apellidos`) VALUES ('"+ alu.getIdAlumno()+"','"+ alu.getIdNivelAlumno() +"','"+ alu.getNombreAlumno()+"','"+ alu.getApellidoAlumno() +"')";      
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
    
    public boolean modificar(Alumno alu) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE producto SET idAlumno=?, idNivelAlumno=?, nombreAlumno=?, apellidoAlumno=? WHERE codigo = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alu.getIdAlumno());
            ps.setInt(2, alu.getIdNivelAlumno());
            ps.setString(3, alu.getNombreAlumno());
            ps.setString(4, alu.getApellidoAlumno());
            ps.execute();
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
    
    public boolean eliminar(Alumno alu) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM producto WHERE nroSerie = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alu.getIdAlumno());
            ps.execute();
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
