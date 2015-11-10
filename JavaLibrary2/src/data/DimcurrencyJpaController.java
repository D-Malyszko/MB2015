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
public class DimcurrencyJpaController implements Serializable {

    public DimcurrencyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimcurrency dimcurrency) throws PreexistingEntityException, Exception {
        if (dimcurrency.getFactinternetsalesCollection() == null) {
            dimcurrency.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        if (dimcurrency.getDimorganizationCollection() == null) {
            dimcurrency.setDimorganizationCollection(new ArrayList<Dimorganization>());
        }
        if (dimcurrency.getFactresellersalesCollection() == null) {
            dimcurrency.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        if (dimcurrency.getFactcurrencyrateCollection() == null) {
            dimcurrency.setFactcurrencyrateCollection(new ArrayList<Factcurrencyrate>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimcurrency.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimcurrency.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            Collection<Dimorganization> attachedDimorganizationCollection = new ArrayList<Dimorganization>();
            for (Dimorganization dimorganizationCollectionDimorganizationToAttach : dimcurrency.getDimorganizationCollection()) {
                dimorganizationCollectionDimorganizationToAttach = em.getReference(dimorganizationCollectionDimorganizationToAttach.getClass(), dimorganizationCollectionDimorganizationToAttach.getOrganizationkey());
                attachedDimorganizationCollection.add(dimorganizationCollectionDimorganizationToAttach);
            }
            dimcurrency.setDimorganizationCollection(attachedDimorganizationCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimcurrency.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimcurrency.setFactresellersalesCollection(attachedFactresellersalesCollection);
            Collection<Factcurrencyrate> attachedFactcurrencyrateCollection = new ArrayList<Factcurrencyrate>();
            for (Factcurrencyrate factcurrencyrateCollectionFactcurrencyrateToAttach : dimcurrency.getFactcurrencyrateCollection()) {
                factcurrencyrateCollectionFactcurrencyrateToAttach = em.getReference(factcurrencyrateCollectionFactcurrencyrateToAttach.getClass(), factcurrencyrateCollectionFactcurrencyrateToAttach.getFactcurrencyratePK());
                attachedFactcurrencyrateCollection.add(factcurrencyrateCollectionFactcurrencyrateToAttach);
            }
            dimcurrency.setFactcurrencyrateCollection(attachedFactcurrencyrateCollection);
            em.persist(dimcurrency);
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimcurrency.getFactinternetsalesCollection()) {
                Dimcurrency oldCurrencykeyOfFactinternetsalesCollectionFactinternetsales = factinternetsalesCollectionFactinternetsales.getCurrencykey();
                factinternetsalesCollectionFactinternetsales.setCurrencykey(dimcurrency);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
                if (oldCurrencykeyOfFactinternetsalesCollectionFactinternetsales != null) {
                    oldCurrencykeyOfFactinternetsalesCollectionFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionFactinternetsales);
                    oldCurrencykeyOfFactinternetsalesCollectionFactinternetsales = em.merge(oldCurrencykeyOfFactinternetsalesCollectionFactinternetsales);
                }
            }
            for (Dimorganization dimorganizationCollectionDimorganization : dimcurrency.getDimorganizationCollection()) {
                Dimcurrency oldCurrencykeyOfDimorganizationCollectionDimorganization = dimorganizationCollectionDimorganization.getCurrencykey();
                dimorganizationCollectionDimorganization.setCurrencykey(dimcurrency);
                dimorganizationCollectionDimorganization = em.merge(dimorganizationCollectionDimorganization);
                if (oldCurrencykeyOfDimorganizationCollectionDimorganization != null) {
                    oldCurrencykeyOfDimorganizationCollectionDimorganization.getDimorganizationCollection().remove(dimorganizationCollectionDimorganization);
                    oldCurrencykeyOfDimorganizationCollectionDimorganization = em.merge(oldCurrencykeyOfDimorganizationCollectionDimorganization);
                }
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimcurrency.getFactresellersalesCollection()) {
                Dimcurrency oldCurrencykeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getCurrencykey();
                factresellersalesCollectionFactresellersales.setCurrencykey(dimcurrency);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldCurrencykeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldCurrencykeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldCurrencykeyOfFactresellersalesCollectionFactresellersales = em.merge(oldCurrencykeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            for (Factcurrencyrate factcurrencyrateCollectionFactcurrencyrate : dimcurrency.getFactcurrencyrateCollection()) {
                Dimcurrency oldDimcurrencyOfFactcurrencyrateCollectionFactcurrencyrate = factcurrencyrateCollectionFactcurrencyrate.getDimcurrency();
                factcurrencyrateCollectionFactcurrencyrate.setDimcurrency(dimcurrency);
                factcurrencyrateCollectionFactcurrencyrate = em.merge(factcurrencyrateCollectionFactcurrencyrate);
                if (oldDimcurrencyOfFactcurrencyrateCollectionFactcurrencyrate != null) {
                    oldDimcurrencyOfFactcurrencyrateCollectionFactcurrencyrate.getFactcurrencyrateCollection().remove(factcurrencyrateCollectionFactcurrencyrate);
                    oldDimcurrencyOfFactcurrencyrateCollectionFactcurrencyrate = em.merge(oldDimcurrencyOfFactcurrencyrateCollectionFactcurrencyrate);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimcurrency(dimcurrency.getCurrencykey()) != null) {
                throw new PreexistingEntityException("Dimcurrency " + dimcurrency + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimcurrency dimcurrency) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcurrency persistentDimcurrency = em.find(Dimcurrency.class, dimcurrency.getCurrencykey());
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimcurrency.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimcurrency.getFactinternetsalesCollection();
            Collection<Dimorganization> dimorganizationCollectionOld = persistentDimcurrency.getDimorganizationCollection();
            Collection<Dimorganization> dimorganizationCollectionNew = dimcurrency.getDimorganizationCollection();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimcurrency.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimcurrency.getFactresellersalesCollection();
            Collection<Factcurrencyrate> factcurrencyrateCollectionOld = persistentDimcurrency.getFactcurrencyrateCollection();
            Collection<Factcurrencyrate> factcurrencyrateCollectionNew = dimcurrency.getFactcurrencyrateCollection();
            List<String> illegalOrphanMessages = null;
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollectionOldFactinternetsales + " since its currencykey field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its currencykey field is not nullable.");
                }
            }
            for (Factcurrencyrate factcurrencyrateCollectionOldFactcurrencyrate : factcurrencyrateCollectionOld) {
                if (!factcurrencyrateCollectionNew.contains(factcurrencyrateCollectionOldFactcurrencyrate)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factcurrencyrate " + factcurrencyrateCollectionOldFactcurrencyrate + " since its dimcurrency field is not nullable.");
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
            dimcurrency.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            Collection<Dimorganization> attachedDimorganizationCollectionNew = new ArrayList<Dimorganization>();
            for (Dimorganization dimorganizationCollectionNewDimorganizationToAttach : dimorganizationCollectionNew) {
                dimorganizationCollectionNewDimorganizationToAttach = em.getReference(dimorganizationCollectionNewDimorganizationToAttach.getClass(), dimorganizationCollectionNewDimorganizationToAttach.getOrganizationkey());
                attachedDimorganizationCollectionNew.add(dimorganizationCollectionNewDimorganizationToAttach);
            }
            dimorganizationCollectionNew = attachedDimorganizationCollectionNew;
            dimcurrency.setDimorganizationCollection(dimorganizationCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimcurrency.setFactresellersalesCollection(factresellersalesCollectionNew);
            Collection<Factcurrencyrate> attachedFactcurrencyrateCollectionNew = new ArrayList<Factcurrencyrate>();
            for (Factcurrencyrate factcurrencyrateCollectionNewFactcurrencyrateToAttach : factcurrencyrateCollectionNew) {
                factcurrencyrateCollectionNewFactcurrencyrateToAttach = em.getReference(factcurrencyrateCollectionNewFactcurrencyrateToAttach.getClass(), factcurrencyrateCollectionNewFactcurrencyrateToAttach.getFactcurrencyratePK());
                attachedFactcurrencyrateCollectionNew.add(factcurrencyrateCollectionNewFactcurrencyrateToAttach);
            }
            factcurrencyrateCollectionNew = attachedFactcurrencyrateCollectionNew;
            dimcurrency.setFactcurrencyrateCollection(factcurrencyrateCollectionNew);
            dimcurrency = em.merge(dimcurrency);
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    Dimcurrency oldCurrencykeyOfFactinternetsalesCollectionNewFactinternetsales = factinternetsalesCollectionNewFactinternetsales.getCurrencykey();
                    factinternetsalesCollectionNewFactinternetsales.setCurrencykey(dimcurrency);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                    if (oldCurrencykeyOfFactinternetsalesCollectionNewFactinternetsales != null && !oldCurrencykeyOfFactinternetsalesCollectionNewFactinternetsales.equals(dimcurrency)) {
                        oldCurrencykeyOfFactinternetsalesCollectionNewFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionNewFactinternetsales);
                        oldCurrencykeyOfFactinternetsalesCollectionNewFactinternetsales = em.merge(oldCurrencykeyOfFactinternetsalesCollectionNewFactinternetsales);
                    }
                }
            }
            for (Dimorganization dimorganizationCollectionOldDimorganization : dimorganizationCollectionOld) {
                if (!dimorganizationCollectionNew.contains(dimorganizationCollectionOldDimorganization)) {
                    dimorganizationCollectionOldDimorganization.setCurrencykey(null);
                    dimorganizationCollectionOldDimorganization = em.merge(dimorganizationCollectionOldDimorganization);
                }
            }
            for (Dimorganization dimorganizationCollectionNewDimorganization : dimorganizationCollectionNew) {
                if (!dimorganizationCollectionOld.contains(dimorganizationCollectionNewDimorganization)) {
                    Dimcurrency oldCurrencykeyOfDimorganizationCollectionNewDimorganization = dimorganizationCollectionNewDimorganization.getCurrencykey();
                    dimorganizationCollectionNewDimorganization.setCurrencykey(dimcurrency);
                    dimorganizationCollectionNewDimorganization = em.merge(dimorganizationCollectionNewDimorganization);
                    if (oldCurrencykeyOfDimorganizationCollectionNewDimorganization != null && !oldCurrencykeyOfDimorganizationCollectionNewDimorganization.equals(dimcurrency)) {
                        oldCurrencykeyOfDimorganizationCollectionNewDimorganization.getDimorganizationCollection().remove(dimorganizationCollectionNewDimorganization);
                        oldCurrencykeyOfDimorganizationCollectionNewDimorganization = em.merge(oldCurrencykeyOfDimorganizationCollectionNewDimorganization);
                    }
                }
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimcurrency oldCurrencykeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getCurrencykey();
                    factresellersalesCollectionNewFactresellersales.setCurrencykey(dimcurrency);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldCurrencykeyOfFactresellersalesCollectionNewFactresellersales != null && !oldCurrencykeyOfFactresellersalesCollectionNewFactresellersales.equals(dimcurrency)) {
                        oldCurrencykeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldCurrencykeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldCurrencykeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            for (Factcurrencyrate factcurrencyrateCollectionNewFactcurrencyrate : factcurrencyrateCollectionNew) {
                if (!factcurrencyrateCollectionOld.contains(factcurrencyrateCollectionNewFactcurrencyrate)) {
                    Dimcurrency oldDimcurrencyOfFactcurrencyrateCollectionNewFactcurrencyrate = factcurrencyrateCollectionNewFactcurrencyrate.getDimcurrency();
                    factcurrencyrateCollectionNewFactcurrencyrate.setDimcurrency(dimcurrency);
                    factcurrencyrateCollectionNewFactcurrencyrate = em.merge(factcurrencyrateCollectionNewFactcurrencyrate);
                    if (oldDimcurrencyOfFactcurrencyrateCollectionNewFactcurrencyrate != null && !oldDimcurrencyOfFactcurrencyrateCollectionNewFactcurrencyrate.equals(dimcurrency)) {
                        oldDimcurrencyOfFactcurrencyrateCollectionNewFactcurrencyrate.getFactcurrencyrateCollection().remove(factcurrencyrateCollectionNewFactcurrencyrate);
                        oldDimcurrencyOfFactcurrencyrateCollectionNewFactcurrencyrate = em.merge(oldDimcurrencyOfFactcurrencyrateCollectionNewFactcurrencyrate);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimcurrency.getCurrencykey();
                if (findDimcurrency(id) == null) {
                    throw new NonexistentEntityException("The dimcurrency with id " + id + " no longer exists.");
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
            Dimcurrency dimcurrency;
            try {
                dimcurrency = em.getReference(Dimcurrency.class, id);
                dimcurrency.getCurrencykey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimcurrency with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factinternetsales> factinternetsalesCollectionOrphanCheck = dimcurrency.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionOrphanCheckFactinternetsales : factinternetsalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimcurrency (" + dimcurrency + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollectionOrphanCheckFactinternetsales + " in its factinternetsalesCollection field has a non-nullable currencykey field.");
            }
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimcurrency.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimcurrency (" + dimcurrency + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable currencykey field.");
            }
            Collection<Factcurrencyrate> factcurrencyrateCollectionOrphanCheck = dimcurrency.getFactcurrencyrateCollection();
            for (Factcurrencyrate factcurrencyrateCollectionOrphanCheckFactcurrencyrate : factcurrencyrateCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimcurrency (" + dimcurrency + ") cannot be destroyed since the Factcurrencyrate " + factcurrencyrateCollectionOrphanCheckFactcurrencyrate + " in its factcurrencyrateCollection field has a non-nullable dimcurrency field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Dimorganization> dimorganizationCollection = dimcurrency.getDimorganizationCollection();
            for (Dimorganization dimorganizationCollectionDimorganization : dimorganizationCollection) {
                dimorganizationCollectionDimorganization.setCurrencykey(null);
                dimorganizationCollectionDimorganization = em.merge(dimorganizationCollectionDimorganization);
            }
            em.remove(dimcurrency);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimcurrency> findDimcurrencyEntities() {
        return findDimcurrencyEntities(true, -1, -1);
    }

    public List<Dimcurrency> findDimcurrencyEntities(int maxResults, int firstResult) {
        return findDimcurrencyEntities(false, maxResults, firstResult);
    }

    private List<Dimcurrency> findDimcurrencyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimcurrency.class));
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

    public Dimcurrency findDimcurrency(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimcurrency.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimcurrencyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimcurrency> rt = cq.from(Dimcurrency.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
