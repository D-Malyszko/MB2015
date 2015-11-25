package data;

import data.Dimdate;
import data.Dimemployee;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Factsalesquota.class)
public class Factsalesquota_ { 

    public static volatile SingularAttribute<Factsalesquota, Integer> salesquotakey;
    public static volatile SingularAttribute<Factsalesquota, Short> calendarquarter;
    public static volatile SingularAttribute<Factsalesquota, Short> calendaryear;
    public static volatile SingularAttribute<Factsalesquota, BigDecimal> salesamountquota;
    public static volatile SingularAttribute<Factsalesquota, Dimemployee> employeekey;
    public static volatile SingularAttribute<Factsalesquota, Date> date;
    public static volatile SingularAttribute<Factsalesquota, Dimdate> datekey;

}