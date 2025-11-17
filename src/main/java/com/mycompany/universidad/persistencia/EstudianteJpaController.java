package com.mycompany.universidad.persistencia;

import com.mycompany.universidad.logica.Estudiante;
import com.mycompany.universidad.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class EstudianteJpaController implements Serializable {

    public EstudianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EstudianteJpaController() {
        emf = Persistence.createEntityManagerFactory("universidadJPAPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudiante estudiante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudiante> findEstudianteEntities() {
        return findEstudianteEntities(true, -1, -1);
    }

    public List<Estudiante> findEstudianteEntities(int maxResults, int firstResult) {
        return findEstudianteEntities(false, maxResults, firstResult);
    }

    private List<Estudiante> findEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudiante.class));
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

    public Estudiante findEstudiante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
            em.close();
        }
    }

    // ========== CONSULTAS JPQL ==========
    
    public List<Estudiante> findEstudiantesPorNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre LIKE :nombre ORDER BY e.apellido, e.nombre");
            query.setParameter("nombre", "%" + nombre + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Estudiante> findEstudiantesPaginados(int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.id DESC");
            query.setMaxResults(maxResults);
            query.setFirstResult(firstResult);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Estudiante> findEstudiantesConMatriculasActivas() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT DISTINCT e FROM Estudiante e JOIN e.matriculas m WHERE m.estado = 'ACTIVA' ORDER BY e.nombre");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}