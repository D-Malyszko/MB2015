package data;

import data.Dimdepartmentgroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Dimdepartmentgroup.class)
public class Dimdepartmentgroup_ { 

    public static volatile SingularAttribute<Dimdepartmentgroup, Dimdepartmentgroup> parentdepartmentgroupkey;
    public static volatile SingularAttribute<Dimdepartmentgroup, String> departmentgroupname;
    public static volatile SingularAttribute<Dimdepartmentgroup, Integer> departmentgroupkey;
    public static volatile CollectionAttribute<Dimdepartmentgroup, Dimdepartmentgroup> dimdepartmentgroupCollection;

}