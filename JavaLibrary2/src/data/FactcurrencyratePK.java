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
public class FactcurrencyratePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATEKEY")
    private int datekey;
    @Basic(optional = false)
    @Column(name = "CURRENCYKEY")
    private int currencykey;

    public FactcurrencyratePK() {
    }

    public FactcurrencyratePK(int datekey, int currencykey) {
        this.datekey = datekey;
        this.currencykey = currencykey;
    }

    public int getDatekey() {
        return datekey;
    }

    public void setDatekey(int datekey) {
        this.datekey = datekey;
    }

    public int getCurrencykey() {
        return currencykey;
    }

    public void setCurrencykey(int currencykey) {
        this.currencykey = currencykey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) datekey;
        hash += (int) currencykey;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactcurrencyratePK)) {
            return false;
        }
        FactcurrencyratePK other = (FactcurrencyratePK) object;
        if (this.datekey != other.datekey) {
            return false;
        }
        if (this.currencykey != other.currencykey) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FactcurrencyratePK[ datekey=" + datekey + ", currencykey=" + currencykey + " ]";
    }
    
}
