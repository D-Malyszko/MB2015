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
@Table(name = "ATTRIBUTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
    @NamedQuery(name = "Attribute.findById", query = "SELECT a FROM Attribute a WHERE a.id = :id"),
    @NamedQuery(name = "Attribute.findByAlttext", query = "SELECT a FROM Attribute a WHERE a.alttext = :alttext"),
    @NamedQuery(name = "Attribute.findByAutocompleteplugin", query = "SELECT a FROM Attribute a WHERE a.autocompleteplugin = :autocompleteplugin"),
    @NamedQuery(name = "Attribute.findByBaseurl", query = "SELECT a FROM Attribute a WHERE a.baseurl = :baseurl"),
    @NamedQuery(name = "Attribute.findByDateformattype", query = "SELECT a FROM Attribute a WHERE a.dateformattype = :dateformattype"),
    @NamedQuery(name = "Attribute.findByDefaultkeywordfilter", query = "SELECT a FROM Attribute a WHERE a.defaultkeywordfilter = :defaultkeywordfilter"),
    @NamedQuery(name = "Attribute.findByDefaultvalue", query = "SELECT a FROM Attribute a WHERE a.defaultvalue = :defaultvalue"),
    @NamedQuery(name = "Attribute.findByDisplayname", query = "SELECT a FROM Attribute a WHERE a.displayname = :displayname"),
    @NamedQuery(name = "Attribute.findByEnforceuniqueness", query = "SELECT a FROM Attribute a WHERE a.enforceuniqueness = :enforceuniqueness"),
    @NamedQuery(name = "Attribute.findByFulldateprecisionrequired", query = "SELECT a FROM Attribute a WHERE a.fulldateprecisionrequired = :fulldateprecisionrequired"),
    @NamedQuery(name = "Attribute.findByGetdatafromchildren", query = "SELECT a FROM Attribute a WHERE a.getdatafromchildren = :getdatafromchildren"),
    @NamedQuery(name = "Attribute.findByHassearchtokens", query = "SELECT a FROM Attribute a WHERE a.hassearchtokens = :hassearchtokens"),
    @NamedQuery(name = "Attribute.findByHeight", query = "SELECT a FROM Attribute a WHERE a.height = :height"),
    @NamedQuery(name = "Attribute.findByHelptext", query = "SELECT a FROM Attribute a WHERE a.helptext = :helptext"),
    @NamedQuery(name = "Attribute.findByHideforsort", query = "SELECT a FROM Attribute a WHERE a.hideforsort = :hideforsort"),
    @NamedQuery(name = "Attribute.findByHighlight", query = "SELECT a FROM Attribute a WHERE a.highlight = :highlight"),
    @NamedQuery(name = "Attribute.findByIncludeinsearchforchild", query = "SELECT a FROM Attribute a WHERE a.includeinsearchforchild = :includeinsearchforchild"),
    @NamedQuery(name = "Attribute.findByIncrementamount", query = "SELECT a FROM Attribute a WHERE a.incrementamount = :incrementamount"),
    @NamedQuery(name = "Attribute.findByInputmask", query = "SELECT a FROM Attribute a WHERE a.inputmask = :inputmask"),
    @NamedQuery(name = "Attribute.findByIsautocomplete", query = "SELECT a FROM Attribute a WHERE a.isautocomplete = :isautocomplete"),
    @NamedQuery(name = "Attribute.findByIsdescriptionattribute", query = "SELECT a FROM Attribute a WHERE a.isdescriptionattribute = :isdescriptionattribute"),
    @NamedQuery(name = "Attribute.findByIsextendablelist", query = "SELECT a FROM Attribute a WHERE a.isextendablelist = :isextendablelist"),
    @NamedQuery(name = "Attribute.findByIsfiltered", query = "SELECT a FROM Attribute a WHERE a.isfiltered = :isfiltered"),
    @NamedQuery(name = "Attribute.findByIshtml", query = "SELECT a FROM Attribute a WHERE a.ishtml = :ishtml"),
    @NamedQuery(name = "Attribute.findByIskeywordsearchable", query = "SELECT a FROM Attribute a WHERE a.iskeywordsearchable = :iskeywordsearchable"),
    @NamedQuery(name = "Attribute.findByIsmandatory", query = "SELECT a FROM Attribute a WHERE a.ismandatory = :ismandatory"),
    @NamedQuery(name = "Attribute.findByIsmandatorybulkupload", query = "SELECT a FROM Attribute a WHERE a.ismandatorybulkupload = :ismandatorybulkupload"),
    @NamedQuery(name = "Attribute.findByIsreadonly", query = "SELECT a FROM Attribute a WHERE a.isreadonly = :isreadonly"),
    @NamedQuery(name = "Attribute.findByIsrequiredforcompleteness", query = "SELECT a FROM Attribute a WHERE a.isrequiredforcompleteness = :isrequiredforcompleteness"),
    @NamedQuery(name = "Attribute.findByIsstatic", query = "SELECT a FROM Attribute a WHERE a.isstatic = :isstatic"),
    @NamedQuery(name = "Attribute.findByKeywordimporturl", query = "SELECT a FROM Attribute a WHERE a.keywordimporturl = :keywordimporturl"),
    @NamedQuery(name = "Attribute.findByLabel", query = "SELECT a FROM Attribute a WHERE a.label = :label"),
    @NamedQuery(name = "Attribute.findByMaxdecimalplaces", query = "SELECT a FROM Attribute a WHERE a.maxdecimalplaces = :maxdecimalplaces"),
    @NamedQuery(name = "Attribute.findByMaxdisplaylength", query = "SELECT a FROM Attribute a WHERE a.maxdisplaylength = :maxdisplaylength"),
    @NamedQuery(name = "Attribute.findByMaxsize", query = "SELECT a FROM Attribute a WHERE a.maxsize = :maxsize"),
    @NamedQuery(name = "Attribute.findByMindecimalplaces", query = "SELECT a FROM Attribute a WHERE a.mindecimalplaces = :mindecimalplaces"),
    @NamedQuery(name = "Attribute.findByNameattribute", query = "SELECT a FROM Attribute a WHERE a.nameattribute = :nameattribute"),
    @NamedQuery(name = "Attribute.findByOnchangescript", query = "SELECT a FROM Attribute a WHERE a.onchangescript = :onchangescript"),
    @NamedQuery(name = "Attribute.findByPluginclass", query = "SELECT a FROM Attribute a WHERE a.pluginclass = :pluginclass"),
    @NamedQuery(name = "Attribute.findByPluginparamsattributeids", query = "SELECT a FROM Attribute a WHERE a.pluginparamsattributeids = :pluginparamsattributeids"),
    @NamedQuery(name = "Attribute.findByPrefix", query = "SELECT a FROM Attribute a WHERE a.prefix = :prefix"),
    @NamedQuery(name = "Attribute.findByRequirestranslation", query = "SELECT a FROM Attribute a WHERE a.requirestranslation = :requirestranslation"),
    @NamedQuery(name = "Attribute.findBySanitizehtml", query = "SELECT a FROM Attribute a WHERE a.sanitizehtml = :sanitizehtml"),
    @NamedQuery(name = "Attribute.findBySearchhelptext", query = "SELECT a FROM Attribute a WHERE a.searchhelptext = :searchhelptext"),
    @NamedQuery(name = "Attribute.findBySeed", query = "SELECT a FROM Attribute a WHERE a.seed = :seed"),
    @NamedQuery(name = "Attribute.findByShowonchild", query = "SELECT a FROM Attribute a WHERE a.showonchild = :showonchild"),
    @NamedQuery(name = "Attribute.findByShowondownload", query = "SELECT a FROM Attribute a WHERE a.showondownload = :showondownload"),
    @NamedQuery(name = "Attribute.findBySinglepointonly", query = "SELECT a FROM Attribute a WHERE a.singlepointonly = :singlepointonly"),
    @NamedQuery(name = "Attribute.findByStaticfieldname", query = "SELECT a FROM Attribute a WHERE a.staticfieldname = :staticfieldname"),
    @NamedQuery(name = "Attribute.findByTokendelimiterregex", query = "SELECT a FROM Attribute a WHERE a.tokendelimiterregex = :tokendelimiterregex"),
    @NamedQuery(name = "Attribute.findByTreeid", query = "SELECT a FROM Attribute a WHERE a.treeid = :treeid"),
    @NamedQuery(name = "Attribute.findByValuecolumnname", query = "SELECT a FROM Attribute a WHERE a.valuecolumnname = :valuecolumnname"),
    @NamedQuery(name = "Attribute.findByValueifnotvisible", query = "SELECT a FROM Attribute a WHERE a.valueifnotvisible = :valueifnotvisible"),
    @NamedQuery(name = "Attribute.findByWidth", query = "SELECT a FROM Attribute a WHERE a.width = :width")})
