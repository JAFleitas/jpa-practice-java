
package com.mycompany.jpapractice.persistencia;

import com.mycompany.jpapractice.logica.Alumno;


public class ControllerPersistencia {
    AlumnoJpaController alumnoJpaController = new AlumnoJpaController();

    public void createAlumno(Alumno alumno) {
        alumnoJpaController.create(alumno);
    
    }
}
