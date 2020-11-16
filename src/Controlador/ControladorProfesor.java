package Controlador;

import Modelo.Profesor;
import Modelo.OperacionesAdmin;
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
    
    public void iniciar() {
        
        modList.setTitle("Listado de Profesores");
        modList.setLocationRelativeTo(null);
    }  

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnGuardarAdminProfesor) {
            mod.setIdProfesor(Integer.parseInt(modList.txtRutAdminProfesor.getText()));
            mod.setNombreProfesor(modList.txtNombreAdminProfesor.getText());
            mod.setApellidoProfesor(modList.txtApellidoAdminProfesor.getText());
            mod.setEmailProfesor(modList.txtEmailAdminProfesor.getText());
            mod.setClaveProfesor(modList.passContrasenaAdminProfesor.getText());
            mod.setEspecialistaProfesor(Integer.parseInt(modList.txtAsignaturaAdminProfesor.getText()));
            
            if (modOp.guardarProfesor(mod)) {
                JOptionPane.showMessageDialog(null, "Profesor Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
        if (e.getSource() == modList.btnModificarAdminProfesor) {
            mod.setNombreProfesor(modList.txtNombreAdminProfesor.getText());
            mod.setApellidoProfesor(modList.txtApellidoAdminProfesor.getText());
            mod.setEmailProfesor(modList.txtEmailAdminProfesor.getText());
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
        modList.passContrasenaAdminProfesor.setText(null);
        modList.txtAsignaturaAdminProfesor.setText(null);
    } 
}

