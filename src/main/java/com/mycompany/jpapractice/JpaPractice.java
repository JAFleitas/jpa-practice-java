

package com.mycompany.jpapractice;

import com.mycompany.jpapractice.logica.Alumno;
import com.mycompany.jpapractice.logica.LogicaController;
import java.util.Date;


public class JpaPractice {

    public static void main(String[] args) {
        LogicaController control = new LogicaController();
       /*
        
        Alumno alumno2 = new Alumno(3, "Julieta", "Fleitas",new Date());
        
        
        
        control.createAlumno(alumno2);
        control.deleteAlumno(1);
        */
        Alumno alumno1 = new Alumno(1, "Gonzalo", "Fleitas",new Date());
       control.createAlumno(alumno1);
       alumno1.setApellido("Spinelli");
       control.editAlumno(alumno1);
    }
}
