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
@Table(name = "ORGUNIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orgunit.findAll", query = "SELECT o FROM Orgunit o"),
    @NamedQuery(name = "Orgunit.findById", query = "SELECT o FROM Orgunit o WHERE o.id = :id"),
    @NamedQuery(name = "Orgunit.findByDiskquotamb", query = "SELECT o FROM Orgunit o WHERE o.diskquotamb = :diskquotamb"),
    @NamedQuery(name = "Orgunit.findByNotes", query = "SELECT o FROM Orgunit o WHERE o.notes = :notes")})
public class Orgunit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DISKQUOTAMB")
    private Integer diskquotamb;
    @Column(name = "NOTES")
    private String notes;
    @JoinTable(name = "ORGUNITGROUP", joinColumns = {
        @JoinColumn(name = "ORGUNITID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERGROUPID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usergroup> usergroupCollection;
    @JoinColumn(name = "ROOTORGUNITCATEGORYID", referencedColumnName = "ID")
    @ManyToOne
    private CmCategory rootorgunitcategoryid;
    @JoinColumn(name = "ROOTDESCRIPTIVECATEGORYID", referencedColumnName = "ID")
    @ManyToOne
    private CmCategory rootdescriptivecategoryid;
    @JoinColumn(name = "ADMINGROUPID", referencedColumnName = "ID")
    @ManyToOne
    private Usergroup admingroupid;
    @JoinColumn(name = "STANDARDGROUPID", referencedColumnName = "ID")
    @ManyToOne
    private Usergroup standardgroupid;
    @OneToMany(mappedBy = "requestedorgunitid")
    private Collection<Assetbankuser> assetbankuserCollection;

    public Orgunit() {
    }

    public Orgunit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiskquotamb() {
        return diskquotamb;
    }

    public void setDiskquotamb(Integer diskquotamb) {
        this.diskquotamb = diskquotamb;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection() {
        return usergroupCollection;
    }

    public void setUsergroupCollection(Collection<Usergroup> usergroupCollection) {
        this.usergroupCollection = usergroupCollection;
    }

    public CmCategory getRootorgunitcategoryid() {
        return rootorgunitcategoryid;
    }

    public void setRootorgunitcategoryid(CmCategory rootorgunitcategoryid) {
        this.rootorgunitcategoryid = rootorgunitcategoryid;
    }

    public CmCategory getRootdescriptivecategoryid() {
        return rootdescriptivecategoryid;
    }

    public void setRootdescriptivecategoryid(CmCategory rootdescriptivecategoryid) {
        this.rootdescriptivecategoryid = rootdescriptivecategoryid;
    }

    public Usergroup getAdmingroupid() {
        return admingroupid;
    }

    public void setAdmingroupid(Usergroup admingroupid) {
        this.admingroupid = admingroupid;
    }

    public Usergroup getStandardgroupid() {
        return standardgroupid;
    }

    public void setStandardgroupid(Usergroup standardgroupid) {
        this.standardgroupid = standardgroupid;
    }

    @XmlTransient
    public Collection<Assetbankuser> getAssetbankuserCollection() {
        return assetbankuserCollection;
    }

    public void setAssetbankuserCollection(Collection<Assetbankuser> assetbankuserCollection) {
        this.assetbankuserCollection = assetbankuserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orgunit)) {
            return false;
        }
        Orgunit other = (Orgunit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Orgunit[ id=" + id + " ]";
    }
    
}
