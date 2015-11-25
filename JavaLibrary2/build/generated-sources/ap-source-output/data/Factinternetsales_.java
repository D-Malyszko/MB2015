package data;

import data.Dimcurrency;
import data.Dimcustomer;
import data.Dimdate;
import data.Dimproduct;
import data.Dimpromotion;
import data.Dimsalesreason;
import data.Dimsalesterritory;
import data.FactinternetsalesPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Factinternetsales.class)
public class Factinternetsales_ { 

    public static volatile SingularAttribute<Factinternetsales, Dimpromotion> promotionkey;
    public static volatile CollectionAttribute<Factinternetsales, Dimsalesreason> dimsalesreasonCollection;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> salesamount;
    public static volatile SingularAttribute<Factinternetsales, Dimcustomer> customerkey;
    public static volatile SingularAttribute<Factinternetsales, String> carriertrackingnumber;
    public static volatile SingularAttribute<Factinternetsales, Dimproduct> productkey;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> unitprice;
    public static volatile SingularAttribute<Factinternetsales, Date> duedate;
    public static volatile SingularAttribute<Factinternetsales, Double> discountamount;
    public static volatile SingularAttribute<Factinternetsales, Short> revisionnumber;
    public static volatile SingularAttribute<Factinternetsales, Dimsalesterritory> salesterritorykey;
    public static volatile SingularAttribute<Factinternetsales, Dimcurrency> currencykey;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> extendedamount;
    public static volatile SingularAttribute<Factinternetsales, Date> orderdate;
    public static volatile SingularAttribute<Factinternetsales, Dimdate> shipdatekey;
    public static volatile SingularAttribute<Factinternetsales, String> customerponumber;
    public static volatile SingularAttribute<Factinternetsales, Date> shipdate;
    public static volatile SingularAttribute<Factinternetsales, Dimdate> orderdatekey;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> totalproductcost;
    public static volatile SingularAttribute<Factinternetsales, Short> orderquantity;
    public static volatile SingularAttribute<Factinternetsales, Dimdate> duedatekey;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> freight;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> taxamt;
    public static volatile SingularAttribute<Factinternetsales, Double> unitpricediscountpct;
    public static volatile SingularAttribute<Factinternetsales, BigDecimal> productstandardcost;
    public static volatile SingularAttribute<Factinternetsales, FactinternetsalesPK> factinternetsalesPK;

}