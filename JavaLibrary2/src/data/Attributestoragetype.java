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
@Table(name = "ATTRIBUTESTORAGETYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributestoragetype.findAll", query = "SELECT a FROM Attributestoragetype a"),
    @NamedQuery(name = "Attributestoragetype.findById", query = "SELECT a FROM Attributestoragetype a WHERE a.id = :id"),
    @NamedQuery(name = "Attributestoragetype.findByName", query = "SELECT a FROM Attributestoragetype a WHERE a.name = :name")})
public class Attributestoragetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "attributestoragetypeid")
    private Collection<Attributetype> attributetypeCollection;

    public Attributestoragetype() {
    }

    public Attributestoragetype(Integer id) {
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
    public Collection<Attributetype> getAttributetypeCollection() {
        return attributetypeCollection;
    }

    public void setAttributetypeCollection(Collection<Attributetype> attributetypeCollection) {
        this.attributetypeCollection = attributetypeCollection;
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
        if (!(object instanceof Attributestoragetype)) {
            return false;
        }
        Attributestoragetype other = (Attributestoragetype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Attributestoragetype[ id=" + id + " ]";
    }
    
}
