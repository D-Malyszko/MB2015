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
public class UsergroupJpaController implements Serializable {

    public UsergroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usergroup usergroup) throws PreexistingEntityException, Exception {
        if (usergroup.getAssetbankuserCollection() == null) {
            usergroup.setAssetbankuserCollection(new ArrayList<Assetbankuser>());
        }
        if (usergroup.getOrgunitCollection() == null) {
            usergroup.setOrgunitCollection(new ArrayList<Orgunit>());
        }
        if (usergroup.getAssetentityCollection() == null) {
            usergroup.setAssetentityCollection(new ArrayList<Assetentity>());
        }
        if (usergroup.getMenuitemCollection() == null) {
            usergroup.setMenuitemCollection(new ArrayList<Menuitem>());
        }
        if (usergroup.getOrgunitCollection1() == null) {
            usergroup.setOrgunitCollection1(new ArrayList<Orgunit>());
        }
        if (usergroup.getOrgunitCollection2() == null) {
            usergroup.setOrgunitCollection2(new ArrayList<Orgunit>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Brand brandid = usergroup.getBrandid();
            if (brandid != null) {
                brandid = em.getReference(brandid.getClass(), brandid.getId());
                usergroup.setBrandid(brandid);
            }
            Menuitem homepagemenuitemidentifier = usergroup.getHomepagemenuitemidentifier();
            if (homepagemenuitemidentifier != null) {
                homepagemenuitemidentifier = em.getReference(homepagemenuitemidentifier.getClass(), homepagemenuitemidentifier.getItemidentifier());
                usergroup.setHomepagemenuitemidentifier(homepagemenuitemidentifier);
            }
            Collection<Assetbankuser> attachedAssetbankuserCollection = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionAssetbankuserToAttach : usergroup.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuserToAttach = em.getReference(assetbankuserCollectionAssetbankuserToAttach.getClass(), assetbankuserCollectionAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection.add(assetbankuserCollectionAssetbankuserToAttach);
            }
            usergroup.setAssetbankuserCollection(attachedAssetbankuserCollection);
            Collection<Orgunit> attachedOrgunitCollection = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollectionOrgunitToAttach : usergroup.getOrgunitCollection()) {
                orgunitCollectionOrgunitToAttach = em.getReference(orgunitCollectionOrgunitToAttach.getClass(), orgunitCollectionOrgunitToAttach.getId());
                attachedOrgunitCollection.add(orgunitCollectionOrgunitToAttach);
            }
            usergroup.setOrgunitCollection(attachedOrgunitCollection);
            Collection<Assetentity> attachedAssetentityCollection = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionAssetentityToAttach : usergroup.getAssetentityCollection()) {
                assetentityCollectionAssetentityToAttach = em.getReference(assetentityCollectionAssetentityToAttach.getClass(), assetentityCollectionAssetentityToAttach.getId());
                attachedAssetentityCollection.add(assetentityCollectionAssetentityToAttach);
            }
            usergroup.setAssetentityCollection(attachedAssetentityCollection);
            Collection<Menuitem> attachedMenuitemCollection = new ArrayList<Menuitem>();
            for (Menuitem menuitemCollectionMenuitemToAttach : usergroup.getMenuitemCollection()) {
                menuitemCollectionMenuitemToAttach = em.getReference(menuitemCollectionMenuitemToAttach.getClass(), menuitemCollectionMenuitemToAttach.getItemidentifier());
                attachedMenuitemCollection.add(menuitemCollectionMenuitemToAttach);
            }
            usergroup.setMenuitemCollection(attachedMenuitemCollection);
            Collection<Orgunit> attachedOrgunitCollection1 = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollection1OrgunitToAttach : usergroup.getOrgunitCollection1()) {
                orgunitCollection1OrgunitToAttach = em.getReference(orgunitCollection1OrgunitToAttach.getClass(), orgunitCollection1OrgunitToAttach.getId());
                attachedOrgunitCollection1.add(orgunitCollection1OrgunitToAttach);
            }
            usergroup.setOrgunitCollection1(attachedOrgunitCollection1);
            Collection<Orgunit> attachedOrgunitCollection2 = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollection2OrgunitToAttach : usergroup.getOrgunitCollection2()) {
                orgunitCollection2OrgunitToAttach = em.getReference(orgunitCollection2OrgunitToAttach.getClass(), orgunitCollection2OrgunitToAttach.getId());
                attachedOrgunitCollection2.add(orgunitCollection2OrgunitToAttach);
            }
            usergroup.setOrgunitCollection2(attachedOrgunitCollection2);
            em.persist(usergroup);
            if (brandid != null) {
                brandid.getUsergroupCollection().add(usergroup);
                brandid = em.merge(brandid);
            }
            if (homepagemenuitemidentifier != null) {
                homepagemenuitemidentifier.getUsergroupCollection().add(usergroup);
                homepagemenuitemidentifier = em.merge(homepagemenuitemidentifier);
            }
            for (Assetbankuser assetbankuserCollectionAssetbankuser : usergroup.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuser.getUsergroupCollection().add(usergroup);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            for (Orgunit orgunitCollectionOrgunit : usergroup.getOrgunitCollection()) {
                orgunitCollectionOrgunit.getUsergroupCollection().add(usergroup);
                orgunitCollectionOrgunit = em.merge(orgunitCollectionOrgunit);
            }
            for (Assetentity assetentityCollectionAssetentity : usergroup.getAssetentityCollection()) {
                assetentityCollectionAssetentity.getUsergroupCollection().add(usergroup);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
            }
            for (Menuitem menuitemCollectionMenuitem : usergroup.getMenuitemCollection()) {
                menuitemCollectionMenuitem.getUsergroupCollection().add(usergroup);
                menuitemCollectionMenuitem = em.merge(menuitemCollectionMenuitem);
            }
            for (Orgunit orgunitCollection1Orgunit : usergroup.getOrgunitCollection1()) {
                Usergroup oldAdmingroupidOfOrgunitCollection1Orgunit = orgunitCollection1Orgunit.getAdmingroupid();
                orgunitCollection1Orgunit.setAdmingroupid(usergroup);
                orgunitCollection1Orgunit = em.merge(orgunitCollection1Orgunit);
                if (oldAdmingroupidOfOrgunitCollection1Orgunit != null) {
                    oldAdmingroupidOfOrgunitCollection1Orgunit.getOrgunitCollection1().remove(orgunitCollection1Orgunit);
                    oldAdmingroupidOfOrgunitCollection1Orgunit = em.merge(oldAdmingroupidOfOrgunitCollection1Orgunit);
                }
            }
            for (Orgunit orgunitCollection2Orgunit : usergroup.getOrgunitCollection2()) {
                Usergroup oldStandardgroupidOfOrgunitCollection2Orgunit = orgunitCollection2Orgunit.getStandardgroupid();
                orgunitCollection2Orgunit.setStandardgroupid(usergroup);
                orgunitCollection2Orgunit = em.merge(orgunitCollection2Orgunit);
                if (oldStandardgroupidOfOrgunitCollection2Orgunit != null) {
                    oldStandardgroupidOfOrgunitCollection2Orgunit.getOrgunitCollection2().remove(orgunitCollection2Orgunit);
                    oldStandardgroupidOfOrgunitCollection2Orgunit = em.merge(oldStandardgroupidOfOrgunitCollection2Orgunit);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsergroup(usergroup.getId()) != null) {
                throw new PreexistingEntityException("Usergroup " + usergroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usergroup usergroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usergroup persistentUsergroup = em.find(Usergroup.class, usergroup.getId());
            Brand brandidOld = persistentUsergroup.getBrandid();
            Brand brandidNew = usergroup.getBrandid();
            Menuitem homepagemenuitemidentifierOld = persistentUsergroup.getHomepagemenuitemidentifier();
            Menuitem homepagemenuitemidentifierNew = usergroup.getHomepagemenuitemidentifier();
            Collection<Assetbankuser> assetbankuserCollectionOld = persistentUsergroup.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollectionNew = usergroup.getAssetbankuserCollection();
            Collection<Orgunit> orgunitCollectionOld = persistentUsergroup.getOrgunitCollection();
            Collection<Orgunit> orgunitCollectionNew = usergroup.getOrgunitCollection();
            Collection<Assetentity> assetentityCollectionOld = persistentUsergroup.getAssetentityCollection();
            Collection<Assetentity> assetentityCollectionNew = usergroup.getAssetentityCollection();
            Collection<Menuitem> menuitemCollectionOld = persistentUsergroup.getMenuitemCollection();
            Collection<Menuitem> menuitemCollectionNew = usergroup.getMenuitemCollection();
            Collection<Orgunit> orgunitCollection1Old = persistentUsergroup.getOrgunitCollection1();
            Collection<Orgunit> orgunitCollection1New = usergroup.getOrgunitCollection1();
            Collection<Orgunit> orgunitCollection2Old = persistentUsergroup.getOrgunitCollection2();
            Collection<Orgunit> orgunitCollection2New = usergroup.getOrgunitCollection2();
            if (brandidNew != null) {
                brandidNew = em.getReference(brandidNew.getClass(), brandidNew.getId());
                usergroup.setBrandid(brandidNew);
            }
            if (homepagemenuitemidentifierNew != null) {
                homepagemenuitemidentifierNew = em.getReference(homepagemenuitemidentifierNew.getClass(), homepagemenuitemidentifierNew.getItemidentifier());
                usergroup.setHomepagemenuitemidentifier(homepagemenuitemidentifierNew);
            }
            Collection<Assetbankuser> attachedAssetbankuserCollectionNew = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionNewAssetbankuserToAttach : assetbankuserCollectionNew) {
                assetbankuserCollectionNewAssetbankuserToAttach = em.getReference(assetbankuserCollectionNewAssetbankuserToAttach.getClass(), assetbankuserCollectionNewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollectionNew.add(assetbankuserCollectionNewAssetbankuserToAttach);
            }
            assetbankuserCollectionNew = attachedAssetbankuserCollectionNew;
            usergroup.setAssetbankuserCollection(assetbankuserCollectionNew);
            Collection<Orgunit> attachedOrgunitCollectionNew = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollectionNewOrgunitToAttach : orgunitCollectionNew) {
                orgunitCollectionNewOrgunitToAttach = em.getReference(orgunitCollectionNewOrgunitToAttach.getClass(), orgunitCollectionNewOrgunitToAttach.getId());
                attachedOrgunitCollectionNew.add(orgunitCollectionNewOrgunitToAttach);
            }
            orgunitCollectionNew = attachedOrgunitCollectionNew;
            usergroup.setOrgunitCollection(orgunitCollectionNew);
            Collection<Assetentity> attachedAssetentityCollectionNew = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionNewAssetentityToAttach : assetentityCollectionNew) {
                assetentityCollectionNewAssetentityToAttach = em.getReference(assetentityCollectionNewAssetentityToAttach.getClass(), assetentityCollectionNewAssetentityToAttach.getId());
                attachedAssetentityCollectionNew.add(assetentityCollectionNewAssetentityToAttach);
            }
            assetentityCollectionNew = attachedAssetentityCollectionNew;
            usergroup.setAssetentityCollection(assetentityCollectionNew);
            Collection<Menuitem> attachedMenuitemCollectionNew = new ArrayList<Menuitem>();
            for (Menuitem menuitemCollectionNewMenuitemToAttach : menuitemCollectionNew) {
                menuitemCollectionNewMenuitemToAttach = em.getReference(menuitemCollectionNewMenuitemToAttach.getClass(), menuitemCollectionNewMenuitemToAttach.getItemidentifier());
                attachedMenuitemCollectionNew.add(menuitemCollectionNewMenuitemToAttach);
            }
            menuitemCollectionNew = attachedMenuitemCollectionNew;
            usergroup.setMenuitemCollection(menuitemCollectionNew);
            Collection<Orgunit> attachedOrgunitCollection1New = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollection1NewOrgunitToAttach : orgunitCollection1New) {
                orgunitCollection1NewOrgunitToAttach = em.getReference(orgunitCollection1NewOrgunitToAttach.getClass(), orgunitCollection1NewOrgunitToAttach.getId());
                attachedOrgunitCollection1New.add(orgunitCollection1NewOrgunitToAttach);
            }
            orgunitCollection1New = attachedOrgunitCollection1New;
            usergroup.setOrgunitCollection1(orgunitCollection1New);
            Collection<Orgunit> attachedOrgunitCollection2New = new ArrayList<Orgunit>();
            for (Orgunit orgunitCollection2NewOrgunitToAttach : orgunitCollection2New) {
                orgunitCollection2NewOrgunitToAttach = em.getReference(orgunitCollection2NewOrgunitToAttach.getClass(), orgunitCollection2NewOrgunitToAttach.getId());
                attachedOrgunitCollection2New.add(orgunitCollection2NewOrgunitToAttach);
            }
            orgunitCollection2New = attachedOrgunitCollection2New;
            usergroup.setOrgunitCollection2(orgunitCollection2New);
            usergroup = em.merge(usergroup);
            if (brandidOld != null && !brandidOld.equals(brandidNew)) {
                brandidOld.getUsergroupCollection().remove(usergroup);
                brandidOld = em.merge(brandidOld);
            }
            if (brandidNew != null && !brandidNew.equals(brandidOld)) {
                brandidNew.getUsergroupCollection().add(usergroup);
                brandidNew = em.merge(brandidNew);
            }
            if (homepagemenuitemidentifierOld != null && !homepagemenuitemidentifierOld.equals(homepagemenuitemidentifierNew)) {
                homepagemenuitemidentifierOld.getUsergroupCollection().remove(usergroup);
                homepagemenuitemidentifierOld = em.merge(homepagemenuitemidentifierOld);
            }
            if (homepagemenuitemidentifierNew != null && !homepagemenuitemidentifierNew.equals(homepagemenuitemidentifierOld)) {
                homepagemenuitemidentifierNew.getUsergroupCollection().add(usergroup);
                homepagemenuitemidentifierNew = em.merge(homepagemenuitemidentifierNew);
            }
            for (Assetbankuser assetbankuserCollectionOldAssetbankuser : assetbankuserCollectionOld) {
                if (!assetbankuserCollectionNew.contains(assetbankuserCollectionOldAssetbankuser)) {
                    assetbankuserCollectionOldAssetbankuser.getUsergroupCollection().remove(usergroup);
                    assetbankuserCollectionOldAssetbankuser = em.merge(assetbankuserCollectionOldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollectionNewAssetbankuser : assetbankuserCollectionNew) {
                if (!assetbankuserCollectionOld.contains(assetbankuserCollectionNewAssetbankuser)) {
                    assetbankuserCollectionNewAssetbankuser.getUsergroupCollection().add(usergroup);
                    assetbankuserCollectionNewAssetbankuser = em.merge(assetbankuserCollectionNewAssetbankuser);
                }
            }
            for (Orgunit orgunitCollectionOldOrgunit : orgunitCollectionOld) {
                if (!orgunitCollectionNew.contains(orgunitCollectionOldOrgunit)) {
                    orgunitCollectionOldOrgunit.getUsergroupCollection().remove(usergroup);
                    orgunitCollectionOldOrgunit = em.merge(orgunitCollectionOldOrgunit);
                }
            }
            for (Orgunit orgunitCollectionNewOrgunit : orgunitCollectionNew) {
                if (!orgunitCollectionOld.contains(orgunitCollectionNewOrgunit)) {
                    orgunitCollectionNewOrgunit.getUsergroupCollection().add(usergroup);
                    orgunitCollectionNewOrgunit = em.merge(orgunitCollectionNewOrgunit);
                }
            }
            for (Assetentity assetentityCollectionOldAssetentity : assetentityCollectionOld) {
                if (!assetentityCollectionNew.contains(assetentityCollectionOldAssetentity)) {
                    assetentityCollectionOldAssetentity.getUsergroupCollection().remove(usergroup);
                    assetentityCollectionOldAssetentity = em.merge(assetentityCollectionOldAssetentity);
                }
            }
            for (Assetentity assetentityCollectionNewAssetentity : assetentityCollectionNew) {
                if (!assetentityCollectionOld.contains(assetentityCollectionNewAssetentity)) {
                    assetentityCollectionNewAssetentity.getUsergroupCollection().add(usergroup);
                    assetentityCollectionNewAssetentity = em.merge(assetentityCollectionNewAssetentity);
                }
            }
            for (Menuitem menuitemCollectionOldMenuitem : menuitemCollectionOld) {
                if (!menuitemCollectionNew.contains(menuitemCollectionOldMenuitem)) {
                    menuitemCollectionOldMenuitem.getUsergroupCollection().remove(usergroup);
                    menuitemCollectionOldMenuitem = em.merge(menuitemCollectionOldMenuitem);
                }
            }
            for (Menuitem menuitemCollectionNewMenuitem : menuitemCollectionNew) {
                if (!menuitemCollectionOld.contains(menuitemCollectionNewMenuitem)) {
                    menuitemCollectionNewMenuitem.getUsergroupCollection().add(usergroup);
                    menuitemCollectionNewMenuitem = em.merge(menuitemCollectionNewMenuitem);
                }
            }
            for (Orgunit orgunitCollection1OldOrgunit : orgunitCollection1Old) {
                if (!orgunitCollection1New.contains(orgunitCollection1OldOrgunit)) {
                    orgunitCollection1OldOrgunit.setAdmingroupid(null);
                    orgunitCollection1OldOrgunit = em.merge(orgunitCollection1OldOrgunit);
                }
            }
            for (Orgunit orgunitCollection1NewOrgunit : orgunitCollection1New) {
                if (!orgunitCollection1Old.contains(orgunitCollection1NewOrgunit)) {
                    Usergroup oldAdmingroupidOfOrgunitCollection1NewOrgunit = orgunitCollection1NewOrgunit.getAdmingroupid();
                    orgunitCollection1NewOrgunit.setAdmingroupid(usergroup);
                    orgunitCollection1NewOrgunit = em.merge(orgunitCollection1NewOrgunit);
                    if (oldAdmingroupidOfOrgunitCollection1NewOrgunit != null && !oldAdmingroupidOfOrgunitCollection1NewOrgunit.equals(usergroup)) {
                        oldAdmingroupidOfOrgunitCollection1NewOrgunit.getOrgunitCollection1().remove(orgunitCollection1NewOrgunit);
                        oldAdmingroupidOfOrgunitCollection1NewOrgunit = em.merge(oldAdmingroupidOfOrgunitCollection1NewOrgunit);
                    }
                }
            }
            for (Orgunit orgunitCollection2OldOrgunit : orgunitCollection2Old) {
                if (!orgunitCollection2New.contains(orgunitCollection2OldOrgunit)) {
                    orgunitCollection2OldOrgunit.setStandardgroupid(null);
                    orgunitCollection2OldOrgunit = em.merge(orgunitCollection2OldOrgunit);
                }
            }
            for (Orgunit orgunitCollection2NewOrgunit : orgunitCollection2New) {
                if (!orgunitCollection2Old.contains(orgunitCollection2NewOrgunit)) {
                    Usergroup oldStandardgroupidOfOrgunitCollection2NewOrgunit = orgunitCollection2NewOrgunit.getStandardgroupid();
                    orgunitCollection2NewOrgunit.setStandardgroupid(usergroup);
                    orgunitCollection2NewOrgunit = em.merge(orgunitCollection2NewOrgunit);
                    if (oldStandardgroupidOfOrgunitCollection2NewOrgunit != null && !oldStandardgroupidOfOrgunitCollection2NewOrgunit.equals(usergroup)) {
                        oldStandardgroupidOfOrgunitCollection2NewOrgunit.getOrgunitCollection2().remove(orgunitCollection2NewOrgunit);
                        oldStandardgroupidOfOrgunitCollection2NewOrgunit = em.merge(oldStandardgroupidOfOrgunitCollection2NewOrgunit);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usergroup.getId();
                if (findUsergroup(id) == null) {
                    throw new NonexistentEntityException("The usergroup with id " + id + " no longer exists.");
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
            Usergroup usergroup;
            try {
                usergroup = em.getReference(Usergroup.class, id);
                usergroup.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usergroup with id " + id + " no longer exists.", enfe);
            }
            Brand brandid = usergroup.getBrandid();
            if (brandid != null) {
                brandid.getUsergroupCollection().remove(usergroup);
                brandid = em.merge(brandid);
            }
            Menuitem homepagemenuitemidentifier = usergroup.getHomepagemenuitemidentifier();
            if (homepagemenuitemidentifier != null) {
                homepagemenuitemidentifier.getUsergroupCollection().remove(usergroup);
                homepagemenuitemidentifier = em.merge(homepagemenuitemidentifier);
            }
            Collection<Assetbankuser> assetbankuserCollection = usergroup.getAssetbankuserCollection();
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuserCollection) {
                assetbankuserCollectionAssetbankuser.getUsergroupCollection().remove(usergroup);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            Collection<Orgunit> orgunitCollection = usergroup.getOrgunitCollection();
            for (Orgunit orgunitCollectionOrgunit : orgunitCollection) {
                orgunitCollectionOrgunit.getUsergroupCollection().remove(usergroup);
                orgunitCollectionOrgunit = em.merge(orgunitCollectionOrgunit);
            }
            Collection<Assetentity> assetentityCollection = usergroup.getAssetentityCollection();
            for (Assetentity assetentityCollectionAssetentity : assetentityCollection) {
                assetentityCollectionAssetentity.getUsergroupCollection().remove(usergroup);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
            }
            Collection<Menuitem> menuitemCollection = usergroup.getMenuitemCollection();
            for (Menuitem menuitemCollectionMenuitem : menuitemCollection) {
                menuitemCollectionMenuitem.getUsergroupCollection().remove(usergroup);
                menuitemCollectionMenuitem = em.merge(menuitemCollectionMenuitem);
            }
            Collection<Orgunit> orgunitCollection1 = usergroup.getOrgunitCollection1();
            for (Orgunit orgunitCollection1Orgunit : orgunitCollection1) {
                orgunitCollection1Orgunit.setAdmingroupid(null);
                orgunitCollection1Orgunit = em.merge(orgunitCollection1Orgunit);
            }
            Collection<Orgunit> orgunitCollection2 = usergroup.getOrgunitCollection2();
            for (Orgunit orgunitCollection2Orgunit : orgunitCollection2) {
                orgunitCollection2Orgunit.setStandardgroupid(null);
                orgunitCollection2Orgunit = em.merge(orgunitCollection2Orgunit);
            }
            em.remove(usergroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usergroup> findUsergroupEntities() {
        return findUsergroupEntities(true, -1, -1);
    }

    public List<Usergroup> findUsergroupEntities(int maxResults, int firstResult) {
        return findUsergroupEntities(false, maxResults, firstResult);
    }

    private List<Usergroup> findUsergroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usergroup.class));
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

    public Usergroup findUsergroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usergroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsergroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usergroup> rt = cq.from(Usergroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
