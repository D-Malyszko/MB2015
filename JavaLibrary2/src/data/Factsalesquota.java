/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "FACTSALESQUOTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factsalesquota.findAll", query = "SELECT f FROM Factsalesquota f"),
    @NamedQuery(name = "Factsalesquota.findBySalesquotakey", query = "SELECT f FROM Factsalesquota f WHERE f.salesquotakey = :salesquotakey"),
    @NamedQuery(name = "Factsalesquota.findByCalendarquarter", query = "SELECT f FROM Factsalesquota f WHERE f.calendarquarter = :calendarquarter"),
    @NamedQuery(name = "Factsalesquota.findByCalendaryear", query = "SELECT f FROM Factsalesquota f WHERE f.calendaryear = :calendaryear"),
    @NamedQuery(name = "Factsalesquota.findByDate", query = "SELECT f FROM Factsalesquota f WHERE f.date = :date"),
    @NamedQuery(name = "Factsalesquota.findBySalesamountquota", query = "SELECT f FROM Factsalesquota f WHERE f.salesamountquota = :salesamountquota")})
public class Factsalesquota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SALESQUOTAKEY")
    private Integer salesquotakey;
    @Basic(optional = false)
    @Column(name = "CALENDARQUARTER")
    private short calendarquarter;
    @Basic(optional = false)
    @Column(name = "CALENDARYEAR")
    private short calendaryear;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SALESAMOUNTQUOTA")
    private BigDecimal salesamountquota;
    @JoinColumn(name = "DATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate datekey;
    @JoinColumn(name = "EMPLOYEEKEY", referencedColumnName = "EMPLOYEEKEY")
    @ManyToOne(optional = false)
    private Dimemployee employeekey;

    public Factsalesquota() {
    }

    public Factsalesquota(Integer salesquotakey) {
        this.salesquotakey = salesquotakey;
    }

    public Factsalesquota(Integer salesquotakey, short calendarquarter, short calendaryear, BigDecimal salesamountquota) {
        this.salesquotakey = salesquotakey;
        this.calendarquarter = calendarquarter;
        this.calendaryear = calendaryear;
        this.salesamountquota = salesamountquota;
    }

    public Integer getSalesquotakey() {
        return salesquotakey;
    }

    public void setSalesquotakey(Integer salesquotakey) {
        this.salesquotakey = salesquotakey;
    }

    public short getCalendarquarter() {
        return calendarquarter;
    }

    public void setCalendarquarter(short calendarquarter) {
        this.calendarquarter = calendarquarter;
    }

    public short getCalendaryear() {
        return calendaryear;
    }

    public void setCalendaryear(short calendaryear) {
        this.calendaryear = calendaryear;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getSalesamountquota() {
        return salesamountquota;
    }

    public void setSalesamountquota(BigDecimal salesamountquota) {
        this.salesamountquota = salesamountquota;
    }

    public Dimdate getDatekey() {
        return datekey;
    }

    public void setDatekey(Dimdate datekey) {
        this.datekey = datekey;
    }

    public Dimemployee getEmployeekey() {
        return employeekey;
    }

    public void setEmployeekey(Dimemployee employeekey) {
        this.employeekey = employeekey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesquotakey != null ? salesquotakey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factsalesquota)) {
            return false;
        }
        Factsalesquota other = (Factsalesquota) object;
        if ((this.salesquotakey == null && other.salesquotakey != null) || (this.salesquotakey != null && !this.salesquotakey.equals(other.salesquotakey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factsalesquota[ salesquotakey=" + salesquotakey + " ]";
    }
    
}
