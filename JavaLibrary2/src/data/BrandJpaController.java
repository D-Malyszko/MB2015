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
public class BrandJpaController implements Serializable {

    public BrandJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Brand brand) throws PreexistingEntityException, Exception {
        if (brand.getUsergroupCollection() == null) {
            brand.setUsergroupCollection(new ArrayList<Usergroup>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usergroup> attachedUsergroupCollection = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionUsergroupToAttach : brand.getUsergroupCollection()) {
                usergroupCollectionUsergroupToAttach = em.getReference(usergroupCollectionUsergroupToAttach.getClass(), usergroupCollectionUsergroupToAttach.getId());
                attachedUsergroupCollection.add(usergroupCollectionUsergroupToAttach);
            }
            brand.setUsergroupCollection(attachedUsergroupCollection);
            em.persist(brand);
            for (Usergroup usergroupCollectionUsergroup : brand.getUsergroupCollection()) {
                Brand oldBrandidOfUsergroupCollectionUsergroup = usergroupCollectionUsergroup.getBrandid();
                usergroupCollectionUsergroup.setBrandid(brand);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
                if (oldBrandidOfUsergroupCollectionUsergroup != null) {
                    oldBrandidOfUsergroupCollectionUsergroup.getUsergroupCollection().remove(usergroupCollectionUsergroup);
                    oldBrandidOfUsergroupCollectionUsergroup = em.merge(oldBrandidOfUsergroupCollectionUsergroup);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBrand(brand.getId()) != null) {
                throw new PreexistingEntityException("Brand " + brand + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Brand brand) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Brand persistentBrand = em.find(Brand.class, brand.getId());
            Collection<Usergroup> usergroupCollectionOld = persistentBrand.getUsergroupCollection();
            Collection<Usergroup> usergroupCollectionNew = brand.getUsergroupCollection();
            Collection<Usergroup> attachedUsergroupCollectionNew = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionNewUsergroupToAttach : usergroupCollectionNew) {
                usergroupCollectionNewUsergroupToAttach = em.getReference(usergroupCollectionNewUsergroupToAttach.getClass(), usergroupCollectionNewUsergroupToAttach.getId());
                attachedUsergroupCollectionNew.add(usergroupCollectionNewUsergroupToAttach);
            }
            usergroupCollectionNew = attachedUsergroupCollectionNew;
            brand.setUsergroupCollection(usergroupCollectionNew);
            brand = em.merge(brand);
            for (Usergroup usergroupCollectionOldUsergroup : usergroupCollectionOld) {
                if (!usergroupCollectionNew.contains(usergroupCollectionOldUsergroup)) {
                    usergroupCollectionOldUsergroup.setBrandid(null);
                    usergroupCollectionOldUsergroup = em.merge(usergroupCollectionOldUsergroup);
                }
            }
            for (Usergroup usergroupCollectionNewUsergroup : usergroupCollectionNew) {
                if (!usergroupCollectionOld.contains(usergroupCollectionNewUsergroup)) {
                    Brand oldBrandidOfUsergroupCollectionNewUsergroup = usergroupCollectionNewUsergroup.getBrandid();
                    usergroupCollectionNewUsergroup.setBrandid(brand);
                    usergroupCollectionNewUsergroup = em.merge(usergroupCollectionNewUsergroup);
                    if (oldBrandidOfUsergroupCollectionNewUsergroup != null && !oldBrandidOfUsergroupCollectionNewUsergroup.equals(brand)) {
                        oldBrandidOfUsergroupCollectionNewUsergroup.getUsergroupCollection().remove(usergroupCollectionNewUsergroup);
                        oldBrandidOfUsergroupCollectionNewUsergroup = em.merge(oldBrandidOfUsergroupCollectionNewUsergroup);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = brand.getId();
                if (findBrand(id) == null) {
                    throw new NonexistentEntityException("The brand with id " + id + " no longer exists.");
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
            Brand brand;
            try {
                brand = em.getReference(Brand.class, id);
                brand.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The brand with id " + id + " no longer exists.", enfe);
            }
            Collection<Usergroup> usergroupCollection = brand.getUsergroupCollection();
            for (Usergroup usergroupCollectionUsergroup : usergroupCollection) {
                usergroupCollectionUsergroup.setBrandid(null);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            em.remove(brand);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Brand> findBrandEntities() {
        return findBrandEntities(true, -1, -1);
    }

    public List<Brand> findBrandEntities(int maxResults, int firstResult) {
        return findBrandEntities(false, maxResults, firstResult);
    }

    private List<Brand> findBrandEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Brand.class));
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

    public Brand findBrand(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Brand.class, id);
        } finally {
            em.close();
        }
    }

    public int getBrandCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Brand> rt = cq.from(Brand.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
