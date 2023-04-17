
package com.mycompany.jpapractice.persistencia;

import com.mycompany.jpapractice.logica.Profession;
import com.mycompany.jpapractice.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class ProfessionJpaController implements Serializable {

    public ProfessionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ProfessionJpaController(){
        
        emf = Persistence.createEntityManagerFactory("JPApracticePU");
    }
   
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profession profession) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(profession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profession profession) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            profession = em.merge(profession);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = profession.getId();
                if (findProfession(id) == null) {
                    throw new NonexistentEntityException("The profession with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profession profession;
            try {
                profession = em.getReference(Profession.class, id);
                profession.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profession with id " + id + " no longer exists.", enfe);
            }
            em.remove(profession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profession> findProfessionEntities() {
        return findProfessionEntities(true, -1, -1);
    }

    public List<Profession> findProfessionEntities(int maxResults, int firstResult) {
        return findProfessionEntities(false, maxResults, firstResult);
    }

    private List<Profession> findProfessionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profession.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Profession findProfession(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profession.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfessionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profession> rt = cq.from(Profession.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
