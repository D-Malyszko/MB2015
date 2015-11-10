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
@Table(name = "FACTPRODUCTINVENTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factproductinventory.findAll", query = "SELECT f FROM Factproductinventory f"),
    @NamedQuery(name = "Factproductinventory.findByMovementdate", query = "SELECT f FROM Factproductinventory f WHERE f.movementdate = :movementdate"),
    @NamedQuery(name = "Factproductinventory.findByUnitcost", query = "SELECT f FROM Factproductinventory f WHERE f.unitcost = :unitcost"),
    @NamedQuery(name = "Factproductinventory.findByUnitsbalance", query = "SELECT f FROM Factproductinventory f WHERE f.unitsbalance = :unitsbalance"),
    @NamedQuery(name = "Factproductinventory.findByUnitsin", query = "SELECT f FROM Factproductinventory f WHERE f.unitsin = :unitsin"),
    @NamedQuery(name = "Factproductinventory.findByUnitsout", query = "SELECT f FROM Factproductinventory f WHERE f.unitsout = :unitsout"),
    @NamedQuery(name = "Factproductinventory.findByDatekey", query = "SELECT f FROM Factproductinventory f WHERE f.factproductinventoryPK.datekey = :datekey"),
    @NamedQuery(name = "Factproductinventory.findByProductkey", query = "SELECT f FROM Factproductinventory f WHERE f.factproductinventoryPK.productkey = :productkey")})
public class Factproductinventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactproductinventoryPK factproductinventoryPK;
    @Basic(optional = false)
    @Column(name = "MOVEMENTDATE")
    @Temporal(TemporalType.DATE)
    private Date movementdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "UNITCOST")
    private BigDecimal unitcost;
    @Basic(optional = false)
    @Column(name = "UNITSBALANCE")
    private int unitsbalance;
    @Basic(optional = false)
    @Column(name = "UNITSIN")
    private int unitsin;
    @Basic(optional = false)
    @Column(name = "UNITSOUT")
    private int unitsout;
    @JoinColumn(name = "DATEKEY", referencedColumnName = "DATEKEY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dimdate dimdate;
    @JoinColumn(name = "PRODUCTKEY", referencedColumnName = "PRODUCTKEY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dimproduct dimproduct;

    public Factproductinventory() {
    }

    public Factproductinventory(FactproductinventoryPK factproductinventoryPK) {
        this.factproductinventoryPK = factproductinventoryPK;
    }

    public Factproductinventory(FactproductinventoryPK factproductinventoryPK, Date movementdate, BigDecimal unitcost, int unitsbalance, int unitsin, int unitsout) {
        this.factproductinventoryPK = factproductinventoryPK;
        this.movementdate = movementdate;
        this.unitcost = unitcost;
        this.unitsbalance = unitsbalance;
        this.unitsin = unitsin;
        this.unitsout = unitsout;
    }

    public Factproductinventory(int datekey, int productkey) {
        this.factproductinventoryPK = new FactproductinventoryPK(datekey, productkey);
    }

    public FactproductinventoryPK getFactproductinventoryPK() {
        return factproductinventoryPK;
    }

    public void setFactproductinventoryPK(FactproductinventoryPK factproductinventoryPK) {
        this.factproductinventoryPK = factproductinventoryPK;
    }

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public int getUnitsbalance() {
        return unitsbalance;
    }

    public void setUnitsbalance(int unitsbalance) {
        this.unitsbalance = unitsbalance;
    }

    public int getUnitsin() {
        return unitsin;
    }

    public void setUnitsin(int unitsin) {
        this.unitsin = unitsin;
    }

    public int getUnitsout() {
        return unitsout;
    }

    public void setUnitsout(int unitsout) {
        this.unitsout = unitsout;
    }

    public Dimdate getDimdate() {
        return dimdate;
    }

    public void setDimdate(Dimdate dimdate) {
        this.dimdate = dimdate;
    }

    public Dimproduct getDimproduct() {
        return dimproduct;
    }

    public void setDimproduct(Dimproduct dimproduct) {
        this.dimproduct = dimproduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factproductinventoryPK != null ? factproductinventoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factproductinventory)) {
            return false;
        }
        Factproductinventory other = (Factproductinventory) object;
        if ((this.factproductinventoryPK == null && other.factproductinventoryPK != null) || (this.factproductinventoryPK != null && !this.factproductinventoryPK.equals(other.factproductinventoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factproductinventory[ factproductinventoryPK=" + factproductinventoryPK + " ]";
    }
    
}
