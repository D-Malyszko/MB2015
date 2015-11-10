package data;

import data.Dimcurrency;
import data.Dimdate;
import data.FactcurrencyratePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Factcurrencyrate.class)
public class Factcurrencyrate_ { 

    public static volatile SingularAttribute<Factcurrencyrate, Dimdate> dimdate;
    public static volatile SingularAttribute<Factcurrencyrate, Dimcurrency> dimcurrency;
    public static volatile SingularAttribute<Factcurrencyrate, FactcurrencyratePK> factcurrencyratePK;
    public static volatile SingularAttribute<Factcurrencyrate, Double> averagerate;
    public static volatile SingularAttribute<Factcurrencyrate, Date> date;
    public static volatile SingularAttribute<Factcurrencyrate, Double> endofdayrate;

}