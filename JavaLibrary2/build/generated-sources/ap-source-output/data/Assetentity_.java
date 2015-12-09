package data;

import data.Asset;
import data.Assettype;
import data.Attribute;
import data.CmCategory;
import data.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Assetentity.class)
public class Assetentity_ { 

    public static volatile CollectionAttribute<Assetentity, Usergroup> usergroupCollection;
    public static volatile SingularAttribute<Assetentity, String> termforsibling;
    public static volatile SingularAttribute<Assetentity, Short> isquicksearchable;
    public static volatile SingularAttribute<Assetentity, Integer> sequencenumber;
    public static volatile SingularAttribute<Assetentity, String> includedfileformats;
    public static volatile SingularAttribute<Assetentity, Short> isarticle;
    public static volatile SingularAttribute<Assetentity, Short> musthaveparent;
    public static volatile SingularAttribute<Assetentity, Integer> unrestagreementid;
    public static volatile SingularAttribute<Assetentity, Short> onlyallowdefaultcategory;
    public static volatile SingularAttribute<Assetentity, Short> issearchable;
    public static volatile SingularAttribute<Assetentity, Integer> id;
    public static volatile SingularAttribute<Assetentity, Short> candownloadchildren;
    public static volatile SingularAttribute<Assetentity, Short> showattributelabels;
    public static volatile SingularAttribute<Assetentity, Short> cancopyassets;
    public static volatile SingularAttribute<Assetentity, String> name;
    public static volatile SingularAttribute<Assetentity, Integer> defaultcategoryid;
    public static volatile SingularAttribute<Assetentity, CmCategory> rootcategoryid;
    public static volatile SingularAttribute<Assetentity, Short> showondescendantcategories;
    public static volatile SingularAttribute<Assetentity, String> excludedfileformats;
    public static volatile SingularAttribute<Assetentity, Short> iscategoryextension;
    public static volatile SingularAttribute<Assetentity, String> thumbnailfilename;
    public static volatile CollectionAttribute<Assetentity, Asset> assetCollection;
    public static volatile SingularAttribute<Assetentity, Integer> restagreementid;
    public static volatile CollectionAttribute<Assetentity, Assettype> assettypeCollection;
    public static volatile SingularAttribute<Assetentity, Attribute> matchonattributeid;
    public static volatile SingularAttribute<Assetentity, String> termforsiblings;

}