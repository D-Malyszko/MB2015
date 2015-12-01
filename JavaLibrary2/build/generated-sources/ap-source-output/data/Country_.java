package data;

import data.Address;
import data.Region;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Integer> id;
    public static volatile CollectionAttribute<Country, Region> regionCollection;
    public static volatile SingularAttribute<Country, Integer> sequencenumber;
    public static volatile SingularAttribute<Country, String> name;
    public static volatile CollectionAttribute<Country, Address> addressCollection;
    public static volatile SingularAttribute<Country, String> code;
    public static volatile SingularAttribute<Country, String> nativename;
    public static volatile SingularAttribute<Country, String> taxnumberformatregex;

}