package data;

import data.Factcallcenter;
import data.Factcurrencyrate;
import data.Factinternetsales;
import data.Factproductinventory;
import data.Factresellersales;
import data.Factsalesquota;
import data.Factsurveyresponse;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Dimdate.class)
public class Dimdate_ { 

    public static volatile SingularAttribute<Dimdate, Short> fiscalsemester;
    public static volatile SingularAttribute<Dimdate, Short> weeknumberofyear;
    public static volatile SingularAttribute<Dimdate, Short> calendaryear;
    public static volatile SingularAttribute<Dimdate, Short> fiscalquarter;
    public static volatile CollectionAttribute<Dimdate, Factcallcenter> factcallcenterCollection;
    public static volatile SingularAttribute<Dimdate, String> spanishmonthname;
    public static volatile SingularAttribute<Dimdate, Short> daynumberofweek;
    public static volatile CollectionAttribute<Dimdate, Factsalesquota> factsalesquotaCollection;
    public static volatile CollectionAttribute<Dimdate, Factproductinventory> factproductinventoryCollection;
    public static volatile SingularAttribute<Dimdate, Short> monthnumberofyear;
    public static volatile SingularAttribute<Dimdate, Integer> datekey;
    public static volatile CollectionAttribute<Dimdate, Factresellersales> factresellersalesCollection2;
    public static volatile CollectionAttribute<Dimdate, Factresellersales> factresellersalesCollection1;
    public static volatile CollectionAttribute<Dimdate, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimdate, Short> daynumberofmonth;
    public static volatile CollectionAttribute<Dimdate, Factsurveyresponse> factsurveyresponseCollection;
    public static volatile SingularAttribute<Dimdate, String> spanishdaynameofweek;
    public static volatile SingularAttribute<Dimdate, String> frenchmonthname;
    public static volatile CollectionAttribute<Dimdate, Factinternetsales> factinternetsalesCollection2;
    public static volatile CollectionAttribute<Dimdate, Factinternetsales> factinternetsalesCollection1;
    public static volatile SingularAttribute<Dimdate, Short> calendarquarter;
    public static volatile SingularAttribute<Dimdate, Short> calendarsemester;
    public static volatile SingularAttribute<Dimdate, Date> fulldatealternatekey;
    public static volatile CollectionAttribute<Dimdate, Factresellersales> factresellersalesCollection;
    public static volatile CollectionAttribute<Dimdate, Factcurrencyrate> factcurrencyrateCollection;
    public static volatile SingularAttribute<Dimdate, Short> daynumberofyear;
    public static volatile SingularAttribute<Dimdate, String> englishmonthname;
    public static volatile SingularAttribute<Dimdate, String> englishdaynameofweek;
    public static volatile SingularAttribute<Dimdate, Short> fiscalyear;
    public static volatile SingularAttribute<Dimdate, String> frenchdaynameofweek;

}