package Modelo;

public class Nota {
    int idNota;
    int idAlumnoAsignatura;
    int idAsignatura;
    int trimestre;
    double nota;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdAlumnoAsignatura() {
        return idAlumnoAsignatura;
    }

    public void setIdAlumnoAsignatura(int idAlumnoAsignatura) {
        this.idAlumnoAsignatura = idAlumnoAsignatura;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
