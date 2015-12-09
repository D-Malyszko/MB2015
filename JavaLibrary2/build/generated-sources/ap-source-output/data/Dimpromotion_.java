package data;

import data.Factinternetsales;
import data.Factresellersales;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Dimpromotion.class)
public class Dimpromotion_ { 

    public static volatile SingularAttribute<Dimpromotion, Integer> promotionkey;
    public static volatile SingularAttribute<Dimpromotion, Double> discountpct;
    public static volatile SingularAttribute<Dimpromotion, String> spanishpromotioncategory;
    public static volatile SingularAttribute<Dimpromotion, String> frenchpromotionname;
    public static volatile SingularAttribute<Dimpromotion, String> englishpromotiontype;
    public static volatile SingularAttribute<Dimpromotion, String> spanishpromotionname;
    public static volatile CollectionAttribute<Dimpromotion, Factresellersales> factresellersalesCollection;
    public static volatile SingularAttribute<Dimpromotion, Integer> maxqty;
    public static volatile SingularAttribute<Dimpromotion, String> englishpromotionname;
    public static volatile SingularAttribute<Dimpromotion, String> frenchpromotioncategory;
    public static volatile CollectionAttribute<Dimpromotion, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimpromotion, Integer> minqty;
    public static volatile SingularAttribute<Dimpromotion, Date> startdate;
    public static volatile SingularAttribute<Dimpromotion, String> spanishpromotiontype;
    public static volatile SingularAttribute<Dimpromotion, String> englishpromotioncategory;
    public static volatile SingularAttribute<Dimpromotion, String> frenchpromotiontype;
    public static volatile SingularAttribute<Dimpromotion, Integer> promotionalternatekey;
    public static volatile SingularAttribute<Dimpromotion, Date> enddate;

}