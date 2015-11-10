/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.IllegalOrphanException;
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
public class DimemployeeJpaController implements Serializable {

    public DimemployeeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimemployee dimemployee) throws PreexistingEntityException, Exception {
        if (dimemployee.getFactsalesquotaCollection() == null) {
            dimemployee.setFactsalesquotaCollection(new ArrayList<Factsalesquota>());
        }
        if (dimemployee.getDimemployeeCollection() == null) {
            dimemployee.setDimemployeeCollection(new ArrayList<Dimemployee>());
        }
        if (dimemployee.getFactresellersalesCollection() == null) {
            dimemployee.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimemployee parentemployeekey = dimemployee.getParentemployeekey();
            if (parentemployeekey != null) {
                parentemployeekey = em.getReference(parentemployeekey.getClass(), parentemployeekey.getEmployeekey());
                dimemployee.setParentemployeekey(parentemployeekey);
            }
            Dimsalesterritory salesterritorykey = dimemployee.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey = em.getReference(salesterritorykey.getClass(), salesterritorykey.getSalesterritorykey());
                dimemployee.setSalesterritorykey(salesterritorykey);
            }
            Collection<Factsalesquota> attachedFactsalesquotaCollection = new ArrayList<Factsalesquota>();
            for (Factsalesquota factsalesquotaCollectionFactsalesquotaToAttach : dimemployee.getFactsalesquotaCollection()) {
                factsalesquotaCollectionFactsalesquotaToAttach = em.getReference(factsalesquotaCollectionFactsalesquotaToAttach.getClass(), factsalesquotaCollectionFactsalesquotaToAttach.getSalesquotakey());
                attachedFactsalesquotaCollection.add(factsalesquotaCollectionFactsalesquotaToAttach);
            }
            dimemployee.setFactsalesquotaCollection(attachedFactsalesquotaCollection);
            Collection<Dimemployee> attachedDimemployeeCollection = new ArrayList<Dimemployee>();
            for (Dimemployee dimemployeeCollectionDimemployeeToAttach : dimemployee.getDimemployeeCollection()) {
                dimemployeeCollectionDimemployeeToAttach = em.getReference(dimemployeeCollectionDimemployeeToAttach.getClass(), dimemployeeCollectionDimemployeeToAttach.getEmployeekey());
                attachedDimemployeeCollection.add(dimemployeeCollectionDimemployeeToAttach);
            }
            dimemployee.setDimemployeeCollection(attachedDimemployeeCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimemployee.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimemployee.setFactresellersalesCollection(attachedFactresellersalesCollection);
            em.persist(dimemployee);
            if (parentemployeekey != null) {
                parentemployeekey.getDimemployeeCollection().add(dimemployee);
                parentemployeekey = em.merge(parentemployeekey);
            }
            if (salesterritorykey != null) {
                salesterritorykey.getDimemployeeCollection().add(dimemployee);
                salesterritorykey = em.merge(salesterritorykey);
            }
            for (Factsalesquota factsalesquotaCollectionFactsalesquota : dimemployee.getFactsalesquotaCollection()) {
                Dimemployee oldEmployeekeyOfFactsalesquotaCollectionFactsalesquota = factsalesquotaCollectionFactsalesquota.getEmployeekey();
                factsalesquotaCollectionFactsalesquota.setEmployeekey(dimemployee);
                factsalesquotaCollectionFactsalesquota = em.merge(factsalesquotaCollectionFactsalesquota);
                if (oldEmployeekeyOfFactsalesquotaCollectionFactsalesquota != null) {
                    oldEmployeekeyOfFactsalesquotaCollectionFactsalesquota.getFactsalesquotaCollection().remove(factsalesquotaCollectionFactsalesquota);
                    oldEmployeekeyOfFactsalesquotaCollectionFactsalesquota = em.merge(oldEmployeekeyOfFactsalesquotaCollectionFactsalesquota);
                }
            }
            for (Dimemployee dimemployeeCollectionDimemployee : dimemployee.getDimemployeeCollection()) {
                Dimemployee oldParentemployeekeyOfDimemployeeCollectionDimemployee = dimemployeeCollectionDimemployee.getParentemployeekey();
                dimemployeeCollectionDimemployee.setParentemployeekey(dimemployee);
                dimemployeeCollectionDimemployee = em.merge(dimemployeeCollectionDimemployee);
                if (oldParentemployeekeyOfDimemployeeCollectionDimemployee != null) {
                    oldParentemployeekeyOfDimemployeeCollectionDimemployee.getDimemployeeCollection().remove(dimemployeeCollectionDimemployee);
                    oldParentemployeekeyOfDimemployeeCollectionDimemployee = em.merge(oldParentemployeekeyOfDimemployeeCollectionDimemployee);
                }
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimemployee.getFactresellersalesCollection()) {
                Dimemployee oldEmployeekeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getEmployeekey();
                factresellersalesCollectionFactresellersales.setEmployeekey(dimemployee);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldEmployeekeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldEmployeekeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldEmployeekeyOfFactresellersalesCollectionFactresellersales = em.merge(oldEmployeekeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimemployee(dimemployee.getEmployeekey()) != null) {
                throw new PreexistingEntityException("Dimemployee " + dimemployee + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimemployee dimemployee) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimemployee persistentDimemployee = em.find(Dimemployee.class, dimemployee.getEmployeekey());
            Dimemployee parentemployeekeyOld = persistentDimemployee.getParentemployeekey();
            Dimemployee parentemployeekeyNew = dimemployee.getParentemployeekey();
            Dimsalesterritory salesterritorykeyOld = persistentDimemployee.getSalesterritorykey();
            Dimsalesterritory salesterritorykeyNew = dimemployee.getSalesterritorykey();
            Collection<Factsalesquota> factsalesquotaCollectionOld = persistentDimemployee.getFactsalesquotaCollection();
            Collection<Factsalesquota> factsalesquotaCollectionNew = dimemployee.getFactsalesquotaCollection();
            Collection<Dimemployee> dimemployeeCollectionOld = persistentDimemployee.getDimemployeeCollection();
            Collection<Dimemployee> dimemployeeCollectionNew = dimemployee.getDimemployeeCollection();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimemployee.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimemployee.getFactresellersalesCollection();
            List<String> illegalOrphanMessages = null;
            for (Factsalesquota factsalesquotaCollectionOldFactsalesquota : factsalesquotaCollectionOld) {
                if (!factsalesquotaCollectionNew.contains(factsalesquotaCollectionOldFactsalesquota)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factsalesquota " + factsalesquotaCollectionOldFactsalesquota + " since its employeekey field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its employeekey field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (parentemployeekeyNew != null) {
                parentemployeekeyNew = em.getReference(parentemployeekeyNew.getClass(), parentemployeekeyNew.getEmployeekey());
                dimemployee.setParentemployeekey(parentemployeekeyNew);
            }
            if (salesterritorykeyNew != null) {
                salesterritorykeyNew = em.getReference(salesterritorykeyNew.getClass(), salesterritorykeyNew.getSalesterritorykey());
                dimemployee.setSalesterritorykey(salesterritorykeyNew);
            }
            Collection<Factsalesquota> attachedFactsalesquotaCollectionNew = new ArrayList<Factsalesquota>();
            for (Factsalesquota factsalesquotaCollectionNewFactsalesquotaToAttach : factsalesquotaCollectionNew) {
                factsalesquotaCollectionNewFactsalesquotaToAttach = em.getReference(factsalesquotaCollectionNewFactsalesquotaToAttach.getClass(), factsalesquotaCollectionNewFactsalesquotaToAttach.getSalesquotakey());
                attachedFactsalesquotaCollectionNew.add(factsalesquotaCollectionNewFactsalesquotaToAttach);
            }
            factsalesquotaCollectionNew = attachedFactsalesquotaCollectionNew;
            dimemployee.setFactsalesquotaCollection(factsalesquotaCollectionNew);
            Collection<Dimemployee> attachedDimemployeeCollectionNew = new ArrayList<Dimemployee>();
            for (Dimemployee dimemployeeCollectionNewDimemployeeToAttach : dimemployeeCollectionNew) {
                dimemployeeCollectionNewDimemployeeToAttach = em.getReference(dimemployeeCollectionNewDimemployeeToAttach.getClass(), dimemployeeCollectionNewDimemployeeToAttach.getEmployeekey());
                attachedDimemployeeCollectionNew.add(dimemployeeCollectionNewDimemployeeToAttach);
            }
            dimemployeeCollectionNew = attachedDimemployeeCollectionNew;
            dimemployee.setDimemployeeCollection(dimemployeeCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimemployee.setFactresellersalesCollection(factresellersalesCollectionNew);
            dimemployee = em.merge(dimemployee);
            if (parentemployeekeyOld != null && !parentemployeekeyOld.equals(parentemployeekeyNew)) {
                parentemployeekeyOld.getDimemployeeCollection().remove(dimemployee);
                parentemployeekeyOld = em.merge(parentemployeekeyOld);
            }
            if (parentemployeekeyNew != null && !parentemployeekeyNew.equals(parentemployeekeyOld)) {
                parentemployeekeyNew.getDimemployeeCollection().add(dimemployee);
                parentemployeekeyNew = em.merge(parentemployeekeyNew);
            }
            if (salesterritorykeyOld != null && !salesterritorykeyOld.equals(salesterritorykeyNew)) {
                salesterritorykeyOld.getDimemployeeCollection().remove(dimemployee);
                salesterritorykeyOld = em.merge(salesterritorykeyOld);
            }
            if (salesterritorykeyNew != null && !salesterritorykeyNew.equals(salesterritorykeyOld)) {
                salesterritorykeyNew.getDimemployeeCollection().add(dimemployee);
                salesterritorykeyNew = em.merge(salesterritorykeyNew);
            }
            for (Factsalesquota factsalesquotaCollectionNewFactsalesquota : factsalesquotaCollectionNew) {
                if (!factsalesquotaCollectionOld.contains(factsalesquotaCollectionNewFactsalesquota)) {
                    Dimemployee oldEmployeekeyOfFactsalesquotaCollectionNewFactsalesquota = factsalesquotaCollectionNewFactsalesquota.getEmployeekey();
                    factsalesquotaCollectionNewFactsalesquota.setEmployeekey(dimemployee);
                    factsalesquotaCollectionNewFactsalesquota = em.merge(factsalesquotaCollectionNewFactsalesquota);
                    if (oldEmployeekeyOfFactsalesquotaCollectionNewFactsalesquota != null && !oldEmployeekeyOfFactsalesquotaCollectionNewFactsalesquota.equals(dimemployee)) {
                        oldEmployeekeyOfFactsalesquotaCollectionNewFactsalesquota.getFactsalesquotaCollection().remove(factsalesquotaCollectionNewFactsalesquota);
                        oldEmployeekeyOfFactsalesquotaCollectionNewFactsalesquota = em.merge(oldEmployeekeyOfFactsalesquotaCollectionNewFactsalesquota);
                    }
                }
            }
            for (Dimemployee dimemployeeCollectionOldDimemployee : dimemployeeCollectionOld) {
                if (!dimemployeeCollectionNew.contains(dimemployeeCollectionOldDimemployee)) {
                    dimemployeeCollectionOldDimemployee.setParentemployeekey(null);
                    dimemployeeCollectionOldDimemployee = em.merge(dimemployeeCollectionOldDimemployee);
                }
            }
            for (Dimemployee dimemployeeCollectionNewDimemployee : dimemployeeCollectionNew) {
                if (!dimemployeeCollectionOld.contains(dimemployeeCollectionNewDimemployee)) {
                    Dimemployee oldParentemployeekeyOfDimemployeeCollectionNewDimemployee = dimemployeeCollectionNewDimemployee.getParentemployeekey();
                    dimemployeeCollectionNewDimemployee.setParentemployeekey(dimemployee);
                    dimemployeeCollectionNewDimemployee = em.merge(dimemployeeCollectionNewDimemployee);
                    if (oldParentemployeekeyOfDimemployeeCollectionNewDimemployee != null && !oldParentemployeekeyOfDimemployeeCollectionNewDimemployee.equals(dimemployee)) {
                        oldParentemployeekeyOfDimemployeeCollectionNewDimemployee.getDimemployeeCollection().remove(dimemployeeCollectionNewDimemployee);
                        oldParentemployeekeyOfDimemployeeCollectionNewDimemployee = em.merge(oldParentemployeekeyOfDimemployeeCollectionNewDimemployee);
                    }
                }
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimemployee oldEmployeekeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getEmployeekey();
                    factresellersalesCollectionNewFactresellersales.setEmployeekey(dimemployee);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldEmployeekeyOfFactresellersalesCollectionNewFactresellersales != null && !oldEmployeekeyOfFactresellersalesCollectionNewFactresellersales.equals(dimemployee)) {
                        oldEmployeekeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldEmployeekeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldEmployeekeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimemployee.getEmployeekey();
                if (findDimemployee(id) == null) {
                    throw new NonexistentEntityException("The dimemployee with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimemployee dimemployee;
            try {
                dimemployee = em.getReference(Dimemployee.class, id);
                dimemployee.getEmployeekey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimemployee with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factsalesquota> factsalesquotaCollectionOrphanCheck = dimemployee.getFactsalesquotaCollection();
            for (Factsalesquota factsalesquotaCollectionOrphanCheckFactsalesquota : factsalesquotaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimemployee (" + dimemployee + ") cannot be destroyed since the Factsalesquota " + factsalesquotaCollectionOrphanCheckFactsalesquota + " in its factsalesquotaCollection field has a non-nullable employeekey field.");
            }
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimemployee.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimemployee (" + dimemployee + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable employeekey field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dimemployee parentemployeekey = dimemployee.getParentemployeekey();
            if (parentemployeekey != null) {
                parentemployeekey.getDimemployeeCollection().remove(dimemployee);
                parentemployeekey = em.merge(parentemployeekey);
            }
            Dimsalesterritory salesterritorykey = dimemployee.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey.getDimemployeeCollection().remove(dimemployee);
                salesterritorykey = em.merge(salesterritorykey);
            }
            Collection<Dimemployee> dimemployeeCollection = dimemployee.getDimemployeeCollection();
            for (Dimemployee dimemployeeCollectionDimemployee : dimemployeeCollection) {
                dimemployeeCollectionDimemployee.setParentemployeekey(null);
                dimemployeeCollectionDimemployee = em.merge(dimemployeeCollectionDimemployee);
            }
            em.remove(dimemployee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimemployee> findDimemployeeEntities() {
        return findDimemployeeEntities(true, -1, -1);
    }

    public List<Dimemployee> findDimemployeeEntities(int maxResults, int firstResult) {
        return findDimemployeeEntities(false, maxResults, firstResult);
    }

    private List<Dimemployee> findDimemployeeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimemployee.class));
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

    public Dimemployee findDimemployee(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimemployee.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimemployeeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimemployee> rt = cq.from(Dimemployee.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
