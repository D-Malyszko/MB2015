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
public class FactproductinventoryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATEKEY")
    private int datekey;
    @Basic(optional = false)
    @Column(name = "PRODUCTKEY")
    private int productkey;

    public FactproductinventoryPK() {
    }

    public FactproductinventoryPK(int datekey, int productkey) {
        this.datekey = datekey;
        this.productkey = productkey;
    }

    public int getDatekey() {
        return datekey;
    }

    public void setDatekey(int datekey) {
        this.datekey = datekey;
    }

    public int getProductkey() {
        return productkey;
    }

    public void setProductkey(int productkey) {
        this.productkey = productkey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) datekey;
        hash += (int) productkey;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactproductinventoryPK)) {
            return false;
        }
        FactproductinventoryPK other = (FactproductinventoryPK) object;
        if (this.datekey != other.datekey) {
            return false;
        }
        if (this.productkey != other.productkey) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.FactproductinventoryPK[ datekey=" + datekey + ", productkey=" + productkey + " ]";
    }
    
}
