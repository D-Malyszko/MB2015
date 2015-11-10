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
public class DivisionJpaController implements Serializable {

    public DivisionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Division division) throws PreexistingEntityException, Exception {
        if (division.getAssetbankuserCollection() == null) {
            division.setAssetbankuserCollection(new ArrayList<Assetbankuser>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Assetbankuser> attachedAssetbankuserCollection = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionAssetbankuserToAttach : division.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuserToAttach = em.getReference(assetbankuserCollectionAssetbankuserToAttach.getClass(), assetbankuserCollectionAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection.add(assetbankuserCollectionAssetbankuserToAttach);
            }
            division.setAssetbankuserCollection(attachedAssetbankuserCollection);
            em.persist(division);
            for (Assetbankuser assetbankuserCollectionAssetbankuser : division.getAssetbankuserCollection()) {
                Division oldDivisionidOfAssetbankuserCollectionAssetbankuser = assetbankuserCollectionAssetbankuser.getDivisionid();
                assetbankuserCollectionAssetbankuser.setDivisionid(division);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
                if (oldDivisionidOfAssetbankuserCollectionAssetbankuser != null) {
                    oldDivisionidOfAssetbankuserCollectionAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionAssetbankuser);
                    oldDivisionidOfAssetbankuserCollectionAssetbankuser = em.merge(oldDivisionidOfAssetbankuserCollectionAssetbankuser);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDivision(division.getId()) != null) {
                throw new PreexistingEntityException("Division " + division + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Division division) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Division persistentDivision = em.find(Division.class, division.getId());
            Collection<Assetbankuser> assetbankuserCollectionOld = persistentDivision.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollectionNew = division.getAssetbankuserCollection();
            Collection<Assetbankuser> attachedAssetbankuserCollectionNew = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionNewAssetbankuserToAttach : assetbankuserCollectionNew) {
                assetbankuserCollectionNewAssetbankuserToAttach = em.getReference(assetbankuserCollectionNewAssetbankuserToAttach.getClass(), assetbankuserCollectionNewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollectionNew.add(assetbankuserCollectionNewAssetbankuserToAttach);
            }
            assetbankuserCollectionNew = attachedAssetbankuserCollectionNew;
            division.setAssetbankuserCollection(assetbankuserCollectionNew);
            division = em.merge(division);
            for (Assetbankuser assetbankuserCollectionOldAssetbankuser : assetbankuserCollectionOld) {
                if (!assetbankuserCollectionNew.contains(assetbankuserCollectionOldAssetbankuser)) {
                    assetbankuserCollectionOldAssetbankuser.setDivisionid(null);
                    assetbankuserCollectionOldAssetbankuser = em.merge(assetbankuserCollectionOldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollectionNewAssetbankuser : assetbankuserCollectionNew) {
                if (!assetbankuserCollectionOld.contains(assetbankuserCollectionNewAssetbankuser)) {
                    Division oldDivisionidOfAssetbankuserCollectionNewAssetbankuser = assetbankuserCollectionNewAssetbankuser.getDivisionid();
                    assetbankuserCollectionNewAssetbankuser.setDivisionid(division);
                    assetbankuserCollectionNewAssetbankuser = em.merge(assetbankuserCollectionNewAssetbankuser);
                    if (oldDivisionidOfAssetbankuserCollectionNewAssetbankuser != null && !oldDivisionidOfAssetbankuserCollectionNewAssetbankuser.equals(division)) {
                        oldDivisionidOfAssetbankuserCollectionNewAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionNewAssetbankuser);
                        oldDivisionidOfAssetbankuserCollectionNewAssetbankuser = em.merge(oldDivisionidOfAssetbankuserCollectionNewAssetbankuser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = division.getId();
                if (findDivision(id) == null) {
                    throw new NonexistentEntityException("The division with id " + id + " no longer exists.");
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
            Division division;
            try {
                division = em.getReference(Division.class, id);
                division.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The division with id " + id + " no longer exists.", enfe);
            }
            Collection<Assetbankuser> assetbankuserCollection = division.getAssetbankuserCollection();
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuserCollection) {
                assetbankuserCollectionAssetbankuser.setDivisionid(null);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            em.remove(division);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Division> findDivisionEntities() {
        return findDivisionEntities(true, -1, -1);
    }

    public List<Division> findDivisionEntities(int maxResults, int firstResult) {
        return findDivisionEntities(false, maxResults, firstResult);
    }

    private List<Division> findDivisionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Division.class));
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

    public Division findDivision(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Division.class, id);
        } finally {
            em.close();
        }
    }

    public int getDivisionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Division> rt = cq.from(Division.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
