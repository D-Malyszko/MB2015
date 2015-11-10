/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "FACTRESELLERSALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factresellersales.findAll", query = "SELECT f FROM Factresellersales f"),
    @NamedQuery(name = "Factresellersales.findByCarriertrackingnumber", query = "SELECT f FROM Factresellersales f WHERE f.carriertrackingnumber = :carriertrackingnumber"),
    @NamedQuery(name = "Factresellersales.findByCustomerponumber", query = "SELECT f FROM Factresellersales f WHERE f.customerponumber = :customerponumber"),
    @NamedQuery(name = "Factresellersales.findByDiscountamount", query = "SELECT f FROM Factresellersales f WHERE f.discountamount = :discountamount"),
    @NamedQuery(name = "Factresellersales.findByDuedate", query = "SELECT f FROM Factresellersales f WHERE f.duedate = :duedate"),
    @NamedQuery(name = "Factresellersales.findByExtendedamount", query = "SELECT f FROM Factresellersales f WHERE f.extendedamount = :extendedamount"),
    @NamedQuery(name = "Factresellersales.findByFreight", query = "SELECT f FROM Factresellersales f WHERE f.freight = :freight"),
    @NamedQuery(name = "Factresellersales.findByOrderdate", query = "SELECT f FROM Factresellersales f WHERE f.orderdate = :orderdate"),
    @NamedQuery(name = "Factresellersales.findByOrderquantity", query = "SELECT f FROM Factresellersales f WHERE f.orderquantity = :orderquantity"),
    @NamedQuery(name = "Factresellersales.findByProductstandardcost", query = "SELECT f FROM Factresellersales f WHERE f.productstandardcost = :productstandardcost"),
    @NamedQuery(name = "Factresellersales.findByRevisionnumber", query = "SELECT f FROM Factresellersales f WHERE f.revisionnumber = :revisionnumber"),
    @NamedQuery(name = "Factresellersales.findBySalesamount", query = "SELECT f FROM Factresellersales f WHERE f.salesamount = :salesamount"),
    @NamedQuery(name = "Factresellersales.findByShipdate", query = "SELECT f FROM Factresellersales f WHERE f.shipdate = :shipdate"),
    @NamedQuery(name = "Factresellersales.findByTaxamt", query = "SELECT f FROM Factresellersales f WHERE f.taxamt = :taxamt"),
    @NamedQuery(name = "Factresellersales.findByTotalproductcost", query = "SELECT f FROM Factresellersales f WHERE f.totalproductcost = :totalproductcost"),
    @NamedQuery(name = "Factresellersales.findByUnitprice", query = "SELECT f FROM Factresellersales f WHERE f.unitprice = :unitprice"),
    @NamedQuery(name = "Factresellersales.findByUnitpricediscountpct", query = "SELECT f FROM Factresellersales f WHERE f.unitpricediscountpct = :unitpricediscountpct"),
    @NamedQuery(name = "Factresellersales.findBySalesordernumber", query = "SELECT f FROM Factresellersales f WHERE f.factresellersalesPK.salesordernumber = :salesordernumber"),
    @NamedQuery(name = "Factresellersales.findBySalesorderlinenumber", query = "SELECT f FROM Factresellersales f WHERE f.factresellersalesPK.salesorderlinenumber = :salesorderlinenumber")})
