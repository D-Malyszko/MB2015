/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "DIMDATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimdate.findAll", query = "SELECT d FROM Dimdate d"),
    @NamedQuery(name = "Dimdate.findByDatekey", query = "SELECT d FROM Dimdate d WHERE d.datekey = :datekey"),
    @NamedQuery(name = "Dimdate.findByCalendarquarter", query = "SELECT d FROM Dimdate d WHERE d.calendarquarter = :calendarquarter"),
    @NamedQuery(name = "Dimdate.findByCalendarsemester", query = "SELECT d FROM Dimdate d WHERE d.calendarsemester = :calendarsemester"),
    @NamedQuery(name = "Dimdate.findByCalendaryear", query = "SELECT d FROM Dimdate d WHERE d.calendaryear = :calendaryear"),
    @NamedQuery(name = "Dimdate.findByDaynumberofmonth", query = "SELECT d FROM Dimdate d WHERE d.daynumberofmonth = :daynumberofmonth"),
    @NamedQuery(name = "Dimdate.findByDaynumberofweek", query = "SELECT d FROM Dimdate d WHERE d.daynumberofweek = :daynumberofweek"),
    @NamedQuery(name = "Dimdate.findByDaynumberofyear", query = "SELECT d FROM Dimdate d WHERE d.daynumberofyear = :daynumberofyear"),
    @NamedQuery(name = "Dimdate.findByEnglishdaynameofweek", query = "SELECT d FROM Dimdate d WHERE d.englishdaynameofweek = :englishdaynameofweek"),
    @NamedQuery(name = "Dimdate.findByEnglishmonthname", query = "SELECT d FROM Dimdate d WHERE d.englishmonthname = :englishmonthname"),
    @NamedQuery(name = "Dimdate.findByFiscalquarter", query = "SELECT d FROM Dimdate d WHERE d.fiscalquarter = :fiscalquarter"),
    @NamedQuery(name = "Dimdate.findByFiscalsemester", query = "SELECT d FROM Dimdate d WHERE d.fiscalsemester = :fiscalsemester"),
    @NamedQuery(name = "Dimdate.findByFiscalyear", query = "SELECT d FROM Dimdate d WHERE d.fiscalyear = :fiscalyear"),
    @NamedQuery(name = "Dimdate.findByFrenchdaynameofweek", query = "SELECT d FROM Dimdate d WHERE d.frenchdaynameofweek = :frenchdaynameofweek"),
    @NamedQuery(name = "Dimdate.findByFrenchmonthname", query = "SELECT d FROM Dimdate d WHERE d.frenchmonthname = :frenchmonthname"),
    @NamedQuery(name = "Dimdate.findByFulldatealternatekey", query = "SELECT d FROM Dimdate d WHERE d.fulldatealternatekey = :fulldatealternatekey"),
    @NamedQuery(name = "Dimdate.findByMonthnumberofyear", query = "SELECT d FROM Dimdate d WHERE d.monthnumberofyear = :monthnumberofyear"),
    @NamedQuery(name = "Dimdate.findBySpanishdaynameofweek", query = "SELECT d FROM Dimdate d WHERE d.spanishdaynameofweek = :spanishdaynameofweek"),
    @NamedQuery(name = "Dimdate.findBySpanishmonthname", query = "SELECT d FROM Dimdate d WHERE d.spanishmonthname = :spanishmonthname"),
    @NamedQuery(name = "Dimdate.findByWeeknumberofyear", query = "SELECT d FROM Dimdate d WHERE d.weeknumberofyear = :weeknumberofyear")})
