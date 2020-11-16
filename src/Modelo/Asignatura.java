package Modelo;

public class Asignatura {
    int idAsignatura;
    int idNivelAsignatura;
    int idProfesor;
    String nombreAsignatura;

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public int getIdNivelAsignatura() {
        return idNivelAsignatura;
    }

    public void setIdNivelAsignatura(int idNivelAsignatura) {
        this.idNivelAsignatura = idNivelAsignatura;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }  
}