public class Factresellersales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactresellersalesPK factresellersalesPK;
    @Column(name = "CARRIERTRACKINGNUMBER")
    private String carriertrackingnumber;
    @Column(name = "CUSTOMERPONUMBER")
    private String customerponumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNTAMOUNT")
    private Double discountamount;
    @Column(name = "DUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Column(name = "EXTENDEDAMOUNT")
    private BigDecimal extendedamount;
    @Column(name = "FREIGHT")
    private BigDecimal freight;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Column(name = "ORDERQUANTITY")
    private Short orderquantity;
    @Column(name = "PRODUCTSTANDARDCOST")
    private BigDecimal productstandardcost;
    @Column(name = "REVISIONNUMBER")
    private Short revisionnumber;
    @Column(name = "SALESAMOUNT")
    private BigDecimal salesamount;
    @Column(name = "SHIPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipdate;
    @Column(name = "TAXAMT")
    private BigDecimal taxamt;
    @Column(name = "TOTALPRODUCTCOST")
    private BigDecimal totalproductcost;
    @Column(name = "UNITPRICE")
    private BigDecimal unitprice;
    @Column(name = "UNITPRICEDISCOUNTPCT")
    private Double unitpricediscountpct;
    @JoinColumn(name = "CURRENCYKEY", referencedColumnName = "CURRENCYKEY")
    @ManyToOne(optional = false)
    private Dimcurrency currencykey;
    @JoinColumn(name = "SHIPDATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate shipdatekey;
    @JoinColumn(name = "DUEDATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate duedatekey;
    @JoinColumn(name = "ORDERDATEKEY", referencedColumnName = "DATEKEY")
    @ManyToOne(optional = false)
    private Dimdate orderdatekey;
    @JoinColumn(name = "EMPLOYEEKEY", referencedColumnName = "EMPLOYEEKEY")
    @ManyToOne(optional = false)
    private Dimemployee employeekey;
    @JoinColumn(name = "PRODUCTKEY", referencedColumnName = "PRODUCTKEY")
    @ManyToOne(optional = false)
    private Dimproduct productkey;
    @JoinColumn(name = "PROMOTIONKEY", referencedColumnName = "PROMOTIONKEY")
    @ManyToOne(optional = false)
    private Dimpromotion promotionkey;
    @JoinColumn(name = "RESELLERKEY", referencedColumnName = "RESELLERKEY")
    @ManyToOne(optional = false)
    private Dimreseller resellerkey;
    @JoinColumn(name = "SALESTERRITORYKEY", referencedColumnName = "SALESTERRITORYKEY")
    @ManyToOne(optional = false)
    private Dimsalesterritory salesterritorykey;

    public Factresellersales() {
    }

    public Factresellersales(FactresellersalesPK factresellersalesPK) {
        this.factresellersalesPK = factresellersalesPK;
    }

    public Factresellersales(String salesordernumber, short salesorderlinenumber) {
        this.factresellersalesPK = new FactresellersalesPK(salesordernumber, salesorderlinenumber);
    }

    public FactresellersalesPK getFactresellersalesPK() {
        return factresellersalesPK;
    }

    public void setFactresellersalesPK(FactresellersalesPK factresellersalesPK) {
        this.factresellersalesPK = factresellersalesPK;
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

    public Double getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(Double discountamount) {
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

    public Short getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(Short orderquantity) {
        this.orderquantity = orderquantity;
    }

    public BigDecimal getProductstandardcost() {
        return productstandardcost;
    }

    public void setProductstandardcost(BigDecimal productstandardcost) {
        this.productstandardcost = productstandardcost;
    }

    public Short getRevisionnumber() {
        return revisionnumber;
    }

    public void setRevisionnumber(Short revisionnumber) {
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

    public Double getUnitpricediscountpct() {
        return unitpricediscountpct;
    }

    public void setUnitpricediscountpct(Double unitpricediscountpct) {
        this.unitpricediscountpct = unitpricediscountpct;
    }

    public Dimcurrency getCurrencykey() {
        return currencykey;
    }

    public void setCurrencykey(Dimcurrency currencykey) {
        this.currencykey = currencykey;
    }

    public Dimdate getShipdatekey() {
        return shipdatekey;
    }

    public void setShipdatekey(Dimdate shipdatekey) {
        this.shipdatekey = shipdatekey;
    }

    public Dimdate getDuedatekey() {
        return duedatekey;
    }

    public void setDuedatekey(Dimdate duedatekey) {
        this.duedatekey = duedatekey;
    }

    public Dimdate getOrderdatekey() {
        return orderdatekey;
    }

    public void setOrderdatekey(Dimdate orderdatekey) {
        this.orderdatekey = orderdatekey;
    }

    public Dimemployee getEmployeekey() {
        return employeekey;
    }

    public void setEmployeekey(Dimemployee employeekey) {
        this.employeekey = employeekey;
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

    public Dimreseller getResellerkey() {
        return resellerkey;
    }

    public void setResellerkey(Dimreseller resellerkey) {
        this.resellerkey = resellerkey;
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
        hash += (factresellersalesPK != null ? factresellersalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factresellersales)) {
            return false;
        }
        Factresellersales other = (Factresellersales) object;
        if ((this.factresellersalesPK == null && other.factresellersalesPK != null) || (this.factresellersalesPK != null && !this.factresellersalesPK.equals(other.factresellersalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Factresellersales[ factresellersalesPK=" + factresellersalesPK + " ]";
    }
    
}
