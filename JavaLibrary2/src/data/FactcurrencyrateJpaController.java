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
public class FactcurrencyrateJpaController implements Serializable {

    public FactcurrencyrateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factcurrencyrate factcurrencyrate) throws PreexistingEntityException, Exception {
        if (factcurrencyrate.getFactcurrencyratePK() == null) {
            factcurrencyrate.setFactcurrencyratePK(new FactcurrencyratePK());
        }
        factcurrencyrate.getFactcurrencyratePK().setCurrencykey(factcurrencyrate.getDimcurrency().getCurrencykey());
        factcurrencyrate.getFactcurrencyratePK().setDatekey(factcurrencyrate.getDimdate().getDatekey());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcurrency dimcurrency = factcurrencyrate.getDimcurrency();
            if (dimcurrency != null) {
                dimcurrency = em.getReference(dimcurrency.getClass(), dimcurrency.getCurrencykey());
                factcurrencyrate.setDimcurrency(dimcurrency);
            }
            Dimdate dimdate = factcurrencyrate.getDimdate();
            if (dimdate != null) {
                dimdate = em.getReference(dimdate.getClass(), dimdate.getDatekey());
                factcurrencyrate.setDimdate(dimdate);
            }
            em.persist(factcurrencyrate);
            if (dimcurrency != null) {
                dimcurrency.getFactcurrencyrateCollection().add(factcurrencyrate);
                dimcurrency = em.merge(dimcurrency);
            }
            if (dimdate != null) {
                dimdate.getFactcurrencyrateCollection().add(factcurrencyrate);
                dimdate = em.merge(dimdate);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactcurrencyrate(factcurrencyrate.getFactcurrencyratePK()) != null) {
                throw new PreexistingEntityException("Factcurrencyrate " + factcurrencyrate + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factcurrencyrate factcurrencyrate) throws NonexistentEntityException, Exception {
        factcurrencyrate.getFactcurrencyratePK().setCurrencykey(factcurrencyrate.getDimcurrency().getCurrencykey());
        factcurrencyrate.getFactcurrencyratePK().setDatekey(factcurrencyrate.getDimdate().getDatekey());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factcurrencyrate persistentFactcurrencyrate = em.find(Factcurrencyrate.class, factcurrencyrate.getFactcurrencyratePK());
            Dimcurrency dimcurrencyOld = persistentFactcurrencyrate.getDimcurrency();
            Dimcurrency dimcurrencyNew = factcurrencyrate.getDimcurrency();
            Dimdate dimdateOld = persistentFactcurrencyrate.getDimdate();
            Dimdate dimdateNew = factcurrencyrate.getDimdate();
            if (dimcurrencyNew != null) {
                dimcurrencyNew = em.getReference(dimcurrencyNew.getClass(), dimcurrencyNew.getCurrencykey());
                factcurrencyrate.setDimcurrency(dimcurrencyNew);
            }
            if (dimdateNew != null) {
                dimdateNew = em.getReference(dimdateNew.getClass(), dimdateNew.getDatekey());
                factcurrencyrate.setDimdate(dimdateNew);
            }
            factcurrencyrate = em.merge(factcurrencyrate);
            if (dimcurrencyOld != null && !dimcurrencyOld.equals(dimcurrencyNew)) {
                dimcurrencyOld.getFactcurrencyrateCollection().remove(factcurrencyrate);
                dimcurrencyOld = em.merge(dimcurrencyOld);
            }
            if (dimcurrencyNew != null && !dimcurrencyNew.equals(dimcurrencyOld)) {
                dimcurrencyNew.getFactcurrencyrateCollection().add(factcurrencyrate);
                dimcurrencyNew = em.merge(dimcurrencyNew);
            }
            if (dimdateOld != null && !dimdateOld.equals(dimdateNew)) {
                dimdateOld.getFactcurrencyrateCollection().remove(factcurrencyrate);
                dimdateOld = em.merge(dimdateOld);
            }
            if (dimdateNew != null && !dimdateNew.equals(dimdateOld)) {
                dimdateNew.getFactcurrencyrateCollection().add(factcurrencyrate);
                dimdateNew = em.merge(dimdateNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                FactcurrencyratePK id = factcurrencyrate.getFactcurrencyratePK();
                if (findFactcurrencyrate(id) == null) {
                    throw new NonexistentEntityException("The factcurrencyrate with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(FactcurrencyratePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factcurrencyrate factcurrencyrate;
            try {
                factcurrencyrate = em.getReference(Factcurrencyrate.class, id);
                factcurrencyrate.getFactcurrencyratePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factcurrencyrate with id " + id + " no longer exists.", enfe);
            }
            Dimcurrency dimcurrency = factcurrencyrate.getDimcurrency();
            if (dimcurrency != null) {
                dimcurrency.getFactcurrencyrateCollection().remove(factcurrencyrate);
                dimcurrency = em.merge(dimcurrency);
            }
            Dimdate dimdate = factcurrencyrate.getDimdate();
            if (dimdate != null) {
                dimdate.getFactcurrencyrateCollection().remove(factcurrencyrate);
                dimdate = em.merge(dimdate);
            }
            em.remove(factcurrencyrate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factcurrencyrate> findFactcurrencyrateEntities() {
        return findFactcurrencyrateEntities(true, -1, -1);
    }

    public List<Factcurrencyrate> findFactcurrencyrateEntities(int maxResults, int firstResult) {
        return findFactcurrencyrateEntities(false, maxResults, firstResult);
    }

    private List<Factcurrencyrate> findFactcurrencyrateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factcurrencyrate.class));
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

    public Factcurrencyrate findFactcurrencyrate(FactcurrencyratePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factcurrencyrate.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactcurrencyrateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factcurrencyrate> rt = cq.from(Factcurrencyrate.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
