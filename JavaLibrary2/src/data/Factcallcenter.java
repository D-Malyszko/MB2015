/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "FACTCALLCENTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factcallcenter.findAll", query = "SELECT f FROM Factcallcenter f"),
    @NamedQuery(name = "Factcallcenter.findByFactcallcenterid", query = "SELECT f FROM Factcallcenter f WHERE f.factcallcenterid = :factcallcenterid"),
    @NamedQuery(name = "Factcallcenter.findByAutomaticresponses", query = "SELECT f FROM Factcallcenter f WHERE f.automaticresponses = :automaticresponses"),
    @NamedQuery(name = "Factcallcenter.findByAveragetimeperissue", query = "SELECT f FROM Factcallcenter f WHERE f.averagetimeperissue = :averagetimeperissue"),
    @NamedQuery(name = "Factcallcenter.findByCalls", query = "SELECT f FROM Factcallcenter f WHERE f.calls = :calls"),
    @NamedQuery(name = "Factcallcenter.findByDate", query = "SELECT f FROM Factcallcenter f WHERE f.date = :date"),
    @NamedQuery(name = "Factcallcenter.findByIssuesraised", query = "SELECT f FROM Factcallcenter f WHERE f.issuesraised = :issuesraised"),
    @NamedQuery(name = "Factcallcenter.findByLeveloneoperators", query = "SELECT f FROM Factcallcenter f WHERE f.leveloneoperators = :leveloneoperators"),
    @NamedQuery(name = "Factcallcenter.findByLeveltwooperators", query = "SELECT f FROM Factcallcenter f WHERE f.leveltwooperators = :leveltwooperators"),
    @NamedQuery(name = "Factcallcenter.findByOrders", query = "SELECT f FROM Factcallcenter f WHERE f.orders = :orders"),
    @NamedQuery(name = "Factcallcenter.findByServicegrade", query = "SELECT f FROM Factcallcenter f WHERE f.servicegrade = :servicegrade"),
    @NamedQuery(name = "Factcallcenter.findByShift", query = "SELECT f FROM Factcallcenter f WHERE f.shift = :shift"),
    @NamedQuery(name = "Factcallcenter.findByTotaloperators", query = "SELECT f FROM Factcallcenter f WHERE f.totaloperators = :totaloperators"),
    @NamedQuery(name = "Factcallcenter.findByWagetype", query = "SELECT f FROM Factcallcenter f WHERE f.wagetype = :wagetype")})
public class Factcallcenter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FACTCALLCENTERID")
    private Integer factcallcenterid;
    @Basic(optional = false)
    @Column(name = "AUTOMATICRESPONSES")
    private int automaticresponses;
    @Basic(optional = false)
    @Column(name = "AVERAGETIMEPERISSUE")
    private short averagetimeperissue;
    @Basic(optional = false)
    @Column(name = "CALLS")
    private int calls;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "ISSUESRAISED")
    private short issuesraised;
    @Basic(optional = false)
    @Column(name = "LEVELONEOPERATORS")
    private short leveloneoperators;
    @Basic(optional = false)
    @Column(name = "LEVELTWOOPERATORS")
    private short leveltwooperators;
    @Basic(optional = false)
    @Column(name = "ORDERS")
    private int orders;
    @Basic(optional = false)
    @Column(name = "SERVICEGRADE")
    private double servicegrade;
    @Basic(optional = false)
    @Column(name = "SHIFT")
    private String shift;
    @Basic(optional = false)
    @Column(name = "TOTALOPERATORS")
    private short totaloperators;
    @Basic(optional = false)
    @Column(name = "WAGETYPE")
    private String wagetype;
    @JoinColumn(name = "DATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate datekey;

    public Factcallcenter() {
    }

    public Factcallcenter(Integer factcallcenterid) {
        this.factcallcenterid = factcallcenterid;
    }

    public Factcallcenter(Integer factcallcenterid, int automaticresponses, short averagetimeperissue, int calls, short issuesraised, short leveloneoperators, short leveltwooperators, int orders, double servicegrade, String shift, short totaloperators, String wagetype) {
        this.factcallcenterid = factcallcenterid;
        this.automaticresponses = automaticresponses;
        this.averagetimeperissue = averagetimeperissue;
        this.calls = calls;
        this.issuesraised = issuesraised;
        this.leveloneoperators = leveloneoperators;
        this.leveltwooperators = leveltwooperators;
        this.orders = orders;
        this.servicegrade = servicegrade;
        this.shift = shift;
        this.totaloperators = totaloperators;
        this.wagetype = wagetype;
    }

    public Integer getFactcallcenterid() {
        return factcallcenterid;
    }

    public void setFactcallcenterid(Integer factcallcenterid) {
        this.factcallcenterid = factcallcenterid;
    }

    public int getAutomaticresponses() {
        return automaticresponses;
    }

    public void setAutomaticresponses(int automaticresponses) {
        this.automaticresponses = automaticresponses;
    }

    public short getAveragetimeperissue() {
        return averagetimeperissue;
    }

    public void setAveragetimeperissue(short averagetimeperissue) {
        this.averagetimeperissue = averagetimeperissue;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getIssuesraised() {
        return issuesraised;
    }

    public void setIssuesraised(short issuesraised) {
        this.issuesraised = issuesraised;
    }

    public short getLeveloneoperators() {
        return leveloneoperators;
    }

    public void setLeveloneoperators(short leveloneoperators) {
        this.leveloneoperators = leveloneoperators;
    }

    public short getLeveltwooperators() {
        return leveltwooperators;
    }

    public void setLeveltwooperators(short leveltwooperators) {
        this.leveltwooperators = leveltwooperators;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public double getServicegrade() {
        return servicegrade;
    }

    public void setServicegrade(double servicegrade) {
        this.servicegrade = servicegrade;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public short getTotaloperators() {
        return totaloperators;
    }

    public void setTotaloperators(short totaloperators) {
        this.totaloperators = totaloperators;
    }

    public String getWagetype() {
        return wagetype;
    }

    public void setWagetype(String wagetype) {
        this.wagetype = wagetype;
    }

    public Dimdate getDatekey() {
        return datekey;
    }

    public void setDatekey(Dimdate datekey) {
        this.datekey = datekey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factcallcenterid != null ? factcallcenterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factcallcenter)) {
            return false;
        }
        Factcallcenter other = (Factcallcenter) object;
        if ((this.factcallcenterid == null && other.factcallcenterid != null) || (this.factcallcenterid != null && !this.factcallcenterid.equals(other.factcallcenterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factcallcenter[ factcallcenterid=" + factcallcenterid + " ]";
    }
    
}
