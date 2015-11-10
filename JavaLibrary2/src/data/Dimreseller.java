/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "DIMRESELLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimreseller.findAll", query = "SELECT d FROM Dimreseller d"),
    @NamedQuery(name = "Dimreseller.findByResellerkey", query = "SELECT d FROM Dimreseller d WHERE d.resellerkey = :resellerkey"),
    @NamedQuery(name = "Dimreseller.findByAddressline1", query = "SELECT d FROM Dimreseller d WHERE d.addressline1 = :addressline1"),
    @NamedQuery(name = "Dimreseller.findByAddressline2", query = "SELECT d FROM Dimreseller d WHERE d.addressline2 = :addressline2"),
    @NamedQuery(name = "Dimreseller.findByAnnualrevenue", query = "SELECT d FROM Dimreseller d WHERE d.annualrevenue = :annualrevenue"),
    @NamedQuery(name = "Dimreseller.findByAnnualsales", query = "SELECT d FROM Dimreseller d WHERE d.annualsales = :annualsales"),
    @NamedQuery(name = "Dimreseller.findByBankname", query = "SELECT d FROM Dimreseller d WHERE d.bankname = :bankname"),
    @NamedQuery(name = "Dimreseller.findByBusinesstype", query = "SELECT d FROM Dimreseller d WHERE d.businesstype = :businesstype"),
    @NamedQuery(name = "Dimreseller.findByFirstorderyear", query = "SELECT d FROM Dimreseller d WHERE d.firstorderyear = :firstorderyear"),
    @NamedQuery(name = "Dimreseller.findByLastorderyear", query = "SELECT d FROM Dimreseller d WHERE d.lastorderyear = :lastorderyear"),
    @NamedQuery(name = "Dimreseller.findByMinpaymentamount", query = "SELECT d FROM Dimreseller d WHERE d.minpaymentamount = :minpaymentamount"),
    @NamedQuery(name = "Dimreseller.findByMinpaymenttype", query = "SELECT d FROM Dimreseller d WHERE d.minpaymenttype = :minpaymenttype"),
    @NamedQuery(name = "Dimreseller.findByNumberemployees", query = "SELECT d FROM Dimreseller d WHERE d.numberemployees = :numberemployees"),
    @NamedQuery(name = "Dimreseller.findByOrderfrequency", query = "SELECT d FROM Dimreseller d WHERE d.orderfrequency = :orderfrequency"),
    @NamedQuery(name = "Dimreseller.findByOrdermonth", query = "SELECT d FROM Dimreseller d WHERE d.ordermonth = :ordermonth"),
    @NamedQuery(name = "Dimreseller.findByPhone", query = "SELECT d FROM Dimreseller d WHERE d.phone = :phone"),
    @NamedQuery(name = "Dimreseller.findByProductline", query = "SELECT d FROM Dimreseller d WHERE d.productline = :productline"),
    @NamedQuery(name = "Dimreseller.findByReselleralternatekey", query = "SELECT d FROM Dimreseller d WHERE d.reselleralternatekey = :reselleralternatekey"),
    @NamedQuery(name = "Dimreseller.findByResellername", query = "SELECT d FROM Dimreseller d WHERE d.resellername = :resellername"),
    @NamedQuery(name = "Dimreseller.findByYearopened", query = "SELECT d FROM Dimreseller d WHERE d.yearopened = :yearopened")})
