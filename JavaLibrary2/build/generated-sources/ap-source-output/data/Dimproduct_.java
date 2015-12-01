package data;

import data.Dimproductsubcategory;
import data.Factinternetsales;
import data.Factproductinventory;
import data.Factresellersales;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:50")
@StaticMetamodel(Dimproduct.class)
public class Dimproduct_ { 

    public static volatile SingularAttribute<Dimproduct, String> modelname;
    public static volatile SingularAttribute<Dimproduct, Double> weight;
    public static volatile SingularAttribute<Dimproduct, Short> finishedgoodsflag;
    public static volatile SingularAttribute<Dimproduct, String> sizeunitmeasurecode;
    public static volatile SingularAttribute<Dimproduct, Short> safetystocklevel;
    public static volatile SingularAttribute<Dimproduct, String> productalternatekey;
    public static volatile SingularAttribute<Dimproduct, Integer> daystomanufacture;
    public static volatile CollectionAttribute<Dimproduct, Factproductinventory> factproductinventoryCollection;
    public static volatile SingularAttribute<Dimproduct, String> productline;
    public static volatile CollectionAttribute<Dimproduct, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimproduct, Integer> productkey;
    public static volatile SingularAttribute<Dimproduct, String> style;
    public static volatile SingularAttribute<Dimproduct, String> thaidescription;
    public static volatile SingularAttribute<Dimproduct, Serializable> largephoto;
    public static volatile SingularAttribute<Dimproduct, String> englishdescription;
    public static volatile SingularAttribute<Dimproduct, String> chinesedescription;
    public static volatile SingularAttribute<Dimproduct, String> status;
    public static volatile SingularAttribute<Dimproduct, String> weightunitmeasurecode;
    public static volatile SingularAttribute<Dimproduct, String> spanishproductname;
    public static volatile SingularAttribute<Dimproduct, String> frenchproductname;
    public static volatile CollectionAttribute<Dimproduct, Factresellersales> factresellersalesCollection;
    public static volatile SingularAttribute<Dimproduct, String> sizerange;
    public static volatile SingularAttribute<Dimproduct, String> germandescription;
    public static volatile SingularAttribute<Dimproduct, BigDecimal> listprice;
    public static volatile SingularAttribute<Dimproduct, BigDecimal> dealerprice;
    public static volatile SingularAttribute<Dimproduct, String> size;
    public static volatile SingularAttribute<Dimproduct, Short> reorderpoint;
    public static volatile SingularAttribute<Dimproduct, Date> startdate;
    public static volatile SingularAttribute<Dimproduct, String> frenchdescription;
    public static volatile SingularAttribute<Dimproduct, String> hebrewdescription;
    public static volatile SingularAttribute<Dimproduct, String> class1;
    public static volatile SingularAttribute<Dimproduct, String> color;
    public static volatile SingularAttribute<Dimproduct, String> englishproductname;
    public static volatile SingularAttribute<Dimproduct, BigDecimal> standardcost;
    public static volatile SingularAttribute<Dimproduct, String> arabicdescription;
    public static volatile SingularAttribute<Dimproduct, String> japanesedescription;
    public static volatile SingularAttribute<Dimproduct, Date> enddate;
    public static volatile SingularAttribute<Dimproduct, Dimproductsubcategory> productsubcategorykey;
    public static volatile SingularAttribute<Dimproduct, String> turkishdescription;

}