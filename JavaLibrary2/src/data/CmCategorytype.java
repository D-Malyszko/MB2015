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
@Table(name = "CM_CATEGORYTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmCategorytype.findAll", query = "SELECT c FROM CmCategorytype c"),
    @NamedQuery(name = "CmCategorytype.findById", query = "SELECT c FROM CmCategorytype c WHERE c.id = :id"),
    @NamedQuery(name = "CmCategorytype.findByDescription", query = "SELECT c FROM CmCategorytype c WHERE c.description = :description"),
    @NamedQuery(name = "CmCategorytype.findByIsalphabeticorder", query = "SELECT c FROM CmCategorytype c WHERE c.isalphabeticorder = :isalphabeticorder"),
    @NamedQuery(name = "CmCategorytype.findByIsnamegloballyunique", query = "SELECT c FROM CmCategorytype c WHERE c.isnamegloballyunique = :isnamegloballyunique")})
public class CmCategorytype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ISALPHABETICORDER")
    private Short isalphabeticorder;
    @Column(name = "ISNAMEGLOBALLYUNIQUE")
    private Short isnamegloballyunique;
    @OneToMany(mappedBy = "categorytypeid")
    private Collection<CmCategory> cmCategoryCollection;

    public CmCategorytype() {
    }

    public CmCategorytype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getIsalphabeticorder() {
        return isalphabeticorder;
    }

    public void setIsalphabeticorder(Short isalphabeticorder) {
        this.isalphabeticorder = isalphabeticorder;
    }

    public Short getIsnamegloballyunique() {
        return isnamegloballyunique;
    }

    public void setIsnamegloballyunique(Short isnamegloballyunique) {
        this.isnamegloballyunique = isnamegloballyunique;
    }

    @XmlTransient
    public Collection<CmCategory> getCmCategoryCollection() {
        return cmCategoryCollection;
    }

    public void setCmCategoryCollection(Collection<CmCategory> cmCategoryCollection) {
        this.cmCategoryCollection = cmCategoryCollection;
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
        if (!(object instanceof CmCategorytype)) {
            return false;
        }
        CmCategorytype other = (CmCategorytype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.CmCategorytype[ id=" + id + " ]";
    }
    
}
