
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
    
    // profession
    public void createProfession (Profession profession){
        controllerPersistencia.createProfession(profession);
    }
    
    public void deleteProfession (int id){
        controllerPersistencia.deleteProfession(id);
    }
    
    public void editProfession (Profession profession){
        controllerPersistencia.editProfession(profession);
    }
    
    public Profession getProfession (int id){
        return controllerPersistencia.getProfession(id);
    }
    
    public ArrayList<Profession> getProfessionList (){
        return controllerPersistencia.getProfessionList();
    }
}
