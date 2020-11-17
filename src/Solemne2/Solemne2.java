package Solemne2;

import Controlador.*;
import Modelo.Alumno;
import Modelo.Profesor;
import Modelo.Asignatura;
import Modelo.OperacionesAdmin;
import Vista.*;
import java.util.*;
import javax.swing.*;
        
public class Solemne2 {
        public static void main(String[] args) {            
            Scanner leer = new Scanner(System.in);
            /*System.out.println("0 Login 1 Alumno 2 Profesor 3 Asignatura");
            int opcion = leer.nextInt();*/
            
            Login loginList = new Login();
            ControladorLogin control = new ControladorLogin(loginList);
            control.iniciar();
            loginList.setVisible(true);
            
                       
            if (control.seleccion()== "Alumno"){
                Alumno mod = new Alumno();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAlumno modList = new AdministradorAlumno();
                ControladorAlumno ctrl = new ControladorAlumno(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
                System.out.println(control.seleccion());
            }
            
            if (control.seleccion() == "Profesor"){
                Profesor mod = new Profesor();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorProfesor modList = new AdministradorProfesor();
                ControladorProfesor ctrl = new ControladorProfesor(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
                System.out.println(control.seleccion());
            }
            
            if (control.seleccion() == "administrador"){
                Asignatura mod = new Asignatura();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAsignatura modList = new AdministradorAsignatura();
                ControladorAsignatura ctrl = new ControladorAsignatura(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
                System.out.println(control.seleccion());
            }
    }
}
