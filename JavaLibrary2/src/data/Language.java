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
@Table(name = "LANGUAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
    @NamedQuery(name = "Language.findById", query = "SELECT l FROM Language l WHERE l.id = :id"),
    @NamedQuery(name = "Language.findByCode", query = "SELECT l FROM Language l WHERE l.code = :code"),
    @NamedQuery(name = "Language.findByIconfilename", query = "SELECT l FROM Language l WHERE l.iconfilename = :iconfilename"),
    @NamedQuery(name = "Language.findByIsdefault", query = "SELECT l FROM Language l WHERE l.isdefault = :isdefault"),
    @NamedQuery(name = "Language.findByIsrighttoleft", query = "SELECT l FROM Language l WHERE l.isrighttoleft = :isrighttoleft"),
    @NamedQuery(name = "Language.findByIssuspended", query = "SELECT l FROM Language l WHERE l.issuspended = :issuspended"),
    @NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name = :name"),
    @NamedQuery(name = "Language.findByNativename", query = "SELECT l FROM Language l WHERE l.nativename = :nativename"),
    @NamedQuery(name = "Language.findByUseslatinalphabet", query = "SELECT l FROM Language l WHERE l.useslatinalphabet = :useslatinalphabet")})
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "ICONFILENAME")
    private String iconfilename;
    @Column(name = "ISDEFAULT")
    private Short isdefault;
    @Column(name = "ISRIGHTTOLEFT")
    private Short isrighttoleft;
    @Column(name = "ISSUSPENDED")
    private Short issuspended;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NATIVENAME")
    private String nativename;
    @Column(name = "USESLATINALPHABET")
    private Short useslatinalphabet;
    @JoinTable(name = "USEREDITLANGUAGE", joinColumns = {
        @JoinColumn(name = "LANGUAGEID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Assetbankuser> assetbankuserCollection;
    @OneToMany(mappedBy = "languageid")
    private Collection<Assetbankuser> assetbankuserCollection1;

    public Language() {
    }

    public Language(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIconfilename() {
        return iconfilename;
    }

    public void setIconfilename(String iconfilename) {
        this.iconfilename = iconfilename;
    }

    public Short getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Short isdefault) {
        this.isdefault = isdefault;
    }

    public Short getIsrighttoleft() {
        return isrighttoleft;
    }

    public void setIsrighttoleft(Short isrighttoleft) {
        this.isrighttoleft = isrighttoleft;
    }

    public Short getIssuspended() {
        return issuspended;
    }

    public void setIssuspended(Short issuspended) {
        this.issuspended = issuspended;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativename() {
        return nativename;
    }

    public void setNativename(String nativename) {
        this.nativename = nativename;
    }

    public Short getUseslatinalphabet() {
        return useslatinalphabet;
    }

    public void setUseslatinalphabet(Short useslatinalphabet) {
        this.useslatinalphabet = useslatinalphabet;
    }

    @XmlTransient
    public Collection<Assetbankuser> getAssetbankuserCollection() {
        return assetbankuserCollection;
    }

    public void setAssetbankuserCollection(Collection<Assetbankuser> assetbankuserCollection) {
        this.assetbankuserCollection = assetbankuserCollection;
    }

    @XmlTransient
    public Collection<Assetbankuser> getAssetbankuserCollection1() {
        return assetbankuserCollection1;
    }

    public void setAssetbankuserCollection1(Collection<Assetbankuser> assetbankuserCollection1) {
        this.assetbankuserCollection1 = assetbankuserCollection1;
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
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Language[ id=" + id + " ]";
    }
    
}
