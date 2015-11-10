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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "DIMSALESREASON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimsalesreason.findAll", query = "SELECT d FROM Dimsalesreason d"),
    @NamedQuery(name = "Dimsalesreason.findBySalesreasonkey", query = "SELECT d FROM Dimsalesreason d WHERE d.salesreasonkey = :salesreasonkey"),
    @NamedQuery(name = "Dimsalesreason.findBySalesreasonalternatekey", query = "SELECT d FROM Dimsalesreason d WHERE d.salesreasonalternatekey = :salesreasonalternatekey"),
    @NamedQuery(name = "Dimsalesreason.findBySalesreasonname", query = "SELECT d FROM Dimsalesreason d WHERE d.salesreasonname = :salesreasonname"),
    @NamedQuery(name = "Dimsalesreason.findBySalesreasonreasontype", query = "SELECT d FROM Dimsalesreason d WHERE d.salesreasonreasontype = :salesreasonreasontype")})
public class Dimsalesreason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SALESREASONKEY")
    private Integer salesreasonkey;
    @Basic(optional = false)
    @Column(name = "SALESREASONALTERNATEKEY")
    private int salesreasonalternatekey;
    @Basic(optional = false)
    @Column(name = "SALESREASONNAME")
    private String salesreasonname;
    @Basic(optional = false)
    @Column(name = "SALESREASONREASONTYPE")
    private String salesreasonreasontype;
    @JoinTable(name = "FACTINTERNETSALESREASON", joinColumns = {
        @JoinColumn(name = "SALESREASONKEY", referencedColumnName = "SALESREASONKEY")}, inverseJoinColumns = {
        @JoinColumn(name = "SALESORDERNUMBER", referencedColumnName = "SALESORDERNUMBER"),
        @JoinColumn(name = "SALESORDERLINENUMBER", referencedColumnName = "SALESORDERLINENUMBER")})
    @ManyToMany
    private Collection<Factinternetsales> factinternetsalesCollection;

    public Dimsalesreason() {
    }

    public Dimsalesreason(Integer salesreasonkey) {
        this.salesreasonkey = salesreasonkey;
    }

    public Dimsalesreason(Integer salesreasonkey, int salesreasonalternatekey, String salesreasonname, String salesreasonreasontype) {
        this.salesreasonkey = salesreasonkey;
        this.salesreasonalternatekey = salesreasonalternatekey;
        this.salesreasonname = salesreasonname;
        this.salesreasonreasontype = salesreasonreasontype;
    }

    public Integer getSalesreasonkey() {
        return salesreasonkey;
    }

    public void setSalesreasonkey(Integer salesreasonkey) {
        this.salesreasonkey = salesreasonkey;
    }

    public int getSalesreasonalternatekey() {
        return salesreasonalternatekey;
    }

    public void setSalesreasonalternatekey(int salesreasonalternatekey) {
        this.salesreasonalternatekey = salesreasonalternatekey;
    }

    public String getSalesreasonname() {
        return salesreasonname;
    }

    public void setSalesreasonname(String salesreasonname) {
        this.salesreasonname = salesreasonname;
    }

    public String getSalesreasonreasontype() {
        return salesreasonreasontype;
    }

    public void setSalesreasonreasontype(String salesreasonreasontype) {
        this.salesreasonreasontype = salesreasonreasontype;
    }

    @XmlTransient
    public Collection<Factinternetsales> getFactinternetsalesCollection() {
        return factinternetsalesCollection;
    }

    public void setFactinternetsalesCollection(Collection<Factinternetsales> factinternetsalesCollection) {
        this.factinternetsalesCollection = factinternetsalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesreasonkey != null ? salesreasonkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimsalesreason)) {
            return false;
        }
        Dimsalesreason other = (Dimsalesreason) object;
        if ((this.salesreasonkey == null && other.salesreasonkey != null) || (this.salesreasonkey != null && !this.salesreasonkey.equals(other.salesreasonkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimsalesreason[ salesreasonkey=" + salesreasonkey + " ]";
    }
    
}
