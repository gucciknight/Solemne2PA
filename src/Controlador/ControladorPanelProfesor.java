package Controlador;

import Vista.ProfesorPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPanelProfesor implements ActionListener {
    
    private ProfesorPanel ProfList;
    
    public ControladorPanelProfesor(ProfesorPanel modList){
        this.ProfList = modList;
        this.ProfList.btnAsignaturas.addActionListener(this);
        this.ProfList.btnProfesores.addActionListener(this);
        this.ProfList.btnRegistrarNotas.addActionListener(this);      
    }
    
    public void iniciar() {
        ProfList.setTitle("Panel de Profesores");
        ProfList.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ProfList.btnAsignaturas) {
            System.out.println("Prueba Asignaturas");
            }
        if (e.getSource() == ProfList.btnProfesores) {
            System.out.println("Prueba Profesores");
            }
            
        if (e.getSource() == ProfList.btnRegistrarNotas) {
            System.out.println("Prueba Registro Notas");
            }
    } 
}