/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "DIMEMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimemployee.findAll", query = "SELECT d FROM Dimemployee d"),
    @NamedQuery(name = "Dimemployee.findByEmployeekey", query = "SELECT d FROM Dimemployee d WHERE d.employeekey = :employeekey"),
    @NamedQuery(name = "Dimemployee.findByBaserate", query = "SELECT d FROM Dimemployee d WHERE d.baserate = :baserate"),
    @NamedQuery(name = "Dimemployee.findByBirthdate", query = "SELECT d FROM Dimemployee d WHERE d.birthdate = :birthdate"),
    @NamedQuery(name = "Dimemployee.findByCurrentflag", query = "SELECT d FROM Dimemployee d WHERE d.currentflag = :currentflag"),
    @NamedQuery(name = "Dimemployee.findByDepartmentname", query = "SELECT d FROM Dimemployee d WHERE d.departmentname = :departmentname"),
    @NamedQuery(name = "Dimemployee.findByEmailaddress", query = "SELECT d FROM Dimemployee d WHERE d.emailaddress = :emailaddress"),
    @NamedQuery(name = "Dimemployee.findByEmergencycontactname", query = "SELECT d FROM Dimemployee d WHERE d.emergencycontactname = :emergencycontactname"),
    @NamedQuery(name = "Dimemployee.findByEmergencycontactphone", query = "SELECT d FROM Dimemployee d WHERE d.emergencycontactphone = :emergencycontactphone"),
    @NamedQuery(name = "Dimemployee.findByEmployeenationalidalternatekey", query = "SELECT d FROM Dimemployee d WHERE d.employeenationalidalternatekey = :employeenationalidalternatekey"),
    @NamedQuery(name = "Dimemployee.findByEnddate", query = "SELECT d FROM Dimemployee d WHERE d.enddate = :enddate"),
    @NamedQuery(name = "Dimemployee.findByFirstname", query = "SELECT d FROM Dimemployee d WHERE d.firstname = :firstname"),
    @NamedQuery(name = "Dimemployee.findByGender", query = "SELECT d FROM Dimemployee d WHERE d.gender = :gender"),
    @NamedQuery(name = "Dimemployee.findByHiredate", query = "SELECT d FROM Dimemployee d WHERE d.hiredate = :hiredate"),
    @NamedQuery(name = "Dimemployee.findByLastname", query = "SELECT d FROM Dimemployee d WHERE d.lastname = :lastname"),
    @NamedQuery(name = "Dimemployee.findByLoginid", query = "SELECT d FROM Dimemployee d WHERE d.loginid = :loginid"),
    @NamedQuery(name = "Dimemployee.findByMaritalstatus", query = "SELECT d FROM Dimemployee d WHERE d.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Dimemployee.findByMiddlename", query = "SELECT d FROM Dimemployee d WHERE d.middlename = :middlename"),
    @NamedQuery(name = "Dimemployee.findByNamestyle", query = "SELECT d FROM Dimemployee d WHERE d.namestyle = :namestyle"),
    @NamedQuery(name = "Dimemployee.findByParentemployeenationalidalternatekey", query = "SELECT d FROM Dimemployee d WHERE d.parentemployeenationalidalternatekey = :parentemployeenationalidalternatekey"),
    @NamedQuery(name = "Dimemployee.findByPayfrequency", query = "SELECT d FROM Dimemployee d WHERE d.payfrequency = :payfrequency"),
    @NamedQuery(name = "Dimemployee.findByPhone", query = "SELECT d FROM Dimemployee d WHERE d.phone = :phone"),
    @NamedQuery(name = "Dimemployee.findBySalariedflag", query = "SELECT d FROM Dimemployee d WHERE d.salariedflag = :salariedflag"),
    @NamedQuery(name = "Dimemployee.findBySalespersonflag", query = "SELECT d FROM Dimemployee d WHERE d.salespersonflag = :salespersonflag"),
    @NamedQuery(name = "Dimemployee.findBySickleavehours", query = "SELECT d FROM Dimemployee d WHERE d.sickleavehours = :sickleavehours"),
    @NamedQuery(name = "Dimemployee.findByStartdate", query = "SELECT d FROM Dimemployee d WHERE d.startdate = :startdate"),
    @NamedQuery(name = "Dimemployee.findByStatus", query = "SELECT d FROM Dimemployee d WHERE d.status = :status"),
    @NamedQuery(name = "Dimemployee.findByTitle", query = "SELECT d FROM Dimemployee d WHERE d.title = :title"),
    @NamedQuery(name = "Dimemployee.findByVacationhours", query = "SELECT d FROM Dimemployee d WHERE d.vacationhours = :vacationhours")})
