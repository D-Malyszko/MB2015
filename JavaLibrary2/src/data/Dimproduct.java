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
import javax.persistence.Lob;
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
@Table(name = "DIMPRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimproduct.findAll", query = "SELECT d FROM Dimproduct d"),
    @NamedQuery(name = "Dimproduct.findByProductkey", query = "SELECT d FROM Dimproduct d WHERE d.productkey = :productkey"),
    @NamedQuery(name = "Dimproduct.findByArabicdescription", query = "SELECT d FROM Dimproduct d WHERE d.arabicdescription = :arabicdescription"),
    @NamedQuery(name = "Dimproduct.findByChinesedescription", query = "SELECT d FROM Dimproduct d WHERE d.chinesedescription = :chinesedescription"),
    @NamedQuery(name = "Dimproduct.findByClass1", query = "SELECT d FROM Dimproduct d WHERE d.class1 = :class1"),
    @NamedQuery(name = "Dimproduct.findByColor", query = "SELECT d FROM Dimproduct d WHERE d.color = :color"),
    @NamedQuery(name = "Dimproduct.findByDaystomanufacture", query = "SELECT d FROM Dimproduct d WHERE d.daystomanufacture = :daystomanufacture"),
    @NamedQuery(name = "Dimproduct.findByDealerprice", query = "SELECT d FROM Dimproduct d WHERE d.dealerprice = :dealerprice"),
    @NamedQuery(name = "Dimproduct.findByEnddate", query = "SELECT d FROM Dimproduct d WHERE d.enddate = :enddate"),
    @NamedQuery(name = "Dimproduct.findByEnglishdescription", query = "SELECT d FROM Dimproduct d WHERE d.englishdescription = :englishdescription"),
    @NamedQuery(name = "Dimproduct.findByEnglishproductname", query = "SELECT d FROM Dimproduct d WHERE d.englishproductname = :englishproductname"),
    @NamedQuery(name = "Dimproduct.findByFinishedgoodsflag", query = "SELECT d FROM Dimproduct d WHERE d.finishedgoodsflag = :finishedgoodsflag"),
    @NamedQuery(name = "Dimproduct.findByFrenchdescription", query = "SELECT d FROM Dimproduct d WHERE d.frenchdescription = :frenchdescription"),
    @NamedQuery(name = "Dimproduct.findByFrenchproductname", query = "SELECT d FROM Dimproduct d WHERE d.frenchproductname = :frenchproductname"),
    @NamedQuery(name = "Dimproduct.findByGermandescription", query = "SELECT d FROM Dimproduct d WHERE d.germandescription = :germandescription"),
    @NamedQuery(name = "Dimproduct.findByHebrewdescription", query = "SELECT d FROM Dimproduct d WHERE d.hebrewdescription = :hebrewdescription"),
    @NamedQuery(name = "Dimproduct.findByJapanesedescription", query = "SELECT d FROM Dimproduct d WHERE d.japanesedescription = :japanesedescription"),
    @NamedQuery(name = "Dimproduct.findByListprice", query = "SELECT d FROM Dimproduct d WHERE d.listprice = :listprice"),
    @NamedQuery(name = "Dimproduct.findByModelname", query = "SELECT d FROM Dimproduct d WHERE d.modelname = :modelname"),
    @NamedQuery(name = "Dimproduct.findByProductalternatekey", query = "SELECT d FROM Dimproduct d WHERE d.productalternatekey = :productalternatekey"),
    @NamedQuery(name = "Dimproduct.findByProductline", query = "SELECT d FROM Dimproduct d WHERE d.productline = :productline"),
    @NamedQuery(name = "Dimproduct.findByReorderpoint", query = "SELECT d FROM Dimproduct d WHERE d.reorderpoint = :reorderpoint"),
    @NamedQuery(name = "Dimproduct.findBySafetystocklevel", query = "SELECT d FROM Dimproduct d WHERE d.safetystocklevel = :safetystocklevel"),
    @NamedQuery(name = "Dimproduct.findBySize", query = "SELECT d FROM Dimproduct d WHERE d.size = :size"),
    @NamedQuery(name = "Dimproduct.findBySizerange", query = "SELECT d FROM Dimproduct d WHERE d.sizerange = :sizerange"),
    @NamedQuery(name = "Dimproduct.findBySizeunitmeasurecode", query = "SELECT d FROM Dimproduct d WHERE d.sizeunitmeasurecode = :sizeunitmeasurecode"),
    @NamedQuery(name = "Dimproduct.findBySpanishproductname", query = "SELECT d FROM Dimproduct d WHERE d.spanishproductname = :spanishproductname"),
    @NamedQuery(name = "Dimproduct.findByStandardcost", query = "SELECT d FROM Dimproduct d WHERE d.standardcost = :standardcost"),
    @NamedQuery(name = "Dimproduct.findByStartdate", query = "SELECT d FROM Dimproduct d WHERE d.startdate = :startdate"),
    @NamedQuery(name = "Dimproduct.findByStatus", query = "SELECT d FROM Dimproduct d WHERE d.status = :status"),
    @NamedQuery(name = "Dimproduct.findByStyle", query = "SELECT d FROM Dimproduct d WHERE d.style = :style"),
    @NamedQuery(name = "Dimproduct.findByThaidescription", query = "SELECT d FROM Dimproduct d WHERE d.thaidescription = :thaidescription"),
    @NamedQuery(name = "Dimproduct.findByTurkishdescription", query = "SELECT d FROM Dimproduct d WHERE d.turkishdescription = :turkishdescription"),
    @NamedQuery(name = "Dimproduct.findByWeight", query = "SELECT d FROM Dimproduct d WHERE d.weight = :weight"),
    @NamedQuery(name = "Dimproduct.findByWeightunitmeasurecode", query = "SELECT d FROM Dimproduct d WHERE d.weightunitmeasurecode = :weightunitmeasurecode")})
