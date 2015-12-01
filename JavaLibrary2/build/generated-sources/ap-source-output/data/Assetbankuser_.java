package data;

import data.Address;
import data.Asset;
import data.Assetbankuser;
import data.Division;
import data.Language;
import data.Orgunit;
import data.Usergroup;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:50")
@StaticMetamodel(Assetbankuser.class)
public class Assetbankuser_ { 

    public static volatile CollectionAttribute<Assetbankuser, Usergroup> usergroupCollection;
    public static volatile SingularAttribute<Assetbankuser, Assetbankuser> invitedbyuserid;
    public static volatile SingularAttribute<Assetbankuser, String> surname;
    public static volatile SingularAttribute<Assetbankuser, Short> notactivedirectory;
    public static volatile SingularAttribute<Assetbankuser, String> password;
    public static volatile SingularAttribute<Assetbankuser, Short> contentalertsubscriber;
    public static volatile SingularAttribute<Assetbankuser, String> username;
    public static volatile SingularAttribute<Assetbankuser, String> emailaddress;
    public static volatile SingularAttribute<Assetbankuser, Short> isdeleted;
    public static volatile SingularAttribute<Assetbankuser, String> adminnotes;
    public static volatile SingularAttribute<Assetbankuser, Short> homepageaccesslevelsexpanded;
    public static volatile SingularAttribute<Assetbankuser, String> registrationinfo;
    public static volatile SingularAttribute<Assetbankuser, String> forename;
    public static volatile CollectionAttribute<Assetbankuser, Language> languageCollection;
    public static volatile SingularAttribute<Assetbankuser, String> vatnumber;
    public static volatile CollectionAttribute<Assetbankuser, Asset> assetCollection2;
    public static volatile CollectionAttribute<Assetbankuser, Asset> assetCollection3;
    public static volatile CollectionAttribute<Assetbankuser, Asset> assetCollection1;
    public static volatile CollectionAttribute<Assetbankuser, Asset> assetCollection;
    public static volatile SingularAttribute<Assetbankuser, Date> datelastmodified;
    public static volatile SingularAttribute<Assetbankuser, String> distinguishedname;
    public static volatile SingularAttribute<Assetbankuser, Date> registerdate;
    public static volatile CollectionAttribute<Assetbankuser, Assetbankuser> assetbankuserCollection;
    public static volatile SingularAttribute<Assetbankuser, String> cn;
    public static volatile SingularAttribute<Assetbankuser, Short> requestfulfiller;
    public static volatile SingularAttribute<Assetbankuser, Short> issuspended;
    public static volatile SingularAttribute<Assetbankuser, Short> canloginfromcms;
    public static volatile SingularAttribute<Assetbankuser, Short> requiresupdate;
    public static volatile SingularAttribute<Assetbankuser, Assetbankuser> lastmodifiedbyid;
    public static volatile SingularAttribute<Assetbankuser, Short> isadmin;
    public static volatile SingularAttribute<Assetbankuser, Division> divisionid;
    public static volatile SingularAttribute<Assetbankuser, Short> receivealerts;
    public static volatile SingularAttribute<Assetbankuser, Date> datechangedpassword;
    public static volatile SingularAttribute<Assetbankuser, Date> expirydate;
    public static volatile SingularAttribute<Assetbankuser, String> mailbox;
    public static volatile SingularAttribute<Assetbankuser, Integer> id;
    public static volatile SingularAttribute<Assetbankuser, String> jobtitle;
    public static volatile CollectionAttribute<Assetbankuser, Assetbankuser> assetbankuserCollection1;
    public static volatile SingularAttribute<Assetbankuser, String> title;
    public static volatile SingularAttribute<Assetbankuser, Short> ldapserverindex;
    public static volatile SingularAttribute<Assetbankuser, Language> languageid;
    public static volatile SingularAttribute<Assetbankuser, Short> canbecategoryadmin;
    public static volatile SingularAttribute<Assetbankuser, String> additionalapprovalname;
    public static volatile SingularAttribute<Assetbankuser, Address> addressid;
    public static volatile SingularAttribute<Assetbankuser, Short> haseverloggedin;
    public static volatile SingularAttribute<Assetbankuser, Short> reactivationpending;
    public static volatile SingularAttribute<Assetbankuser, Short> notapproved;
    public static volatile SingularAttribute<Assetbankuser, String> organisation;
    public static volatile SingularAttribute<Assetbankuser, Integer> searchresultsperpage;
    public static volatile SingularAttribute<Assetbankuser, Orgunit> requestedorgunitid;
    public static volatile SingularAttribute<Assetbankuser, Short> homepagecategoriesexpanded;
    public static volatile SingularAttribute<Assetbankuser, String> address;
    public static volatile SingularAttribute<Assetbankuser, Date> datelastloggedin;
    public static volatile SingularAttribute<Assetbankuser, Short> hidden;
    public static volatile SingularAttribute<Assetbankuser, String> displayname;

}