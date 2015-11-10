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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "FACTINTERNETSALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factinternetsales.findAll", query = "SELECT f FROM Factinternetsales f"),
    @NamedQuery(name = "Factinternetsales.findByCarriertrackingnumber", query = "SELECT f FROM Factinternetsales f WHERE f.carriertrackingnumber = :carriertrackingnumber"),
    @NamedQuery(name = "Factinternetsales.findByCustomerponumber", query = "SELECT f FROM Factinternetsales f WHERE f.customerponumber = :customerponumber"),
    @NamedQuery(name = "Factinternetsales.findByDiscountamount", query = "SELECT f FROM Factinternetsales f WHERE f.discountamount = :discountamount"),
    @NamedQuery(name = "Factinternetsales.findByDuedate", query = "SELECT f FROM Factinternetsales f WHERE f.duedate = :duedate"),
    @NamedQuery(name = "Factinternetsales.findByExtendedamount", query = "SELECT f FROM Factinternetsales f WHERE f.extendedamount = :extendedamount"),
    @NamedQuery(name = "Factinternetsales.findByFreight", query = "SELECT f FROM Factinternetsales f WHERE f.freight = :freight"),
    @NamedQuery(name = "Factinternetsales.findByOrderdate", query = "SELECT f FROM Factinternetsales f WHERE f.orderdate = :orderdate"),
    @NamedQuery(name = "Factinternetsales.findByOrderquantity", query = "SELECT f FROM Factinternetsales f WHERE f.orderquantity = :orderquantity"),
    @NamedQuery(name = "Factinternetsales.findByProductstandardcost", query = "SELECT f FROM Factinternetsales f WHERE f.productstandardcost = :productstandardcost"),
    @NamedQuery(name = "Factinternetsales.findByRevisionnumber", query = "SELECT f FROM Factinternetsales f WHERE f.revisionnumber = :revisionnumber"),
    @NamedQuery(name = "Factinternetsales.findBySalesamount", query = "SELECT f FROM Factinternetsales f WHERE f.salesamount = :salesamount"),
    @NamedQuery(name = "Factinternetsales.findByShipdate", query = "SELECT f FROM Factinternetsales f WHERE f.shipdate = :shipdate"),
    @NamedQuery(name = "Factinternetsales.findByTaxamt", query = "SELECT f FROM Factinternetsales f WHERE f.taxamt = :taxamt"),
    @NamedQuery(name = "Factinternetsales.findByTotalproductcost", query = "SELECT f FROM Factinternetsales f WHERE f.totalproductcost = :totalproductcost"),
    @NamedQuery(name = "Factinternetsales.findByUnitprice", query = "SELECT f FROM Factinternetsales f WHERE f.unitprice = :unitprice"),
    @NamedQuery(name = "Factinternetsales.findByUnitpricediscountpct", query = "SELECT f FROM Factinternetsales f WHERE f.unitpricediscountpct = :unitpricediscountpct"),
    @NamedQuery(name = "Factinternetsales.findBySalesordernumber", query = "SELECT f FROM Factinternetsales f WHERE f.factinternetsalesPK.salesordernumber = :salesordernumber"),
    @NamedQuery(name = "Factinternetsales.findBySalesorderlinenumber", query = "SELECT f FROM Factinternetsales f WHERE f.factinternetsalesPK.salesorderlinenumber = :salesorderlinenumber")})
