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
public class AddressJpaController implements Serializable {

    public AddressJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Address address) throws PreexistingEntityException, Exception {
        if (address.getAssetbankuserCollection() == null) {
            address.setAssetbankuserCollection(new ArrayList<Assetbankuser>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Country countryid = address.getCountryid();
            if (countryid != null) {
                countryid = em.getReference(countryid.getClass(), countryid.getId());
                address.setCountryid(countryid);
            }
            Region regionid = address.getRegionid();
            if (regionid != null) {
                regionid = em.getReference(regionid.getClass(), regionid.getId());
                address.setRegionid(regionid);
            }
            Collection<Assetbankuser> attachedAssetbankuserCollection = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionAssetbankuserToAttach : address.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuserToAttach = em.getReference(assetbankuserCollectionAssetbankuserToAttach.getClass(), assetbankuserCollectionAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection.add(assetbankuserCollectionAssetbankuserToAttach);
            }
            address.setAssetbankuserCollection(attachedAssetbankuserCollection);
            em.persist(address);
            if (countryid != null) {
                countryid.getAddressCollection().add(address);
                countryid = em.merge(countryid);
            }
            if (regionid != null) {
                regionid.getAddressCollection().add(address);
                regionid = em.merge(regionid);
            }
            for (Assetbankuser assetbankuserCollectionAssetbankuser : address.getAssetbankuserCollection()) {
                Address oldAddressidOfAssetbankuserCollectionAssetbankuser = assetbankuserCollectionAssetbankuser.getAddressid();
                assetbankuserCollectionAssetbankuser.setAddressid(address);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
                if (oldAddressidOfAssetbankuserCollectionAssetbankuser != null) {
                    oldAddressidOfAssetbankuserCollectionAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionAssetbankuser);
                    oldAddressidOfAssetbankuserCollectionAssetbankuser = em.merge(oldAddressidOfAssetbankuserCollectionAssetbankuser);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAddress(address.getId()) != null) {
                throw new PreexistingEntityException("Address " + address + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Address address) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address persistentAddress = em.find(Address.class, address.getId());
            Country countryidOld = persistentAddress.getCountryid();
            Country countryidNew = address.getCountryid();
            Region regionidOld = persistentAddress.getRegionid();
            Region regionidNew = address.getRegionid();
            Collection<Assetbankuser> assetbankuserCollectionOld = persistentAddress.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollectionNew = address.getAssetbankuserCollection();
            if (countryidNew != null) {
                countryidNew = em.getReference(countryidNew.getClass(), countryidNew.getId());
                address.setCountryid(countryidNew);
            }
            if (regionidNew != null) {
                regionidNew = em.getReference(regionidNew.getClass(), regionidNew.getId());
                address.setRegionid(regionidNew);
            }
            Collection<Assetbankuser> attachedAssetbankuserCollectionNew = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionNewAssetbankuserToAttach : assetbankuserCollectionNew) {
                assetbankuserCollectionNewAssetbankuserToAttach = em.getReference(assetbankuserCollectionNewAssetbankuserToAttach.getClass(), assetbankuserCollectionNewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollectionNew.add(assetbankuserCollectionNewAssetbankuserToAttach);
            }
            assetbankuserCollectionNew = attachedAssetbankuserCollectionNew;
            address.setAssetbankuserCollection(assetbankuserCollectionNew);
            address = em.merge(address);
            if (countryidOld != null && !countryidOld.equals(countryidNew)) {
                countryidOld.getAddressCollection().remove(address);
                countryidOld = em.merge(countryidOld);
            }
            if (countryidNew != null && !countryidNew.equals(countryidOld)) {
                countryidNew.getAddressCollection().add(address);
                countryidNew = em.merge(countryidNew);
            }
            if (regionidOld != null && !regionidOld.equals(regionidNew)) {
                regionidOld.getAddressCollection().remove(address);
                regionidOld = em.merge(regionidOld);
            }
            if (regionidNew != null && !regionidNew.equals(regionidOld)) {
                regionidNew.getAddressCollection().add(address);
                regionidNew = em.merge(regionidNew);
            }
            for (Assetbankuser assetbankuserCollectionOldAssetbankuser : assetbankuserCollectionOld) {
                if (!assetbankuserCollectionNew.contains(assetbankuserCollectionOldAssetbankuser)) {
                    assetbankuserCollectionOldAssetbankuser.setAddressid(null);
                    assetbankuserCollectionOldAssetbankuser = em.merge(assetbankuserCollectionOldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollectionNewAssetbankuser : assetbankuserCollectionNew) {
                if (!assetbankuserCollectionOld.contains(assetbankuserCollectionNewAssetbankuser)) {
                    Address oldAddressidOfAssetbankuserCollectionNewAssetbankuser = assetbankuserCollectionNewAssetbankuser.getAddressid();
                    assetbankuserCollectionNewAssetbankuser.setAddressid(address);
                    assetbankuserCollectionNewAssetbankuser = em.merge(assetbankuserCollectionNewAssetbankuser);
                    if (oldAddressidOfAssetbankuserCollectionNewAssetbankuser != null && !oldAddressidOfAssetbankuserCollectionNewAssetbankuser.equals(address)) {
                        oldAddressidOfAssetbankuserCollectionNewAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionNewAssetbankuser);
                        oldAddressidOfAssetbankuserCollectionNewAssetbankuser = em.merge(oldAddressidOfAssetbankuserCollectionNewAssetbankuser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = address.getId();
                if (findAddress(id) == null) {
                    throw new NonexistentEntityException("The address with id " + id + " no longer exists.");
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
            Address address;
            try {
                address = em.getReference(Address.class, id);
                address.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The address with id " + id + " no longer exists.", enfe);
            }
            Country countryid = address.getCountryid();
            if (countryid != null) {
                countryid.getAddressCollection().remove(address);
                countryid = em.merge(countryid);
            }
            Region regionid = address.getRegionid();
            if (regionid != null) {
                regionid.getAddressCollection().remove(address);
                regionid = em.merge(regionid);
            }
            Collection<Assetbankuser> assetbankuserCollection = address.getAssetbankuserCollection();
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuserCollection) {
                assetbankuserCollectionAssetbankuser.setAddressid(null);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            em.remove(address);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Address> findAddressEntities() {
        return findAddressEntities(true, -1, -1);
    }

    public List<Address> findAddressEntities(int maxResults, int firstResult) {
        return findAddressEntities(false, maxResults, firstResult);
    }

    private List<Address> findAddressEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Address.class));
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

    public Address findAddress(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Address.class, id);
        } finally {
            em.close();
        }
    }

    public int getAddressCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Address> rt = cq.from(Address.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
