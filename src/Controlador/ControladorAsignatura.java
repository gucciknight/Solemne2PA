package Controlador;

import Modelo.Asignatura;
import Modelo.OperacionesAdmin;
import Vista.AdministradorAsignatura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorAsignatura implements ActionListener {
    
    private Asignatura mod;
    private OperacionesAdmin modOp;
    private AdministradorAsignatura modList;
    
    public ControladorAsignatura (Asignatura mod, OperacionesAdmin modOp, AdministradorAsignatura modList){
        this.mod = mod;
        this.modOp = modOp;
        this.modList = modList;
        this.modList.btnGuardarAdminAsignatura.addActionListener(this);
        this.modList.btnEliminarAdminAsignatura.addActionListener(this);
        this.modList.btnModificarAdminAsignatura.addActionListener(this);
    }
    
    public void iniciar() {
        
        modList.setTitle("Gestion Asignaturas");
        modList.setLocationRelativeTo(null);
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnGuardarAdminAsignatura) {
            /*mod.setIdAsignatura(1);*/
            mod.setIdNivelAsignatura(Integer.parseInt(modList.txtAsignaturaAdminAsignatura1.getText()));
            mod.setIdProfesor(Integer.parseInt(modList.txtAsignaturaAdminAsignatura2.getText()));
            mod.setNombreAsignatura(modList.txtAsignaturaAdminAsignatura.getText());
            
            if (modOp.guardarAsignatura(mod)) {
                JOptionPane.showMessageDialog(null, "Asignatura Guardada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
          if (e.getSource() == modList.btnModificarAdminAsignatura) {
            mod.setIdNivelAsignatura(Integer.parseInt(modList.txtAsignaturaAdminAsignatura5.getText()));
            mod.setIdProfesor(Integer.parseInt(modList.txtAsignaturaAdminAsignatura3.getText()));
            mod.setNombreAsignatura(modList.txtAsignaturaAdminAsignatura4.getText());
            
            if (modOp.modificarAsignatura(mod)) {
                JOptionPane.showMessageDialog(null, "Asignatura Modificada");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == modList.btnEliminarAdminAsignatura){
            mod.setIdAsignatura(Integer.parseInt(modList.txtAsignaturaAdminAsignatura7.getText()));
            
            if (modOp.eliminarAsignatura(mod)) {
                JOptionPane.showMessageDialog(null, "Asignatura Eliminada");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
    }
    
    public void limpiar() {

        modList.txtAsignaturaAdminAsignatura.setText(null);
        modList.txtAsignaturaAdminAsignatura1.setText(null);
        modList.txtAsignaturaAdminAsignatura2.setText(null);
        modList.txtAsignaturaAdminAsignatura3.setText(null);
        modList.txtAsignaturaAdminAsignatura4.setText(null);
        modList.txtAsignaturaAdminAsignatura5.setText(null);
        modList.txtAsignaturaAdminAsignatura6.setText(null);
        modList.txtAsignaturaAdminAsignatura7.setText(null);
    } 
}
