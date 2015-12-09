package data;

import data.Dimemployee;
import data.Dimgeography;
import data.Factinternetsales;
import data.Factresellersales;
import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Dimsalesterritory.class)
public class Dimsalesterritory_ { 

    public static volatile SingularAttribute<Dimsalesterritory, Integer> salesterritorykey;
    public static volatile SingularAttribute<Dimsalesterritory, Integer> salesterritoryalternatekey;
    public static volatile SingularAttribute<Dimsalesterritory, Serializable> salesterritoryimage;
    public static volatile SingularAttribute<Dimsalesterritory, String> salesterritoryregion;
    public static volatile CollectionAttribute<Dimsalesterritory, Factinternetsales> factinternetsalesCollection;
    public static volatile SingularAttribute<Dimsalesterritory, String> salesterritorycountry;
    public static volatile CollectionAttribute<Dimsalesterritory, Dimemployee> dimemployeeCollection;
    public static volatile SingularAttribute<Dimsalesterritory, String> salesterritorygroup;
    public static volatile CollectionAttribute<Dimsalesterritory, Factresellersales> factresellersalesCollection;
    public static volatile CollectionAttribute<Dimsalesterritory, Dimgeography> dimgeographyCollection;

}