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
public class AttributetypeJpaController implements Serializable {

    public AttributetypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Attributetype attributetype) throws PreexistingEntityException, Exception {
        if (attributetype.getAttributeCollection() == null) {
            attributetype.setAttributeCollection(new ArrayList<Attribute>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Attributestoragetype attributestoragetypeid = attributetype.getAttributestoragetypeid();
            if (attributestoragetypeid != null) {
                attributestoragetypeid = em.getReference(attributestoragetypeid.getClass(), attributestoragetypeid.getId());
                attributetype.setAttributestoragetypeid(attributestoragetypeid);
            }
            Collection<Attribute> attachedAttributeCollection = new ArrayList<Attribute>();
            for (Attribute attributeCollectionAttributeToAttach : attributetype.getAttributeCollection()) {
                attributeCollectionAttributeToAttach = em.getReference(attributeCollectionAttributeToAttach.getClass(), attributeCollectionAttributeToAttach.getId());
                attachedAttributeCollection.add(attributeCollectionAttributeToAttach);
            }
            attributetype.setAttributeCollection(attachedAttributeCollection);
            em.persist(attributetype);
            if (attributestoragetypeid != null) {
                attributestoragetypeid.getAttributetypeCollection().add(attributetype);
                attributestoragetypeid = em.merge(attributestoragetypeid);
            }
            for (Attribute attributeCollectionAttribute : attributetype.getAttributeCollection()) {
                Attributetype oldAttributetypeidOfAttributeCollectionAttribute = attributeCollectionAttribute.getAttributetypeid();
                attributeCollectionAttribute.setAttributetypeid(attributetype);
                attributeCollectionAttribute = em.merge(attributeCollectionAttribute);
                if (oldAttributetypeidOfAttributeCollectionAttribute != null) {
                    oldAttributetypeidOfAttributeCollectionAttribute.getAttributeCollection().remove(attributeCollectionAttribute);
                    oldAttributetypeidOfAttributeCollectionAttribute = em.merge(oldAttributetypeidOfAttributeCollectionAttribute);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAttributetype(attributetype.getId()) != null) {
                throw new PreexistingEntityException("Attributetype " + attributetype + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Attributetype attributetype) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Attributetype persistentAttributetype = em.find(Attributetype.class, attributetype.getId());
            Attributestoragetype attributestoragetypeidOld = persistentAttributetype.getAttributestoragetypeid();
            Attributestoragetype attributestoragetypeidNew = attributetype.getAttributestoragetypeid();
            Collection<Attribute> attributeCollectionOld = persistentAttributetype.getAttributeCollection();
            Collection<Attribute> attributeCollectionNew = attributetype.getAttributeCollection();
            if (attributestoragetypeidNew != null) {
                attributestoragetypeidNew = em.getReference(attributestoragetypeidNew.getClass(), attributestoragetypeidNew.getId());
                attributetype.setAttributestoragetypeid(attributestoragetypeidNew);
            }
            Collection<Attribute> attachedAttributeCollectionNew = new ArrayList<Attribute>();
            for (Attribute attributeCollectionNewAttributeToAttach : attributeCollectionNew) {
                attributeCollectionNewAttributeToAttach = em.getReference(attributeCollectionNewAttributeToAttach.getClass(), attributeCollectionNewAttributeToAttach.getId());
                attachedAttributeCollectionNew.add(attributeCollectionNewAttributeToAttach);
            }
            attributeCollectionNew = attachedAttributeCollectionNew;
            attributetype.setAttributeCollection(attributeCollectionNew);
            attributetype = em.merge(attributetype);
            if (attributestoragetypeidOld != null && !attributestoragetypeidOld.equals(attributestoragetypeidNew)) {
                attributestoragetypeidOld.getAttributetypeCollection().remove(attributetype);
                attributestoragetypeidOld = em.merge(attributestoragetypeidOld);
            }
            if (attributestoragetypeidNew != null && !attributestoragetypeidNew.equals(attributestoragetypeidOld)) {
                attributestoragetypeidNew.getAttributetypeCollection().add(attributetype);
                attributestoragetypeidNew = em.merge(attributestoragetypeidNew);
            }
            for (Attribute attributeCollectionOldAttribute : attributeCollectionOld) {
                if (!attributeCollectionNew.contains(attributeCollectionOldAttribute)) {
                    attributeCollectionOldAttribute.setAttributetypeid(null);
                    attributeCollectionOldAttribute = em.merge(attributeCollectionOldAttribute);
                }
            }
            for (Attribute attributeCollectionNewAttribute : attributeCollectionNew) {
                if (!attributeCollectionOld.contains(attributeCollectionNewAttribute)) {
                    Attributetype oldAttributetypeidOfAttributeCollectionNewAttribute = attributeCollectionNewAttribute.getAttributetypeid();
                    attributeCollectionNewAttribute.setAttributetypeid(attributetype);
                    attributeCollectionNewAttribute = em.merge(attributeCollectionNewAttribute);
                    if (oldAttributetypeidOfAttributeCollectionNewAttribute != null && !oldAttributetypeidOfAttributeCollectionNewAttribute.equals(attributetype)) {
                        oldAttributetypeidOfAttributeCollectionNewAttribute.getAttributeCollection().remove(attributeCollectionNewAttribute);
                        oldAttributetypeidOfAttributeCollectionNewAttribute = em.merge(oldAttributetypeidOfAttributeCollectionNewAttribute);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = attributetype.getId();
                if (findAttributetype(id) == null) {
                    throw new NonexistentEntityException("The attributetype with id " + id + " no longer exists.");
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
            Attributetype attributetype;
            try {
                attributetype = em.getReference(Attributetype.class, id);
                attributetype.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The attributetype with id " + id + " no longer exists.", enfe);
            }
            Attributestoragetype attributestoragetypeid = attributetype.getAttributestoragetypeid();
            if (attributestoragetypeid != null) {
                attributestoragetypeid.getAttributetypeCollection().remove(attributetype);
                attributestoragetypeid = em.merge(attributestoragetypeid);
            }
            Collection<Attribute> attributeCollection = attributetype.getAttributeCollection();
            for (Attribute attributeCollectionAttribute : attributeCollection) {
                attributeCollectionAttribute.setAttributetypeid(null);
                attributeCollectionAttribute = em.merge(attributeCollectionAttribute);
            }
            em.remove(attributetype);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Attributetype> findAttributetypeEntities() {
        return findAttributetypeEntities(true, -1, -1);
    }

    public List<Attributetype> findAttributetypeEntities(int maxResults, int firstResult) {
        return findAttributetypeEntities(false, maxResults, firstResult);
    }

    private List<Attributetype> findAttributetypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Attributetype.class));
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

    public Attributetype findAttributetype(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Attributetype.class, id);
        } finally {
            em.close();
        }
    }

    public int getAttributetypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Attributetype> rt = cq.from(Attributetype.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
