
package com.mycompany.jpapractice.persistencia;

import com.mycompany.jpapractice.logica.Alumno;
import com.mycompany.jpapractice.logica.Profession;
import com.mycompany.jpapractice.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControllerPersistencia {
    AlumnoJpaController alumnoJpaController = new AlumnoJpaController();
    ProfessionJpaController professionJpaController = new ProfessionJpaController();

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
        }}

    
    public Alumno getAlumno(int id) {
       return alumnoJpaController.findAlumno(id);
    }

    public ArrayList<Alumno> getAlumnosList() {
        List<Alumno> list = alumnoJpaController.findAlumnoEntities();
        
        ArrayList<Alumno> listAlumnos = new ArrayList<Alumno>(list);
        
        return listAlumnos;
    }

    public void createProfession(Profession profession) {
       professionJpaController.create(profession);
    }

    public void deleteProfession(int id) {
        try {
            professionJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProfession(Profession profession) {
        try {
            professionJpaController.edit(profession);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Profession getProfession(int id) {
        return professionJpaController.findProfession(id);
    }

    public ArrayList<Profession> getProfessionList() {
        List<Profession> list= professionJpaController.findProfessionEntities();
        
        ArrayList<Profession> arrayProfessions = new ArrayList(list);
        
        return arrayProfessions;
    }
}
