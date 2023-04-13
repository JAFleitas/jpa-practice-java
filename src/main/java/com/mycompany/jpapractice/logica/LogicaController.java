
package com.mycompany.jpapractice.logica;

import com.mycompany.jpapractice.persistencia.ControllerPersistencia;


public class LogicaController {
    ControllerPersistencia controllerPersistencia = new ControllerPersistencia();
    
    public void createAlumno (Alumno alumno){
        controllerPersistencia.createAlumno(alumno);
    }
}
