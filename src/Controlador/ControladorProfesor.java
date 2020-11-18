package Controlador;

import Modelo.Asignatura;
import Modelo.Profesor;
import Modelo.OperacionesAdmin;
import Vista.AdministradorAsignatura;
import Vista.AdministradorProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorProfesor implements ActionListener{
    private Profesor mod;
    private OperacionesAdmin modOp;
    private AdministradorProfesor modList;
    
    public ControladorProfesor (Profesor mod, OperacionesAdmin modOp, AdministradorProfesor modList){
        this.mod = mod;
        this.modOp = modOp;
        this.modList = modList;
        this.modList.btnGuardarAdminProfesor.addActionListener(this);
        this.modList.btnEliminarAdminProfesor.addActionListener(this);
        this.modList.btnModificarAdminProfesor.addActionListener(this);
    }

    public ControladorProfesor(Asignatura mod, OperacionesAdmin modOp, AdministradorAsignatura modList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void iniciar() {
        
        modList.setTitle("Gestion de Profesores");
        modList.setLocationRelativeTo(null);
    }  

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnGuardarAdminProfesor) {
            mod.setIdProfesor(Integer.parseInt(modList.txtRutAdminProfesor.getText()));
            mod.setNombreProfesor(modList.txtNombreAdminProfesor.getText());
            mod.setApellidoProfesor(modList.txtApellidoAdminProfesor.getText());
            mod.setEmailProfesor(modList.txtEmailAdminProfesor.getText());
            mod.setLoginProfesor(modList.txtLoginAdminProfesor.getText());
            mod.setClaveProfesor(modList.txtclaveAdminProfesor.getText());
            mod.setEspecialistaProfesor(Integer.parseInt(modList.txtAsignaturaAdminProfesor.getText()));
            
            if (modOp.guardarProfesor(mod)) {
                JOptionPane.showMessageDialog(null, "Profesor Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
        if (e.getSource() == modList.btnModificarAdminProfesor) {
            mod.setIdProfesor(Integer.parseInt(modList.txtRutAdminProfesor.getText()));
            mod.setLoginProfesor(modList.txtLoginAdminProfesor.getText());
            mod.setClaveProfesor(modList.txtclaveAdminProfesor.getText());
            mod.setNombreProfesor(modList.txtNombreAdminProfesor.getText());
            mod.setApellidoProfesor(modList.txtApellidoAdminProfesor.getText());
            mod.setEmailProfesor(modList.txtLoginAdminProfesor.getText());
            mod.setEspecialistaProfesor(Integer.parseInt(modList.txtAsignaturaAdminProfesor.getText()));
            
            if (modOp.modificarProfesor(mod)) {
                JOptionPane.showMessageDialog(null, "Profesor Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == modList.btnEliminarAdminProfesor){
            mod.setIdProfesor(Integer.parseInt(modList.txtRutAdminProfesor.getText()));
            
            if (modOp.eliminarProfesor(mod)) {
                JOptionPane.showMessageDialog(null, "Profesor Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
    }
    
    public void limpiar() {

        modList.txtNombreAdminProfesor.setText(null);
        modList.txtApellidoAdminProfesor.setText(null);
        modList.txtRutAdminProfesor.setText(null);
        modList.txtEmailAdminProfesor.setText(null);
        modList.txtclaveAdminProfesor.setText(null);
        modList.txtAsignaturaAdminProfesor.setText(null);
        modList.txtLoginAdminProfesor.setText(null);
    } 
}

