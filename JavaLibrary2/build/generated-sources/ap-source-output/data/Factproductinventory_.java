package data;

import data.Dimdate;
import data.Dimproduct;
import data.FactproductinventoryPK;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Factproductinventory.class)
public class Factproductinventory_ { 

    public static volatile SingularAttribute<Factproductinventory, Integer> unitsout;
    public static volatile SingularAttribute<Factproductinventory, Dimdate> dimdate;
    public static volatile SingularAttribute<Factproductinventory, Integer> unitsbalance;
    public static volatile SingularAttribute<Factproductinventory, BigDecimal> unitcost;
    public static volatile SingularAttribute<Factproductinventory, Dimproduct> dimproduct;
    public static volatile SingularAttribute<Factproductinventory, Integer> unitsin;
    public static volatile SingularAttribute<Factproductinventory, FactproductinventoryPK> factproductinventoryPK;
    public static volatile SingularAttribute<Factproductinventory, Date> movementdate;

}