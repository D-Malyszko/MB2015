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
@Table(name = "DIMCURRENCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimcurrency.findAll", query = "SELECT d FROM Dimcurrency d"),
    @NamedQuery(name = "Dimcurrency.findByCurrencykey", query = "SELECT d FROM Dimcurrency d WHERE d.currencykey = :currencykey"),
    @NamedQuery(name = "Dimcurrency.findByCurrencyalternatekey", query = "SELECT d FROM Dimcurrency d WHERE d.currencyalternatekey = :currencyalternatekey"),
    @NamedQuery(name = "Dimcurrency.findByCurrencyname", query = "SELECT d FROM Dimcurrency d WHERE d.currencyname = :currencyname")})
public class Dimcurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CURRENCYKEY")
    private Integer currencykey;
    @Basic(optional = false)
    @Column(name = "CURRENCYALTERNATEKEY")
    private String currencyalternatekey;
    @Basic(optional = false)
    @Column(name = "CURRENCYNAME")
    private String currencyname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencykey")
    private Collection<Factinternetsales> factinternetsalesCollection;
    @OneToMany(mappedBy = "currencykey")
    private Collection<Dimorganization> dimorganizationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencykey")
    private Collection<Factresellersales> factresellersalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimcurrency")
    private Collection<Factcurrencyrate> factcurrencyrateCollection;

    public Dimcurrency() {
    }

    public Dimcurrency(Integer currencykey) {
        this.currencykey = currencykey;
    }

    public Dimcurrency(Integer currencykey, String currencyalternatekey, String currencyname) {
        this.currencykey = currencykey;
        this.currencyalternatekey = currencyalternatekey;
        this.currencyname = currencyname;
    }

    public Integer getCurrencykey() {
        return currencykey;
    }

    public void setCurrencykey(Integer currencykey) {
        this.currencykey = currencykey;
    }

    public String getCurrencyalternatekey() {
        return currencyalternatekey;
    }

    public void setCurrencyalternatekey(String currencyalternatekey) {
        this.currencyalternatekey = currencyalternatekey;
    }

    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
    }

    @XmlTransient
    public Collection<Dimorganization> getDimorganizationCollection() {
        return dimorganizationCollection;
    }

    public void setDimorganizationCollection(Collection<Dimorganization> dimorganizationCollection) {
        this.dimorganizationCollection = dimorganizationCollection;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection() {
        return factresellersalesCollection;
    }

    public void setFactresellersalesCollection(Collection<Factresellersales> factresellersalesCollection) {
        this.factresellersalesCollection = factresellersalesCollection;
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
        hash += (currencykey != null ? currencykey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimcurrency)) {
            return false;
        }
        Dimcurrency other = (Dimcurrency) object;
        if ((this.currencykey == null && other.currencykey != null) || (this.currencykey != null && !this.currencykey.equals(other.currencykey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimcurrency[ currencykey=" + currencykey + " ]";
    }
    
}
