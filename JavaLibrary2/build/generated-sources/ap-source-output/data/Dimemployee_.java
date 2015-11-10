package data;

import data.Dimemployee;
import data.Dimsalesterritory;
import data.Factresellersales;
import data.Factsalesquota;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:01")
@StaticMetamodel(Dimemployee.class)
public class Dimemployee_ { 

    public static volatile SingularAttribute<Dimemployee, Date> hiredate;
    public static volatile SingularAttribute<Dimemployee, String> phone;
    public static volatile SingularAttribute<Dimemployee, Short> salespersonflag;
    public static volatile SingularAttribute<Dimemployee, Serializable> employeephoto;
    public static volatile SingularAttribute<Dimemployee, Short> payfrequency;
    public static volatile SingularAttribute<Dimemployee, String> lastname;
    public static volatile SingularAttribute<Dimemployee, Short> currentflag;
    public static volatile CollectionAttribute<Dimemployee, Factsalesquota> factsalesquotaCollection;
    public static volatile SingularAttribute<Dimemployee, Dimemployee> parentemployeekey;
    public static volatile SingularAttribute<Dimemployee, String> title;
    public static volatile SingularAttribute<Dimemployee, Short> salariedflag;
    public static volatile SingularAttribute<Dimemployee, String> maritalstatus;
    public static volatile SingularAttribute<Dimemployee, String> emailaddress;
    public static volatile SingularAttribute<Dimemployee, String> parentemployeenationalidalternatekey;
    public static volatile SingularAttribute<Dimemployee, String> employeenationalidalternatekey;
    public static volatile SingularAttribute<Dimemployee, Date> birthdate;
    public static volatile SingularAttribute<Dimemployee, String> gender;
    public static volatile SingularAttribute<Dimemployee, BigDecimal> baserate;
    public static volatile SingularAttribute<Dimemployee, Dimsalesterritory> salesterritorykey;
    public static volatile CollectionAttribute<Dimemployee, Dimemployee> dimemployeeCollection;
    public static volatile SingularAttribute<Dimemployee, Short> namestyle;
    public static volatile SingularAttribute<Dimemployee, String> middlename;
    public static volatile SingularAttribute<Dimemployee, String> status;
    public static volatile SingularAttribute<Dimemployee, Short> vacationhours;
    public static volatile SingularAttribute<Dimemployee, Short> sickleavehours;
    public static volatile CollectionAttribute<Dimemployee, Factresellersales> factresellersalesCollection;
    public static volatile SingularAttribute<Dimemployee, String> loginid;
    public static volatile SingularAttribute<Dimemployee, String> firstname;
    public static volatile SingularAttribute<Dimemployee, String> departmentname;
    public static volatile SingularAttribute<Dimemployee, Date> startdate;
    public static volatile SingularAttribute<Dimemployee, String> emergencycontactname;
    public static volatile SingularAttribute<Dimemployee, Integer> employeekey;
    public static volatile SingularAttribute<Dimemployee, Date> enddate;
    public static volatile SingularAttribute<Dimemployee, String> emergencycontactphone;

}