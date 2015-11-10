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
public class CountryJpaController implements Serializable {

    public CountryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Country country) throws PreexistingEntityException, Exception {
        if (country.getRegionCollection() == null) {
            country.setRegionCollection(new ArrayList<Region>());
        }
        if (country.getAddressCollection() == null) {
            country.setAddressCollection(new ArrayList<Address>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Region> attachedRegionCollection = new ArrayList<Region>();
            for (Region regionCollectionRegionToAttach : country.getRegionCollection()) {
                regionCollectionRegionToAttach = em.getReference(regionCollectionRegionToAttach.getClass(), regionCollectionRegionToAttach.getId());
                attachedRegionCollection.add(regionCollectionRegionToAttach);
            }
            country.setRegionCollection(attachedRegionCollection);
            Collection<Address> attachedAddressCollection = new ArrayList<Address>();
            for (Address addressCollectionAddressToAttach : country.getAddressCollection()) {
                addressCollectionAddressToAttach = em.getReference(addressCollectionAddressToAttach.getClass(), addressCollectionAddressToAttach.getId());
                attachedAddressCollection.add(addressCollectionAddressToAttach);
            }
            country.setAddressCollection(attachedAddressCollection);
            em.persist(country);
            for (Region regionCollectionRegion : country.getRegionCollection()) {
                Country oldCountryidOfRegionCollectionRegion = regionCollectionRegion.getCountryid();
                regionCollectionRegion.setCountryid(country);
                regionCollectionRegion = em.merge(regionCollectionRegion);
                if (oldCountryidOfRegionCollectionRegion != null) {
                    oldCountryidOfRegionCollectionRegion.getRegionCollection().remove(regionCollectionRegion);
                    oldCountryidOfRegionCollectionRegion = em.merge(oldCountryidOfRegionCollectionRegion);
                }
            }
            for (Address addressCollectionAddress : country.getAddressCollection()) {
                Country oldCountryidOfAddressCollectionAddress = addressCollectionAddress.getCountryid();
                addressCollectionAddress.setCountryid(country);
                addressCollectionAddress = em.merge(addressCollectionAddress);
                if (oldCountryidOfAddressCollectionAddress != null) {
                    oldCountryidOfAddressCollectionAddress.getAddressCollection().remove(addressCollectionAddress);
                    oldCountryidOfAddressCollectionAddress = em.merge(oldCountryidOfAddressCollectionAddress);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCountry(country.getId()) != null) {
                throw new PreexistingEntityException("Country " + country + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Country country) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Country persistentCountry = em.find(Country.class, country.getId());
            Collection<Region> regionCollectionOld = persistentCountry.getRegionCollection();
            Collection<Region> regionCollectionNew = country.getRegionCollection();
            Collection<Address> addressCollectionOld = persistentCountry.getAddressCollection();
            Collection<Address> addressCollectionNew = country.getAddressCollection();
            Collection<Region> attachedRegionCollectionNew = new ArrayList<Region>();
            for (Region regionCollectionNewRegionToAttach : regionCollectionNew) {
                regionCollectionNewRegionToAttach = em.getReference(regionCollectionNewRegionToAttach.getClass(), regionCollectionNewRegionToAttach.getId());
                attachedRegionCollectionNew.add(regionCollectionNewRegionToAttach);
            }
            regionCollectionNew = attachedRegionCollectionNew;
            country.setRegionCollection(regionCollectionNew);
            Collection<Address> attachedAddressCollectionNew = new ArrayList<Address>();
            for (Address addressCollectionNewAddressToAttach : addressCollectionNew) {
                addressCollectionNewAddressToAttach = em.getReference(addressCollectionNewAddressToAttach.getClass(), addressCollectionNewAddressToAttach.getId());
                attachedAddressCollectionNew.add(addressCollectionNewAddressToAttach);
            }
            addressCollectionNew = attachedAddressCollectionNew;
            country.setAddressCollection(addressCollectionNew);
            country = em.merge(country);
            for (Region regionCollectionOldRegion : regionCollectionOld) {
                if (!regionCollectionNew.contains(regionCollectionOldRegion)) {
                    regionCollectionOldRegion.setCountryid(null);
                    regionCollectionOldRegion = em.merge(regionCollectionOldRegion);
                }
            }
            for (Region regionCollectionNewRegion : regionCollectionNew) {
                if (!regionCollectionOld.contains(regionCollectionNewRegion)) {
                    Country oldCountryidOfRegionCollectionNewRegion = regionCollectionNewRegion.getCountryid();
                    regionCollectionNewRegion.setCountryid(country);
                    regionCollectionNewRegion = em.merge(regionCollectionNewRegion);
                    if (oldCountryidOfRegionCollectionNewRegion != null && !oldCountryidOfRegionCollectionNewRegion.equals(country)) {
                        oldCountryidOfRegionCollectionNewRegion.getRegionCollection().remove(regionCollectionNewRegion);
                        oldCountryidOfRegionCollectionNewRegion = em.merge(oldCountryidOfRegionCollectionNewRegion);
                    }
                }
            }
            for (Address addressCollectionOldAddress : addressCollectionOld) {
                if (!addressCollectionNew.contains(addressCollectionOldAddress)) {
                    addressCollectionOldAddress.setCountryid(null);
                    addressCollectionOldAddress = em.merge(addressCollectionOldAddress);
                }
            }
            for (Address addressCollectionNewAddress : addressCollectionNew) {
                if (!addressCollectionOld.contains(addressCollectionNewAddress)) {
                    Country oldCountryidOfAddressCollectionNewAddress = addressCollectionNewAddress.getCountryid();
                    addressCollectionNewAddress.setCountryid(country);
                    addressCollectionNewAddress = em.merge(addressCollectionNewAddress);
                    if (oldCountryidOfAddressCollectionNewAddress != null && !oldCountryidOfAddressCollectionNewAddress.equals(country)) {
                        oldCountryidOfAddressCollectionNewAddress.getAddressCollection().remove(addressCollectionNewAddress);
                        oldCountryidOfAddressCollectionNewAddress = em.merge(oldCountryidOfAddressCollectionNewAddress);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = country.getId();
                if (findCountry(id) == null) {
                    throw new NonexistentEntityException("The country with id " + id + " no longer exists.");
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
            Country country;
            try {
                country = em.getReference(Country.class, id);
                country.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The country with id " + id + " no longer exists.", enfe);
            }
            Collection<Region> regionCollection = country.getRegionCollection();
            for (Region regionCollectionRegion : regionCollection) {
                regionCollectionRegion.setCountryid(null);
                regionCollectionRegion = em.merge(regionCollectionRegion);
            }
            Collection<Address> addressCollection = country.getAddressCollection();
            for (Address addressCollectionAddress : addressCollection) {
                addressCollectionAddress.setCountryid(null);
                addressCollectionAddress = em.merge(addressCollectionAddress);
            }
            em.remove(country);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Country> findCountryEntities() {
        return findCountryEntities(true, -1, -1);
    }

    public List<Country> findCountryEntities(int maxResults, int firstResult) {
        return findCountryEntities(false, maxResults, firstResult);
    }

    private List<Country> findCountryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Country.class));
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

    public Country findCountry(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Country.class, id);
        } finally {
            em.close();
        }
    }

    public int getCountryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Country> rt = cq.from(Country.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
