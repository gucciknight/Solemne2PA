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
    }
}