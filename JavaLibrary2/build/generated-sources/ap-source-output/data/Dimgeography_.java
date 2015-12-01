package data;

import data.Dimcustomer;
import data.Dimreseller;
import data.Dimsalesterritory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Dimgeography.class)
public class Dimgeography_ { 

    public static volatile SingularAttribute<Dimgeography, Dimsalesterritory> salesterritorykey;
    public static volatile SingularAttribute<Dimgeography, String> spanishcountryregionname;
    public static volatile SingularAttribute<Dimgeography, String> postalcode;
    public static volatile CollectionAttribute<Dimgeography, Dimcustomer> dimcustomerCollection;
    public static volatile SingularAttribute<Dimgeography, String> stateprovincecode;
    public static volatile SingularAttribute<Dimgeography, String> countryregioncode;
    public static volatile SingularAttribute<Dimgeography, String> frenchcountryregionname;
    public static volatile SingularAttribute<Dimgeography, Integer> geographykey;
    public static volatile SingularAttribute<Dimgeography, String> stateprovincename;
    public static volatile SingularAttribute<Dimgeography, String> englishcountryregionname;
    public static volatile CollectionAttribute<Dimgeography, Dimreseller> dimresellerCollection;
    public static volatile SingularAttribute<Dimgeography, String> ipaddresslocator;
    public static volatile SingularAttribute<Dimgeography, String> city;

}