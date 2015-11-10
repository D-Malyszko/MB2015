package data;

import data.Dimproduct;
import data.Dimproductcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Dimproductsubcategory.class)
public class Dimproductsubcategory_ { 

    public static volatile SingularAttribute<Dimproductsubcategory, String> spanishproductsubcategoryname;
    public static volatile CollectionAttribute<Dimproductsubcategory, Dimproduct> dimproductCollection;
    public static volatile SingularAttribute<Dimproductsubcategory, String> frenchproductsubcategoryname;
    public static volatile SingularAttribute<Dimproductsubcategory, Dimproductcategory> productcategorykey;
    public static volatile SingularAttribute<Dimproductsubcategory, Integer> productsubcategoryalternatekey;
    public static volatile SingularAttribute<Dimproductsubcategory, Integer> productsubcategorykey;
    public static volatile SingularAttribute<Dimproductsubcategory, String> englishproductsubcategoryname;

}