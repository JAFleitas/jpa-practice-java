

package com.mycompany.jpapractice;

import com.mycompany.jpapractice.logica.Alumno;
import com.mycompany.jpapractice.logica.LogicaController;
import java.util.Date;


public class JpaPractice {

    public static void main(String[] args) {
        LogicaController control = new LogicaController();
        Alumno alumno1 = new Alumno(1, "Gonzalo", "Fleitas",new Date());
        Alumno alumno2 = new Alumno(3, "Julieta", "Fleitas",new Date());
        
        control.createAlumno(alumno1);
        
        control.createAlumno(alumno2);
    }
}
