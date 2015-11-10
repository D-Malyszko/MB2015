/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.IllegalOrphanException;
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
public class DimdateJpaController implements Serializable {

    public DimdateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimdate dimdate) throws PreexistingEntityException, Exception {
        if (dimdate.getFactinternetsalesCollection() == null) {
            dimdate.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        if (dimdate.getFactinternetsalesCollection1() == null) {
            dimdate.setFactinternetsalesCollection1(new ArrayList<Factinternetsales>());
        }
        if (dimdate.getFactinternetsalesCollection2() == null) {
            dimdate.setFactinternetsalesCollection2(new ArrayList<Factinternetsales>());
        }
        if (dimdate.getFactsurveyresponseCollection() == null) {
            dimdate.setFactsurveyresponseCollection(new ArrayList<Factsurveyresponse>());
        }
        if (dimdate.getFactsalesquotaCollection() == null) {
            dimdate.setFactsalesquotaCollection(new ArrayList<Factsalesquota>());
        }
        if (dimdate.getFactcallcenterCollection() == null) {
            dimdate.setFactcallcenterCollection(new ArrayList<Factcallcenter>());
        }
        if (dimdate.getFactproductinventoryCollection() == null) {
            dimdate.setFactproductinventoryCollection(new ArrayList<Factproductinventory>());
        }
        if (dimdate.getFactresellersalesCollection() == null) {
            dimdate.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        if (dimdate.getFactresellersalesCollection1() == null) {
            dimdate.setFactresellersalesCollection1(new ArrayList<Factresellersales>());
        }
        if (dimdate.getFactresellersalesCollection2() == null) {
            dimdate.setFactresellersalesCollection2(new ArrayList<Factresellersales>());
        }
        if (dimdate.getFactcurrencyrateCollection() == null) {
            dimdate.setFactcurrencyrateCollection(new ArrayList<Factcurrencyrate>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimdate.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimdate.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            Collection<Factinternetsales> attachedFactinternetsalesCollection1 = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollection1FactinternetsalesToAttach : dimdate.getFactinternetsalesCollection1()) {
                factinternetsalesCollection1FactinternetsalesToAttach = em.getReference(factinternetsalesCollection1FactinternetsalesToAttach.getClass(), factinternetsalesCollection1FactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection1.add(factinternetsalesCollection1FactinternetsalesToAttach);
            }
            dimdate.setFactinternetsalesCollection1(attachedFactinternetsalesCollection1);
            Collection<Factinternetsales> attachedFactinternetsalesCollection2 = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollection2FactinternetsalesToAttach : dimdate.getFactinternetsalesCollection2()) {
                factinternetsalesCollection2FactinternetsalesToAttach = em.getReference(factinternetsalesCollection2FactinternetsalesToAttach.getClass(), factinternetsalesCollection2FactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection2.add(factinternetsalesCollection2FactinternetsalesToAttach);
            }
            dimdate.setFactinternetsalesCollection2(attachedFactinternetsalesCollection2);
            Collection<Factsurveyresponse> attachedFactsurveyresponseCollection = new ArrayList<Factsurveyresponse>();
            for (Factsurveyresponse factsurveyresponseCollectionFactsurveyresponseToAttach : dimdate.getFactsurveyresponseCollection()) {
                factsurveyresponseCollectionFactsurveyresponseToAttach = em.getReference(factsurveyresponseCollectionFactsurveyresponseToAttach.getClass(), factsurveyresponseCollectionFactsurveyresponseToAttach.getSurveyresponsekey());
                attachedFactsurveyresponseCollection.add(factsurveyresponseCollectionFactsurveyresponseToAttach);
            }
            dimdate.setFactsurveyresponseCollection(attachedFactsurveyresponseCollection);
            Collection<Factsalesquota> attachedFactsalesquotaCollection = new ArrayList<Factsalesquota>();
            for (Factsalesquota factsalesquotaCollectionFactsalesquotaToAttach : dimdate.getFactsalesquotaCollection()) {
                factsalesquotaCollectionFactsalesquotaToAttach = em.getReference(factsalesquotaCollectionFactsalesquotaToAttach.getClass(), factsalesquotaCollectionFactsalesquotaToAttach.getSalesquotakey());
                attachedFactsalesquotaCollection.add(factsalesquotaCollectionFactsalesquotaToAttach);
            }
            dimdate.setFactsalesquotaCollection(attachedFactsalesquotaCollection);
            Collection<Factcallcenter> attachedFactcallcenterCollection = new ArrayList<Factcallcenter>();
            for (Factcallcenter factcallcenterCollectionFactcallcenterToAttach : dimdate.getFactcallcenterCollection()) {
                factcallcenterCollectionFactcallcenterToAttach = em.getReference(factcallcenterCollectionFactcallcenterToAttach.getClass(), factcallcenterCollectionFactcallcenterToAttach.getFactcallcenterid());
                attachedFactcallcenterCollection.add(factcallcenterCollectionFactcallcenterToAttach);
            }
            dimdate.setFactcallcenterCollection(attachedFactcallcenterCollection);
            Collection<Factproductinventory> attachedFactproductinventoryCollection = new ArrayList<Factproductinventory>();
            for (Factproductinventory factproductinventoryCollectionFactproductinventoryToAttach : dimdate.getFactproductinventoryCollection()) {
                factproductinventoryCollectionFactproductinventoryToAttach = em.getReference(factproductinventoryCollectionFactproductinventoryToAttach.getClass(), factproductinventoryCollectionFactproductinventoryToAttach.getFactproductinventoryPK());
                attachedFactproductinventoryCollection.add(factproductinventoryCollectionFactproductinventoryToAttach);
            }
            dimdate.setFactproductinventoryCollection(attachedFactproductinventoryCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimdate.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimdate.setFactresellersalesCollection(attachedFactresellersalesCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection1 = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollection1FactresellersalesToAttach : dimdate.getFactresellersalesCollection1()) {
                factresellersalesCollection1FactresellersalesToAttach = em.getReference(factresellersalesCollection1FactresellersalesToAttach.getClass(), factresellersalesCollection1FactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection1.add(factresellersalesCollection1FactresellersalesToAttach);
            }
            dimdate.setFactresellersalesCollection1(attachedFactresellersalesCollection1);
            Collection<Factresellersales> attachedFactresellersalesCollection2 = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollection2FactresellersalesToAttach : dimdate.getFactresellersalesCollection2()) {
                factresellersalesCollection2FactresellersalesToAttach = em.getReference(factresellersalesCollection2FactresellersalesToAttach.getClass(), factresellersalesCollection2FactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection2.add(factresellersalesCollection2FactresellersalesToAttach);
            }
            dimdate.setFactresellersalesCollection2(attachedFactresellersalesCollection2);
            Collection<Factcurrencyrate> attachedFactcurrencyrateCollection = new ArrayList<Factcurrencyrate>();
            for (Factcurrencyrate factcurrencyrateCollectionFactcurrencyrateToAttach : dimdate.getFactcurrencyrateCollection()) {
                factcurrencyrateCollectionFactcurrencyrateToAttach = em.getReference(factcurrencyrateCollectionFactcurrencyrateToAttach.getClass(), factcurrencyrateCollectionFactcurrencyrateToAttach.getFactcurrencyratePK());
                attachedFactcurrencyrateCollection.add(factcurrencyrateCollectionFactcurrencyrateToAttach);
            }
            dimdate.setFactcurrencyrateCollection(attachedFactcurrencyrateCollection);
            em.persist(dimdate);
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimdate.getFactinternetsalesCollection()) {
                Dimdate oldShipdatekeyOfFactinternetsalesCollectionFactinternetsales = factinternetsalesCollectionFactinternetsales.getShipdatekey();
                factinternetsalesCollectionFactinternetsales.setShipdatekey(dimdate);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
                if (oldShipdatekeyOfFactinternetsalesCollectionFactinternetsales != null) {
                    oldShipdatekeyOfFactinternetsalesCollectionFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionFactinternetsales);
                    oldShipdatekeyOfFactinternetsalesCollectionFactinternetsales = em.merge(oldShipdatekeyOfFactinternetsalesCollectionFactinternetsales);
                }
            }
            for (Factinternetsales factinternetsalesCollection1Factinternetsales : dimdate.getFactinternetsalesCollection1()) {
                Dimdate oldOrderdatekeyOfFactinternetsalesCollection1Factinternetsales = factinternetsalesCollection1Factinternetsales.getOrderdatekey();
                factinternetsalesCollection1Factinternetsales.setOrderdatekey(dimdate);
                factinternetsalesCollection1Factinternetsales = em.merge(factinternetsalesCollection1Factinternetsales);
                if (oldOrderdatekeyOfFactinternetsalesCollection1Factinternetsales != null) {
                    oldOrderdatekeyOfFactinternetsalesCollection1Factinternetsales.getFactinternetsalesCollection1().remove(factinternetsalesCollection1Factinternetsales);
                    oldOrderdatekeyOfFactinternetsalesCollection1Factinternetsales = em.merge(oldOrderdatekeyOfFactinternetsalesCollection1Factinternetsales);
                }
            }
            for (Factinternetsales factinternetsalesCollection2Factinternetsales : dimdate.getFactinternetsalesCollection2()) {
                Dimdate oldDuedatekeyOfFactinternetsalesCollection2Factinternetsales = factinternetsalesCollection2Factinternetsales.getDuedatekey();
                factinternetsalesCollection2Factinternetsales.setDuedatekey(dimdate);
                factinternetsalesCollection2Factinternetsales = em.merge(factinternetsalesCollection2Factinternetsales);
                if (oldDuedatekeyOfFactinternetsalesCollection2Factinternetsales != null) {
                    oldDuedatekeyOfFactinternetsalesCollection2Factinternetsales.getFactinternetsalesCollection2().remove(factinternetsalesCollection2Factinternetsales);
                    oldDuedatekeyOfFactinternetsalesCollection2Factinternetsales = em.merge(oldDuedatekeyOfFactinternetsalesCollection2Factinternetsales);
                }
            }
            for (Factsurveyresponse factsurveyresponseCollectionFactsurveyresponse : dimdate.getFactsurveyresponseCollection()) {
                Dimdate oldDatekeyOfFactsurveyresponseCollectionFactsurveyresponse = factsurveyresponseCollectionFactsurveyresponse.getDatekey();
                factsurveyresponseCollectionFactsurveyresponse.setDatekey(dimdate);
                factsurveyresponseCollectionFactsurveyresponse = em.merge(factsurveyresponseCollectionFactsurveyresponse);
                if (oldDatekeyOfFactsurveyresponseCollectionFactsurveyresponse != null) {
                    oldDatekeyOfFactsurveyresponseCollectionFactsurveyresponse.getFactsurveyresponseCollection().remove(factsurveyresponseCollectionFactsurveyresponse);
                    oldDatekeyOfFactsurveyresponseCollectionFactsurveyresponse = em.merge(oldDatekeyOfFactsurveyresponseCollectionFactsurveyresponse);
                }
            }
            for (Factsalesquota factsalesquotaCollectionFactsalesquota : dimdate.getFactsalesquotaCollection()) {
                Dimdate oldDatekeyOfFactsalesquotaCollectionFactsalesquota = factsalesquotaCollectionFactsalesquota.getDatekey();
                factsalesquotaCollectionFactsalesquota.setDatekey(dimdate);
                factsalesquotaCollectionFactsalesquota = em.merge(factsalesquotaCollectionFactsalesquota);
                if (oldDatekeyOfFactsalesquotaCollectionFactsalesquota != null) {
                    oldDatekeyOfFactsalesquotaCollectionFactsalesquota.getFactsalesquotaCollection().remove(factsalesquotaCollectionFactsalesquota);
                    oldDatekeyOfFactsalesquotaCollectionFactsalesquota = em.merge(oldDatekeyOfFactsalesquotaCollectionFactsalesquota);
                }
            }
            for (Factcallcenter factcallcenterCollectionFactcallcenter : dimdate.getFactcallcenterCollection()) {
                Dimdate oldDatekeyOfFactcallcenterCollectionFactcallcenter = factcallcenterCollectionFactcallcenter.getDatekey();
                factcallcenterCollectionFactcallcenter.setDatekey(dimdate);
                factcallcenterCollectionFactcallcenter = em.merge(factcallcenterCollectionFactcallcenter);
                if (oldDatekeyOfFactcallcenterCollectionFactcallcenter != null) {
                    oldDatekeyOfFactcallcenterCollectionFactcallcenter.getFactcallcenterCollection().remove(factcallcenterCollectionFactcallcenter);
                    oldDatekeyOfFactcallcenterCollectionFactcallcenter = em.merge(oldDatekeyOfFactcallcenterCollectionFactcallcenter);
                }
            }
            for (Factproductinventory factproductinventoryCollectionFactproductinventory : dimdate.getFactproductinventoryCollection()) {
                Dimdate oldDimdateOfFactproductinventoryCollectionFactproductinventory = factproductinventoryCollectionFactproductinventory.getDimdate();
                factproductinventoryCollectionFactproductinventory.setDimdate(dimdate);
                factproductinventoryCollectionFactproductinventory = em.merge(factproductinventoryCollectionFactproductinventory);
                if (oldDimdateOfFactproductinventoryCollectionFactproductinventory != null) {
                    oldDimdateOfFactproductinventoryCollectionFactproductinventory.getFactproductinventoryCollection().remove(factproductinventoryCollectionFactproductinventory);
                    oldDimdateOfFactproductinventoryCollectionFactproductinventory = em.merge(oldDimdateOfFactproductinventoryCollectionFactproductinventory);
                }
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimdate.getFactresellersalesCollection()) {
                Dimdate oldShipdatekeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getShipdatekey();
                factresellersalesCollectionFactresellersales.setShipdatekey(dimdate);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldShipdatekeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldShipdatekeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldShipdatekeyOfFactresellersalesCollectionFactresellersales = em.merge(oldShipdatekeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            for (Factresellersales factresellersalesCollection1Factresellersales : dimdate.getFactresellersalesCollection1()) {
                Dimdate oldDuedatekeyOfFactresellersalesCollection1Factresellersales = factresellersalesCollection1Factresellersales.getDuedatekey();
                factresellersalesCollection1Factresellersales.setDuedatekey(dimdate);
                factresellersalesCollection1Factresellersales = em.merge(factresellersalesCollection1Factresellersales);
                if (oldDuedatekeyOfFactresellersalesCollection1Factresellersales != null) {
                    oldDuedatekeyOfFactresellersalesCollection1Factresellersales.getFactresellersalesCollection1().remove(factresellersalesCollection1Factresellersales);
                    oldDuedatekeyOfFactresellersalesCollection1Factresellersales = em.merge(oldDuedatekeyOfFactresellersalesCollection1Factresellersales);
                }
            }
            for (Factresellersales factresellersalesCollection2Factresellersales : dimdate.getFactresellersalesCollection2()) {
                Dimdate oldOrderdatekeyOfFactresellersalesCollection2Factresellersales = factresellersalesCollection2Factresellersales.getOrderdatekey();
                factresellersalesCollection2Factresellersales.setOrderdatekey(dimdate);
                factresellersalesCollection2Factresellersales = em.merge(factresellersalesCollection2Factresellersales);
                if (oldOrderdatekeyOfFactresellersalesCollection2Factresellersales != null) {
                    oldOrderdatekeyOfFactresellersalesCollection2Factresellersales.getFactresellersalesCollection2().remove(factresellersalesCollection2Factresellersales);
                    oldOrderdatekeyOfFactresellersalesCollection2Factresellersales = em.merge(oldOrderdatekeyOfFactresellersalesCollection2Factresellersales);
                }
            }
            for (Factcurrencyrate factcurrencyrateCollectionFactcurrencyrate : dimdate.getFactcurrencyrateCollection()) {
                Dimdate oldDimdateOfFactcurrencyrateCollectionFactcurrencyrate = factcurrencyrateCollectionFactcurrencyrate.getDimdate();
                factcurrencyrateCollectionFactcurrencyrate.setDimdate(dimdate);
                factcurrencyrateCollectionFactcurrencyrate = em.merge(factcurrencyrateCollectionFactcurrencyrate);
                if (oldDimdateOfFactcurrencyrateCollectionFactcurrencyrate != null) {
                    oldDimdateOfFactcurrencyrateCollectionFactcurrencyrate.getFactcurrencyrateCollection().remove(factcurrencyrateCollectionFactcurrencyrate);
                    oldDimdateOfFactcurrencyrateCollectionFactcurrencyrate = em.merge(oldDimdateOfFactcurrencyrateCollectionFactcurrencyrate);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimdate(dimdate.getDatekey()) != null) {
                throw new PreexistingEntityException("Dimdate " + dimdate + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimdate dimdate) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdate persistentDimdate = em.find(Dimdate.class, dimdate.getDatekey());
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimdate.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimdate.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollection1Old = persistentDimdate.getFactinternetsalesCollection1();
            Collection<Factinternetsales> factinternetsalesCollection1New = dimdate.getFactinternetsalesCollection1();
            Collection<Factinternetsales> factinternetsalesCollection2Old = persistentDimdate.getFactinternetsalesCollection2();
            Collection<Factinternetsales> factinternetsalesCollection2New = dimdate.getFactinternetsalesCollection2();
            Collection<Factsurveyresponse> factsurveyresponseCollectionOld = persistentDimdate.getFactsurveyresponseCollection();
            Collection<Factsurveyresponse> factsurveyresponseCollectionNew = dimdate.getFactsurveyresponseCollection();
            Collection<Factsalesquota> factsalesquotaCollectionOld = persistentDimdate.getFactsalesquotaCollection();
            Collection<Factsalesquota> factsalesquotaCollectionNew = dimdate.getFactsalesquotaCollection();
            Collection<Factcallcenter> factcallcenterCollectionOld = persistentDimdate.getFactcallcenterCollection();
            Collection<Factcallcenter> factcallcenterCollectionNew = dimdate.getFactcallcenterCollection();
            Collection<Factproductinventory> factproductinventoryCollectionOld = persistentDimdate.getFactproductinventoryCollection();
            Collection<Factproductinventory> factproductinventoryCollectionNew = dimdate.getFactproductinventoryCollection();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimdate.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimdate.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollection1Old = persistentDimdate.getFactresellersalesCollection1();
            Collection<Factresellersales> factresellersalesCollection1New = dimdate.getFactresellersalesCollection1();
            Collection<Factresellersales> factresellersalesCollection2Old = persistentDimdate.getFactresellersalesCollection2();
            Collection<Factresellersales> factresellersalesCollection2New = dimdate.getFactresellersalesCollection2();
            Collection<Factcurrencyrate> factcurrencyrateCollectionOld = persistentDimdate.getFactcurrencyrateCollection();
            Collection<Factcurrencyrate> factcurrencyrateCollectionNew = dimdate.getFactcurrencyrateCollection();
            List<String> illegalOrphanMessages = null;
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollectionOldFactinternetsales + " since its shipdatekey field is not nullable.");
                }
            }
            for (Factinternetsales factinternetsalesCollection1OldFactinternetsales : factinternetsalesCollection1Old) {
                if (!factinternetsalesCollection1New.contains(factinternetsalesCollection1OldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollection1OldFactinternetsales + " since its orderdatekey field is not nullable.");
                }
            }
            for (Factinternetsales factinternetsalesCollection2OldFactinternetsales : factinternetsalesCollection2Old) {
                if (!factinternetsalesCollection2New.contains(factinternetsalesCollection2OldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollection2OldFactinternetsales + " since its duedatekey field is not nullable.");
                }
            }
            for (Factsurveyresponse factsurveyresponseCollectionOldFactsurveyresponse : factsurveyresponseCollectionOld) {
                if (!factsurveyresponseCollectionNew.contains(factsurveyresponseCollectionOldFactsurveyresponse)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factsurveyresponse " + factsurveyresponseCollectionOldFactsurveyresponse + " since its datekey field is not nullable.");
                }
            }
            for (Factsalesquota factsalesquotaCollectionOldFactsalesquota : factsalesquotaCollectionOld) {
                if (!factsalesquotaCollectionNew.contains(factsalesquotaCollectionOldFactsalesquota)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factsalesquota " + factsalesquotaCollectionOldFactsalesquota + " since its datekey field is not nullable.");
                }
            }
            for (Factcallcenter factcallcenterCollectionOldFactcallcenter : factcallcenterCollectionOld) {
                if (!factcallcenterCollectionNew.contains(factcallcenterCollectionOldFactcallcenter)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factcallcenter " + factcallcenterCollectionOldFactcallcenter + " since its datekey field is not nullable.");
                }
            }
            for (Factproductinventory factproductinventoryCollectionOldFactproductinventory : factproductinventoryCollectionOld) {
                if (!factproductinventoryCollectionNew.contains(factproductinventoryCollectionOldFactproductinventory)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factproductinventory " + factproductinventoryCollectionOldFactproductinventory + " since its dimdate field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its shipdatekey field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollection1OldFactresellersales : factresellersalesCollection1Old) {
                if (!factresellersalesCollection1New.contains(factresellersalesCollection1OldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollection1OldFactresellersales + " since its duedatekey field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollection2OldFactresellersales : factresellersalesCollection2Old) {
                if (!factresellersalesCollection2New.contains(factresellersalesCollection2OldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollection2OldFactresellersales + " since its orderdatekey field is not nullable.");
                }
            }
            for (Factcurrencyrate factcurrencyrateCollectionOldFactcurrencyrate : factcurrencyrateCollectionOld) {
                if (!factcurrencyrateCollectionNew.contains(factcurrencyrateCollectionOldFactcurrencyrate)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factcurrencyrate " + factcurrencyrateCollectionOldFactcurrencyrate + " since its dimdate field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollectionNew = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsalesToAttach : factinternetsalesCollectionNew) {
                factinternetsalesCollectionNewFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionNewFactinternetsalesToAttach.getClass(), factinternetsalesCollectionNewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollectionNew.add(factinternetsalesCollectionNewFactinternetsalesToAttach);
            }
            factinternetsalesCollectionNew = attachedFactinternetsalesCollectionNew;
            dimdate.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            Collection<Factinternetsales> attachedFactinternetsalesCollection1New = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollection1NewFactinternetsalesToAttach : factinternetsalesCollection1New) {
                factinternetsalesCollection1NewFactinternetsalesToAttach = em.getReference(factinternetsalesCollection1NewFactinternetsalesToAttach.getClass(), factinternetsalesCollection1NewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection1New.add(factinternetsalesCollection1NewFactinternetsalesToAttach);
            }
            factinternetsalesCollection1New = attachedFactinternetsalesCollection1New;
            dimdate.setFactinternetsalesCollection1(factinternetsalesCollection1New);
            Collection<Factinternetsales> attachedFactinternetsalesCollection2New = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollection2NewFactinternetsalesToAttach : factinternetsalesCollection2New) {
                factinternetsalesCollection2NewFactinternetsalesToAttach = em.getReference(factinternetsalesCollection2NewFactinternetsalesToAttach.getClass(), factinternetsalesCollection2NewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection2New.add(factinternetsalesCollection2NewFactinternetsalesToAttach);
            }
            factinternetsalesCollection2New = attachedFactinternetsalesCollection2New;
            dimdate.setFactinternetsalesCollection2(factinternetsalesCollection2New);
            Collection<Factsurveyresponse> attachedFactsurveyresponseCollectionNew = new ArrayList<Factsurveyresponse>();
            for (Factsurveyresponse factsurveyresponseCollectionNewFactsurveyresponseToAttach : factsurveyresponseCollectionNew) {
                factsurveyresponseCollectionNewFactsurveyresponseToAttach = em.getReference(factsurveyresponseCollectionNewFactsurveyresponseToAttach.getClass(), factsurveyresponseCollectionNewFactsurveyresponseToAttach.getSurveyresponsekey());
                attachedFactsurveyresponseCollectionNew.add(factsurveyresponseCollectionNewFactsurveyresponseToAttach);
            }
            factsurveyresponseCollectionNew = attachedFactsurveyresponseCollectionNew;
            dimdate.setFactsurveyresponseCollection(factsurveyresponseCollectionNew);
            Collection<Factsalesquota> attachedFactsalesquotaCollectionNew = new ArrayList<Factsalesquota>();
            for (Factsalesquota factsalesquotaCollectionNewFactsalesquotaToAttach : factsalesquotaCollectionNew) {
                factsalesquotaCollectionNewFactsalesquotaToAttach = em.getReference(factsalesquotaCollectionNewFactsalesquotaToAttach.getClass(), factsalesquotaCollectionNewFactsalesquotaToAttach.getSalesquotakey());
                attachedFactsalesquotaCollectionNew.add(factsalesquotaCollectionNewFactsalesquotaToAttach);
            }
            factsalesquotaCollectionNew = attachedFactsalesquotaCollectionNew;
            dimdate.setFactsalesquotaCollection(factsalesquotaCollectionNew);
            Collection<Factcallcenter> attachedFactcallcenterCollectionNew = new ArrayList<Factcallcenter>();
            for (Factcallcenter factcallcenterCollectionNewFactcallcenterToAttach : factcallcenterCollectionNew) {
                factcallcenterCollectionNewFactcallcenterToAttach = em.getReference(factcallcenterCollectionNewFactcallcenterToAttach.getClass(), factcallcenterCollectionNewFactcallcenterToAttach.getFactcallcenterid());
                attachedFactcallcenterCollectionNew.add(factcallcenterCollectionNewFactcallcenterToAttach);
            }
            factcallcenterCollectionNew = attachedFactcallcenterCollectionNew;
            dimdate.setFactcallcenterCollection(factcallcenterCollectionNew);
            Collection<Factproductinventory> attachedFactproductinventoryCollectionNew = new ArrayList<Factproductinventory>();
            for (Factproductinventory factproductinventoryCollectionNewFactproductinventoryToAttach : factproductinventoryCollectionNew) {
                factproductinventoryCollectionNewFactproductinventoryToAttach = em.getReference(factproductinventoryCollectionNewFactproductinventoryToAttach.getClass(), factproductinventoryCollectionNewFactproductinventoryToAttach.getFactproductinventoryPK());
                attachedFactproductinventoryCollectionNew.add(factproductinventoryCollectionNewFactproductinventoryToAttach);
            }
            factproductinventoryCollectionNew = attachedFactproductinventoryCollectionNew;
            dimdate.setFactproductinventoryCollection(factproductinventoryCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimdate.setFactresellersalesCollection(factresellersalesCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollection1New = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollection1NewFactresellersalesToAttach : factresellersalesCollection1New) {
                factresellersalesCollection1NewFactresellersalesToAttach = em.getReference(factresellersalesCollection1NewFactresellersalesToAttach.getClass(), factresellersalesCollection1NewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection1New.add(factresellersalesCollection1NewFactresellersalesToAttach);
            }
            factresellersalesCollection1New = attachedFactresellersalesCollection1New;
            dimdate.setFactresellersalesCollection1(factresellersalesCollection1New);
            Collection<Factresellersales> attachedFactresellersalesCollection2New = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollection2NewFactresellersalesToAttach : factresellersalesCollection2New) {
                factresellersalesCollection2NewFactresellersalesToAttach = em.getReference(factresellersalesCollection2NewFactresellersalesToAttach.getClass(), factresellersalesCollection2NewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection2New.add(factresellersalesCollection2NewFactresellersalesToAttach);
            }
            factresellersalesCollection2New = attachedFactresellersalesCollection2New;
            dimdate.setFactresellersalesCollection2(factresellersalesCollection2New);
            Collection<Factcurrencyrate> attachedFactcurrencyrateCollectionNew = new ArrayList<Factcurrencyrate>();
            for (Factcurrencyrate factcurrencyrateCollectionNewFactcurrencyrateToAttach : factcurrencyrateCollectionNew) {
                factcurrencyrateCollectionNewFactcurrencyrateToAttach = em.getReference(factcurrencyrateCollectionNewFactcurrencyrateToAttach.getClass(), factcurrencyrateCollectionNewFactcurrencyrateToAttach.getFactcurrencyratePK());
                attachedFactcurrencyrateCollectionNew.add(factcurrencyrateCollectionNewFactcurrencyrateToAttach);
            }
            factcurrencyrateCollectionNew = attachedFactcurrencyrateCollectionNew;
            dimdate.setFactcurrencyrateCollection(factcurrencyrateCollectionNew);
            dimdate = em.merge(dimdate);
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    Dimdate oldShipdatekeyOfFactinternetsalesCollectionNewFactinternetsales = factinternetsalesCollectionNewFactinternetsales.getShipdatekey();
                    factinternetsalesCollectionNewFactinternetsales.setShipdatekey(dimdate);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                    if (oldShipdatekeyOfFactinternetsalesCollectionNewFactinternetsales != null && !oldShipdatekeyOfFactinternetsalesCollectionNewFactinternetsales.equals(dimdate)) {
                        oldShipdatekeyOfFactinternetsalesCollectionNewFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionNewFactinternetsales);
                        oldShipdatekeyOfFactinternetsalesCollectionNewFactinternetsales = em.merge(oldShipdatekeyOfFactinternetsalesCollectionNewFactinternetsales);
                    }
                }
            }
            for (Factinternetsales factinternetsalesCollection1NewFactinternetsales : factinternetsalesCollection1New) {
                if (!factinternetsalesCollection1Old.contains(factinternetsalesCollection1NewFactinternetsales)) {
                    Dimdate oldOrderdatekeyOfFactinternetsalesCollection1NewFactinternetsales = factinternetsalesCollection1NewFactinternetsales.getOrderdatekey();
                    factinternetsalesCollection1NewFactinternetsales.setOrderdatekey(dimdate);
                    factinternetsalesCollection1NewFactinternetsales = em.merge(factinternetsalesCollection1NewFactinternetsales);
                    if (oldOrderdatekeyOfFactinternetsalesCollection1NewFactinternetsales != null && !oldOrderdatekeyOfFactinternetsalesCollection1NewFactinternetsales.equals(dimdate)) {
                        oldOrderdatekeyOfFactinternetsalesCollection1NewFactinternetsales.getFactinternetsalesCollection1().remove(factinternetsalesCollection1NewFactinternetsales);
                        oldOrderdatekeyOfFactinternetsalesCollection1NewFactinternetsales = em.merge(oldOrderdatekeyOfFactinternetsalesCollection1NewFactinternetsales);
                    }
                }
            }
            for (Factinternetsales factinternetsalesCollection2NewFactinternetsales : factinternetsalesCollection2New) {
                if (!factinternetsalesCollection2Old.contains(factinternetsalesCollection2NewFactinternetsales)) {
                    Dimdate oldDuedatekeyOfFactinternetsalesCollection2NewFactinternetsales = factinternetsalesCollection2NewFactinternetsales.getDuedatekey();
                    factinternetsalesCollection2NewFactinternetsales.setDuedatekey(dimdate);
                    factinternetsalesCollection2NewFactinternetsales = em.merge(factinternetsalesCollection2NewFactinternetsales);
                    if (oldDuedatekeyOfFactinternetsalesCollection2NewFactinternetsales != null && !oldDuedatekeyOfFactinternetsalesCollection2NewFactinternetsales.equals(dimdate)) {
                        oldDuedatekeyOfFactinternetsalesCollection2NewFactinternetsales.getFactinternetsalesCollection2().remove(factinternetsalesCollection2NewFactinternetsales);
                        oldDuedatekeyOfFactinternetsalesCollection2NewFactinternetsales = em.merge(oldDuedatekeyOfFactinternetsalesCollection2NewFactinternetsales);
                    }
                }
            }
            for (Factsurveyresponse factsurveyresponseCollectionNewFactsurveyresponse : factsurveyresponseCollectionNew) {
                if (!factsurveyresponseCollectionOld.contains(factsurveyresponseCollectionNewFactsurveyresponse)) {
                    Dimdate oldDatekeyOfFactsurveyresponseCollectionNewFactsurveyresponse = factsurveyresponseCollectionNewFactsurveyresponse.getDatekey();
                    factsurveyresponseCollectionNewFactsurveyresponse.setDatekey(dimdate);
                    factsurveyresponseCollectionNewFactsurveyresponse = em.merge(factsurveyresponseCollectionNewFactsurveyresponse);
                    if (oldDatekeyOfFactsurveyresponseCollectionNewFactsurveyresponse != null && !oldDatekeyOfFactsurveyresponseCollectionNewFactsurveyresponse.equals(dimdate)) {
                        oldDatekeyOfFactsurveyresponseCollectionNewFactsurveyresponse.getFactsurveyresponseCollection().remove(factsurveyresponseCollectionNewFactsurveyresponse);
                        oldDatekeyOfFactsurveyresponseCollectionNewFactsurveyresponse = em.merge(oldDatekeyOfFactsurveyresponseCollectionNewFactsurveyresponse);
                    }
                }
            }
            for (Factsalesquota factsalesquotaCollectionNewFactsalesquota : factsalesquotaCollectionNew) {
                if (!factsalesquotaCollectionOld.contains(factsalesquotaCollectionNewFactsalesquota)) {
                    Dimdate oldDatekeyOfFactsalesquotaCollectionNewFactsalesquota = factsalesquotaCollectionNewFactsalesquota.getDatekey();
                    factsalesquotaCollectionNewFactsalesquota.setDatekey(dimdate);
                    factsalesquotaCollectionNewFactsalesquota = em.merge(factsalesquotaCollectionNewFactsalesquota);
                    if (oldDatekeyOfFactsalesquotaCollectionNewFactsalesquota != null && !oldDatekeyOfFactsalesquotaCollectionNewFactsalesquota.equals(dimdate)) {
                        oldDatekeyOfFactsalesquotaCollectionNewFactsalesquota.getFactsalesquotaCollection().remove(factsalesquotaCollectionNewFactsalesquota);
                        oldDatekeyOfFactsalesquotaCollectionNewFactsalesquota = em.merge(oldDatekeyOfFactsalesquotaCollectionNewFactsalesquota);
                    }
                }
            }
            for (Factcallcenter factcallcenterCollectionNewFactcallcenter : factcallcenterCollectionNew) {
                if (!factcallcenterCollectionOld.contains(factcallcenterCollectionNewFactcallcenter)) {
                    Dimdate oldDatekeyOfFactcallcenterCollectionNewFactcallcenter = factcallcenterCollectionNewFactcallcenter.getDatekey();
                    factcallcenterCollectionNewFactcallcenter.setDatekey(dimdate);
                    factcallcenterCollectionNewFactcallcenter = em.merge(factcallcenterCollectionNewFactcallcenter);
                    if (oldDatekeyOfFactcallcenterCollectionNewFactcallcenter != null && !oldDatekeyOfFactcallcenterCollectionNewFactcallcenter.equals(dimdate)) {
                        oldDatekeyOfFactcallcenterCollectionNewFactcallcenter.getFactcallcenterCollection().remove(factcallcenterCollectionNewFactcallcenter);
                        oldDatekeyOfFactcallcenterCollectionNewFactcallcenter = em.merge(oldDatekeyOfFactcallcenterCollectionNewFactcallcenter);
                    }
                }
            }
            for (Factproductinventory factproductinventoryCollectionNewFactproductinventory : factproductinventoryCollectionNew) {
                if (!factproductinventoryCollectionOld.contains(factproductinventoryCollectionNewFactproductinventory)) {
                    Dimdate oldDimdateOfFactproductinventoryCollectionNewFactproductinventory = factproductinventoryCollectionNewFactproductinventory.getDimdate();
                    factproductinventoryCollectionNewFactproductinventory.setDimdate(dimdate);
                    factproductinventoryCollectionNewFactproductinventory = em.merge(factproductinventoryCollectionNewFactproductinventory);
                    if (oldDimdateOfFactproductinventoryCollectionNewFactproductinventory != null && !oldDimdateOfFactproductinventoryCollectionNewFactproductinventory.equals(dimdate)) {
                        oldDimdateOfFactproductinventoryCollectionNewFactproductinventory.getFactproductinventoryCollection().remove(factproductinventoryCollectionNewFactproductinventory);
                        oldDimdateOfFactproductinventoryCollectionNewFactproductinventory = em.merge(oldDimdateOfFactproductinventoryCollectionNewFactproductinventory);
                    }
                }
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimdate oldShipdatekeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getShipdatekey();
                    factresellersalesCollectionNewFactresellersales.setShipdatekey(dimdate);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldShipdatekeyOfFactresellersalesCollectionNewFactresellersales != null && !oldShipdatekeyOfFactresellersalesCollectionNewFactresellersales.equals(dimdate)) {
                        oldShipdatekeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldShipdatekeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldShipdatekeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            for (Factresellersales factresellersalesCollection1NewFactresellersales : factresellersalesCollection1New) {
                if (!factresellersalesCollection1Old.contains(factresellersalesCollection1NewFactresellersales)) {
                    Dimdate oldDuedatekeyOfFactresellersalesCollection1NewFactresellersales = factresellersalesCollection1NewFactresellersales.getDuedatekey();
                    factresellersalesCollection1NewFactresellersales.setDuedatekey(dimdate);
                    factresellersalesCollection1NewFactresellersales = em.merge(factresellersalesCollection1NewFactresellersales);
                    if (oldDuedatekeyOfFactresellersalesCollection1NewFactresellersales != null && !oldDuedatekeyOfFactresellersalesCollection1NewFactresellersales.equals(dimdate)) {
                        oldDuedatekeyOfFactresellersalesCollection1NewFactresellersales.getFactresellersalesCollection1().remove(factresellersalesCollection1NewFactresellersales);
                        oldDuedatekeyOfFactresellersalesCollection1NewFactresellersales = em.merge(oldDuedatekeyOfFactresellersalesCollection1NewFactresellersales);
                    }
                }
            }
            for (Factresellersales factresellersalesCollection2NewFactresellersales : factresellersalesCollection2New) {
                if (!factresellersalesCollection2Old.contains(factresellersalesCollection2NewFactresellersales)) {
                    Dimdate oldOrderdatekeyOfFactresellersalesCollection2NewFactresellersales = factresellersalesCollection2NewFactresellersales.getOrderdatekey();
                    factresellersalesCollection2NewFactresellersales.setOrderdatekey(dimdate);
                    factresellersalesCollection2NewFactresellersales = em.merge(factresellersalesCollection2NewFactresellersales);
                    if (oldOrderdatekeyOfFactresellersalesCollection2NewFactresellersales != null && !oldOrderdatekeyOfFactresellersalesCollection2NewFactresellersales.equals(dimdate)) {
                        oldOrderdatekeyOfFactresellersalesCollection2NewFactresellersales.getFactresellersalesCollection2().remove(factresellersalesCollection2NewFactresellersales);
                        oldOrderdatekeyOfFactresellersalesCollection2NewFactresellersales = em.merge(oldOrderdatekeyOfFactresellersalesCollection2NewFactresellersales);
                    }
                }
            }
            for (Factcurrencyrate factcurrencyrateCollectionNewFactcurrencyrate : factcurrencyrateCollectionNew) {
                if (!factcurrencyrateCollectionOld.contains(factcurrencyrateCollectionNewFactcurrencyrate)) {
                    Dimdate oldDimdateOfFactcurrencyrateCollectionNewFactcurrencyrate = factcurrencyrateCollectionNewFactcurrencyrate.getDimdate();
                    factcurrencyrateCollectionNewFactcurrencyrate.setDimdate(dimdate);
                    factcurrencyrateCollectionNewFactcurrencyrate = em.merge(factcurrencyrateCollectionNewFactcurrencyrate);
                    if (oldDimdateOfFactcurrencyrateCollectionNewFactcurrencyrate != null && !oldDimdateOfFactcurrencyrateCollectionNewFactcurrencyrate.equals(dimdate)) {
                        oldDimdateOfFactcurrencyrateCollectionNewFactcurrencyrate.getFactcurrencyrateCollection().remove(factcurrencyrateCollectionNewFactcurrencyrate);
                        oldDimdateOfFactcurrencyrateCollectionNewFactcurrencyrate = em.merge(oldDimdateOfFactcurrencyrateCollectionNewFactcurrencyrate);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimdate.getDatekey();
                if (findDimdate(id) == null) {
                    throw new NonexistentEntityException("The dimdate with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdate dimdate;
            try {
                dimdate = em.getReference(Dimdate.class, id);
                dimdate.getDatekey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimdate with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factinternetsales> factinternetsalesCollectionOrphanCheck = dimdate.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionOrphanCheckFactinternetsales : factinternetsalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollectionOrphanCheckFactinternetsales + " in its factinternetsalesCollection field has a non-nullable shipdatekey field.");
            }
            Collection<Factinternetsales> factinternetsalesCollection1OrphanCheck = dimdate.getFactinternetsalesCollection1();
            for (Factinternetsales factinternetsalesCollection1OrphanCheckFactinternetsales : factinternetsalesCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollection1OrphanCheckFactinternetsales + " in its factinternetsalesCollection1 field has a non-nullable orderdatekey field.");
            }
            Collection<Factinternetsales> factinternetsalesCollection2OrphanCheck = dimdate.getFactinternetsalesCollection2();
            for (Factinternetsales factinternetsalesCollection2OrphanCheckFactinternetsales : factinternetsalesCollection2OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollection2OrphanCheckFactinternetsales + " in its factinternetsalesCollection2 field has a non-nullable duedatekey field.");
            }
            Collection<Factsurveyresponse> factsurveyresponseCollectionOrphanCheck = dimdate.getFactsurveyresponseCollection();
            for (Factsurveyresponse factsurveyresponseCollectionOrphanCheckFactsurveyresponse : factsurveyresponseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factsurveyresponse " + factsurveyresponseCollectionOrphanCheckFactsurveyresponse + " in its factsurveyresponseCollection field has a non-nullable datekey field.");
            }
            Collection<Factsalesquota> factsalesquotaCollectionOrphanCheck = dimdate.getFactsalesquotaCollection();
            for (Factsalesquota factsalesquotaCollectionOrphanCheckFactsalesquota : factsalesquotaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factsalesquota " + factsalesquotaCollectionOrphanCheckFactsalesquota + " in its factsalesquotaCollection field has a non-nullable datekey field.");
            }
            Collection<Factcallcenter> factcallcenterCollectionOrphanCheck = dimdate.getFactcallcenterCollection();
            for (Factcallcenter factcallcenterCollectionOrphanCheckFactcallcenter : factcallcenterCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factcallcenter " + factcallcenterCollectionOrphanCheckFactcallcenter + " in its factcallcenterCollection field has a non-nullable datekey field.");
            }
            Collection<Factproductinventory> factproductinventoryCollectionOrphanCheck = dimdate.getFactproductinventoryCollection();
            for (Factproductinventory factproductinventoryCollectionOrphanCheckFactproductinventory : factproductinventoryCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factproductinventory " + factproductinventoryCollectionOrphanCheckFactproductinventory + " in its factproductinventoryCollection field has a non-nullable dimdate field.");
            }
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimdate.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable shipdatekey field.");
            }
            Collection<Factresellersales> factresellersalesCollection1OrphanCheck = dimdate.getFactresellersalesCollection1();
            for (Factresellersales factresellersalesCollection1OrphanCheckFactresellersales : factresellersalesCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factresellersales " + factresellersalesCollection1OrphanCheckFactresellersales + " in its factresellersalesCollection1 field has a non-nullable duedatekey field.");
            }
            Collection<Factresellersales> factresellersalesCollection2OrphanCheck = dimdate.getFactresellersalesCollection2();
            for (Factresellersales factresellersalesCollection2OrphanCheckFactresellersales : factresellersalesCollection2OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factresellersales " + factresellersalesCollection2OrphanCheckFactresellersales + " in its factresellersalesCollection2 field has a non-nullable orderdatekey field.");
            }
            Collection<Factcurrencyrate> factcurrencyrateCollectionOrphanCheck = dimdate.getFactcurrencyrateCollection();
            for (Factcurrencyrate factcurrencyrateCollectionOrphanCheckFactcurrencyrate : factcurrencyrateCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimdate (" + dimdate + ") cannot be destroyed since the Factcurrencyrate " + factcurrencyrateCollectionOrphanCheckFactcurrencyrate + " in its factcurrencyrateCollection field has a non-nullable dimdate field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(dimdate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimdate> findDimdateEntities() {
        return findDimdateEntities(true, -1, -1);
    }

    public List<Dimdate> findDimdateEntities(int maxResults, int firstResult) {
        return findDimdateEntities(false, maxResults, firstResult);
    }

    private List<Dimdate> findDimdateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimdate.class));
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

    public Dimdate findDimdate(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimdate.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimdateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimdate> rt = cq.from(Dimdate.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
