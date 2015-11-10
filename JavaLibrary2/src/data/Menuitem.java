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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "MENUITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuitem.findAll", query = "SELECT m FROM Menuitem m"),
    @NamedQuery(name = "Menuitem.findByItemidentifier", query = "SELECT m FROM Menuitem m WHERE m.itemidentifier = :itemidentifier"),
    @NamedQuery(name = "Menuitem.findByIshidden", query = "SELECT m FROM Menuitem m WHERE m.ishidden = :ishidden"),
    @NamedQuery(name = "Menuitem.findByIsopenedinnewwindow", query = "SELECT m FROM Menuitem m WHERE m.isopenedinnewwindow = :isopenedinnewwindow"),
    @NamedQuery(name = "Menuitem.findByItemcomment", query = "SELECT m FROM Menuitem m WHERE m.itemcomment = :itemcomment"),
    @NamedQuery(name = "Menuitem.findBySequencenumber", query = "SELECT m FROM Menuitem m WHERE m.sequencenumber = :sequencenumber")})
public class Menuitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ITEMIDENTIFIER")
    private String itemidentifier;
    @Column(name = "ISHIDDEN")
    private Short ishidden;
    @Column(name = "ISOPENEDINNEWWINDOW")
    private Short isopenedinnewwindow;
    @Column(name = "ITEMCOMMENT")
    private String itemcomment;
    @Column(name = "SEQUENCENUMBER")
    private Integer sequencenumber;
    @JoinTable(name = "MENUITEMHIDDENFROMGROUP", joinColumns = {
        @JoinColumn(name = "MENUITEMIDENTIFIER", referencedColumnName = "ITEMIDENTIFIER")}, inverseJoinColumns = {
        @JoinColumn(name = "USERGROUPID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usergroup> usergroupCollection;
    @OneToMany(mappedBy = "homepagemenuitemidentifier")
    private Collection<Usergroup> usergroupCollection1;

    public Menuitem() {
    }

    public Menuitem(String itemidentifier) {
        this.itemidentifier = itemidentifier;
    }

    public String getItemidentifier() {
        return itemidentifier;
    }

    public void setItemidentifier(String itemidentifier) {
        this.itemidentifier = itemidentifier;
    }

    public Short getIshidden() {
        return ishidden;
    }

    public void setIshidden(Short ishidden) {
        this.ishidden = ishidden;
    }

    public Short getIsopenedinnewwindow() {
        return isopenedinnewwindow;
    }

    public void setIsopenedinnewwindow(Short isopenedinnewwindow) {
        this.isopenedinnewwindow = isopenedinnewwindow;
    }

    public String getItemcomment() {
        return itemcomment;
    }

    public void setItemcomment(String itemcomment) {
        this.itemcomment = itemcomment;
    }

    public Integer getSequencenumber() {
        return sequencenumber;
    }

    public void setSequencenumber(Integer sequencenumber) {
        this.sequencenumber = sequencenumber;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection() {
        return usergroupCollection;
    }

    public void setUsergroupCollection(Collection<Usergroup> usergroupCollection) {
        this.usergroupCollection = usergroupCollection;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection1() {
        return usergroupCollection1;
    }

    public void setUsergroupCollection1(Collection<Usergroup> usergroupCollection1) {
        this.usergroupCollection1 = usergroupCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemidentifier != null ? itemidentifier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuitem)) {
            return false;
        }
        Menuitem other = (Menuitem) object;
        if ((this.itemidentifier == null && other.itemidentifier != null) || (this.itemidentifier != null && !this.itemidentifier.equals(other.itemidentifier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Menuitem[ itemidentifier=" + itemidentifier + " ]";
    }
    
}
