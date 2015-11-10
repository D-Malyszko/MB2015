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
public class AssetbankuserJpaController implements Serializable {

    public AssetbankuserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assetbankuser assetbankuser) throws PreexistingEntityException, Exception {
        if (assetbankuser.getUsergroupCollection() == null) {
            assetbankuser.setUsergroupCollection(new ArrayList<Usergroup>());
        }
        if (assetbankuser.getLanguageCollection() == null) {
            assetbankuser.setLanguageCollection(new ArrayList<Language>());
        }
        if (assetbankuser.getAssetCollection() == null) {
            assetbankuser.setAssetCollection(new ArrayList<Asset>());
        }
        if (assetbankuser.getAssetCollection1() == null) {
            assetbankuser.setAssetCollection1(new ArrayList<Asset>());
        }
        if (assetbankuser.getAssetCollection2() == null) {
            assetbankuser.setAssetCollection2(new ArrayList<Asset>());
        }
        if (assetbankuser.getAssetCollection3() == null) {
            assetbankuser.setAssetCollection3(new ArrayList<Asset>());
        }
        if (assetbankuser.getAssetbankuserCollection() == null) {
            assetbankuser.setAssetbankuserCollection(new ArrayList<Assetbankuser>());
        }
        if (assetbankuser.getAssetbankuserCollection1() == null) {
            assetbankuser.setAssetbankuserCollection1(new ArrayList<Assetbankuser>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Address addressid = assetbankuser.getAddressid();
            if (addressid != null) {
                addressid = em.getReference(addressid.getClass(), addressid.getId());
                assetbankuser.setAddressid(addressid);
            }
            Assetbankuser lastmodifiedbyid = assetbankuser.getLastmodifiedbyid();
            if (lastmodifiedbyid != null) {
                lastmodifiedbyid = em.getReference(lastmodifiedbyid.getClass(), lastmodifiedbyid.getId());
                assetbankuser.setLastmodifiedbyid(lastmodifiedbyid);
            }
            Assetbankuser invitedbyuserid = assetbankuser.getInvitedbyuserid();
            if (invitedbyuserid != null) {
                invitedbyuserid = em.getReference(invitedbyuserid.getClass(), invitedbyuserid.getId());
                assetbankuser.setInvitedbyuserid(invitedbyuserid);
            }
            Division divisionid = assetbankuser.getDivisionid();
            if (divisionid != null) {
                divisionid = em.getReference(divisionid.getClass(), divisionid.getId());
                assetbankuser.setDivisionid(divisionid);
            }
            Language languageid = assetbankuser.getLanguageid();
            if (languageid != null) {
                languageid = em.getReference(languageid.getClass(), languageid.getId());
                assetbankuser.setLanguageid(languageid);
            }
            Orgunit requestedorgunitid = assetbankuser.getRequestedorgunitid();
            if (requestedorgunitid != null) {
                requestedorgunitid = em.getReference(requestedorgunitid.getClass(), requestedorgunitid.getId());
                assetbankuser.setRequestedorgunitid(requestedorgunitid);
            }
            Collection<Usergroup> attachedUsergroupCollection = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionUsergroupToAttach : assetbankuser.getUsergroupCollection()) {
                usergroupCollectionUsergroupToAttach = em.getReference(usergroupCollectionUsergroupToAttach.getClass(), usergroupCollectionUsergroupToAttach.getId());
                attachedUsergroupCollection.add(usergroupCollectionUsergroupToAttach);
            }
            assetbankuser.setUsergroupCollection(attachedUsergroupCollection);
            Collection<Language> attachedLanguageCollection = new ArrayList<Language>();
            for (Language languageCollectionLanguageToAttach : assetbankuser.getLanguageCollection()) {
                languageCollectionLanguageToAttach = em.getReference(languageCollectionLanguageToAttach.getClass(), languageCollectionLanguageToAttach.getId());
                attachedLanguageCollection.add(languageCollectionLanguageToAttach);
            }
            assetbankuser.setLanguageCollection(attachedLanguageCollection);
            Collection<Asset> attachedAssetCollection = new ArrayList<Asset>();
            for (Asset assetCollectionAssetToAttach : assetbankuser.getAssetCollection()) {
                assetCollectionAssetToAttach = em.getReference(assetCollectionAssetToAttach.getClass(), assetCollectionAssetToAttach.getId());
                attachedAssetCollection.add(assetCollectionAssetToAttach);
            }
            assetbankuser.setAssetCollection(attachedAssetCollection);
            Collection<Asset> attachedAssetCollection1 = new ArrayList<Asset>();
            for (Asset assetCollection1AssetToAttach : assetbankuser.getAssetCollection1()) {
                assetCollection1AssetToAttach = em.getReference(assetCollection1AssetToAttach.getClass(), assetCollection1AssetToAttach.getId());
                attachedAssetCollection1.add(assetCollection1AssetToAttach);
            }
            assetbankuser.setAssetCollection1(attachedAssetCollection1);
            Collection<Asset> attachedAssetCollection2 = new ArrayList<Asset>();
            for (Asset assetCollection2AssetToAttach : assetbankuser.getAssetCollection2()) {
                assetCollection2AssetToAttach = em.getReference(assetCollection2AssetToAttach.getClass(), assetCollection2AssetToAttach.getId());
                attachedAssetCollection2.add(assetCollection2AssetToAttach);
            }
            assetbankuser.setAssetCollection2(attachedAssetCollection2);
            Collection<Asset> attachedAssetCollection3 = new ArrayList<Asset>();
            for (Asset assetCollection3AssetToAttach : assetbankuser.getAssetCollection3()) {
                assetCollection3AssetToAttach = em.getReference(assetCollection3AssetToAttach.getClass(), assetCollection3AssetToAttach.getId());
                attachedAssetCollection3.add(assetCollection3AssetToAttach);
            }
            assetbankuser.setAssetCollection3(attachedAssetCollection3);
            Collection<Assetbankuser> attachedAssetbankuserCollection = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionAssetbankuserToAttach : assetbankuser.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuserToAttach = em.getReference(assetbankuserCollectionAssetbankuserToAttach.getClass(), assetbankuserCollectionAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection.add(assetbankuserCollectionAssetbankuserToAttach);
            }
            assetbankuser.setAssetbankuserCollection(attachedAssetbankuserCollection);
            Collection<Assetbankuser> attachedAssetbankuserCollection1 = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollection1AssetbankuserToAttach : assetbankuser.getAssetbankuserCollection1()) {
                assetbankuserCollection1AssetbankuserToAttach = em.getReference(assetbankuserCollection1AssetbankuserToAttach.getClass(), assetbankuserCollection1AssetbankuserToAttach.getId());
                attachedAssetbankuserCollection1.add(assetbankuserCollection1AssetbankuserToAttach);
            }
            assetbankuser.setAssetbankuserCollection1(attachedAssetbankuserCollection1);
            em.persist(assetbankuser);
            if (addressid != null) {
                addressid.getAssetbankuserCollection().add(assetbankuser);
                addressid = em.merge(addressid);
            }
            if (lastmodifiedbyid != null) {
                lastmodifiedbyid.getAssetbankuserCollection().add(assetbankuser);
                lastmodifiedbyid = em.merge(lastmodifiedbyid);
            }
            if (invitedbyuserid != null) {
                invitedbyuserid.getAssetbankuserCollection().add(assetbankuser);
                invitedbyuserid = em.merge(invitedbyuserid);
            }
            if (divisionid != null) {
                divisionid.getAssetbankuserCollection().add(assetbankuser);
                divisionid = em.merge(divisionid);
            }
            if (languageid != null) {
                languageid.getAssetbankuserCollection().add(assetbankuser);
                languageid = em.merge(languageid);
            }
            if (requestedorgunitid != null) {
                requestedorgunitid.getAssetbankuserCollection().add(assetbankuser);
                requestedorgunitid = em.merge(requestedorgunitid);
            }
            for (Usergroup usergroupCollectionUsergroup : assetbankuser.getUsergroupCollection()) {
                usergroupCollectionUsergroup.getAssetbankuserCollection().add(assetbankuser);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            for (Language languageCollectionLanguage : assetbankuser.getLanguageCollection()) {
                languageCollectionLanguage.getAssetbankuserCollection().add(assetbankuser);
                languageCollectionLanguage = em.merge(languageCollectionLanguage);
            }
            for (Asset assetCollectionAsset : assetbankuser.getAssetCollection()) {
                Assetbankuser oldSubmittedbyuseridOfAssetCollectionAsset = assetCollectionAsset.getSubmittedbyuserid();
                assetCollectionAsset.setSubmittedbyuserid(assetbankuser);
                assetCollectionAsset = em.merge(assetCollectionAsset);
                if (oldSubmittedbyuseridOfAssetCollectionAsset != null) {
                    oldSubmittedbyuseridOfAssetCollectionAsset.getAssetCollection().remove(assetCollectionAsset);
                    oldSubmittedbyuseridOfAssetCollectionAsset = em.merge(oldSubmittedbyuseridOfAssetCollectionAsset);
                }
            }
            for (Asset assetCollection1Asset : assetbankuser.getAssetCollection1()) {
                Assetbankuser oldAddedbyuseridOfAssetCollection1Asset = assetCollection1Asset.getAddedbyuserid();
                assetCollection1Asset.setAddedbyuserid(assetbankuser);
                assetCollection1Asset = em.merge(assetCollection1Asset);
                if (oldAddedbyuseridOfAssetCollection1Asset != null) {
                    oldAddedbyuseridOfAssetCollection1Asset.getAssetCollection1().remove(assetCollection1Asset);
                    oldAddedbyuseridOfAssetCollection1Asset = em.merge(oldAddedbyuseridOfAssetCollection1Asset);
                }
            }
            for (Asset assetCollection2Asset : assetbankuser.getAssetCollection2()) {
                Assetbankuser oldLastmodifiedbyuseridOfAssetCollection2Asset = assetCollection2Asset.getLastmodifiedbyuserid();
                assetCollection2Asset.setLastmodifiedbyuserid(assetbankuser);
                assetCollection2Asset = em.merge(assetCollection2Asset);
                if (oldLastmodifiedbyuseridOfAssetCollection2Asset != null) {
                    oldLastmodifiedbyuseridOfAssetCollection2Asset.getAssetCollection2().remove(assetCollection2Asset);
                    oldLastmodifiedbyuseridOfAssetCollection2Asset = em.merge(oldLastmodifiedbyuseridOfAssetCollection2Asset);
                }
            }
            for (Asset assetCollection3Asset : assetbankuser.getAssetCollection3()) {
                Assetbankuser oldFilecheckedoutbyuseridOfAssetCollection3Asset = assetCollection3Asset.getFilecheckedoutbyuserid();
                assetCollection3Asset.setFilecheckedoutbyuserid(assetbankuser);
                assetCollection3Asset = em.merge(assetCollection3Asset);
                if (oldFilecheckedoutbyuseridOfAssetCollection3Asset != null) {
                    oldFilecheckedoutbyuseridOfAssetCollection3Asset.getAssetCollection3().remove(assetCollection3Asset);
                    oldFilecheckedoutbyuseridOfAssetCollection3Asset = em.merge(oldFilecheckedoutbyuseridOfAssetCollection3Asset);
                }
            }
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuser.getAssetbankuserCollection()) {
                Assetbankuser oldLastmodifiedbyidOfAssetbankuserCollectionAssetbankuser = assetbankuserCollectionAssetbankuser.getLastmodifiedbyid();
                assetbankuserCollectionAssetbankuser.setLastmodifiedbyid(assetbankuser);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
                if (oldLastmodifiedbyidOfAssetbankuserCollectionAssetbankuser != null) {
                    oldLastmodifiedbyidOfAssetbankuserCollectionAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionAssetbankuser);
                    oldLastmodifiedbyidOfAssetbankuserCollectionAssetbankuser = em.merge(oldLastmodifiedbyidOfAssetbankuserCollectionAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollection1Assetbankuser : assetbankuser.getAssetbankuserCollection1()) {
                Assetbankuser oldInvitedbyuseridOfAssetbankuserCollection1Assetbankuser = assetbankuserCollection1Assetbankuser.getInvitedbyuserid();
                assetbankuserCollection1Assetbankuser.setInvitedbyuserid(assetbankuser);
                assetbankuserCollection1Assetbankuser = em.merge(assetbankuserCollection1Assetbankuser);
                if (oldInvitedbyuseridOfAssetbankuserCollection1Assetbankuser != null) {
                    oldInvitedbyuseridOfAssetbankuserCollection1Assetbankuser.getAssetbankuserCollection1().remove(assetbankuserCollection1Assetbankuser);
                    oldInvitedbyuseridOfAssetbankuserCollection1Assetbankuser = em.merge(oldInvitedbyuseridOfAssetbankuserCollection1Assetbankuser);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAssetbankuser(assetbankuser.getId()) != null) {
                throw new PreexistingEntityException("Assetbankuser " + assetbankuser + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Assetbankuser assetbankuser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assetbankuser persistentAssetbankuser = em.find(Assetbankuser.class, assetbankuser.getId());
            Address addressidOld = persistentAssetbankuser.getAddressid();
            Address addressidNew = assetbankuser.getAddressid();
            Assetbankuser lastmodifiedbyidOld = persistentAssetbankuser.getLastmodifiedbyid();
            Assetbankuser lastmodifiedbyidNew = assetbankuser.getLastmodifiedbyid();
            Assetbankuser invitedbyuseridOld = persistentAssetbankuser.getInvitedbyuserid();
            Assetbankuser invitedbyuseridNew = assetbankuser.getInvitedbyuserid();
            Division divisionidOld = persistentAssetbankuser.getDivisionid();
            Division divisionidNew = assetbankuser.getDivisionid();
            Language languageidOld = persistentAssetbankuser.getLanguageid();
            Language languageidNew = assetbankuser.getLanguageid();
            Orgunit requestedorgunitidOld = persistentAssetbankuser.getRequestedorgunitid();
            Orgunit requestedorgunitidNew = assetbankuser.getRequestedorgunitid();
            Collection<Usergroup> usergroupCollectionOld = persistentAssetbankuser.getUsergroupCollection();
            Collection<Usergroup> usergroupCollectionNew = assetbankuser.getUsergroupCollection();
            Collection<Language> languageCollectionOld = persistentAssetbankuser.getLanguageCollection();
            Collection<Language> languageCollectionNew = assetbankuser.getLanguageCollection();
            Collection<Asset> assetCollectionOld = persistentAssetbankuser.getAssetCollection();
            Collection<Asset> assetCollectionNew = assetbankuser.getAssetCollection();
            Collection<Asset> assetCollection1Old = persistentAssetbankuser.getAssetCollection1();
            Collection<Asset> assetCollection1New = assetbankuser.getAssetCollection1();
            Collection<Asset> assetCollection2Old = persistentAssetbankuser.getAssetCollection2();
            Collection<Asset> assetCollection2New = assetbankuser.getAssetCollection2();
            Collection<Asset> assetCollection3Old = persistentAssetbankuser.getAssetCollection3();
            Collection<Asset> assetCollection3New = assetbankuser.getAssetCollection3();
            Collection<Assetbankuser> assetbankuserCollectionOld = persistentAssetbankuser.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollectionNew = assetbankuser.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollection1Old = persistentAssetbankuser.getAssetbankuserCollection1();
            Collection<Assetbankuser> assetbankuserCollection1New = assetbankuser.getAssetbankuserCollection1();
            if (addressidNew != null) {
                addressidNew = em.getReference(addressidNew.getClass(), addressidNew.getId());
                assetbankuser.setAddressid(addressidNew);
            }
            if (lastmodifiedbyidNew != null) {
                lastmodifiedbyidNew = em.getReference(lastmodifiedbyidNew.getClass(), lastmodifiedbyidNew.getId());
                assetbankuser.setLastmodifiedbyid(lastmodifiedbyidNew);
            }
            if (invitedbyuseridNew != null) {
                invitedbyuseridNew = em.getReference(invitedbyuseridNew.getClass(), invitedbyuseridNew.getId());
                assetbankuser.setInvitedbyuserid(invitedbyuseridNew);
            }
            if (divisionidNew != null) {
                divisionidNew = em.getReference(divisionidNew.getClass(), divisionidNew.getId());
                assetbankuser.setDivisionid(divisionidNew);
            }
            if (languageidNew != null) {
                languageidNew = em.getReference(languageidNew.getClass(), languageidNew.getId());
                assetbankuser.setLanguageid(languageidNew);
            }
            if (requestedorgunitidNew != null) {
                requestedorgunitidNew = em.getReference(requestedorgunitidNew.getClass(), requestedorgunitidNew.getId());
                assetbankuser.setRequestedorgunitid(requestedorgunitidNew);
            }
            Collection<Usergroup> attachedUsergroupCollectionNew = new ArrayList<Usergroup>();
            for (Usergroup usergroupCollectionNewUsergroupToAttach : usergroupCollectionNew) {
                usergroupCollectionNewUsergroupToAttach = em.getReference(usergroupCollectionNewUsergroupToAttach.getClass(), usergroupCollectionNewUsergroupToAttach.getId());
                attachedUsergroupCollectionNew.add(usergroupCollectionNewUsergroupToAttach);
            }
            usergroupCollectionNew = attachedUsergroupCollectionNew;
            assetbankuser.setUsergroupCollection(usergroupCollectionNew);
            Collection<Language> attachedLanguageCollectionNew = new ArrayList<Language>();
            for (Language languageCollectionNewLanguageToAttach : languageCollectionNew) {
                languageCollectionNewLanguageToAttach = em.getReference(languageCollectionNewLanguageToAttach.getClass(), languageCollectionNewLanguageToAttach.getId());
                attachedLanguageCollectionNew.add(languageCollectionNewLanguageToAttach);
            }
            languageCollectionNew = attachedLanguageCollectionNew;
            assetbankuser.setLanguageCollection(languageCollectionNew);
            Collection<Asset> attachedAssetCollectionNew = new ArrayList<Asset>();
            for (Asset assetCollectionNewAssetToAttach : assetCollectionNew) {
                assetCollectionNewAssetToAttach = em.getReference(assetCollectionNewAssetToAttach.getClass(), assetCollectionNewAssetToAttach.getId());
                attachedAssetCollectionNew.add(assetCollectionNewAssetToAttach);
            }
            assetCollectionNew = attachedAssetCollectionNew;
            assetbankuser.setAssetCollection(assetCollectionNew);
            Collection<Asset> attachedAssetCollection1New = new ArrayList<Asset>();
            for (Asset assetCollection1NewAssetToAttach : assetCollection1New) {
                assetCollection1NewAssetToAttach = em.getReference(assetCollection1NewAssetToAttach.getClass(), assetCollection1NewAssetToAttach.getId());
                attachedAssetCollection1New.add(assetCollection1NewAssetToAttach);
            }
            assetCollection1New = attachedAssetCollection1New;
            assetbankuser.setAssetCollection1(assetCollection1New);
            Collection<Asset> attachedAssetCollection2New = new ArrayList<Asset>();
            for (Asset assetCollection2NewAssetToAttach : assetCollection2New) {
                assetCollection2NewAssetToAttach = em.getReference(assetCollection2NewAssetToAttach.getClass(), assetCollection2NewAssetToAttach.getId());
                attachedAssetCollection2New.add(assetCollection2NewAssetToAttach);
            }
            assetCollection2New = attachedAssetCollection2New;
            assetbankuser.setAssetCollection2(assetCollection2New);
            Collection<Asset> attachedAssetCollection3New = new ArrayList<Asset>();
            for (Asset assetCollection3NewAssetToAttach : assetCollection3New) {
                assetCollection3NewAssetToAttach = em.getReference(assetCollection3NewAssetToAttach.getClass(), assetCollection3NewAssetToAttach.getId());
                attachedAssetCollection3New.add(assetCollection3NewAssetToAttach);
            }
            assetCollection3New = attachedAssetCollection3New;
            assetbankuser.setAssetCollection3(assetCollection3New);
            Collection<Assetbankuser> attachedAssetbankuserCollectionNew = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionNewAssetbankuserToAttach : assetbankuserCollectionNew) {
                assetbankuserCollectionNewAssetbankuserToAttach = em.getReference(assetbankuserCollectionNewAssetbankuserToAttach.getClass(), assetbankuserCollectionNewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollectionNew.add(assetbankuserCollectionNewAssetbankuserToAttach);
            }
            assetbankuserCollectionNew = attachedAssetbankuserCollectionNew;
            assetbankuser.setAssetbankuserCollection(assetbankuserCollectionNew);
            Collection<Assetbankuser> attachedAssetbankuserCollection1New = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollection1NewAssetbankuserToAttach : assetbankuserCollection1New) {
                assetbankuserCollection1NewAssetbankuserToAttach = em.getReference(assetbankuserCollection1NewAssetbankuserToAttach.getClass(), assetbankuserCollection1NewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection1New.add(assetbankuserCollection1NewAssetbankuserToAttach);
            }
            assetbankuserCollection1New = attachedAssetbankuserCollection1New;
            assetbankuser.setAssetbankuserCollection1(assetbankuserCollection1New);
            assetbankuser = em.merge(assetbankuser);
            if (addressidOld != null && !addressidOld.equals(addressidNew)) {
                addressidOld.getAssetbankuserCollection().remove(assetbankuser);
                addressidOld = em.merge(addressidOld);
            }
            if (addressidNew != null && !addressidNew.equals(addressidOld)) {
                addressidNew.getAssetbankuserCollection().add(assetbankuser);
                addressidNew = em.merge(addressidNew);
            }
            if (lastmodifiedbyidOld != null && !lastmodifiedbyidOld.equals(lastmodifiedbyidNew)) {
                lastmodifiedbyidOld.getAssetbankuserCollection().remove(assetbankuser);
                lastmodifiedbyidOld = em.merge(lastmodifiedbyidOld);
            }
            if (lastmodifiedbyidNew != null && !lastmodifiedbyidNew.equals(lastmodifiedbyidOld)) {
                lastmodifiedbyidNew.getAssetbankuserCollection().add(assetbankuser);
                lastmodifiedbyidNew = em.merge(lastmodifiedbyidNew);
            }
            if (invitedbyuseridOld != null && !invitedbyuseridOld.equals(invitedbyuseridNew)) {
                invitedbyuseridOld.getAssetbankuserCollection().remove(assetbankuser);
                invitedbyuseridOld = em.merge(invitedbyuseridOld);
            }
            if (invitedbyuseridNew != null && !invitedbyuseridNew.equals(invitedbyuseridOld)) {
                invitedbyuseridNew.getAssetbankuserCollection().add(assetbankuser);
                invitedbyuseridNew = em.merge(invitedbyuseridNew);
            }
            if (divisionidOld != null && !divisionidOld.equals(divisionidNew)) {
                divisionidOld.getAssetbankuserCollection().remove(assetbankuser);
                divisionidOld = em.merge(divisionidOld);
            }
            if (divisionidNew != null && !divisionidNew.equals(divisionidOld)) {
                divisionidNew.getAssetbankuserCollection().add(assetbankuser);
                divisionidNew = em.merge(divisionidNew);
            }
            if (languageidOld != null && !languageidOld.equals(languageidNew)) {
                languageidOld.getAssetbankuserCollection().remove(assetbankuser);
                languageidOld = em.merge(languageidOld);
            }
            if (languageidNew != null && !languageidNew.equals(languageidOld)) {
                languageidNew.getAssetbankuserCollection().add(assetbankuser);
                languageidNew = em.merge(languageidNew);
            }
            if (requestedorgunitidOld != null && !requestedorgunitidOld.equals(requestedorgunitidNew)) {
                requestedorgunitidOld.getAssetbankuserCollection().remove(assetbankuser);
                requestedorgunitidOld = em.merge(requestedorgunitidOld);
            }
            if (requestedorgunitidNew != null && !requestedorgunitidNew.equals(requestedorgunitidOld)) {
                requestedorgunitidNew.getAssetbankuserCollection().add(assetbankuser);
                requestedorgunitidNew = em.merge(requestedorgunitidNew);
            }
            for (Usergroup usergroupCollectionOldUsergroup : usergroupCollectionOld) {
                if (!usergroupCollectionNew.contains(usergroupCollectionOldUsergroup)) {
                    usergroupCollectionOldUsergroup.getAssetbankuserCollection().remove(assetbankuser);
                    usergroupCollectionOldUsergroup = em.merge(usergroupCollectionOldUsergroup);
                }
            }
            for (Usergroup usergroupCollectionNewUsergroup : usergroupCollectionNew) {
                if (!usergroupCollectionOld.contains(usergroupCollectionNewUsergroup)) {
                    usergroupCollectionNewUsergroup.getAssetbankuserCollection().add(assetbankuser);
                    usergroupCollectionNewUsergroup = em.merge(usergroupCollectionNewUsergroup);
                }
            }
            for (Language languageCollectionOldLanguage : languageCollectionOld) {
                if (!languageCollectionNew.contains(languageCollectionOldLanguage)) {
                    languageCollectionOldLanguage.getAssetbankuserCollection().remove(assetbankuser);
                    languageCollectionOldLanguage = em.merge(languageCollectionOldLanguage);
                }
            }
            for (Language languageCollectionNewLanguage : languageCollectionNew) {
                if (!languageCollectionOld.contains(languageCollectionNewLanguage)) {
                    languageCollectionNewLanguage.getAssetbankuserCollection().add(assetbankuser);
                    languageCollectionNewLanguage = em.merge(languageCollectionNewLanguage);
                }
            }
            for (Asset assetCollectionOldAsset : assetCollectionOld) {
                if (!assetCollectionNew.contains(assetCollectionOldAsset)) {
                    assetCollectionOldAsset.setSubmittedbyuserid(null);
                    assetCollectionOldAsset = em.merge(assetCollectionOldAsset);
                }
            }
            for (Asset assetCollectionNewAsset : assetCollectionNew) {
                if (!assetCollectionOld.contains(assetCollectionNewAsset)) {
                    Assetbankuser oldSubmittedbyuseridOfAssetCollectionNewAsset = assetCollectionNewAsset.getSubmittedbyuserid();
                    assetCollectionNewAsset.setSubmittedbyuserid(assetbankuser);
                    assetCollectionNewAsset = em.merge(assetCollectionNewAsset);
                    if (oldSubmittedbyuseridOfAssetCollectionNewAsset != null && !oldSubmittedbyuseridOfAssetCollectionNewAsset.equals(assetbankuser)) {
                        oldSubmittedbyuseridOfAssetCollectionNewAsset.getAssetCollection().remove(assetCollectionNewAsset);
                        oldSubmittedbyuseridOfAssetCollectionNewAsset = em.merge(oldSubmittedbyuseridOfAssetCollectionNewAsset);
                    }
                }
            }
            for (Asset assetCollection1OldAsset : assetCollection1Old) {
                if (!assetCollection1New.contains(assetCollection1OldAsset)) {
                    assetCollection1OldAsset.setAddedbyuserid(null);
                    assetCollection1OldAsset = em.merge(assetCollection1OldAsset);
                }
            }
            for (Asset assetCollection1NewAsset : assetCollection1New) {
                if (!assetCollection1Old.contains(assetCollection1NewAsset)) {
                    Assetbankuser oldAddedbyuseridOfAssetCollection1NewAsset = assetCollection1NewAsset.getAddedbyuserid();
                    assetCollection1NewAsset.setAddedbyuserid(assetbankuser);
                    assetCollection1NewAsset = em.merge(assetCollection1NewAsset);
                    if (oldAddedbyuseridOfAssetCollection1NewAsset != null && !oldAddedbyuseridOfAssetCollection1NewAsset.equals(assetbankuser)) {
                        oldAddedbyuseridOfAssetCollection1NewAsset.getAssetCollection1().remove(assetCollection1NewAsset);
                        oldAddedbyuseridOfAssetCollection1NewAsset = em.merge(oldAddedbyuseridOfAssetCollection1NewAsset);
                    }
                }
            }
            for (Asset assetCollection2OldAsset : assetCollection2Old) {
                if (!assetCollection2New.contains(assetCollection2OldAsset)) {
                    assetCollection2OldAsset.setLastmodifiedbyuserid(null);
                    assetCollection2OldAsset = em.merge(assetCollection2OldAsset);
                }
            }
            for (Asset assetCollection2NewAsset : assetCollection2New) {
                if (!assetCollection2Old.contains(assetCollection2NewAsset)) {
                    Assetbankuser oldLastmodifiedbyuseridOfAssetCollection2NewAsset = assetCollection2NewAsset.getLastmodifiedbyuserid();
                    assetCollection2NewAsset.setLastmodifiedbyuserid(assetbankuser);
                    assetCollection2NewAsset = em.merge(assetCollection2NewAsset);
                    if (oldLastmodifiedbyuseridOfAssetCollection2NewAsset != null && !oldLastmodifiedbyuseridOfAssetCollection2NewAsset.equals(assetbankuser)) {
                        oldLastmodifiedbyuseridOfAssetCollection2NewAsset.getAssetCollection2().remove(assetCollection2NewAsset);
                        oldLastmodifiedbyuseridOfAssetCollection2NewAsset = em.merge(oldLastmodifiedbyuseridOfAssetCollection2NewAsset);
                    }
                }
            }
            for (Asset assetCollection3OldAsset : assetCollection3Old) {
                if (!assetCollection3New.contains(assetCollection3OldAsset)) {
                    assetCollection3OldAsset.setFilecheckedoutbyuserid(null);
                    assetCollection3OldAsset = em.merge(assetCollection3OldAsset);
                }
            }
            for (Asset assetCollection3NewAsset : assetCollection3New) {
                if (!assetCollection3Old.contains(assetCollection3NewAsset)) {
                    Assetbankuser oldFilecheckedoutbyuseridOfAssetCollection3NewAsset = assetCollection3NewAsset.getFilecheckedoutbyuserid();
                    assetCollection3NewAsset.setFilecheckedoutbyuserid(assetbankuser);
                    assetCollection3NewAsset = em.merge(assetCollection3NewAsset);
                    if (oldFilecheckedoutbyuseridOfAssetCollection3NewAsset != null && !oldFilecheckedoutbyuseridOfAssetCollection3NewAsset.equals(assetbankuser)) {
                        oldFilecheckedoutbyuseridOfAssetCollection3NewAsset.getAssetCollection3().remove(assetCollection3NewAsset);
                        oldFilecheckedoutbyuseridOfAssetCollection3NewAsset = em.merge(oldFilecheckedoutbyuseridOfAssetCollection3NewAsset);
                    }
                }
            }
            for (Assetbankuser assetbankuserCollectionOldAssetbankuser : assetbankuserCollectionOld) {
                if (!assetbankuserCollectionNew.contains(assetbankuserCollectionOldAssetbankuser)) {
                    assetbankuserCollectionOldAssetbankuser.setLastmodifiedbyid(null);
                    assetbankuserCollectionOldAssetbankuser = em.merge(assetbankuserCollectionOldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollectionNewAssetbankuser : assetbankuserCollectionNew) {
                if (!assetbankuserCollectionOld.contains(assetbankuserCollectionNewAssetbankuser)) {
                    Assetbankuser oldLastmodifiedbyidOfAssetbankuserCollectionNewAssetbankuser = assetbankuserCollectionNewAssetbankuser.getLastmodifiedbyid();
                    assetbankuserCollectionNewAssetbankuser.setLastmodifiedbyid(assetbankuser);
                    assetbankuserCollectionNewAssetbankuser = em.merge(assetbankuserCollectionNewAssetbankuser);
                    if (oldLastmodifiedbyidOfAssetbankuserCollectionNewAssetbankuser != null && !oldLastmodifiedbyidOfAssetbankuserCollectionNewAssetbankuser.equals(assetbankuser)) {
                        oldLastmodifiedbyidOfAssetbankuserCollectionNewAssetbankuser.getAssetbankuserCollection().remove(assetbankuserCollectionNewAssetbankuser);
                        oldLastmodifiedbyidOfAssetbankuserCollectionNewAssetbankuser = em.merge(oldLastmodifiedbyidOfAssetbankuserCollectionNewAssetbankuser);
                    }
                }
            }
            for (Assetbankuser assetbankuserCollection1OldAssetbankuser : assetbankuserCollection1Old) {
                if (!assetbankuserCollection1New.contains(assetbankuserCollection1OldAssetbankuser)) {
                    assetbankuserCollection1OldAssetbankuser.setInvitedbyuserid(null);
                    assetbankuserCollection1OldAssetbankuser = em.merge(assetbankuserCollection1OldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollection1NewAssetbankuser : assetbankuserCollection1New) {
                if (!assetbankuserCollection1Old.contains(assetbankuserCollection1NewAssetbankuser)) {
                    Assetbankuser oldInvitedbyuseridOfAssetbankuserCollection1NewAssetbankuser = assetbankuserCollection1NewAssetbankuser.getInvitedbyuserid();
                    assetbankuserCollection1NewAssetbankuser.setInvitedbyuserid(assetbankuser);
                    assetbankuserCollection1NewAssetbankuser = em.merge(assetbankuserCollection1NewAssetbankuser);
                    if (oldInvitedbyuseridOfAssetbankuserCollection1NewAssetbankuser != null && !oldInvitedbyuseridOfAssetbankuserCollection1NewAssetbankuser.equals(assetbankuser)) {
                        oldInvitedbyuseridOfAssetbankuserCollection1NewAssetbankuser.getAssetbankuserCollection1().remove(assetbankuserCollection1NewAssetbankuser);
                        oldInvitedbyuseridOfAssetbankuserCollection1NewAssetbankuser = em.merge(oldInvitedbyuseridOfAssetbankuserCollection1NewAssetbankuser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = assetbankuser.getId();
                if (findAssetbankuser(id) == null) {
                    throw new NonexistentEntityException("The assetbankuser with id " + id + " no longer exists.");
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
            Assetbankuser assetbankuser;
            try {
                assetbankuser = em.getReference(Assetbankuser.class, id);
                assetbankuser.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assetbankuser with id " + id + " no longer exists.", enfe);
            }
            Address addressid = assetbankuser.getAddressid();
            if (addressid != null) {
                addressid.getAssetbankuserCollection().remove(assetbankuser);
                addressid = em.merge(addressid);
            }
            Assetbankuser lastmodifiedbyid = assetbankuser.getLastmodifiedbyid();
            if (lastmodifiedbyid != null) {
                lastmodifiedbyid.getAssetbankuserCollection().remove(assetbankuser);
                lastmodifiedbyid = em.merge(lastmodifiedbyid);
            }
            Assetbankuser invitedbyuserid = assetbankuser.getInvitedbyuserid();
            if (invitedbyuserid != null) {
                invitedbyuserid.getAssetbankuserCollection().remove(assetbankuser);
                invitedbyuserid = em.merge(invitedbyuserid);
            }
            Division divisionid = assetbankuser.getDivisionid();
            if (divisionid != null) {
                divisionid.getAssetbankuserCollection().remove(assetbankuser);
                divisionid = em.merge(divisionid);
            }
            Language languageid = assetbankuser.getLanguageid();
            if (languageid != null) {
                languageid.getAssetbankuserCollection().remove(assetbankuser);
                languageid = em.merge(languageid);
            }
            Orgunit requestedorgunitid = assetbankuser.getRequestedorgunitid();
            if (requestedorgunitid != null) {
                requestedorgunitid.getAssetbankuserCollection().remove(assetbankuser);
                requestedorgunitid = em.merge(requestedorgunitid);
            }
            Collection<Usergroup> usergroupCollection = assetbankuser.getUsergroupCollection();
            for (Usergroup usergroupCollectionUsergroup : usergroupCollection) {
                usergroupCollectionUsergroup.getAssetbankuserCollection().remove(assetbankuser);
                usergroupCollectionUsergroup = em.merge(usergroupCollectionUsergroup);
            }
            Collection<Language> languageCollection = assetbankuser.getLanguageCollection();
            for (Language languageCollectionLanguage : languageCollection) {
                languageCollectionLanguage.getAssetbankuserCollection().remove(assetbankuser);
                languageCollectionLanguage = em.merge(languageCollectionLanguage);
            }
            Collection<Asset> assetCollection = assetbankuser.getAssetCollection();
            for (Asset assetCollectionAsset : assetCollection) {
                assetCollectionAsset.setSubmittedbyuserid(null);
                assetCollectionAsset = em.merge(assetCollectionAsset);
            }
            Collection<Asset> assetCollection1 = assetbankuser.getAssetCollection1();
            for (Asset assetCollection1Asset : assetCollection1) {
                assetCollection1Asset.setAddedbyuserid(null);
                assetCollection1Asset = em.merge(assetCollection1Asset);
            }
            Collection<Asset> assetCollection2 = assetbankuser.getAssetCollection2();
            for (Asset assetCollection2Asset : assetCollection2) {
                assetCollection2Asset.setLastmodifiedbyuserid(null);
                assetCollection2Asset = em.merge(assetCollection2Asset);
            }
            Collection<Asset> assetCollection3 = assetbankuser.getAssetCollection3();
            for (Asset assetCollection3Asset : assetCollection3) {
                assetCollection3Asset.setFilecheckedoutbyuserid(null);
                assetCollection3Asset = em.merge(assetCollection3Asset);
            }
            Collection<Assetbankuser> assetbankuserCollection = assetbankuser.getAssetbankuserCollection();
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuserCollection) {
                assetbankuserCollectionAssetbankuser.setLastmodifiedbyid(null);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            Collection<Assetbankuser> assetbankuserCollection1 = assetbankuser.getAssetbankuserCollection1();
            for (Assetbankuser assetbankuserCollection1Assetbankuser : assetbankuserCollection1) {
                assetbankuserCollection1Assetbankuser.setInvitedbyuserid(null);
                assetbankuserCollection1Assetbankuser = em.merge(assetbankuserCollection1Assetbankuser);
            }
            em.remove(assetbankuser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assetbankuser> findAssetbankuserEntities() {
        return findAssetbankuserEntities(true, -1, -1);
    }

    public List<Assetbankuser> findAssetbankuserEntities(int maxResults, int firstResult) {
        return findAssetbankuserEntities(false, maxResults, firstResult);
    }

    private List<Assetbankuser> findAssetbankuserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assetbankuser.class));
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

    public Assetbankuser findAssetbankuser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assetbankuser.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssetbankuserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assetbankuser> rt = cq.from(Assetbankuser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
