package data;

import data.Usergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Menuitem.class)
public class Menuitem_ { 

    public static volatile CollectionAttribute<Menuitem, Usergroup> usergroupCollection;
    public static volatile CollectionAttribute<Menuitem, Usergroup> usergroupCollection1;
    public static volatile SingularAttribute<Menuitem, Short> isopenedinnewwindow;
    public static volatile SingularAttribute<Menuitem, Integer> sequencenumber;
    public static volatile SingularAttribute<Menuitem, String> itemcomment;
    public static volatile SingularAttribute<Menuitem, String> itemidentifier;
    public static volatile SingularAttribute<Menuitem, Short> ishidden;

}