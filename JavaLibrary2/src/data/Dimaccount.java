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
@Table(name = "DIMACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimaccount.findAll", query = "SELECT d FROM Dimaccount d"),
    @NamedQuery(name = "Dimaccount.findByAccountkey", query = "SELECT d FROM Dimaccount d WHERE d.accountkey = :accountkey"),
    @NamedQuery(name = "Dimaccount.findByAccountcodealternatekey", query = "SELECT d FROM Dimaccount d WHERE d.accountcodealternatekey = :accountcodealternatekey"),
    @NamedQuery(name = "Dimaccount.findByAccountdescription", query = "SELECT d FROM Dimaccount d WHERE d.accountdescription = :accountdescription"),
    @NamedQuery(name = "Dimaccount.findByAccounttype", query = "SELECT d FROM Dimaccount d WHERE d.accounttype = :accounttype"),
    @NamedQuery(name = "Dimaccount.findByCustommemberoptions", query = "SELECT d FROM Dimaccount d WHERE d.custommemberoptions = :custommemberoptions"),
    @NamedQuery(name = "Dimaccount.findByCustommembers", query = "SELECT d FROM Dimaccount d WHERE d.custommembers = :custommembers"),
    @NamedQuery(name = "Dimaccount.findByOperator", query = "SELECT d FROM Dimaccount d WHERE d.operator = :operator"),
    @NamedQuery(name = "Dimaccount.findByParentaccountcodealternatekey", query = "SELECT d FROM Dimaccount d WHERE d.parentaccountcodealternatekey = :parentaccountcodealternatekey"),
    @NamedQuery(name = "Dimaccount.findByValuetype", query = "SELECT d FROM Dimaccount d WHERE d.valuetype = :valuetype")})
public class Dimaccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ACCOUNTKEY")
    private Integer accountkey;
    @Column(name = "ACCOUNTCODEALTERNATEKEY")
    private Integer accountcodealternatekey;
    @Column(name = "ACCOUNTDESCRIPTION")
    private String accountdescription;
    @Column(name = "ACCOUNTTYPE")
    private String accounttype;
    @Column(name = "CUSTOMMEMBEROPTIONS")
    private String custommemberoptions;
    @Column(name = "CUSTOMMEMBERS")
    private String custommembers;
    @Column(name = "OPERATOR")
    private String operator;
    @Column(name = "PARENTACCOUNTCODEALTERNATEKEY")
    private Integer parentaccountcodealternatekey;
    @Column(name = "VALUETYPE")
    private String valuetype;
    @OneToMany(mappedBy = "parentaccountkey")
    private Collection<Dimaccount> dimaccountCollection;
    @JoinColumn(name = "PARENTACCOUNTKEY", referencedColumnName = "ACCOUNTKEY")
    @ManyToOne
    private Dimaccount parentaccountkey;

    public Dimaccount() {
    }

    public Dimaccount(Integer accountkey) {
        this.accountkey = accountkey;
    }

    public Integer getAccountkey() {
        return accountkey;
    }

    public void setAccountkey(Integer accountkey) {
        this.accountkey = accountkey;
    }

    public Integer getAccountcodealternatekey() {
        return accountcodealternatekey;
    }

    public void setAccountcodealternatekey(Integer accountcodealternatekey) {
        this.accountcodealternatekey = accountcodealternatekey;
    }

    public String getAccountdescription() {
        return accountdescription;
    }

    public void setAccountdescription(String accountdescription) {
        this.accountdescription = accountdescription;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getCustommemberoptions() {
        return custommemberoptions;
    }

    public void setCustommemberoptions(String custommemberoptions) {
        this.custommemberoptions = custommemberoptions;
    }

    public String getCustommembers() {
        return custommembers;
    }

    public void setCustommembers(String custommembers) {
        this.custommembers = custommembers;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getParentaccountcodealternatekey() {
        return parentaccountcodealternatekey;
    }

    public void setParentaccountcodealternatekey(Integer parentaccountcodealternatekey) {
        this.parentaccountcodealternatekey = parentaccountcodealternatekey;
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    @XmlTransient
    public Collection<Dimaccount> getDimaccountCollection() {
        return dimaccountCollection;
    }

    public void setDimaccountCollection(Collection<Dimaccount> dimaccountCollection) {
        this.dimaccountCollection = dimaccountCollection;
    }

    public Dimaccount getParentaccountkey() {
        return parentaccountkey;
    }

    public void setParentaccountkey(Dimaccount parentaccountkey) {
        this.parentaccountkey = parentaccountkey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountkey != null ? accountkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimaccount)) {
            return false;
        }
        Dimaccount other = (Dimaccount) object;
        if ((this.accountkey == null && other.accountkey != null) || (this.accountkey != null && !this.accountkey.equals(other.accountkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimaccount[ accountkey=" + accountkey + " ]";
    }
    
}
