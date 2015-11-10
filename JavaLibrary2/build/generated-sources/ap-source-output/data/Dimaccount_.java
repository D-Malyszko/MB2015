package data;

import data.Dimaccount;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Dimaccount.class)
public class Dimaccount_ { 

    public static volatile SingularAttribute<Dimaccount, String> valuetype;
    public static volatile SingularAttribute<Dimaccount, String> accountdescription;
    public static volatile SingularAttribute<Dimaccount, Integer> accountkey;
    public static volatile SingularAttribute<Dimaccount, Dimaccount> parentaccountkey;
    public static volatile SingularAttribute<Dimaccount, Integer> accountcodealternatekey;
    public static volatile SingularAttribute<Dimaccount, String> custommemberoptions;
    public static volatile SingularAttribute<Dimaccount, Integer> parentaccountcodealternatekey;
    public static volatile SingularAttribute<Dimaccount, String> accounttype;
    public static volatile SingularAttribute<Dimaccount, String> custommembers;
    public static volatile CollectionAttribute<Dimaccount, Dimaccount> dimaccountCollection;
    public static volatile SingularAttribute<Dimaccount, String> operator;

}