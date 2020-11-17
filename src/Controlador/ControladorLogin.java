package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.OperacionesAdmin;
import Modelo.Profesor;
import Modelo.OperacionesAlumno;
import Vista.AdministradorPanel;
import Vista.AdministradorAlumno;
import Vista.AdministradorProfesor;
import Vista.Login;
import Vista.AlumnoPanel;
import Vista.ProfesorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {
    
    private Login modList;
    
    public ControladorLogin(Login modList){
        this.modList = modList;
        this.modList.btnIngresar.addActionListener(this);
        this.modList.btnSalir.addActionListener(this);
        this.modList.txtPass.getText();
        this.modList.txtUser.getText();
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
                OperacionesAlumno opal = new OperacionesAlumno();
                Alumno alumno = opal.LoginAlumno(this.modList.txtUser.getText(), this.modList.txtPass.getText());
                System.out.println(alumno.getIdAlumno());
                
                AlumnoPanel modList = new AlumnoPanel();
                ControladorPanelAlumno ctrl = new ControladorPanelAlumno(modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            if (seleccion()== "Profesor"){
                ProfesorPanel modList = new ProfesorPanel();
                ControladorPanelProfesor ctrl = new ControladorPanelProfesor(modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            
            if (seleccion()=="Administrador"){
                AdministradorPanel modList = new AdministradorPanel();
                ControladorPanelAdministrador ctrl = new ControladorPanelAdministrador(modList);
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