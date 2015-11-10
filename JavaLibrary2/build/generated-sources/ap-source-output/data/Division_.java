package data;

import data.Assetbankuser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Division.class)
public class Division_ { 

    public static volatile SingularAttribute<Division, Integer> id;
    public static volatile CollectionAttribute<Division, Assetbankuser> assetbankuserCollection;
    public static volatile SingularAttribute<Division, String> name;

}