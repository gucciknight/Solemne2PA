package Solemne2;

import Controlador.Controlador;
import Modelo.Alumno;
import Modelo.OpAdminAlumno;
import Vista.AdministradorAlumno;
        
public class Solemne2 {
        public static void main(String[] args) {
            
            Alumno mod = new Alumno();
            OpAdminAlumno modOp = new OpAdminAlumno();
            AdministradorAlumno modList = new AdministradorAlumno();
            Controlador ctrl = new Controlador(mod, modOp, modList);
            ctrl.iniciar();
            modList.setVisible(true);
    }
}
