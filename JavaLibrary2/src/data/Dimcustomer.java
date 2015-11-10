/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DIMCUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimcustomer.findAll", query = "SELECT d FROM Dimcustomer d"),
    @NamedQuery(name = "Dimcustomer.findByCustomerkey", query = "SELECT d FROM Dimcustomer d WHERE d.customerkey = :customerkey"),
    @NamedQuery(name = "Dimcustomer.findByAddressline1", query = "SELECT d FROM Dimcustomer d WHERE d.addressline1 = :addressline1"),
    @NamedQuery(name = "Dimcustomer.findByAddressline2", query = "SELECT d FROM Dimcustomer d WHERE d.addressline2 = :addressline2"),
    @NamedQuery(name = "Dimcustomer.findByBirthdate", query = "SELECT d FROM Dimcustomer d WHERE d.birthdate = :birthdate"),
    @NamedQuery(name = "Dimcustomer.findByCommutedistance", query = "SELECT d FROM Dimcustomer d WHERE d.commutedistance = :commutedistance"),
    @NamedQuery(name = "Dimcustomer.findByCustomeralternatekey", query = "SELECT d FROM Dimcustomer d WHERE d.customeralternatekey = :customeralternatekey"),
    @NamedQuery(name = "Dimcustomer.findByDatefirstpurchase", query = "SELECT d FROM Dimcustomer d WHERE d.datefirstpurchase = :datefirstpurchase"),
    @NamedQuery(name = "Dimcustomer.findByEmailaddress", query = "SELECT d FROM Dimcustomer d WHERE d.emailaddress = :emailaddress"),
    @NamedQuery(name = "Dimcustomer.findByEnglisheducation", query = "SELECT d FROM Dimcustomer d WHERE d.englisheducation = :englisheducation"),
    @NamedQuery(name = "Dimcustomer.findByEnglishoccupation", query = "SELECT d FROM Dimcustomer d WHERE d.englishoccupation = :englishoccupation"),
    @NamedQuery(name = "Dimcustomer.findByFirstname", query = "SELECT d FROM Dimcustomer d WHERE d.firstname = :firstname"),
    @NamedQuery(name = "Dimcustomer.findByFrencheducation", query = "SELECT d FROM Dimcustomer d WHERE d.frencheducation = :frencheducation"),
    @NamedQuery(name = "Dimcustomer.findByFrenchoccupation", query = "SELECT d FROM Dimcustomer d WHERE d.frenchoccupation = :frenchoccupation"),
    @NamedQuery(name = "Dimcustomer.findByGender", query = "SELECT d FROM Dimcustomer d WHERE d.gender = :gender"),
    @NamedQuery(name = "Dimcustomer.findByHouseownerflag", query = "SELECT d FROM Dimcustomer d WHERE d.houseownerflag = :houseownerflag"),
    @NamedQuery(name = "Dimcustomer.findByLastname", query = "SELECT d FROM Dimcustomer d WHERE d.lastname = :lastname"),
    @NamedQuery(name = "Dimcustomer.findByMaritalstatus", query = "SELECT d FROM Dimcustomer d WHERE d.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Dimcustomer.findByMiddlename", query = "SELECT d FROM Dimcustomer d WHERE d.middlename = :middlename"),
    @NamedQuery(name = "Dimcustomer.findByNamestyle", query = "SELECT d FROM Dimcustomer d WHERE d.namestyle = :namestyle"),
    @NamedQuery(name = "Dimcustomer.findByNumbercarsowned", query = "SELECT d FROM Dimcustomer d WHERE d.numbercarsowned = :numbercarsowned"),
    @NamedQuery(name = "Dimcustomer.findByNumberchildrenathome", query = "SELECT d FROM Dimcustomer d WHERE d.numberchildrenathome = :numberchildrenathome"),
    @NamedQuery(name = "Dimcustomer.findByPhone", query = "SELECT d FROM Dimcustomer d WHERE d.phone = :phone"),
    @NamedQuery(name = "Dimcustomer.findBySpanisheducation", query = "SELECT d FROM Dimcustomer d WHERE d.spanisheducation = :spanisheducation"),
    @NamedQuery(name = "Dimcustomer.findBySpanishoccupation", query = "SELECT d FROM Dimcustomer d WHERE d.spanishoccupation = :spanishoccupation"),
    @NamedQuery(name = "Dimcustomer.findBySuffix", query = "SELECT d FROM Dimcustomer d WHERE d.suffix = :suffix"),
    @NamedQuery(name = "Dimcustomer.findByTitle", query = "SELECT d FROM Dimcustomer d WHERE d.title = :title"),
    @NamedQuery(name = "Dimcustomer.findByTotalchildren", query = "SELECT d FROM Dimcustomer d WHERE d.totalchildren = :totalchildren"),
    @NamedQuery(name = "Dimcustomer.findByYearlyincome", query = "SELECT d FROM Dimcustomer d WHERE d.yearlyincome = :yearlyincome")})