public class Dimdate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATEKEY")
    private Integer datekey;
    @Basic(optional = false)
    @Column(name = "CALENDARQUARTER")
    private short calendarquarter;
    @Basic(optional = false)
    @Column(name = "CALENDARSEMESTER")
    private short calendarsemester;
    @Basic(optional = false)
    @Column(name = "CALENDARYEAR")
    private short calendaryear;
    @Basic(optional = false)
    @Column(name = "DAYNUMBEROFMONTH")
    private short daynumberofmonth;
    @Basic(optional = false)
    @Column(name = "DAYNUMBEROFWEEK")
    private short daynumberofweek;
    @Basic(optional = false)
    @Column(name = "DAYNUMBEROFYEAR")
    private short daynumberofyear;
    @Basic(optional = false)
    @Column(name = "ENGLISHDAYNAMEOFWEEK")
    private String englishdaynameofweek;
    @Basic(optional = false)
    @Column(name = "ENGLISHMONTHNAME")
    private String englishmonthname;
    @Basic(optional = false)
    @Column(name = "FISCALQUARTER")
    private short fiscalquarter;
    @Basic(optional = false)
    @Column(name = "FISCALSEMESTER")
    private short fiscalsemester;
    @Basic(optional = false)
    @Column(name = "FISCALYEAR")
    private short fiscalyear;
    @Basic(optional = false)
    @Column(name = "FRENCHDAYNAMEOFWEEK")
    private String frenchdaynameofweek;
    @Basic(optional = false)
    @Column(name = "FRENCHMONTHNAME")
    private String frenchmonthname;
    @Basic(optional = false)
    @Column(name = "FULLDATEALTERNATEKEY")
    @Temporal(TemporalType.DATE)
    private Date fulldatealternatekey;
    @Basic(optional = false)
    @Column(name = "MONTHNUMBEROFYEAR")
    private short monthnumberofyear;
    @Basic(optional = false)
    @Column(name = "SPANISHDAYNAMEOFWEEK")
    private String spanishdaynameofweek;
    @Basic(optional = false)
    @Column(name = "SPANISHMONTHNAME")
    private String spanishmonthname;
    @Basic(optional = false)
    @Column(name = "WEEKNUMBEROFYEAR")
    private short weeknumberofyear;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipdatekey")
    private Collection<Factinternetsales> factinternetsalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderdatekey")
    private Collection<Factinternetsales> factinternetsalesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duedatekey")
    private Collection<Factinternetsales> factinternetsalesCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datekey")
    private Collection<Factsurveyresponse> factsurveyresponseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datekey")
    private Collection<Factsalesquota> factsalesquotaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datekey")
    private Collection<Factcallcenter> factcallcenterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimdate")
    private Collection<Factproductinventory> factproductinventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipdatekey")
    private Collection<Factresellersales> factresellersalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duedatekey")
    private Collection<Factresellersales> factresellersalesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderdatekey")
    private Collection<Factresellersales> factresellersalesCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimdate")
    private Collection<Factcurrencyrate> factcurrencyrateCollection;

    public Dimdate() {
    }

    public Dimdate(Integer datekey) {
        this.datekey = datekey;
    }

    public Dimdate(Integer datekey, short calendarquarter, short calendarsemester, short calendaryear, short daynumberofmonth, short daynumberofweek, short daynumberofyear, String englishdaynameofweek, String englishmonthname, short fiscalquarter, short fiscalsemester, short fiscalyear, String frenchdaynameofweek, String frenchmonthname, Date fulldatealternatekey, short monthnumberofyear, String spanishdaynameofweek, String spanishmonthname, short weeknumberofyear) {
        this.datekey = datekey;
        this.calendarquarter = calendarquarter;
        this.calendarsemester = calendarsemester;
        this.calendaryear = calendaryear;
        this.daynumberofmonth = daynumberofmonth;
        this.daynumberofweek = daynumberofweek;
        this.daynumberofyear = daynumberofyear;
        this.englishdaynameofweek = englishdaynameofweek;
        this.englishmonthname = englishmonthname;
        this.fiscalquarter = fiscalquarter;
        this.fiscalsemester = fiscalsemester;
        this.fiscalyear = fiscalyear;
        this.frenchdaynameofweek = frenchdaynameofweek;
        this.frenchmonthname = frenchmonthname;
        this.fulldatealternatekey = fulldatealternatekey;
        this.monthnumberofyear = monthnumberofyear;
        this.spanishdaynameofweek = spanishdaynameofweek;
        this.spanishmonthname = spanishmonthname;
        this.weeknumberofyear = weeknumberofyear;
    }

    public Integer getDatekey() {
        return datekey;
    }

    public void setDatekey(Integer datekey) {
        this.datekey = datekey;
    }

    public short getCalendarquarter() {
        return calendarquarter;
    }

    public void setCalendarquarter(short calendarquarter) {
        this.calendarquarter = calendarquarter;
    }

    public short getCalendarsemester() {
        return calendarsemester;
    }

    public void setCalendarsemester(short calendarsemester) {
        this.calendarsemester = calendarsemester;
    }

    public short getCalendaryear() {
        return calendaryear;
    }

    public void setCalendaryear(short calendaryear) {
        this.calendaryear = calendaryear;
    }

    public short getDaynumberofmonth() {
        return daynumberofmonth;
    }

    public void setDaynumberofmonth(short daynumberofmonth) {
        this.daynumberofmonth = daynumberofmonth;
    }

    public short getDaynumberofweek() {
        return daynumberofweek;
    }

    public void setDaynumberofweek(short daynumberofweek) {
        this.daynumberofweek = daynumberofweek;
    }

    public short getDaynumberofyear() {
        return daynumberofyear;
    }

    public void setDaynumberofyear(short daynumberofyear) {
        this.daynumberofyear = daynumberofyear;
    }

    public String getEnglishdaynameofweek() {
        return englishdaynameofweek;
    }

    public void setEnglishdaynameofweek(String englishdaynameofweek) {
        this.englishdaynameofweek = englishdaynameofweek;
    }

    public String getEnglishmonthname() {
        return englishmonthname;
    }

    public void setEnglishmonthname(String englishmonthname) {
        this.englishmonthname = englishmonthname;
    }

    public short getFiscalquarter() {
        return fiscalquarter;
    }

    public void setFiscalquarter(short fiscalquarter) {
        this.fiscalquarter = fiscalquarter;
    }

    public short getFiscalsemester() {
        return fiscalsemester;
    }

    public void setFiscalsemester(short fiscalsemester) {
        this.fiscalsemester = fiscalsemester;
    }

    public short getFiscalyear() {
        return fiscalyear;
    }

    public void setFiscalyear(short fiscalyear) {
        this.fiscalyear = fiscalyear;
    }

    public String getFrenchdaynameofweek() {
        return frenchdaynameofweek;
    }

    public void setFrenchdaynameofweek(String frenchdaynameofweek) {
        this.frenchdaynameofweek = frenchdaynameofweek;
    }

    public String getFrenchmonthname() {
        return frenchmonthname;
    }

    public void setFrenchmonthname(String frenchmonthname) {
        this.frenchmonthname = frenchmonthname;
    }

    public Date getFulldatealternatekey() {
        return fulldatealternatekey;
    }

    public void setFulldatealternatekey(Date fulldatealternatekey) {
        this.fulldatealternatekey = fulldatealternatekey;
    }

    public short getMonthnumberofyear() {
        return monthnumberofyear;
    }

    public void setMonthnumberofyear(short monthnumberofyear) {
        this.monthnumberofyear = monthnumberofyear;
    }

    public String getSpanishdaynameofweek() {
        return spanishdaynameofweek;
    }

    public void setSpanishdaynameofweek(String spanishdaynameofweek) {
        this.spanishdaynameofweek = spanishdaynameofweek;
    }

    public String getSpanishmonthname() {
        return spanishmonthname;
    }

    public void setSpanishmonthname(String spanishmonthname) {
        this.spanishmonthname = spanishmonthname;
    }

    public short getWeeknumberofyear() {
        return weeknumberofyear;
    }

    public void setWeeknumberofyear(short weeknumberofyear) {
        this.weeknumberofyear = weeknumberofyear;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection1() {
        return factinternetsalesCollection1;
    }

    public void setFactinternetsalesCollection1(Collection<Factinternetsales> factinternetsalesCollection1) {
        this.factinternetsalesCollection1 = factinternetsalesCollection1;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection2() {
        return factinternetsalesCollection2;
    }

    public void setFactinternetsalesCollection2(Collection<Factinternetsales> factinternetsalesCollection2) {
        this.factinternetsalesCollection2 = factinternetsalesCollection2;
    }

    @XmlTransient
    public Collection<Factsurveyresponse> getFactsurveyresponseCollection() {
        return factsurveyresponseCollection;
    }

    public void setFactsurveyresponseCollection(Collection<Factsurveyresponse> factsurveyresponseCollection) {
        this.factsurveyresponseCollection = factsurveyresponseCollection;
    }

    @XmlTransient
    public Collection<Factsalesquota> getFactsalesquotaCollection() {
        return factsalesquotaCollection;
    }

    public void setFactsalesquotaCollection(Collection<Factsalesquota> factsalesquotaCollection) {
        this.factsalesquotaCollection = factsalesquotaCollection;
    }

    @XmlTransient
    public Collection<Factcallcenter> getFactcallcenterCollection() {
        return factcallcenterCollection;
    }

    public void setFactcallcenterCollection(Collection<Factcallcenter> factcallcenterCollection) {
        this.factcallcenterCollection = factcallcenterCollection;
    }

    @XmlTransient
    public Collection<Factproductinventory> getFactproductinventoryCollection() {
        return factproductinventoryCollection;
    }

    public void setFactproductinventoryCollection(Collection<Factproductinventory> factproductinventoryCollection) {
        this.factproductinventoryCollection = factproductinventoryCollection;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection() {
        return factresellersalesCollection;
    }

    public void setFactresellersalesCollection(Collection<Factresellersales> factresellersalesCollection) {
        this.factresellersalesCollection = factresellersalesCollection;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection1() {
        return factresellersalesCollection1;
    }

    public void setFactresellersalesCollection1(Collection<Factresellersales> factresellersalesCollection1) {
        this.factresellersalesCollection1 = factresellersalesCollection1;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection2() {
        return factresellersalesCollection2;
    }

    public void setFactresellersalesCollection2(Collection<Factresellersales> factresellersalesCollection2) {
        this.factresellersalesCollection2 = factresellersalesCollection2;
    }

    @XmlTransient
    public Collection<Factcurrencyrate> getFactcurrencyrateCollection() {
        return factcurrencyrateCollection;
    }

    public void setFactcurrencyrateCollection(Collection<Factcurrencyrate> factcurrencyrateCollection) {
        this.factcurrencyrateCollection = factcurrencyrateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datekey != null ? datekey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimdate)) {
            return false;
        }
        Dimdate other = (Dimdate) object;
        if ((this.datekey == null && other.datekey != null) || (this.datekey != null && !this.datekey.equals(other.datekey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimdate[ datekey=" + datekey + " ]";
    }
    
}
