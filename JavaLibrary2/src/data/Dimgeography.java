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
@Table(name = "DIMGEOGRAPHY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimgeography.findAll", query = "SELECT d FROM Dimgeography d"),
    @NamedQuery(name = "Dimgeography.findByGeographykey", query = "SELECT d FROM Dimgeography d WHERE d.geographykey = :geographykey"),
    @NamedQuery(name = "Dimgeography.findByCity", query = "SELECT d FROM Dimgeography d WHERE d.city = :city"),
    @NamedQuery(name = "Dimgeography.findByCountryregioncode", query = "SELECT d FROM Dimgeography d WHERE d.countryregioncode = :countryregioncode"),
    @NamedQuery(name = "Dimgeography.findByEnglishcountryregionname", query = "SELECT d FROM Dimgeography d WHERE d.englishcountryregionname = :englishcountryregionname"),
    @NamedQuery(name = "Dimgeography.findByFrenchcountryregionname", query = "SELECT d FROM Dimgeography d WHERE d.frenchcountryregionname = :frenchcountryregionname"),
    @NamedQuery(name = "Dimgeography.findByIpaddresslocator", query = "SELECT d FROM Dimgeography d WHERE d.ipaddresslocator = :ipaddresslocator"),
    @NamedQuery(name = "Dimgeography.findByPostalcode", query = "SELECT d FROM Dimgeography d WHERE d.postalcode = :postalcode"),
    @NamedQuery(name = "Dimgeography.findBySpanishcountryregionname", query = "SELECT d FROM Dimgeography d WHERE d.spanishcountryregionname = :spanishcountryregionname"),
    @NamedQuery(name = "Dimgeography.findByStateprovincecode", query = "SELECT d FROM Dimgeography d WHERE d.stateprovincecode = :stateprovincecode"),
    @NamedQuery(name = "Dimgeography.findByStateprovincename", query = "SELECT d FROM Dimgeography d WHERE d.stateprovincename = :stateprovincename")})
public class Dimgeography implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GEOGRAPHYKEY")
    private Integer geographykey;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRYREGIONCODE")
    private String countryregioncode;
    @Column(name = "ENGLISHCOUNTRYREGIONNAME")
    private String englishcountryregionname;
    @Column(name = "FRENCHCOUNTRYREGIONNAME")
    private String frenchcountryregionname;
    @Column(name = "IPADDRESSLOCATOR")
    private String ipaddresslocator;
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Column(name = "SPANISHCOUNTRYREGIONNAME")
    private String spanishcountryregionname;
    @Column(name = "STATEPROVINCECODE")
    private String stateprovincecode;
    @Column(name = "STATEPROVINCENAME")
    private String stateprovincename;
    @OneToMany(mappedBy = "geographykey")
    private Collection<Dimcustomer> dimcustomerCollection;
    @OneToMany(mappedBy = "geographykey")
    private Collection<Dimreseller> dimresellerCollection;
    @JoinColumn(name = "SALESTERRITORYKEY", referencedColumnName = "SALESTERRITORYKEY")
    @ManyToOne
    private Dimsalesterritory salesterritorykey;

    public Dimgeography() {
    }

    public Dimgeography(Integer geographykey) {
        this.geographykey = geographykey;
    }

    public Integer getGeographykey() {
        return geographykey;
    }

    public void setGeographykey(Integer geographykey) {
        this.geographykey = geographykey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryregioncode() {
        return countryregioncode;
    }

    public void setCountryregioncode(String countryregioncode) {
        this.countryregioncode = countryregioncode;
    }

    public String getEnglishcountryregionname() {
        return englishcountryregionname;
    }

    public void setEnglishcountryregionname(String englishcountryregionname) {
        this.englishcountryregionname = englishcountryregionname;
    }

    public String getFrenchcountryregionname() {
        return frenchcountryregionname;
    }

    public void setFrenchcountryregionname(String frenchcountryregionname) {
        this.frenchcountryregionname = frenchcountryregionname;
    }

    public String getIpaddresslocator() {
        return ipaddresslocator;
    }

    public void setIpaddresslocator(String ipaddresslocator) {
        this.ipaddresslocator = ipaddresslocator;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getSpanishcountryregionname() {
        return spanishcountryregionname;
    }

    public void setSpanishcountryregionname(String spanishcountryregionname) {
        this.spanishcountryregionname = spanishcountryregionname;
    }

    public String getStateprovincecode() {
        return stateprovincecode;
    }

    public void setStateprovincecode(String stateprovincecode) {
        this.stateprovincecode = stateprovincecode;
    }

    public String getStateprovincename() {
        return stateprovincename;
    }

    public void setStateprovincename(String stateprovincename) {
        this.stateprovincename = stateprovincename;
    }

    @XmlTransient
    public Collection<Dimcustomer> getDimcustomerCollection() {
        return dimcustomerCollection;
    }

    public void setDimcustomerCollection(Collection<Dimcustomer> dimcustomerCollection) {
        this.dimcustomerCollection = dimcustomerCollection;
    }

    @XmlTransient
    public Collection<Dimreseller> getDimresellerCollection() {
        return dimresellerCollection;
    }

    public void setDimresellerCollection(Collection<Dimreseller> dimresellerCollection) {
        this.dimresellerCollection = dimresellerCollection;
    }

    public Dimsalesterritory getSalesterritorykey() {
        return salesterritorykey;
    }

    public void setSalesterritorykey(Dimsalesterritory salesterritorykey) {
        this.salesterritorykey = salesterritorykey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geographykey != null ? geographykey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimgeography)) {
            return false;
        }
        Dimgeography other = (Dimgeography) object;
        if ((this.geographykey == null && other.geographykey != null) || (this.geographykey != null && !this.geographykey.equals(other.geographykey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimgeography[ geographykey=" + geographykey + " ]";
    }
    
}