public class Attribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ALTTEXT")
    private String alttext;
    @Column(name = "AUTOCOMPLETEPLUGIN")
    private String autocompleteplugin;
    @Column(name = "BASEURL")
    private String baseurl;
    @Column(name = "DATEFORMATTYPE")
    private Short dateformattype;
    @Column(name = "DEFAULTKEYWORDFILTER")
    private String defaultkeywordfilter;
    @Column(name = "DEFAULTVALUE")
    private String defaultvalue;
    @Column(name = "DISPLAYNAME")
    private String displayname;
    @Column(name = "ENFORCEUNIQUENESS")
    private Short enforceuniqueness;
    @Column(name = "FULLDATEPRECISIONREQUIRED")
    private Short fulldateprecisionrequired;
    @Column(name = "GETDATAFROMCHILDREN")
    private Short getdatafromchildren;
    @Column(name = "HASSEARCHTOKENS")
    private Short hassearchtokens;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "HELPTEXT")
    private String helptext;
    @Column(name = "HIDEFORSORT")
    private Short hideforsort;
    @Column(name = "HIGHLIGHT")
    private Short highlight;
    @Column(name = "INCLUDEINSEARCHFORCHILD")
    private Short includeinsearchforchild;
    @Column(name = "INCREMENTAMOUNT")
    private Integer incrementamount;
    @Column(name = "INPUTMASK")
    private String inputmask;
    @Column(name = "ISAUTOCOMPLETE")
    private Short isautocomplete;
    @Column(name = "ISDESCRIPTIONATTRIBUTE")
    private Short isdescriptionattribute;
    @Column(name = "ISEXTENDABLELIST")
    private Short isextendablelist;
    @Column(name = "ISFILTERED")
    private Short isfiltered;
    @Column(name = "ISHTML")
    private Short ishtml;
    @Column(name = "ISKEYWORDSEARCHABLE")
    private Short iskeywordsearchable;
    @Column(name = "ISMANDATORY")
    private Short ismandatory;
    @Column(name = "ISMANDATORYBULKUPLOAD")
    private Short ismandatorybulkupload;
    @Column(name = "ISREADONLY")
    private Short isreadonly;
    @Column(name = "ISREQUIREDFORCOMPLETENESS")
    private Short isrequiredforcompleteness;
    @Column(name = "ISSTATIC")
    private Short isstatic;
    @Column(name = "KEYWORDIMPORTURL")
    private String keywordimporturl;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "MAXDECIMALPLACES")
    private Integer maxdecimalplaces;
    @Column(name = "MAXDISPLAYLENGTH")
    private Integer maxdisplaylength;
    @Column(name = "MAXSIZE")
    private Integer maxsize;
    @Column(name = "MINDECIMALPLACES")
    private Integer mindecimalplaces;
    @Column(name = "NAMEATTRIBUTE")
    private Short nameattribute;
    @Column(name = "ONCHANGESCRIPT")
    private String onchangescript;
    @Column(name = "PLUGINCLASS")
    private String pluginclass;
    @Column(name = "PLUGINPARAMSATTRIBUTEIDS")
    private String pluginparamsattributeids;
    @Column(name = "PREFIX")
    private String prefix;
    @Column(name = "REQUIRESTRANSLATION")
    private Short requirestranslation;
    @Column(name = "SANITIZEHTML")
    private Short sanitizehtml;
    @Column(name = "SEARCHHELPTEXT")
    private String searchhelptext;
    @Column(name = "SEED")
    private Integer seed;
    @Column(name = "SHOWONCHILD")
    private Short showonchild;
    @Column(name = "SHOWONDOWNLOAD")
    private Short showondownload;
    @Column(name = "SINGLEPOINTONLY")
    private Short singlepointonly;
    @Column(name = "STATICFIELDNAME")
    private String staticfieldname;
    @Column(name = "TOKENDELIMITERREGEX")
    private String tokendelimiterregex;
    @Column(name = "TREEID")
    private Integer treeid;
    @Column(name = "VALUECOLUMNNAME")
    private String valuecolumnname;
    @Column(name = "VALUEIFNOTVISIBLE")
    private String valueifnotvisible;
    @Column(name = "WIDTH")
    private Integer width;
    @OneToMany(mappedBy = "matchonattributeid")
    private Collection<Assetentity> assetentityCollection;
    @OneToMany(mappedBy = "parentid")
    private Collection<Attribute> attributeCollection;
    @JoinColumn(name = "PARENTID", referencedColumnName = "ID")
    @ManyToOne
    private Attribute parentid;
    @JoinColumn(name = "ATTRIBUTETYPEID", referencedColumnName = "ID")
    @ManyToOne
    private Attributetype attributetypeid;

    public Attribute() {
    }

    public Attribute(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlttext() {
        return alttext;
    }

    public void setAlttext(String alttext) {
        this.alttext = alttext;
    }

    public String getAutocompleteplugin() {
        return autocompleteplugin;
    }

    public void setAutocompleteplugin(String autocompleteplugin) {
        this.autocompleteplugin = autocompleteplugin;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public Short getDateformattype() {
        return dateformattype;
    }

    public void setDateformattype(Short dateformattype) {
        this.dateformattype = dateformattype;
    }

    public String getDefaultkeywordfilter() {
        return defaultkeywordfilter;
    }

    public void setDefaultkeywordfilter(String defaultkeywordfilter) {
        this.defaultkeywordfilter = defaultkeywordfilter;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Short getEnforceuniqueness() {
        return enforceuniqueness;
    }

    public void setEnforceuniqueness(Short enforceuniqueness) {
        this.enforceuniqueness = enforceuniqueness;
    }

    public Short getFulldateprecisionrequired() {
        return fulldateprecisionrequired;
    }

    public void setFulldateprecisionrequired(Short fulldateprecisionrequired) {
        this.fulldateprecisionrequired = fulldateprecisionrequired;
    }

    public Short getGetdatafromchildren() {
        return getdatafromchildren;
    }

    public void setGetdatafromchildren(Short getdatafromchildren) {
        this.getdatafromchildren = getdatafromchildren;
    }

    public Short getHassearchtokens() {
        return hassearchtokens;
    }

    public void setHassearchtokens(Short hassearchtokens) {
        this.hassearchtokens = hassearchtokens;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    public Short getHideforsort() {
        return hideforsort;
    }

    public void setHideforsort(Short hideforsort) {
        this.hideforsort = hideforsort;
    }

    public Short getHighlight() {
        return highlight;
    }

    public void setHighlight(Short highlight) {
        this.highlight = highlight;
    }

    public Short getIncludeinsearchforchild() {
        return includeinsearchforchild;
    }

    public void setIncludeinsearchforchild(Short includeinsearchforchild) {
        this.includeinsearchforchild = includeinsearchforchild;
    }

    public Integer getIncrementamount() {
        return incrementamount;
    }

    public void setIncrementamount(Integer incrementamount) {
        this.incrementamount = incrementamount;
    }

    public String getInputmask() {
        return inputmask;
    }

    public void setInputmask(String inputmask) {
        this.inputmask = inputmask;
    }

    public Short getIsautocomplete() {
        return isautocomplete;
    }

    public void setIsautocomplete(Short isautocomplete) {
        this.isautocomplete = isautocomplete;
    }

    public Short getIsdescriptionattribute() {
        return isdescriptionattribute;
    }

    public void setIsdescriptionattribute(Short isdescriptionattribute) {
        this.isdescriptionattribute = isdescriptionattribute;
    }

    public Short getIsextendablelist() {
        return isextendablelist;
    }

    public void setIsextendablelist(Short isextendablelist) {
        this.isextendablelist = isextendablelist;
    }

    public Short getIsfiltered() {
        return isfiltered;
    }

    public void setIsfiltered(Short isfiltered) {
        this.isfiltered = isfiltered;
    }

    public Short getIshtml() {
        return ishtml;
    }

    public void setIshtml(Short ishtml) {
        this.ishtml = ishtml;
    }

    public Short getIskeywordsearchable() {
        return iskeywordsearchable;
    }

    public void setIskeywordsearchable(Short iskeywordsearchable) {
        this.iskeywordsearchable = iskeywordsearchable;
    }

    public Short getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Short ismandatory) {
        this.ismandatory = ismandatory;
    }

    public Short getIsmandatorybulkupload() {
        return ismandatorybulkupload;
    }

    public void setIsmandatorybulkupload(Short ismandatorybulkupload) {
        this.ismandatorybulkupload = ismandatorybulkupload;
    }

    public Short getIsreadonly() {
        return isreadonly;
    }

    public void setIsreadonly(Short isreadonly) {
        this.isreadonly = isreadonly;
    }

    public Short getIsrequiredforcompleteness() {
        return isrequiredforcompleteness;
    }

    public void setIsrequiredforcompleteness(Short isrequiredforcompleteness) {
        this.isrequiredforcompleteness = isrequiredforcompleteness;
    }

    public Short getIsstatic() {
        return isstatic;
    }

    public void setIsstatic(Short isstatic) {
        this.isstatic = isstatic;
    }

    public String getKeywordimporturl() {
        return keywordimporturl;
    }

    public void setKeywordimporturl(String keywordimporturl) {
        this.keywordimporturl = keywordimporturl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getMaxdecimalplaces() {
        return maxdecimalplaces;
    }

    public void setMaxdecimalplaces(Integer maxdecimalplaces) {
        this.maxdecimalplaces = maxdecimalplaces;
    }

    public Integer getMaxdisplaylength() {
        return maxdisplaylength;
    }

    public void setMaxdisplaylength(Integer maxdisplaylength) {
        this.maxdisplaylength = maxdisplaylength;
    }

    public Integer getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(Integer maxsize) {
        this.maxsize = maxsize;
    }

    public Integer getMindecimalplaces() {
        return mindecimalplaces;
    }

    public void setMindecimalplaces(Integer mindecimalplaces) {
        this.mindecimalplaces = mindecimalplaces;
    }

    public Short getNameattribute() {
        return nameattribute;
    }

    public void setNameattribute(Short nameattribute) {
        this.nameattribute = nameattribute;
    }

    public String getOnchangescript() {
        return onchangescript;
    }

    public void setOnchangescript(String onchangescript) {
        this.onchangescript = onchangescript;
    }

    public String getPluginclass() {
        return pluginclass;
    }

    public void setPluginclass(String pluginclass) {
        this.pluginclass = pluginclass;
    }

    public String getPluginparamsattributeids() {
        return pluginparamsattributeids;
    }

    public void setPluginparamsattributeids(String pluginparamsattributeids) {
        this.pluginparamsattributeids = pluginparamsattributeids;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Short getRequirestranslation() {
        return requirestranslation;
    }

    public void setRequirestranslation(Short requirestranslation) {
        this.requirestranslation = requirestranslation;
    }

    public Short getSanitizehtml() {
        return sanitizehtml;
    }

    public void setSanitizehtml(Short sanitizehtml) {
        this.sanitizehtml = sanitizehtml;
    }

    public String getSearchhelptext() {
        return searchhelptext;
    }

    public void setSearchhelptext(String searchhelptext) {
        this.searchhelptext = searchhelptext;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public Short getShowonchild() {
        return showonchild;
    }

    public void setShowonchild(Short showonchild) {
        this.showonchild = showonchild;
    }

    public Short getShowondownload() {
        return showondownload;
    }

    public void setShowondownload(Short showondownload) {
        this.showondownload = showondownload;
    }

    public Short getSinglepointonly() {
        return singlepointonly;
    }

    public void setSinglepointonly(Short singlepointonly) {
        this.singlepointonly = singlepointonly;
    }

    public String getStaticfieldname() {
        return staticfieldname;
    }

    public void setStaticfieldname(String staticfieldname) {
        this.staticfieldname = staticfieldname;
    }

    public String getTokendelimiterregex() {
        return tokendelimiterregex;
    }

    public void setTokendelimiterregex(String tokendelimiterregex) {
        this.tokendelimiterregex = tokendelimiterregex;
    }

    public Integer getTreeid() {
        return treeid;
    }

    public void setTreeid(Integer treeid) {
        this.treeid = treeid;
    }

    public String getValuecolumnname() {
        return valuecolumnname;
    }

    public void setValuecolumnname(String valuecolumnname) {
        this.valuecolumnname = valuecolumnname;
    }

    public String getValueifnotvisible() {
        return valueifnotvisible;
    }

    public void setValueifnotvisible(String valueifnotvisible) {
        this.valueifnotvisible = valueifnotvisible;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @XmlTransient
    public Collection<Assetentity> getAssetentityCollection() {
        return assetentityCollection;
    }

    public void setAssetentityCollection(Collection<Assetentity> assetentityCollection) {
        this.assetentityCollection = assetentityCollection;
    }

    @XmlTransient
    public Collection<Attribute> getAttributeCollection() {
        return attributeCollection;
    }

    public void setAttributeCollection(Collection<Attribute> attributeCollection) {
        this.attributeCollection = attributeCollection;
    }

    public Attribute getParentid() {
        return parentid;
    }

    public void setParentid(Attribute parentid) {
        this.parentid = parentid;
    }

    public Attributetype getAttributetypeid() {
        return attributetypeid;
    }

    public void setAttributetypeid(Attributetype attributetypeid) {
        this.attributetypeid = attributetypeid;
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
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute other = (Attribute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Attribute[ id=" + id + " ]";
    }
    
}
