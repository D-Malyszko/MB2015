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
public class AssettypeJpaController implements Serializable {

    public AssettypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assettype assettype) throws PreexistingEntityException, Exception {
        if (assettype.getAssetentityCollection() == null) {
            assettype.setAssetentityCollection(new ArrayList<Assetentity>());
        }
        if (assettype.getFileformatCollection() == null) {
            assettype.setFileformatCollection(new ArrayList<Fileformat>());
        }
        if (assettype.getAssetCollection() == null) {
            assettype.setAssetCollection(new ArrayList<Asset>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Assetentity> attachedAssetentityCollection = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionAssetentityToAttach : assettype.getAssetentityCollection()) {
                assetentityCollectionAssetentityToAttach = em.getReference(assetentityCollectionAssetentityToAttach.getClass(), assetentityCollectionAssetentityToAttach.getId());
                attachedAssetentityCollection.add(assetentityCollectionAssetentityToAttach);
            }
            assettype.setAssetentityCollection(attachedAssetentityCollection);
            Collection<Fileformat> attachedFileformatCollection = new ArrayList<Fileformat>();
            for (Fileformat fileformatCollectionFileformatToAttach : assettype.getFileformatCollection()) {
                fileformatCollectionFileformatToAttach = em.getReference(fileformatCollectionFileformatToAttach.getClass(), fileformatCollectionFileformatToAttach.getId());
                attachedFileformatCollection.add(fileformatCollectionFileformatToAttach);
            }
            assettype.setFileformatCollection(attachedFileformatCollection);
            Collection<Asset> attachedAssetCollection = new ArrayList<Asset>();
            for (Asset assetCollectionAssetToAttach : assettype.getAssetCollection()) {
                assetCollectionAssetToAttach = em.getReference(assetCollectionAssetToAttach.getClass(), assetCollectionAssetToAttach.getId());
                attachedAssetCollection.add(assetCollectionAssetToAttach);
            }
            assettype.setAssetCollection(attachedAssetCollection);
            em.persist(assettype);
            for (Assetentity assetentityCollectionAssetentity : assettype.getAssetentityCollection()) {
                assetentityCollectionAssetentity.getAssettypeCollection().add(assettype);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
            }
            for (Fileformat fileformatCollectionFileformat : assettype.getFileformatCollection()) {
                Assettype oldAssettypeidOfFileformatCollectionFileformat = fileformatCollectionFileformat.getAssettypeid();
                fileformatCollectionFileformat.setAssettypeid(assettype);
                fileformatCollectionFileformat = em.merge(fileformatCollectionFileformat);
                if (oldAssettypeidOfFileformatCollectionFileformat != null) {
                    oldAssettypeidOfFileformatCollectionFileformat.getFileformatCollection().remove(fileformatCollectionFileformat);
                    oldAssettypeidOfFileformatCollectionFileformat = em.merge(oldAssettypeidOfFileformatCollectionFileformat);
                }
            }
            for (Asset assetCollectionAsset : assettype.getAssetCollection()) {
                Assettype oldAssettypeidOfAssetCollectionAsset = assetCollectionAsset.getAssettypeid();
                assetCollectionAsset.setAssettypeid(assettype);
                assetCollectionAsset = em.merge(assetCollectionAsset);
                if (oldAssettypeidOfAssetCollectionAsset != null) {
                    oldAssettypeidOfAssetCollectionAsset.getAssetCollection().remove(assetCollectionAsset);
                    oldAssettypeidOfAssetCollectionAsset = em.merge(oldAssettypeidOfAssetCollectionAsset);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAssettype(assettype.getId()) != null) {
                throw new PreexistingEntityException("Assettype " + assettype + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Assettype assettype) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assettype persistentAssettype = em.find(Assettype.class, assettype.getId());
            Collection<Assetentity> assetentityCollectionOld = persistentAssettype.getAssetentityCollection();
            Collection<Assetentity> assetentityCollectionNew = assettype.getAssetentityCollection();
            Collection<Fileformat> fileformatCollectionOld = persistentAssettype.getFileformatCollection();
            Collection<Fileformat> fileformatCollectionNew = assettype.getFileformatCollection();
            Collection<Asset> assetCollectionOld = persistentAssettype.getAssetCollection();
            Collection<Asset> assetCollectionNew = assettype.getAssetCollection();
            Collection<Assetentity> attachedAssetentityCollectionNew = new ArrayList<Assetentity>();
            for (Assetentity assetentityCollectionNewAssetentityToAttach : assetentityCollectionNew) {
                assetentityCollectionNewAssetentityToAttach = em.getReference(assetentityCollectionNewAssetentityToAttach.getClass(), assetentityCollectionNewAssetentityToAttach.getId());
                attachedAssetentityCollectionNew.add(assetentityCollectionNewAssetentityToAttach);
            }
            assetentityCollectionNew = attachedAssetentityCollectionNew;
            assettype.setAssetentityCollection(assetentityCollectionNew);
            Collection<Fileformat> attachedFileformatCollectionNew = new ArrayList<Fileformat>();
            for (Fileformat fileformatCollectionNewFileformatToAttach : fileformatCollectionNew) {
                fileformatCollectionNewFileformatToAttach = em.getReference(fileformatCollectionNewFileformatToAttach.getClass(), fileformatCollectionNewFileformatToAttach.getId());
                attachedFileformatCollectionNew.add(fileformatCollectionNewFileformatToAttach);
            }
            fileformatCollectionNew = attachedFileformatCollectionNew;
            assettype.setFileformatCollection(fileformatCollectionNew);
            Collection<Asset> attachedAssetCollectionNew = new ArrayList<Asset>();
            for (Asset assetCollectionNewAssetToAttach : assetCollectionNew) {
                assetCollectionNewAssetToAttach = em.getReference(assetCollectionNewAssetToAttach.getClass(), assetCollectionNewAssetToAttach.getId());
                attachedAssetCollectionNew.add(assetCollectionNewAssetToAttach);
            }
            assetCollectionNew = attachedAssetCollectionNew;
            assettype.setAssetCollection(assetCollectionNew);
            assettype = em.merge(assettype);
            for (Assetentity assetentityCollectionOldAssetentity : assetentityCollectionOld) {
                if (!assetentityCollectionNew.contains(assetentityCollectionOldAssetentity)) {
                    assetentityCollectionOldAssetentity.getAssettypeCollection().remove(assettype);
                    assetentityCollectionOldAssetentity = em.merge(assetentityCollectionOldAssetentity);
                }
            }
            for (Assetentity assetentityCollectionNewAssetentity : assetentityCollectionNew) {
                if (!assetentityCollectionOld.contains(assetentityCollectionNewAssetentity)) {
                    assetentityCollectionNewAssetentity.getAssettypeCollection().add(assettype);
                    assetentityCollectionNewAssetentity = em.merge(assetentityCollectionNewAssetentity);
                }
            }
            for (Fileformat fileformatCollectionOldFileformat : fileformatCollectionOld) {
                if (!fileformatCollectionNew.contains(fileformatCollectionOldFileformat)) {
                    fileformatCollectionOldFileformat.setAssettypeid(null);
                    fileformatCollectionOldFileformat = em.merge(fileformatCollectionOldFileformat);
                }
            }
            for (Fileformat fileformatCollectionNewFileformat : fileformatCollectionNew) {
                if (!fileformatCollectionOld.contains(fileformatCollectionNewFileformat)) {
                    Assettype oldAssettypeidOfFileformatCollectionNewFileformat = fileformatCollectionNewFileformat.getAssettypeid();
                    fileformatCollectionNewFileformat.setAssettypeid(assettype);
                    fileformatCollectionNewFileformat = em.merge(fileformatCollectionNewFileformat);
                    if (oldAssettypeidOfFileformatCollectionNewFileformat != null && !oldAssettypeidOfFileformatCollectionNewFileformat.equals(assettype)) {
                        oldAssettypeidOfFileformatCollectionNewFileformat.getFileformatCollection().remove(fileformatCollectionNewFileformat);
                        oldAssettypeidOfFileformatCollectionNewFileformat = em.merge(oldAssettypeidOfFileformatCollectionNewFileformat);
                    }
                }
            }
            for (Asset assetCollectionOldAsset : assetCollectionOld) {
                if (!assetCollectionNew.contains(assetCollectionOldAsset)) {
                    assetCollectionOldAsset.setAssettypeid(null);
                    assetCollectionOldAsset = em.merge(assetCollectionOldAsset);
                }
            }
            for (Asset assetCollectionNewAsset : assetCollectionNew) {
                if (!assetCollectionOld.contains(assetCollectionNewAsset)) {
                    Assettype oldAssettypeidOfAssetCollectionNewAsset = assetCollectionNewAsset.getAssettypeid();
                    assetCollectionNewAsset.setAssettypeid(assettype);
                    assetCollectionNewAsset = em.merge(assetCollectionNewAsset);
                    if (oldAssettypeidOfAssetCollectionNewAsset != null && !oldAssettypeidOfAssetCollectionNewAsset.equals(assettype)) {
                        oldAssettypeidOfAssetCollectionNewAsset.getAssetCollection().remove(assetCollectionNewAsset);
                        oldAssettypeidOfAssetCollectionNewAsset = em.merge(oldAssettypeidOfAssetCollectionNewAsset);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = assettype.getId();
                if (findAssettype(id) == null) {
                    throw new NonexistentEntityException("The assettype with id " + id + " no longer exists.");
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
            Assettype assettype;
            try {
                assettype = em.getReference(Assettype.class, id);
                assettype.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assettype with id " + id + " no longer exists.", enfe);
            }
            Collection<Assetentity> assetentityCollection = assettype.getAssetentityCollection();
            for (Assetentity assetentityCollectionAssetentity : assetentityCollection) {
                assetentityCollectionAssetentity.getAssettypeCollection().remove(assettype);
                assetentityCollectionAssetentity = em.merge(assetentityCollectionAssetentity);
            }
            Collection<Fileformat> fileformatCollection = assettype.getFileformatCollection();
            for (Fileformat fileformatCollectionFileformat : fileformatCollection) {
                fileformatCollectionFileformat.setAssettypeid(null);
                fileformatCollectionFileformat = em.merge(fileformatCollectionFileformat);
            }
            Collection<Asset> assetCollection = assettype.getAssetCollection();
            for (Asset assetCollectionAsset : assetCollection) {
                assetCollectionAsset.setAssettypeid(null);
                assetCollectionAsset = em.merge(assetCollectionAsset);
            }
            em.remove(assettype);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assettype> findAssettypeEntities() {
        return findAssettypeEntities(true, -1, -1);
    }

    public List<Assettype> findAssettypeEntities(int maxResults, int firstResult) {
        return findAssettypeEntities(false, maxResults, firstResult);
    }

    private List<Assettype> findAssettypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assettype.class));
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

    public Assettype findAssettype(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assettype.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssettypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assettype> rt = cq.from(Assettype.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
