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
public class MenuitemJpaController implements Serializable {

    public MenuitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Menuitem menuitem) throws PreexistingEntityException, Exception {
        if (menuitem.getUsergroupCollection() == null) {
            menuitem.setUsergroupCollection(new ArrayList<Usergroup>());
        }
        if (menuitem.getUsergroupCollection1() == null) {
            menuitem.setUsergroupCollection1(new ArrayList<Usergroup>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usergroup> attachedUsergroupCollection = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionUsergroupToAttach : menuitem.getUsergroupCollection()) {
                usergroupCollectionUsergroupToAttach = em.getReference(usergroupCollectionUsergroupToAttach.getClass(), usergroupCollectionUsergroupToAttach.getId());
                attachedUsergroupCollection.add(usergroupCollectionUsergroupToAttach);
            }
            menuitem.setUsergroupCollection(attachedUsergroupCollection);
            Collection<Usergroup> attachedUsergroupCollection1 = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollection1UsergroupToAttach : menuitem.getUsergroupCollection1()) {
                usergroupCollection1UsergroupToAttach = em.getReference(usergroupCollection1UsergroupToAttach.getClass(), usergroupCollection1UsergroupToAttach.getId());
                attachedUsergroupCollection1.add(usergroupCollection1UsergroupToAttach);
            }
            menuitem.setUsergroupCollection1(attachedUsergroupCollection1);
            em.persist(menuitem);
            for (Usergroup usergroupCollectionUsergroup : menuitem.getUsergroupCollection()) {
                usergroupCollectionUsergroup.getMenuitemCollection().add(menuitem);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            for (Usergroup usergroupCollection1Usergroup : menuitem.getUsergroupCollection1()) {
                Menuitem oldHomepagemenuitemidentifierOfUsergroupCollection1Usergroup = usergroupCollection1Usergroup.getHomepagemenuitemidentifier();
                usergroupCollection1Usergroup.setHomepagemenuitemidentifier(menuitem);
                usergroupCollection1Usergroup = em.merge(usergroupCollection1Usergroup);
                if (oldHomepagemenuitemidentifierOfUsergroupCollection1Usergroup != null) {
                    oldHomepagemenuitemidentifierOfUsergroupCollection1Usergroup.getUsergroupCollection1().remove(usergroupCollection1Usergroup);
                    oldHomepagemenuitemidentifierOfUsergroupCollection1Usergroup = em.merge(oldHomepagemenuitemidentifierOfUsergroupCollection1Usergroup);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMenuitem(menuitem.getItemidentifier()) != null) {
                throw new PreexistingEntityException("Menuitem " + menuitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menuitem menuitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menuitem persistentMenuitem = em.find(Menuitem.class, menuitem.getItemidentifier());
            Collection<Usergroup> usergroupCollectionOld = persistentMenuitem.getUsergroupCollection();
            Collection<Usergroup> usergroupCollectionNew = menuitem.getUsergroupCollection();
            Collection<Usergroup> usergroupCollection1Old = persistentMenuitem.getUsergroupCollection1();
            Collection<Usergroup> usergroupCollection1New = menuitem.getUsergroupCollection1();
            Collection<Usergroup> attachedUsergroupCollectionNew = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionNewUsergroupToAttach : usergroupCollectionNew) {
                usergroupCollectionNewUsergroupToAttach = em.getReference(usergroupCollectionNewUsergroupToAttach.getClass(), usergroupCollectionNewUsergroupToAttach.getId());
                attachedUsergroupCollectionNew.add(usergroupCollectionNewUsergroupToAttach);
            }
            usergroupCollectionNew = attachedUsergroupCollectionNew;
            menuitem.setUsergroupCollection(usergroupCollectionNew);
            Collection<Usergroup> attachedUsergroupCollection1New = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollection1NewUsergroupToAttach : usergroupCollection1New) {
                usergroupCollection1NewUsergroupToAttach = em.getReference(usergroupCollection1NewUsergroupToAttach.getClass(), usergroupCollection1NewUsergroupToAttach.getId());
                attachedUsergroupCollection1New.add(usergroupCollection1NewUsergroupToAttach);
            }
            usergroupCollection1New = attachedUsergroupCollection1New;
            menuitem.setUsergroupCollection1(usergroupCollection1New);
            menuitem = em.merge(menuitem);
            for (Usergroup usergroupCollectionOldUsergroup : usergroupCollectionOld) {
                if (!usergroupCollectionNew.contains(usergroupCollectionOldUsergroup)) {
                    usergroupCollectionOldUsergroup.getMenuitemCollection().remove(menuitem);
                    usergroupCollectionOldUsergroup = em.merge(usergroupCollectionOldUsergroup);
                }
            }
            for (Usergroup usergroupCollectionNewUsergroup : usergroupCollectionNew) {
                if (!usergroupCollectionOld.contains(usergroupCollectionNewUsergroup)) {
                    usergroupCollectionNewUsergroup.getMenuitemCollection().add(menuitem);
                    usergroupCollectionNewUsergroup = em.merge(usergroupCollectionNewUsergroup);
                }
            }
            for (Usergroup usergroupCollection1OldUsergroup : usergroupCollection1Old) {
                if (!usergroupCollection1New.contains(usergroupCollection1OldUsergroup)) {
                    usergroupCollection1OldUsergroup.setHomepagemenuitemidentifier(null);
                    usergroupCollection1OldUsergroup = em.merge(usergroupCollection1OldUsergroup);
                }
            }
            for (Usergroup usergroupCollection1NewUsergroup : usergroupCollection1New) {
                if (!usergroupCollection1Old.contains(usergroupCollection1NewUsergroup)) {
                    Menuitem oldHomepagemenuitemidentifierOfUsergroupCollection1NewUsergroup = usergroupCollection1NewUsergroup.getHomepagemenuitemidentifier();
                    usergroupCollection1NewUsergroup.setHomepagemenuitemidentifier(menuitem);
                    usergroupCollection1NewUsergroup = em.merge(usergroupCollection1NewUsergroup);
                    if (oldHomepagemenuitemidentifierOfUsergroupCollection1NewUsergroup != null && !oldHomepagemenuitemidentifierOfUsergroupCollection1NewUsergroup.equals(menuitem)) {
                        oldHomepagemenuitemidentifierOfUsergroupCollection1NewUsergroup.getUsergroupCollection1().remove(usergroupCollection1NewUsergroup);
                        oldHomepagemenuitemidentifierOfUsergroupCollection1NewUsergroup = em.merge(oldHomepagemenuitemidentifierOfUsergroupCollection1NewUsergroup);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = menuitem.getItemidentifier();
                if (findMenuitem(id) == null) {
                    throw new NonexistentEntityException("The menuitem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menuitem menuitem;
            try {
                menuitem = em.getReference(Menuitem.class, id);
                menuitem.getItemidentifier();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menuitem with id " + id + " no longer exists.", enfe);
            }
            Collection<Usergroup> usergroupCollection = menuitem.getUsergroupCollection();
            for (Usergroup usergroupCollectionUsergroup : usergroupCollection) {
                usergroupCollectionUsergroup.getMenuitemCollection().remove(menuitem);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            Collection<Usergroup> usergroupCollection1 = menuitem.getUsergroupCollection1();
            for (Usergroup usergroupCollection1Usergroup : usergroupCollection1) {
                usergroupCollection1Usergroup.setHomepagemenuitemidentifier(null);
                usergroupCollection1Usergroup = em.merge(usergroupCollection1Usergroup);
            }
            em.remove(menuitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menuitem> findMenuitemEntities() {
        return findMenuitemEntities(true, -1, -1);
    }

    public List<Menuitem> findMenuitemEntities(int maxResults, int firstResult) {
        return findMenuitemEntities(false, maxResults, firstResult);
    }

    private List<Menuitem> findMenuitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menuitem.class));
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

    public Menuitem findMenuitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menuitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenuitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menuitem> rt = cq.from(Menuitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
