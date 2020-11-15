package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpAdminProfesor extends Conexion{
    private int rs;
        
    public boolean guardar (Profesor prof){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `profesor`(`id`, `nombre`, `apellidos`, `email`, `especialista` ) VALUES ('"+ prof.getIdProfesor()+"','" +"','"+ prof.getNombreProfesor()+"','"+ prof.getApellidoProfesor() +"','" + prof.getEmailProfesor() + "','" + prof.getEspecialistaProfesor()+ "')";      
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeUpdate(sql);
            System.out.println(prof.idProfesor);
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
    
    public boolean modificar(Profesor prof) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE producto SET idProfesor=?, nombreProfesor=?, apellidoProfesor=?, emailProfesor=?, especialistaProfesor=? WHERE codigo = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prof.getIdProfesor());
            ps.setString(2, prof.getNombreProfesor());
            ps.setString(3, prof.getApellidoProfesor());
            ps.setString(4, prof.getEmailProfesor());
            ps.setString(5, prof.getEspecialistaProfesor());
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
    
    public boolean eliminar(Profesor prof) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM producto WHERE nroSerie = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prof.getIdProfesor());
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