package data;

import data.Assetbankuser;
import data.Assetentity;
import data.Brand;
import data.Menuitem;
import data.Orgunit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:51")
@StaticMetamodel(Usergroup.class)
public class Usergroup_ { 

    public static volatile SingularAttribute<Usergroup, Short> canaddemptyassets;
    public static volatile SingularAttribute<Usergroup, Integer> maxdownloadheight;
    public static volatile SingularAttribute<Usergroup, Short> canemailassets;
    public static volatile SingularAttribute<Usergroup, Integer> sequencenumber;
    public static volatile CollectionAttribute<Usergroup, Menuitem> menuitemCollection;
    public static volatile SingularAttribute<Usergroup, Integer> discountpercentage;
    public static volatile SingularAttribute<Usergroup, Brand> brandid;
    public static volatile SingularAttribute<Usergroup, String> mapping;
    public static volatile SingularAttribute<Usergroup, Short> canpublishassetbox;
    public static volatile CollectionAttribute<Usergroup, Assetentity> assetentityCollection;
    public static volatile SingularAttribute<Usergroup, Short> canviewlargersize;
    public static volatile SingularAttribute<Usergroup, Short> advancedviewing;
    public static volatile SingularAttribute<Usergroup, Integer> id;
    public static volatile CollectionAttribute<Usergroup, Orgunit> orgunitCollection1;
    public static volatile CollectionAttribute<Usergroup, Orgunit> orgunitCollection2;
    public static volatile SingularAttribute<Usergroup, Menuitem> homepagemenuitemidentifier;
    public static volatile SingularAttribute<Usergroup, String> description;
    public static volatile SingularAttribute<Usergroup, Short> canexportassets;
    public static volatile SingularAttribute<Usergroup, String> name;
    public static volatile SingularAttribute<Usergroup, Short> caninviteusers;
    public static volatile CollectionAttribute<Usergroup, Orgunit> orgunitCollection;
    public static volatile SingularAttribute<Usergroup, String> downloadlimitperiod;
    public static volatile SingularAttribute<Usergroup, Short> isdefaultgroup;
    public static volatile SingularAttribute<Usergroup, Short> automaticbrandregister;
    public static volatile SingularAttribute<Usergroup, Short> canselectonregistration;
    public static volatile SingularAttribute<Usergroup, Short> canseesourcepath;
    public static volatile SingularAttribute<Usergroup, Integer> downloadlimit;
    public static volatile SingularAttribute<Usergroup, Integer> maxdownloadwidth;
    public static volatile SingularAttribute<Usergroup, String> ipmapping;
    public static volatile SingularAttribute<Usergroup, Short> canrepurposeassets;
    public static volatile CollectionAttribute<Usergroup, Assetbankuser> assetbankuserCollection;
    public static volatile SingularAttribute<Usergroup, Short> canonlyeditown;
    public static volatile SingularAttribute<Usergroup, String> urlmapping;

}