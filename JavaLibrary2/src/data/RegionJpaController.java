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
public class RegionJpaController implements Serializable {

    public RegionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Region region) throws PreexistingEntityException, Exception {
        if (region.getAddressCollection() == null) {
            region.setAddressCollection(new ArrayList<Address>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Country countryid = region.getCountryid();
            if (countryid != null) {
                countryid = em.getReference(countryid.getClass(), countryid.getId());
                region.setCountryid(countryid);
            }
            Collection<Address> attachedAddressCollection = new ArrayList<Address>();
            for (Address addressCollectionAddressToAttach : region.getAddressCollection()) {
                addressCollectionAddressToAttach = em.getReference(addressCollectionAddressToAttach.getClass(), addressCollectionAddressToAttach.getId());
                attachedAddressCollection.add(addressCollectionAddressToAttach);
            }
            region.setAddressCollection(attachedAddressCollection);
            em.persist(region);
            if (countryid != null) {
                countryid.getRegionCollection().add(region);
                countryid = em.merge(countryid);
            }
            for (Address addressCollectionAddress : region.getAddressCollection()) {
                Region oldRegionidOfAddressCollectionAddress = addressCollectionAddress.getRegionid();
                addressCollectionAddress.setRegionid(region);
                addressCollectionAddress = em.merge(addressCollectionAddress);
                if (oldRegionidOfAddressCollectionAddress != null) {
                    oldRegionidOfAddressCollectionAddress.getAddressCollection().remove(addressCollectionAddress);
                    oldRegionidOfAddressCollectionAddress = em.merge(oldRegionidOfAddressCollectionAddress);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegion(region.getId()) != null) {
                throw new PreexistingEntityException("Region " + region + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Region region) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Region persistentRegion = em.find(Region.class, region.getId());
            Country countryidOld = persistentRegion.getCountryid();
            Country countryidNew = region.getCountryid();
            Collection<Address> addressCollectionOld = persistentRegion.getAddressCollection();
            Collection<Address> addressCollectionNew = region.getAddressCollection();
            if (countryidNew != null) {
                countryidNew = em.getReference(countryidNew.getClass(), countryidNew.getId());
                region.setCountryid(countryidNew);
            }
            Collection<Address> attachedAddressCollectionNew = new ArrayList<Address>();
            for (Address addressCollectionNewAddressToAttach : addressCollectionNew) {
                addressCollectionNewAddressToAttach = em.getReference(addressCollectionNewAddressToAttach.getClass(), addressCollectionNewAddressToAttach.getId());
                attachedAddressCollectionNew.add(addressCollectionNewAddressToAttach);
            }
            addressCollectionNew = attachedAddressCollectionNew;
            region.setAddressCollection(addressCollectionNew);
            region = em.merge(region);
            if (countryidOld != null && !countryidOld.equals(countryidNew)) {
                countryidOld.getRegionCollection().remove(region);
                countryidOld = em.merge(countryidOld);
            }
            if (countryidNew != null && !countryidNew.equals(countryidOld)) {
                countryidNew.getRegionCollection().add(region);
                countryidNew = em.merge(countryidNew);
            }
            for (Address addressCollectionOldAddress : addressCollectionOld) {
                if (!addressCollectionNew.contains(addressCollectionOldAddress)) {
                    addressCollectionOldAddress.setRegionid(null);
                    addressCollectionOldAddress = em.merge(addressCollectionOldAddress);
                }
            }
            for (Address addressCollectionNewAddress : addressCollectionNew) {
                if (!addressCollectionOld.contains(addressCollectionNewAddress)) {
                    Region oldRegionidOfAddressCollectionNewAddress = addressCollectionNewAddress.getRegionid();
                    addressCollectionNewAddress.setRegionid(region);
                    addressCollectionNewAddress = em.merge(addressCollectionNewAddress);
                    if (oldRegionidOfAddressCollectionNewAddress != null && !oldRegionidOfAddressCollectionNewAddress.equals(region)) {
                        oldRegionidOfAddressCollectionNewAddress.getAddressCollection().remove(addressCollectionNewAddress);
                        oldRegionidOfAddressCollectionNewAddress = em.merge(oldRegionidOfAddressCollectionNewAddress);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = region.getId();
                if (findRegion(id) == null) {
                    throw new NonexistentEntityException("The region with id " + id + " no longer exists.");
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
            Region region;
            try {
                region = em.getReference(Region.class, id);
                region.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The region with id " + id + " no longer exists.", enfe);
            }
            Country countryid = region.getCountryid();
            if (countryid != null) {
                countryid.getRegionCollection().remove(region);
                countryid = em.merge(countryid);
            }
            Collection<Address> addressCollection = region.getAddressCollection();
            for (Address addressCollectionAddress : addressCollection) {
                addressCollectionAddress.setRegionid(null);
                addressCollectionAddress = em.merge(addressCollectionAddress);
            }
            em.remove(region);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Region> findRegionEntities() {
        return findRegionEntities(true, -1, -1);
    }

    public List<Region> findRegionEntities(int maxResults, int firstResult) {
        return findRegionEntities(false, maxResults, firstResult);
    }

    private List<Region> findRegionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Region.class));
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

    public Region findRegion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Region.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Region> rt = cq.from(Region.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
