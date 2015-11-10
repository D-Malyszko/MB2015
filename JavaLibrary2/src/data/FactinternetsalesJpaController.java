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
public class FactinternetsalesJpaController implements Serializable {

    public FactinternetsalesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factinternetsales factinternetsales) throws PreexistingEntityException, Exception {
        if (factinternetsales.getFactinternetsalesPK() == null) {
            factinternetsales.setFactinternetsalesPK(new FactinternetsalesPK());
        }
        if (factinternetsales.getDimsalesreasonCollection() == null) {
            factinternetsales.setDimsalesreasonCollection(new ArrayList<Dimsalesreason>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcurrency currencykey = factinternetsales.getCurrencykey();
            if (currencykey != null) {
                currencykey = em.getReference(currencykey.getClass(), currencykey.getCurrencykey());
                factinternetsales.setCurrencykey(currencykey);
            }
            Dimcustomer customerkey = factinternetsales.getCustomerkey();
            if (customerkey != null) {
                customerkey = em.getReference(customerkey.getClass(), customerkey.getCustomerkey());
                factinternetsales.setCustomerkey(customerkey);
            }
            Dimdate shipdatekey = factinternetsales.getShipdatekey();
            if (shipdatekey != null) {
                shipdatekey = em.getReference(shipdatekey.getClass(), shipdatekey.getDatekey());
                factinternetsales.setShipdatekey(shipdatekey);
            }
            Dimdate orderdatekey = factinternetsales.getOrderdatekey();
            if (orderdatekey != null) {
                orderdatekey = em.getReference(orderdatekey.getClass(), orderdatekey.getDatekey());
                factinternetsales.setOrderdatekey(orderdatekey);
            }
            Dimdate duedatekey = factinternetsales.getDuedatekey();
            if (duedatekey != null) {
                duedatekey = em.getReference(duedatekey.getClass(), duedatekey.getDatekey());
                factinternetsales.setDuedatekey(duedatekey);
            }
            Dimproduct productkey = factinternetsales.getProductkey();
            if (productkey != null) {
                productkey = em.getReference(productkey.getClass(), productkey.getProductkey());
                factinternetsales.setProductkey(productkey);
            }
            Dimpromotion promotionkey = factinternetsales.getPromotionkey();
            if (promotionkey != null) {
                promotionkey = em.getReference(promotionkey.getClass(), promotionkey.getPromotionkey());
                factinternetsales.setPromotionkey(promotionkey);
            }
            Dimsalesterritory salesterritorykey = factinternetsales.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey = em.getReference(salesterritorykey.getClass(), salesterritorykey.getSalesterritorykey());
                factinternetsales.setSalesterritorykey(salesterritorykey);
            }
            Collection<Dimsalesreason> attachedDimsalesreasonCollection = new ArrayList<Dimsalesreason>();
            for (Dimsalesreason dimsalesreasonCollectionDimsalesreasonToAttach : factinternetsales.getDimsalesreasonCollection()) {
                dimsalesreasonCollectionDimsalesreasonToAttach = em.getReference(dimsalesreasonCollectionDimsalesreasonToAttach.getClass(), dimsalesreasonCollectionDimsalesreasonToAttach.getSalesreasonkey());
                attachedDimsalesreasonCollection.add(dimsalesreasonCollectionDimsalesreasonToAttach);
            }
            factinternetsales.setDimsalesreasonCollection(attachedDimsalesreasonCollection);
            em.persist(factinternetsales);
            if (currencykey != null) {
                currencykey.getFactinternetsalesCollection().add(factinternetsales);
                currencykey = em.merge(currencykey);
            }
            if (customerkey != null) {
                customerkey.getFactinternetsalesCollection().add(factinternetsales);
                customerkey = em.merge(customerkey);
            }
            if (shipdatekey != null) {
                shipdatekey.getFactinternetsalesCollection().add(factinternetsales);
                shipdatekey = em.merge(shipdatekey);
            }
            if (orderdatekey != null) {
                orderdatekey.getFactinternetsalesCollection().add(factinternetsales);
                orderdatekey = em.merge(orderdatekey);
            }
            if (duedatekey != null) {
                duedatekey.getFactinternetsalesCollection().add(factinternetsales);
                duedatekey = em.merge(duedatekey);
            }
            if (productkey != null) {
                productkey.getFactinternetsalesCollection().add(factinternetsales);
                productkey = em.merge(productkey);
            }
            if (promotionkey != null) {
                promotionkey.getFactinternetsalesCollection().add(factinternetsales);
                promotionkey = em.merge(promotionkey);
            }
            if (salesterritorykey != null) {
                salesterritorykey.getFactinternetsalesCollection().add(factinternetsales);
                salesterritorykey = em.merge(salesterritorykey);
            }
            for (Dimsalesreason dimsalesreasonCollectionDimsalesreason : factinternetsales.getDimsalesreasonCollection()) {
                dimsalesreasonCollectionDimsalesreason.getFactinternetsalesCollection().add(factinternetsales);
                dimsalesreasonCollectionDimsalesreason = em.merge(dimsalesreasonCollectionDimsalesreason);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactinternetsales(factinternetsales.getFactinternetsalesPK()) != null) {
                throw new PreexistingEntityException("Factinternetsales " + factinternetsales + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factinternetsales factinternetsales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factinternetsales persistentFactinternetsales = em.find(Factinternetsales.class, factinternetsales.getFactinternetsalesPK());
            Dimcurrency currencykeyOld = persistentFactinternetsales.getCurrencykey();
            Dimcurrency currencykeyNew = factinternetsales.getCurrencykey();
            Dimcustomer customerkeyOld = persistentFactinternetsales.getCustomerkey();
            Dimcustomer customerkeyNew = factinternetsales.getCustomerkey();
            Dimdate shipdatekeyOld = persistentFactinternetsales.getShipdatekey();
            Dimdate shipdatekeyNew = factinternetsales.getShipdatekey();
            Dimdate orderdatekeyOld = persistentFactinternetsales.getOrderdatekey();
            Dimdate orderdatekeyNew = factinternetsales.getOrderdatekey();
            Dimdate duedatekeyOld = persistentFactinternetsales.getDuedatekey();
            Dimdate duedatekeyNew = factinternetsales.getDuedatekey();
            Dimproduct productkeyOld = persistentFactinternetsales.getProductkey();
            Dimproduct productkeyNew = factinternetsales.getProductkey();
            Dimpromotion promotionkeyOld = persistentFactinternetsales.getPromotionkey();
            Dimpromotion promotionkeyNew = factinternetsales.getPromotionkey();
            Dimsalesterritory salesterritorykeyOld = persistentFactinternetsales.getSalesterritorykey();
            Dimsalesterritory salesterritorykeyNew = factinternetsales.getSalesterritorykey();
            Collection<Dimsalesreason> dimsalesreasonCollectionOld = persistentFactinternetsales.getDimsalesreasonCollection();
            Collection<Dimsalesreason> dimsalesreasonCollectionNew = factinternetsales.getDimsalesreasonCollection();
            if (currencykeyNew != null) {
                currencykeyNew = em.getReference(currencykeyNew.getClass(), currencykeyNew.getCurrencykey());
                factinternetsales.setCurrencykey(currencykeyNew);
            }
            if (customerkeyNew != null) {
                customerkeyNew = em.getReference(customerkeyNew.getClass(), customerkeyNew.getCustomerkey());
                factinternetsales.setCustomerkey(customerkeyNew);
            }
            if (shipdatekeyNew != null) {
                shipdatekeyNew = em.getReference(shipdatekeyNew.getClass(), shipdatekeyNew.getDatekey());
                factinternetsales.setShipdatekey(shipdatekeyNew);
            }
            if (orderdatekeyNew != null) {
                orderdatekeyNew = em.getReference(orderdatekeyNew.getClass(), orderdatekeyNew.getDatekey());
                factinternetsales.setOrderdatekey(orderdatekeyNew);
            }
            if (duedatekeyNew != null) {
                duedatekeyNew = em.getReference(duedatekeyNew.getClass(), duedatekeyNew.getDatekey());
                factinternetsales.setDuedatekey(duedatekeyNew);
            }
            if (productkeyNew != null) {
                productkeyNew = em.getReference(productkeyNew.getClass(), productkeyNew.getProductkey());
                factinternetsales.setProductkey(productkeyNew);
            }
            if (promotionkeyNew != null) {
                promotionkeyNew = em.getReference(promotionkeyNew.getClass(), promotionkeyNew.getPromotionkey());
                factinternetsales.setPromotionkey(promotionkeyNew);
            }
            if (salesterritorykeyNew != null) {
                salesterritorykeyNew = em.getReference(salesterritorykeyNew.getClass(), salesterritorykeyNew.getSalesterritorykey());
                factinternetsales.setSalesterritorykey(salesterritorykeyNew);
            }
            Collection<Dimsalesreason> attachedDimsalesreasonCollectionNew = new ArrayList<Dimsalesreason>();
            for (Dimsalesreason dimsalesreasonCollectionNewDimsalesreasonToAttach : dimsalesreasonCollectionNew) {
                dimsalesreasonCollectionNewDimsalesreasonToAttach = em.getReference(dimsalesreasonCollectionNewDimsalesreasonToAttach.getClass(), dimsalesreasonCollectionNewDimsalesreasonToAttach.getSalesreasonkey());
                attachedDimsalesreasonCollectionNew.add(dimsalesreasonCollectionNewDimsalesreasonToAttach);
            }
            dimsalesreasonCollectionNew = attachedDimsalesreasonCollectionNew;
            factinternetsales.setDimsalesreasonCollection(dimsalesreasonCollectionNew);
            factinternetsales = em.merge(factinternetsales);
            if (currencykeyOld != null && !currencykeyOld.equals(currencykeyNew)) {
                currencykeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                currencykeyOld = em.merge(currencykeyOld);
            }
            if (currencykeyNew != null && !currencykeyNew.equals(currencykeyOld)) {
                currencykeyNew.getFactinternetsalesCollection().add(factinternetsales);
                currencykeyNew = em.merge(currencykeyNew);
            }
            if (customerkeyOld != null && !customerkeyOld.equals(customerkeyNew)) {
                customerkeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                customerkeyOld = em.merge(customerkeyOld);
            }
            if (customerkeyNew != null && !customerkeyNew.equals(customerkeyOld)) {
                customerkeyNew.getFactinternetsalesCollection().add(factinternetsales);
                customerkeyNew = em.merge(customerkeyNew);
            }
            if (shipdatekeyOld != null && !shipdatekeyOld.equals(shipdatekeyNew)) {
                shipdatekeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                shipdatekeyOld = em.merge(shipdatekeyOld);
            }
            if (shipdatekeyNew != null && !shipdatekeyNew.equals(shipdatekeyOld)) {
                shipdatekeyNew.getFactinternetsalesCollection().add(factinternetsales);
                shipdatekeyNew = em.merge(shipdatekeyNew);
            }
            if (orderdatekeyOld != null && !orderdatekeyOld.equals(orderdatekeyNew)) {
                orderdatekeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                orderdatekeyOld = em.merge(orderdatekeyOld);
            }
            if (orderdatekeyNew != null && !orderdatekeyNew.equals(orderdatekeyOld)) {
                orderdatekeyNew.getFactinternetsalesCollection().add(factinternetsales);
                orderdatekeyNew = em.merge(orderdatekeyNew);
            }
            if (duedatekeyOld != null && !duedatekeyOld.equals(duedatekeyNew)) {
                duedatekeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                duedatekeyOld = em.merge(duedatekeyOld);
            }
            if (duedatekeyNew != null && !duedatekeyNew.equals(duedatekeyOld)) {
                duedatekeyNew.getFactinternetsalesCollection().add(factinternetsales);
                duedatekeyNew = em.merge(duedatekeyNew);
            }
            if (productkeyOld != null && !productkeyOld.equals(productkeyNew)) {
                productkeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                productkeyOld = em.merge(productkeyOld);
            }
            if (productkeyNew != null && !productkeyNew.equals(productkeyOld)) {
                productkeyNew.getFactinternetsalesCollection().add(factinternetsales);
                productkeyNew = em.merge(productkeyNew);
            }
            if (promotionkeyOld != null && !promotionkeyOld.equals(promotionkeyNew)) {
                promotionkeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                promotionkeyOld = em.merge(promotionkeyOld);
            }
            if (promotionkeyNew != null && !promotionkeyNew.equals(promotionkeyOld)) {
                promotionkeyNew.getFactinternetsalesCollection().add(factinternetsales);
                promotionkeyNew = em.merge(promotionkeyNew);
            }
            if (salesterritorykeyOld != null && !salesterritorykeyOld.equals(salesterritorykeyNew)) {
                salesterritorykeyOld.getFactinternetsalesCollection().remove(factinternetsales);
                salesterritorykeyOld = em.merge(salesterritorykeyOld);
            }
            if (salesterritorykeyNew != null && !salesterritorykeyNew.equals(salesterritorykeyOld)) {
                salesterritorykeyNew.getFactinternetsalesCollection().add(factinternetsales);
                salesterritorykeyNew = em.merge(salesterritorykeyNew);
            }
            for (Dimsalesreason dimsalesreasonCollectionOldDimsalesreason : dimsalesreasonCollectionOld) {
                if (!dimsalesreasonCollectionNew.contains(dimsalesreasonCollectionOldDimsalesreason)) {
                    dimsalesreasonCollectionOldDimsalesreason.getFactinternetsalesCollection().remove(factinternetsales);
                    dimsalesreasonCollectionOldDimsalesreason = em.merge(dimsalesreasonCollectionOldDimsalesreason);
                }
            }
            for (Dimsalesreason dimsalesreasonCollectionNewDimsalesreason : dimsalesreasonCollectionNew) {
                if (!dimsalesreasonCollectionOld.contains(dimsalesreasonCollectionNewDimsalesreason)) {
                    dimsalesreasonCollectionNewDimsalesreason.getFactinternetsalesCollection().add(factinternetsales);
                    dimsalesreasonCollectionNewDimsalesreason = em.merge(dimsalesreasonCollectionNewDimsalesreason);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                FactinternetsalesPK id = factinternetsales.getFactinternetsalesPK();
                if (findFactinternetsales(id) == null) {
                    throw new NonexistentEntityException("The factinternetsales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(FactinternetsalesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factinternetsales factinternetsales;
            try {
                factinternetsales = em.getReference(Factinternetsales.class, id);
                factinternetsales.getFactinternetsalesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factinternetsales with id " + id + " no longer exists.", enfe);
            }
            Dimcurrency currencykey = factinternetsales.getCurrencykey();
            if (currencykey != null) {
                currencykey.getFactinternetsalesCollection().remove(factinternetsales);
                currencykey = em.merge(currencykey);
            }
            Dimcustomer customerkey = factinternetsales.getCustomerkey();
            if (customerkey != null) {
                customerkey.getFactinternetsalesCollection().remove(factinternetsales);
                customerkey = em.merge(customerkey);
            }
            Dimdate shipdatekey = factinternetsales.getShipdatekey();
            if (shipdatekey != null) {
                shipdatekey.getFactinternetsalesCollection().remove(factinternetsales);
                shipdatekey = em.merge(shipdatekey);
            }
            Dimdate orderdatekey = factinternetsales.getOrderdatekey();
            if (orderdatekey != null) {
                orderdatekey.getFactinternetsalesCollection().remove(factinternetsales);
                orderdatekey = em.merge(orderdatekey);
            }
            Dimdate duedatekey = factinternetsales.getDuedatekey();
            if (duedatekey != null) {
                duedatekey.getFactinternetsalesCollection().remove(factinternetsales);
                duedatekey = em.merge(duedatekey);
            }
            Dimproduct productkey = factinternetsales.getProductkey();
            if (productkey != null) {
                productkey.getFactinternetsalesCollection().remove(factinternetsales);
                productkey = em.merge(productkey);
            }
            Dimpromotion promotionkey = factinternetsales.getPromotionkey();
            if (promotionkey != null) {
                promotionkey.getFactinternetsalesCollection().remove(factinternetsales);
                promotionkey = em.merge(promotionkey);
            }
            Dimsalesterritory salesterritorykey = factinternetsales.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey.getFactinternetsalesCollection().remove(factinternetsales);
                salesterritorykey = em.merge(salesterritorykey);
            }
            Collection<Dimsalesreason> dimsalesreasonCollection = factinternetsales.getDimsalesreasonCollection();
            for (Dimsalesreason dimsalesreasonCollectionDimsalesreason : dimsalesreasonCollection) {
                dimsalesreasonCollectionDimsalesreason.getFactinternetsalesCollection().remove(factinternetsales);
                dimsalesreasonCollectionDimsalesreason = em.merge(dimsalesreasonCollectionDimsalesreason);
            }
            em.remove(factinternetsales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factinternetsales> findFactinternetsalesEntities() {
        return findFactinternetsalesEntities(true, -1, -1);
    }

    public List<Factinternetsales> findFactinternetsalesEntities(int maxResults, int firstResult) {
        return findFactinternetsalesEntities(false, maxResults, firstResult);
    }

    private List<Factinternetsales> findFactinternetsalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factinternetsales.class));
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

    public Factinternetsales findFactinternetsales(FactinternetsalesPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factinternetsales.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactinternetsalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factinternetsales> rt = cq.from(Factinternetsales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
