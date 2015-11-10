/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ASSETBANKUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assetbankuser.findAll", query = "SELECT a FROM Assetbankuser a"),
    @NamedQuery(name = "Assetbankuser.findById", query = "SELECT a FROM Assetbankuser a WHERE a.id = :id"),
    @NamedQuery(name = "Assetbankuser.findByAdditionalapprovalname", query = "SELECT a FROM Assetbankuser a WHERE a.additionalapprovalname = :additionalapprovalname"),
    @NamedQuery(name = "Assetbankuser.findByAddress", query = "SELECT a FROM Assetbankuser a WHERE a.address = :address"),
    @NamedQuery(name = "Assetbankuser.findByAdminnotes", query = "SELECT a FROM Assetbankuser a WHERE a.adminnotes = :adminnotes"),
    @NamedQuery(name = "Assetbankuser.findByCanbecategoryadmin", query = "SELECT a FROM Assetbankuser a WHERE a.canbecategoryadmin = :canbecategoryadmin"),
    @NamedQuery(name = "Assetbankuser.findByCanloginfromcms", query = "SELECT a FROM Assetbankuser a WHERE a.canloginfromcms = :canloginfromcms"),
    @NamedQuery(name = "Assetbankuser.findByCn", query = "SELECT a FROM Assetbankuser a WHERE a.cn = :cn"),
    @NamedQuery(name = "Assetbankuser.findByContentalertsubscriber", query = "SELECT a FROM Assetbankuser a WHERE a.contentalertsubscriber = :contentalertsubscriber"),
    @NamedQuery(name = "Assetbankuser.findByDatechangedpassword", query = "SELECT a FROM Assetbankuser a WHERE a.datechangedpassword = :datechangedpassword"),
    @NamedQuery(name = "Assetbankuser.findByDatelastloggedin", query = "SELECT a FROM Assetbankuser a WHERE a.datelastloggedin = :datelastloggedin"),
    @NamedQuery(name = "Assetbankuser.findByDatelastmodified", query = "SELECT a FROM Assetbankuser a WHERE a.datelastmodified = :datelastmodified"),
    @NamedQuery(name = "Assetbankuser.findByDisplayname", query = "SELECT a FROM Assetbankuser a WHERE a.displayname = :displayname"),
    @NamedQuery(name = "Assetbankuser.findByDistinguishedname", query = "SELECT a FROM Assetbankuser a WHERE a.distinguishedname = :distinguishedname"),
    @NamedQuery(name = "Assetbankuser.findByEmailaddress", query = "SELECT a FROM Assetbankuser a WHERE a.emailaddress = :emailaddress"),
    @NamedQuery(name = "Assetbankuser.findByExpirydate", query = "SELECT a FROM Assetbankuser a WHERE a.expirydate = :expirydate"),
    @NamedQuery(name = "Assetbankuser.findByForename", query = "SELECT a FROM Assetbankuser a WHERE a.forename = :forename"),
    @NamedQuery(name = "Assetbankuser.findByHaseverloggedin", query = "SELECT a FROM Assetbankuser a WHERE a.haseverloggedin = :haseverloggedin"),
    @NamedQuery(name = "Assetbankuser.findByHidden", query = "SELECT a FROM Assetbankuser a WHERE a.hidden = :hidden"),
    @NamedQuery(name = "Assetbankuser.findByHomepageaccesslevelsexpanded", query = "SELECT a FROM Assetbankuser a WHERE a.homepageaccesslevelsexpanded = :homepageaccesslevelsexpanded"),
    @NamedQuery(name = "Assetbankuser.findByHomepagecategoriesexpanded", query = "SELECT a FROM Assetbankuser a WHERE a.homepagecategoriesexpanded = :homepagecategoriesexpanded"),
    @NamedQuery(name = "Assetbankuser.findByIsadmin", query = "SELECT a FROM Assetbankuser a WHERE a.isadmin = :isadmin"),
    @NamedQuery(name = "Assetbankuser.findByIsdeleted", query = "SELECT a FROM Assetbankuser a WHERE a.isdeleted = :isdeleted"),
    @NamedQuery(name = "Assetbankuser.findByIssuspended", query = "SELECT a FROM Assetbankuser a WHERE a.issuspended = :issuspended"),
    @NamedQuery(name = "Assetbankuser.findByJobtitle", query = "SELECT a FROM Assetbankuser a WHERE a.jobtitle = :jobtitle"),
    @NamedQuery(name = "Assetbankuser.findByLdapserverindex", query = "SELECT a FROM Assetbankuser a WHERE a.ldapserverindex = :ldapserverindex"),
    @NamedQuery(name = "Assetbankuser.findByMailbox", query = "SELECT a FROM Assetbankuser a WHERE a.mailbox = :mailbox"),
    @NamedQuery(name = "Assetbankuser.findByNotactivedirectory", query = "SELECT a FROM Assetbankuser a WHERE a.notactivedirectory = :notactivedirectory"),
    @NamedQuery(name = "Assetbankuser.findByNotapproved", query = "SELECT a FROM Assetbankuser a WHERE a.notapproved = :notapproved"),
    @NamedQuery(name = "Assetbankuser.findByOrganisation", query = "SELECT a FROM Assetbankuser a WHERE a.organisation = :organisation"),
    @NamedQuery(name = "Assetbankuser.findByPassword", query = "SELECT a FROM Assetbankuser a WHERE a.password = :password"),
    @NamedQuery(name = "Assetbankuser.findByReactivationpending", query = "SELECT a FROM Assetbankuser a WHERE a.reactivationpending = :reactivationpending"),
    @NamedQuery(name = "Assetbankuser.findByReceivealerts", query = "SELECT a FROM Assetbankuser a WHERE a.receivealerts = :receivealerts"),
    @NamedQuery(name = "Assetbankuser.findByRegisterdate", query = "SELECT a FROM Assetbankuser a WHERE a.registerdate = :registerdate"),
    @NamedQuery(name = "Assetbankuser.findByRegistrationinfo", query = "SELECT a FROM Assetbankuser a WHERE a.registrationinfo = :registrationinfo"),
    @NamedQuery(name = "Assetbankuser.findByRequestfulfiller", query = "SELECT a FROM Assetbankuser a WHERE a.requestfulfiller = :requestfulfiller"),
    @NamedQuery(name = "Assetbankuser.findByRequiresupdate", query = "SELECT a FROM Assetbankuser a WHERE a.requiresupdate = :requiresupdate"),
    @NamedQuery(name = "Assetbankuser.findBySearchresultsperpage", query = "SELECT a FROM Assetbankuser a WHERE a.searchresultsperpage = :searchresultsperpage"),
    @NamedQuery(name = "Assetbankuser.findBySurname", query = "SELECT a FROM Assetbankuser a WHERE a.surname = :surname"),
    @NamedQuery(name = "Assetbankuser.findByTitle", query = "SELECT a FROM Assetbankuser a WHERE a.title = :title"),
    @NamedQuery(name = "Assetbankuser.findByUsername", query = "SELECT a FROM Assetbankuser a WHERE a.username = :username"),
    @NamedQuery(name = "Assetbankuser.findByVatnumber", query = "SELECT a FROM Assetbankuser a WHERE a.vatnumber = :vatnumber")})
