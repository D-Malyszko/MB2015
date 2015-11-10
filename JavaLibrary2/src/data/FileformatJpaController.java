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
public class FileformatJpaController implements Serializable {

    public FileformatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fileformat fileformat) throws PreexistingEntityException, Exception {
        if (fileformat.getAssetCollection() == null) {
            fileformat.setAssetCollection(new ArrayList<Asset>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assettype assettypeid = fileformat.getAssettypeid();
            if (assettypeid != null) {
                assettypeid = em.getReference(assettypeid.getClass(), assettypeid.getId());
                fileformat.setAssettypeid(assettypeid);
            }
            Collection<Asset> attachedAssetCollection = new ArrayList<Asset>();
            for (Asset assetCollectionAssetToAttach : fileformat.getAssetCollection()) {
                assetCollectionAssetToAttach = em.getReference(assetCollectionAssetToAttach.getClass(), assetCollectionAssetToAttach.getId());
                attachedAssetCollection.add(assetCollectionAssetToAttach);
            }
            fileformat.setAssetCollection(attachedAssetCollection);
            em.persist(fileformat);
            if (assettypeid != null) {
                assettypeid.getFileformatCollection().add(fileformat);
                assettypeid = em.merge(assettypeid);
            }
            for (Asset assetCollectionAsset : fileformat.getAssetCollection()) {
                Fileformat oldFileformatidOfAssetCollectionAsset = assetCollectionAsset.getFileformatid();
                assetCollectionAsset.setFileformatid(fileformat);
                assetCollectionAsset = em.merge(assetCollectionAsset);
                if (oldFileformatidOfAssetCollectionAsset != null) {
                    oldFileformatidOfAssetCollectionAsset.getAssetCollection().remove(assetCollectionAsset);
                    oldFileformatidOfAssetCollectionAsset = em.merge(oldFileformatidOfAssetCollectionAsset);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFileformat(fileformat.getId()) != null) {
                throw new PreexistingEntityException("Fileformat " + fileformat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fileformat fileformat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fileformat persistentFileformat = em.find(Fileformat.class, fileformat.getId());
            Assettype assettypeidOld = persistentFileformat.getAssettypeid();
            Assettype assettypeidNew = fileformat.getAssettypeid();
            Collection<Asset> assetCollectionOld = persistentFileformat.getAssetCollection();
            Collection<Asset> assetCollectionNew = fileformat.getAssetCollection();
            if (assettypeidNew != null) {
                assettypeidNew = em.getReference(assettypeidNew.getClass(), assettypeidNew.getId());
                fileformat.setAssettypeid(assettypeidNew);
            }
            Collection<Asset> attachedAssetCollectionNew = new ArrayList<Asset>();
            for (Asset assetCollectionNewAssetToAttach : assetCollectionNew) {
                assetCollectionNewAssetToAttach = em.getReference(assetCollectionNewAssetToAttach.getClass(), assetCollectionNewAssetToAttach.getId());
                attachedAssetCollectionNew.add(assetCollectionNewAssetToAttach);
            }
            assetCollectionNew = attachedAssetCollectionNew;
            fileformat.setAssetCollection(assetCollectionNew);
            fileformat = em.merge(fileformat);
            if (assettypeidOld != null && !assettypeidOld.equals(assettypeidNew)) {
                assettypeidOld.getFileformatCollection().remove(fileformat);
                assettypeidOld = em.merge(assettypeidOld);
            }
            if (assettypeidNew != null && !assettypeidNew.equals(assettypeidOld)) {
                assettypeidNew.getFileformatCollection().add(fileformat);
                assettypeidNew = em.merge(assettypeidNew);
            }
            for (Asset assetCollectionOldAsset : assetCollectionOld) {
                if (!assetCollectionNew.contains(assetCollectionOldAsset)) {
                    assetCollectionOldAsset.setFileformatid(null);
                    assetCollectionOldAsset = em.merge(assetCollectionOldAsset);
                }
            }
            for (Asset assetCollectionNewAsset : assetCollectionNew) {
                if (!assetCollectionOld.contains(assetCollectionNewAsset)) {
                    Fileformat oldFileformatidOfAssetCollectionNewAsset = assetCollectionNewAsset.getFileformatid();
                    assetCollectionNewAsset.setFileformatid(fileformat);
                    assetCollectionNewAsset = em.merge(assetCollectionNewAsset);
                    if (oldFileformatidOfAssetCollectionNewAsset != null && !oldFileformatidOfAssetCollectionNewAsset.equals(fileformat)) {
                        oldFileformatidOfAssetCollectionNewAsset.getAssetCollection().remove(assetCollectionNewAsset);
                        oldFileformatidOfAssetCollectionNewAsset = em.merge(oldFileformatidOfAssetCollectionNewAsset);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = fileformat.getId();
                if (findFileformat(id) == null) {
                    throw new NonexistentEntityException("The fileformat with id " + id + " no longer exists.");
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
            Fileformat fileformat;
            try {
                fileformat = em.getReference(Fileformat.class, id);
                fileformat.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fileformat with id " + id + " no longer exists.", enfe);
            }
            Assettype assettypeid = fileformat.getAssettypeid();
            if (assettypeid != null) {
                assettypeid.getFileformatCollection().remove(fileformat);
                assettypeid = em.merge(assettypeid);
            }
            Collection<Asset> assetCollection = fileformat.getAssetCollection();
            for (Asset assetCollectionAsset : assetCollection) {
                assetCollectionAsset.setFileformatid(null);
                assetCollectionAsset = em.merge(assetCollectionAsset);
            }
            em.remove(fileformat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fileformat> findFileformatEntities() {
        return findFileformatEntities(true, -1, -1);
    }

    public List<Fileformat> findFileformatEntities(int maxResults, int firstResult) {
        return findFileformatEntities(false, maxResults, firstResult);
    }

    private List<Fileformat> findFileformatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fileformat.class));
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

    public Fileformat findFileformat(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fileformat.class, id);
        } finally {
            em.close();
        }
    }

    public int getFileformatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fileformat> rt = cq.from(Fileformat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
