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
public class CmCategoryJpaController implements Serializable {

    public CmCategoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CmCategory cmCategory) throws PreexistingEntityException, Exception {
        if (cmCategory.getOrgunitCollection() == null) {
            cmCategory.setOrgunitCollection(new ArrayList<Orgunit>());
        }
        if (cmCategory.getOrgunitCollection1() == null) {
            cmCategory.setOrgunitCollection1(new ArrayList<Orgunit>());
        }
        if (cmCategory.getCmCategoryCollection() == null) {
            cmCategory.setCmCategoryCollection(new ArrayList<CmCategory>());
        }
        if (cmCategory.getAssetentityCollection() == null) {
            cmCategory.setAssetentityCollection(new ArrayList<Assetentity>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asset extensionassetid = cmCategory.getExtensionassetid();
            if (extensionassetid != null) {
                extensionassetid = em.getReference(extensionassetid.getClass(), extensionassetid.getId());
                cmCategory.setExtensionassetid(extensionassetid);
            }
            CmCategory parentid = cmCategory.getParentid();
            if (parentid != null) {
                parentid = em.getReference(parentid.getClass(), parentid.getId());
                cmCategory.setParentid(parentid);
            }
            CmCategorytype categorytypeid = cmCategory.getCategorytypeid();
            if (categorytypeid != null) {
                categorytypeid = em.getReference(categorytypeid.getClass(), categorytypeid.getId());
                cmCategory.setCategorytypeid(categorytypeid);
            }
            Collection<Orgunit> attachedOrgunitCollection = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollectionOrgunitToAttach : cmCategory.getOrgunitCollection()) {
                orgunitCollectionOrgunitToAttach = em.getReference(orgunitCollectionOrgunitToAttach.getClass(), orgunitCollectionOrgunitToAttach.getId());
                attachedOrgunitCollection.add(orgunitCollectionOrgunitToAttach);
            }
            cmCategory.setOrgunitCollection(attachedOrgunitCollection);
            Collection<Orgunit> attachedOrgunitCollection1 = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollection1OrgunitToAttach : cmCategory.getOrgunitCollection1()) {
                orgunitCollection1OrgunitToAttach = em.getReference(orgunitCollection1OrgunitToAttach.getClass(), orgunitCollection1OrgunitToAttach.getId());
                attachedOrgunitCollection1.add(orgunitCollection1OrgunitToAttach);
            }
            cmCategory.setOrgunitCollection1(attachedOrgunitCollection1);
            Collection<CmCategory> attachedCmCategoryCollection = new ArrayList<CmCategory>();
            for (CmCategory cmCategoryCollectionCmCategoryToAttach : cmCategory.getCmCategoryCollection()) {
                cmCategoryCollectionCmCategoryToAttach = em.getReference(cmCategoryCollectionCmCategoryToAttach.getClass(), cmCategoryCollectionCmCategoryToAttach.getId());
                attachedCmCategoryCollection.add(cmCategoryCollectionCmCategoryToAttach);
            }
            cmCategory.setCmCategoryCollection(attachedCmCategoryCollection);
            Collection<Assetentity> attachedAssetentityCollection = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionAssetentityToAttach : cmCategory.getAssetentityCollection()) {
                assetentityCollectionAssetentityToAttach = em.getReference(assetentityCollectionAssetentityToAttach.getClass(), assetentityCollectionAssetentityToAttach.getId());
                attachedAssetentityCollection.add(assetentityCollectionAssetentityToAttach);
            }
            cmCategory.setAssetentityCollection(attachedAssetentityCollection);
            em.persist(cmCategory);
            if (extensionassetid != null) {
                extensionassetid.getCmCategoryCollection().add(cmCategory);
                extensionassetid = em.merge(extensionassetid);
            }
            if (parentid != null) {
                parentid.getCmCategoryCollection().add(cmCategory);
                parentid = em.merge(parentid);
            }
            if (categorytypeid != null) {
                categorytypeid.getCmCategoryCollection().add(cmCategory);
                categorytypeid = em.merge(categorytypeid);
            }
            for (Orgunit orgunitCollectionOrgunit : cmCategory.getOrgunitCollection()) {
                CmCategory oldRootorgunitcategoryidOfOrgunitCollectionOrgunit = orgunitCollectionOrgunit.getRootorgunitcategoryid();
                orgunitCollectionOrgunit.setRootorgunitcategoryid(cmCategory);
                orgunitCollectionOrgunit = em.merge(orgunitCollectionOrgunit);
                if (oldRootorgunitcategoryidOfOrgunitCollectionOrgunit != null) {
                    oldRootorgunitcategoryidOfOrgunitCollectionOrgunit.getOrgunitCollection().remove(orgunitCollectionOrgunit);
                    oldRootorgunitcategoryidOfOrgunitCollectionOrgunit = em.merge(oldRootorgunitcategoryidOfOrgunitCollectionOrgunit);
                }
            }
            for (Orgunit orgunitCollection1Orgunit : cmCategory.getOrgunitCollection1()) {
                CmCategory oldRootdescriptivecategoryidOfOrgunitCollection1Orgunit = orgunitCollection1Orgunit.getRootdescriptivecategoryid();
                orgunitCollection1Orgunit.setRootdescriptivecategoryid(cmCategory);
                orgunitCollection1Orgunit = em.merge(orgunitCollection1Orgunit);
                if (oldRootdescriptivecategoryidOfOrgunitCollection1Orgunit != null) {
                    oldRootdescriptivecategoryidOfOrgunitCollection1Orgunit.getOrgunitCollection1().remove(orgunitCollection1Orgunit);
                    oldRootdescriptivecategoryidOfOrgunitCollection1Orgunit = em.merge(oldRootdescriptivecategoryidOfOrgunitCollection1Orgunit);
                }
            }
            for (CmCategory cmCategoryCollectionCmCategory : cmCategory.getCmCategoryCollection()) {
                CmCategory oldParentidOfCmCategoryCollectionCmCategory = cmCategoryCollectionCmCategory.getParentid();
                cmCategoryCollectionCmCategory.setParentid(cmCategory);
                cmCategoryCollectionCmCategory = em.merge(cmCategoryCollectionCmCategory);
                if (oldParentidOfCmCategoryCollectionCmCategory != null) {
                    oldParentidOfCmCategoryCollectionCmCategory.getCmCategoryCollection().remove(cmCategoryCollectionCmCategory);
                    oldParentidOfCmCategoryCollectionCmCategory = em.merge(oldParentidOfCmCategoryCollectionCmCategory);
                }
            }
            for (Assetentity assetentityCollectionAssetentity : cmCategory.getAssetentityCollection()) {
                CmCategory oldRootcategoryidOfAssetentityCollectionAssetentity = assetentityCollectionAssetentity.getRootcategoryid();
                assetentityCollectionAssetentity.setRootcategoryid(cmCategory);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
                if (oldRootcategoryidOfAssetentityCollectionAssetentity != null) {
                    oldRootcategoryidOfAssetentityCollectionAssetentity.getAssetentityCollection().remove(assetentityCollectionAssetentity);
                    oldRootcategoryidOfAssetentityCollectionAssetentity = em.merge(oldRootcategoryidOfAssetentityCollectionAssetentity);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCmCategory(cmCategory.getId()) != null) {
                throw new PreexistingEntityException("CmCategory " + cmCategory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CmCategory cmCategory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CmCategory persistentCmCategory = em.find(CmCategory.class, cmCategory.getId());
            Asset extensionassetidOld = persistentCmCategory.getExtensionassetid();
            Asset extensionassetidNew = cmCategory.getExtensionassetid();
            CmCategory parentidOld = persistentCmCategory.getParentid();
            CmCategory parentidNew = cmCategory.getParentid();
            CmCategorytype categorytypeidOld = persistentCmCategory.getCategorytypeid();
            CmCategorytype categorytypeidNew = cmCategory.getCategorytypeid();
            Collection<Orgunit> orgunitCollectionOld = persistentCmCategory.getOrgunitCollection();
            Collection<Orgunit> orgunitCollectionNew = cmCategory.getOrgunitCollection();
            Collection<Orgunit> orgunitCollection1Old = persistentCmCategory.getOrgunitCollection1();
            Collection<Orgunit> orgunitCollection1New = cmCategory.getOrgunitCollection1();
            Collection<CmCategory> cmCategoryCollectionOld = persistentCmCategory.getCmCategoryCollection();
            Collection<CmCategory> cmCategoryCollectionNew = cmCategory.getCmCategoryCollection();
            Collection<Assetentity> assetentityCollectionOld = persistentCmCategory.getAssetentityCollection();
            Collection<Assetentity> assetentityCollectionNew = cmCategory.getAssetentityCollection();
            if (extensionassetidNew != null) {
                extensionassetidNew = em.getReference(extensionassetidNew.getClass(), extensionassetidNew.getId());
                cmCategory.setExtensionassetid(extensionassetidNew);
            }
            if (parentidNew != null) {
                parentidNew = em.getReference(parentidNew.getClass(), parentidNew.getId());
                cmCategory.setParentid(parentidNew);
            }
            if (categorytypeidNew != null) {
                categorytypeidNew = em.getReference(categorytypeidNew.getClass(), categorytypeidNew.getId());
                cmCategory.setCategorytypeid(categorytypeidNew);
            }
            Collection<Orgunit> attachedOrgunitCollectionNew = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollectionNewOrgunitToAttach : orgunitCollectionNew) {
                orgunitCollectionNewOrgunitToAttach = em.getReference(orgunitCollectionNewOrgunitToAttach.getClass(), orgunitCollectionNewOrgunitToAttach.getId());
                attachedOrgunitCollectionNew.add(orgunitCollectionNewOrgunitToAttach);
            }
            orgunitCollectionNew = attachedOrgunitCollectionNew;
            cmCategory.setOrgunitCollection(orgunitCollectionNew);
            Collection<Orgunit> attachedOrgunitCollection1New = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollection1NewOrgunitToAttach : orgunitCollection1New) {
                orgunitCollection1NewOrgunitToAttach = em.getReference(orgunitCollection1NewOrgunitToAttach.getClass(), orgunitCollection1NewOrgunitToAttach.getId());
                attachedOrgunitCollection1New.add(orgunitCollection1NewOrgunitToAttach);
            }
            orgunitCollection1New = attachedOrgunitCollection1New;
            cmCategory.setOrgunitCollection1(orgunitCollection1New);
            Collection<CmCategory> attachedCmCategoryCollectionNew = new ArrayList<CmCategory>();
            for (CmCategory cmCategoryCollectionNewCmCategoryToAttach : cmCategoryCollectionNew) {
                cmCategoryCollectionNewCmCategoryToAttach = em.getReference(cmCategoryCollectionNewCmCategoryToAttach.getClass(), cmCategoryCollectionNewCmCategoryToAttach.getId());
                attachedCmCategoryCollectionNew.add(cmCategoryCollectionNewCmCategoryToAttach);
            }
            cmCategoryCollectionNew = attachedCmCategoryCollectionNew;
            cmCategory.setCmCategoryCollection(cmCategoryCollectionNew);
            Collection<Assetentity> attachedAssetentityCollectionNew = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionNewAssetentityToAttach : assetentityCollectionNew) {
                assetentityCollectionNewAssetentityToAttach = em.getReference(assetentityCollectionNewAssetentityToAttach.getClass(), assetentityCollectionNewAssetentityToAttach.getId());
                attachedAssetentityCollectionNew.add(assetentityCollectionNewAssetentityToAttach);
            }
            assetentityCollectionNew = attachedAssetentityCollectionNew;
            cmCategory.setAssetentityCollection(assetentityCollectionNew);
            cmCategory = em.merge(cmCategory);
            if (extensionassetidOld != null && !extensionassetidOld.equals(extensionassetidNew)) {
                extensionassetidOld.getCmCategoryCollection().remove(cmCategory);
                extensionassetidOld = em.merge(extensionassetidOld);
            }
            if (extensionassetidNew != null && !extensionassetidNew.equals(extensionassetidOld)) {
                extensionassetidNew.getCmCategoryCollection().add(cmCategory);
                extensionassetidNew = em.merge(extensionassetidNew);
            }
            if (parentidOld != null && !parentidOld.equals(parentidNew)) {
                parentidOld.getCmCategoryCollection().remove(cmCategory);
                parentidOld = em.merge(parentidOld);
            }
            if (parentidNew != null && !parentidNew.equals(parentidOld)) {
                parentidNew.getCmCategoryCollection().add(cmCategory);
                parentidNew = em.merge(parentidNew);
            }
            if (categorytypeidOld != null && !categorytypeidOld.equals(categorytypeidNew)) {
                categorytypeidOld.getCmCategoryCollection().remove(cmCategory);
                categorytypeidOld = em.merge(categorytypeidOld);
            }
            if (categorytypeidNew != null && !categorytypeidNew.equals(categorytypeidOld)) {
                categorytypeidNew.getCmCategoryCollection().add(cmCategory);
                categorytypeidNew = em.merge(categorytypeidNew);
            }
            for (Orgunit orgunitCollectionOldOrgunit : orgunitCollectionOld) {
                if (!orgunitCollectionNew.contains(orgunitCollectionOldOrgunit)) {
                    orgunitCollectionOldOrgunit.setRootorgunitcategoryid(null);
                    orgunitCollectionOldOrgunit = em.merge(orgunitCollectionOldOrgunit);
                }
            }
            for (Orgunit orgunitCollectionNewOrgunit : orgunitCollectionNew) {
                if (!orgunitCollectionOld.contains(orgunitCollectionNewOrgunit)) {
                    CmCategory oldRootorgunitcategoryidOfOrgunitCollectionNewOrgunit = orgunitCollectionNewOrgunit.getRootorgunitcategoryid();
                    orgunitCollectionNewOrgunit.setRootorgunitcategoryid(cmCategory);
                    orgunitCollectionNewOrgunit = em.merge(orgunitCollectionNewOrgunit);
                    if (oldRootorgunitcategoryidOfOrgunitCollectionNewOrgunit != null && !oldRootorgunitcategoryidOfOrgunitCollectionNewOrgunit.equals(cmCategory)) {
                        oldRootorgunitcategoryidOfOrgunitCollectionNewOrgunit.getOrgunitCollection().remove(orgunitCollectionNewOrgunit);
                        oldRootorgunitcategoryidOfOrgunitCollectionNewOrgunit = em.merge(oldRootorgunitcategoryidOfOrgunitCollectionNewOrgunit);
                    }
                }
            }
            for (Orgunit orgunitCollection1OldOrgunit : orgunitCollection1Old) {
                if (!orgunitCollection1New.contains(orgunitCollection1OldOrgunit)) {
                    orgunitCollection1OldOrgunit.setRootdescriptivecategoryid(null);
                    orgunitCollection1OldOrgunit = em.merge(orgunitCollection1OldOrgunit);
                }
            }
            for (Orgunit orgunitCollection1NewOrgunit : orgunitCollection1New) {
                if (!orgunitCollection1Old.contains(orgunitCollection1NewOrgunit)) {
                    CmCategory oldRootdescriptivecategoryidOfOrgunitCollection1NewOrgunit = orgunitCollection1NewOrgunit.getRootdescriptivecategoryid();
                    orgunitCollection1NewOrgunit.setRootdescriptivecategoryid(cmCategory);
                    orgunitCollection1NewOrgunit = em.merge(orgunitCollection1NewOrgunit);
                    if (oldRootdescriptivecategoryidOfOrgunitCollection1NewOrgunit != null && !oldRootdescriptivecategoryidOfOrgunitCollection1NewOrgunit.equals(cmCategory)) {
                        oldRootdescriptivecategoryidOfOrgunitCollection1NewOrgunit.getOrgunitCollection1().remove(orgunitCollection1NewOrgunit);
                        oldRootdescriptivecategoryidOfOrgunitCollection1NewOrgunit = em.merge(oldRootdescriptivecategoryidOfOrgunitCollection1NewOrgunit);
                    }
                }
            }
            for (CmCategory cmCategoryCollectionOldCmCategory : cmCategoryCollectionOld) {
                if (!cmCategoryCollectionNew.contains(cmCategoryCollectionOldCmCategory)) {
                    cmCategoryCollectionOldCmCategory.setParentid(null);
                    cmCategoryCollectionOldCmCategory = em.merge(cmCategoryCollectionOldCmCategory);
                }
            }
            for (CmCategory cmCategoryCollectionNewCmCategory : cmCategoryCollectionNew) {
                if (!cmCategoryCollectionOld.contains(cmCategoryCollectionNewCmCategory)) {
                    CmCategory oldParentidOfCmCategoryCollectionNewCmCategory = cmCategoryCollectionNewCmCategory.getParentid();
                    cmCategoryCollectionNewCmCategory.setParentid(cmCategory);
                    cmCategoryCollectionNewCmCategory = em.merge(cmCategoryCollectionNewCmCategory);
                    if (oldParentidOfCmCategoryCollectionNewCmCategory != null && !oldParentidOfCmCategoryCollectionNewCmCategory.equals(cmCategory)) {
                        oldParentidOfCmCategoryCollectionNewCmCategory.getCmCategoryCollection().remove(cmCategoryCollectionNewCmCategory);
                        oldParentidOfCmCategoryCollectionNewCmCategory = em.merge(oldParentidOfCmCategoryCollectionNewCmCategory);
                    }
                }
            }
            for (Assetentity assetentityCollectionOldAssetentity : assetentityCollectionOld) {
                if (!assetentityCollectionNew.contains(assetentityCollectionOldAssetentity)) {
                    assetentityCollectionOldAssetentity.setRootcategoryid(null);
                    assetentityCollectionOldAssetentity = em.merge(assetentityCollectionOldAssetentity);
                }
            }
            for (Assetentity assetentityCollectionNewAssetentity : assetentityCollectionNew) {
                if (!assetentityCollectionOld.contains(assetentityCollectionNewAssetentity)) {
                    CmCategory oldRootcategoryidOfAssetentityCollectionNewAssetentity = assetentityCollectionNewAssetentity.getRootcategoryid();
                    assetentityCollectionNewAssetentity.setRootcategoryid(cmCategory);
                    assetentityCollectionNewAssetentity = em.merge(assetentityCollectionNewAssetentity);
                    if (oldRootcategoryidOfAssetentityCollectionNewAssetentity != null && !oldRootcategoryidOfAssetentityCollectionNewAssetentity.equals(cmCategory)) {
                        oldRootcategoryidOfAssetentityCollectionNewAssetentity.getAssetentityCollection().remove(assetentityCollectionNewAssetentity);
                        oldRootcategoryidOfAssetentityCollectionNewAssetentity = em.merge(oldRootcategoryidOfAssetentityCollectionNewAssetentity);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cmCategory.getId();
                if (findCmCategory(id) == null) {
                    throw new NonexistentEntityException("The cmCategory with id " + id + " no longer exists.");
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
            CmCategory cmCategory;
            try {
                cmCategory = em.getReference(CmCategory.class, id);
                cmCategory.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cmCategory with id " + id + " no longer exists.", enfe);
            }
            Asset extensionassetid = cmCategory.getExtensionassetid();
            if (extensionassetid != null) {
                extensionassetid.getCmCategoryCollection().remove(cmCategory);
                extensionassetid = em.merge(extensionassetid);
            }
            CmCategory parentid = cmCategory.getParentid();
            if (parentid != null) {
                parentid.getCmCategoryCollection().remove(cmCategory);
                parentid = em.merge(parentid);
            }
            CmCategorytype categorytypeid = cmCategory.getCategorytypeid();
            if (categorytypeid != null) {
                categorytypeid.getCmCategoryCollection().remove(cmCategory);
                categorytypeid = em.merge(categorytypeid);
            }
            Collection<Orgunit> orgunitCollection = cmCategory.getOrgunitCollection();
            for (Orgunit orgunitCollectionOrgunit : orgunitCollection) {
                orgunitCollectionOrgunit.setRootorgunitcategoryid(null);
                orgunitCollectionOrgunit = em.merge(orgunitCollectionOrgunit);
            }
            Collection<Orgunit> orgunitCollection1 = cmCategory.getOrgunitCollection1();
            for (Orgunit orgunitCollection1Orgunit : orgunitCollection1) {
                orgunitCollection1Orgunit.setRootdescriptivecategoryid(null);
                orgunitCollection1Orgunit = em.merge(orgunitCollection1Orgunit);
            }
            Collection<CmCategory> cmCategoryCollection = cmCategory.getCmCategoryCollection();
            for (CmCategory cmCategoryCollectionCmCategory : cmCategoryCollection) {
                cmCategoryCollectionCmCategory.setParentid(null);
                cmCategoryCollectionCmCategory = em.merge(cmCategoryCollectionCmCategory);
            }
            Collection<Assetentity> assetentityCollection = cmCategory.getAssetentityCollection();
            for (Assetentity assetentityCollectionAssetentity : assetentityCollection) {
                assetentityCollectionAssetentity.setRootcategoryid(null);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
            }
            em.remove(cmCategory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CmCategory> findCmCategoryEntities() {
        return findCmCategoryEntities(true, -1, -1);
    }

    public List<CmCategory> findCmCategoryEntities(int maxResults, int firstResult) {
        return findCmCategoryEntities(false, maxResults, firstResult);
    }

    private List<CmCategory> findCmCategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CmCategory.class));
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

    public CmCategory findCmCategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CmCategory.class, id);
        } finally {
            em.close();
        }
    }

    public int getCmCategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CmCategory> rt = cq.from(CmCategory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
