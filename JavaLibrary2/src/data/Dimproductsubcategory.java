/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "DIMPRODUCTSUBCATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimproductsubcategory.findAll", query = "SELECT d FROM Dimproductsubcategory d"),
    @NamedQuery(name = "Dimproductsubcategory.findByProductsubcategorykey", query = "SELECT d FROM Dimproductsubcategory d WHERE d.productsubcategorykey = :productsubcategorykey"),
    @NamedQuery(name = "Dimproductsubcategory.findByEnglishproductsubcategoryname", query = "SELECT d FROM Dimproductsubcategory d WHERE d.englishproductsubcategoryname = :englishproductsubcategoryname"),
    @NamedQuery(name = "Dimproductsubcategory.findByFrenchproductsubcategoryname", query = "SELECT d FROM Dimproductsubcategory d WHERE d.frenchproductsubcategoryname = :frenchproductsubcategoryname"),
    @NamedQuery(name = "Dimproductsubcategory.findByProductsubcategoryalternatekey", query = "SELECT d FROM Dimproductsubcategory d WHERE d.productsubcategoryalternatekey = :productsubcategoryalternatekey"),
    @NamedQuery(name = "Dimproductsubcategory.findBySpanishproductsubcategoryname", query = "SELECT d FROM Dimproductsubcategory d WHERE d.spanishproductsubcategoryname = :spanishproductsubcategoryname")})
public class Dimproductsubcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTSUBCATEGORYKEY")
    private Integer productsubcategorykey;
    @Basic(optional = false)
    @Column(name = "ENGLISHPRODUCTSUBCATEGORYNAME")
    private String englishproductsubcategoryname;
    @Basic(optional = false)
    @Column(name = "FRENCHPRODUCTSUBCATEGORYNAME")
    private String frenchproductsubcategoryname;
    @Column(name = "PRODUCTSUBCATEGORYALTERNATEKEY")
    private Integer productsubcategoryalternatekey;
    @Basic(optional = false)
    @Column(name = "SPANISHPRODUCTSUBCATEGORYNAME")
    private String spanishproductsubcategoryname;
    @JoinColumn(name = "PRODUCTCATEGORYKEY", referencedColumnName = "PRODUCTCATEGORYKEY")
    @ManyToOne
    private Dimproductcategory productcategorykey;
    @OneToMany(mappedBy = "productsubcategorykey")
    private Collection<Dimproduct> dimproductCollection;

    public Dimproductsubcategory() {
    }

    public Dimproductsubcategory(Integer productsubcategorykey) {
        this.productsubcategorykey = productsubcategorykey;
    }

    public Dimproductsubcategory(Integer productsubcategorykey, String englishproductsubcategoryname, String frenchproductsubcategoryname, String spanishproductsubcategoryname) {
        this.productsubcategorykey = productsubcategorykey;
        this.englishproductsubcategoryname = englishproductsubcategoryname;
        this.frenchproductsubcategoryname = frenchproductsubcategoryname;
        this.spanishproductsubcategoryname = spanishproductsubcategoryname;
    }

    public Integer getProductsubcategorykey() {
        return productsubcategorykey;
    }

    public void setProductsubcategorykey(Integer productsubcategorykey) {
        this.productsubcategorykey = productsubcategorykey;
    }

    public String getEnglishproductsubcategoryname() {
        return englishproductsubcategoryname;
    }

    public void setEnglishproductsubcategoryname(String englishproductsubcategoryname) {
        this.englishproductsubcategoryname = englishproductsubcategoryname;
    }

    public String getFrenchproductsubcategoryname() {
        return frenchproductsubcategoryname;
    }

    public void setFrenchproductsubcategoryname(String frenchproductsubcategoryname) {
        this.frenchproductsubcategoryname = frenchproductsubcategoryname;
    }

    public Integer getProductsubcategoryalternatekey() {
        return productsubcategoryalternatekey;
    }

    public void setProductsubcategoryalternatekey(Integer productsubcategoryalternatekey) {
        this.productsubcategoryalternatekey = productsubcategoryalternatekey;
    }

    public String getSpanishproductsubcategoryname() {
        return spanishproductsubcategoryname;
    }

    public void setSpanishproductsubcategoryname(String spanishproductsubcategoryname) {
        this.spanishproductsubcategoryname = spanishproductsubcategoryname;
    }

    public Dimproductcategory getProductcategorykey() {
        return productcategorykey;
    }

    public void setProductcategorykey(Dimproductcategory productcategorykey) {
        this.productcategorykey = productcategorykey;
    }

    @XmlTransient
    public Collection<Dimproduct> getDimproductCollection() {
        return dimproductCollection;
    }

    public void setDimproductCollection(Collection<Dimproduct> dimproductCollection) {
        this.dimproductCollection = dimproductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productsubcategorykey != null ? productsubcategorykey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimproductsubcategory)) {
            return false;
        }
        Dimproductsubcategory other = (Dimproductsubcategory) object;
        if ((this.productsubcategorykey == null && other.productsubcategorykey != null) || (this.productsubcategorykey != null && !this.productsubcategorykey.equals(other.productsubcategorykey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimproductsubcategory[ productsubcategorykey=" + productsubcategorykey + " ]";
    }
    
}
