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
@Table(name = "FACTSURVEYRESPONSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factsurveyresponse.findAll", query = "SELECT f FROM Factsurveyresponse f"),
    @NamedQuery(name = "Factsurveyresponse.findBySurveyresponsekey", query = "SELECT f FROM Factsurveyresponse f WHERE f.surveyresponsekey = :surveyresponsekey"),
    @NamedQuery(name = "Factsurveyresponse.findByDate", query = "SELECT f FROM Factsurveyresponse f WHERE f.date = :date"),
    @NamedQuery(name = "Factsurveyresponse.findByEnglishproductcategoryname", query = "SELECT f FROM Factsurveyresponse f WHERE f.englishproductcategoryname = :englishproductcategoryname"),
    @NamedQuery(name = "Factsurveyresponse.findByEnglishproductsubcategoryname", query = "SELECT f FROM Factsurveyresponse f WHERE f.englishproductsubcategoryname = :englishproductsubcategoryname"),
    @NamedQuery(name = "Factsurveyresponse.findByProductcategorykey", query = "SELECT f FROM Factsurveyresponse f WHERE f.productcategorykey = :productcategorykey"),
    @NamedQuery(name = "Factsurveyresponse.findByProductsubcategorykey", query = "SELECT f FROM Factsurveyresponse f WHERE f.productsubcategorykey = :productsubcategorykey")})
public class Factsurveyresponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SURVEYRESPONSEKEY")
    private Integer surveyresponsekey;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "ENGLISHPRODUCTCATEGORYNAME")
    private String englishproductcategoryname;
    @Basic(optional = false)
    @Column(name = "ENGLISHPRODUCTSUBCATEGORYNAME")
    private String englishproductsubcategoryname;
    @Basic(optional = false)
    @Column(name = "PRODUCTCATEGORYKEY")
    private int productcategorykey;
    @Basic(optional = false)
    @Column(name = "PRODUCTSUBCATEGORYKEY")
    private int productsubcategorykey;
    @JoinColumn(name = "CUSTOMERKEY", referencedColumnName = "CUSTOMERKEY")
    @ManyToOne(optional = false)
    private Dimcustomer customerkey;
    @JoinColumn(name = "DATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate datekey;

    public Factsurveyresponse() {
    }

    public Factsurveyresponse(Integer surveyresponsekey) {
        this.surveyresponsekey = surveyresponsekey;
    }

    public Factsurveyresponse(Integer surveyresponsekey, String englishproductcategoryname, String englishproductsubcategoryname, int productcategorykey, int productsubcategorykey) {
        this.surveyresponsekey = surveyresponsekey;
        this.englishproductcategoryname = englishproductcategoryname;
        this.englishproductsubcategoryname = englishproductsubcategoryname;
        this.productcategorykey = productcategorykey;
        this.productsubcategorykey = productsubcategorykey;
    }

    public Integer getSurveyresponsekey() {
        return surveyresponsekey;
    }

    public void setSurveyresponsekey(Integer surveyresponsekey) {
        this.surveyresponsekey = surveyresponsekey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEnglishproductcategoryname() {
        return englishproductcategoryname;
    }

    public void setEnglishproductcategoryname(String englishproductcategoryname) {
        this.englishproductcategoryname = englishproductcategoryname;
    }

    public String getEnglishproductsubcategoryname() {
        return englishproductsubcategoryname;
    }

    public void setEnglishproductsubcategoryname(String englishproductsubcategoryname) {
        this.englishproductsubcategoryname = englishproductsubcategoryname;
    }

    public int getProductcategorykey() {
        return productcategorykey;
    }

    public void setProductcategorykey(int productcategorykey) {
        this.productcategorykey = productcategorykey;
    }

    public int getProductsubcategorykey() {
        return productsubcategorykey;
    }

    public void setProductsubcategorykey(int productsubcategorykey) {
        this.productsubcategorykey = productsubcategorykey;
    }

    public Dimcustomer getCustomerkey() {
        return customerkey;
    }

    public void setCustomerkey(Dimcustomer customerkey) {
        this.customerkey = customerkey;
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
        hash += (surveyresponsekey != null ? surveyresponsekey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factsurveyresponse)) {
            return false;
        }
        Factsurveyresponse other = (Factsurveyresponse) object;
        if ((this.surveyresponsekey == null && other.surveyresponsekey != null) || (this.surveyresponsekey != null && !this.surveyresponsekey.equals(other.surveyresponsekey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factsurveyresponse[ surveyresponsekey=" + surveyresponsekey + " ]";
    }
    
}
