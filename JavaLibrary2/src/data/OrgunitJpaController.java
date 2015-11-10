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
public class OrgunitJpaController implements Serializable {

    public OrgunitJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orgunit orgunit) throws PreexistingEntityException, Exception {
        if (orgunit.getUsergroupCollection() == null) {
            orgunit.setUsergroupCollection(new ArrayList<Usergroup>());
        }
        if (orgunit.getAssetbankuserCollection() == null) {
            orgunit.setAssetbankuserCollection(new ArrayList<Assetbankuser>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CmCategory rootorgunitcategoryid = orgunit.getRootorgunitcategoryid();
            if (rootorgunitcategoryid != null) {
                rootorgunitcategoryid = em.getReference(rootorgunitcategoryid.getClass(), rootorgunitcategoryid.getId());
                orgunit.setRootorgunitcategoryid(rootorgunitcategoryid);
            }
            CmCategory rootdescriptivecategoryid = orgunit.getRootdescriptivecategoryid();
            if (rootdescriptivecategoryid != null) {
                rootdescriptivecategoryid = em.getReference(rootdescriptivecategoryid.getClass(), rootdescriptivecategoryid.getId());
                orgunit.setRootdescriptivecategoryid(rootdescriptivecategoryid);
            }
            Usergroup admingroupid = orgunit.getAdmingroupid();
            if (admingroupid != null) {
                admingroupid = em.getReference(admingroupid.getClass(), admingroupid.getId());
                orgunit.setAdmingroupid(admingroupid);
            }
            Usergroup standardgroupid = orgunit.getStandardgroupid();
            if (standardgroupid != null) {
                standardgroupid = em.getReference(standardgroupid.getClass(), standardgroupid.getId());
                orgunit.setStandardgroupid(standardgroupid);
            }
            Collection<Usergroup> attachedUsergroupCollection = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionUsergroupToAttach : orgunit.getUsergroupCollection()) {
                usergroupCollectionUsergroupToAttach = em.getReference(usergroupCollectionUsergroupToAttach.getClass(), usergroupCollectionUsergroupToAttach.getId());
                attachedUsergroupCollection.add(usergroupCollectionUsergroupToAttach);
            }
            orgunit.setUsergroupCollection(attachedUsergroupCollection);
            Collection<Assetbankuser> attachedAssetbankuserCollection = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionAssetbankuserToAttach : orgunit.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuserToAttach = em.getReference(assetbankuserCollectionAssetbankuserToAttach.getClass(), assetbankuserCollectionAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection.add(assetbankuserCollectionAssetbankuserToAttach);
            }
            orgunit.setAssetbankuserCollection(attachedAssetbankuserCollection);
            em.persist(orgunit);
            if (rootorgunitcategoryid != null) {
                rootorgunitcategoryid.getOrgunitCollection().add(orgunit);
                rootorgunitcategoryid = em.merge(rootorgunitcategoryid);
            }
            if (rootdescriptivecategoryid != null) {
                rootdescriptivecategoryid.getOrgunitCollection().add(orgunit);
                rootdescriptivecategoryid = em.merge(rootdescriptivecategoryid);
            }
            if (admingroupid != null) {
                admingroupid.getOrgunitCollection().add(orgunit);
                admingroupid = em.merge(admingroupid);
            }
            if (standardgroupid != null) {
                standardgroupid.getOrgunitCollection().add(orgunit);
                standardgroupid = em.merge(standardgroupid);
            }
            for (Usergroup usergroupCollectionUsergroup : orgunit.getUsergroupCollection()) {
                usergroupCollectionUsergroup.getOrgunitCollection().add(orgunit);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            for (Assetbankuser assetbankuserCollectionAssetbankuser : orgunit.getAssetbankuserCollection()) {
                Orgunit oldRequestedorgunitidOfAssetbankuserCollectionAssetbankuser = assetbankuserCollectionAssetbankuser.getRequestedorgunitid();
                assetbankuserCollectionAssetbankuser.setRequestedorgunitid(orgunit);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
                if (oldRequestedorgunitidOfAssetbankuserCollectionAssetbankuser != null) {
                    oldRequestedorgunitidOfAssetbankuserCollectionAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionAssetbankuser);
                    oldRequestedorgunitidOfAssetbankuserCollectionAssetbankuser = em.merge(oldRequestedorgunitidOfAssetbankuserCollectionAssetbankuser);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrgunit(orgunit.getId()) != null) {
                throw new PreexistingEntityException("Orgunit " + orgunit + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orgunit orgunit) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orgunit persistentOrgunit = em.find(Orgunit.class, orgunit.getId());
            CmCategory rootorgunitcategoryidOld = persistentOrgunit.getRootorgunitcategoryid();
            CmCategory rootorgunitcategoryidNew = orgunit.getRootorgunitcategoryid();
            CmCategory rootdescriptivecategoryidOld = persistentOrgunit.getRootdescriptivecategoryid();
            CmCategory rootdescriptivecategoryidNew = orgunit.getRootdescriptivecategoryid();
            Usergroup admingroupidOld = persistentOrgunit.getAdmingroupid();
            Usergroup admingroupidNew = orgunit.getAdmingroupid();
            Usergroup standardgroupidOld = persistentOrgunit.getStandardgroupid();
            Usergroup standardgroupidNew = orgunit.getStandardgroupid();
            Collection<Usergroup> usergroupCollectionOld = persistentOrgunit.getUsergroupCollection();
            Collection<Usergroup> usergroupCollectionNew = orgunit.getUsergroupCollection();
            Collection<Assetbankuser> assetbankuserCollectionOld = persistentOrgunit.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollectionNew = orgunit.getAssetbankuserCollection();
            if (rootorgunitcategoryidNew != null) {
                rootorgunitcategoryidNew = em.getReference(rootorgunitcategoryidNew.getClass(), rootorgunitcategoryidNew.getId());
                orgunit.setRootorgunitcategoryid(rootorgunitcategoryidNew);
            }
            if (rootdescriptivecategoryidNew != null) {
                rootdescriptivecategoryidNew = em.getReference(rootdescriptivecategoryidNew.getClass(), rootdescriptivecategoryidNew.getId());
                orgunit.setRootdescriptivecategoryid(rootdescriptivecategoryidNew);
            }
            if (admingroupidNew != null) {
                admingroupidNew = em.getReference(admingroupidNew.getClass(), admingroupidNew.getId());
                orgunit.setAdmingroupid(admingroupidNew);
            }
            if (standardgroupidNew != null) {
                standardgroupidNew = em.getReference(standardgroupidNew.getClass(), standardgroupidNew.getId());
                orgunit.setStandardgroupid(standardgroupidNew);
            }
            Collection<Usergroup> attachedUsergroupCollectionNew = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionNewUsergroupToAttach : usergroupCollectionNew) {
                usergroupCollectionNewUsergroupToAttach = em.getReference(usergroupCollectionNewUsergroupToAttach.getClass(), usergroupCollectionNewUsergroupToAttach.getId());
                attachedUsergroupCollectionNew.add(usergroupCollectionNewUsergroupToAttach);
            }
            usergroupCollectionNew = attachedUsergroupCollectionNew;
            orgunit.setUsergroupCollection(usergroupCollectionNew);
            Collection<Assetbankuser> attachedAssetbankuserCollectionNew = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionNewAssetbankuserToAttach : assetbankuserCollectionNew) {
                assetbankuserCollectionNewAssetbankuserToAttach = em.getReference(assetbankuserCollectionNewAssetbankuserToAttach.getClass(), assetbankuserCollectionNewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollectionNew.add(assetbankuserCollectionNewAssetbankuserToAttach);
            }
            assetbankuserCollectionNew = attachedAssetbankuserCollectionNew;
            orgunit.setAssetbankuserCollection(assetbankuserCollectionNew);
            orgunit = em.merge(orgunit);
            if (rootorgunitcategoryidOld != null && !rootorgunitcategoryidOld.equals(rootorgunitcategoryidNew)) {
                rootorgunitcategoryidOld.getOrgunitCollection().remove(orgunit);
                rootorgunitcategoryidOld = em.merge(rootorgunitcategoryidOld);
            }
            if (rootorgunitcategoryidNew != null && !rootorgunitcategoryidNew.equals(rootorgunitcategoryidOld)) {
                rootorgunitcategoryidNew.getOrgunitCollection().add(orgunit);
                rootorgunitcategoryidNew = em.merge(rootorgunitcategoryidNew);
            }
            if (rootdescriptivecategoryidOld != null && !rootdescriptivecategoryidOld.equals(rootdescriptivecategoryidNew)) {
                rootdescriptivecategoryidOld.getOrgunitCollection().remove(orgunit);
                rootdescriptivecategoryidOld = em.merge(rootdescriptivecategoryidOld);
            }
            if (rootdescriptivecategoryidNew != null && !rootdescriptivecategoryidNew.equals(rootdescriptivecategoryidOld)) {
                rootdescriptivecategoryidNew.getOrgunitCollection().add(orgunit);
                rootdescriptivecategoryidNew = em.merge(rootdescriptivecategoryidNew);
            }
            if (admingroupidOld != null && !admingroupidOld.equals(admingroupidNew)) {
                admingroupidOld.getOrgunitCollection().remove(orgunit);
                admingroupidOld = em.merge(admingroupidOld);
            }
            if (admingroupidNew != null && !admingroupidNew.equals(admingroupidOld)) {
                admingroupidNew.getOrgunitCollection().add(orgunit);
                admingroupidNew = em.merge(admingroupidNew);
            }
            if (standardgroupidOld != null && !standardgroupidOld.equals(standardgroupidNew)) {
                standardgroupidOld.getOrgunitCollection().remove(orgunit);
                standardgroupidOld = em.merge(standardgroupidOld);
            }
            if (standardgroupidNew != null && !standardgroupidNew.equals(standardgroupidOld)) {
                standardgroupidNew.getOrgunitCollection().add(orgunit);
                standardgroupidNew = em.merge(standardgroupidNew);
            }
            for (Usergroup usergroupCollectionOldUsergroup : usergroupCollectionOld) {
                if (!usergroupCollectionNew.contains(usergroupCollectionOldUsergroup)) {
                    usergroupCollectionOldUsergroup.getOrgunitCollection().remove(orgunit);
                    usergroupCollectionOldUsergroup = em.merge(usergroupCollectionOldUsergroup);
                }
            }
            for (Usergroup usergroupCollectionNewUsergroup : usergroupCollectionNew) {
                if (!usergroupCollectionOld.contains(usergroupCollectionNewUsergroup)) {
                    usergroupCollectionNewUsergroup.getOrgunitCollection().add(orgunit);
                    usergroupCollectionNewUsergroup = em.merge(usergroupCollectionNewUsergroup);
                }
            }
            for (Assetbankuser assetbankuserCollectionOldAssetbankuser : assetbankuserCollectionOld) {
                if (!assetbankuserCollectionNew.contains(assetbankuserCollectionOldAssetbankuser)) {
                    assetbankuserCollectionOldAssetbankuser.setRequestedorgunitid(null);
                    assetbankuserCollectionOldAssetbankuser = em.merge(assetbankuserCollectionOldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollectionNewAssetbankuser : assetbankuserCollectionNew) {
                if (!assetbankuserCollectionOld.contains(assetbankuserCollectionNewAssetbankuser)) {
                    Orgunit oldRequestedorgunitidOfAssetbankuserCollectionNewAssetbankuser = assetbankuserCollectionNewAssetbankuser.getRequestedorgunitid();
                    assetbankuserCollectionNewAssetbankuser.setRequestedorgunitid(orgunit);
                    assetbankuserCollectionNewAssetbankuser = em.merge(assetbankuserCollectionNewAssetbankuser);
                    if (oldRequestedorgunitidOfAssetbankuserCollectionNewAssetbankuser != null && !oldRequestedorgunitidOfAssetbankuserCollectionNewAssetbankuser.equals(orgunit)) {
                        oldRequestedorgunitidOfAssetbankuserCollectionNewAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionNewAssetbankuser);
                        oldRequestedorgunitidOfAssetbankuserCollectionNewAssetbankuser = em.merge(oldRequestedorgunitidOfAssetbankuserCollectionNewAssetbankuser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = orgunit.getId();
                if (findOrgunit(id) == null) {
                    throw new NonexistentEntityException("The orgunit with id " + id + " no longer exists.");
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
            Orgunit orgunit;
            try {
                orgunit = em.getReference(Orgunit.class, id);
                orgunit.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orgunit with id " + id + " no longer exists.", enfe);
            }
            CmCategory rootorgunitcategoryid = orgunit.getRootorgunitcategoryid();
            if (rootorgunitcategoryid != null) {
                rootorgunitcategoryid.getOrgunitCollection().remove(orgunit);
                rootorgunitcategoryid = em.merge(rootorgunitcategoryid);
            }
            CmCategory rootdescriptivecategoryid = orgunit.getRootdescriptivecategoryid();
            if (rootdescriptivecategoryid != null) {
                rootdescriptivecategoryid.getOrgunitCollection().remove(orgunit);
                rootdescriptivecategoryid = em.merge(rootdescriptivecategoryid);
            }
            Usergroup admingroupid = orgunit.getAdmingroupid();
            if (admingroupid != null) {
                admingroupid.getOrgunitCollection().remove(orgunit);
                admingroupid = em.merge(admingroupid);
            }
            Usergroup standardgroupid = orgunit.getStandardgroupid();
            if (standardgroupid != null) {
                standardgroupid.getOrgunitCollection().remove(orgunit);
                standardgroupid = em.merge(standardgroupid);
            }
            Collection<Usergroup> usergroupCollection = orgunit.getUsergroupCollection();
            for (Usergroup usergroupCollectionUsergroup : usergroupCollection) {
                usergroupCollectionUsergroup.getOrgunitCollection().remove(orgunit);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            Collection<Assetbankuser> assetbankuserCollection = orgunit.getAssetbankuserCollection();
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuserCollection) {
                assetbankuserCollectionAssetbankuser.setRequestedorgunitid(null);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            em.remove(orgunit);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orgunit> findOrgunitEntities() {
        return findOrgunitEntities(true, -1, -1);
    }

    public List<Orgunit> findOrgunitEntities(int maxResults, int firstResult) {
        return findOrgunitEntities(false, maxResults, firstResult);
    }

    private List<Orgunit> findOrgunitEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orgunit.class));
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

    public Orgunit findOrgunit(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orgunit.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrgunitCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orgunit> rt = cq.from(Orgunit.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
