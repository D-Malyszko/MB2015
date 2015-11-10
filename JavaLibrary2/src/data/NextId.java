/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "NEXT_ID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NextId.findAll", query = "SELECT n FROM NextId n"),
    @NamedQuery(name = "NextId.findByBeanname", query = "SELECT n FROM NextId n WHERE n.beanname = :beanname"),
    @NamedQuery(name = "NextId.findById", query = "SELECT n FROM NextId n WHERE n.id = :id")})
public class NextId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BEANNAME")
    private String beanname;
    @Column(name = "ID")
    private BigInteger id;

    public NextId() {
    }

    public NextId(String beanname) {
        this.beanname = beanname;
    }

    public String getBeanname() {
        return beanname;
    }

    public void setBeanname(String beanname) {
        this.beanname = beanname;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beanname != null ? beanname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NextId)) {
            return false;
        }
        NextId other = (NextId) object;
        if ((this.beanname == null && other.beanname != null) || (this.beanname != null && !this.beanname.equals(other.beanname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.NextId[ beanname=" + beanname + " ]";
    }
    
}
