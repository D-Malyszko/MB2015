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
@Table(name = "ASSETTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assettype.findAll", query = "SELECT a FROM Assettype a"),
    @NamedQuery(name = "Assettype.findById", query = "SELECT a FROM Assettype a WHERE a.id = :id"),
    @NamedQuery(name = "Assettype.findByName", query = "SELECT a FROM Assettype a WHERE a.name = :name")})
public class Assettype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @JoinTable(name = "ALLOWABLEENTITYASSETTYPE", joinColumns = {
        @JoinColumn(name = "ASSETTYPEID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ASSETENTITYID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Assetentity> assetentityCollection;
    @OneToMany(mappedBy = "assettypeid")
    private Collection<Fileformat> fileformatCollection;
    @OneToMany(mappedBy = "assettypeid")
    private Collection<Asset> assetCollection;

    public Assettype() {
    }

    public Assettype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Assetentity> getAssetentityCollection() {
        return assetentityCollection;
    }

    public void setAssetentityCollection(Collection<Assetentity> assetentityCollection) {
        this.assetentityCollection = assetentityCollection;
    }

    @XmlTransient
    public Collection<Fileformat> getFileformatCollection() {
        return fileformatCollection;
    }

    public void setFileformatCollection(Collection<Fileformat> fileformatCollection) {
        this.fileformatCollection = fileformatCollection;
    }

    @XmlTransient
    public Collection<Asset> getAssetCollection() {
        return assetCollection;
    }

    public void setAssetCollection(Collection<Asset> assetCollection) {
        this.assetCollection = assetCollection;
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
        if (!(object instanceof Assettype)) {
            return false;
        }
        Assettype other = (Assettype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Assettype[ id=" + id + " ]";
    }
    
}
