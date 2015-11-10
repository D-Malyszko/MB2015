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
@Table(name = "CM_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmCategory.findAll", query = "SELECT c FROM CmCategory c"),
    @NamedQuery(name = "CmCategory.findById", query = "SELECT c FROM CmCategory c WHERE c.id = :id"),
    @NamedQuery(name = "CmCategory.findByAllowadvancedoptions", query = "SELECT c FROM CmCategory c WHERE c.allowadvancedoptions = :allowadvancedoptions"),
    @NamedQuery(name = "CmCategory.findByBitposition", query = "SELECT c FROM CmCategory c WHERE c.bitposition = :bitposition"),
    @NamedQuery(name = "CmCategory.findByBrowseaspanels", query = "SELECT c FROM CmCategory c WHERE c.browseaspanels = :browseaspanels"),
    @NamedQuery(name = "CmCategory.findByCanassignifnotleaf", query = "SELECT c FROM CmCategory c WHERE c.canassignifnotleaf = :canassignifnotleaf"),
    @NamedQuery(name = "CmCategory.findByCannotbedeleted", query = "SELECT c FROM CmCategory c WHERE c.cannotbedeleted = :cannotbedeleted"),
    @NamedQuery(name = "CmCategory.findByDescription", query = "SELECT c FROM CmCategory c WHERE c.description = :description"),
    @NamedQuery(name = "CmCategory.findByIsbrowsable", query = "SELECT c FROM CmCategory c WHERE c.isbrowsable = :isbrowsable"),
    @NamedQuery(name = "CmCategory.findByIsexpired", query = "SELECT c FROM CmCategory c WHERE c.isexpired = :isexpired"),
    @NamedQuery(name = "CmCategory.findByIslistboxcategory", query = "SELECT c FROM CmCategory c WHERE c.islistboxcategory = :islistboxcategory"),
    @NamedQuery(name = "CmCategory.findByIsrestrictive", query = "SELECT c FROM CmCategory c WHERE c.isrestrictive = :isrestrictive"),
    @NamedQuery(name = "CmCategory.findByName", query = "SELECT c FROM CmCategory c WHERE c.name = :name"),
    @NamedQuery(name = "CmCategory.findBySelectedonload", query = "SELECT c FROM CmCategory c WHERE c.selectedonload = :selectedonload"),
    @NamedQuery(name = "CmCategory.findBySequencenumber", query = "SELECT c FROM CmCategory c WHERE c.sequencenumber = :sequencenumber"),
    @NamedQuery(name = "CmCategory.findByShowpromotedonbrowse", query = "SELECT c FROM CmCategory c WHERE c.showpromotedonbrowse = :showpromotedonbrowse"),
    @NamedQuery(name = "CmCategory.findByShowrecentonbrowse", query = "SELECT c FROM CmCategory c WHERE c.showrecentonbrowse = :showrecentonbrowse"),
    @NamedQuery(name = "CmCategory.findBySummary", query = "SELECT c FROM CmCategory c WHERE c.summary = :summary"),
    @NamedQuery(name = "CmCategory.findByViewtype", query = "SELECT c FROM CmCategory c WHERE c.viewtype = :viewtype"),
    @NamedQuery(name = "CmCategory.findByWorkflowname", query = "SELECT c FROM CmCategory c WHERE c.workflowname = :workflowname")})
