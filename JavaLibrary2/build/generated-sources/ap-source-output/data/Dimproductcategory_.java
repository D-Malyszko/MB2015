package data;

import data.Dimproductsubcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:01")
@StaticMetamodel(Dimproductcategory.class)
public class Dimproductcategory_ { 

    public static volatile SingularAttribute<Dimproductcategory, Integer> productcategorykey;
    public static volatile SingularAttribute<Dimproductcategory, Integer> productcategoryalternatekey;
    public static volatile CollectionAttribute<Dimproductcategory, Dimproductsubcategory> dimproductsubcategoryCollection;
    public static volatile SingularAttribute<Dimproductcategory, String> englishproductcategoryname;
    public static volatile SingularAttribute<Dimproductcategory, String> frenchproductcategoryname;
    public static volatile SingularAttribute<Dimproductcategory, String> spanishproductcategoryname;

}