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
@Table(name = "DIMORGANIZATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimorganization.findAll", query = "SELECT d FROM Dimorganization d"),
    @NamedQuery(name = "Dimorganization.findByOrganizationkey", query = "SELECT d FROM Dimorganization d WHERE d.organizationkey = :organizationkey"),
    @NamedQuery(name = "Dimorganization.findByOrganizationname", query = "SELECT d FROM Dimorganization d WHERE d.organizationname = :organizationname"),
    @NamedQuery(name = "Dimorganization.findByPercentageofownership", query = "SELECT d FROM Dimorganization d WHERE d.percentageofownership = :percentageofownership")})
public class Dimorganization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORGANIZATIONKEY")
    private Integer organizationkey;
    @Column(name = "ORGANIZATIONNAME")
    private String organizationname;
    @Column(name = "PERCENTAGEOFOWNERSHIP")
    private String percentageofownership;
    @JoinColumn(name = "CURRENCYKEY", referencedColumnName = "CURRENCYKEY")
    @ManyToOne
    private Dimcurrency currencykey;
    @OneToMany(mappedBy = "parentorganizationkey")
    private Collection<Dimorganization> dimorganizationCollection;
    @JoinColumn(name = "PARENTORGANIZATIONKEY", referencedColumnName = "ORGANIZATIONKEY")
    @ManyToOne
    private Dimorganization parentorganizationkey;

    public Dimorganization() {
    }

    public Dimorganization(Integer organizationkey) {
        this.organizationkey = organizationkey;
    }

    public Integer getOrganizationkey() {
        return organizationkey;
    }

    public void setOrganizationkey(Integer organizationkey) {
        this.organizationkey = organizationkey;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public String getPercentageofownership() {
        return percentageofownership;
    }

    public void setPercentageofownership(String percentageofownership) {
        this.percentageofownership = percentageofownership;
    }

    public Dimcurrency getCurrencykey() {
        return currencykey;
    }

    public void setCurrencykey(Dimcurrency currencykey) {
        this.currencykey = currencykey;
    }

    @XmlTransient
    public Collection<Dimorganization> getDimorganizationCollection() {
        return dimorganizationCollection;
    }

    public void setDimorganizationCollection(Collection<Dimorganization> dimorganizationCollection) {
        this.dimorganizationCollection = dimorganizationCollection;
    }

    public Dimorganization getParentorganizationkey() {
        return parentorganizationkey;
    }

    public void setParentorganizationkey(Dimorganization parentorganizationkey) {
        this.parentorganizationkey = parentorganizationkey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizationkey != null ? organizationkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimorganization)) {
            return false;
        }
        Dimorganization other = (Dimorganization) object;
        if ((this.organizationkey == null && other.organizationkey != null) || (this.organizationkey != null && !this.organizationkey.equals(other.organizationkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimorganization[ organizationkey=" + organizationkey + " ]";
    }
    
}
