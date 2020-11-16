package Solemne2;

import Controlador.ControladorAlumno;
import Controlador.ControladorProfesor;
import Modelo.Alumno;
import Modelo.Profesor;
import Modelo.OperacionesAdmin;
import Vista.AdministradorAlumno;
import Vista.AdministradorProfesor;
import java.util.*;
        
public class Solemne2 {
        public static void main(String[] args) {
            Scanner leer = new Scanner(System.in);
            System.out.println("1 Alumno 2 Profesor");
            int opcion = leer.nextInt();
            
            if (opcion == 1){
                Alumno mod = new Alumno();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorAlumno modList = new AdministradorAlumno();
                ControladorAlumno ctrl = new ControladorAlumno(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
            
            if (opcion == 2){
                Profesor mod = new Profesor();
                OperacionesAdmin modOp = new OperacionesAdmin();
                AdministradorProfesor modList = new AdministradorProfesor();
                ControladorProfesor ctrl = new ControladorProfesor(mod, modOp, modList);
                ctrl.iniciar();
                modList.setVisible(true);
            }
    }
}
