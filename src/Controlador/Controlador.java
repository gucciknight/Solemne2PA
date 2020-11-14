package Controlador;

import Modelo.Alumno;
import Modelo.OpAdminAlumno;
import Vista.AdministradorAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    
    private Alumno mod;
    private OpAdminAlumno modOp;
    private AdministradorAlumno modList;
    
    public Controlador (Alumno mod, OpAdminAlumno modOp, AdministradorAlumno modList){
         this.mod = mod;
        this.modOp = modOp;
        this.modList = modList;
        this.modList.btnGuardarAdminAlumno.addActionListener(this);
    }
    
    public void iniciar() {
        
        modList.setTitle("Listado de Equipos");
        modList.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnGuardarAdminAlumno) {
            mod.setIdAlumno(Integer.parseInt(modList.txtRutAdminAlumno.getText()));
            mod.setNombreAlumno(modList.txtNombreAdminAlumno.getText());
            mod.setApellidosAlumno(modList.txtApellidoAdminAlumno.getText());
            
            if (modOp.guardar(mod)) {
                JOptionPane.showMessageDialog(null, "Equipo Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
    }
}
