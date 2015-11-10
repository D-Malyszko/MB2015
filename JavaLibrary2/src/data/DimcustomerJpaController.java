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
public class DimcustomerJpaController implements Serializable {

    public DimcustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimcustomer dimcustomer) throws PreexistingEntityException, Exception {
        if (dimcustomer.getFactinternetsalesCollection() == null) {
            dimcustomer.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        if (dimcustomer.getFactsurveyresponseCollection() == null) {
            dimcustomer.setFactsurveyresponseCollection(new ArrayList<Factsurveyresponse>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimgeography geographykey = dimcustomer.getGeographykey();
            if (geographykey != null) {
                geographykey = em.getReference(geographykey.getClass(), geographykey.getGeographykey());
                dimcustomer.setGeographykey(geographykey);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimcustomer.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimcustomer.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            Collection<Factsurveyresponse> attachedFactsurveyresponseCollection = new ArrayList<Factsurveyresponse>();
            for (Factsurveyresponse factsurveyresponseCollectionFactsurveyresponseToAttach : dimcustomer.getFactsurveyresponseCollection()) {
                factsurveyresponseCollectionFactsurveyresponseToAttach = em.getReference(factsurveyresponseCollectionFactsurveyresponseToAttach.getClass(), factsurveyresponseCollectionFactsurveyresponseToAttach.getSurveyresponsekey());
                attachedFactsurveyresponseCollection.add(factsurveyresponseCollectionFactsurveyresponseToAttach);
            }
            dimcustomer.setFactsurveyresponseCollection(attachedFactsurveyresponseCollection);
            em.persist(dimcustomer);
            if (geographykey != null) {
                geographykey.getDimcustomerCollection().add(dimcustomer);
                geographykey = em.merge(geographykey);
            }
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimcustomer.getFactinternetsalesCollection()) {
                Dimcustomer oldCustomerkeyOfFactinternetsalesCollectionFactinternetsales = factinternetsalesCollectionFactinternetsales.getCustomerkey();
                factinternetsalesCollectionFactinternetsales.setCustomerkey(dimcustomer);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
                if (oldCustomerkeyOfFactinternetsalesCollectionFactinternetsales != null) {
                    oldCustomerkeyOfFactinternetsalesCollectionFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionFactinternetsales);
                    oldCustomerkeyOfFactinternetsalesCollectionFactinternetsales = em.merge(oldCustomerkeyOfFactinternetsalesCollectionFactinternetsales);
                }
            }
            for (Factsurveyresponse factsurveyresponseCollectionFactsurveyresponse : dimcustomer.getFactsurveyresponseCollection()) {
                Dimcustomer oldCustomerkeyOfFactsurveyresponseCollectionFactsurveyresponse = factsurveyresponseCollectionFactsurveyresponse.getCustomerkey();
                factsurveyresponseCollectionFactsurveyresponse.setCustomerkey(dimcustomer);
                factsurveyresponseCollectionFactsurveyresponse = em.merge(factsurveyresponseCollectionFactsurveyresponse);
                if (oldCustomerkeyOfFactsurveyresponseCollectionFactsurveyresponse != null) {
                    oldCustomerkeyOfFactsurveyresponseCollectionFactsurveyresponse.getFactsurveyresponseCollection().remove(factsurveyresponseCollectionFactsurveyresponse);
                    oldCustomerkeyOfFactsurveyresponseCollectionFactsurveyresponse = em.merge(oldCustomerkeyOfFactsurveyresponseCollectionFactsurveyresponse);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimcustomer(dimcustomer.getCustomerkey()) != null) {
                throw new PreexistingEntityException("Dimcustomer " + dimcustomer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimcustomer dimcustomer) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcustomer persistentDimcustomer = em.find(Dimcustomer.class, dimcustomer.getCustomerkey());
            Dimgeography geographykeyOld = persistentDimcustomer.getGeographykey();
            Dimgeography geographykeyNew = dimcustomer.getGeographykey();
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimcustomer.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimcustomer.getFactinternetsalesCollection();
            Collection<Factsurveyresponse> factsurveyresponseCollectionOld = persistentDimcustomer.getFactsurveyresponseCollection();
            Collection<Factsurveyresponse> factsurveyresponseCollectionNew = dimcustomer.getFactsurveyresponseCollection();
            List<String> illegalOrphanMessages = null;
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollectionOldFactinternetsales + " since its customerkey field is not nullable.");
                }
            }
            for (Factsurveyresponse factsurveyresponseCollectionOldFactsurveyresponse : factsurveyresponseCollectionOld) {
                if (!factsurveyresponseCollectionNew.contains(factsurveyresponseCollectionOldFactsurveyresponse)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factsurveyresponse " + factsurveyresponseCollectionOldFactsurveyresponse + " since its customerkey field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (geographykeyNew != null) {
                geographykeyNew = em.getReference(geographykeyNew.getClass(), geographykeyNew.getGeographykey());
                dimcustomer.setGeographykey(geographykeyNew);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollectionNew = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsalesToAttach : factinternetsalesCollectionNew) {
                factinternetsalesCollectionNewFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionNewFactinternetsalesToAttach.getClass(), factinternetsalesCollectionNewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollectionNew.add(factinternetsalesCollectionNewFactinternetsalesToAttach);
            }
            factinternetsalesCollectionNew = attachedFactinternetsalesCollectionNew;
            dimcustomer.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            Collection<Factsurveyresponse> attachedFactsurveyresponseCollectionNew = new ArrayList<Factsurveyresponse>();
            for (Factsurveyresponse factsurveyresponseCollectionNewFactsurveyresponseToAttach : factsurveyresponseCollectionNew) {
                factsurveyresponseCollectionNewFactsurveyresponseToAttach = em.getReference(factsurveyresponseCollectionNewFactsurveyresponseToAttach.getClass(), factsurveyresponseCollectionNewFactsurveyresponseToAttach.getSurveyresponsekey());
                attachedFactsurveyresponseCollectionNew.add(factsurveyresponseCollectionNewFactsurveyresponseToAttach);
            }
            factsurveyresponseCollectionNew = attachedFactsurveyresponseCollectionNew;
            dimcustomer.setFactsurveyresponseCollection(factsurveyresponseCollectionNew);
            dimcustomer = em.merge(dimcustomer);
            if (geographykeyOld != null && !geographykeyOld.equals(geographykeyNew)) {
                geographykeyOld.getDimcustomerCollection().remove(dimcustomer);
                geographykeyOld = em.merge(geographykeyOld);
            }
            if (geographykeyNew != null && !geographykeyNew.equals(geographykeyOld)) {
                geographykeyNew.getDimcustomerCollection().add(dimcustomer);
                geographykeyNew = em.merge(geographykeyNew);
            }
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    Dimcustomer oldCustomerkeyOfFactinternetsalesCollectionNewFactinternetsales = factinternetsalesCollectionNewFactinternetsales.getCustomerkey();
                    factinternetsalesCollectionNewFactinternetsales.setCustomerkey(dimcustomer);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                    if (oldCustomerkeyOfFactinternetsalesCollectionNewFactinternetsales != null && !oldCustomerkeyOfFactinternetsalesCollectionNewFactinternetsales.equals(dimcustomer)) {
                        oldCustomerkeyOfFactinternetsalesCollectionNewFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionNewFactinternetsales);
                        oldCustomerkeyOfFactinternetsalesCollectionNewFactinternetsales = em.merge(oldCustomerkeyOfFactinternetsalesCollectionNewFactinternetsales);
                    }
                }
            }
            for (Factsurveyresponse factsurveyresponseCollectionNewFactsurveyresponse : factsurveyresponseCollectionNew) {
                if (!factsurveyresponseCollectionOld.contains(factsurveyresponseCollectionNewFactsurveyresponse)) {
                    Dimcustomer oldCustomerkeyOfFactsurveyresponseCollectionNewFactsurveyresponse = factsurveyresponseCollectionNewFactsurveyresponse.getCustomerkey();
                    factsurveyresponseCollectionNewFactsurveyresponse.setCustomerkey(dimcustomer);
                    factsurveyresponseCollectionNewFactsurveyresponse = em.merge(factsurveyresponseCollectionNewFactsurveyresponse);
                    if (oldCustomerkeyOfFactsurveyresponseCollectionNewFactsurveyresponse != null && !oldCustomerkeyOfFactsurveyresponseCollectionNewFactsurveyresponse.equals(dimcustomer)) {
                        oldCustomerkeyOfFactsurveyresponseCollectionNewFactsurveyresponse.getFactsurveyresponseCollection().remove(factsurveyresponseCollectionNewFactsurveyresponse);
                        oldCustomerkeyOfFactsurveyresponseCollectionNewFactsurveyresponse = em.merge(oldCustomerkeyOfFactsurveyresponseCollectionNewFactsurveyresponse);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimcustomer.getCustomerkey();
                if (findDimcustomer(id) == null) {
                    throw new NonexistentEntityException("The dimcustomer with id " + id + " no longer exists.");
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
            Dimcustomer dimcustomer;
            try {
                dimcustomer = em.getReference(Dimcustomer.class, id);
                dimcustomer.getCustomerkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimcustomer with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factinternetsales> factinternetsalesCollectionOrphanCheck = dimcustomer.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionOrphanCheckFactinternetsales : factinternetsalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimcustomer (" + dimcustomer + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollectionOrphanCheckFactinternetsales + " in its factinternetsalesCollection field has a non-nullable customerkey field.");
            }
            Collection<Factsurveyresponse> factsurveyresponseCollectionOrphanCheck = dimcustomer.getFactsurveyresponseCollection();
            for (Factsurveyresponse factsurveyresponseCollectionOrphanCheckFactsurveyresponse : factsurveyresponseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimcustomer (" + dimcustomer + ") cannot be destroyed since the Factsurveyresponse " + factsurveyresponseCollectionOrphanCheckFactsurveyresponse + " in its factsurveyresponseCollection field has a non-nullable customerkey field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dimgeography geographykey = dimcustomer.getGeographykey();
            if (geographykey != null) {
                geographykey.getDimcustomerCollection().remove(dimcustomer);
                geographykey = em.merge(geographykey);
            }
            em.remove(dimcustomer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimcustomer> findDimcustomerEntities() {
        return findDimcustomerEntities(true, -1, -1);
    }

    public List<Dimcustomer> findDimcustomerEntities(int maxResults, int firstResult) {
        return findDimcustomerEntities(false, maxResults, firstResult);
    }

    private List<Dimcustomer> findDimcustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimcustomer.class));
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

    public Dimcustomer findDimcustomer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimcustomer.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimcustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimcustomer> rt = cq.from(Dimcustomer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
