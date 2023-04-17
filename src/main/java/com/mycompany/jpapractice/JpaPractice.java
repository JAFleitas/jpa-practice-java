

package com.mycompany.jpapractice;

import com.mycompany.jpapractice.logica.Alumno;
import com.mycompany.jpapractice.logica.LogicaController;
import com.mycompany.jpapractice.logica.Profession;
import java.util.ArrayList;
import java.util.Date;


public class JpaPractice {

    public static void main(String[] args) {
        LogicaController control = new LogicaController();
        
        // CREAR PROFESION
        Profession abogaciaProfession = new Profession(1, "Abogacia");
        
        // GUARDAR PROFESION EN DB
        control.createProfession(abogaciaProfession);
        // CREAR ALUMNO CON PROFESION
        Alumno alumnoUno = new Alumno(33,"Gonzalo","Fleitas",new Date(),abogaciaProfession);
        // GUARDAR ALUMNO EN LA DB
        control.createAlumno(alumnoUno);
        
        // PRUEBA
        Profession prof = control.getProfession(1);
        Alumno pruebaAlumno = control.getAlumno(33);
        System.out.println(pruebaAlumno.toString());
        System.out.println("--------");
        System.out.println(prof.toString());
        
       /*
        
        Alumno alumno2 = new Alumno(3, "Julieta", "Fleitas",new Date());
        
        
        
        control.createAlumno(alumno2);
        control.deleteAlumno(1);
        */
        //Alumno alumno1 = new Alumno(1, "Gonzalo", "Fleitas",new Date());
        //control.createAlumno(alumno1);
        //alumno1.setApellido("Spinelli");
        //control.editAlumno(alumno1);
        
        //find
//        System.out.println(control.getAlumno(1).toString());
//        
//        ArrayList<Alumno> listAlumnos = control.getAlumnosList();
//        
//        for (Alumno alumno: listAlumnos) {
//            System.out.println(alumno.toString());
//        }
        
    }
}
