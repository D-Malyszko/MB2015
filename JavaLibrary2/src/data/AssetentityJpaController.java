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
public class AssetentityJpaController implements Serializable {

    public AssetentityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assetentity assetentity) throws PreexistingEntityException, Exception {
        if (assetentity.getAssettypeCollection() == null) {
            assetentity.setAssettypeCollection(new ArrayList<Assettype>());
        }
        if (assetentity.getUsergroupCollection() == null) {
            assetentity.setUsergroupCollection(new ArrayList<Usergroup>());
        }
        if (assetentity.getAssetCollection() == null) {
            assetentity.setAssetCollection(new ArrayList<Asset>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Attribute matchonattributeid = assetentity.getMatchonattributeid();
            if (matchonattributeid != null) {
                matchonattributeid = em.getReference(matchonattributeid.getClass(), matchonattributeid.getId());
                assetentity.setMatchonattributeid(matchonattributeid);
            }
            CmCategory rootcategoryid = assetentity.getRootcategoryid();
            if (rootcategoryid != null) {
                rootcategoryid = em.getReference(rootcategoryid.getClass(), rootcategoryid.getId());
                assetentity.setRootcategoryid(rootcategoryid);
            }
            Collection<Assettype> attachedAssettypeCollection = new ArrayList<Assettype>();
            for (Assettype assettypeCollectionAssettypeToAttach : assetentity.getAssettypeCollection()) {
                assettypeCollectionAssettypeToAttach = em.getReference(assettypeCollectionAssettypeToAttach.getClass(), assettypeCollectionAssettypeToAttach.getId());
                attachedAssettypeCollection.add(assettypeCollectionAssettypeToAttach);
            }
            assetentity.setAssettypeCollection(attachedAssettypeCollection);
            Collection<Usergroup> attachedUsergroupCollection = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionUsergroupToAttach : assetentity.getUsergroupCollection()) {
                usergroupCollectionUsergroupToAttach = em.getReference(usergroupCollectionUsergroupToAttach.getClass(), usergroupCollectionUsergroupToAttach.getId());
                attachedUsergroupCollection.add(usergroupCollectionUsergroupToAttach);
            }
            assetentity.setUsergroupCollection(attachedUsergroupCollection);
            Collection<Asset> attachedAssetCollection = new ArrayList<Asset>();
            for (Asset assetCollectionAssetToAttach : assetentity.getAssetCollection()) {
                assetCollectionAssetToAttach = em.getReference(assetCollectionAssetToAttach.getClass(), assetCollectionAssetToAttach.getId());
                attachedAssetCollection.add(assetCollectionAssetToAttach);
            }
            assetentity.setAssetCollection(attachedAssetCollection);
            em.persist(assetentity);
            if (matchonattributeid != null) {
                matchonattributeid.getAssetentityCollection().add(assetentity);
                matchonattributeid = em.merge(matchonattributeid);
            }
            if (rootcategoryid != null) {
                rootcategoryid.getAssetentityCollection().add(assetentity);
                rootcategoryid = em.merge(rootcategoryid);
            }
            for (Assettype assettypeCollectionAssettype : assetentity.getAssettypeCollection()) {
                assettypeCollectionAssettype.getAssetentityCollection().add(assetentity);
                assettypeCollectionAssettype = em.merge(assettypeCollectionAssettype);
            }
            for (Usergroup usergroupCollectionUsergroup : assetentity.getUsergroupCollection()) {
                usergroupCollectionUsergroup.getAssetentityCollection().add(assetentity);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            for (Asset assetCollectionAsset : assetentity.getAssetCollection()) {
                Assetentity oldAssetentityidOfAssetCollectionAsset = assetCollectionAsset.getAssetentityid();
                assetCollectionAsset.setAssetentityid(assetentity);
                assetCollectionAsset = em.merge(assetCollectionAsset);
                if (oldAssetentityidOfAssetCollectionAsset != null) {
                    oldAssetentityidOfAssetCollectionAsset.getAssetCollection().remove(assetCollectionAsset);
                    oldAssetentityidOfAssetCollectionAsset = em.merge(oldAssetentityidOfAssetCollectionAsset);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAssetentity(assetentity.getId()) != null) {
                throw new PreexistingEntityException("Assetentity " + assetentity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Assetentity assetentity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assetentity persistentAssetentity = em.find(Assetentity.class, assetentity.getId());
            Attribute matchonattributeidOld = persistentAssetentity.getMatchonattributeid();
            Attribute matchonattributeidNew = assetentity.getMatchonattributeid();
            CmCategory rootcategoryidOld = persistentAssetentity.getRootcategoryid();
            CmCategory rootcategoryidNew = assetentity.getRootcategoryid();
            Collection<Assettype> assettypeCollectionOld = persistentAssetentity.getAssettypeCollection();
            Collection<Assettype> assettypeCollectionNew = assetentity.getAssettypeCollection();
            Collection<Usergroup> usergroupCollectionOld = persistentAssetentity.getUsergroupCollection();
            Collection<Usergroup> usergroupCollectionNew = assetentity.getUsergroupCollection();
            Collection<Asset> assetCollectionOld = persistentAssetentity.getAssetCollection();
            Collection<Asset> assetCollectionNew = assetentity.getAssetCollection();
            if (matchonattributeidNew != null) {
                matchonattributeidNew = em.getReference(matchonattributeidNew.getClass(), matchonattributeidNew.getId());
                assetentity.setMatchonattributeid(matchonattributeidNew);
            }
            if (rootcategoryidNew != null) {
                rootcategoryidNew = em.getReference(rootcategoryidNew.getClass(), rootcategoryidNew.getId());
                assetentity.setRootcategoryid(rootcategoryidNew);
            }
            Collection<Assettype> attachedAssettypeCollectionNew = new ArrayList<Assettype>();
            for (Assettype assettypeCollectionNewAssettypeToAttach : assettypeCollectionNew) {
                assettypeCollectionNewAssettypeToAttach = em.getReference(assettypeCollectionNewAssettypeToAttach.getClass(), assettypeCollectionNewAssettypeToAttach.getId());
                attachedAssettypeCollectionNew.add(assettypeCollectionNewAssettypeToAttach);
            }
            assettypeCollectionNew = attachedAssettypeCollectionNew;
            assetentity.setAssettypeCollection(assettypeCollectionNew);
            Collection<Usergroup> attachedUsergroupCollectionNew = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionNewUsergroupToAttach : usergroupCollectionNew) {
                usergroupCollectionNewUsergroupToAttach = em.getReference(usergroupCollectionNewUsergroupToAttach.getClass(), usergroupCollectionNewUsergroupToAttach.getId());
                attachedUsergroupCollectionNew.add(usergroupCollectionNewUsergroupToAttach);
            }
            usergroupCollectionNew = attachedUsergroupCollectionNew;
            assetentity.setUsergroupCollection(usergroupCollectionNew);
            Collection<Asset> attachedAssetCollectionNew = new ArrayList<Asset>();
            for (Asset assetCollectionNewAssetToAttach : assetCollectionNew) {
                assetCollectionNewAssetToAttach = em.getReference(assetCollectionNewAssetToAttach.getClass(), assetCollectionNewAssetToAttach.getId());
                attachedAssetCollectionNew.add(assetCollectionNewAssetToAttach);
            }
            assetCollectionNew = attachedAssetCollectionNew;
            assetentity.setAssetCollection(assetCollectionNew);
            assetentity = em.merge(assetentity);
            if (matchonattributeidOld != null && !matchonattributeidOld.equals(matchonattributeidNew)) {
                matchonattributeidOld.getAssetentityCollection().remove(assetentity);
                matchonattributeidOld = em.merge(matchonattributeidOld);
            }
            if (matchonattributeidNew != null && !matchonattributeidNew.equals(matchonattributeidOld)) {
                matchonattributeidNew.getAssetentityCollection().add(assetentity);
                matchonattributeidNew = em.merge(matchonattributeidNew);
            }
            if (rootcategoryidOld != null && !rootcategoryidOld.equals(rootcategoryidNew)) {
                rootcategoryidOld.getAssetentityCollection().remove(assetentity);
                rootcategoryidOld = em.merge(rootcategoryidOld);
            }
            if (rootcategoryidNew != null && !rootcategoryidNew.equals(rootcategoryidOld)) {
                rootcategoryidNew.getAssetentityCollection().add(assetentity);
                rootcategoryidNew = em.merge(rootcategoryidNew);
            }
            for (Assettype assettypeCollectionOldAssettype : assettypeCollectionOld) {
                if (!assettypeCollectionNew.contains(assettypeCollectionOldAssettype)) {
                    assettypeCollectionOldAssettype.getAssetentityCollection().remove(assetentity);
                    assettypeCollectionOldAssettype = em.merge(assettypeCollectionOldAssettype);
                }
            }
            for (Assettype assettypeCollectionNewAssettype : assettypeCollectionNew) {
                if (!assettypeCollectionOld.contains(assettypeCollectionNewAssettype)) {
                    assettypeCollectionNewAssettype.getAssetentityCollection().add(assetentity);
                    assettypeCollectionNewAssettype = em.merge(assettypeCollectionNewAssettype);
                }
            }
            for (Usergroup usergroupCollectionOldUsergroup : usergroupCollectionOld) {
                if (!usergroupCollectionNew.contains(usergroupCollectionOldUsergroup)) {
                    usergroupCollectionOldUsergroup.getAssetentityCollection().remove(assetentity);
                    usergroupCollectionOldUsergroup = em.merge(usergroupCollectionOldUsergroup);
                }
            }
            for (Usergroup usergroupCollectionNewUsergroup : usergroupCollectionNew) {
                if (!usergroupCollectionOld.contains(usergroupCollectionNewUsergroup)) {
                    usergroupCollectionNewUsergroup.getAssetentityCollection().add(assetentity);
                    usergroupCollectionNewUsergroup = em.merge(usergroupCollectionNewUsergroup);
                }
            }
            for (Asset assetCollectionOldAsset : assetCollectionOld) {
                if (!assetCollectionNew.contains(assetCollectionOldAsset)) {
                    assetCollectionOldAsset.setAssetentityid(null);
                    assetCollectionOldAsset = em.merge(assetCollectionOldAsset);
                }
            }
            for (Asset assetCollectionNewAsset : assetCollectionNew) {
                if (!assetCollectionOld.contains(assetCollectionNewAsset)) {
                    Assetentity oldAssetentityidOfAssetCollectionNewAsset = assetCollectionNewAsset.getAssetentityid();
                    assetCollectionNewAsset.setAssetentityid(assetentity);
                    assetCollectionNewAsset = em.merge(assetCollectionNewAsset);
                    if (oldAssetentityidOfAssetCollectionNewAsset != null && !oldAssetentityidOfAssetCollectionNewAsset.equals(assetentity)) {
                        oldAssetentityidOfAssetCollectionNewAsset.getAssetCollection().remove(assetCollectionNewAsset);
                        oldAssetentityidOfAssetCollectionNewAsset = em.merge(oldAssetentityidOfAssetCollectionNewAsset);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = assetentity.getId();
                if (findAssetentity(id) == null) {
                    throw new NonexistentEntityException("The assetentity with id " + id + " no longer exists.");
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
            Assetentity assetentity;
            try {
                assetentity = em.getReference(Assetentity.class, id);
                assetentity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assetentity with id " + id + " no longer exists.", enfe);
            }
            Attribute matchonattributeid = assetentity.getMatchonattributeid();
            if (matchonattributeid != null) {
                matchonattributeid.getAssetentityCollection().remove(assetentity);
                matchonattributeid = em.merge(matchonattributeid);
            }
            CmCategory rootcategoryid = assetentity.getRootcategoryid();
            if (rootcategoryid != null) {
                rootcategoryid.getAssetentityCollection().remove(assetentity);
                rootcategoryid = em.merge(rootcategoryid);
            }
            Collection<Assettype> assettypeCollection = assetentity.getAssettypeCollection();
            for (Assettype assettypeCollectionAssettype : assettypeCollection) {
                assettypeCollectionAssettype.getAssetentityCollection().remove(assetentity);
                assettypeCollectionAssettype = em.merge(assettypeCollectionAssettype);
            }
            Collection<Usergroup> usergroupCollection = assetentity.getUsergroupCollection();
            for (Usergroup usergroupCollectionUsergroup : usergroupCollection) {
                usergroupCollectionUsergroup.getAssetentityCollection().remove(assetentity);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            Collection<Asset> assetCollection = assetentity.getAssetCollection();
            for (Asset assetCollectionAsset : assetCollection) {
                assetCollectionAsset.setAssetentityid(null);
                assetCollectionAsset = em.merge(assetCollectionAsset);
            }
            em.remove(assetentity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assetentity> findAssetentityEntities() {
        return findAssetentityEntities(true, -1, -1);
    }

    public List<Assetentity> findAssetentityEntities(int maxResults, int firstResult) {
        return findAssetentityEntities(false, maxResults, firstResult);
    }

    private List<Assetentity> findAssetentityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assetentity.class));
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

    public Assetentity findAssetentity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assetentity.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssetentityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assetentity> rt = cq.from(Assetentity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
