/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "DIMSCENARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimscenario.findAll", query = "SELECT d FROM Dimscenario d"),
    @NamedQuery(name = "Dimscenario.findByScenariokey", query = "SELECT d FROM Dimscenario d WHERE d.scenariokey = :scenariokey"),
    @NamedQuery(name = "Dimscenario.findByScenarioname", query = "SELECT d FROM Dimscenario d WHERE d.scenarioname = :scenarioname")})
public class Dimscenario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SCENARIOKEY")
    private Integer scenariokey;
    @Column(name = "SCENARIONAME")
    private String scenarioname;

    public Dimscenario() {
    }

    public Dimscenario(Integer scenariokey) {
        this.scenariokey = scenariokey;
    }

    public Integer getScenariokey() {
        return scenariokey;
    }

    public void setScenariokey(Integer scenariokey) {
        this.scenariokey = scenariokey;
    }

    public String getScenarioname() {
        return scenarioname;
    }

    public void setScenarioname(String scenarioname) {
        this.scenarioname = scenarioname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scenariokey != null ? scenariokey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dimscenario)) {
            return false;
        }
        Dimscenario other = (Dimscenario) object;
        if ((this.scenariokey == null && other.scenariokey != null) || (this.scenariokey != null && !this.scenariokey.equals(other.scenariokey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Dimscenario[ scenariokey=" + scenariokey + " ]";
    }
    
}
