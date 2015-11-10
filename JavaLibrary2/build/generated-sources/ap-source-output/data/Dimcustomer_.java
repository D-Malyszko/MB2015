package data;

import data.Dimgeography;
import data.Factinternetsales;
import data.Factsurveyresponse;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Dimcustomer.class)
public class Dimcustomer_ { 

    public static volatile SingularAttribute<Dimcustomer, String> phone;
    public static volatile SingularAttribute<Dimcustomer, String> spanisheducation;
    public static volatile SingularAttribute<Dimcustomer, String> commutedistance;
    public static volatile SingularAttribute<Dimcustomer, BigDecimal> yearlyincome;
    public static volatile SingularAttribute<Dimcustomer, String> lastname;
    public static volatile SingularAttribute<Dimcustomer, Integer> customerkey;
    public static volatile CollectionAttribute<Dimcustomer, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimcustomer, String> title;
    public static volatile SingularAttribute<Dimcustomer, Short> numberchildrenathome;
    public static volatile SingularAttribute<Dimcustomer, String> maritalstatus;
    public static volatile SingularAttribute<Dimcustomer, String> frenchoccupation;
    public static volatile CollectionAttribute<Dimcustomer, Factsurveyresponse> factsurveyresponseCollection;
    public static volatile SingularAttribute<Dimcustomer, String> emailaddress;
    public static volatile SingularAttribute<Dimcustomer, String> englisheducation;
    public static volatile SingularAttribute<Dimcustomer, Short> totalchildren;
    public static volatile SingularAttribute<Dimcustomer, Date> birthdate;
    public static volatile SingularAttribute<Dimcustomer, String> gender;
    public static volatile SingularAttribute<Dimcustomer, Short> numbercarsowned;
    public static volatile SingularAttribute<Dimcustomer, Short> namestyle;
    public static volatile SingularAttribute<Dimcustomer, String> middlename;
    public static volatile SingularAttribute<Dimcustomer, Date> datefirstpurchase;
    public static volatile SingularAttribute<Dimcustomer, String> customeralternatekey;
    public static volatile SingularAttribute<Dimcustomer, String> houseownerflag;
    public static volatile SingularAttribute<Dimcustomer, String> firstname;
    public static volatile SingularAttribute<Dimcustomer, String> suffix;
    public static volatile SingularAttribute<Dimcustomer, String> addressline2;
    public static volatile SingularAttribute<Dimcustomer, String> englishoccupation;
    public static volatile SingularAttribute<Dimcustomer, String> addressline1;
    public static volatile SingularAttribute<Dimcustomer, String> spanishoccupation;
    public static volatile SingularAttribute<Dimcustomer, Dimgeography> geographykey;
    public static volatile SingularAttribute<Dimcustomer, String> frencheducation;

}