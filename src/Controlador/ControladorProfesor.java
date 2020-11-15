package Controlador;

import Modelo.Profesor;
import Modelo.OpAdminProfesor;
import Vista.AdministradorProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorProfesor {
    private Profesor mod;
    private OpAdminProfesor modOp;
    private AdministradorProfesor modList;
    
    public ControladorProfesor (Profesor mod, OpAdminProfesor modOp, AdministradorProfesor modList){
        this.mod = mod;
        this.modOp = modOp;
        this.modList = modList;
        this.modList.btnGuardarAdminProfesor.addActionListener((ActionListener) this);
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
            
            if (modOp.guardar(mod)) {
                JOptionPane.showMessageDialog(null, "Profesor Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
        if (e.getSource() == modList.btnEliminarAdminProfesor){
            mod.setIdProfesor(Integer.parseInt(modList.txtRutAdminProfesor.getText()));
            
            if (modOp.eliminar(mod)) {
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
        modList.txtAsignaturaAdminProfesor.setText(null);
    } 
}
