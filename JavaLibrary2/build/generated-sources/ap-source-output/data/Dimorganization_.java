package data;

import data.Dimcurrency;
import data.Dimorganization;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Dimorganization.class)
public class Dimorganization_ { 

    public static volatile SingularAttribute<Dimorganization, String> organizationname;
    public static volatile SingularAttribute<Dimorganization, Integer> organizationkey;
    public static volatile SingularAttribute<Dimorganization, Dimcurrency> currencykey;
    public static volatile SingularAttribute<Dimorganization, Dimorganization> parentorganizationkey;
    public static volatile SingularAttribute<Dimorganization, String> percentageofownership;
    public static volatile CollectionAttribute<Dimorganization, Dimorganization> dimorganizationCollection;

}