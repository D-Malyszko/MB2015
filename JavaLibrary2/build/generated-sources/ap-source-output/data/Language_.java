package data;

import data.Assetbankuser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-10T21:13:02")
@StaticMetamodel(Language.class)
public class Language_ { 

    public static volatile SingularAttribute<Language, Integer> id;
    public static volatile SingularAttribute<Language, String> iconfilename;
    public static volatile SingularAttribute<Language, Short> useslatinalphabet;
    public static volatile CollectionAttribute<Language, Assetbankuser> assetbankuserCollection1;
    public static volatile SingularAttribute<Language, Short> isdefault;
    public static volatile CollectionAttribute<Language, Assetbankuser> assetbankuserCollection;
    public static volatile SingularAttribute<Language, String> name;
    public static volatile SingularAttribute<Language, Short> issuspended;
    public static volatile SingularAttribute<Language, String> code;
    public static volatile SingularAttribute<Language, String> nativename;
    public static volatile SingularAttribute<Language, Short> isrighttoleft;

}