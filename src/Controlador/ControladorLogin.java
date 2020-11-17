package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.OperacionesAdmin;
import Modelo.Profesor;
import Vista.AdministradorAlumno;
import Vista.AdministradorAsignatura;
import Vista.AdministradorProfesor;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {
    
    private Login modList;
    
    public ControladorLogin(Login modList){
        this.modList = modList;
        this.modList.btnIngresar.addActionListener(this);
        this.modList.btnSalir.addActionListener(this);
    }
    
    public void iniciar() {
        modList.setTitle("Login");
        modList.setLocationRelativeTo(null);
    }
    
    public String seleccion(){
        String seleccion = modList.cbUsuario.getSelectedItem().toString();
        return seleccion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnIngresar) {
            JOptionPane.showMessageDialog(null, "Ingresado con exito");
            modList.setVisible(false);
            
            if (seleccion() == "Alumno"){
                Alumno mod = new Alumno();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAlumno modList = new AdministradorAlumno();
                ControladorAlumno ctrl = new ControladorAlumno(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);                
            }
            if (seleccion()== "Profesor"){
                Profesor mod = new Profesor();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorProfesor modList = new AdministradorProfesor();
                ControladorProfesor ctrl = new ControladorProfesor(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            
            if (seleccion()=="Administrador"){
                Asignatura mod = new Asignatura();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAsignatura modList = new AdministradorAsignatura();
                ControladorAsignatura ctrl = new ControladorAsignatura(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            
        }
        
        if (e.getSource() == modList.btnSalir){
            JOptionPane.showMessageDialog(null, "Salido con exito");
            modList.dispose();
        } 
    }
}