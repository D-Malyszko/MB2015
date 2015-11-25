package data;

import data.Dimcurrency;
import data.Dimdate;
import data.Dimemployee;
import data.Dimproduct;
import data.Dimpromotion;
import data.Dimreseller;
import data.Dimsalesterritory;
import data.FactresellersalesPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Factresellersales.class)
public class Factresellersales_ { 

    public static volatile SingularAttribute<Factresellersales, Dimpromotion> promotionkey;
    public static volatile SingularAttribute<Factresellersales, Dimreseller> resellerkey;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> salesamount;
    public static volatile SingularAttribute<Factresellersales, String> carriertrackingnumber;
    public static volatile SingularAttribute<Factresellersales, Dimproduct> productkey;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> unitprice;
    public static volatile SingularAttribute<Factresellersales, Date> duedate;
    public static volatile SingularAttribute<Factresellersales, Double> discountamount;
    public static volatile SingularAttribute<Factresellersales, Short> revisionnumber;
    public static volatile SingularAttribute<Factresellersales, Dimsalesterritory> salesterritorykey;
    public static volatile SingularAttribute<Factresellersales, Dimcurrency> currencykey;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> extendedamount;
    public static volatile SingularAttribute<Factresellersales, Date> orderdate;
    public static volatile SingularAttribute<Factresellersales, Dimdate> shipdatekey;
    public static volatile SingularAttribute<Factresellersales, String> customerponumber;
    public static volatile SingularAttribute<Factresellersales, Date> shipdate;
    public static volatile SingularAttribute<Factresellersales, FactresellersalesPK> factresellersalesPK;
    public static volatile SingularAttribute<Factresellersales, Dimdate> orderdatekey;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> totalproductcost;
    public static volatile SingularAttribute<Factresellersales, Short> orderquantity;
    public static volatile SingularAttribute<Factresellersales, Dimdate> duedatekey;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> freight;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> taxamt;
    public static volatile SingularAttribute<Factresellersales, Double> unitpricediscountpct;
    public static volatile SingularAttribute<Factresellersales, BigDecimal> productstandardcost;
    public static volatile SingularAttribute<Factresellersales, Dimemployee> employeekey;

}