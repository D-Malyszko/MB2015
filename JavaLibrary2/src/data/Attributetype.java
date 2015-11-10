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
@Table(name = "ATTRIBUTETYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributetype.findAll", query = "SELECT a FROM Attributetype a"),
    @NamedQuery(name = "Attributetype.findById", query = "SELECT a FROM Attributetype a WHERE a.id = :id"),
    @NamedQuery(name = "Attributetype.findByName", query = "SELECT a FROM Attributetype a WHERE a.name = :name"),
    @NamedQuery(name = "Attributetype.findBySequencenumber", query = "SELECT a FROM Attributetype a WHERE a.sequencenumber = :sequencenumber")})
public class Attributetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCENUMBER")
    private Integer sequencenumber;
    @JoinColumn(name = "ATTRIBUTESTORAGETYPEID", referencedColumnName = "ID")
    @ManyToOne
    private Attributestoragetype attributestoragetypeid;
    @OneToMany(mappedBy = "attributetypeid")
    private Collection<Attribute> attributeCollection;

    public Attributetype() {
    }

    public Attributetype(Integer id) {
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

    public Integer getSequencenumber() {
        return sequencenumber;
    }

    public void setSequencenumber(Integer sequencenumber) {
        this.sequencenumber = sequencenumber;
    }

    public Attributestoragetype getAttributestoragetypeid() {
        return attributestoragetypeid;
    }

    public void setAttributestoragetypeid(Attributestoragetype attributestoragetypeid) {
        this.attributestoragetypeid = attributestoragetypeid;
    }

    @XmlTransient
    public Collection<Attribute> getAttributeCollection() {
        return attributeCollection;
    }

    public void setAttributeCollection(Collection<Attribute> attributeCollection) {
        this.attributeCollection = attributeCollection;
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
        if (!(object instanceof Attributetype)) {
            return false;
        }
        Attributetype other = (Attributetype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Attributetype[ id=" + id + " ]";
    }
    
}
