package data;

import data.Dimorganization;
import data.Factcurrencyrate;
import data.Factinternetsales;
import data.Factresellersales;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Dimcurrency.class)
public class Dimcurrency_ { 

    public static volatile CollectionAttribute<Dimcurrency, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimcurrency, Integer> currencykey;
    public static volatile SingularAttribute<Dimcurrency, String> currencyalternatekey;
    public static volatile CollectionAttribute<Dimcurrency, Factresellersales> factresellersalesCollection;
    public static volatile CollectionAttribute<Dimcurrency, Factcurrencyrate> factcurrencyrateCollection;
    public static volatile SingularAttribute<Dimcurrency, String> currencyname;
    public static volatile CollectionAttribute<Dimcurrency, Dimorganization> dimorganizationCollection;

}