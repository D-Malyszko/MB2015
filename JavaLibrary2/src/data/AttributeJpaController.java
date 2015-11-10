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
public class AttributeJpaController implements Serializable {

    public AttributeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Attribute attribute) throws PreexistingEntityException, Exception {
        if (attribute.getAssetentityCollection() == null) {
            attribute.setAssetentityCollection(new ArrayList<Assetentity>());
        }
        if (attribute.getAttributeCollection() == null) {
            attribute.setAttributeCollection(new ArrayList<Attribute>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Attribute parentid = attribute.getParentid();
            if (parentid != null) {
                parentid = em.getReference(parentid.getClass(), parentid.getId());
                attribute.setParentid(parentid);
            }
            Attributetype attributetypeid = attribute.getAttributetypeid();
            if (attributetypeid != null) {
                attributetypeid = em.getReference(attributetypeid.getClass(), attributetypeid.getId());
                attribute.setAttributetypeid(attributetypeid);
            }
            Collection<Assetentity> attachedAssetentityCollection = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionAssetentityToAttach : attribute.getAssetentityCollection()) {
                assetentityCollectionAssetentityToAttach = em.getReference(assetentityCollectionAssetentityToAttach.getClass(), assetentityCollectionAssetentityToAttach.getId());
                attachedAssetentityCollection.add(assetentityCollectionAssetentityToAttach);
            }
            attribute.setAssetentityCollection(attachedAssetentityCollection);
            Collection<Attribute> attachedAttributeCollection = new ArrayList<Attribute>();
            for (Attribute attributeCollectionAttributeToAttach : attribute.getAttributeCollection()) {
                attributeCollectionAttributeToAttach = em.getReference(attributeCollectionAttributeToAttach.getClass(), attributeCollectionAttributeToAttach.getId());
                attachedAttributeCollection.add(attributeCollectionAttributeToAttach);
            }
            attribute.setAttributeCollection(attachedAttributeCollection);
            em.persist(attribute);
            if (parentid != null) {
                parentid.getAttributeCollection().add(attribute);
                parentid = em.merge(parentid);
            }
            if (attributetypeid != null) {
                attributetypeid.getAttributeCollection().add(attribute);
                attributetypeid = em.merge(attributetypeid);
            }
            for (Assetentity assetentityCollectionAssetentity : attribute.getAssetentityCollection()) {
                Attribute oldMatchonattributeidOfAssetentityCollectionAssetentity = assetentityCollectionAssetentity.getMatchonattributeid();
                assetentityCollectionAssetentity.setMatchonattributeid(attribute);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
                if (oldMatchonattributeidOfAssetentityCollectionAssetentity != null) {
                    oldMatchonattributeidOfAssetentityCollectionAssetentity.getAssetentityCollection().remove(assetentityCollectionAssetentity);
                    oldMatchonattributeidOfAssetentityCollectionAssetentity = em.merge(oldMatchonattributeidOfAssetentityCollectionAssetentity);
                }
            }
            for (Attribute attributeCollectionAttribute : attribute.getAttributeCollection()) {
                Attribute oldParentidOfAttributeCollectionAttribute = attributeCollectionAttribute.getParentid();
                attributeCollectionAttribute.setParentid(attribute);
                attributeCollectionAttribute = em.merge(attributeCollectionAttribute);
                if (oldParentidOfAttributeCollectionAttribute != null) {
                    oldParentidOfAttributeCollectionAttribute.getAttributeCollection().remove(attributeCollectionAttribute);
                    oldParentidOfAttributeCollectionAttribute = em.merge(oldParentidOfAttributeCollectionAttribute);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAttribute(attribute.getId()) != null) {
                throw new PreexistingEntityException("Attribute " + attribute + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Attribute attribute) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Attribute persistentAttribute = em.find(Attribute.class, attribute.getId());
            Attribute parentidOld = persistentAttribute.getParentid();
            Attribute parentidNew = attribute.getParentid();
            Attributetype attributetypeidOld = persistentAttribute.getAttributetypeid();
            Attributetype attributetypeidNew = attribute.getAttributetypeid();
            Collection<Assetentity> assetentityCollectionOld = persistentAttribute.getAssetentityCollection();
            Collection<Assetentity> assetentityCollectionNew = attribute.getAssetentityCollection();
            Collection<Attribute> attributeCollectionOld = persistentAttribute.getAttributeCollection();
            Collection<Attribute> attributeCollectionNew = attribute.getAttributeCollection();
            if (parentidNew != null) {
                parentidNew = em.getReference(parentidNew.getClass(), parentidNew.getId());
                attribute.setParentid(parentidNew);
            }
            if (attributetypeidNew != null) {
                attributetypeidNew = em.getReference(attributetypeidNew.getClass(), attributetypeidNew.getId());
                attribute.setAttributetypeid(attributetypeidNew);
            }
            Collection<Assetentity> attachedAssetentityCollectionNew = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionNewAssetentityToAttach : assetentityCollectionNew) {
                assetentityCollectionNewAssetentityToAttach = em.getReference(assetentityCollectionNewAssetentityToAttach.getClass(), assetentityCollectionNewAssetentityToAttach.getId());
                attachedAssetentityCollectionNew.add(assetentityCollectionNewAssetentityToAttach);
            }
            assetentityCollectionNew = attachedAssetentityCollectionNew;
            attribute.setAssetentityCollection(assetentityCollectionNew);
            Collection<Attribute> attachedAttributeCollectionNew = new ArrayList<Attribute>();
            for (Attribute attributeCollectionNewAttributeToAttach : attributeCollectionNew) {
                attributeCollectionNewAttributeToAttach = em.getReference(attributeCollectionNewAttributeToAttach.getClass(), attributeCollectionNewAttributeToAttach.getId());
                attachedAttributeCollectionNew.add(attributeCollectionNewAttributeToAttach);
            }
            attributeCollectionNew = attachedAttributeCollectionNew;
            attribute.setAttributeCollection(attributeCollectionNew);
            attribute = em.merge(attribute);
            if (parentidOld != null && !parentidOld.equals(parentidNew)) {
                parentidOld.getAttributeCollection().remove(attribute);
                parentidOld = em.merge(parentidOld);
            }
            if (parentidNew != null && !parentidNew.equals(parentidOld)) {
                parentidNew.getAttributeCollection().add(attribute);
                parentidNew = em.merge(parentidNew);
            }
            if (attributetypeidOld != null && !attributetypeidOld.equals(attributetypeidNew)) {
                attributetypeidOld.getAttributeCollection().remove(attribute);
                attributetypeidOld = em.merge(attributetypeidOld);
            }
            if (attributetypeidNew != null && !attributetypeidNew.equals(attributetypeidOld)) {
                attributetypeidNew.getAttributeCollection().add(attribute);
                attributetypeidNew = em.merge(attributetypeidNew);
            }
            for (Assetentity assetentityCollectionOldAssetentity : assetentityCollectionOld) {
                if (!assetentityCollectionNew.contains(assetentityCollectionOldAssetentity)) {
                    assetentityCollectionOldAssetentity.setMatchonattributeid(null);
                    assetentityCollectionOldAssetentity = em.merge(assetentityCollectionOldAssetentity);
                }
            }
            for (Assetentity assetentityCollectionNewAssetentity : assetentityCollectionNew) {
                if (!assetentityCollectionOld.contains(assetentityCollectionNewAssetentity)) {
                    Attribute oldMatchonattributeidOfAssetentityCollectionNewAssetentity = assetentityCollectionNewAssetentity.getMatchonattributeid();
                    assetentityCollectionNewAssetentity.setMatchonattributeid(attribute);
                    assetentityCollectionNewAssetentity = em.merge(assetentityCollectionNewAssetentity);
                    if (oldMatchonattributeidOfAssetentityCollectionNewAssetentity != null && !oldMatchonattributeidOfAssetentityCollectionNewAssetentity.equals(attribute)) {
                        oldMatchonattributeidOfAssetentityCollectionNewAssetentity.getAssetentityCollection().remove(assetentityCollectionNewAssetentity);
                        oldMatchonattributeidOfAssetentityCollectionNewAssetentity = em.merge(oldMatchonattributeidOfAssetentityCollectionNewAssetentity);
                    }
                }
            }
            for (Attribute attributeCollectionOldAttribute : attributeCollectionOld) {
                if (!attributeCollectionNew.contains(attributeCollectionOldAttribute)) {
                    attributeCollectionOldAttribute.setParentid(null);
                    attributeCollectionOldAttribute = em.merge(attributeCollectionOldAttribute);
                }
            }
            for (Attribute attributeCollectionNewAttribute : attributeCollectionNew) {
                if (!attributeCollectionOld.contains(attributeCollectionNewAttribute)) {
                    Attribute oldParentidOfAttributeCollectionNewAttribute = attributeCollectionNewAttribute.getParentid();
                    attributeCollectionNewAttribute.setParentid(attribute);
                    attributeCollectionNewAttribute = em.merge(attributeCollectionNewAttribute);
                    if (oldParentidOfAttributeCollectionNewAttribute != null && !oldParentidOfAttributeCollectionNewAttribute.equals(attribute)) {
                        oldParentidOfAttributeCollectionNewAttribute.getAttributeCollection().remove(attributeCollectionNewAttribute);
                        oldParentidOfAttributeCollectionNewAttribute = em.merge(oldParentidOfAttributeCollectionNewAttribute);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = attribute.getId();
                if (findAttribute(id) == null) {
                    throw new NonexistentEntityException("The attribute with id " + id + " no longer exists.");
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
            Attribute attribute;
            try {
                attribute = em.getReference(Attribute.class, id);
                attribute.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The attribute with id " + id + " no longer exists.", enfe);
            }
            Attribute parentid = attribute.getParentid();
            if (parentid != null) {
                parentid.getAttributeCollection().remove(attribute);
                parentid = em.merge(parentid);
            }
            Attributetype attributetypeid = attribute.getAttributetypeid();
            if (attributetypeid != null) {
                attributetypeid.getAttributeCollection().remove(attribute);
                attributetypeid = em.merge(attributetypeid);
            }
            Collection<Assetentity> assetentityCollection = attribute.getAssetentityCollection();
            for (Assetentity assetentityCollectionAssetentity : assetentityCollection) {
                assetentityCollectionAssetentity.setMatchonattributeid(null);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
            }
            Collection<Attribute> attributeCollection = attribute.getAttributeCollection();
            for (Attribute attributeCollectionAttribute : attributeCollection) {
                attributeCollectionAttribute.setParentid(null);
                attributeCollectionAttribute = em.merge(attributeCollectionAttribute);
            }
            em.remove(attribute);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Attribute> findAttributeEntities() {
        return findAttributeEntities(true, -1, -1);
    }

    public List<Attribute> findAttributeEntities(int maxResults, int firstResult) {
        return findAttributeEntities(false, maxResults, firstResult);
    }

    private List<Attribute> findAttributeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Attribute.class));
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

    public Attribute findAttribute(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Attribute.class, id);
        } finally {
            em.close();
        }
    }

    public int getAttributeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Attribute> rt = cq.from(Attribute.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
