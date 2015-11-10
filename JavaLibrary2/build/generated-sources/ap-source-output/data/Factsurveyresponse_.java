package data;

import data.Dimcustomer;
import data.Dimdate;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Factsurveyresponse.class)
public class Factsurveyresponse_ { 

    public static volatile SingularAttribute<Factsurveyresponse, Integer> surveyresponsekey;
    public static volatile SingularAttribute<Factsurveyresponse, Integer> productcategorykey;
    public static volatile SingularAttribute<Factsurveyresponse, String> englishproductcategoryname;
    public static volatile SingularAttribute<Factsurveyresponse, Dimcustomer> customerkey;
    public static volatile SingularAttribute<Factsurveyresponse, Date> date;
    public static volatile SingularAttribute<Factsurveyresponse, Dimdate> datekey;
    public static volatile SingularAttribute<Factsurveyresponse, String> englishproductsubcategoryname;
    public static volatile SingularAttribute<Factsurveyresponse, Integer> productsubcategorykey;

}