package Controlador;

import Vista.AlumnoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPanelAlumno implements ActionListener {
    
    private AlumnoPanel AluList;
    
    public ControladorPanelAlumno(AlumnoPanel modList){
        this.AluList = modList;
        this.AluList.btnConectados.addActionListener(this);
        this.AluList.btnProfesores.addActionListener(this);
        this.AluList.btnNotasAlumno.addActionListener(this);      
    }
    
    public void iniciar() {
        AluList.setTitle("Panel de Alumnos");
        AluList.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == AluList.btnConectados) {
            System.out.println("Prueba Conectados");
            }
        
        if (e.getSource() == AluList.btnProfesores) {
            System.out.println("Prueba Profesores");
            }
            
        if (e.getSource() == AluList.btnNotasAlumno) {
            System.out.println("Prueba Notas");
        }
    } 
}