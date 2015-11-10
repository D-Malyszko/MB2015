package data;

import data.CmCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(CmCategorytype.class)
public class CmCategorytype_ { 

    public static volatile SingularAttribute<CmCategorytype, Integer> id;
    public static volatile CollectionAttribute<CmCategorytype, CmCategory> cmCategoryCollection;
    public static volatile SingularAttribute<CmCategorytype, String> description;
    public static volatile SingularAttribute<CmCategorytype, Short> isnamegloballyunique;
    public static volatile SingularAttribute<CmCategorytype, Short> isalphabeticorder;

}