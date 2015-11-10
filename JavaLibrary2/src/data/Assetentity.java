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
@Table(name = "ASSETENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetentity.findAll", query = "SELECT a FROM Assetentity a"),
    @NamedQuery(name = "Assetentity.findById", query = "SELECT a FROM Assetentity a WHERE a.id = :id"),
    @NamedQuery(name = "Assetentity.findByCancopyassets", query = "SELECT a FROM Assetentity a WHERE a.cancopyassets = :cancopyassets"),
    @NamedQuery(name = "Assetentity.findByCandownloadchildren", query = "SELECT a FROM Assetentity a WHERE a.candownloadchildren = :candownloadchildren"),
    @NamedQuery(name = "Assetentity.findByDefaultcategoryid", query = "SELECT a FROM Assetentity a WHERE a.defaultcategoryid = :defaultcategoryid"),
    @NamedQuery(name = "Assetentity.findByExcludedfileformats", query = "SELECT a FROM Assetentity a WHERE a.excludedfileformats = :excludedfileformats"),
    @NamedQuery(name = "Assetentity.findByIncludedfileformats", query = "SELECT a FROM Assetentity a WHERE a.includedfileformats = :includedfileformats"),
    @NamedQuery(name = "Assetentity.findByIsarticle", query = "SELECT a FROM Assetentity a WHERE a.isarticle = :isarticle"),
    @NamedQuery(name = "Assetentity.findByIscategoryextension", query = "SELECT a FROM Assetentity a WHERE a.iscategoryextension = :iscategoryextension"),
    @NamedQuery(name = "Assetentity.findByIsquicksearchable", query = "SELECT a FROM Assetentity a WHERE a.isquicksearchable = :isquicksearchable"),
    @NamedQuery(name = "Assetentity.findByIssearchable", query = "SELECT a FROM Assetentity a WHERE a.issearchable = :issearchable"),
    @NamedQuery(name = "Assetentity.findByMusthaveparent", query = "SELECT a FROM Assetentity a WHERE a.musthaveparent = :musthaveparent"),
    @NamedQuery(name = "Assetentity.findByName", query = "SELECT a FROM Assetentity a WHERE a.name = :name"),
    @NamedQuery(name = "Assetentity.findByOnlyallowdefaultcategory", query = "SELECT a FROM Assetentity a WHERE a.onlyallowdefaultcategory = :onlyallowdefaultcategory"),
    @NamedQuery(name = "Assetentity.findByRestagreementid", query = "SELECT a FROM Assetentity a WHERE a.restagreementid = :restagreementid"),
    @NamedQuery(name = "Assetentity.findBySequencenumber", query = "SELECT a FROM Assetentity a WHERE a.sequencenumber = :sequencenumber"),
    @NamedQuery(name = "Assetentity.findByShowattributelabels", query = "SELECT a FROM Assetentity a WHERE a.showattributelabels = :showattributelabels"),
    @NamedQuery(name = "Assetentity.findByShowondescendantcategories", query = "SELECT a FROM Assetentity a WHERE a.showondescendantcategories = :showondescendantcategories"),
    @NamedQuery(name = "Assetentity.findByTermforsibling", query = "SELECT a FROM Assetentity a WHERE a.termforsibling = :termforsibling"),
    @NamedQuery(name = "Assetentity.findByTermforsiblings", query = "SELECT a FROM Assetentity a WHERE a.termforsiblings = :termforsiblings"),
    @NamedQuery(name = "Assetentity.findByThumbnailfilename", query = "SELECT a FROM Assetentity a WHERE a.thumbnailfilename = :thumbnailfilename"),
    @NamedQuery(name = "Assetentity.findByUnrestagreementid", query = "SELECT a FROM Assetentity a WHERE a.unrestagreementid = :unrestagreementid")})
