/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "FACTCURRENCYRATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factcurrencyrate.findAll", query = "SELECT f FROM Factcurrencyrate f"),
    @NamedQuery(name = "Factcurrencyrate.findByAveragerate", query = "SELECT f FROM Factcurrencyrate f WHERE f.averagerate = :averagerate"),
    @NamedQuery(name = "Factcurrencyrate.findByDate", query = "SELECT f FROM Factcurrencyrate f WHERE f.date = :date"),
    @NamedQuery(name = "Factcurrencyrate.findByEndofdayrate", query = "SELECT f FROM Factcurrencyrate f WHERE f.endofdayrate = :endofdayrate"),
    @NamedQuery(name = "Factcurrencyrate.findByDatekey", query = "SELECT f FROM Factcurrencyrate f WHERE f.factcurrencyratePK.datekey = :datekey"),
    @NamedQuery(name = "Factcurrencyrate.findByCurrencykey", query = "SELECT f FROM Factcurrencyrate f WHERE f.factcurrencyratePK.currencykey = :currencykey")})
public class Factcurrencyrate implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactcurrencyratePK factcurrencyratePK;
    @Basic(optional = false)
    @Column(name = "AVERAGERATE")
    private double averagerate;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "ENDOFDAYRATE")
    private double endofdayrate;
    @JoinColumn(name = "CURRENCYKEY", referencedColumnName = "CURRENCYKEY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dimcurrency dimcurrency;
    @JoinColumn(name = "DATEKEY", referencedColumnName = "DATEKEY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dimdate dimdate;

    public Factcurrencyrate() {
    }

    public Factcurrencyrate(FactcurrencyratePK factcurrencyratePK) {
        this.factcurrencyratePK = factcurrencyratePK;
    }

    public Factcurrencyrate(FactcurrencyratePK factcurrencyratePK, double averagerate, double endofdayrate) {
        this.factcurrencyratePK = factcurrencyratePK;
        this.averagerate = averagerate;
        this.endofdayrate = endofdayrate;
    }

    public Factcurrencyrate(int datekey, int currencykey) {
        this.factcurrencyratePK = new FactcurrencyratePK(datekey, currencykey);
    }

    public FactcurrencyratePK getFactcurrencyratePK() {
        return factcurrencyratePK;
    }

    public void setFactcurrencyratePK(FactcurrencyratePK factcurrencyratePK) {
        this.factcurrencyratePK = factcurrencyratePK;
    }

    public double getAveragerate() {
        return averagerate;
    }

    public void setAveragerate(double averagerate) {
        this.averagerate = averagerate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getEndofdayrate() {
        return endofdayrate;
    }

    public void setEndofdayrate(double endofdayrate) {
        this.endofdayrate = endofdayrate;
    }

    public Dimcurrency getDimcurrency() {
        return dimcurrency;
    }

    public void setDimcurrency(Dimcurrency dimcurrency) {
        this.dimcurrency = dimcurrency;
    }

    public Dimdate getDimdate() {
        return dimdate;
    }

    public void setDimdate(Dimdate dimdate) {
        this.dimdate = dimdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factcurrencyratePK != null ? factcurrencyratePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factcurrencyrate)) {
            return false;
        }
        Factcurrencyrate other = (Factcurrencyrate) object;
        if ((this.factcurrencyratePK == null && other.factcurrencyratePK != null) || (this.factcurrencyratePK != null && !this.factcurrencyratePK.equals(other.factcurrencyratePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factcurrencyrate[ factcurrencyratePK=" + factcurrencyratePK + " ]";
    }
    
}