public class Dimreseller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RESELLERKEY")
    private Integer resellerkey;
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ANNUALREVENUE")
    private BigDecimal annualrevenue;
    @Column(name = "ANNUALSALES")
    private BigDecimal annualsales;
    @Column(name = "BANKNAME")
    private String bankname;
    @Basic(optional = false)
    @Column(name = "BUSINESSTYPE")
    private String businesstype;
    @Column(name = "FIRSTORDERYEAR")
    private Integer firstorderyear;
    @Column(name = "LASTORDERYEAR")
    private Integer lastorderyear;
    @Column(name = "MINPAYMENTAMOUNT")
    private BigDecimal minpaymentamount;
    @Column(name = "MINPAYMENTTYPE")
    private Short minpaymenttype;
    @Column(name = "NUMBEREMPLOYEES")
    private Integer numberemployees;
    @Column(name = "ORDERFREQUENCY")
    private Character orderfrequency;
    @Column(name = "ORDERMONTH")
    private Short ordermonth;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PRODUCTLINE")
    private String productline;
    @Column(name = "RESELLERALTERNATEKEY")
    private String reselleralternatekey;
    @Basic(optional = false)
    @Column(name = "RESELLERNAME")
    private String resellername;
    @Column(name = "YEAROPENED")
    private Integer yearopened;
    @JoinColumn(name = "GEOGRAPHYKEY", referencedColumnName = "GEOGRAPHYKEY")
    @ManyToOne
    private Dimgeography geographykey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resellerkey")
    private Collection<Factresellersales> factresellersalesCollection;

    public Dimreseller() {
    }

    public Dimreseller(Integer resellerkey) {
        this.resellerkey = resellerkey;
    }

    public Dimreseller(Integer resellerkey, String businesstype, String resellername) {
        this.resellerkey = resellerkey;
        this.businesstype = businesstype;
        this.resellername = resellername;
    }

    public Integer getResellerkey() {
        return resellerkey;
    }

    public void setResellerkey(Integer resellerkey) {
        this.resellerkey = resellerkey;
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

    public BigDecimal getAnnualrevenue() {
        return annualrevenue;
    }

    public void setAnnualrevenue(BigDecimal annualrevenue) {
        this.annualrevenue = annualrevenue;
    }

    public BigDecimal getAnnualsales() {
        return annualsales;
    }

    public void setAnnualsales(BigDecimal annualsales) {
        this.annualsales = annualsales;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public Integer getFirstorderyear() {
        return firstorderyear;
    }

    public void setFirstorderyear(Integer firstorderyear) {
        this.firstorderyear = firstorderyear;
    }

    public Integer getLastorderyear() {
        return lastorderyear;
    }

    public void setLastorderyear(Integer lastorderyear) {
        this.lastorderyear = lastorderyear;
    }

    public BigDecimal getMinpaymentamount() {
        return minpaymentamount;
    }

    public void setMinpaymentamount(BigDecimal minpaymentamount) {
        this.minpaymentamount = minpaymentamount;
    }

    public Short getMinpaymenttype() {
        return minpaymenttype;
    }

    public void setMinpaymenttype(Short minpaymenttype) {
        this.minpaymenttype = minpaymenttype;
    }

    public Integer getNumberemployees() {
        return numberemployees;
    }

    public void setNumberemployees(Integer numberemployees) {
        this.numberemployees = numberemployees;
    }

    public Character getOrderfrequency() {
        return orderfrequency;
    }

    public void setOrderfrequency(Character orderfrequency) {
        this.orderfrequency = orderfrequency;
    }

    public Short getOrdermonth() {
        return ordermonth;
    }

    public void setOrdermonth(Short ordermonth) {
        this.ordermonth = ordermonth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public String getReselleralternatekey() {
        return reselleralternatekey;
    }

    public void setReselleralternatekey(String reselleralternatekey) {
        this.reselleralternatekey = reselleralternatekey;
    }

    public String getResellername() {
        return resellername;
    }

    public void setResellername(String resellername) {
        this.resellername = resellername;
    }

    public Integer getYearopened() {
        return yearopened;
    }

    public void setYearopened(Integer yearopened) {
        this.yearopened = yearopened;
    }

    public Dimgeography getGeographykey() {
        return geographykey;
    }

    public void setGeographykey(Dimgeography geographykey) {
        this.geographykey = geographykey;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection() {
        return factresellersalesCollection;
    }

    public void setFactresellersalesCollection(Collection<Factresellersales> factresellersalesCollection) {
        this.factresellersalesCollection = factresellersalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resellerkey != null ? resellerkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimreseller)) {
            return false;
        }
        Dimreseller other = (Dimreseller) object;
        if ((this.resellerkey == null && other.resellerkey != null) || (this.resellerkey != null && !this.resellerkey.equals(other.resellerkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimreseller[ resellerkey=" + resellerkey + " ]";
    }
    
}
