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
public class AttributestoragetypeJpaController implements Serializable {

    public AttributestoragetypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Attributestoragetype attributestoragetype) throws PreexistingEntityException, Exception {
        if (attributestoragetype.getAttributetypeCollection() == null) {
            attributestoragetype.setAttributetypeCollection(new ArrayList<Attributetype>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Attributetype> attachedAttributetypeCollection = new ArrayList<Attributetype>();
            for (Attributetype attributetypeCollectionAttributetypeToAttach : attributestoragetype.getAttributetypeCollection()) {
                attributetypeCollectionAttributetypeToAttach = em.getReference(attributetypeCollectionAttributetypeToAttach.getClass(), attributetypeCollectionAttributetypeToAttach.getId());
                attachedAttributetypeCollection.add(attributetypeCollectionAttributetypeToAttach);
            }
            attributestoragetype.setAttributetypeCollection(attachedAttributetypeCollection);
            em.persist(attributestoragetype);
            for (Attributetype attributetypeCollectionAttributetype : attributestoragetype.getAttributetypeCollection()) {
                Attributestoragetype oldAttributestoragetypeidOfAttributetypeCollectionAttributetype = attributetypeCollectionAttributetype.getAttributestoragetypeid();
                attributetypeCollectionAttributetype.setAttributestoragetypeid(attributestoragetype);
                attributetypeCollectionAttributetype = em.merge(attributetypeCollectionAttributetype);
                if (oldAttributestoragetypeidOfAttributetypeCollectionAttributetype != null) {
                    oldAttributestoragetypeidOfAttributetypeCollectionAttributetype.getAttributetypeCollection().remove(attributetypeCollectionAttributetype);
                    oldAttributestoragetypeidOfAttributetypeCollectionAttributetype = em.merge(oldAttributestoragetypeidOfAttributetypeCollectionAttributetype);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAttributestoragetype(attributestoragetype.getId()) != null) {
                throw new PreexistingEntityException("Attributestoragetype " + attributestoragetype + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Attributestoragetype attributestoragetype) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Attributestoragetype persistentAttributestoragetype = em.find(Attributestoragetype.class, attributestoragetype.getId());
            Collection<Attributetype> attributetypeCollectionOld = persistentAttributestoragetype.getAttributetypeCollection();
            Collection<Attributetype> attributetypeCollectionNew = attributestoragetype.getAttributetypeCollection();
            Collection<Attributetype> attachedAttributetypeCollectionNew = new ArrayList<Attributetype>();
            for (Attributetype attributetypeCollectionNewAttributetypeToAttach : attributetypeCollectionNew) {
                attributetypeCollectionNewAttributetypeToAttach = em.getReference(attributetypeCollectionNewAttributetypeToAttach.getClass(), attributetypeCollectionNewAttributetypeToAttach.getId());
                attachedAttributetypeCollectionNew.add(attributetypeCollectionNewAttributetypeToAttach);
            }
            attributetypeCollectionNew = attachedAttributetypeCollectionNew;
            attributestoragetype.setAttributetypeCollection(attributetypeCollectionNew);
            attributestoragetype = em.merge(attributestoragetype);
            for (Attributetype attributetypeCollectionOldAttributetype : attributetypeCollectionOld) {
                if (!attributetypeCollectionNew.contains(attributetypeCollectionOldAttributetype)) {
                    attributetypeCollectionOldAttributetype.setAttributestoragetypeid(null);
                    attributetypeCollectionOldAttributetype = em.merge(attributetypeCollectionOldAttributetype);
                }
            }
            for (Attributetype attributetypeCollectionNewAttributetype : attributetypeCollectionNew) {
                if (!attributetypeCollectionOld.contains(attributetypeCollectionNewAttributetype)) {
                    Attributestoragetype oldAttributestoragetypeidOfAttributetypeCollectionNewAttributetype = attributetypeCollectionNewAttributetype.getAttributestoragetypeid();
                    attributetypeCollectionNewAttributetype.setAttributestoragetypeid(attributestoragetype);
                    attributetypeCollectionNewAttributetype = em.merge(attributetypeCollectionNewAttributetype);
                    if (oldAttributestoragetypeidOfAttributetypeCollectionNewAttributetype != null && !oldAttributestoragetypeidOfAttributetypeCollectionNewAttributetype.equals(attributestoragetype)) {
                        oldAttributestoragetypeidOfAttributetypeCollectionNewAttributetype.getAttributetypeCollection().remove(attributetypeCollectionNewAttributetype);
                        oldAttributestoragetypeidOfAttributetypeCollectionNewAttributetype = em.merge(oldAttributestoragetypeidOfAttributetypeCollectionNewAttributetype);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = attributestoragetype.getId();
                if (findAttributestoragetype(id) == null) {
                    throw new NonexistentEntityException("The attributestoragetype with id " + id + " no longer exists.");
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
            Attributestoragetype attributestoragetype;
            try {
                attributestoragetype = em.getReference(Attributestoragetype.class, id);
                attributestoragetype.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The attributestoragetype with id " + id + " no longer exists.", enfe);
            }
            Collection<Attributetype> attributetypeCollection = attributestoragetype.getAttributetypeCollection();
            for (Attributetype attributetypeCollectionAttributetype : attributetypeCollection) {
                attributetypeCollectionAttributetype.setAttributestoragetypeid(null);
                attributetypeCollectionAttributetype = em.merge(attributetypeCollectionAttributetype);
            }
            em.remove(attributestoragetype);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Attributestoragetype> findAttributestoragetypeEntities() {
        return findAttributestoragetypeEntities(true, -1, -1);
    }

    public List<Attributestoragetype> findAttributestoragetypeEntities(int maxResults, int firstResult) {
        return findAttributestoragetypeEntities(false, maxResults, firstResult);
    }

    private List<Attributestoragetype> findAttributestoragetypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Attributestoragetype.class));
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

    public Attributestoragetype findAttributestoragetype(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Attributestoragetype.class, id);
        } finally {
            em.close();
        }
    }

    public int getAttributestoragetypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Attributestoragetype> rt = cq.from(Attributestoragetype.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
