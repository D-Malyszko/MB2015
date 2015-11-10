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
public class CmCategorytypeJpaController implements Serializable {

    public CmCategorytypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CmCategorytype cmCategorytype) throws PreexistingEntityException, Exception {
        if (cmCategorytype.getCmCategoryCollection() == null) {
            cmCategorytype.setCmCategoryCollection(new ArrayList<CmCategory>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<CmCategory> attachedCmCategoryCollection = new ArrayList<CmCategory>();
            for (CmCategory cmCategoryCollectionCmCategoryToAttach : cmCategorytype.getCmCategoryCollection()) {
                cmCategoryCollectionCmCategoryToAttach = em.getReference(cmCategoryCollectionCmCategoryToAttach.getClass(), cmCategoryCollectionCmCategoryToAttach.getId());
                attachedCmCategoryCollection.add(cmCategoryCollectionCmCategoryToAttach);
            }
            cmCategorytype.setCmCategoryCollection(attachedCmCategoryCollection);
            em.persist(cmCategorytype);
            for (CmCategory cmCategoryCollectionCmCategory : cmCategorytype.getCmCategoryCollection()) {
                CmCategorytype oldCategorytypeidOfCmCategoryCollectionCmCategory = cmCategoryCollectionCmCategory.getCategorytypeid();
                cmCategoryCollectionCmCategory.setCategorytypeid(cmCategorytype);
                cmCategoryCollectionCmCategory = em.merge(cmCategoryCollectionCmCategory);
                if (oldCategorytypeidOfCmCategoryCollectionCmCategory != null) {
                    oldCategorytypeidOfCmCategoryCollectionCmCategory.getCmCategoryCollection().remove(cmCategoryCollectionCmCategory);
                    oldCategorytypeidOfCmCategoryCollectionCmCategory = em.merge(oldCategorytypeidOfCmCategoryCollectionCmCategory);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCmCategorytype(cmCategorytype.getId()) != null) {
                throw new PreexistingEntityException("CmCategorytype " + cmCategorytype + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CmCategorytype cmCategorytype) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CmCategorytype persistentCmCategorytype = em.find(CmCategorytype.class, cmCategorytype.getId());
            Collection<CmCategory> cmCategoryCollectionOld = persistentCmCategorytype.getCmCategoryCollection();
            Collection<CmCategory> cmCategoryCollectionNew = cmCategorytype.getCmCategoryCollection();
            Collection<CmCategory> attachedCmCategoryCollectionNew = new ArrayList<CmCategory>();
            for (CmCategory cmCategoryCollectionNewCmCategoryToAttach : cmCategoryCollectionNew) {
                cmCategoryCollectionNewCmCategoryToAttach = em.getReference(cmCategoryCollectionNewCmCategoryToAttach.getClass(), cmCategoryCollectionNewCmCategoryToAttach.getId());
                attachedCmCategoryCollectionNew.add(cmCategoryCollectionNewCmCategoryToAttach);
            }
            cmCategoryCollectionNew = attachedCmCategoryCollectionNew;
            cmCategorytype.setCmCategoryCollection(cmCategoryCollectionNew);
            cmCategorytype = em.merge(cmCategorytype);
            for (CmCategory cmCategoryCollectionOldCmCategory : cmCategoryCollectionOld) {
                if (!cmCategoryCollectionNew.contains(cmCategoryCollectionOldCmCategory)) {
                    cmCategoryCollectionOldCmCategory.setCategorytypeid(null);
                    cmCategoryCollectionOldCmCategory = em.merge(cmCategoryCollectionOldCmCategory);
                }
            }
            for (CmCategory cmCategoryCollectionNewCmCategory : cmCategoryCollectionNew) {
                if (!cmCategoryCollectionOld.contains(cmCategoryCollectionNewCmCategory)) {
                    CmCategorytype oldCategorytypeidOfCmCategoryCollectionNewCmCategory = cmCategoryCollectionNewCmCategory.getCategorytypeid();
                    cmCategoryCollectionNewCmCategory.setCategorytypeid(cmCategorytype);
                    cmCategoryCollectionNewCmCategory = em.merge(cmCategoryCollectionNewCmCategory);
                    if (oldCategorytypeidOfCmCategoryCollectionNewCmCategory != null && !oldCategorytypeidOfCmCategoryCollectionNewCmCategory.equals(cmCategorytype)) {
                        oldCategorytypeidOfCmCategoryCollectionNewCmCategory.getCmCategoryCollection().remove(cmCategoryCollectionNewCmCategory);
                        oldCategorytypeidOfCmCategoryCollectionNewCmCategory = em.merge(oldCategorytypeidOfCmCategoryCollectionNewCmCategory);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cmCategorytype.getId();
                if (findCmCategorytype(id) == null) {
                    throw new NonexistentEntityException("The cmCategorytype with id " + id + " no longer exists.");
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
            CmCategorytype cmCategorytype;
            try {
                cmCategorytype = em.getReference(CmCategorytype.class, id);
                cmCategorytype.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cmCategorytype with id " + id + " no longer exists.", enfe);
            }
            Collection<CmCategory> cmCategoryCollection = cmCategorytype.getCmCategoryCollection();
            for (CmCategory cmCategoryCollectionCmCategory : cmCategoryCollection) {
                cmCategoryCollectionCmCategory.setCategorytypeid(null);
                cmCategoryCollectionCmCategory = em.merge(cmCategoryCollectionCmCategory);
            }
            em.remove(cmCategorytype);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CmCategorytype> findCmCategorytypeEntities() {
        return findCmCategorytypeEntities(true, -1, -1);
    }

    public List<CmCategorytype> findCmCategorytypeEntities(int maxResults, int firstResult) {
        return findCmCategorytypeEntities(false, maxResults, firstResult);
    }

    private List<CmCategorytype> findCmCategorytypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CmCategorytype.class));
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

    public CmCategorytype findCmCategorytype(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CmCategorytype.class, id);
        } finally {
            em.close();
        }
    }

    public int getCmCategorytypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CmCategorytype> rt = cq.from(CmCategorytype.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
