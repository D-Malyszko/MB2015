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
@Table(name = "DIMPROMOTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimpromotion.findAll", query = "SELECT d FROM Dimpromotion d"),
    @NamedQuery(name = "Dimpromotion.findByPromotionkey", query = "SELECT d FROM Dimpromotion d WHERE d.promotionkey = :promotionkey"),
    @NamedQuery(name = "Dimpromotion.findByDiscountpct", query = "SELECT d FROM Dimpromotion d WHERE d.discountpct = :discountpct"),
    @NamedQuery(name = "Dimpromotion.findByEnddate", query = "SELECT d FROM Dimpromotion d WHERE d.enddate = :enddate"),
    @NamedQuery(name = "Dimpromotion.findByEnglishpromotioncategory", query = "SELECT d FROM Dimpromotion d WHERE d.englishpromotioncategory = :englishpromotioncategory"),
    @NamedQuery(name = "Dimpromotion.findByEnglishpromotionname", query = "SELECT d FROM Dimpromotion d WHERE d.englishpromotionname = :englishpromotionname"),
    @NamedQuery(name = "Dimpromotion.findByEnglishpromotiontype", query = "SELECT d FROM Dimpromotion d WHERE d.englishpromotiontype = :englishpromotiontype"),
    @NamedQuery(name = "Dimpromotion.findByFrenchpromotioncategory", query = "SELECT d FROM Dimpromotion d WHERE d.frenchpromotioncategory = :frenchpromotioncategory"),
    @NamedQuery(name = "Dimpromotion.findByFrenchpromotionname", query = "SELECT d FROM Dimpromotion d WHERE d.frenchpromotionname = :frenchpromotionname"),
    @NamedQuery(name = "Dimpromotion.findByFrenchpromotiontype", query = "SELECT d FROM Dimpromotion d WHERE d.frenchpromotiontype = :frenchpromotiontype"),
    @NamedQuery(name = "Dimpromotion.findByMaxqty", query = "SELECT d FROM Dimpromotion d WHERE d.maxqty = :maxqty"),
    @NamedQuery(name = "Dimpromotion.findByMinqty", query = "SELECT d FROM Dimpromotion d WHERE d.minqty = :minqty"),
    @NamedQuery(name = "Dimpromotion.findByPromotionalternatekey", query = "SELECT d FROM Dimpromotion d WHERE d.promotionalternatekey = :promotionalternatekey"),
    @NamedQuery(name = "Dimpromotion.findBySpanishpromotioncategory", query = "SELECT d FROM Dimpromotion d WHERE d.spanishpromotioncategory = :spanishpromotioncategory"),
    @NamedQuery(name = "Dimpromotion.findBySpanishpromotionname", query = "SELECT d FROM Dimpromotion d WHERE d.spanishpromotionname = :spanishpromotionname"),
    @NamedQuery(name = "Dimpromotion.findBySpanishpromotiontype", query = "SELECT d FROM Dimpromotion d WHERE d.spanishpromotiontype = :spanishpromotiontype"),
    @NamedQuery(name = "Dimpromotion.findByStartdate", query = "SELECT d FROM Dimpromotion d WHERE d.startdate = :startdate")})
