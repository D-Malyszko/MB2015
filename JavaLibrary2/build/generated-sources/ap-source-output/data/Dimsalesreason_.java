package data;

import data.Factinternetsales;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Dimsalesreason.class)
public class Dimsalesreason_ { 

    public static volatile SingularAttribute<Dimsalesreason, Integer> salesreasonkey;
    public static volatile SingularAttribute<Dimsalesreason, String> salesreasonreasontype;
    public static volatile CollectionAttribute<Dimsalesreason, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimsalesreason, Integer> salesreasonalternatekey;
    public static volatile SingularAttribute<Dimsalesreason, String> salesreasonname;

}