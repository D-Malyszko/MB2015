package data;

import data.Asset;
import data.Assetentity;
import data.Fileformat;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Assettype.class)
public class Assettype_ { 

    public static volatile SingularAttribute<Assettype, Integer> id;
    public static volatile SingularAttribute<Assettype, String> name;
    public static volatile CollectionAttribute<Assettype, Assetentity> assetentityCollection;
    public static volatile CollectionAttribute<Assettype, Fileformat> fileformatCollection;
    public static volatile CollectionAttribute<Assettype, Asset> assetCollection;

}