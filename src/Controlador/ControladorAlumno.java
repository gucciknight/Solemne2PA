package Controlador;

import Modelo.Alumno;
import Modelo.OpAdminAlumno;
import Vista.AdministradorAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorAlumno implements ActionListener {
    
    private Alumno mod;
    private OpAdminAlumno modOp;
    private AdministradorAlumno modList;
    
    public ControladorAlumno (Alumno mod, OpAdminAlumno modOp, AdministradorAlumno modList){
        this.mod = mod;
        this.modOp = modOp;
        this.modList = modList;
        this.modList.btnGuardarAdminAlumno.addActionListener(this);
        this.modList.btnEliminarAdminAlumno.addActionListener(this);
        this.modList.btnModificarAdminAlumno.addActionListener(this);
    }
    
    public void iniciar() {
        
        modList.setTitle("Listado de Alumnos");
        modList.setLocationRelativeTo(null);
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnGuardarAdminAlumno) {
            mod.setIdAlumno(Integer.parseInt(modList.txtRutAdminAlumno.getText()));
            mod.setNombreAlumno(modList.txtNombreAdminAlumno.getText());
            mod.setApellidoAlumno(modList.txtApellidoAdminAlumno.getText());
            mod.setLoginAlumno(modList.txtLoginAdminAlumno.getText());
            mod.setClaveAlumno(modList.txtClaveAdminAlumno.getText());
            
            if (modOp.guardar(mod)) {
                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
          if (e.getSource() == modList.btnModificarAdminAlumno) {
            mod.setNombreAlumno(modList.txtNombreAdminAlumno.getText());
            mod.setApellidoAlumno(modList.txtApellidoAdminAlumno.getText());
            
            if (modOp.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Equipo Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == modList.btnEliminarAdminAlumno){
            mod.setIdAlumno(Integer.parseInt(modList.txtRutAdminAlumno.getText()));
            
            if (modOp.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
    }
    
    public void limpiar() {

        modList.txtNombreAdminAlumno.setText(null);
        modList.txtApellidoAdminAlumno.setText(null);
        modList.txtRutAdminAlumno.setText(null);
        modList.txtAsignaturaAdminAlumno.setText(null);
    } 
}
