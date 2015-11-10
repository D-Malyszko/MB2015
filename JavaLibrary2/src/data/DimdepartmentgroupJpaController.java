/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.NonexistentEntityException;
import data.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author admin
 */
public class DimdepartmentgroupJpaController implements Serializable {

    public DimdepartmentgroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimdepartmentgroup dimdepartmentgroup) throws PreexistingEntityException, Exception {
        if (dimdepartmentgroup.getDimdepartmentgroupCollection() == null) {
            dimdepartmentgroup.setDimdepartmentgroupCollection(new ArrayList<Dimdepartmentgroup>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdepartmentgroup parentdepartmentgroupkey = dimdepartmentgroup.getParentdepartmentgroupkey();
            if (parentdepartmentgroupkey != null) {
                parentdepartmentgroupkey = em.getReference(parentdepartmentgroupkey.getClass(), parentdepartmentgroupkey.getDepartmentgroupkey());
                dimdepartmentgroup.setParentdepartmentgroupkey(parentdepartmentgroupkey);
            }
            Collection<Dimdepartmentgroup> attachedDimdepartmentgroupCollection = new ArrayList<Dimdepartmentgroup>();
            for (Dimdepartmentgroup dimdepartmentgroupCollectionDimdepartmentgroupToAttach : dimdepartmentgroup.getDimdepartmentgroupCollection()) {
                dimdepartmentgroupCollectionDimdepartmentgroupToAttach = em.getReference(dimdepartmentgroupCollectionDimdepartmentgroupToAttach.getClass(), dimdepartmentgroupCollectionDimdepartmentgroupToAttach.getDepartmentgroupkey());
                attachedDimdepartmentgroupCollection.add(dimdepartmentgroupCollectionDimdepartmentgroupToAttach);
            }
            dimdepartmentgroup.setDimdepartmentgroupCollection(attachedDimdepartmentgroupCollection);
            em.persist(dimdepartmentgroup);
            if (parentdepartmentgroupkey != null) {
                parentdepartmentgroupkey.getDimdepartmentgroupCollection().add(dimdepartmentgroup);
                parentdepartmentgroupkey = em.merge(parentdepartmentgroupkey);
            }
            for (Dimdepartmentgroup dimdepartmentgroupCollectionDimdepartmentgroup : dimdepartmentgroup.getDimdepartmentgroupCollection()) {
                Dimdepartmentgroup oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionDimdepartmentgroup = dimdepartmentgroupCollectionDimdepartmentgroup.getParentdepartmentgroupkey();
                dimdepartmentgroupCollectionDimdepartmentgroup.setParentdepartmentgroupkey(dimdepartmentgroup);
                dimdepartmentgroupCollectionDimdepartmentgroup = em.merge(dimdepartmentgroupCollectionDimdepartmentgroup);
                if (oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionDimdepartmentgroup != null) {
                    oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionDimdepartmentgroup.getDimdepartmentgroupCollection().remove(dimdepartmentgroupCollectionDimdepartmentgroup);
                    oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionDimdepartmentgroup = em.merge(oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionDimdepartmentgroup);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimdepartmentgroup(dimdepartmentgroup.getDepartmentgroupkey()) != null) {
                throw new PreexistingEntityException("Dimdepartmentgroup " + dimdepartmentgroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimdepartmentgroup dimdepartmentgroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdepartmentgroup persistentDimdepartmentgroup = em.find(Dimdepartmentgroup.class, dimdepartmentgroup.getDepartmentgroupkey());
            Dimdepartmentgroup parentdepartmentgroupkeyOld = persistentDimdepartmentgroup.getParentdepartmentgroupkey();
            Dimdepartmentgroup parentdepartmentgroupkeyNew = dimdepartmentgroup.getParentdepartmentgroupkey();
            Collection<Dimdepartmentgroup> dimdepartmentgroupCollectionOld = persistentDimdepartmentgroup.getDimdepartmentgroupCollection();
            Collection<Dimdepartmentgroup> dimdepartmentgroupCollectionNew = dimdepartmentgroup.getDimdepartmentgroupCollection();
            if (parentdepartmentgroupkeyNew != null) {
                parentdepartmentgroupkeyNew = em.getReference(parentdepartmentgroupkeyNew.getClass(), parentdepartmentgroupkeyNew.getDepartmentgroupkey());
                dimdepartmentgroup.setParentdepartmentgroupkey(parentdepartmentgroupkeyNew);
            }
            Collection<Dimdepartmentgroup> attachedDimdepartmentgroupCollectionNew = new ArrayList<Dimdepartmentgroup>();
            for (Dimdepartmentgroup dimdepartmentgroupCollectionNewDimdepartmentgroupToAttach : dimdepartmentgroupCollectionNew) {
                dimdepartmentgroupCollectionNewDimdepartmentgroupToAttach = em.getReference(dimdepartmentgroupCollectionNewDimdepartmentgroupToAttach.getClass(), dimdepartmentgroupCollectionNewDimdepartmentgroupToAttach.getDepartmentgroupkey());
                attachedDimdepartmentgroupCollectionNew.add(dimdepartmentgroupCollectionNewDimdepartmentgroupToAttach);
            }
            dimdepartmentgroupCollectionNew = attachedDimdepartmentgroupCollectionNew;
            dimdepartmentgroup.setDimdepartmentgroupCollection(dimdepartmentgroupCollectionNew);
            dimdepartmentgroup = em.merge(dimdepartmentgroup);
            if (parentdepartmentgroupkeyOld != null && !parentdepartmentgroupkeyOld.equals(parentdepartmentgroupkeyNew)) {
                parentdepartmentgroupkeyOld.getDimdepartmentgroupCollection().remove(dimdepartmentgroup);
                parentdepartmentgroupkeyOld = em.merge(parentdepartmentgroupkeyOld);
            }
            if (parentdepartmentgroupkeyNew != null && !parentdepartmentgroupkeyNew.equals(parentdepartmentgroupkeyOld)) {
                parentdepartmentgroupkeyNew.getDimdepartmentgroupCollection().add(dimdepartmentgroup);
                parentdepartmentgroupkeyNew = em.merge(parentdepartmentgroupkeyNew);
            }
            for (Dimdepartmentgroup dimdepartmentgroupCollectionOldDimdepartmentgroup : dimdepartmentgroupCollectionOld) {
                if (!dimdepartmentgroupCollectionNew.contains(dimdepartmentgroupCollectionOldDimdepartmentgroup)) {
                    dimdepartmentgroupCollectionOldDimdepartmentgroup.setParentdepartmentgroupkey(null);
                    dimdepartmentgroupCollectionOldDimdepartmentgroup = em.merge(dimdepartmentgroupCollectionOldDimdepartmentgroup);
                }
            }
            for (Dimdepartmentgroup dimdepartmentgroupCollectionNewDimdepartmentgroup : dimdepartmentgroupCollectionNew) {
                if (!dimdepartmentgroupCollectionOld.contains(dimdepartmentgroupCollectionNewDimdepartmentgroup)) {
                    Dimdepartmentgroup oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionNewDimdepartmentgroup = dimdepartmentgroupCollectionNewDimdepartmentgroup.getParentdepartmentgroupkey();
                    dimdepartmentgroupCollectionNewDimdepartmentgroup.setParentdepartmentgroupkey(dimdepartmentgroup);
                    dimdepartmentgroupCollectionNewDimdepartmentgroup = em.merge(dimdepartmentgroupCollectionNewDimdepartmentgroup);
                    if (oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionNewDimdepartmentgroup != null && !oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionNewDimdepartmentgroup.equals(dimdepartmentgroup)) {
                        oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionNewDimdepartmentgroup.getDimdepartmentgroupCollection().remove(dimdepartmentgroupCollectionNewDimdepartmentgroup);
                        oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionNewDimdepartmentgroup = em.merge(oldParentdepartmentgroupkeyOfDimdepartmentgroupCollectionNewDimdepartmentgroup);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimdepartmentgroup.getDepartmentgroupkey();
                if (findDimdepartmentgroup(id) == null) {
                    throw new NonexistentEntityException("The dimdepartmentgroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdepartmentgroup dimdepartmentgroup;
            try {
                dimdepartmentgroup = em.getReference(Dimdepartmentgroup.class, id);
                dimdepartmentgroup.getDepartmentgroupkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimdepartmentgroup with id " + id + " no longer exists.", enfe);
            }
            Dimdepartmentgroup parentdepartmentgroupkey = dimdepartmentgroup.getParentdepartmentgroupkey();
            if (parentdepartmentgroupkey != null) {
                parentdepartmentgroupkey.getDimdepartmentgroupCollection().remove(dimdepartmentgroup);
                parentdepartmentgroupkey = em.merge(parentdepartmentgroupkey);
            }
            Collection<Dimdepartmentgroup> dimdepartmentgroupCollection = dimdepartmentgroup.getDimdepartmentgroupCollection();
            for (Dimdepartmentgroup dimdepartmentgroupCollectionDimdepartmentgroup : dimdepartmentgroupCollection) {
                dimdepartmentgroupCollectionDimdepartmentgroup.setParentdepartmentgroupkey(null);
                dimdepartmentgroupCollectionDimdepartmentgroup = em.merge(dimdepartmentgroupCollectionDimdepartmentgroup);
            }
            em.remove(dimdepartmentgroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimdepartmentgroup> findDimdepartmentgroupEntities() {
        return findDimdepartmentgroupEntities(true, -1, -1);
    }

    public List<Dimdepartmentgroup> findDimdepartmentgroupEntities(int maxResults, int firstResult) {
        return findDimdepartmentgroupEntities(false, maxResults, firstResult);
    }

    private List<Dimdepartmentgroup> findDimdepartmentgroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimdepartmentgroup.class));
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

    public Dimdepartmentgroup findDimdepartmentgroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimdepartmentgroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimdepartmentgroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimdepartmentgroup> rt = cq.from(Dimdepartmentgroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