public class Assetentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CANCOPYASSETS")
    private Short cancopyassets;
    @Column(name = "CANDOWNLOADCHILDREN")
    private Short candownloadchildren;
    @Column(name = "DEFAULTCATEGORYID")
    private Integer defaultcategoryid;
    @Column(name = "EXCLUDEDFILEFORMATS")
    private String excludedfileformats;
    @Column(name = "INCLUDEDFILEFORMATS")
    private String includedfileformats;
    @Column(name = "ISARTICLE")
    private Short isarticle;
    @Column(name = "ISCATEGORYEXTENSION")
    private Short iscategoryextension;
    @Column(name = "ISQUICKSEARCHABLE")
    private Short isquicksearchable;
    @Column(name = "ISSEARCHABLE")
    private Short issearchable;
    @Column(name = "MUSTHAVEPARENT")
    private Short musthaveparent;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ONLYALLOWDEFAULTCATEGORY")
    private Short onlyallowdefaultcategory;
    @Column(name = "RESTAGREEMENTID")
    private Integer restagreementid;
    @Column(name = "SEQUENCENUMBER")
    private Integer sequencenumber;
    @Column(name = "SHOWATTRIBUTELABELS")
    private Short showattributelabels;
    @Column(name = "SHOWONDESCENDANTCATEGORIES")
    private Short showondescendantcategories;
    @Column(name = "TERMFORSIBLING")
    private String termforsibling;
    @Column(name = "TERMFORSIBLINGS")
    private String termforsiblings;
    @Column(name = "THUMBNAILFILENAME")
    private String thumbnailfilename;
    @Column(name = "UNRESTAGREEMENTID")
    private Integer unrestagreementid;
    @ManyToMany(mappedBy = "assetentityCollection")
    private Collection<Assettype> assettypeCollection;
    @ManyToMany(mappedBy = "assetentityCollection")
    private Collection<Usergroup> usergroupCollection;
    @JoinColumn(name = "MATCHONATTRIBUTEID", referencedColumnName = "ID")
    @ManyToOne
    private Attribute matchonattributeid;
    @JoinColumn(name = "ROOTCATEGORYID", referencedColumnName = "ID")
    @ManyToOne
    private CmCategory rootcategoryid;
    @OneToMany(mappedBy = "assetentityid")
    private Collection<Asset> assetCollection;

    public Assetentity() {
    }

    public Assetentity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCancopyassets() {
        return cancopyassets;
    }

    public void setCancopyassets(Short cancopyassets) {
        this.cancopyassets = cancopyassets;
    }

    public Short getCandownloadchildren() {
        return candownloadchildren;
    }

    public void setCandownloadchildren(Short candownloadchildren) {
        this.candownloadchildren = candownloadchildren;
    }

    public Integer getDefaultcategoryid() {
        return defaultcategoryid;
    }

    public void setDefaultcategoryid(Integer defaultcategoryid) {
        this.defaultcategoryid = defaultcategoryid;
    }

    public String getExcludedfileformats() {
        return excludedfileformats;
    }

    public void setExcludedfileformats(String excludedfileformats) {
        this.excludedfileformats = excludedfileformats;
    }

    public String getIncludedfileformats() {
        return includedfileformats;
    }

    public void setIncludedfileformats(String includedfileformats) {
        this.includedfileformats = includedfileformats;
    }

    public Short getIsarticle() {
        return isarticle;
    }

    public void setIsarticle(Short isarticle) {
        this.isarticle = isarticle;
    }

    public Short getIscategoryextension() {
        return iscategoryextension;
    }

    public void setIscategoryextension(Short iscategoryextension) {
        this.iscategoryextension = iscategoryextension;
    }

    public Short getIsquicksearchable() {
        return isquicksearchable;
    }

    public void setIsquicksearchable(Short isquicksearchable) {
        this.isquicksearchable = isquicksearchable;
    }

    public Short getIssearchable() {
        return issearchable;
    }

    public void setIssearchable(Short issearchable) {
        this.issearchable = issearchable;
    }

    public Short getMusthaveparent() {
        return musthaveparent;
    }

    public void setMusthaveparent(Short musthaveparent) {
        this.musthaveparent = musthaveparent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getOnlyallowdefaultcategory() {
        return onlyallowdefaultcategory;
    }

    public void setOnlyallowdefaultcategory(Short onlyallowdefaultcategory) {
        this.onlyallowdefaultcategory = onlyallowdefaultcategory;
    }

    public Integer getRestagreementid() {
        return restagreementid;
    }

    public void setRestagreementid(Integer restagreementid) {
        this.restagreementid = restagreementid;
    }

    public Integer getSequencenumber() {
        return sequencenumber;
    }

    public void setSequencenumber(Integer sequencenumber) {
        this.sequencenumber = sequencenumber;
    }

    public Short getShowattributelabels() {
        return showattributelabels;
    }

    public void setShowattributelabels(Short showattributelabels) {
        this.showattributelabels = showattributelabels;
    }

    public Short getShowondescendantcategories() {
        return showondescendantcategories;
    }

    public void setShowondescendantcategories(Short showondescendantcategories) {
        this.showondescendantcategories = showondescendantcategories;
    }

    public String getTermforsibling() {
        return termforsibling;
    }

    public void setTermforsibling(String termforsibling) {
        this.termforsibling = termforsibling;
    }

    public String getTermforsiblings() {
        return termforsiblings;
    }

    public void setTermforsiblings(String termforsiblings) {
        this.termforsiblings = termforsiblings;
    }

    public String getThumbnailfilename() {
        return thumbnailfilename;
    }

    public void setThumbnailfilename(String thumbnailfilename) {
        this.thumbnailfilename = thumbnailfilename;
    }

    public Integer getUnrestagreementid() {
        return unrestagreementid;
    }

    public void setUnrestagreementid(Integer unrestagreementid) {
        this.unrestagreementid = unrestagreementid;
    }

    @XmlTransient
    public Collection<Assettype> getAssettypeCollection() {
        return assettypeCollection;
    }

    public void setAssettypeCollection(Collection<Assettype> assettypeCollection) {
        this.assettypeCollection = assettypeCollection;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection() {
        return usergroupCollection;
    }

    public void setUsergroupCollection(Collection<Usergroup> usergroupCollection) {
        this.usergroupCollection = usergroupCollection;
    }

    public Attribute getMatchonattributeid() {
        return matchonattributeid;
    }

    public void setMatchonattributeid(Attribute matchonattributeid) {
        this.matchonattributeid = matchonattributeid;
    }

    public CmCategory getRootcategoryid() {
        return rootcategoryid;
    }

    public void setRootcategoryid(CmCategory rootcategoryid) {
        this.rootcategoryid = rootcategoryid;
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
        if (!(object instanceof Assetentity)) {
            return false;
        }
        Assetentity other = (Assetentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Assetentity[ id=" + id + " ]";
    }
    
}
