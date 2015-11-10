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
@Table(name = "BRAND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findById", query = "SELECT b FROM Brand b WHERE b.id = :id"),
    @NamedQuery(name = "Brand.findByCode", query = "SELECT b FROM Brand b WHERE b.code = :code"),
    @NamedQuery(name = "Brand.findByContentlistidentifier", query = "SELECT b FROM Brand b WHERE b.contentlistidentifier = :contentlistidentifier"),
    @NamedQuery(name = "Brand.findByCssfile", query = "SELECT b FROM Brand b WHERE b.cssfile = :cssfile"),
    @NamedQuery(name = "Brand.findByEmaildomains", query = "SELECT b FROM Brand b WHERE b.emaildomains = :emaildomains"),
    @NamedQuery(name = "Brand.findByLogoalt", query = "SELECT b FROM Brand b WHERE b.logoalt = :logoalt"),
    @NamedQuery(name = "Brand.findByLogofile", query = "SELECT b FROM Brand b WHERE b.logofile = :logofile"),
    @NamedQuery(name = "Brand.findByLogoheight", query = "SELECT b FROM Brand b WHERE b.logoheight = :logoheight"),
    @NamedQuery(name = "Brand.findByLogowidth", query = "SELECT b FROM Brand b WHERE b.logowidth = :logowidth"),
    @NamedQuery(name = "Brand.findByName", query = "SELECT b FROM Brand b WHERE b.name = :name")})
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "CONTENTLISTIDENTIFIER")
    private String contentlistidentifier;
    @Column(name = "CSSFILE")
    private String cssfile;
    @Column(name = "EMAILDOMAINS")
    private String emaildomains;
    @Column(name = "LOGOALT")
    private String logoalt;
    @Column(name = "LOGOFILE")
    private String logofile;
    @Column(name = "LOGOHEIGHT")
    private Integer logoheight;
    @Column(name = "LOGOWIDTH")
    private Integer logowidth;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "brandid")
    private Collection<Usergroup> usergroupCollection;

    public Brand() {
    }

    public Brand(Integer id) {
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

    public String getContentlistidentifier() {
        return contentlistidentifier;
    }

    public void setContentlistidentifier(String contentlistidentifier) {
        this.contentlistidentifier = contentlistidentifier;
    }

    public String getCssfile() {
        return cssfile;
    }

    public void setCssfile(String cssfile) {
        this.cssfile = cssfile;
    }

    public String getEmaildomains() {
        return emaildomains;
    }

    public void setEmaildomains(String emaildomains) {
        this.emaildomains = emaildomains;
    }

    public String getLogoalt() {
        return logoalt;
    }

    public void setLogoalt(String logoalt) {
        this.logoalt = logoalt;
    }

    public String getLogofile() {
        return logofile;
    }

    public void setLogofile(String logofile) {
        this.logofile = logofile;
    }

    public Integer getLogoheight() {
        return logoheight;
    }

    public void setLogoheight(Integer logoheight) {
        this.logoheight = logoheight;
    }

    public Integer getLogowidth() {
        return logowidth;
    }

    public void setLogowidth(Integer logowidth) {
        this.logowidth = logowidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection() {
        return usergroupCollection;
    }

    public void setUsergroupCollection(Collection<Usergroup> usergroupCollection) {
        this.usergroupCollection = usergroupCollection;
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
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Brand[ id=" + id + " ]";
    }
    
}