public class Assetbankuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADDITIONALAPPROVALNAME")
    private String additionalapprovalname;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ADMINNOTES")
    private String adminnotes;
    @Column(name = "CANBECATEGORYADMIN")
    private Short canbecategoryadmin;
    @Column(name = "CANLOGINFROMCMS")
    private Short canloginfromcms;
    @Column(name = "CN")
    private String cn;
    @Column(name = "CONTENTALERTSUBSCRIBER")
    private Short contentalertsubscriber;
    @Column(name = "DATECHANGEDPASSWORD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datechangedpassword;
    @Column(name = "DATELASTLOGGEDIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastloggedin;
    @Column(name = "DATELASTMODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastmodified;
    @Column(name = "DISPLAYNAME")
    private String displayname;
    @Column(name = "DISTINGUISHEDNAME")
    private String distinguishedname;
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @Column(name = "EXPIRYDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirydate;
    @Column(name = "FORENAME")
    private String forename;
    @Column(name = "HASEVERLOGGEDIN")
    private Short haseverloggedin;
    @Column(name = "HIDDEN")
    private Short hidden;
    @Column(name = "HOMEPAGEACCESSLEVELSEXPANDED")
    private Short homepageaccesslevelsexpanded;
    @Column(name = "HOMEPAGECATEGORIESEXPANDED")
    private Short homepagecategoriesexpanded;
    @Column(name = "ISADMIN")
    private Short isadmin;
    @Column(name = "ISDELETED")
    private Short isdeleted;
    @Column(name = "ISSUSPENDED")
    private Short issuspended;
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @Column(name = "LDAPSERVERINDEX")
    private Short ldapserverindex;
    @Column(name = "MAILBOX")
    private String mailbox;
    @Column(name = "NOTACTIVEDIRECTORY")
    private Short notactivedirectory;
    @Column(name = "NOTAPPROVED")
    private Short notapproved;
    @Column(name = "ORGANISATION")
    private String organisation;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "REACTIVATIONPENDING")
    private Short reactivationpending;
    @Column(name = "RECEIVEALERTS")
    private Short receivealerts;
    @Column(name = "REGISTERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerdate;
    @Column(name = "REGISTRATIONINFO")
    private String registrationinfo;
    @Column(name = "REQUESTFULFILLER")
    private Short requestfulfiller;
    @Column(name = "REQUIRESUPDATE")
    private Short requiresupdate;
    @Column(name = "SEARCHRESULTSPERPAGE")
    private Integer searchresultsperpage;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "VATNUMBER")
    private String vatnumber;
    @ManyToMany(mappedBy = "assetbankuserCollection")
    private Collection<Usergroup> usergroupCollection;
    @ManyToMany(mappedBy = "assetbankuserCollection")
    private Collection<Language> languageCollection;
    @OneToMany(mappedBy = "submittedbyuserid")
    private Collection<Asset> assetCollection;
    @OneToMany(mappedBy = "addedbyuserid")
    private Collection<Asset> assetCollection1;
    @OneToMany(mappedBy = "lastmodifiedbyuserid")
    private Collection<Asset> assetCollection2;
    @OneToMany(mappedBy = "filecheckedoutbyuserid")
    private Collection<Asset> assetCollection3;
    @JoinColumn(name = "ADDRESSID", referencedColumnName = "ID")
    @ManyToOne
    private Address addressid;
    @OneToMany(mappedBy = "lastmodifiedbyid")
    private Collection<Assetbankuser> assetbankuserCollection;
    @JoinColumn(name = "LASTMODIFIEDBYID", referencedColumnName = "ID")
    @ManyToOne
    private Assetbankuser lastmodifiedbyid;
    @OneToMany(mappedBy = "invitedbyuserid")
    private Collection<Assetbankuser> assetbankuserCollection1;
    @JoinColumn(name = "INVITEDBYUSERID", referencedColumnName = "ID")
    @ManyToOne
    private Assetbankuser invitedbyuserid;
    @JoinColumn(name = "DIVISIONID", referencedColumnName = "ID")
    @ManyToOne
    private Division divisionid;
    @JoinColumn(name = "LANGUAGEID", referencedColumnName = "ID")
    @ManyToOne
    private Language languageid;
    @JoinColumn(name = "REQUESTEDORGUNITID", referencedColumnName = "ID")
    @ManyToOne
    private Orgunit requestedorgunitid;

    public Assetbankuser() {
    }

    public Assetbankuser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdditionalapprovalname() {
        return additionalapprovalname;
    }

    public void setAdditionalapprovalname(String additionalapprovalname) {
        this.additionalapprovalname = additionalapprovalname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminnotes() {
        return adminnotes;
    }

    public void setAdminnotes(String adminnotes) {
        this.adminnotes = adminnotes;
    }

    public Short getCanbecategoryadmin() {
        return canbecategoryadmin;
    }

    public void setCanbecategoryadmin(Short canbecategoryadmin) {
        this.canbecategoryadmin = canbecategoryadmin;
    }

    public Short getCanloginfromcms() {
        return canloginfromcms;
    }

    public void setCanloginfromcms(Short canloginfromcms) {
        this.canloginfromcms = canloginfromcms;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public Short getContentalertsubscriber() {
        return contentalertsubscriber;
    }

    public void setContentalertsubscriber(Short contentalertsubscriber) {
        this.contentalertsubscriber = contentalertsubscriber;
    }

    public Date getDatechangedpassword() {
        return datechangedpassword;
    }

    public void setDatechangedpassword(Date datechangedpassword) {
        this.datechangedpassword = datechangedpassword;
    }

    public Date getDatelastloggedin() {
        return datelastloggedin;
    }

    public void setDatelastloggedin(Date datelastloggedin) {
        this.datelastloggedin = datelastloggedin;
    }

    public Date getDatelastmodified() {
        return datelastmodified;
    }

    public void setDatelastmodified(Date datelastmodified) {
        this.datelastmodified = datelastmodified;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDistinguishedname() {
        return distinguishedname;
    }

    public void setDistinguishedname(String distinguishedname) {
        this.distinguishedname = distinguishedname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public Short getHaseverloggedin() {
        return haseverloggedin;
    }

    public void setHaseverloggedin(Short haseverloggedin) {
        this.haseverloggedin = haseverloggedin;
    }

    public Short getHidden() {
        return hidden;
    }

    public void setHidden(Short hidden) {
        this.hidden = hidden;
    }

    public Short getHomepageaccesslevelsexpanded() {
        return homepageaccesslevelsexpanded;
    }

    public void setHomepageaccesslevelsexpanded(Short homepageaccesslevelsexpanded) {
        this.homepageaccesslevelsexpanded = homepageaccesslevelsexpanded;
    }

    public Short getHomepagecategoriesexpanded() {
        return homepagecategoriesexpanded;
    }

    public void setHomepagecategoriesexpanded(Short homepagecategoriesexpanded) {
        this.homepagecategoriesexpanded = homepagecategoriesexpanded;
    }

    public Short getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Short isadmin) {
        this.isadmin = isadmin;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Short getIssuspended() {
        return issuspended;
    }

    public void setIssuspended(Short issuspended) {
        this.issuspended = issuspended;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public Short getLdapserverindex() {
        return ldapserverindex;
    }

    public void setLdapserverindex(Short ldapserverindex) {
        this.ldapserverindex = ldapserverindex;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Short getNotactivedirectory() {
        return notactivedirectory;
    }

    public void setNotactivedirectory(Short notactivedirectory) {
        this.notactivedirectory = notactivedirectory;
    }

    public Short getNotapproved() {
        return notapproved;
    }

    public void setNotapproved(Short notapproved) {
        this.notapproved = notapproved;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getReactivationpending() {
        return reactivationpending;
    }

    public void setReactivationpending(Short reactivationpending) {
        this.reactivationpending = reactivationpending;
    }

    public Short getReceivealerts() {
        return receivealerts;
    }

    public void setReceivealerts(Short receivealerts) {
        this.receivealerts = receivealerts;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getRegistrationinfo() {
        return registrationinfo;
    }

    public void setRegistrationinfo(String registrationinfo) {
        this.registrationinfo = registrationinfo;
    }

    public Short getRequestfulfiller() {
        return requestfulfiller;
    }

    public void setRequestfulfiller(Short requestfulfiller) {
        this.requestfulfiller = requestfulfiller;
    }

    public Short getRequiresupdate() {
        return requiresupdate;
    }

    public void setRequiresupdate(Short requiresupdate) {
        this.requiresupdate = requiresupdate;
    }

    public Integer getSearchresultsperpage() {
        return searchresultsperpage;
    }

    public void setSearchresultsperpage(Integer searchresultsperpage) {
        this.searchresultsperpage = searchresultsperpage;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    @XmlTransient
    public Collection<Usergroup> getUsergroupCollection() {
        return usergroupCollection;
    }

    public void setUsergroupCollection(Collection<Usergroup> usergroupCollection) {
        this.usergroupCollection = usergroupCollection;
    }

    @XmlTransient
    public Collection<Language> getLanguageCollection() {
        return languageCollection;
    }

    public void setLanguageCollection(Collection<Language> languageCollection) {
        this.languageCollection = languageCollection;
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
    public Collection<Asset> getAssetCollection2() {
        return assetCollection2;
    }

    public void setAssetCollection2(Collection<Asset> assetCollection2) {
        this.assetCollection2 = assetCollection2;
    }

    @XmlTransient
    public Collection<Asset> getAssetCollection3() {
        return assetCollection3;
    }

    public void setAssetCollection3(Collection<Asset> assetCollection3) {
        this.assetCollection3 = assetCollection3;
    }

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    @XmlTransient
    public Collection<Assetbankuser> getAssetbankuserCollection() {
        return assetbankuserCollection;
    }

    public void setAssetbankuserCollection(Collection<Assetbankuser> assetbankuserCollection) {
        this.assetbankuserCollection = assetbankuserCollection;
    }

    public Assetbankuser getLastmodifiedbyid() {
        return lastmodifiedbyid;
    }

    public void setLastmodifiedbyid(Assetbankuser lastmodifiedbyid) {
        this.lastmodifiedbyid = lastmodifiedbyid;
    }

    @XmlTransient
    public Collection<Assetbankuser> getAssetbankuserCollection1() {
        return assetbankuserCollection1;
    }

    public void setAssetbankuserCollection1(Collection<Assetbankuser> assetbankuserCollection1) {
        this.assetbankuserCollection1 = assetbankuserCollection1;
    }

    public Assetbankuser getInvitedbyuserid() {
        return invitedbyuserid;
    }

    public void setInvitedbyuserid(Assetbankuser invitedbyuserid) {
        this.invitedbyuserid = invitedbyuserid;
    }

    public Division getDivisionid() {
        return divisionid;
    }

    public void setDivisionid(Division divisionid) {
        this.divisionid = divisionid;
    }

    public Language getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Language languageid) {
        this.languageid = languageid;
    }

    public Orgunit getRequestedorgunitid() {
        return requestedorgunitid;
    }

    public void setRequestedorgunitid(Orgunit requestedorgunitid) {
        this.requestedorgunitid = requestedorgunitid;
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
        if (!(object instanceof Assetbankuser)) {
            return false;
        }
        Assetbankuser other = (Assetbankuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Assetbankuser[ id=" + id + " ]";
    }
    
}
