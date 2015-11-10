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
@Table(name = "FILEFORMAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fileformat.findAll", query = "SELECT f FROM Fileformat f"),
    @NamedQuery(name = "Fileformat.findById", query = "SELECT f FROM Fileformat f WHERE f.id = :id"),
    @NamedQuery(name = "Fileformat.findByCanuploadthumbnail", query = "SELECT f FROM Fileformat f WHERE f.canuploadthumbnail = :canuploadthumbnail"),
    @NamedQuery(name = "Fileformat.findByCanvieworiginal", query = "SELECT f FROM Fileformat f WHERE f.canvieworiginal = :canvieworiginal"),
    @NamedQuery(name = "Fileformat.findByCompressedinzip", query = "SELECT f FROM Fileformat f WHERE f.compressedinzip = :compressedinzip"),
    @NamedQuery(name = "Fileformat.findByContenttype", query = "SELECT f FROM Fileformat f WHERE f.contenttype = :contenttype"),
    @NamedQuery(name = "Fileformat.findByConvertindividuallayers", query = "SELECT f FROM Fileformat f WHERE f.convertindividuallayers = :convertindividuallayers"),
    @NamedQuery(name = "Fileformat.findByConverterclass", query = "SELECT f FROM Fileformat f WHERE f.converterclass = :converterclass"),
    @NamedQuery(name = "Fileformat.findByDescription", query = "SELECT f FROM Fileformat f WHERE f.description = :description"),
    @NamedQuery(name = "Fileformat.findByFileextension", query = "SELECT f FROM Fileformat f WHERE f.fileextension = :fileextension"),
    @NamedQuery(name = "Fileformat.findByIsconversiontarget", query = "SELECT f FROM Fileformat f WHERE f.isconversiontarget = :isconversiontarget"),
    @NamedQuery(name = "Fileformat.findByIsconvertable", query = "SELECT f FROM Fileformat f WHERE f.isconvertable = :isconvertable"),
    @NamedQuery(name = "Fileformat.findByIsindexable", query = "SELECT f FROM Fileformat f WHERE f.isindexable = :isindexable"),
    @NamedQuery(name = "Fileformat.findByIsrotatable", query = "SELECT f FROM Fileformat f WHERE f.isrotatable = :isrotatable"),
    @NamedQuery(name = "Fileformat.findByName", query = "SELECT f FROM Fileformat f WHERE f.name = :name"),
    @NamedQuery(name = "Fileformat.findByPreviewheight", query = "SELECT f FROM Fileformat f WHERE f.previewheight = :previewheight"),
    @NamedQuery(name = "Fileformat.findByPreviewinclude", query = "SELECT f FROM Fileformat f WHERE f.previewinclude = :previewinclude"),
    @NamedQuery(name = "Fileformat.findByPreviewwidth", query = "SELECT f FROM Fileformat f WHERE f.previewwidth = :previewwidth"),
    @NamedQuery(name = "Fileformat.findBySupportstransparency", query = "SELECT f FROM Fileformat f WHERE f.supportstransparency = :supportstransparency"),
    @NamedQuery(name = "Fileformat.findByThumbnailfilelocation", query = "SELECT f FROM Fileformat f WHERE f.thumbnailfilelocation = :thumbnailfilelocation"),
    @NamedQuery(name = "Fileformat.findByTotextconverterclass", query = "SELECT f FROM Fileformat f WHERE f.totextconverterclass = :totextconverterclass"),
    @NamedQuery(name = "Fileformat.findByViewfileinclude", query = "SELECT f FROM Fileformat f WHERE f.viewfileinclude = :viewfileinclude")})