public class Dimpromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROMOTIONKEY")
    private Integer promotionkey;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNTPCT")
    private Double discountpct;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "ENGLISHPROMOTIONCATEGORY")
    private String englishpromotioncategory;
    @Column(name = "ENGLISHPROMOTIONNAME")
    private String englishpromotionname;
    @Column(name = "ENGLISHPROMOTIONTYPE")
    private String englishpromotiontype;
    @Column(name = "FRENCHPROMOTIONCATEGORY")
    private String frenchpromotioncategory;
    @Column(name = "FRENCHPROMOTIONNAME")
    private String frenchpromotionname;
    @Column(name = "FRENCHPROMOTIONTYPE")
    private String frenchpromotiontype;
    @Column(name = "MAXQTY")
    private Integer maxqty;
    @Column(name = "MINQTY")
    private Integer minqty;
    @Column(name = "PROMOTIONALTERNATEKEY")
    private Integer promotionalternatekey;
    @Column(name = "SPANISHPROMOTIONCATEGORY")
    private String spanishpromotioncategory;
    @Column(name = "SPANISHPROMOTIONNAME")
    private String spanishpromotionname;
    @Column(name = "SPANISHPROMOTIONTYPE")
    private String spanishpromotiontype;
    @Basic(optional = false)
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionkey")
    private Collection<Factinternetsales> factinternetsalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionkey")
    private Collection<Factresellersales> factresellersalesCollection;

    public Dimpromotion() {
    }

    public Dimpromotion(Integer promotionkey) {
        this.promotionkey = promotionkey;
    }

    public Dimpromotion(Integer promotionkey, Date startdate) {
        this.promotionkey = promotionkey;
        this.startdate = startdate;
    }

    public Integer getPromotionkey() {
        return promotionkey;
    }

    public void setPromotionkey(Integer promotionkey) {
        this.promotionkey = promotionkey;
    }

    public Double getDiscountpct() {
        return discountpct;
    }

    public void setDiscountpct(Double discountpct) {
        this.discountpct = discountpct;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getEnglishpromotioncategory() {
        return englishpromotioncategory;
    }

    public void setEnglishpromotioncategory(String englishpromotioncategory) {
        this.englishpromotioncategory = englishpromotioncategory;
    }

    public String getEnglishpromotionname() {
        return englishpromotionname;
    }

    public void setEnglishpromotionname(String englishpromotionname) {
        this.englishpromotionname = englishpromotionname;
    }

    public String getEnglishpromotiontype() {
        return englishpromotiontype;
    }

    public void setEnglishpromotiontype(String englishpromotiontype) {
        this.englishpromotiontype = englishpromotiontype;
    }

    public String getFrenchpromotioncategory() {
        return frenchpromotioncategory;
    }

    public void setFrenchpromotioncategory(String frenchpromotioncategory) {
        this.frenchpromotioncategory = frenchpromotioncategory;
    }

    public String getFrenchpromotionname() {
        return frenchpromotionname;
    }

    public void setFrenchpromotionname(String frenchpromotionname) {
        this.frenchpromotionname = frenchpromotionname;
    }

    public String getFrenchpromotiontype() {
        return frenchpromotiontype;
    }

    public void setFrenchpromotiontype(String frenchpromotiontype) {
        this.frenchpromotiontype = frenchpromotiontype;
    }

    public Integer getMaxqty() {
        return maxqty;
    }

    public void setMaxqty(Integer maxqty) {
        this.maxqty = maxqty;
    }

    public Integer getMinqty() {
        return minqty;
    }

    public void setMinqty(Integer minqty) {
        this.minqty = minqty;
    }

    public Integer getPromotionalternatekey() {
        return promotionalternatekey;
    }

    public void setPromotionalternatekey(Integer promotionalternatekey) {
        this.promotionalternatekey = promotionalternatekey;
    }

    public String getSpanishpromotioncategory() {
        return spanishpromotioncategory;
    }

    public void setSpanishpromotioncategory(String spanishpromotioncategory) {
        this.spanishpromotioncategory = spanishpromotioncategory;
    }

    public String getSpanishpromotionname() {
        return spanishpromotionname;
    }

    public void setSpanishpromotionname(String spanishpromotionname) {
        this.spanishpromotionname = spanishpromotionname;
    }

    public String getSpanishpromotiontype() {
        return spanishpromotiontype;
    }

    public void setSpanishpromotiontype(String spanishpromotiontype) {
        this.spanishpromotiontype = spanishpromotiontype;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
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
        hash += (promotionkey != null ? promotionkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimpromotion)) {
            return false;
        }
        Dimpromotion other = (Dimpromotion) object;
        if ((this.promotionkey == null && other.promotionkey != null) || (this.promotionkey != null && !this.promotionkey.equals(other.promotionkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimpromotion[ promotionkey=" + promotionkey + " ]";
    }
    
}