public class Factinternetsales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactinternetsalesPK factinternetsalesPK;
    @Column(name = "CARRIERTRACKINGNUMBER")
    private String carriertrackingnumber;
    @Column(name = "CUSTOMERPONUMBER")
    private String customerponumber;
    @Basic(optional = false)
    @Column(name = "DISCOUNTAMOUNT")
    private double discountamount;
    @Column(name = "DUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "EXTENDEDAMOUNT")
    private BigDecimal extendedamount;
    @Basic(optional = false)
    @Column(name = "FREIGHT")
    private BigDecimal freight;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Basic(optional = false)
    @Column(name = "ORDERQUANTITY")
    private short orderquantity;
    @Basic(optional = false)
    @Column(name = "PRODUCTSTANDARDCOST")
    private BigDecimal productstandardcost;
    @Basic(optional = false)
    @Column(name = "REVISIONNUMBER")
    private short revisionnumber;
    @Basic(optional = false)
    @Column(name = "SALESAMOUNT")
    private BigDecimal salesamount;
    @Column(name = "SHIPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipdate;
    @Basic(optional = false)
    @Column(name = "TAXAMT")
    private BigDecimal taxamt;
    @Basic(optional = false)
    @Column(name = "TOTALPRODUCTCOST")
    private BigDecimal totalproductcost;
    @Basic(optional = false)
    @Column(name = "UNITPRICE")
    private BigDecimal unitprice;
    @Basic(optional = false)
    @Column(name = "UNITPRICEDISCOUNTPCT")
    private double unitpricediscountpct;
    @ManyToMany(mappedBy = "factinternetsalesCollection")
    private Collection<Dimsalesreason> dimsalesreasonCollection;
    @JoinColumn(name = "CURRENCYKEY", referencedColumnName = "CURRENCYKEY")
    @ManyToOne(optional = false)
    private Dimcurrency currencykey;
    @JoinColumn(name = "CUSTOMERKEY", referencedColumnName = "CUSTOMERKEY")
    @ManyToOne(optional = false)
    private Dimcustomer customerkey;
    @JoinColumn(name = "SHIPDATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate shipdatekey;
    @JoinColumn(name = "ORDERDATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate orderdatekey;
    @JoinColumn(name = "DUEDATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate duedatekey;
    @JoinColumn(name = "PRODUCTKEY", referencedColumnName = "PRODUCTKEY")
    @ManyToOne(optional = false)
    private Dimproduct productkey;
    @JoinColumn(name = "PROMOTIONKEY", referencedColumnName = "PROMOTIONKEY")
    @ManyToOne(optional = false)
    private Dimpromotion promotionkey;
    @JoinColumn(name = "SALESTERRITORYKEY", referencedColumnName = "SALESTERRITORYKEY")
    @ManyToOne(optional = false)
    private Dimsalesterritory salesterritorykey;

    public Factinternetsales() {
    }

    public Factinternetsales(FactinternetsalesPK factinternetsalesPK) {
        this.factinternetsalesPK = factinternetsalesPK;
    }

    public Factinternetsales(FactinternetsalesPK factinternetsalesPK, double discountamount, BigDecimal extendedamount, BigDecimal freight, short orderquantity, BigDecimal productstandardcost, short revisionnumber, BigDecimal salesamount, BigDecimal taxamt, BigDecimal totalproductcost, BigDecimal unitprice, double unitpricediscountpct) {
        this.factinternetsalesPK = factinternetsalesPK;
        this.discountamount = discountamount;
        this.extendedamount = extendedamount;
        this.freight = freight;
        this.orderquantity = orderquantity;
        this.productstandardcost = productstandardcost;
        this.revisionnumber = revisionnumber;
        this.salesamount = salesamount;
        this.taxamt = taxamt;
        this.totalproductcost = totalproductcost;
        this.unitprice = unitprice;
        this.unitpricediscountpct = unitpricediscountpct;
    }

    public Factinternetsales(String salesordernumber, short salesorderlinenumber) {
        this.factinternetsalesPK = new FactinternetsalesPK(salesordernumber, salesorderlinenumber);
    }

    public FactinternetsalesPK getFactinternetsalesPK() {
        return factinternetsalesPK;
    }

    public void setFactinternetsalesPK(FactinternetsalesPK factinternetsalesPK) {
        this.factinternetsalesPK = factinternetsalesPK;
    }

    public String getCarriertrackingnumber() {
        return carriertrackingnumber;
    }

    public void setCarriertrackingnumber(String carriertrackingnumber) {
        this.carriertrackingnumber = carriertrackingnumber;
    }

    public String getCustomerponumber() {
        return customerponumber;
    }

    public void setCustomerponumber(String customerponumber) {
        this.customerponumber = customerponumber;
    }

    public double getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(double discountamount) {
        this.discountamount = discountamount;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public BigDecimal getExtendedamount() {
        return extendedamount;
    }

    public void setExtendedamount(BigDecimal extendedamount) {
        this.extendedamount = extendedamount;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public short getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(short orderquantity) {
        this.orderquantity = orderquantity;
    }

    public BigDecimal getProductstandardcost() {
        return productstandardcost;
    }

    public void setProductstandardcost(BigDecimal productstandardcost) {
        this.productstandardcost = productstandardcost;
    }

    public short getRevisionnumber() {
        return revisionnumber;
    }

    public void setRevisionnumber(short revisionnumber) {
        this.revisionnumber = revisionnumber;
    }

    public BigDecimal getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(BigDecimal salesamount) {
        this.salesamount = salesamount;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public BigDecimal getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigDecimal taxamt) {
        this.taxamt = taxamt;
    }

    public BigDecimal getTotalproductcost() {
        return totalproductcost;
    }

    public void setTotalproductcost(BigDecimal totalproductcost) {
        this.totalproductcost = totalproductcost;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public double getUnitpricediscountpct() {
        return unitpricediscountpct;
    }

    public void setUnitpricediscountpct(double unitpricediscountpct) {
        this.unitpricediscountpct = unitpricediscountpct;
    }

    @XmlTransient
    public Collection<Dimsalesreason> getDimsalesreasonCollection() {
        return dimsalesreasonCollection;
    }

    public void setDimsalesreasonCollection(Collection<Dimsalesreason> dimsalesreasonCollection) {
        this.dimsalesreasonCollection = dimsalesreasonCollection;
    }

    public Dimcurrency getCurrencykey() {
        return currencykey;
    }

    public void setCurrencykey(Dimcurrency currencykey) {
        this.currencykey = currencykey;
    }

    public Dimcustomer getCustomerkey() {
        return customerkey;
    }

    public void setCustomerkey(Dimcustomer customerkey) {
        this.customerkey = customerkey;
    }

    public Dimdate getShipdatekey() {
        return shipdatekey;
    }

    public void setShipdatekey(Dimdate shipdatekey) {
        this.shipdatekey = shipdatekey;
    }

    public Dimdate getOrderdatekey() {
        return orderdatekey;
    }

    public void setOrderdatekey(Dimdate orderdatekey) {
        this.orderdatekey = orderdatekey;
    }

    public Dimdate getDuedatekey() {
        return duedatekey;
    }

    public void setDuedatekey(Dimdate duedatekey) {
        this.duedatekey = duedatekey;
    }

    public Dimproduct getProductkey() {
        return productkey;
    }

    public void setProductkey(Dimproduct productkey) {
        this.productkey = productkey;
    }

    public Dimpromotion getPromotionkey() {
        return promotionkey;
    }

    public void setPromotionkey(Dimpromotion promotionkey) {
        this.promotionkey = promotionkey;
    }

    public Dimsalesterritory getSalesterritorykey() {
        return salesterritorykey;
    }

    public void setSalesterritorykey(Dimsalesterritory salesterritorykey) {
        this.salesterritorykey = salesterritorykey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factinternetsalesPK != null ? factinternetsalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factinternetsales)) {
            return false;
        }
        Factinternetsales other = (Factinternetsales) object;
        if ((this.factinternetsalesPK == null && other.factinternetsalesPK != null) || (this.factinternetsalesPK != null && !this.factinternetsalesPK.equals(other.factinternetsalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factinternetsales[ factinternetsalesPK=" + factinternetsalesPK + " ]";
    }
    
}
