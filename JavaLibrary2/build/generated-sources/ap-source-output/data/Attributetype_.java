package data;

import data.Attribute;
import data.Attributestoragetype;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Attributetype.class)
public class Attributetype_ { 

    public static volatile SingularAttribute<Attributetype, Integer> id;
    public static volatile CollectionAttribute<Attributetype, Attribute> attributeCollection;
    public static volatile SingularAttribute<Attributetype, Integer> sequencenumber;
    public static volatile SingularAttribute<Attributetype, String> name;
    public static volatile SingularAttribute<Attributetype, Attributestoragetype> attributestoragetypeid;

}