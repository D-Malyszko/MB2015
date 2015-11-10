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
public class LanguageJpaController implements Serializable {

    public LanguageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Language language) throws PreexistingEntityException, Exception {
        if (language.getAssetbankuserCollection() == null) {
            language.setAssetbankuserCollection(new ArrayList<Assetbankuser>());
        }
        if (language.getAssetbankuserCollection1() == null) {
            language.setAssetbankuserCollection1(new ArrayList<Assetbankuser>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Assetbankuser> attachedAssetbankuserCollection = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionAssetbankuserToAttach : language.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuserToAttach = em.getReference(assetbankuserCollectionAssetbankuserToAttach.getClass(), assetbankuserCollectionAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection.add(assetbankuserCollectionAssetbankuserToAttach);
            }
            language.setAssetbankuserCollection(attachedAssetbankuserCollection);
            Collection<Assetbankuser> attachedAssetbankuserCollection1 = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollection1AssetbankuserToAttach : language.getAssetbankuserCollection1()) {
                assetbankuserCollection1AssetbankuserToAttach = em.getReference(assetbankuserCollection1AssetbankuserToAttach.getClass(), assetbankuserCollection1AssetbankuserToAttach.getId());
                attachedAssetbankuserCollection1.add(assetbankuserCollection1AssetbankuserToAttach);
            }
            language.setAssetbankuserCollection1(attachedAssetbankuserCollection1);
            em.persist(language);
            for (Assetbankuser assetbankuserCollectionAssetbankuser : language.getAssetbankuserCollection()) {
                assetbankuserCollectionAssetbankuser.getLanguageCollection().add(language);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            for (Assetbankuser assetbankuserCollection1Assetbankuser : language.getAssetbankuserCollection1()) {
                Language oldLanguageidOfAssetbankuserCollection1Assetbankuser = assetbankuserCollection1Assetbankuser.getLanguageid();
                assetbankuserCollection1Assetbankuser.setLanguageid(language);
                assetbankuserCollection1Assetbankuser = em.merge(assetbankuserCollection1Assetbankuser);
                if (oldLanguageidOfAssetbankuserCollection1Assetbankuser != null) {
                    oldLanguageidOfAssetbankuserCollection1Assetbankuser.getAssetbankuserCollection1().remove(assetbankuserCollection1Assetbankuser);
                    oldLanguageidOfAssetbankuserCollection1Assetbankuser = em.merge(oldLanguageidOfAssetbankuserCollection1Assetbankuser);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLanguage(language.getId()) != null) {
                throw new PreexistingEntityException("Language " + language + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Language language) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Language persistentLanguage = em.find(Language.class, language.getId());
            Collection<Assetbankuser> assetbankuserCollectionOld = persistentLanguage.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollectionNew = language.getAssetbankuserCollection();
            Collection<Assetbankuser> assetbankuserCollection1Old = persistentLanguage.getAssetbankuserCollection1();
            Collection<Assetbankuser> assetbankuserCollection1New = language.getAssetbankuserCollection1();
            Collection<Assetbankuser> attachedAssetbankuserCollectionNew = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollectionNewAssetbankuserToAttach : assetbankuserCollectionNew) {
                assetbankuserCollectionNewAssetbankuserToAttach = em.getReference(assetbankuserCollectionNewAssetbankuserToAttach.getClass(), assetbankuserCollectionNewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollectionNew.add(assetbankuserCollectionNewAssetbankuserToAttach);
            }
            assetbankuserCollectionNew = attachedAssetbankuserCollectionNew;
            language.setAssetbankuserCollection(assetbankuserCollectionNew);
            Collection<Assetbankuser> attachedAssetbankuserCollection1New = new ArrayList<Assetbankuser>();
            for (Assetbankuser assetbankuserCollection1NewAssetbankuserToAttach : assetbankuserCollection1New) {
                assetbankuserCollection1NewAssetbankuserToAttach = em.getReference(assetbankuserCollection1NewAssetbankuserToAttach.getClass(), assetbankuserCollection1NewAssetbankuserToAttach.getId());
                attachedAssetbankuserCollection1New.add(assetbankuserCollection1NewAssetbankuserToAttach);
            }
            assetbankuserCollection1New = attachedAssetbankuserCollection1New;
            language.setAssetbankuserCollection1(assetbankuserCollection1New);
            language = em.merge(language);
            for (Assetbankuser assetbankuserCollectionOldAssetbankuser : assetbankuserCollectionOld) {
                if (!assetbankuserCollectionNew.contains(assetbankuserCollectionOldAssetbankuser)) {
                    assetbankuserCollectionOldAssetbankuser.getLanguageCollection().remove(language);
                    assetbankuserCollectionOldAssetbankuser = em.merge(assetbankuserCollectionOldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollectionNewAssetbankuser : assetbankuserCollectionNew) {
                if (!assetbankuserCollectionOld.contains(assetbankuserCollectionNewAssetbankuser)) {
                    assetbankuserCollectionNewAssetbankuser.getLanguageCollection().add(language);
                    assetbankuserCollectionNewAssetbankuser = em.merge(assetbankuserCollectionNewAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollection1OldAssetbankuser : assetbankuserCollection1Old) {
                if (!assetbankuserCollection1New.contains(assetbankuserCollection1OldAssetbankuser)) {
                    assetbankuserCollection1OldAssetbankuser.setLanguageid(null);
                    assetbankuserCollection1OldAssetbankuser = em.merge(assetbankuserCollection1OldAssetbankuser);
                }
            }
            for (Assetbankuser assetbankuserCollection1NewAssetbankuser : assetbankuserCollection1New) {
                if (!assetbankuserCollection1Old.contains(assetbankuserCollection1NewAssetbankuser)) {
                    Language oldLanguageidOfAssetbankuserCollection1NewAssetbankuser = assetbankuserCollection1NewAssetbankuser.getLanguageid();
                    assetbankuserCollection1NewAssetbankuser.setLanguageid(language);
                    assetbankuserCollection1NewAssetbankuser = em.merge(assetbankuserCollection1NewAssetbankuser);
                    if (oldLanguageidOfAssetbankuserCollection1NewAssetbankuser != null && !oldLanguageidOfAssetbankuserCollection1NewAssetbankuser.equals(language)) {
                        oldLanguageidOfAssetbankuserCollection1NewAssetbankuser.getAssetbankuserCollection1().remove(assetbankuserCollection1NewAssetbankuser);
                        oldLanguageidOfAssetbankuserCollection1NewAssetbankuser = em.merge(oldLanguageidOfAssetbankuserCollection1NewAssetbankuser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = language.getId();
                if (findLanguage(id) == null) {
                    throw new NonexistentEntityException("The language with id " + id + " no longer exists.");
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
            Language language;
            try {
                language = em.getReference(Language.class, id);
                language.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The language with id " + id + " no longer exists.", enfe);
            }
            Collection<Assetbankuser> assetbankuserCollection = language.getAssetbankuserCollection();
            for (Assetbankuser assetbankuserCollectionAssetbankuser : assetbankuserCollection) {
                assetbankuserCollectionAssetbankuser.getLanguageCollection().remove(language);
                assetbankuserCollectionAssetbankuser = em.merge(assetbankuserCollectionAssetbankuser);
            }
            Collection<Assetbankuser> assetbankuserCollection1 = language.getAssetbankuserCollection1();
            for (Assetbankuser assetbankuserCollection1Assetbankuser : assetbankuserCollection1) {
                assetbankuserCollection1Assetbankuser.setLanguageid(null);
                assetbankuserCollection1Assetbankuser = em.merge(assetbankuserCollection1Assetbankuser);
            }
            em.remove(language);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Language> findLanguageEntities() {
        return findLanguageEntities(true, -1, -1);
    }

    public List<Language> findLanguageEntities(int maxResults, int firstResult) {
        return findLanguageEntities(false, maxResults, firstResult);
    }

    private List<Language> findLanguageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Language.class));
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

    public Language findLanguage(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Language.class, id);
        } finally {
            em.close();
        }
    }

    public int getLanguageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Language> rt = cq.from(Language.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
