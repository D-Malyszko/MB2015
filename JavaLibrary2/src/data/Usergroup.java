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
@Table(name = "USERGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergroup.findAll", query = "SELECT u FROM Usergroup u"),
    @NamedQuery(name = "Usergroup.findById", query = "SELECT u FROM Usergroup u WHERE u.id = :id"),
    @NamedQuery(name = "Usergroup.findByAdvancedviewing", query = "SELECT u FROM Usergroup u WHERE u.advancedviewing = :advancedviewing"),
    @NamedQuery(name = "Usergroup.findByAutomaticbrandregister", query = "SELECT u FROM Usergroup u WHERE u.automaticbrandregister = :automaticbrandregister"),
    @NamedQuery(name = "Usergroup.findByCanaddemptyassets", query = "SELECT u FROM Usergroup u WHERE u.canaddemptyassets = :canaddemptyassets"),
    @NamedQuery(name = "Usergroup.findByCanemailassets", query = "SELECT u FROM Usergroup u WHERE u.canemailassets = :canemailassets"),
    @NamedQuery(name = "Usergroup.findByCanexportassets", query = "SELECT u FROM Usergroup u WHERE u.canexportassets = :canexportassets"),
    @NamedQuery(name = "Usergroup.findByCaninviteusers", query = "SELECT u FROM Usergroup u WHERE u.caninviteusers = :caninviteusers"),
    @NamedQuery(name = "Usergroup.findByCanonlyeditown", query = "SELECT u FROM Usergroup u WHERE u.canonlyeditown = :canonlyeditown"),
    @NamedQuery(name = "Usergroup.findByCanpublishassetbox", query = "SELECT u FROM Usergroup u WHERE u.canpublishassetbox = :canpublishassetbox"),
    @NamedQuery(name = "Usergroup.findByCanrepurposeassets", query = "SELECT u FROM Usergroup u WHERE u.canrepurposeassets = :canrepurposeassets"),
    @NamedQuery(name = "Usergroup.findByCanseesourcepath", query = "SELECT u FROM Usergroup u WHERE u.canseesourcepath = :canseesourcepath"),
    @NamedQuery(name = "Usergroup.findByCanselectonregistration", query = "SELECT u FROM Usergroup u WHERE u.canselectonregistration = :canselectonregistration"),
    @NamedQuery(name = "Usergroup.findByCanviewlargersize", query = "SELECT u FROM Usergroup u WHERE u.canviewlargersize = :canviewlargersize"),
    @NamedQuery(name = "Usergroup.findByDescription", query = "SELECT u FROM Usergroup u WHERE u.description = :description"),
    @NamedQuery(name = "Usergroup.findByDiscountpercentage", query = "SELECT u FROM Usergroup u WHERE u.discountpercentage = :discountpercentage"),
    @NamedQuery(name = "Usergroup.findByDownloadlimit", query = "SELECT u FROM Usergroup u WHERE u.downloadlimit = :downloadlimit"),
    @NamedQuery(name = "Usergroup.findByDownloadlimitperiod", query = "SELECT u FROM Usergroup u WHERE u.downloadlimitperiod = :downloadlimitperiod"),
    @NamedQuery(name = "Usergroup.findByIpmapping", query = "SELECT u FROM Usergroup u WHERE u.ipmapping = :ipmapping"),
    @NamedQuery(name = "Usergroup.findByIsdefaultgroup", query = "SELECT u FROM Usergroup u WHERE u.isdefaultgroup = :isdefaultgroup"),
    @NamedQuery(name = "Usergroup.findByMapping", query = "SELECT u FROM Usergroup u WHERE u.mapping = :mapping"),
    @NamedQuery(name = "Usergroup.findByMaxdownloadheight", query = "SELECT u FROM Usergroup u WHERE u.maxdownloadheight = :maxdownloadheight"),
    @NamedQuery(name = "Usergroup.findByMaxdownloadwidth", query = "SELECT u FROM Usergroup u WHERE u.maxdownloadwidth = :maxdownloadwidth"),
    @NamedQuery(name = "Usergroup.findByName", query = "SELECT u FROM Usergroup u WHERE u.name = :name"),
    @NamedQuery(name = "Usergroup.findBySequencenumber", query = "SELECT u FROM Usergroup u WHERE u.sequencenumber = :sequencenumber"),
    @NamedQuery(name = "Usergroup.findByUrlmapping", query = "SELECT u FROM Usergroup u WHERE u.urlmapping = :urlmapping")})
