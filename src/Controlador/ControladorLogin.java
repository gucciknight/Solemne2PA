package Controlador;

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
    
    public Object seleccion(){
        Object seleccion = modList.cbUsuario.getSelectedItem();
        return seleccion;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modList.btnIngresar) {
            JOptionPane.showMessageDialog(null, "Ingresado con exito");
            System.out.println(seleccion());
        }
        
        if (e.getSource() == modList.btnSalir){
            JOptionPane.showMessageDialog(null, "Salido con exito");
            modList.dispose();
        } 
    }
}