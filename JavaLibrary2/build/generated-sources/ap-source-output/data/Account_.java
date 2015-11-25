package data;

import data.Customer;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, BigDecimal> balance;
    public static volatile SingularAttribute<Account, String> accountId;
    public static volatile CollectionAttribute<Account, Customer> customerCollection;
    public static volatile SingularAttribute<Account, String> description;
    public static volatile SingularAttribute<Account, BigDecimal> creditLine;
    public static volatile SingularAttribute<Account, Serializable> beginBalanceTimeStamp;
    public static volatile SingularAttribute<Account, String> type;
    public static volatile SingularAttribute<Account, BigDecimal> beginBalance;

}