public class Dimemployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEEKEY")
    private Integer employeekey;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASERATE")
    private BigDecimal baserate;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "CURRENTFLAG")
    private short currentflag;
    @Column(name = "DEPARTMENTNAME")
    private String departmentname;
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @Column(name = "EMERGENCYCONTACTNAME")
    private String emergencycontactname;
    @Column(name = "EMERGENCYCONTACTPHONE")
    private String emergencycontactphone;
    @Column(name = "EMPLOYEENATIONALIDALTERNATEKEY")
    private String employeenationalidalternatekey;
    @Lob
    @Column(name = "EMPLOYEEPHOTO")
    private Serializable employeephoto;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "HIREDATE")
    @Temporal(TemporalType.DATE)
    private Date hiredate;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "LOGINID")
    private String loginid;
    @Column(name = "MARITALSTATUS")
    private String maritalstatus;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "NAMESTYLE")
    private short namestyle;
    @Column(name = "PARENTEMPLOYEENATIONALIDALTERNATEKEY")
    private String parentemployeenationalidalternatekey;
    @Column(name = "PAYFREQUENCY")
    private Short payfrequency;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "SALARIEDFLAG")
    private Short salariedflag;
    @Basic(optional = false)
    @Column(name = "SALESPERSONFLAG")
    private short salespersonflag;
    @Column(name = "SICKLEAVEHOURS")
    private Short sickleavehours;
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "VACATIONHOURS")
    private Short vacationhours;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeekey")
    private Collection<Factsalesquota> factsalesquotaCollection;
    @OneToMany(mappedBy = "parentemployeekey")
    private Collection<Dimemployee> dimemployeeCollection;
    @JoinColumn(name = "PARENTEMPLOYEEKEY", referencedColumnName = "EMPLOYEEKEY")
    @ManyToOne
    private Dimemployee parentemployeekey;
    @JoinColumn(name = "SALESTERRITORYKEY", referencedColumnName = "SALESTERRITORYKEY")
    @ManyToOne
    private Dimsalesterritory salesterritorykey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeekey")
    private Collection<Factresellersales> factresellersalesCollection;

    public Dimemployee() {
    }

    public Dimemployee(Integer employeekey) {
        this.employeekey = employeekey;
    }

    public Dimemployee(Integer employeekey, short currentflag, String firstname, String lastname, short namestyle, short salespersonflag) {
        this.employeekey = employeekey;
        this.currentflag = currentflag;
        this.firstname = firstname;
        this.lastname = lastname;
        this.namestyle = namestyle;
        this.salespersonflag = salespersonflag;
    }

    public Integer getEmployeekey() {
        return employeekey;
    }

    public void setEmployeekey(Integer employeekey) {
        this.employeekey = employeekey;
    }

    public BigDecimal getBaserate() {
        return baserate;
    }

    public void setBaserate(BigDecimal baserate) {
        this.baserate = baserate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public short getCurrentflag() {
        return currentflag;
    }

    public void setCurrentflag(short currentflag) {
        this.currentflag = currentflag;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getEmergencycontactname() {
        return emergencycontactname;
    }

    public void setEmergencycontactname(String emergencycontactname) {
        this.emergencycontactname = emergencycontactname;
    }

    public String getEmergencycontactphone() {
        return emergencycontactphone;
    }

    public void setEmergencycontactphone(String emergencycontactphone) {
        this.emergencycontactphone = emergencycontactphone;
    }

    public String getEmployeenationalidalternatekey() {
        return employeenationalidalternatekey;
    }

    public void setEmployeenationalidalternatekey(String employeenationalidalternatekey) {
        this.employeenationalidalternatekey = employeenationalidalternatekey;
    }

    public Serializable getEmployeephoto() {
        return employeephoto;
    }

    public void setEmployeephoto(Serializable employeephoto) {
        this.employeephoto = employeephoto;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public short getNamestyle() {
        return namestyle;
    }

    public void setNamestyle(short namestyle) {
        this.namestyle = namestyle;
    }

    public String getParentemployeenationalidalternatekey() {
        return parentemployeenationalidalternatekey;
    }

    public void setParentemployeenationalidalternatekey(String parentemployeenationalidalternatekey) {
        this.parentemployeenationalidalternatekey = parentemployeenationalidalternatekey;
    }

    public Short getPayfrequency() {
        return payfrequency;
    }

    public void setPayfrequency(Short payfrequency) {
        this.payfrequency = payfrequency;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getSalariedflag() {
        return salariedflag;
    }

    public void setSalariedflag(Short salariedflag) {
        this.salariedflag = salariedflag;
    }

    public short getSalespersonflag() {
        return salespersonflag;
    }

    public void setSalespersonflag(short salespersonflag) {
        this.salespersonflag = salespersonflag;
    }

    public Short getSickleavehours() {
        return sickleavehours;
    }

    public void setSickleavehours(Short sickleavehours) {
        this.sickleavehours = sickleavehours;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getVacationhours() {
        return vacationhours;
    }

    public void setVacationhours(Short vacationhours) {
        this.vacationhours = vacationhours;
    }

    @XmlTransient
    public Collection<Factsalesquota> getFactsalesquotaCollection() {
        return factsalesquotaCollection;
    }

    public void setFactsalesquotaCollection(Collection<Factsalesquota> factsalesquotaCollection) {
        this.factsalesquotaCollection = factsalesquotaCollection;
    }

    @XmlTransient
    public Collection<Dimemployee> getDimemployeeCollection() {
        return dimemployeeCollection;
    }

    public void setDimemployeeCollection(Collection<Dimemployee> dimemployeeCollection) {
        this.dimemployeeCollection = dimemployeeCollection;
    }

    public Dimemployee getParentemployeekey() {
        return parentemployeekey;
    }

    public void setParentemployeekey(Dimemployee parentemployeekey) {
        this.parentemployeekey = parentemployeekey;
    }

    public Dimsalesterritory getSalesterritorykey() {
        return salesterritorykey;
    }

    public void setSalesterritorykey(Dimsalesterritory salesterritorykey) {
        this.salesterritorykey = salesterritorykey;
    }

    @XmlTransient
    public Collection<Factresellersales> getFactresellersalesCollection() {
        return factresellersalesCollection;
    }

    public void setFactresellersalesCollection(Collection<Factresellersales> factresellersalesCollection) {
        this.factresellersalesCollection = factresellersalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeekey != null ? employeekey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimemployee)) {
            return false;
        }
        Dimemployee other = (Dimemployee) object;
        if ((this.employeekey == null && other.employeekey != null) || (this.employeekey != null && !this.employeekey.equals(other.employeekey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimemployee[ employeekey=" + employeekey + " ]";
    }
    
}
