package data;

import data.Assetbankuser;
import data.CmCategory;
import data.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Orgunit.class)
public class Orgunit_ { 

    public static volatile SingularAttribute<Orgunit, Integer> id;
    public static volatile SingularAttribute<Orgunit, Integer> diskquotamb;
    public static volatile CollectionAttribute<Orgunit, Usergroup> usergroupCollection;
    public static volatile SingularAttribute<Orgunit, Usergroup> admingroupid;
    public static volatile SingularAttribute<Orgunit, Usergroup> standardgroupid;
    public static volatile CollectionAttribute<Orgunit, Assetbankuser> assetbankuserCollection;
    public static volatile SingularAttribute<Orgunit, CmCategory> rootorgunitcategoryid;
    public static volatile SingularAttribute<Orgunit, CmCategory> rootdescriptivecategoryid;
    public static volatile SingularAttribute<Orgunit, String> notes;

}