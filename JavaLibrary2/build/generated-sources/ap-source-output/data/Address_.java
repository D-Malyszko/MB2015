package data;

import data.Assetbankuser;
import data.Country;
import data.Region;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile CollectionAttribute<Address, Assetbankuser> assetbankuserCollection;
    public static volatile SingularAttribute<Address, String> county;
    public static volatile SingularAttribute<Address, Region> regionid;
    public static volatile SingularAttribute<Address, String> address1;
    public static volatile SingularAttribute<Address, String> address2;
    public static volatile SingularAttribute<Address, String> town;
    public static volatile SingularAttribute<Address, String> postcode;
    public static volatile SingularAttribute<Address, Country> countryid;

}