public class Usergroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADVANCEDVIEWING")
    private Short advancedviewing;
    @Column(name = "AUTOMATICBRANDREGISTER")
    private Short automaticbrandregister;
    @Column(name = "CANADDEMPTYASSETS")
    private Short canaddemptyassets;
    @Column(name = "CANEMAILASSETS")
    private Short canemailassets;
    @Column(name = "CANEXPORTASSETS")
    private Short canexportassets;
    @Column(name = "CANINVITEUSERS")
    private Short caninviteusers;
    @Column(name = "CANONLYEDITOWN")
    private Short canonlyeditown;
    @Column(name = "CANPUBLISHASSETBOX")
    private Short canpublishassetbox;
    @Column(name = "CANREPURPOSEASSETS")
    private Short canrepurposeassets;
    @Column(name = "CANSEESOURCEPATH")
    private Short canseesourcepath;
    @Column(name = "CANSELECTONREGISTRATION")
    private Short canselectonregistration;
    @Column(name = "CANVIEWLARGERSIZE")
    private Short canviewlargersize;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DISCOUNTPERCENTAGE")
    private Integer discountpercentage;
    @Column(name = "DOWNLOADLIMIT")
    private Integer downloadlimit;
    @Column(name = "DOWNLOADLIMITPERIOD")
    private String downloadlimitperiod;
    @Column(name = "IPMAPPING")
    private String ipmapping;
    @Column(name = "ISDEFAULTGROUP")
    private Short isdefaultgroup;
    @Column(name = "MAPPING")
    private String mapping;
    @Column(name = "MAXDOWNLOADHEIGHT")
    private Integer maxdownloadheight;
    @Column(name = "MAXDOWNLOADWIDTH")
    private Integer maxdownloadwidth;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCENUMBER")
    private Integer sequencenumber;
    @Column(name = "URLMAPPING")
    private String urlmapping;
    @JoinTable(name = "USERINGROUP", joinColumns = {
        @JoinColumn(name = "USERGROUPID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Assetbankuser> assetbankuserCollection;
    @ManyToMany(mappedBy = "usergroupCollection")
    private Collection<Orgunit> orgunitCollection;
    @JoinTable(name = "ASSETENTITYUPLOADABLEBYGROUP", joinColumns = {
        @JoinColumn(name = "USERGROUPID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ASSETENTITYID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Assetentity> assetentityCollection;
    @ManyToMany(mappedBy = "usergroupCollection")
    private Collection<Menuitem> menuitemCollection;
    @OneToMany(mappedBy = "admingroupid")
    private Collection<Orgunit> orgunitCollection1;
    @OneToMany(mappedBy = "standardgroupid")
    private Collection<Orgunit> orgunitCollection2;
    @JoinColumn(name = "BRANDID", referencedColumnName = "ID")
    @ManyToOne
    private Brand brandid;
    @JoinColumn(name = "HOMEPAGEMENUITEMIDENTIFIER", referencedColumnName = "ITEMIDENTIFIER")
    @ManyToOne
    private Menuitem homepagemenuitemidentifier;

    public Usergroup() {
    }

    public Usergroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getAdvancedviewing() {
        return advancedviewing;
    }

    public void setAdvancedviewing(Short advancedviewing) {
        this.advancedviewing = advancedviewing;
    }

    public Short getAutomaticbrandregister() {
        return automaticbrandregister;
    }

    public void setAutomaticbrandregister(Short automaticbrandregister) {
        this.automaticbrandregister = automaticbrandregister;
    }

    public Short getCanaddemptyassets() {
        return canaddemptyassets;
    }

    public void setCanaddemptyassets(Short canaddemptyassets) {
        this.canaddemptyassets = canaddemptyassets;
    }

    public Short getCanemailassets() {
        return canemailassets;
    }

    public void setCanemailassets(Short canemailassets) {
        this.canemailassets = canemailassets;
    }

    public Short getCanexportassets() {
        return canexportassets;
    }

    public void setCanexportassets(Short canexportassets) {
        this.canexportassets = canexportassets;
    }

    public Short getCaninviteusers() {
        return caninviteusers;
    }

    public void setCaninviteusers(Short caninviteusers) {
        this.caninviteusers = caninviteusers;
    }

    public Short getCanonlyeditown() {
        return canonlyeditown;
    }

    public void setCanonlyeditown(Short canonlyeditown) {
        this.canonlyeditown = canonlyeditown;
    }

    public Short getCanpublishassetbox() {
        return canpublishassetbox;
    }

    public void setCanpublishassetbox(Short canpublishassetbox) {
        this.canpublishassetbox = canpublishassetbox;
    }

    public Short getCanrepurposeassets() {
        return canrepurposeassets;
    }

    public void setCanrepurposeassets(Short canrepurposeassets) {
        this.canrepurposeassets = canrepurposeassets;
    }

    public Short getCanseesourcepath() {
        return canseesourcepath;
    }

    public void setCanseesourcepath(Short canseesourcepath) {
        this.canseesourcepath = canseesourcepath;
    }

    public Short getCanselectonregistration() {
        return canselectonregistration;
    }

    public void setCanselectonregistration(Short canselectonregistration) {
        this.canselectonregistration = canselectonregistration;
    }

    public Short getCanviewlargersize() {
        return canviewlargersize;
    }

    public void setCanviewlargersize(Short canviewlargersize) {
        this.canviewlargersize = canviewlargersize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscountpercentage() {
        return discountpercentage;
    }

    public void setDiscountpercentage(Integer discountpercentage) {
        this.discountpercentage = discountpercentage;
    }

    public Integer getDownloadlimit() {
        return downloadlimit;
    }

    public void setDownloadlimit(Integer downloadlimit) {
        this.downloadlimit = downloadlimit;
    }

    public String getDownloadlimitperiod() {
        return downloadlimitperiod;
    }

    public void setDownloadlimitperiod(String downloadlimitperiod) {
        this.downloadlimitperiod = downloadlimitperiod;
    }

    public String getIpmapping() {
        return ipmapping;
    }

    public void setIpmapping(String ipmapping) {
        this.ipmapping = ipmapping;
    }

    public Short getIsdefaultgroup() {
        return isdefaultgroup;
    }

    public void setIsdefaultgroup(Short isdefaultgroup) {
        this.isdefaultgroup = isdefaultgroup;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public Integer getMaxdownloadheight() {
        return maxdownloadheight;
    }

    public void setMaxdownloadheight(Integer maxdownloadheight) {
        this.maxdownloadheight = maxdownloadheight;
    }

    public Integer getMaxdownloadwidth() {
        return maxdownloadwidth;
    }

    public void setMaxdownloadwidth(Integer maxdownloadwidth) {
        this.maxdownloadwidth = maxdownloadwidth;
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

    public String getUrlmapping() {
        return urlmapping;
    }

    public void setUrlmapping(String urlmapping) {
        this.urlmapping = urlmapping;
    }

    @XmlTransient
    public Collection<Assetbankuser> getAssetbankuserCollection() {
        return assetbankuserCollection;
    }

    public void setAssetbankuserCollection(Collection<Assetbankuser> assetbankuserCollection) {
        this.assetbankuserCollection = assetbankuserCollection;
    }

    @XmlTransient
    public Collection<Orgunit> getOrgunitCollection() {
        return orgunitCollection;
    }

    public void setOrgunitCollection(Collection<Orgunit> orgunitCollection) {
        this.orgunitCollection = orgunitCollection;
    }

    @XmlTransient
    public Collection<Assetentity> getAssetentityCollection() {
        return assetentityCollection;
    }

    public void setAssetentityCollection(Collection<Assetentity> assetentityCollection) {
        this.assetentityCollection = assetentityCollection;
    }

    @XmlTransient
    public Collection<Menuitem> getMenuitemCollection() {
        return menuitemCollection;
    }

    public void setMenuitemCollection(Collection<Menuitem> menuitemCollection) {
        this.menuitemCollection = menuitemCollection;
    }

    @XmlTransient
    public Collection<Orgunit> getOrgunitCollection1() {
        return orgunitCollection1;
    }

    public void setOrgunitCollection1(Collection<Orgunit> orgunitCollection1) {
        this.orgunitCollection1 = orgunitCollection1;
    }

    @XmlTransient
    public Collection<Orgunit> getOrgunitCollection2() {
        return orgunitCollection2;
    }

    public void setOrgunitCollection2(Collection<Orgunit> orgunitCollection2) {
        this.orgunitCollection2 = orgunitCollection2;
    }

    public Brand getBrandid() {
        return brandid;
    }

    public void setBrandid(Brand brandid) {
        this.brandid = brandid;
    }

    public Menuitem getHomepagemenuitemidentifier() {
        return homepagemenuitemidentifier;
    }

    public void setHomepagemenuitemidentifier(Menuitem homepagemenuitemidentifier) {
        this.homepagemenuitemidentifier = homepagemenuitemidentifier;
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
        if (!(object instanceof Usergroup)) {
            return false;
        }
        Usergroup other = (Usergroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Usergroup[ id=" + id + " ]";
    }
    
}