public class Dimproduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTKEY")
    private Integer productkey;
    @Column(name = "ARABICDESCRIPTION")
    private String arabicdescription;
    @Column(name = "CHINESEDESCRIPTION")
    private String chinesedescription;
    @Column(name = "CLASS")
    private String class1;
    @Basic(optional = false)
    @Column(name = "COLOR")
    private String color;
    @Column(name = "DAYSTOMANUFACTURE")
    private Integer daystomanufacture;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DEALERPRICE")
    private BigDecimal dealerprice;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "ENGLISHDESCRIPTION")
    private String englishdescription;
    @Basic(optional = false)
    @Column(name = "ENGLISHPRODUCTNAME")
    private String englishproductname;
    @Basic(optional = false)
    @Column(name = "FINISHEDGOODSFLAG")
    private short finishedgoodsflag;
    @Column(name = "FRENCHDESCRIPTION")
    private String frenchdescription;
    @Basic(optional = false)
    @Column(name = "FRENCHPRODUCTNAME")
    private String frenchproductname;
    @Column(name = "GERMANDESCRIPTION")
    private String germandescription;
    @Column(name = "HEBREWDESCRIPTION")
    private String hebrewdescription;
    @Column(name = "JAPANESEDESCRIPTION")
    private String japanesedescription;
    @Lob
    @Column(name = "LARGEPHOTO")
    private Serializable largephoto;
    @Column(name = "LISTPRICE")
    private BigDecimal listprice;
    @Column(name = "MODELNAME")
    private String modelname;
    @Column(name = "PRODUCTALTERNATEKEY")
    private String productalternatekey;
    @Column(name = "PRODUCTLINE")
    private String productline;
    @Column(name = "REORDERPOINT")
    private Short reorderpoint;
    @Column(name = "SAFETYSTOCKLEVEL")
    private Short safetystocklevel;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "SIZERANGE")
    private String sizerange;
    @Column(name = "SIZEUNITMEASURECODE")
    private String sizeunitmeasurecode;
    @Basic(optional = false)
    @Column(name = "SPANISHPRODUCTNAME")
    private String spanishproductname;
    @Column(name = "STANDARDCOST")
    private BigDecimal standardcost;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "STYLE")
    private String style;
    @Column(name = "THAIDESCRIPTION")
    private String thaidescription;
    @Column(name = "TURKISHDESCRIPTION")
    private String turkishdescription;
    @Column(name = "WEIGHT")
    private Double weight;
    @Column(name = "WEIGHTUNITMEASURECODE")
    private String weightunitmeasurecode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productkey")
    private Collection<Factinternetsales> factinternetsalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimproduct")
    private Collection<Factproductinventory> factproductinventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productkey")
    private Collection<Factresellersales> factresellersalesCollection;
    @JoinColumn(name = "PRODUCTSUBCATEGORYKEY", referencedColumnName = "PRODUCTSUBCATEGORYKEY")
    @ManyToOne
    private Dimproductsubcategory productsubcategorykey;

    public Dimproduct() {
    }

    public Dimproduct(Integer productkey) {
        this.productkey = productkey;
    }

    public Dimproduct(Integer productkey, String color, String englishproductname, short finishedgoodsflag, String frenchproductname, String spanishproductname) {
        this.productkey = productkey;
        this.color = color;
        this.englishproductname = englishproductname;
        this.finishedgoodsflag = finishedgoodsflag;
        this.frenchproductname = frenchproductname;
        this.spanishproductname = spanishproductname;
    }

    public Integer getProductkey() {
        return productkey;
    }

    public void setProductkey(Integer productkey) {
        this.productkey = productkey;
    }

    public String getArabicdescription() {
        return arabicdescription;
    }

    public void setArabicdescription(String arabicdescription) {
        this.arabicdescription = arabicdescription;
    }

    public String getChinesedescription() {
        return chinesedescription;
    }

    public void setChinesedescription(String chinesedescription) {
        this.chinesedescription = chinesedescription;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDaystomanufacture() {
        return daystomanufacture;
    }

    public void setDaystomanufacture(Integer daystomanufacture) {
        this.daystomanufacture = daystomanufacture;
    }

    public BigDecimal getDealerprice() {
        return dealerprice;
    }

    public void setDealerprice(BigDecimal dealerprice) {
        this.dealerprice = dealerprice;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getEnglishdescription() {
        return englishdescription;
    }

    public void setEnglishdescription(String englishdescription) {
        this.englishdescription = englishdescription;
    }

    public String getEnglishproductname() {
        return englishproductname;
    }

    public void setEnglishproductname(String englishproductname) {
        this.englishproductname = englishproductname;
    }

    public short getFinishedgoodsflag() {
        return finishedgoodsflag;
    }

    public void setFinishedgoodsflag(short finishedgoodsflag) {
        this.finishedgoodsflag = finishedgoodsflag;
    }

    public String getFrenchdescription() {
        return frenchdescription;
    }

    public void setFrenchdescription(String frenchdescription) {
        this.frenchdescription = frenchdescription;
    }

    public String getFrenchproductname() {
        return frenchproductname;
    }

    public void setFrenchproductname(String frenchproductname) {
        this.frenchproductname = frenchproductname;
    }

    public String getGermandescription() {
        return germandescription;
    }

    public void setGermandescription(String germandescription) {
        this.germandescription = germandescription;
    }

    public String getHebrewdescription() {
        return hebrewdescription;
    }

    public void setHebrewdescription(String hebrewdescription) {
        this.hebrewdescription = hebrewdescription;
    }

    public String getJapanesedescription() {
        return japanesedescription;
    }

    public void setJapanesedescription(String japanesedescription) {
        this.japanesedescription = japanesedescription;
    }

    public Serializable getLargephoto() {
        return largephoto;
    }

    public void setLargephoto(Serializable largephoto) {
        this.largephoto = largephoto;
    }

    public BigDecimal getListprice() {
        return listprice;
    }

    public void setListprice(BigDecimal listprice) {
        this.listprice = listprice;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getProductalternatekey() {
        return productalternatekey;
    }

    public void setProductalternatekey(String productalternatekey) {
        this.productalternatekey = productalternatekey;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public Short getReorderpoint() {
        return reorderpoint;
    }

    public void setReorderpoint(Short reorderpoint) {
        this.reorderpoint = reorderpoint;
    }

    public Short getSafetystocklevel() {
        return safetystocklevel;
    }

    public void setSafetystocklevel(Short safetystocklevel) {
        this.safetystocklevel = safetystocklevel;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizerange() {
        return sizerange;
    }

    public void setSizerange(String sizerange) {
        this.sizerange = sizerange;
    }

    public String getSizeunitmeasurecode() {
        return sizeunitmeasurecode;
    }

    public void setSizeunitmeasurecode(String sizeunitmeasurecode) {
        this.sizeunitmeasurecode = sizeunitmeasurecode;
    }

    public String getSpanishproductname() {
        return spanishproductname;
    }

    public void setSpanishproductname(String spanishproductname) {
        this.spanishproductname = spanishproductname;
    }

    public BigDecimal getStandardcost() {
        return standardcost;
    }

    public void setStandardcost(BigDecimal standardcost) {
        this.standardcost = standardcost;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getThaidescription() {
        return thaidescription;
    }

    public void setThaidescription(String thaidescription) {
        this.thaidescription = thaidescription;
    }

    public String getTurkishdescription() {
        return turkishdescription;
    }

    public void setTurkishdescription(String turkishdescription) {
        this.turkishdescription = turkishdescription;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightunitmeasurecode() {
        return weightunitmeasurecode;
    }

    public void setWeightunitmeasurecode(String weightunitmeasurecode) {
        this.weightunitmeasurecode = weightunitmeasurecode;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
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

    public Dimproductsubcategory getProductsubcategorykey() {
        return productsubcategorykey;
    }

    public void setProductsubcategorykey(Dimproductsubcategory productsubcategorykey) {
        this.productsubcategorykey = productsubcategorykey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productkey != null ? productkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimproduct)) {
            return false;
        }
        Dimproduct other = (Dimproduct) object;
        if ((this.productkey == null && other.productkey != null) || (this.productkey != null && !this.productkey.equals(other.productkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimproduct[ productkey=" + productkey + " ]";
    }
    
}
