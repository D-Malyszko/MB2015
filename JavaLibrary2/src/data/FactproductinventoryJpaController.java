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
public class FactproductinventoryJpaController implements Serializable {

    public FactproductinventoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factproductinventory factproductinventory) throws PreexistingEntityException, Exception {
        if (factproductinventory.getFactproductinventoryPK() == null) {
            factproductinventory.setFactproductinventoryPK(new FactproductinventoryPK());
        }
        factproductinventory.getFactproductinventoryPK().setProductkey(factproductinventory.getDimproduct().getProductkey());
        factproductinventory.getFactproductinventoryPK().setDatekey(factproductinventory.getDimdate().getDatekey());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdate dimdate = factproductinventory.getDimdate();
            if (dimdate != null) {
                dimdate = em.getReference(dimdate.getClass(), dimdate.getDatekey());
                factproductinventory.setDimdate(dimdate);
            }
            Dimproduct dimproduct = factproductinventory.getDimproduct();
            if (dimproduct != null) {
                dimproduct = em.getReference(dimproduct.getClass(), dimproduct.getProductkey());
                factproductinventory.setDimproduct(dimproduct);
            }
            em.persist(factproductinventory);
            if (dimdate != null) {
                dimdate.getFactproductinventoryCollection().add(factproductinventory);
                dimdate = em.merge(dimdate);
            }
            if (dimproduct != null) {
                dimproduct.getFactproductinventoryCollection().add(factproductinventory);
                dimproduct = em.merge(dimproduct);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactproductinventory(factproductinventory.getFactproductinventoryPK()) != null) {
                throw new PreexistingEntityException("Factproductinventory " + factproductinventory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factproductinventory factproductinventory) throws NonexistentEntityException, Exception {
        factproductinventory.getFactproductinventoryPK().setProductkey(factproductinventory.getDimproduct().getProductkey());
        factproductinventory.getFactproductinventoryPK().setDatekey(factproductinventory.getDimdate().getDatekey());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factproductinventory persistentFactproductinventory = em.find(Factproductinventory.class, factproductinventory.getFactproductinventoryPK());
            Dimdate dimdateOld = persistentFactproductinventory.getDimdate();
            Dimdate dimdateNew = factproductinventory.getDimdate();
            Dimproduct dimproductOld = persistentFactproductinventory.getDimproduct();
            Dimproduct dimproductNew = factproductinventory.getDimproduct();
            if (dimdateNew != null) {
                dimdateNew = em.getReference(dimdateNew.getClass(), dimdateNew.getDatekey());
                factproductinventory.setDimdate(dimdateNew);
            }
            if (dimproductNew != null) {
                dimproductNew = em.getReference(dimproductNew.getClass(), dimproductNew.getProductkey());
                factproductinventory.setDimproduct(dimproductNew);
            }
            factproductinventory = em.merge(factproductinventory);
            if (dimdateOld != null && !dimdateOld.equals(dimdateNew)) {
                dimdateOld.getFactproductinventoryCollection().remove(factproductinventory);
                dimdateOld = em.merge(dimdateOld);
            }
            if (dimdateNew != null && !dimdateNew.equals(dimdateOld)) {
                dimdateNew.getFactproductinventoryCollection().add(factproductinventory);
                dimdateNew = em.merge(dimdateNew);
            }
            if (dimproductOld != null && !dimproductOld.equals(dimproductNew)) {
                dimproductOld.getFactproductinventoryCollection().remove(factproductinventory);
                dimproductOld = em.merge(dimproductOld);
            }
            if (dimproductNew != null && !dimproductNew.equals(dimproductOld)) {
                dimproductNew.getFactproductinventoryCollection().add(factproductinventory);
                dimproductNew = em.merge(dimproductNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                FactproductinventoryPK id = factproductinventory.getFactproductinventoryPK();
                if (findFactproductinventory(id) == null) {
                    throw new NonexistentEntityException("The factproductinventory with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(FactproductinventoryPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factproductinventory factproductinventory;
            try {
                factproductinventory = em.getReference(Factproductinventory.class, id);
                factproductinventory.getFactproductinventoryPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factproductinventory with id " + id + " no longer exists.", enfe);
            }
            Dimdate dimdate = factproductinventory.getDimdate();
            if (dimdate != null) {
                dimdate.getFactproductinventoryCollection().remove(factproductinventory);
                dimdate = em.merge(dimdate);
            }
            Dimproduct dimproduct = factproductinventory.getDimproduct();
            if (dimproduct != null) {
                dimproduct.getFactproductinventoryCollection().remove(factproductinventory);
                dimproduct = em.merge(dimproduct);
            }
            em.remove(factproductinventory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factproductinventory> findFactproductinventoryEntities() {
        return findFactproductinventoryEntities(true, -1, -1);
    }

    public List<Factproductinventory> findFactproductinventoryEntities(int maxResults, int firstResult) {
        return findFactproductinventoryEntities(false, maxResults, firstResult);
    }

    private List<Factproductinventory> findFactproductinventoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factproductinventory.class));
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

    public Factproductinventory findFactproductinventory(FactproductinventoryPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factproductinventory.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactproductinventoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factproductinventory> rt = cq.from(Factproductinventory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
