
package com.mycompany.jpapractice.logica;

import com.mycompany.jpapractice.persistencia.ControllerPersistencia;
import java.util.ArrayList;


public class LogicaController {
    ControllerPersistencia controllerPersistencia = new ControllerPersistencia();
    
    public void createAlumno (Alumno alumno){
        controllerPersistencia.createAlumno(alumno);
    }
    
    public void deleteAlumno (int id){
        controllerPersistencia.deleteAlumno(id);
    }
    
    public void editAlumno (Alumno alumno){
        controllerPersistencia.editAlumno(alumno);
    }
    
    public Alumno getAlumno (int id){
        return controllerPersistencia.getAlumno(id);
    }
    
    public ArrayList<Alumno> getAlumnosList (){
        return controllerPersistencia.getAlumnosList();
    }
}
