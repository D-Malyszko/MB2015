/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "DIMSALESTERRITORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimsalesterritory.findAll", query = "SELECT d FROM Dimsalesterritory d"),
    @NamedQuery(name = "Dimsalesterritory.findBySalesterritorykey", query = "SELECT d FROM Dimsalesterritory d WHERE d.salesterritorykey = :salesterritorykey"),
    @NamedQuery(name = "Dimsalesterritory.findBySalesterritoryalternatekey", query = "SELECT d FROM Dimsalesterritory d WHERE d.salesterritoryalternatekey = :salesterritoryalternatekey"),
    @NamedQuery(name = "Dimsalesterritory.findBySalesterritorycountry", query = "SELECT d FROM Dimsalesterritory d WHERE d.salesterritorycountry = :salesterritorycountry"),
    @NamedQuery(name = "Dimsalesterritory.findBySalesterritorygroup", query = "SELECT d FROM Dimsalesterritory d WHERE d.salesterritorygroup = :salesterritorygroup"),
    @NamedQuery(name = "Dimsalesterritory.findBySalesterritoryregion", query = "SELECT d FROM Dimsalesterritory d WHERE d.salesterritoryregion = :salesterritoryregion")})
public class Dimsalesterritory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SALESTERRITORYKEY")
    private Integer salesterritorykey;
    @Column(name = "SALESTERRITORYALTERNATEKEY")
    private Integer salesterritoryalternatekey;
    @Basic(optional = false)
    @Column(name = "SALESTERRITORYCOUNTRY")
    private String salesterritorycountry;
    @Column(name = "SALESTERRITORYGROUP")
    private String salesterritorygroup;
    @Lob
    @Column(name = "SALESTERRITORYIMAGE")
    private Serializable salesterritoryimage;
    @Basic(optional = false)
    @Column(name = "SALESTERRITORYREGION")
    private String salesterritoryregion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesterritorykey")
    private Collection<Factinternetsales> factinternetsalesCollection;
    @OneToMany(mappedBy = "salesterritorykey")
    private Collection<Dimemployee> dimemployeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesterritorykey")
    private Collection<Factresellersales> factresellersalesCollection;
    @OneToMany(mappedBy = "salesterritorykey")
    private Collection<Dimgeography> dimgeographyCollection;

    public Dimsalesterritory() {
    }

    public Dimsalesterritory(Integer salesterritorykey) {
        this.salesterritorykey = salesterritorykey;
    }

    public Dimsalesterritory(Integer salesterritorykey, String salesterritorycountry, String salesterritoryregion) {
        this.salesterritorykey = salesterritorykey;
        this.salesterritorycountry = salesterritorycountry;
        this.salesterritoryregion = salesterritoryregion;
    }

    public Integer getSalesterritorykey() {
        return salesterritorykey;
    }

    public void setSalesterritorykey(Integer salesterritorykey) {
        this.salesterritorykey = salesterritorykey;
    }

    public Integer getSalesterritoryalternatekey() {
        return salesterritoryalternatekey;
    }

    public void setSalesterritoryalternatekey(Integer salesterritoryalternatekey) {
        this.salesterritoryalternatekey = salesterritoryalternatekey;
    }

    public String getSalesterritorycountry() {
        return salesterritorycountry;
    }

    public void setSalesterritorycountry(String salesterritorycountry) {
        this.salesterritorycountry = salesterritorycountry;
    }

    public String getSalesterritorygroup() {
        return salesterritorygroup;
    }

    public void setSalesterritorygroup(String salesterritorygroup) {
        this.salesterritorygroup = salesterritorygroup;
    }

    public Serializable getSalesterritoryimage() {
        return salesterritoryimage;
    }

    public void setSalesterritoryimage(Serializable salesterritoryimage) {
        this.salesterritoryimage = salesterritoryimage;
    }

    public String getSalesterritoryregion() {
        return salesterritoryregion;
    }

    public void setSalesterritoryregion(String salesterritoryregion) {
        this.salesterritoryregion = salesterritoryregion;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
    }

    @XmlTransient
    public Collection<Dimemployee> getDimemployeeCollection() {
        return dimemployeeCollection;
    }

    public void setDimemployeeCollection(Collection<Dimemployee> dimemployeeCollection) {
        this.dimemployeeCollection = dimemployeeCollection;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection() {
        return factresellersalesCollection;
    }

    public void setFactresellersalesCollection(Collection<Factresellersales> factresellersalesCollection) {
        this.factresellersalesCollection = factresellersalesCollection;
    }

    @XmlTransient
    public Collection<Dimgeography> getDimgeographyCollection() {
        return dimgeographyCollection;
    }

    public void setDimgeographyCollection(Collection<Dimgeography> dimgeographyCollection) {
        this.dimgeographyCollection = dimgeographyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesterritorykey != null ? salesterritorykey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimsalesterritory)) {
            return false;
        }
        Dimsalesterritory other = (Dimsalesterritory) object;
        if ((this.salesterritorykey == null && other.salesterritorykey != null) || (this.salesterritorykey != null && !this.salesterritorykey.equals(other.salesterritorykey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimsalesterritory[ salesterritorykey=" + salesterritorykey + " ]";
    }
    
}
