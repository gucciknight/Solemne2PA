package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesAdmin extends Conexion {
    public ResultSet rs;
    private Statement st;
    private int rsi;
    private Connection con;
    
    public Administrador LoginAdmin(String login, String contrasena){
       PreparedStatement ps = null;
       Connection con = getConexion(); 
       
       String sql = "SELECT * FROM `administrador` WHERE `login` = '"+ login +"' and `clave` = '"+ contrasena +"'";
       Administrador admin = new Administrador();
       
       try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery(sql);
           
           while(rs.next()){
           int id = rs.getInt("id");
           String email = rs.getString("email");
           
           admin.setIdAdmin(id);
           admin.setEmailAdmin(email);
           admin.setLoginAdmin(login);
           admin.setClaveAdmin(contrasena);
           }
           System.out.println(admin.getEmailAdmin());
       
       }catch(Exception ex){
           System.out.println("Error is found :"+ex);
        }
    
      return admin;
    }
        
    public boolean guardarAlumno (Alumno alu){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `alumno`(`id`,`nivel_id`,`login`,`clave`, `nombre`, `apellidos`) VALUES ('"+ alu.getIdAlumno()+"','"+alu.getIdNivelAlumno()+"','"+ alu.getLoginAlumno()+"','"+ alu.getClaveAlumno()+"','"+ alu.getNombreAlumno()+"','"+ alu.getApellidoAlumno() +"')";      
        try{
            ps = con.prepareStatement(sql);
            rsi = ps.executeUpdate(sql);
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
    
    public boolean modificarAlumno (Alumno alu) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE alumno SET nombre = ?, apellidos = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alu.getIdAlumno());
            /*ps.setInt(2, alu.getIdNivelAlumno());*/
            ps.setString(2, alu.getNombreAlumno());
            ps.setString(3, alu.getApellidoAlumno());
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
    
    public boolean eliminarAlumno(Alumno alu) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM alumno WHERE id = ?";
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
    
    public boolean guardarProfesor (Profesor prof){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `profesor`(`id`,`login`,`clave`,`nombre`,`apellidos`,`email`,`especialista`) VALUES ('"+ prof.getIdProfesor()+"','"+ prof.getLoginProfesor()+"','"+ prof.getClaveProfesor()+"','"+ prof.getNombreProfesor()+"','"+ prof.getApellidoProfesor() +"','" + prof.getEmailProfesor() + "','" + prof.getEspecialistaProfesor()+ "')";      
        try{
            ps = con.prepareStatement(sql);
            rsi = ps.executeUpdate(sql);
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
    
    public boolean modificarProfesor(Profesor prof) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE profesor SET idProfesor=?, nombreProfesor=?, apellidoProfesor=?, emailProfesor=?, especialistaProfesor=? WHERE codigo = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, prof.getIdProfesor());
            ps.setString(2, prof.getNombreProfesor());
            ps.setString(3, prof.getApellidoProfesor());
            ps.setString(4, prof.getEmailProfesor());
            ps.setInt(5, prof.getEspecialistaProfesor());
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
    
    public boolean eliminarProfesor(Profesor prof) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM profesor WHERE idProfesor = ?)";
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
    
    public boolean guardarAsignatura (Asignatura asign){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO `asignatura`(`nivel_id`,`profesor_id`,`nombre`) VALUES ('"+ asign.getIdNivelAsignatura()+"','"+asign.getIdProfesor()+"','"+asign.getNombreAsignatura()+"')";
        try {    
            ps = con.prepareStatement(sql);
            rsi = ps.executeUpdate(sql);
            System.out.println(asign.idAsignatura);
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
    public boolean modificarAsignatura (Asignatura asign) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE asignatura SET nombre = ?, nivel_id = ?, profesor_id = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, asign.getNombreAsignatura());
            ps.setInt(2, asign.getIdNivelAsignatura());
            ps.setInt(3, asign.getIdProfesor());
            ps.setInt(4, asign.idAsignatura);
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
    
    public boolean eliminarAsignatura(Asignatura asign) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM asignatura WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, asign.idAsignatura);
            System.out.println(asign.idAsignatura);
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