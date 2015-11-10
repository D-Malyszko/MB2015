/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ASSET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a"),
    @NamedQuery(name = "Asset.findById", query = "SELECT a FROM Asset a WHERE a.id = :id"),
    @NamedQuery(name = "Asset.findByAdvancedviewing", query = "SELECT a FROM Asset a WHERE a.advancedviewing = :advancedviewing"),
    @NamedQuery(name = "Asset.findByAgreementtypeid", query = "SELECT a FROM Asset a WHERE a.agreementtypeid = :agreementtypeid"),
    @NamedQuery(name = "Asset.findByAllowfeedback", query = "SELECT a FROM Asset a WHERE a.allowfeedback = :allowfeedback"),
    @NamedQuery(name = "Asset.findByAuthor", query = "SELECT a FROM Asset a WHERE a.author = :author"),
    @NamedQuery(name = "Asset.findByAwaitingthumbnailregeneration", query = "SELECT a FROM Asset a WHERE a.awaitingthumbnailregeneration = :awaitingthumbnailregeneration"),
    @NamedQuery(name = "Asset.findByBulkuploadtimestamp", query = "SELECT a FROM Asset a WHERE a.bulkuploadtimestamp = :bulkuploadtimestamp"),
    @NamedQuery(name = "Asset.findByCanembedfile", query = "SELECT a FROM Asset a WHERE a.canembedfile = :canembedfile"),
    @NamedQuery(name = "Asset.findByCode", query = "SELECT a FROM Asset a WHERE a.code = :code"),
    @NamedQuery(name = "Asset.findByDateadded", query = "SELECT a FROM Asset a WHERE a.dateadded = :dateadded"),
    @NamedQuery(name = "Asset.findByDatefirstapproved", query = "SELECT a FROM Asset a WHERE a.datefirstapproved = :datefirstapproved"),
    @NamedQuery(name = "Asset.findByDatelastmodified", query = "SELECT a FROM Asset a WHERE a.datelastmodified = :datelastmodified"),
    @NamedQuery(name = "Asset.findByDatesubmitted", query = "SELECT a FROM Asset a WHERE a.datesubmitted = :datesubmitted"),
    @NamedQuery(name = "Asset.findByEmbeddedpreviewcliplocation", query = "SELECT a FROM Asset a WHERE a.embeddedpreviewcliplocation = :embeddedpreviewcliplocation"),
    @NamedQuery(name = "Asset.findByExpirydate", query = "SELECT a FROM Asset a WHERE a.expirydate = :expirydate"),
    @NamedQuery(name = "Asset.findByFilecheckouttime", query = "SELECT a FROM Asset a WHERE a.filecheckouttime = :filecheckouttime"),
    @NamedQuery(name = "Asset.findByFilelocation", query = "SELECT a FROM Asset a WHERE a.filelocation = :filelocation"),
    @NamedQuery(name = "Asset.findByFilesizeinbytes", query = "SELECT a FROM Asset a WHERE a.filesizeinbytes = :filesizeinbytes"),
    @NamedQuery(name = "Asset.findByHasworkingfile", query = "SELECT a FROM Asset a WHERE a.hasworkingfile = :hasworkingfile"),
    @NamedQuery(name = "Asset.findByImportedassetid", query = "SELECT a FROM Asset a WHERE a.importedassetid = :importedassetid"),
    @NamedQuery(name = "Asset.findByIsbrandtemplate", query = "SELECT a FROM Asset a WHERE a.isbrandtemplate = :isbrandtemplate"),
    @NamedQuery(name = "Asset.findByIsnotduplicate", query = "SELECT a FROM Asset a WHERE a.isnotduplicate = :isnotduplicate"),
    @NamedQuery(name = "Asset.findByIspreviewrestricted", query = "SELECT a FROM Asset a WHERE a.ispreviewrestricted = :ispreviewrestricted"),
    @NamedQuery(name = "Asset.findByIssensitive", query = "SELECT a FROM Asset a WHERE a.issensitive = :issensitive"),
    @NamedQuery(name = "Asset.findByIsunsubmitted", query = "SELECT a FROM Asset a WHERE a.isunsubmitted = :isunsubmitted"),
    @NamedQuery(name = "Asset.findByLastdownloaded", query = "SELECT a FROM Asset a WHERE a.lastdownloaded = :lastdownloaded"),
    @NamedQuery(name = "Asset.findByMediumfilelocation", query = "SELECT a FROM Asset a WHERE a.mediumfilelocation = :mediumfilelocation"),
    @NamedQuery(name = "Asset.findByNumdownloads", query = "SELECT a FROM Asset a WHERE a.numdownloads = :numdownloads"),
    @NamedQuery(name = "Asset.findByNumviews", query = "SELECT a FROM Asset a WHERE a.numviews = :numviews"),
    @NamedQuery(name = "Asset.findByOriginalfilelocation", query = "SELECT a FROM Asset a WHERE a.originalfilelocation = :originalfilelocation"),
    @NamedQuery(name = "Asset.findByOriginalfilename", query = "SELECT a FROM Asset a WHERE a.originalfilename = :originalfilename"),
    @NamedQuery(name = "Asset.findByPrice", query = "SELECT a FROM Asset a WHERE a.price = :price"),
    @NamedQuery(name = "Asset.findBySmallfilelocation", query = "SELECT a FROM Asset a WHERE a.smallfilelocation = :smallfilelocation"),
    @NamedQuery(name = "Asset.findByThumbnailfilelocation", query = "SELECT a FROM Asset a WHERE a.thumbnailfilelocation = :thumbnailfilelocation"),
    @NamedQuery(name = "Asset.findByThumbnailgenerationfailed", query = "SELECT a FROM Asset a WHERE a.thumbnailgenerationfailed = :thumbnailgenerationfailed"),
    @NamedQuery(name = "Asset.findByUploadedthumbnailfile", query = "SELECT a FROM Asset a WHERE a.uploadedthumbnailfile = :uploadedthumbnailfile"),
    @NamedQuery(name = "Asset.findByVersionnumber", query = "SELECT a FROM Asset a WHERE a.versionnumber = :versionnumber")})
