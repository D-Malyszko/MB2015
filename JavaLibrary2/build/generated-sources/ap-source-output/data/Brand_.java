package data;

import data.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile SingularAttribute<Brand, Integer> id;
    public static volatile CollectionAttribute<Brand, Usergroup> usergroupCollection;
    public static volatile SingularAttribute<Brand, Integer> logowidth;
    public static volatile SingularAttribute<Brand, String> cssfile;
    public static volatile SingularAttribute<Brand, String> name;
    public static volatile SingularAttribute<Brand, String> code;
    public static volatile SingularAttribute<Brand, String> contentlistidentifier;
    public static volatile SingularAttribute<Brand, String> emaildomains;
    public static volatile SingularAttribute<Brand, String> logofile;
    public static volatile SingularAttribute<Brand, String> logoalt;
    public static volatile SingularAttribute<Brand, Integer> logoheight;

}