package data;

import data.Address;
import data.Country;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Region.class)
public class Region_ { 

    public static volatile SingularAttribute<Region, Integer> id;
    public static volatile SingularAttribute<Region, String> name;
    public static volatile CollectionAttribute<Region, Address> addressCollection;
    public static volatile SingularAttribute<Region, String> code;
    public static volatile SingularAttribute<Region, Country> countryid;

}