public class Asset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADVANCEDVIEWING")
    private Short advancedviewing;
    @Column(name = "AGREEMENTTYPEID")
    private Integer agreementtypeid;
    @Column(name = "ALLOWFEEDBACK")
    private Short allowfeedback;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "AWAITINGTHUMBNAILREGENERATION")
    private Short awaitingthumbnailregeneration;
    @Column(name = "BULKUPLOADTIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bulkuploadtimestamp;
    @Column(name = "CANEMBEDFILE")
    private Short canembedfile;
    @Column(name = "CODE")
    private String code;
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Column(name = "DATEFIRSTAPPROVED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefirstapproved;
    @Column(name = "DATELASTMODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastmodified;
    @Column(name = "DATESUBMITTED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesubmitted;
    @Column(name = "EMBEDDEDPREVIEWCLIPLOCATION")
    private String embeddedpreviewcliplocation;
    @Column(name = "EXPIRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirydate;
    @Column(name = "FILECHECKOUTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date filecheckouttime;
    @Column(name = "FILELOCATION")
    private String filelocation;
    @Column(name = "FILESIZEINBYTES")
    private BigInteger filesizeinbytes;
    @Column(name = "HASWORKINGFILE")
    private Short hasworkingfile;
    @Column(name = "IMPORTEDASSETID")
    private String importedassetid;
    @Column(name = "ISBRANDTEMPLATE")
    private Short isbrandtemplate;
    @Column(name = "ISNOTDUPLICATE")
    private Short isnotduplicate;
    @Column(name = "ISPREVIEWRESTRICTED")
    private Short ispreviewrestricted;
    @Column(name = "ISSENSITIVE")
    private Short issensitive;
    @Column(name = "ISUNSUBMITTED")
    private Short isunsubmitted;
    @Column(name = "LASTDOWNLOADED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastdownloaded;
    @Column(name = "MEDIUMFILELOCATION")
    private String mediumfilelocation;
    @Column(name = "NUMDOWNLOADS")
    private Integer numdownloads;
    @Column(name = "NUMVIEWS")
    private Integer numviews;
    @Column(name = "ORIGINALFILELOCATION")
    private String originalfilelocation;
    @Column(name = "ORIGINALFILENAME")
    private String originalfilename;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "SMALLFILELOCATION")
    private String smallfilelocation;
    @Column(name = "THUMBNAILFILELOCATION")
    private String thumbnailfilelocation;
    @Column(name = "THUMBNAILGENERATIONFAILED")
    private Short thumbnailgenerationfailed;
    @Column(name = "UPLOADEDTHUMBNAILFILE")
    private String uploadedthumbnailfile;
    @Column(name = "VERSIONNUMBER")
    private Integer versionnumber;
    @JoinTable(name = "INDESIGNLINKEDRESOURCE", joinColumns = {
        @JoinColumn(name = "LINKEDASSETID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ASSETID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Asset> assetCollection;
    @ManyToMany(mappedBy = "assetCollection")
    private Collection<Asset> assetCollection1;
    @OneToMany(mappedBy = "extensionassetid")
    private Collection<CmCategory> cmCategoryCollection;
    @OneToMany(mappedBy = "currentversionid")
    private Collection<Asset> assetCollection2;
    @JoinColumn(name = "CURRENTVERSIONID", referencedColumnName = "ID")
    @ManyToOne
    private Asset currentversionid;
    @JoinColumn(name = "SUBMITTEDBYUSERID", referencedColumnName = "ID")
    @ManyToOne
    private Assetbankuser submittedbyuserid;
    @JoinColumn(name = "ADDEDBYUSERID", referencedColumnName = "ID")
    @ManyToOne
    private Assetbankuser addedbyuserid;
    @JoinColumn(name = "LASTMODIFIEDBYUSERID", referencedColumnName = "ID")
    @ManyToOne
    private Assetbankuser lastmodifiedbyuserid;
    @JoinColumn(name = "FILECHECKEDOUTBYUSERID", referencedColumnName = "ID")
    @ManyToOne
    private Assetbankuser filecheckedoutbyuserid;
    @JoinColumn(name = "ASSETENTITYID", referencedColumnName = "ID")
    @ManyToOne
    private Assetentity assetentityid;
    @JoinColumn(name = "ASSETTYPEID", referencedColumnName = "ID")
    @ManyToOne
    private Assettype assettypeid;
    @JoinColumn(name = "FILEFORMATID", referencedColumnName = "ID")
    @ManyToOne
    private Fileformat fileformatid;

    public Asset() {
    }

    public Asset(Integer id) {
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

    public Integer getAgreementtypeid() {
        return agreementtypeid;
    }

    public void setAgreementtypeid(Integer agreementtypeid) {
        this.agreementtypeid = agreementtypeid;
    }

    public Short getAllowfeedback() {
        return allowfeedback;
    }

    public void setAllowfeedback(Short allowfeedback) {
        this.allowfeedback = allowfeedback;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Short getAwaitingthumbnailregeneration() {
        return awaitingthumbnailregeneration;
    }

    public void setAwaitingthumbnailregeneration(Short awaitingthumbnailregeneration) {
        this.awaitingthumbnailregeneration = awaitingthumbnailregeneration;
    }

    public Date getBulkuploadtimestamp() {
        return bulkuploadtimestamp;
    }

    public void setBulkuploadtimestamp(Date bulkuploadtimestamp) {
        this.bulkuploadtimestamp = bulkuploadtimestamp;
    }

    public Short getCanembedfile() {
        return canembedfile;
    }

    public void setCanembedfile(Short canembedfile) {
        this.canembedfile = canembedfile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public Date getDatefirstapproved() {
        return datefirstapproved;
    }

    public void setDatefirstapproved(Date datefirstapproved) {
        this.datefirstapproved = datefirstapproved;
    }

    public Date getDatelastmodified() {
        return datelastmodified;
    }

    public void setDatelastmodified(Date datelastmodified) {
        this.datelastmodified = datelastmodified;
    }

    public Date getDatesubmitted() {
        return datesubmitted;
    }

    public void setDatesubmitted(Date datesubmitted) {
        this.datesubmitted = datesubmitted;
    }

    public String getEmbeddedpreviewcliplocation() {
        return embeddedpreviewcliplocation;
    }

    public void setEmbeddedpreviewcliplocation(String embeddedpreviewcliplocation) {
        this.embeddedpreviewcliplocation = embeddedpreviewcliplocation;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public Date getFilecheckouttime() {
        return filecheckouttime;
    }

    public void setFilecheckouttime(Date filecheckouttime) {
        this.filecheckouttime = filecheckouttime;
    }

    public String getFilelocation() {
        return filelocation;
    }

    public void setFilelocation(String filelocation) {
        this.filelocation = filelocation;
    }

    public BigInteger getFilesizeinbytes() {
        return filesizeinbytes;
    }

    public void setFilesizeinbytes(BigInteger filesizeinbytes) {
        this.filesizeinbytes = filesizeinbytes;
    }

    public Short getHasworkingfile() {
        return hasworkingfile;
    }

    public void setHasworkingfile(Short hasworkingfile) {
        this.hasworkingfile = hasworkingfile;
    }

    public String getImportedassetid() {
        return importedassetid;
    }

    public void setImportedassetid(String importedassetid) {
        this.importedassetid = importedassetid;
    }

    public Short getIsbrandtemplate() {
        return isbrandtemplate;
    }

    public void setIsbrandtemplate(Short isbrandtemplate) {
        this.isbrandtemplate = isbrandtemplate;
    }

    public Short getIsnotduplicate() {
        return isnotduplicate;
    }

    public void setIsnotduplicate(Short isnotduplicate) {
        this.isnotduplicate = isnotduplicate;
    }

    public Short getIspreviewrestricted() {
        return ispreviewrestricted;
    }

    public void setIspreviewrestricted(Short ispreviewrestricted) {
        this.ispreviewrestricted = ispreviewrestricted;
    }

    public Short getIssensitive() {
        return issensitive;
    }

    public void setIssensitive(Short issensitive) {
        this.issensitive = issensitive;
    }

    public Short getIsunsubmitted() {
        return isunsubmitted;
    }

    public void setIsunsubmitted(Short isunsubmitted) {
        this.isunsubmitted = isunsubmitted;
    }

    public Date getLastdownloaded() {
        return lastdownloaded;
    }

    public void setLastdownloaded(Date lastdownloaded) {
        this.lastdownloaded = lastdownloaded;
    }

    public String getMediumfilelocation() {
        return mediumfilelocation;
    }

    public void setMediumfilelocation(String mediumfilelocation) {
        this.mediumfilelocation = mediumfilelocation;
    }

    public Integer getNumdownloads() {
        return numdownloads;
    }

    public void setNumdownloads(Integer numdownloads) {
        this.numdownloads = numdownloads;
    }

    public Integer getNumviews() {
        return numviews;
    }

    public void setNumviews(Integer numviews) {
        this.numviews = numviews;
    }

    public String getOriginalfilelocation() {
        return originalfilelocation;
    }

    public void setOriginalfilelocation(String originalfilelocation) {
        this.originalfilelocation = originalfilelocation;
    }

    public String getOriginalfilename() {
        return originalfilename;
    }

    public void setOriginalfilename(String originalfilename) {
        this.originalfilename = originalfilename;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSmallfilelocation() {
        return smallfilelocation;
    }

    public void setSmallfilelocation(String smallfilelocation) {
        this.smallfilelocation = smallfilelocation;
    }

    public String getThumbnailfilelocation() {
        return thumbnailfilelocation;
    }

    public void setThumbnailfilelocation(String thumbnailfilelocation) {
        this.thumbnailfilelocation = thumbnailfilelocation;
    }

    public Short getThumbnailgenerationfailed() {
        return thumbnailgenerationfailed;
    }

    public void setThumbnailgenerationfailed(Short thumbnailgenerationfailed) {
        this.thumbnailgenerationfailed = thumbnailgenerationfailed;
    }

    public String getUploadedthumbnailfile() {
        return uploadedthumbnailfile;
    }

    public void setUploadedthumbnailfile(String uploadedthumbnailfile) {
        this.uploadedthumbnailfile = uploadedthumbnailfile;
    }

    public Integer getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(Integer versionnumber) {
        this.versionnumber = versionnumber;
    }

    @XmlTransient
    public Collection<Asset> getAssetCollection() {
        return assetCollection;
    }

    public void setAssetCollection(Collection<Asset> assetCollection) {
        this.assetCollection = assetCollection;
    }

    @XmlTransient
    public Collection<Asset> getAssetCollection1() {
        return assetCollection1;
    }

    public void setAssetCollection1(Collection<Asset> assetCollection1) {
        this.assetCollection1 = assetCollection1;
    }

    @XmlTransient
    public Collection<CmCategory> getCmCategoryCollection() {
        return cmCategoryCollection;
    }

    public void setCmCategoryCollection(Collection<CmCategory> cmCategoryCollection) {
        this.cmCategoryCollection = cmCategoryCollection;
    }

    @XmlTransient
    public Collection<Asset> getAssetCollection2() {
        return assetCollection2;
    }

    public void setAssetCollection2(Collection<Asset> assetCollection2) {
        this.assetCollection2 = assetCollection2;
    }

    public Asset getCurrentversionid() {
        return currentversionid;
    }

    public void setCurrentversionid(Asset currentversionid) {
        this.currentversionid = currentversionid;
    }

    public Assetbankuser getSubmittedbyuserid() {
        return submittedbyuserid;
    }

    public void setSubmittedbyuserid(Assetbankuser submittedbyuserid) {
        this.submittedbyuserid = submittedbyuserid;
    }

    public Assetbankuser getAddedbyuserid() {
        return addedbyuserid;
    }

    public void setAddedbyuserid(Assetbankuser addedbyuserid) {
        this.addedbyuserid = addedbyuserid;
    }

    public Assetbankuser getLastmodifiedbyuserid() {
        return lastmodifiedbyuserid;
    }

    public void setLastmodifiedbyuserid(Assetbankuser lastmodifiedbyuserid) {
        this.lastmodifiedbyuserid = lastmodifiedbyuserid;
    }

    public Assetbankuser getFilecheckedoutbyuserid() {
        return filecheckedoutbyuserid;
    }

    public void setFilecheckedoutbyuserid(Assetbankuser filecheckedoutbyuserid) {
        this.filecheckedoutbyuserid = filecheckedoutbyuserid;
    }

    public Assetentity getAssetentityid() {
        return assetentityid;
    }

    public void setAssetentityid(Assetentity assetentityid) {
        this.assetentityid = assetentityid;
    }

    public Assettype getAssettypeid() {
        return assettypeid;
    }

    public void setAssettypeid(Assettype assettypeid) {
        this.assettypeid = assettypeid;
    }

    public Fileformat getFileformatid() {
        return fileformatid;
    }

    public void setFileformatid(Fileformat fileformatid) {
        this.fileformatid = fileformatid;
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
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Asset[ id=" + id + " ]";
    }
    
}
