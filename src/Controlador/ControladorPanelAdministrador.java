package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.OperacionesAdmin;
import Modelo.Profesor;
import Vista.AdministradorAlumno;
import Vista.AdministradorAsignatura;
import Vista.AdministradorProfesor;
import Vista.AdministradorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPanelAdministrador implements ActionListener {
    
    private AdministradorPanel AdmList;
    
    public ControladorPanelAdministrador(AdministradorPanel modList){
        this.AdmList = modList;
        this.AdmList.btnAlumno.addActionListener(this);
        this.AdmList.btnProfesor.addActionListener(this);
        this.AdmList.btnAsignatura.addActionListener(this);      
    }
    
    public void iniciar() {
        AdmList.setTitle("Panel de Administrador");
        AdmList.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AdmList.btnAlumno) {
            Alumno mod = new Alumno();
            OperacionesAdmin modOp = new OperacionesAdmin();
            AdministradorAlumno modList = new AdministradorAlumno();
            ControladorAlumno ctrl = new ControladorAlumno(mod, modOp, modList);
            ctrl.iniciar();
            modList.setVisible(true);                
            }
        
        if (e.getSource() == AdmList.btnProfesor) {
            Profesor mod = new Profesor();
            OperacionesAdmin modOp = new OperacionesAdmin();
            AdministradorProfesor modList = new AdministradorProfesor();
            ControladorProfesor ctrl = new ControladorProfesor(mod, modOp, modList);
            ctrl.iniciar();
            modList.setVisible(true);
            }
            
        if (e.getSource() == AdmList.btnAsignatura) {
            Asignatura mod = new Asignatura();
            OperacionesAdmin modOp = new OperacionesAdmin();
            AdministradorAsignatura modList = new AdministradorAsignatura();
            ControladorAsignatura ctrl = new ControladorAsignatura(mod, modOp, modList);
            ctrl.iniciar();
            modList.setVisible(true);
            }
    }
}