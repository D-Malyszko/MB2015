package data;

import data.Attributetype;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Attributestoragetype.class)
public class Attributestoragetype_ { 

    public static volatile SingularAttribute<Attributestoragetype, Integer> id;
    public static volatile SingularAttribute<Attributestoragetype, String> name;
    public static volatile CollectionAttribute<Attributestoragetype, Attributetype> attributetypeCollection;

}