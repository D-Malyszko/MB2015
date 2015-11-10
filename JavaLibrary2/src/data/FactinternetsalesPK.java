/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author admin
 */
@Embeddable
public class FactinternetsalesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "SALESORDERNUMBER")
    private String salesordernumber;
    @Basic(optional = false)
    @Column(name = "SALESORDERLINENUMBER")
    private short salesorderlinenumber;

    public FactinternetsalesPK() {
    }

    public FactinternetsalesPK(String salesordernumber, short salesorderlinenumber) {
        this.salesordernumber = salesordernumber;
        this.salesorderlinenumber = salesorderlinenumber;
    }

    public String getSalesordernumber() {
        return salesordernumber;
    }

    public void setSalesordernumber(String salesordernumber) {
        this.salesordernumber = salesordernumber;
    }

    public short getSalesorderlinenumber() {
        return salesorderlinenumber;
    }

    public void setSalesorderlinenumber(short salesorderlinenumber) {
        this.salesorderlinenumber = salesorderlinenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesordernumber != null ? salesordernumber.hashCode() : 0);
        hash += (int) salesorderlinenumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactinternetsalesPK)) {
            return false;
        }
        FactinternetsalesPK other = (FactinternetsalesPK) object;
        if ((this.salesordernumber == null && other.salesordernumber != null) || (this.salesordernumber != null && !this.salesordernumber.equals(other.salesordernumber))) {
            return false;
        }
        if (this.salesorderlinenumber != other.salesorderlinenumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FactinternetsalesPK[ salesordernumber=" + salesordernumber + ", salesorderlinenumber=" + salesorderlinenumber + " ]";
    }
    
}
