package data;

import data.Asset;
import data.Assetentity;
import data.CmCategory;
import data.CmCategorytype;
import data.Orgunit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(CmCategory.class)
public class CmCategory_ { 

    public static volatile SingularAttribute<CmCategory, String> summary;
    public static volatile SingularAttribute<CmCategory, CmCategorytype> categorytypeid;
    public static volatile SingularAttribute<CmCategory, Short> canassignifnotleaf;
    public static volatile SingularAttribute<CmCategory, Integer> sequencenumber;
    public static volatile SingularAttribute<CmCategory, Asset> extensionassetid;
    public static volatile SingularAttribute<CmCategory, Short> cannotbedeleted;
    public static volatile SingularAttribute<CmCategory, Short> isexpired;
    public static volatile SingularAttribute<CmCategory, Short> selectedonload;
    public static volatile CollectionAttribute<CmCategory, Assetentity> assetentityCollection;
    public static volatile SingularAttribute<CmCategory, CmCategory> parentid;
    public static volatile SingularAttribute<CmCategory, Short> islistboxcategory;
    public static volatile SingularAttribute<CmCategory, Short> isbrowsable;
    public static volatile SingularAttribute<CmCategory, String> workflowname;
    public static volatile SingularAttribute<CmCategory, String> viewtype;
    public static volatile SingularAttribute<CmCategory, Integer> id;
    public static volatile SingularAttribute<CmCategory, Short> showpromotedonbrowse;
    public static volatile SingularAttribute<CmCategory, Short> browseaspanels;
    public static volatile SingularAttribute<CmCategory, Short> isrestrictive;
    public static volatile CollectionAttribute<CmCategory, Orgunit> orgunitCollection1;
    public static volatile SingularAttribute<CmCategory, Short> allowadvancedoptions;
    public static volatile CollectionAttribute<CmCategory, CmCategory> cmCategoryCollection;
    public static volatile SingularAttribute<CmCategory, Short> showrecentonbrowse;
    public static volatile SingularAttribute<CmCategory, String> description;
    public static volatile SingularAttribute<CmCategory, String> name;
    public static volatile SingularAttribute<CmCategory, Integer> bitposition;
    public static volatile CollectionAttribute<CmCategory, Orgunit> orgunitCollection;

}