public class CmCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ALLOWADVANCEDOPTIONS")
    private Short allowadvancedoptions;
    @Column(name = "BITPOSITION")
    private Integer bitposition;
    @Column(name = "BROWSEASPANELS")
    private Short browseaspanels;
    @Column(name = "CANASSIGNIFNOTLEAF")
    private Short canassignifnotleaf;
    @Column(name = "CANNOTBEDELETED")
    private Short cannotbedeleted;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ISBROWSABLE")
    private Short isbrowsable;
    @Column(name = "ISEXPIRED")
    private Short isexpired;
    @Column(name = "ISLISTBOXCATEGORY")
    private Short islistboxcategory;
    @Column(name = "ISRESTRICTIVE")
    private Short isrestrictive;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SELECTEDONLOAD")
    private Short selectedonload;
    @Column(name = "SEQUENCENUMBER")
    private Integer sequencenumber;
    @Column(name = "SHOWPROMOTEDONBROWSE")
    private Short showpromotedonbrowse;
    @Column(name = "SHOWRECENTONBROWSE")
    private Short showrecentonbrowse;
    @Column(name = "SUMMARY")
    private String summary;
    @Column(name = "VIEWTYPE")
    private String viewtype;
    @Column(name = "WORKFLOWNAME")
    private String workflowname;
    @OneToMany(mappedBy = "rootorgunitcategoryid")
    private Collection<Orgunit> orgunitCollection;
    @OneToMany(mappedBy = "rootdescriptivecategoryid")
    private Collection<Orgunit> orgunitCollection1;
    @JoinColumn(name = "EXTENSIONASSETID", referencedColumnName = "ID")
    @ManyToOne
    private Asset extensionassetid;
    @OneToMany(mappedBy = "parentid")
    private Collection<CmCategory> cmCategoryCollection;
    @JoinColumn(name = "PARENTID", referencedColumnName = "ID")
    @ManyToOne
    private CmCategory parentid;
    @JoinColumn(name = "CATEGORYTYPEID", referencedColumnName = "ID")
    @ManyToOne
    private CmCategorytype categorytypeid;
    @OneToMany(mappedBy = "rootcategoryid")
    private Collection<Assetentity> assetentityCollection;

    public CmCategory() {
    }

    public CmCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getAllowadvancedoptions() {
        return allowadvancedoptions;
    }

    public void setAllowadvancedoptions(Short allowadvancedoptions) {
        this.allowadvancedoptions = allowadvancedoptions;
    }

    public Integer getBitposition() {
        return bitposition;
    }

    public void setBitposition(Integer bitposition) {
        this.bitposition = bitposition;
    }

    public Short getBrowseaspanels() {
        return browseaspanels;
    }

    public void setBrowseaspanels(Short browseaspanels) {
        this.browseaspanels = browseaspanels;
    }

    public Short getCanassignifnotleaf() {
        return canassignifnotleaf;
    }

    public void setCanassignifnotleaf(Short canassignifnotleaf) {
        this.canassignifnotleaf = canassignifnotleaf;
    }

    public Short getCannotbedeleted() {
        return cannotbedeleted;
    }

    public void setCannotbedeleted(Short cannotbedeleted) {
        this.cannotbedeleted = cannotbedeleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getIsbrowsable() {
        return isbrowsable;
    }

    public void setIsbrowsable(Short isbrowsable) {
        this.isbrowsable = isbrowsable;
    }

    public Short getIsexpired() {
        return isexpired;
    }

    public void setIsexpired(Short isexpired) {
        this.isexpired = isexpired;
    }

    public Short getIslistboxcategory() {
        return islistboxcategory;
    }

    public void setIslistboxcategory(Short islistboxcategory) {
        this.islistboxcategory = islistboxcategory;
    }

    public Short getIsrestrictive() {
        return isrestrictive;
    }

    public void setIsrestrictive(Short isrestrictive) {
        this.isrestrictive = isrestrictive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getSelectedonload() {
        return selectedonload;
    }

    public void setSelectedonload(Short selectedonload) {
        this.selectedonload = selectedonload;
    }

    public Integer getSequencenumber() {
        return sequencenumber;
    }

    public void setSequencenumber(Integer sequencenumber) {
        this.sequencenumber = sequencenumber;
    }

    public Short getShowpromotedonbrowse() {
        return showpromotedonbrowse;
    }

    public void setShowpromotedonbrowse(Short showpromotedonbrowse) {
        this.showpromotedonbrowse = showpromotedonbrowse;
    }

    public Short getShowrecentonbrowse() {
        return showrecentonbrowse;
    }

    public void setShowrecentonbrowse(Short showrecentonbrowse) {
        this.showrecentonbrowse = showrecentonbrowse;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getViewtype() {
        return viewtype;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }

    public String getWorkflowname() {
        return workflowname;
    }

    public void setWorkflowname(String workflowname) {
        this.workflowname = workflowname;
    }

    @XmlTransient
    public Collection<Orgunit> getOrgunitCollection() {
        return orgunitCollection;
    }

    public void setOrgunitCollection(Collection<Orgunit> orgunitCollection) {
        this.orgunitCollection = orgunitCollection;
    }

    @XmlTransient
    public Collection<Orgunit> getOrgunitCollection1() {
        return orgunitCollection1;
    }

    public void setOrgunitCollection1(Collection<Orgunit> orgunitCollection1) {
        this.orgunitCollection1 = orgunitCollection1;
    }

    public Asset getExtensionassetid() {
        return extensionassetid;
    }

    public void setExtensionassetid(Asset extensionassetid) {
        this.extensionassetid = extensionassetid;
    }

    @XmlTransient
    public Collection<CmCategory> getCmCategoryCollection() {
        return cmCategoryCollection;
    }

    public void setCmCategoryCollection(Collection<CmCategory> cmCategoryCollection) {
        this.cmCategoryCollection = cmCategoryCollection;
    }

    public CmCategory getParentid() {
        return parentid;
    }

    public void setParentid(CmCategory parentid) {
        this.parentid = parentid;
    }

    public CmCategorytype getCategorytypeid() {
        return categorytypeid;
    }

    public void setCategorytypeid(CmCategorytype categorytypeid) {
        this.categorytypeid = categorytypeid;
    }

    @XmlTransient
    public Collection<Assetentity> getAssetentityCollection() {
        return assetentityCollection;
    }

    public void setAssetentityCollection(Collection<Assetentity> assetentityCollection) {
        this.assetentityCollection = assetentityCollection;
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
        if (!(object instanceof CmCategory)) {
            return false;
        }
        CmCategory other = (CmCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.CmCategory[ id=" + id + " ]";
    }
    
}
