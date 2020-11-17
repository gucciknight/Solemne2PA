package Solemne2;

import Controlador.*;
import Modelo.Alumno;
import Modelo.Profesor;
import Modelo.Asignatura;
import Modelo.OperacionesAdmin;
import Vista.*;
import java.util.*;
        
public class Solemne2 {
        public static void main(String[] args) {            
            Scanner leer = new Scanner(System.in);
            /*System.out.println("0 Login 1 Alumno 2 Profesor 3 Asignatura");
            int opcion = leer.nextInt();*/
            
            Login loginList = new Login();
            ControladorLogin control = new ControladorLogin(loginList);
            control.iniciar();
            loginList.setVisible(true);
            String seleccion = control.seleccion();
            
            if (seleccion=="Alumno"){
                System.out.println(seleccion);
                Alumno mod = new Alumno();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAlumno modList = new AdministradorAlumno();
                ControladorAlumno ctrl = new ControladorAlumno(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            
            if (seleccion== "Profesor"){
                System.out.println(seleccion);
                Profesor mod = new Profesor();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorProfesor modList = new AdministradorProfesor();
                ControladorProfesor ctrl = new ControladorProfesor(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            
            if (seleccion=="Administrador"){
                System.out.println(seleccion);
                Asignatura mod = new Asignatura();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAsignatura modList = new AdministradorAsignatura();
                ControladorAsignatura ctrl = new ControladorAsignatura(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
    }
}
