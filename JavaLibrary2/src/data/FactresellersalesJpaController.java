/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.NonexistentEntityException;
import data.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author admin
 */
public class FactresellersalesJpaController implements Serializable {

    public FactresellersalesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factresellersales factresellersales) throws PreexistingEntityException, Exception {
        if (factresellersales.getFactresellersalesPK() == null) {
            factresellersales.setFactresellersalesPK(new FactresellersalesPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcurrency currencykey = factresellersales.getCurrencykey();
            if (currencykey != null) {
                currencykey = em.getReference(currencykey.getClass(), currencykey.getCurrencykey());
                factresellersales.setCurrencykey(currencykey);
            }
            Dimdate shipdatekey = factresellersales.getShipdatekey();
            if (shipdatekey != null) {
                shipdatekey = em.getReference(shipdatekey.getClass(), shipdatekey.getDatekey());
                factresellersales.setShipdatekey(shipdatekey);
            }
            Dimdate duedatekey = factresellersales.getDuedatekey();
            if (duedatekey != null) {
                duedatekey = em.getReference(duedatekey.getClass(), duedatekey.getDatekey());
                factresellersales.setDuedatekey(duedatekey);
            }
            Dimdate orderdatekey = factresellersales.getOrderdatekey();
            if (orderdatekey != null) {
                orderdatekey = em.getReference(orderdatekey.getClass(), orderdatekey.getDatekey());
                factresellersales.setOrderdatekey(orderdatekey);
            }
            Dimemployee employeekey = factresellersales.getEmployeekey();
            if (employeekey != null) {
                employeekey = em.getReference(employeekey.getClass(), employeekey.getEmployeekey());
                factresellersales.setEmployeekey(employeekey);
            }
            Dimproduct productkey = factresellersales.getProductkey();
            if (productkey != null) {
                productkey = em.getReference(productkey.getClass(), productkey.getProductkey());
                factresellersales.setProductkey(productkey);
            }
            Dimpromotion promotionkey = factresellersales.getPromotionkey();
            if (promotionkey != null) {
                promotionkey = em.getReference(promotionkey.getClass(), promotionkey.getPromotionkey());
                factresellersales.setPromotionkey(promotionkey);
            }
            Dimreseller resellerkey = factresellersales.getResellerkey();
            if (resellerkey != null) {
                resellerkey = em.getReference(resellerkey.getClass(), resellerkey.getResellerkey());
                factresellersales.setResellerkey(resellerkey);
            }
            Dimsalesterritory salesterritorykey = factresellersales.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey = em.getReference(salesterritorykey.getClass(), salesterritorykey.getSalesterritorykey());
                factresellersales.setSalesterritorykey(salesterritorykey);
            }
            em.persist(factresellersales);
            if (currencykey != null) {
                currencykey.getFactresellersalesCollection().add(factresellersales);
                currencykey = em.merge(currencykey);
            }
            if (shipdatekey != null) {
                shipdatekey.getFactresellersalesCollection().add(factresellersales);
                shipdatekey = em.merge(shipdatekey);
            }
            if (duedatekey != null) {
                duedatekey.getFactresellersalesCollection().add(factresellersales);
                duedatekey = em.merge(duedatekey);
            }
            if (orderdatekey != null) {
                orderdatekey.getFactresellersalesCollection().add(factresellersales);
                orderdatekey = em.merge(orderdatekey);
            }
            if (employeekey != null) {
                employeekey.getFactresellersalesCollection().add(factresellersales);
                employeekey = em.merge(employeekey);
            }
            if (productkey != null) {
                productkey.getFactresellersalesCollection().add(factresellersales);
                productkey = em.merge(productkey);
            }
            if (promotionkey != null) {
                promotionkey.getFactresellersalesCollection().add(factresellersales);
                promotionkey = em.merge(promotionkey);
            }
            if (resellerkey != null) {
                resellerkey.getFactresellersalesCollection().add(factresellersales);
                resellerkey = em.merge(resellerkey);
            }
            if (salesterritorykey != null) {
                salesterritorykey.getFactresellersalesCollection().add(factresellersales);
                salesterritorykey = em.merge(salesterritorykey);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactresellersales(factresellersales.getFactresellersalesPK()) != null) {
                throw new PreexistingEntityException("Factresellersales " + factresellersales + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factresellersales factresellersales) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factresellersales persistentFactresellersales = em.find(Factresellersales.class, factresellersales.getFactresellersalesPK());
            Dimcurrency currencykeyOld = persistentFactresellersales.getCurrencykey();
            Dimcurrency currencykeyNew = factresellersales.getCurrencykey();
            Dimdate shipdatekeyOld = persistentFactresellersales.getShipdatekey();
            Dimdate shipdatekeyNew = factresellersales.getShipdatekey();
            Dimdate duedatekeyOld = persistentFactresellersales.getDuedatekey();
            Dimdate duedatekeyNew = factresellersales.getDuedatekey();
            Dimdate orderdatekeyOld = persistentFactresellersales.getOrderdatekey();
            Dimdate orderdatekeyNew = factresellersales.getOrderdatekey();
            Dimemployee employeekeyOld = persistentFactresellersales.getEmployeekey();
            Dimemployee employeekeyNew = factresellersales.getEmployeekey();
            Dimproduct productkeyOld = persistentFactresellersales.getProductkey();
            Dimproduct productkeyNew = factresellersales.getProductkey();
            Dimpromotion promotionkeyOld = persistentFactresellersales.getPromotionkey();
            Dimpromotion promotionkeyNew = factresellersales.getPromotionkey();
            Dimreseller resellerkeyOld = persistentFactresellersales.getResellerkey();
            Dimreseller resellerkeyNew = factresellersales.getResellerkey();
            Dimsalesterritory salesterritorykeyOld = persistentFactresellersales.getSalesterritorykey();
            Dimsalesterritory salesterritorykeyNew = factresellersales.getSalesterritorykey();
            if (currencykeyNew != null) {
                currencykeyNew = em.getReference(currencykeyNew.getClass(), currencykeyNew.getCurrencykey());
                factresellersales.setCurrencykey(currencykeyNew);
            }
            if (shipdatekeyNew != null) {
                shipdatekeyNew = em.getReference(shipdatekeyNew.getClass(), shipdatekeyNew.getDatekey());
                factresellersales.setShipdatekey(shipdatekeyNew);
            }
            if (duedatekeyNew != null) {
                duedatekeyNew = em.getReference(duedatekeyNew.getClass(), duedatekeyNew.getDatekey());
                factresellersales.setDuedatekey(duedatekeyNew);
            }
            if (orderdatekeyNew != null) {
                orderdatekeyNew = em.getReference(orderdatekeyNew.getClass(), orderdatekeyNew.getDatekey());
                factresellersales.setOrderdatekey(orderdatekeyNew);
            }
            if (employeekeyNew != null) {
                employeekeyNew = em.getReference(employeekeyNew.getClass(), employeekeyNew.getEmployeekey());
                factresellersales.setEmployeekey(employeekeyNew);
            }
            if (productkeyNew != null) {
                productkeyNew = em.getReference(productkeyNew.getClass(), productkeyNew.getProductkey());
                factresellersales.setProductkey(productkeyNew);
            }
            if (promotionkeyNew != null) {
                promotionkeyNew = em.getReference(promotionkeyNew.getClass(), promotionkeyNew.getPromotionkey());
                factresellersales.setPromotionkey(promotionkeyNew);
            }
            if (resellerkeyNew != null) {
                resellerkeyNew = em.getReference(resellerkeyNew.getClass(), resellerkeyNew.getResellerkey());
                factresellersales.setResellerkey(resellerkeyNew);
            }
            if (salesterritorykeyNew != null) {
                salesterritorykeyNew = em.getReference(salesterritorykeyNew.getClass(), salesterritorykeyNew.getSalesterritorykey());
                factresellersales.setSalesterritorykey(salesterritorykeyNew);
            }
            factresellersales = em.merge(factresellersales);
            if (currencykeyOld != null && !currencykeyOld.equals(currencykeyNew)) {
                currencykeyOld.getFactresellersalesCollection().remove(factresellersales);
                currencykeyOld = em.merge(currencykeyOld);
            }
            if (currencykeyNew != null && !currencykeyNew.equals(currencykeyOld)) {
                currencykeyNew.getFactresellersalesCollection().add(factresellersales);
                currencykeyNew = em.merge(currencykeyNew);
            }
            if (shipdatekeyOld != null && !shipdatekeyOld.equals(shipdatekeyNew)) {
                shipdatekeyOld.getFactresellersalesCollection().remove(factresellersales);
                shipdatekeyOld = em.merge(shipdatekeyOld);
            }
            if (shipdatekeyNew != null && !shipdatekeyNew.equals(shipdatekeyOld)) {
                shipdatekeyNew.getFactresellersalesCollection().add(factresellersales);
                shipdatekeyNew = em.merge(shipdatekeyNew);
            }
            if (duedatekeyOld != null && !duedatekeyOld.equals(duedatekeyNew)) {
                duedatekeyOld.getFactresellersalesCollection().remove(factresellersales);
                duedatekeyOld = em.merge(duedatekeyOld);
            }
            if (duedatekeyNew != null && !duedatekeyNew.equals(duedatekeyOld)) {
                duedatekeyNew.getFactresellersalesCollection().add(factresellersales);
                duedatekeyNew = em.merge(duedatekeyNew);
            }
            if (orderdatekeyOld != null && !orderdatekeyOld.equals(orderdatekeyNew)) {
                orderdatekeyOld.getFactresellersalesCollection().remove(factresellersales);
                orderdatekeyOld = em.merge(orderdatekeyOld);
            }
            if (orderdatekeyNew != null && !orderdatekeyNew.equals(orderdatekeyOld)) {
                orderdatekeyNew.getFactresellersalesCollection().add(factresellersales);
                orderdatekeyNew = em.merge(orderdatekeyNew);
            }
            if (employeekeyOld != null && !employeekeyOld.equals(employeekeyNew)) {
                employeekeyOld.getFactresellersalesCollection().remove(factresellersales);
                employeekeyOld = em.merge(employeekeyOld);
            }
            if (employeekeyNew != null && !employeekeyNew.equals(employeekeyOld)) {
                employeekeyNew.getFactresellersalesCollection().add(factresellersales);
                employeekeyNew = em.merge(employeekeyNew);
            }
            if (productkeyOld != null && !productkeyOld.equals(productkeyNew)) {
                productkeyOld.getFactresellersalesCollection().remove(factresellersales);
                productkeyOld = em.merge(productkeyOld);
            }
            if (productkeyNew != null && !productkeyNew.equals(productkeyOld)) {
                productkeyNew.getFactresellersalesCollection().add(factresellersales);
                productkeyNew = em.merge(productkeyNew);
            }
            if (promotionkeyOld != null && !promotionkeyOld.equals(promotionkeyNew)) {
                promotionkeyOld.getFactresellersalesCollection().remove(factresellersales);
                promotionkeyOld = em.merge(promotionkeyOld);
            }
            if (promotionkeyNew != null && !promotionkeyNew.equals(promotionkeyOld)) {
                promotionkeyNew.getFactresellersalesCollection().add(factresellersales);
                promotionkeyNew = em.merge(promotionkeyNew);
            }
            if (resellerkeyOld != null && !resellerkeyOld.equals(resellerkeyNew)) {
                resellerkeyOld.getFactresellersalesCollection().remove(factresellersales);
                resellerkeyOld = em.merge(resellerkeyOld);
            }
            if (resellerkeyNew != null && !resellerkeyNew.equals(resellerkeyOld)) {
                resellerkeyNew.getFactresellersalesCollection().add(factresellersales);
                resellerkeyNew = em.merge(resellerkeyNew);
            }
            if (salesterritorykeyOld != null && !salesterritorykeyOld.equals(salesterritorykeyNew)) {
                salesterritorykeyOld.getFactresellersalesCollection().remove(factresellersales);
                salesterritorykeyOld = em.merge(salesterritorykeyOld);
            }
            if (salesterritorykeyNew != null && !salesterritorykeyNew.equals(salesterritorykeyOld)) {
                salesterritorykeyNew.getFactresellersalesCollection().add(factresellersales);
                salesterritorykeyNew = em.merge(salesterritorykeyNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                FactresellersalesPK id = factresellersales.getFactresellersalesPK();
                if (findFactresellersales(id) == null) {
                    throw new NonexistentEntityException("The factresellersales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(FactresellersalesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factresellersales factresellersales;
            try {
                factresellersales = em.getReference(Factresellersales.class, id);
                factresellersales.getFactresellersalesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factresellersales with id " + id + " no longer exists.", enfe);
            }
            Dimcurrency currencykey = factresellersales.getCurrencykey();
            if (currencykey != null) {
                currencykey.getFactresellersalesCollection().remove(factresellersales);
                currencykey = em.merge(currencykey);
            }
            Dimdate shipdatekey = factresellersales.getShipdatekey();
            if (shipdatekey != null) {
                shipdatekey.getFactresellersalesCollection().remove(factresellersales);
                shipdatekey = em.merge(shipdatekey);
            }
            Dimdate duedatekey = factresellersales.getDuedatekey();
            if (duedatekey != null) {
                duedatekey.getFactresellersalesCollection().remove(factresellersales);
                duedatekey = em.merge(duedatekey);
            }
            Dimdate orderdatekey = factresellersales.getOrderdatekey();
            if (orderdatekey != null) {
                orderdatekey.getFactresellersalesCollection().remove(factresellersales);
                orderdatekey = em.merge(orderdatekey);
            }
            Dimemployee employeekey = factresellersales.getEmployeekey();
            if (employeekey != null) {
                employeekey.getFactresellersalesCollection().remove(factresellersales);
                employeekey = em.merge(employeekey);
            }
            Dimproduct productkey = factresellersales.getProductkey();
            if (productkey != null) {
                productkey.getFactresellersalesCollection().remove(factresellersales);
                productkey = em.merge(productkey);
            }
            Dimpromotion promotionkey = factresellersales.getPromotionkey();
            if (promotionkey != null) {
                promotionkey.getFactresellersalesCollection().remove(factresellersales);
                promotionkey = em.merge(promotionkey);
            }
            Dimreseller resellerkey = factresellersales.getResellerkey();
            if (resellerkey != null) {
                resellerkey.getFactresellersalesCollection().remove(factresellersales);
                resellerkey = em.merge(resellerkey);
            }
            Dimsalesterritory salesterritorykey = factresellersales.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey.getFactresellersalesCollection().remove(factresellersales);
                salesterritorykey = em.merge(salesterritorykey);
            }
            em.remove(factresellersales);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factresellersales> findFactresellersalesEntities() {
        return findFactresellersalesEntities(true, -1, -1);
    }

    public List<Factresellersales> findFactresellersalesEntities(int maxResults, int firstResult) {
        return findFactresellersalesEntities(false, maxResults, firstResult);
    }

    private List<Factresellersales> findFactresellersalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factresellersales.class));
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

    public Factresellersales findFactresellersales(FactresellersalesPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factresellersales.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactresellersalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factresellersales> rt = cq.from(Factresellersales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
