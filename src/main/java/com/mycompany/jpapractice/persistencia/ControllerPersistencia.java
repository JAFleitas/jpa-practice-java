
package com.mycompany.jpapractice.persistencia;

import com.mycompany.jpapractice.logica.Alumno;
import com.mycompany.jpapractice.persistencia.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistencia {
    AlumnoJpaController alumnoJpaController = new AlumnoJpaController();

    public void createAlumno(Alumno alumno) {
        alumnoJpaController.create(alumno);
    
    }

    public void deleteAlumno(int id) {
        try {
            alumnoJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editAlumno(Alumno alumno) {
        try {
            alumnoJpaController.edit(alumno);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
