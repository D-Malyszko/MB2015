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
public class AssetJpaController implements Serializable {

    public AssetJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Asset asset) throws PreexistingEntityException, Exception {
        if (asset.getAssetCollection() == null) {
            asset.setAssetCollection(new ArrayList<Asset>());
        }
        if (asset.getAssetCollection1() == null) {
            asset.setAssetCollection1(new ArrayList<Asset>());
        }
        if (asset.getCmCategoryCollection() == null) {
            asset.setCmCategoryCollection(new ArrayList<CmCategory>());
        }
        if (asset.getAssetCollection2() == null) {
            asset.setAssetCollection2(new ArrayList<Asset>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asset currentversionid = asset.getCurrentversionid();
            if (currentversionid != null) {
                currentversionid = em.getReference(currentversionid.getClass(), currentversionid.getId());
                asset.setCurrentversionid(currentversionid);
            }
            Assetbankuser submittedbyuserid = asset.getSubmittedbyuserid();
            if (submittedbyuserid != null) {
                submittedbyuserid = em.getReference(submittedbyuserid.getClass(), submittedbyuserid.getId());
                asset.setSubmittedbyuserid(submittedbyuserid);
            }
            Assetbankuser addedbyuserid = asset.getAddedbyuserid();
            if (addedbyuserid != null) {
                addedbyuserid = em.getReference(addedbyuserid.getClass(), addedbyuserid.getId());
                asset.setAddedbyuserid(addedbyuserid);
            }
            Assetbankuser lastmodifiedbyuserid = asset.getLastmodifiedbyuserid();
            if (lastmodifiedbyuserid != null) {
                lastmodifiedbyuserid = em.getReference(lastmodifiedbyuserid.getClass(), lastmodifiedbyuserid.getId());
                asset.setLastmodifiedbyuserid(lastmodifiedbyuserid);
            }
            Assetbankuser filecheckedoutbyuserid = asset.getFilecheckedoutbyuserid();
            if (filecheckedoutbyuserid != null) {
                filecheckedoutbyuserid = em.getReference(filecheckedoutbyuserid.getClass(), filecheckedoutbyuserid.getId());
                asset.setFilecheckedoutbyuserid(filecheckedoutbyuserid);
            }
            Assetentity assetentityid = asset.getAssetentityid();
            if (assetentityid != null) {
                assetentityid = em.getReference(assetentityid.getClass(), assetentityid.getId());
                asset.setAssetentityid(assetentityid);
            }
            Assettype assettypeid = asset.getAssettypeid();
            if (assettypeid != null) {
                assettypeid = em.getReference(assettypeid.getClass(), assettypeid.getId());
                asset.setAssettypeid(assettypeid);
            }
            Fileformat fileformatid = asset.getFileformatid();
            if (fileformatid != null) {
                fileformatid = em.getReference(fileformatid.getClass(), fileformatid.getId());
                asset.setFileformatid(fileformatid);
            }
            Collection<Asset> attachedAssetCollection = new ArrayList<Asset>();
            for (Asset assetCollectionAssetToAttach : asset.getAssetCollection()) {
                assetCollectionAssetToAttach = em.getReference(assetCollectionAssetToAttach.getClass(), assetCollectionAssetToAttach.getId());
                attachedAssetCollection.add(assetCollectionAssetToAttach);
            }
            asset.setAssetCollection(attachedAssetCollection);
            Collection<Asset> attachedAssetCollection1 = new ArrayList<Asset>();
            for (Asset assetCollection1AssetToAttach : asset.getAssetCollection1()) {
                assetCollection1AssetToAttach = em.getReference(assetCollection1AssetToAttach.getClass(), assetCollection1AssetToAttach.getId());
                attachedAssetCollection1.add(assetCollection1AssetToAttach);
            }
            asset.setAssetCollection1(attachedAssetCollection1);
            Collection<CmCategory> attachedCmCategoryCollection = new ArrayList<CmCategory>();
            for (CmCategory cmCategoryCollectionCmCategoryToAttach : asset.getCmCategoryCollection()) {
                cmCategoryCollectionCmCategoryToAttach = em.getReference(cmCategoryCollectionCmCategoryToAttach.getClass(), cmCategoryCollectionCmCategoryToAttach.getId());
                attachedCmCategoryCollection.add(cmCategoryCollectionCmCategoryToAttach);
            }
            asset.setCmCategoryCollection(attachedCmCategoryCollection);
            Collection<Asset> attachedAssetCollection2 = new ArrayList<Asset>();
            for (Asset assetCollection2AssetToAttach : asset.getAssetCollection2()) {
                assetCollection2AssetToAttach = em.getReference(assetCollection2AssetToAttach.getClass(), assetCollection2AssetToAttach.getId());
                attachedAssetCollection2.add(assetCollection2AssetToAttach);
            }
            asset.setAssetCollection2(attachedAssetCollection2);
            em.persist(asset);
            if (currentversionid != null) {
                currentversionid.getAssetCollection().add(asset);
                currentversionid = em.merge(currentversionid);
            }
            if (submittedbyuserid != null) {
                submittedbyuserid.getAssetCollection().add(asset);
                submittedbyuserid = em.merge(submittedbyuserid);
            }
            if (addedbyuserid != null) {
                addedbyuserid.getAssetCollection().add(asset);
                addedbyuserid = em.merge(addedbyuserid);
            }
            if (lastmodifiedbyuserid != null) {
                lastmodifiedbyuserid.getAssetCollection().add(asset);
                lastmodifiedbyuserid = em.merge(lastmodifiedbyuserid);
            }
            if (filecheckedoutbyuserid != null) {
                filecheckedoutbyuserid.getAssetCollection().add(asset);
                filecheckedoutbyuserid = em.merge(filecheckedoutbyuserid);
            }
            if (assetentityid != null) {
                assetentityid.getAssetCollection().add(asset);
                assetentityid = em.merge(assetentityid);
            }
            if (assettypeid != null) {
                assettypeid.getAssetCollection().add(asset);
                assettypeid = em.merge(assettypeid);
            }
            if (fileformatid != null) {
                fileformatid.getAssetCollection().add(asset);
                fileformatid = em.merge(fileformatid);
            }
            for (Asset assetCollectionAsset : asset.getAssetCollection()) {
                assetCollectionAsset.getAssetCollection().add(asset);
                assetCollectionAsset = em.merge(assetCollectionAsset);
            }
            for (Asset assetCollection1Asset : asset.getAssetCollection1()) {
                assetCollection1Asset.getAssetCollection().add(asset);
                assetCollection1Asset = em.merge(assetCollection1Asset);
            }
            for (CmCategory cmCategoryCollectionCmCategory : asset.getCmCategoryCollection()) {
                Asset oldExtensionassetidOfCmCategoryCollectionCmCategory = cmCategoryCollectionCmCategory.getExtensionassetid();
                cmCategoryCollectionCmCategory.setExtensionassetid(asset);
                cmCategoryCollectionCmCategory = em.merge(cmCategoryCollectionCmCategory);
                if (oldExtensionassetidOfCmCategoryCollectionCmCategory != null) {
                    oldExtensionassetidOfCmCategoryCollectionCmCategory.getCmCategoryCollection().remove(cmCategoryCollectionCmCategory);
                    oldExtensionassetidOfCmCategoryCollectionCmCategory = em.merge(oldExtensionassetidOfCmCategoryCollectionCmCategory);
                }
            }
            for (Asset assetCollection2Asset : asset.getAssetCollection2()) {
                Asset oldCurrentversionidOfAssetCollection2Asset = assetCollection2Asset.getCurrentversionid();
                assetCollection2Asset.setCurrentversionid(asset);
                assetCollection2Asset = em.merge(assetCollection2Asset);
                if (oldCurrentversionidOfAssetCollection2Asset != null) {
                    oldCurrentversionidOfAssetCollection2Asset.getAssetCollection2().remove(assetCollection2Asset);
                    oldCurrentversionidOfAssetCollection2Asset = em.merge(oldCurrentversionidOfAssetCollection2Asset);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsset(asset.getId()) != null) {
                throw new PreexistingEntityException("Asset " + asset + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asset asset) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Asset persistentAsset = em.find(Asset.class, asset.getId());
            Asset currentversionidOld = persistentAsset.getCurrentversionid();
            Asset currentversionidNew = asset.getCurrentversionid();
            Assetbankuser submittedbyuseridOld = persistentAsset.getSubmittedbyuserid();
            Assetbankuser submittedbyuseridNew = asset.getSubmittedbyuserid();
            Assetbankuser addedbyuseridOld = persistentAsset.getAddedbyuserid();
            Assetbankuser addedbyuseridNew = asset.getAddedbyuserid();
            Assetbankuser lastmodifiedbyuseridOld = persistentAsset.getLastmodifiedbyuserid();
            Assetbankuser lastmodifiedbyuseridNew = asset.getLastmodifiedbyuserid();
            Assetbankuser filecheckedoutbyuseridOld = persistentAsset.getFilecheckedoutbyuserid();
            Assetbankuser filecheckedoutbyuseridNew = asset.getFilecheckedoutbyuserid();
            Assetentity assetentityidOld = persistentAsset.getAssetentityid();
            Assetentity assetentityidNew = asset.getAssetentityid();
            Assettype assettypeidOld = persistentAsset.getAssettypeid();
            Assettype assettypeidNew = asset.getAssettypeid();
            Fileformat fileformatidOld = persistentAsset.getFileformatid();
            Fileformat fileformatidNew = asset.getFileformatid();
            Collection<Asset> assetCollectionOld = persistentAsset.getAssetCollection();
            Collection<Asset> assetCollectionNew = asset.getAssetCollection();
            Collection<Asset> assetCollection1Old = persistentAsset.getAssetCollection1();
            Collection<Asset> assetCollection1New = asset.getAssetCollection1();
            Collection<CmCategory> cmCategoryCollectionOld = persistentAsset.getCmCategoryCollection();
            Collection<CmCategory> cmCategoryCollectionNew = asset.getCmCategoryCollection();
            Collection<Asset> assetCollection2Old = persistentAsset.getAssetCollection2();
            Collection<Asset> assetCollection2New = asset.getAssetCollection2();
            if (currentversionidNew != null) {
                currentversionidNew = em.getReference(currentversionidNew.getClass(), currentversionidNew.getId());
                asset.setCurrentversionid(currentversionidNew);
            }
            if (submittedbyuseridNew != null) {
                submittedbyuseridNew = em.getReference(submittedbyuseridNew.getClass(), submittedbyuseridNew.getId());
                asset.setSubmittedbyuserid(submittedbyuseridNew);
            }
            if (addedbyuseridNew != null) {
                addedbyuseridNew = em.getReference(addedbyuseridNew.getClass(), addedbyuseridNew.getId());
                asset.setAddedbyuserid(addedbyuseridNew);
            }
            if (lastmodifiedbyuseridNew != null) {
                lastmodifiedbyuseridNew = em.getReference(lastmodifiedbyuseridNew.getClass(), lastmodifiedbyuseridNew.getId());
                asset.setLastmodifiedbyuserid(lastmodifiedbyuseridNew);
            }
            if (filecheckedoutbyuseridNew != null) {
                filecheckedoutbyuseridNew = em.getReference(filecheckedoutbyuseridNew.getClass(), filecheckedoutbyuseridNew.getId());
                asset.setFilecheckedoutbyuserid(filecheckedoutbyuseridNew);
            }
            if (assetentityidNew != null) {
                assetentityidNew = em.getReference(assetentityidNew.getClass(), assetentityidNew.getId());
                asset.setAssetentityid(assetentityidNew);
            }
            if (assettypeidNew != null) {
                assettypeidNew = em.getReference(assettypeidNew.getClass(), assettypeidNew.getId());
                asset.setAssettypeid(assettypeidNew);
            }
            if (fileformatidNew != null) {
                fileformatidNew = em.getReference(fileformatidNew.getClass(), fileformatidNew.getId());
                asset.setFileformatid(fileformatidNew);
            }
            Collection<Asset> attachedAssetCollectionNew = new ArrayList<Asset>();
            for (Asset assetCollectionNewAssetToAttach : assetCollectionNew) {
                assetCollectionNewAssetToAttach = em.getReference(assetCollectionNewAssetToAttach.getClass(), assetCollectionNewAssetToAttach.getId());
                attachedAssetCollectionNew.add(assetCollectionNewAssetToAttach);
            }
            assetCollectionNew = attachedAssetCollectionNew;
            asset.setAssetCollection(assetCollectionNew);
            Collection<Asset> attachedAssetCollection1New = new ArrayList<Asset>();
            for (Asset assetCollection1NewAssetToAttach : assetCollection1New) {
                assetCollection1NewAssetToAttach = em.getReference(assetCollection1NewAssetToAttach.getClass(), assetCollection1NewAssetToAttach.getId());
                attachedAssetCollection1New.add(assetCollection1NewAssetToAttach);
            }
            assetCollection1New = attachedAssetCollection1New;
            asset.setAssetCollection1(assetCollection1New);
            Collection<CmCategory> attachedCmCategoryCollectionNew = new ArrayList<CmCategory>();
            for (CmCategory cmCategoryCollectionNewCmCategoryToAttach : cmCategoryCollectionNew) {
                cmCategoryCollectionNewCmCategoryToAttach = em.getReference(cmCategoryCollectionNewCmCategoryToAttach.getClass(), cmCategoryCollectionNewCmCategoryToAttach.getId());
                attachedCmCategoryCollectionNew.add(cmCategoryCollectionNewCmCategoryToAttach);
            }
            cmCategoryCollectionNew = attachedCmCategoryCollectionNew;
            asset.setCmCategoryCollection(cmCategoryCollectionNew);
            Collection<Asset> attachedAssetCollection2New = new ArrayList<Asset>();
            for (Asset assetCollection2NewAssetToAttach : assetCollection2New) {
                assetCollection2NewAssetToAttach = em.getReference(assetCollection2NewAssetToAttach.getClass(), assetCollection2NewAssetToAttach.getId());
                attachedAssetCollection2New.add(assetCollection2NewAssetToAttach);
            }
            assetCollection2New = attachedAssetCollection2New;
            asset.setAssetCollection2(assetCollection2New);
            asset = em.merge(asset);
            if (currentversionidOld != null && !currentversionidOld.equals(currentversionidNew)) {
                currentversionidOld.getAssetCollection().remove(asset);
                currentversionidOld = em.merge(currentversionidOld);
            }
            if (currentversionidNew != null && !currentversionidNew.equals(currentversionidOld)) {
                currentversionidNew.getAssetCollection().add(asset);
                currentversionidNew = em.merge(currentversionidNew);
            }
            if (submittedbyuseridOld != null && !submittedbyuseridOld.equals(submittedbyuseridNew)) {
                submittedbyuseridOld.getAssetCollection().remove(asset);
                submittedbyuseridOld = em.merge(submittedbyuseridOld);
            }
            if (submittedbyuseridNew != null && !submittedbyuseridNew.equals(submittedbyuseridOld)) {
                submittedbyuseridNew.getAssetCollection().add(asset);
                submittedbyuseridNew = em.merge(submittedbyuseridNew);
            }
            if (addedbyuseridOld != null && !addedbyuseridOld.equals(addedbyuseridNew)) {
                addedbyuseridOld.getAssetCollection().remove(asset);
                addedbyuseridOld = em.merge(addedbyuseridOld);
            }
            if (addedbyuseridNew != null && !addedbyuseridNew.equals(addedbyuseridOld)) {
                addedbyuseridNew.getAssetCollection().add(asset);
                addedbyuseridNew = em.merge(addedbyuseridNew);
            }
            if (lastmodifiedbyuseridOld != null && !lastmodifiedbyuseridOld.equals(lastmodifiedbyuseridNew)) {
                lastmodifiedbyuseridOld.getAssetCollection().remove(asset);
                lastmodifiedbyuseridOld = em.merge(lastmodifiedbyuseridOld);
            }
            if (lastmodifiedbyuseridNew != null && !lastmodifiedbyuseridNew.equals(lastmodifiedbyuseridOld)) {
                lastmodifiedbyuseridNew.getAssetCollection().add(asset);
                lastmodifiedbyuseridNew = em.merge(lastmodifiedbyuseridNew);
            }
            if (filecheckedoutbyuseridOld != null && !filecheckedoutbyuseridOld.equals(filecheckedoutbyuseridNew)) {
                filecheckedoutbyuseridOld.getAssetCollection().remove(asset);
                filecheckedoutbyuseridOld = em.merge(filecheckedoutbyuseridOld);
            }
            if (filecheckedoutbyuseridNew != null && !filecheckedoutbyuseridNew.equals(filecheckedoutbyuseridOld)) {
                filecheckedoutbyuseridNew.getAssetCollection().add(asset);
                filecheckedoutbyuseridNew = em.merge(filecheckedoutbyuseridNew);
            }
            if (assetentityidOld != null && !assetentityidOld.equals(assetentityidNew)) {
                assetentityidOld.getAssetCollection().remove(asset);
                assetentityidOld = em.merge(assetentityidOld);
            }
            if (assetentityidNew != null && !assetentityidNew.equals(assetentityidOld)) {
                assetentityidNew.getAssetCollection().add(asset);
                assetentityidNew = em.merge(assetentityidNew);
            }
            if (assettypeidOld != null && !assettypeidOld.equals(assettypeidNew)) {
                assettypeidOld.getAssetCollection().remove(asset);
                assettypeidOld = em.merge(assettypeidOld);
            }
            if (assettypeidNew != null && !assettypeidNew.equals(assettypeidOld)) {
                assettypeidNew.getAssetCollection().add(asset);
                assettypeidNew = em.merge(assettypeidNew);
            }
            if (fileformatidOld != null && !fileformatidOld.equals(fileformatidNew)) {
                fileformatidOld.getAssetCollection().remove(asset);
                fileformatidOld = em.merge(fileformatidOld);
            }
            if (fileformatidNew != null && !fileformatidNew.equals(fileformatidOld)) {
                fileformatidNew.getAssetCollection().add(asset);
                fileformatidNew = em.merge(fileformatidNew);
            }
            for (Asset assetCollectionOldAsset : assetCollectionOld) {
                if (!assetCollectionNew.contains(assetCollectionOldAsset)) {
                    assetCollectionOldAsset.getAssetCollection().remove(asset);
                    assetCollectionOldAsset = em.merge(assetCollectionOldAsset);
                }
            }
            for (Asset assetCollectionNewAsset : assetCollectionNew) {
                if (!assetCollectionOld.contains(assetCollectionNewAsset)) {
                    assetCollectionNewAsset.getAssetCollection().add(asset);
                    assetCollectionNewAsset = em.merge(assetCollectionNewAsset);
                }
            }
            for (Asset assetCollection1OldAsset : assetCollection1Old) {
                if (!assetCollection1New.contains(assetCollection1OldAsset)) {
                    assetCollection1OldAsset.getAssetCollection().remove(asset);
                    assetCollection1OldAsset = em.merge(assetCollection1OldAsset);
                }
            }
            for (Asset assetCollection1NewAsset : assetCollection1New) {
                if (!assetCollection1Old.contains(assetCollection1NewAsset)) {
                    assetCollection1NewAsset.getAssetCollection().add(asset);
                    assetCollection1NewAsset = em.merge(assetCollection1NewAsset);
                }
            }
            for (CmCategory cmCategoryCollectionOldCmCategory : cmCategoryCollectionOld) {
                if (!cmCategoryCollectionNew.contains(cmCategoryCollectionOldCmCategory)) {
                    cmCategoryCollectionOldCmCategory.setExtensionassetid(null);
                    cmCategoryCollectionOldCmCategory = em.merge(cmCategoryCollectionOldCmCategory);
                }
            }
            for (CmCategory cmCategoryCollectionNewCmCategory : cmCategoryCollectionNew) {
                if (!cmCategoryCollectionOld.contains(cmCategoryCollectionNewCmCategory)) {
                    Asset oldExtensionassetidOfCmCategoryCollectionNewCmCategory = cmCategoryCollectionNewCmCategory.getExtensionassetid();
                    cmCategoryCollectionNewCmCategory.setExtensionassetid(asset);
                    cmCategoryCollectionNewCmCategory = em.merge(cmCategoryCollectionNewCmCategory);
                    if (oldExtensionassetidOfCmCategoryCollectionNewCmCategory != null && !oldExtensionassetidOfCmCategoryCollectionNewCmCategory.equals(asset)) {
                        oldExtensionassetidOfCmCategoryCollectionNewCmCategory.getCmCategoryCollection().remove(cmCategoryCollectionNewCmCategory);
                        oldExtensionassetidOfCmCategoryCollectionNewCmCategory = em.merge(oldExtensionassetidOfCmCategoryCollectionNewCmCategory);
                    }
                }
            }
            for (Asset assetCollection2OldAsset : assetCollection2Old) {
                if (!assetCollection2New.contains(assetCollection2OldAsset)) {
                    assetCollection2OldAsset.setCurrentversionid(null);
                    assetCollection2OldAsset = em.merge(assetCollection2OldAsset);
                }
            }
            for (Asset assetCollection2NewAsset : assetCollection2New) {
                if (!assetCollection2Old.contains(assetCollection2NewAsset)) {
                    Asset oldCurrentversionidOfAssetCollection2NewAsset = assetCollection2NewAsset.getCurrentversionid();
                    assetCollection2NewAsset.setCurrentversionid(asset);
                    assetCollection2NewAsset = em.merge(assetCollection2NewAsset);
                    if (oldCurrentversionidOfAssetCollection2NewAsset != null && !oldCurrentversionidOfAssetCollection2NewAsset.equals(asset)) {
                        oldCurrentversionidOfAssetCollection2NewAsset.getAssetCollection2().remove(assetCollection2NewAsset);
                        oldCurrentversionidOfAssetCollection2NewAsset = em.merge(oldCurrentversionidOfAssetCollection2NewAsset);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asset.getId();
                if (findAsset(id) == null) {
                    throw new NonexistentEntityException("The asset with id " + id + " no longer exists.");
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
            Asset asset;
            try {
                asset = em.getReference(Asset.class, id);
                asset.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asset with id " + id + " no longer exists.", enfe);
            }
            Asset currentversionid = asset.getCurrentversionid();
            if (currentversionid != null) {
                currentversionid.getAssetCollection().remove(asset);
                currentversionid = em.merge(currentversionid);
            }
            Assetbankuser submittedbyuserid = asset.getSubmittedbyuserid();
            if (submittedbyuserid != null) {
                submittedbyuserid.getAssetCollection().remove(asset);
                submittedbyuserid = em.merge(submittedbyuserid);
            }
            Assetbankuser addedbyuserid = asset.getAddedbyuserid();
            if (addedbyuserid != null) {
                addedbyuserid.getAssetCollection().remove(asset);
                addedbyuserid = em.merge(addedbyuserid);
            }
            Assetbankuser lastmodifiedbyuserid = asset.getLastmodifiedbyuserid();
            if (lastmodifiedbyuserid != null) {
                lastmodifiedbyuserid.getAssetCollection().remove(asset);
                lastmodifiedbyuserid = em.merge(lastmodifiedbyuserid);
            }
            Assetbankuser filecheckedoutbyuserid = asset.getFilecheckedoutbyuserid();
            if (filecheckedoutbyuserid != null) {
                filecheckedoutbyuserid.getAssetCollection().remove(asset);
                filecheckedoutbyuserid = em.merge(filecheckedoutbyuserid);
            }
            Assetentity assetentityid = asset.getAssetentityid();
            if (assetentityid != null) {
                assetentityid.getAssetCollection().remove(asset);
                assetentityid = em.merge(assetentityid);
            }
            Assettype assettypeid = asset.getAssettypeid();
            if (assettypeid != null) {
                assettypeid.getAssetCollection().remove(asset);
                assettypeid = em.merge(assettypeid);
            }
            Fileformat fileformatid = asset.getFileformatid();
            if (fileformatid != null) {
                fileformatid.getAssetCollection().remove(asset);
                fileformatid = em.merge(fileformatid);
            }
            Collection<Asset> assetCollection = asset.getAssetCollection();
            for (Asset assetCollectionAsset : assetCollection) {
                assetCollectionAsset.getAssetCollection().remove(asset);
                assetCollectionAsset = em.merge(assetCollectionAsset);
            }
            Collection<Asset> assetCollection1 = asset.getAssetCollection1();
            for (Asset assetCollection1Asset : assetCollection1) {
                assetCollection1Asset.getAssetCollection().remove(asset);
                assetCollection1Asset = em.merge(assetCollection1Asset);
            }
            Collection<CmCategory> cmCategoryCollection = asset.getCmCategoryCollection();
            for (CmCategory cmCategoryCollectionCmCategory : cmCategoryCollection) {
                cmCategoryCollectionCmCategory.setExtensionassetid(null);
                cmCategoryCollectionCmCategory = em.merge(cmCategoryCollectionCmCategory);
            }
            Collection<Asset> assetCollection2 = asset.getAssetCollection2();
            for (Asset assetCollection2Asset : assetCollection2) {
                assetCollection2Asset.setCurrentversionid(null);
                assetCollection2Asset = em.merge(assetCollection2Asset);
            }
            em.remove(asset);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asset> findAssetEntities() {
        return findAssetEntities(true, -1, -1);
    }

    public List<Asset> findAssetEntities(int maxResults, int firstResult) {
        return findAssetEntities(false, maxResults, firstResult);
    }

    private List<Asset> findAssetEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asset.class));
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

    public Asset findAsset(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asset.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssetCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asset> rt = cq.from(Asset.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