public class Fileformat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CANUPLOADTHUMBNAIL")
    private Short canuploadthumbnail;
    @Column(name = "CANVIEWORIGINAL")
    private Short canvieworiginal;
    @Column(name = "COMPRESSEDINZIP")
    private Short compressedinzip;
    @Column(name = "CONTENTTYPE")
    private String contenttype;
    @Column(name = "CONVERTINDIVIDUALLAYERS")
    private Short convertindividuallayers;
    @Column(name = "CONVERTERCLASS")
    private String converterclass;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "FILEEXTENSION")
    private String fileextension;
    @Column(name = "ISCONVERSIONTARGET")
    private Short isconversiontarget;
    @Column(name = "ISCONVERTABLE")
    private Short isconvertable;
    @Column(name = "ISINDEXABLE")
    private Short isindexable;
    @Column(name = "ISROTATABLE")
    private Short isrotatable;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PREVIEWHEIGHT")
    private Integer previewheight;
    @Column(name = "PREVIEWINCLUDE")
    private String previewinclude;
    @Column(name = "PREVIEWWIDTH")
    private Integer previewwidth;
    @Column(name = "SUPPORTSTRANSPARENCY")
    private Short supportstransparency;
    @Column(name = "THUMBNAILFILELOCATION")
    private String thumbnailfilelocation;
    @Column(name = "TOTEXTCONVERTERCLASS")
    private String totextconverterclass;
    @Column(name = "VIEWFILEINCLUDE")
    private String viewfileinclude;
    @JoinColumn(name = "ASSETTYPEID", referencedColumnName = "ID")
    @ManyToOne
    private Assettype assettypeid;
    @OneToMany(mappedBy = "fileformatid")
    private Collection<Asset> assetCollection;

    public Fileformat() {
    }

    public Fileformat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCanuploadthumbnail() {
        return canuploadthumbnail;
    }

    public void setCanuploadthumbnail(Short canuploadthumbnail) {
        this.canuploadthumbnail = canuploadthumbnail;
    }

    public Short getCanvieworiginal() {
        return canvieworiginal;
    }

    public void setCanvieworiginal(Short canvieworiginal) {
        this.canvieworiginal = canvieworiginal;
    }

    public Short getCompressedinzip() {
        return compressedinzip;
    }

    public void setCompressedinzip(Short compressedinzip) {
        this.compressedinzip = compressedinzip;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public Short getConvertindividuallayers() {
        return convertindividuallayers;
    }

    public void setConvertindividuallayers(Short convertindividuallayers) {
        this.convertindividuallayers = convertindividuallayers;
    }

    public String getConverterclass() {
        return converterclass;
    }

    public void setConverterclass(String converterclass) {
        this.converterclass = converterclass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileextension() {
        return fileextension;
    }

    public void setFileextension(String fileextension) {
        this.fileextension = fileextension;
    }

    public Short getIsconversiontarget() {
        return isconversiontarget;
    }

    public void setIsconversiontarget(Short isconversiontarget) {
        this.isconversiontarget = isconversiontarget;
    }

    public Short getIsconvertable() {
        return isconvertable;
    }

    public void setIsconvertable(Short isconvertable) {
        this.isconvertable = isconvertable;
    }

    public Short getIsindexable() {
        return isindexable;
    }

    public void setIsindexable(Short isindexable) {
        this.isindexable = isindexable;
    }

    public Short getIsrotatable() {
        return isrotatable;
    }

    public void setIsrotatable(Short isrotatable) {
        this.isrotatable = isrotatable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPreviewheight() {
        return previewheight;
    }

    public void setPreviewheight(Integer previewheight) {
        this.previewheight = previewheight;
    }

    public String getPreviewinclude() {
        return previewinclude;
    }

    public void setPreviewinclude(String previewinclude) {
        this.previewinclude = previewinclude;
    }

    public Integer getPreviewwidth() {
        return previewwidth;
    }

    public void setPreviewwidth(Integer previewwidth) {
        this.previewwidth = previewwidth;
    }

    public Short getSupportstransparency() {
        return supportstransparency;
    }

    public void setSupportstransparency(Short supportstransparency) {
        this.supportstransparency = supportstransparency;
    }

    public String getThumbnailfilelocation() {
        return thumbnailfilelocation;
    }

    public void setThumbnailfilelocation(String thumbnailfilelocation) {
        this.thumbnailfilelocation = thumbnailfilelocation;
    }

    public String getTotextconverterclass() {
        return totextconverterclass;
    }

    public void setTotextconverterclass(String totextconverterclass) {
        this.totextconverterclass = totextconverterclass;
    }

    public String getViewfileinclude() {
        return viewfileinclude;
    }

    public void setViewfileinclude(String viewfileinclude) {
        this.viewfileinclude = viewfileinclude;
    }

    public Assettype getAssettypeid() {
        return assettypeid;
    }

    public void setAssettypeid(Assettype assettypeid) {
        this.assettypeid = assettypeid;
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
        if (!(object instanceof Fileformat)) {
            return false;
        }
        Fileformat other = (Fileformat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Fileformat[ id=" + id + " ]";
    }
    
}
