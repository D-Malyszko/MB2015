package data;

import data.Dimgeography;
import data.Factresellersales;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Dimreseller.class)
public class Dimreseller_ { 

    public static volatile SingularAttribute<Dimreseller, BigDecimal> annualsales;
    public static volatile SingularAttribute<Dimreseller, Integer> resellerkey;
    public static volatile SingularAttribute<Dimreseller, String> phone;
    public static volatile SingularAttribute<Dimreseller, Short> ordermonth;
    public static volatile SingularAttribute<Dimreseller, Integer> lastorderyear;
    public static volatile SingularAttribute<Dimreseller, BigDecimal> minpaymentamount;
    public static volatile SingularAttribute<Dimreseller, Character> orderfrequency;
    public static volatile SingularAttribute<Dimreseller, String> bankname;
    public static volatile SingularAttribute<Dimreseller, Integer> firstorderyear;
    public static volatile SingularAttribute<Dimreseller, String> businesstype;
    public static volatile SingularAttribute<Dimreseller, Short> minpaymenttype;
    public static volatile SingularAttribute<Dimreseller, String> resellername;
    public static volatile SingularAttribute<Dimreseller, Integer> numberemployees;
    public static volatile CollectionAttribute<Dimreseller, Factresellersales> factresellersalesCollection;
    public static volatile SingularAttribute<Dimreseller, BigDecimal> annualrevenue;
    public static volatile SingularAttribute<Dimreseller, String> productline;
    public static volatile SingularAttribute<Dimreseller, String> addressline2;
    public static volatile SingularAttribute<Dimreseller, String> addressline1;
    public static volatile SingularAttribute<Dimreseller, String> reselleralternatekey;
    public static volatile SingularAttribute<Dimreseller, Dimgeography> geographykey;
    public static volatile SingularAttribute<Dimreseller, Integer> yearopened;

}