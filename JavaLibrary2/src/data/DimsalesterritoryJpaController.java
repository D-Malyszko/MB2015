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
public class DimsalesterritoryJpaController implements Serializable {

    public DimsalesterritoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimsalesterritory dimsalesterritory) throws PreexistingEntityException, Exception {
        if (dimsalesterritory.getFactinternetsalesCollection() == null) {
            dimsalesterritory.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        if (dimsalesterritory.getDimemployeeCollection() == null) {
            dimsalesterritory.setDimemployeeCollection(new ArrayList<Dimemployee>());
        }
        if (dimsalesterritory.getFactresellersalesCollection() == null) {
            dimsalesterritory.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        if (dimsalesterritory.getDimgeographyCollection() == null) {
            dimsalesterritory.setDimgeographyCollection(new ArrayList<Dimgeography>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimsalesterritory.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimsalesterritory.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            Collection<Dimemployee> attachedDimemployeeCollection = new ArrayList<Dimemployee>();
            for (Dimemployee dimemployeeCollectionDimemployeeToAttach : dimsalesterritory.getDimemployeeCollection()) {
                dimemployeeCollectionDimemployeeToAttach = em.getReference(dimemployeeCollectionDimemployeeToAttach.getClass(), dimemployeeCollectionDimemployeeToAttach.getEmployeekey());
                attachedDimemployeeCollection.add(dimemployeeCollectionDimemployeeToAttach);
            }
            dimsalesterritory.setDimemployeeCollection(attachedDimemployeeCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimsalesterritory.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimsalesterritory.setFactresellersalesCollection(attachedFactresellersalesCollection);
            Collection<Dimgeography> attachedDimgeographyCollection = new ArrayList<Dimgeography>();
            for (Dimgeography dimgeographyCollectionDimgeographyToAttach : dimsalesterritory.getDimgeographyCollection()) {
                dimgeographyCollectionDimgeographyToAttach = em.getReference(dimgeographyCollectionDimgeographyToAttach.getClass(), dimgeographyCollectionDimgeographyToAttach.getGeographykey());
                attachedDimgeographyCollection.add(dimgeographyCollectionDimgeographyToAttach);
            }
            dimsalesterritory.setDimgeographyCollection(attachedDimgeographyCollection);
            em.persist(dimsalesterritory);
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimsalesterritory.getFactinternetsalesCollection()) {
                Dimsalesterritory oldSalesterritorykeyOfFactinternetsalesCollectionFactinternetsales = factinternetsalesCollectionFactinternetsales.getSalesterritorykey();
                factinternetsalesCollectionFactinternetsales.setSalesterritorykey(dimsalesterritory);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
                if (oldSalesterritorykeyOfFactinternetsalesCollectionFactinternetsales != null) {
                    oldSalesterritorykeyOfFactinternetsalesCollectionFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionFactinternetsales);
                    oldSalesterritorykeyOfFactinternetsalesCollectionFactinternetsales = em.merge(oldSalesterritorykeyOfFactinternetsalesCollectionFactinternetsales);
                }
            }
            for (Dimemployee dimemployeeCollectionDimemployee : dimsalesterritory.getDimemployeeCollection()) {
                Dimsalesterritory oldSalesterritorykeyOfDimemployeeCollectionDimemployee = dimemployeeCollectionDimemployee.getSalesterritorykey();
                dimemployeeCollectionDimemployee.setSalesterritorykey(dimsalesterritory);
                dimemployeeCollectionDimemployee = em.merge(dimemployeeCollectionDimemployee);
                if (oldSalesterritorykeyOfDimemployeeCollectionDimemployee != null) {
                    oldSalesterritorykeyOfDimemployeeCollectionDimemployee.getDimemployeeCollection().remove(dimemployeeCollectionDimemployee);
                    oldSalesterritorykeyOfDimemployeeCollectionDimemployee = em.merge(oldSalesterritorykeyOfDimemployeeCollectionDimemployee);
                }
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimsalesterritory.getFactresellersalesCollection()) {
                Dimsalesterritory oldSalesterritorykeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getSalesterritorykey();
                factresellersalesCollectionFactresellersales.setSalesterritorykey(dimsalesterritory);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldSalesterritorykeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldSalesterritorykeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldSalesterritorykeyOfFactresellersalesCollectionFactresellersales = em.merge(oldSalesterritorykeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            for (Dimgeography dimgeographyCollectionDimgeography : dimsalesterritory.getDimgeographyCollection()) {
                Dimsalesterritory oldSalesterritorykeyOfDimgeographyCollectionDimgeography = dimgeographyCollectionDimgeography.getSalesterritorykey();
                dimgeographyCollectionDimgeography.setSalesterritorykey(dimsalesterritory);
                dimgeographyCollectionDimgeography = em.merge(dimgeographyCollectionDimgeography);
                if (oldSalesterritorykeyOfDimgeographyCollectionDimgeography != null) {
                    oldSalesterritorykeyOfDimgeographyCollectionDimgeography.getDimgeographyCollection().remove(dimgeographyCollectionDimgeography);
                    oldSalesterritorykeyOfDimgeographyCollectionDimgeography = em.merge(oldSalesterritorykeyOfDimgeographyCollectionDimgeography);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimsalesterritory(dimsalesterritory.getSalesterritorykey()) != null) {
                throw new PreexistingEntityException("Dimsalesterritory " + dimsalesterritory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimsalesterritory dimsalesterritory) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimsalesterritory persistentDimsalesterritory = em.find(Dimsalesterritory.class, dimsalesterritory.getSalesterritorykey());
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimsalesterritory.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimsalesterritory.getFactinternetsalesCollection();
            Collection<Dimemployee> dimemployeeCollectionOld = persistentDimsalesterritory.getDimemployeeCollection();
            Collection<Dimemployee> dimemployeeCollectionNew = dimsalesterritory.getDimemployeeCollection();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimsalesterritory.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimsalesterritory.getFactresellersalesCollection();
            Collection<Dimgeography> dimgeographyCollectionOld = persistentDimsalesterritory.getDimgeographyCollection();
            Collection<Dimgeography> dimgeographyCollectionNew = dimsalesterritory.getDimgeographyCollection();
            List<String> illegalOrphanMessages = null;
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollectionOldFactinternetsales + " since its salesterritorykey field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its salesterritorykey field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollectionNew = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsalesToAttach : factinternetsalesCollectionNew) {
                factinternetsalesCollectionNewFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionNewFactinternetsalesToAttach.getClass(), factinternetsalesCollectionNewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollectionNew.add(factinternetsalesCollectionNewFactinternetsalesToAttach);
            }
            factinternetsalesCollectionNew = attachedFactinternetsalesCollectionNew;
            dimsalesterritory.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            Collection<Dimemployee> attachedDimemployeeCollectionNew = new ArrayList<Dimemployee>();
            for (Dimemployee dimemployeeCollectionNewDimemployeeToAttach : dimemployeeCollectionNew) {
                dimemployeeCollectionNewDimemployeeToAttach = em.getReference(dimemployeeCollectionNewDimemployeeToAttach.getClass(), dimemployeeCollectionNewDimemployeeToAttach.getEmployeekey());
                attachedDimemployeeCollectionNew.add(dimemployeeCollectionNewDimemployeeToAttach);
            }
            dimemployeeCollectionNew = attachedDimemployeeCollectionNew;
            dimsalesterritory.setDimemployeeCollection(dimemployeeCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimsalesterritory.setFactresellersalesCollection(factresellersalesCollectionNew);
            Collection<Dimgeography> attachedDimgeographyCollectionNew = new ArrayList<Dimgeography>();
            for (Dimgeography dimgeographyCollectionNewDimgeographyToAttach : dimgeographyCollectionNew) {
                dimgeographyCollectionNewDimgeographyToAttach = em.getReference(dimgeographyCollectionNewDimgeographyToAttach.getClass(), dimgeographyCollectionNewDimgeographyToAttach.getGeographykey());
                attachedDimgeographyCollectionNew.add(dimgeographyCollectionNewDimgeographyToAttach);
            }
            dimgeographyCollectionNew = attachedDimgeographyCollectionNew;
            dimsalesterritory.setDimgeographyCollection(dimgeographyCollectionNew);
            dimsalesterritory = em.merge(dimsalesterritory);
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    Dimsalesterritory oldSalesterritorykeyOfFactinternetsalesCollectionNewFactinternetsales = factinternetsalesCollectionNewFactinternetsales.getSalesterritorykey();
                    factinternetsalesCollectionNewFactinternetsales.setSalesterritorykey(dimsalesterritory);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                    if (oldSalesterritorykeyOfFactinternetsalesCollectionNewFactinternetsales != null && !oldSalesterritorykeyOfFactinternetsalesCollectionNewFactinternetsales.equals(dimsalesterritory)) {
                        oldSalesterritorykeyOfFactinternetsalesCollectionNewFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionNewFactinternetsales);
                        oldSalesterritorykeyOfFactinternetsalesCollectionNewFactinternetsales = em.merge(oldSalesterritorykeyOfFactinternetsalesCollectionNewFactinternetsales);
                    }
                }
            }
            for (Dimemployee dimemployeeCollectionOldDimemployee : dimemployeeCollectionOld) {
                if (!dimemployeeCollectionNew.contains(dimemployeeCollectionOldDimemployee)) {
                    dimemployeeCollectionOldDimemployee.setSalesterritorykey(null);
                    dimemployeeCollectionOldDimemployee = em.merge(dimemployeeCollectionOldDimemployee);
                }
            }
            for (Dimemployee dimemployeeCollectionNewDimemployee : dimemployeeCollectionNew) {
                if (!dimemployeeCollectionOld.contains(dimemployeeCollectionNewDimemployee)) {
                    Dimsalesterritory oldSalesterritorykeyOfDimemployeeCollectionNewDimemployee = dimemployeeCollectionNewDimemployee.getSalesterritorykey();
                    dimemployeeCollectionNewDimemployee.setSalesterritorykey(dimsalesterritory);
                    dimemployeeCollectionNewDimemployee = em.merge(dimemployeeCollectionNewDimemployee);
                    if (oldSalesterritorykeyOfDimemployeeCollectionNewDimemployee != null && !oldSalesterritorykeyOfDimemployeeCollectionNewDimemployee.equals(dimsalesterritory)) {
                        oldSalesterritorykeyOfDimemployeeCollectionNewDimemployee.getDimemployeeCollection().remove(dimemployeeCollectionNewDimemployee);
                        oldSalesterritorykeyOfDimemployeeCollectionNewDimemployee = em.merge(oldSalesterritorykeyOfDimemployeeCollectionNewDimemployee);
                    }
                }
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimsalesterritory oldSalesterritorykeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getSalesterritorykey();
                    factresellersalesCollectionNewFactresellersales.setSalesterritorykey(dimsalesterritory);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldSalesterritorykeyOfFactresellersalesCollectionNewFactresellersales != null && !oldSalesterritorykeyOfFactresellersalesCollectionNewFactresellersales.equals(dimsalesterritory)) {
                        oldSalesterritorykeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldSalesterritorykeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldSalesterritorykeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            for (Dimgeography dimgeographyCollectionOldDimgeography : dimgeographyCollectionOld) {
                if (!dimgeographyCollectionNew.contains(dimgeographyCollectionOldDimgeography)) {
                    dimgeographyCollectionOldDimgeography.setSalesterritorykey(null);
                    dimgeographyCollectionOldDimgeography = em.merge(dimgeographyCollectionOldDimgeography);
                }
            }
            for (Dimgeography dimgeographyCollectionNewDimgeography : dimgeographyCollectionNew) {
                if (!dimgeographyCollectionOld.contains(dimgeographyCollectionNewDimgeography)) {
                    Dimsalesterritory oldSalesterritorykeyOfDimgeographyCollectionNewDimgeography = dimgeographyCollectionNewDimgeography.getSalesterritorykey();
                    dimgeographyCollectionNewDimgeography.setSalesterritorykey(dimsalesterritory);
                    dimgeographyCollectionNewDimgeography = em.merge(dimgeographyCollectionNewDimgeography);
                    if (oldSalesterritorykeyOfDimgeographyCollectionNewDimgeography != null && !oldSalesterritorykeyOfDimgeographyCollectionNewDimgeography.equals(dimsalesterritory)) {
                        oldSalesterritorykeyOfDimgeographyCollectionNewDimgeography.getDimgeographyCollection().remove(dimgeographyCollectionNewDimgeography);
                        oldSalesterritorykeyOfDimgeographyCollectionNewDimgeography = em.merge(oldSalesterritorykeyOfDimgeographyCollectionNewDimgeography);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimsalesterritory.getSalesterritorykey();
                if (findDimsalesterritory(id) == null) {
                    throw new NonexistentEntityException("The dimsalesterritory with id " + id + " no longer exists.");
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
            Dimsalesterritory dimsalesterritory;
            try {
                dimsalesterritory = em.getReference(Dimsalesterritory.class, id);
                dimsalesterritory.getSalesterritorykey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimsalesterritory with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factinternetsales> factinternetsalesCollectionOrphanCheck = dimsalesterritory.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionOrphanCheckFactinternetsales : factinternetsalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimsalesterritory (" + dimsalesterritory + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollectionOrphanCheckFactinternetsales + " in its factinternetsalesCollection field has a non-nullable salesterritorykey field.");
            }
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimsalesterritory.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimsalesterritory (" + dimsalesterritory + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable salesterritorykey field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Dimemployee> dimemployeeCollection = dimsalesterritory.getDimemployeeCollection();
            for (Dimemployee dimemployeeCollectionDimemployee : dimemployeeCollection) {
                dimemployeeCollectionDimemployee.setSalesterritorykey(null);
                dimemployeeCollectionDimemployee = em.merge(dimemployeeCollectionDimemployee);
            }
            Collection<Dimgeography> dimgeographyCollection = dimsalesterritory.getDimgeographyCollection();
            for (Dimgeography dimgeographyCollectionDimgeography : dimgeographyCollection) {
                dimgeographyCollectionDimgeography.setSalesterritorykey(null);
                dimgeographyCollectionDimgeography = em.merge(dimgeographyCollectionDimgeography);
            }
            em.remove(dimsalesterritory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimsalesterritory> findDimsalesterritoryEntities() {
        return findDimsalesterritoryEntities(true, -1, -1);
    }

    public List<Dimsalesterritory> findDimsalesterritoryEntities(int maxResults, int firstResult) {
        return findDimsalesterritoryEntities(false, maxResults, firstResult);
    }

    private List<Dimsalesterritory> findDimsalesterritoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimsalesterritory.class));
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

    public Dimsalesterritory findDimsalesterritory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimsalesterritory.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimsalesterritoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimsalesterritory> rt = cq.from(Dimsalesterritory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
