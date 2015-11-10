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
@Table(name = "DIMPRODUCTCATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimproductcategory.findAll", query = "SELECT d FROM Dimproductcategory d"),
    @NamedQuery(name = "Dimproductcategory.findByProductcategorykey", query = "SELECT d FROM Dimproductcategory d WHERE d.productcategorykey = :productcategorykey"),
    @NamedQuery(name = "Dimproductcategory.findByEnglishproductcategoryname", query = "SELECT d FROM Dimproductcategory d WHERE d.englishproductcategoryname = :englishproductcategoryname"),
    @NamedQuery(name = "Dimproductcategory.findByFrenchproductcategoryname", query = "SELECT d FROM Dimproductcategory d WHERE d.frenchproductcategoryname = :frenchproductcategoryname"),
    @NamedQuery(name = "Dimproductcategory.findByProductcategoryalternatekey", query = "SELECT d FROM Dimproductcategory d WHERE d.productcategoryalternatekey = :productcategoryalternatekey"),
    @NamedQuery(name = "Dimproductcategory.findBySpanishproductcategoryname", query = "SELECT d FROM Dimproductcategory d WHERE d.spanishproductcategoryname = :spanishproductcategoryname")})
public class Dimproductcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTCATEGORYKEY")
    private Integer productcategorykey;
    @Basic(optional = false)
    @Column(name = "ENGLISHPRODUCTCATEGORYNAME")
    private String englishproductcategoryname;
    @Basic(optional = false)
    @Column(name = "FRENCHPRODUCTCATEGORYNAME")
    private String frenchproductcategoryname;
    @Column(name = "PRODUCTCATEGORYALTERNATEKEY")
    private Integer productcategoryalternatekey;
    @Basic(optional = false)
    @Column(name = "SPANISHPRODUCTCATEGORYNAME")
    private String spanishproductcategoryname;
    @OneToMany(mappedBy = "productcategorykey")
    private Collection<Dimproductsubcategory> dimproductsubcategoryCollection;

    public Dimproductcategory() {
    }

    public Dimproductcategory(Integer productcategorykey) {
        this.productcategorykey = productcategorykey;
    }

    public Dimproductcategory(Integer productcategorykey, String englishproductcategoryname, String frenchproductcategoryname, String spanishproductcategoryname) {
        this.productcategorykey = productcategorykey;
        this.englishproductcategoryname = englishproductcategoryname;
        this.frenchproductcategoryname = frenchproductcategoryname;
        this.spanishproductcategoryname = spanishproductcategoryname;
    }

    public Integer getProductcategorykey() {
        return productcategorykey;
    }

    public void setProductcategorykey(Integer productcategorykey) {
        this.productcategorykey = productcategorykey;
    }

    public String getEnglishproductcategoryname() {
        return englishproductcategoryname;
    }

    public void setEnglishproductcategoryname(String englishproductcategoryname) {
        this.englishproductcategoryname = englishproductcategoryname;
    }

    public String getFrenchproductcategoryname() {
        return frenchproductcategoryname;
    }

    public void setFrenchproductcategoryname(String frenchproductcategoryname) {
        this.frenchproductcategoryname = frenchproductcategoryname;
    }

    public Integer getProductcategoryalternatekey() {
        return productcategoryalternatekey;
    }

    public void setProductcategoryalternatekey(Integer productcategoryalternatekey) {
        this.productcategoryalternatekey = productcategoryalternatekey;
    }

    public String getSpanishproductcategoryname() {
        return spanishproductcategoryname;
    }

    public void setSpanishproductcategoryname(String spanishproductcategoryname) {
        this.spanishproductcategoryname = spanishproductcategoryname;
    }

    @XmlTransient
    public Collection<Dimproductsubcategory> getDimproductsubcategoryCollection() {
        return dimproductsubcategoryCollection;
    }

    public void setDimproductsubcategoryCollection(Collection<Dimproductsubcategory> dimproductsubcategoryCollection) {
        this.dimproductsubcategoryCollection = dimproductsubcategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productcategorykey != null ? productcategorykey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimproductcategory)) {
            return false;
        }
        Dimproductcategory other = (Dimproductcategory) object;
        if ((this.productcategorykey == null && other.productcategorykey != null) || (this.productcategorykey != null && !this.productcategorykey.equals(other.productcategorykey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimproductcategory[ productcategorykey=" + productcategorykey + " ]";
    }
    
}
