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
@Table(name = "DIMDEPARTMENTGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimdepartmentgroup.findAll", query = "SELECT d FROM Dimdepartmentgroup d"),
    @NamedQuery(name = "Dimdepartmentgroup.findByDepartmentgroupkey", query = "SELECT d FROM Dimdepartmentgroup d WHERE d.departmentgroupkey = :departmentgroupkey"),
    @NamedQuery(name = "Dimdepartmentgroup.findByDepartmentgroupname", query = "SELECT d FROM Dimdepartmentgroup d WHERE d.departmentgroupname = :departmentgroupname")})
public class Dimdepartmentgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENTGROUPKEY")
    private Integer departmentgroupkey;
    @Column(name = "DEPARTMENTGROUPNAME")
    private String departmentgroupname;
    @OneToMany(mappedBy = "parentdepartmentgroupkey")
    private Collection<Dimdepartmentgroup> dimdepartmentgroupCollection;
    @JoinColumn(name = "PARENTDEPARTMENTGROUPKEY", referencedColumnName = "DEPARTMENTGROUPKEY")
    @ManyToOne
    private Dimdepartmentgroup parentdepartmentgroupkey;

    public Dimdepartmentgroup() {
    }

    public Dimdepartmentgroup(Integer departmentgroupkey) {
        this.departmentgroupkey = departmentgroupkey;
    }

    public Integer getDepartmentgroupkey() {
        return departmentgroupkey;
    }

    public void setDepartmentgroupkey(Integer departmentgroupkey) {
        this.departmentgroupkey = departmentgroupkey;
    }

    public String getDepartmentgroupname() {
        return departmentgroupname;
    }

    public void setDepartmentgroupname(String departmentgroupname) {
        this.departmentgroupname = departmentgroupname;
    }

    @XmlTransient
    public Collection<Dimdepartmentgroup> getDimdepartmentgroupCollection() {
        return dimdepartmentgroupCollection;
    }

    public void setDimdepartmentgroupCollection(Collection<Dimdepartmentgroup> dimdepartmentgroupCollection) {
        this.dimdepartmentgroupCollection = dimdepartmentgroupCollection;
    }

    public Dimdepartmentgroup getParentdepartmentgroupkey() {
        return parentdepartmentgroupkey;
    }

    public void setParentdepartmentgroupkey(Dimdepartmentgroup parentdepartmentgroupkey) {
        this.parentdepartmentgroupkey = parentdepartmentgroupkey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentgroupkey != null ? departmentgroupkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimdepartmentgroup)) {
            return false;
        }
        Dimdepartmentgroup other = (Dimdepartmentgroup) object;
        if ((this.departmentgroupkey == null && other.departmentgroupkey != null) || (this.departmentgroupkey != null && !this.departmentgroupkey.equals(other.departmentgroupkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimdepartmentgroup[ departmentgroupkey=" + departmentgroupkey + " ]";
    }
    
}