public class Dimcustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMERKEY")
    private Integer customerkey;
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Column(name = "COMMUTEDISTANCE")
    private String commutedistance;
    @Basic(optional = false)
    @Column(name = "CUSTOMERALTERNATEKEY")
    private String customeralternatekey;
    @Column(name = "DATEFIRSTPURCHASE")
    @Temporal(TemporalType.DATE)
    private Date datefirstpurchase;
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @Column(name = "ENGLISHEDUCATION")
    private String englisheducation;
    @Column(name = "ENGLISHOCCUPATION")
    private String englishoccupation;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "FRENCHEDUCATION")
    private String frencheducation;
    @Column(name = "FRENCHOCCUPATION")
    private String frenchoccupation;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "HOUSEOWNERFLAG")
    private String houseownerflag;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MARITALSTATUS")
    private String maritalstatus;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Column(name = "NAMESTYLE")
    private Short namestyle;
    @Column(name = "NUMBERCARSOWNED")
    private Short numbercarsowned;
    @Column(name = "NUMBERCHILDRENATHOME")
    private Short numberchildrenathome;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "SPANISHEDUCATION")
    private String spanisheducation;
    @Column(name = "SPANISHOCCUPATION")
    private String spanishoccupation;
    @Column(name = "SUFFIX")
    private String suffix;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TOTALCHILDREN")
    private Short totalchildren;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "YEARLYINCOME")
    private BigDecimal yearlyincome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerkey")
    private Collection<Factinternetsales> factinternetsalesCollection;
    @JoinColumn(name = "GEOGRAPHYKEY", referencedColumnName = "GEOGRAPHYKEY")
    @ManyToOne
    private Dimgeography geographykey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerkey")
    private Collection<Factsurveyresponse> factsurveyresponseCollection;

    public Dimcustomer() {
    }

    public Dimcustomer(Integer customerkey) {
        this.customerkey = customerkey;
    }

    public Dimcustomer(Integer customerkey, String customeralternatekey) {
        this.customerkey = customerkey;
        this.customeralternatekey = customeralternatekey;
    }

    public Integer getCustomerkey() {
        return customerkey;
    }

    public void setCustomerkey(Integer customerkey) {
        this.customerkey = customerkey;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCommutedistance() {
        return commutedistance;
    }

    public void setCommutedistance(String commutedistance) {
        this.commutedistance = commutedistance;
    }

    public String getCustomeralternatekey() {
        return customeralternatekey;
    }

    public void setCustomeralternatekey(String customeralternatekey) {
        this.customeralternatekey = customeralternatekey;
    }

    public Date getDatefirstpurchase() {
        return datefirstpurchase;
    }

    public void setDatefirstpurchase(Date datefirstpurchase) {
        this.datefirstpurchase = datefirstpurchase;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getEnglisheducation() {
        return englisheducation;
    }

    public void setEnglisheducation(String englisheducation) {
        this.englisheducation = englisheducation;
    }

    public String getEnglishoccupation() {
        return englishoccupation;
    }

    public void setEnglishoccupation(String englishoccupation) {
        this.englishoccupation = englishoccupation;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFrencheducation() {
        return frencheducation;
    }

    public void setFrencheducation(String frencheducation) {
        this.frencheducation = frencheducation;
    }

    public String getFrenchoccupation() {
        return frenchoccupation;
    }

    public void setFrenchoccupation(String frenchoccupation) {
        this.frenchoccupation = frenchoccupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHouseownerflag() {
        return houseownerflag;
    }

    public void setHouseownerflag(String houseownerflag) {
        this.houseownerflag = houseownerflag;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Short getNamestyle() {
        return namestyle;
    }

    public void setNamestyle(Short namestyle) {
        this.namestyle = namestyle;
    }

    public Short getNumbercarsowned() {
        return numbercarsowned;
    }

    public void setNumbercarsowned(Short numbercarsowned) {
        this.numbercarsowned = numbercarsowned;
    }

    public Short getNumberchildrenathome() {
        return numberchildrenathome;
    }

    public void setNumberchildrenathome(Short numberchildrenathome) {
        this.numberchildrenathome = numberchildrenathome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpanisheducation() {
        return spanisheducation;
    }

    public void setSpanisheducation(String spanisheducation) {
        this.spanisheducation = spanisheducation;
    }

    public String getSpanishoccupation() {
        return spanishoccupation;
    }

    public void setSpanishoccupation(String spanishoccupation) {
        this.spanishoccupation = spanishoccupation;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getTotalchildren() {
        return totalchildren;
    }

    public void setTotalchildren(Short totalchildren) {
        this.totalchildren = totalchildren;
    }

    public BigDecimal getYearlyincome() {
        return yearlyincome;
    }

    public void setYearlyincome(BigDecimal yearlyincome) {
        this.yearlyincome = yearlyincome;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
    }

    public Dimgeography getGeographykey() {
        return geographykey;
    }

    public void setGeographykey(Dimgeography geographykey) {
        this.geographykey = geographykey;
    }

    @XmlTransient
    public Collection<Factsurveyresponse> getFactsurveyresponseCollection() {
        return factsurveyresponseCollection;
    }

    public void setFactsurveyresponseCollection(Collection<Factsurveyresponse> factsurveyresponseCollection) {
        this.factsurveyresponseCollection = factsurveyresponseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerkey != null ? customerkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimcustomer)) {
            return false;
        }
        Dimcustomer other = (Dimcustomer) object;
        if ((this.customerkey == null && other.customerkey != null) || (this.customerkey != null && !this.customerkey.equals(other.customerkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimcustomer[ customerkey=" + customerkey + " ]";
    }
    
}
